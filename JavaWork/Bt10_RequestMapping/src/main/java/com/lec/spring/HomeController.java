package com.lec.spring;

import java.time.LocalDateTime;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

	public HomeController() {
		System.out.println("HomeController() 생성");
	}
	
	@RequestMapping("/")
	public String now(Model model) {
		LocalDateTime t = LocalDateTime.now();
		model.addAttribute("serverTime", t);
		return "home";	// "/WEB-INF/views/home.jsp" 으로 forwarding
	}
	
	// URL -> Handler mapping
	// url, handler 이름, 뷰 이름 <- 꼭 같을 필요는 없다. (그러나, 일반적으로 같거나 동일한 맥락으로 작명) 
	@RequestMapping("/common")
	public String cccmmm() {	//	핸들러 이름은 중요하진 않다.
		return "comn";
	}
	
	@RequestMapping(value = "/member/search")
	public String searchMember() {
		return "member/search";	// --> /WEB-INF/views/   (prefix를 properties에 명시해줬음)
	}
	
	@RequestMapping("/member/infoView")
	public String infoMember(Model model) {
		model.addAttribute("mbAge",30);
		model.addAttribute("mbName", "홍길이");
		return "member/info";
	}
	
	@RequestMapping("/member/find")
	public ModelAndView findMember() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("mbName", "원피스");
		mv.addObject("mbDate", "2021/11/25");
		mv.setViewName("member/find");
		return mv;
	}
	
	// 확장자 패턴 사용 가능
	@RequestMapping("/member/*/*/*.do")
	public String doMember() {
		return "member/doMember";
	}
	
}
