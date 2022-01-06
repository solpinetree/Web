package com.lec.spring.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.lec.spring.domain.WriteDTO;
import com.lec.spring.service.CouponService;

@Controller
@RequestMapping("/coupon")
public class CouponController {

	private CouponService couponService;

	@Autowired
	public void setBoardService(CouponService couponService) {
		this.couponService = couponService;
	}

	public CouponController() {
		System.out.println("CouponController() 생성");
	}

	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		binder.setValidator(new CouponValidator());
	}

	/*
	 * 
	 * GET 방식
	 * */

	@RequestMapping("/write")
	public void write() {
	} // /board/write.html

	@RequestMapping("/list")
	public void list(Model model) {
		model.addAttribute("list", couponService.list());
	}

	@GetMapping("/view")
	public void view(int uid, Model model) {
		model.addAttribute("list", couponService.viewByUid(uid));
	}
	
	@GetMapping("/update")
	public void update(int uid, Model model) {
		model.addAttribute("list", couponService.selectByUid(uid));
	}

	@GetMapping("/deleteOk")
	public void deleteOk(int uid, Model model) {
		model.addAttribute("result", couponService.deleteByUid(uid));
	}

	/*
	 * Post mapping
	 * */
	@PostMapping("/writeOk")
	public String writeOk(@ModelAttribute("dto") @Valid WriteDTO dto
			, BindingResult result
			, Model model
			, RedirectAttributes redirectAttrs) {
		String page;
		
		if(result.hasErrors()) {
			redirectAttrs.addFlashAttribute("dto", dto);	// 원래 입력한 값 돌려주기
			
	        if(result.getFieldError("cp_name")!=null)
	        	redirectAttrs.addFlashAttribute("errName", "name은 필수입니다.");
	        if(result.getFieldError("cp_sno")!=null)
	        	redirectAttrs.addFlashAttribute("errSno", "일련번호의 형식은 ####-##-## 형식이며 #에는 알파벳, 숫자의 조합입니다.");
	        page="redirect:write";
		}else {
			int cnt = couponService.write(dto);
			model.addAttribute("result", cnt);
			model.addAttribute("dto", dto);
			page = "writeOk";
		}
		return page;
	}

	@PostMapping("/updateOk")
	public String updateOk(@ModelAttribute("dto") @Valid WriteDTO dto
			, BindingResult result
			, Model model
			, RedirectAttributes redirectAttrs) {
		String page;
		
		if(result.hasErrors()) {
			redirectAttrs.addFlashAttribute("dto", dto);	// 원래 입력한 값 돌려주기
			
	        if(result.getFieldError("cp_name")!=null)
	        	redirectAttrs.addFlashAttribute("errName", "name은 필수입니다.");
	        if(result.getFieldError("cp_sno")!=null)
	        	redirectAttrs.addFlashAttribute("errSno", "일련번호의 형식은 ####-##-## 형식이며 #에는 알파벳, 숫자의 조합입니다.");
	        page="redirect:update";
		}else {
			int cnt = couponService.update(dto);
			model.addAttribute("result", cnt);
			model.addAttribute("dto", dto);
			page = "updateOk";
		}
		return page;
	}


} // end controller
