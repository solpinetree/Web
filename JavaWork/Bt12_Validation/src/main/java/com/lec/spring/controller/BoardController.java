package com.lec.spring.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.lec.spring.domain.WriteDTO;

@Controller
@RequestMapping("/board")
public class BoardController {

	@RequestMapping("write")	// /board/write
	public void write() {}
	
	@RequestMapping("writeOk")
	public String writeOk(@ModelAttribute("w") @Valid WriteDTO dto,
			BindingResult result	// <- validator 가 유효성 검사를 한 결과를 담은 객체
			, Model model	// BindingResult 보다 Model 을 뒤에 두어야 한다!
			, RedirectAttributes redirectAttrs
		) {
		System.out.println("writeOk()"+ dto.getUid()+":"+dto.getName());
//		System.out.println("에러의 개수: "+ result.getErrorCount());	// 담긴 결과의 개수(에러의 개수)
//		System.out.println("validate() 전");showErrors(result);
		String page = "board/writeOk";
		
		// Validator 생성	 및 validation 수행
//		Validator validator = new BoardValidator();
//		validator.validate(dto, result);
		
		System.out.println("validate() 후");showErrors(result);
		if(result.hasErrors()) {	// 에러 있으면
			redirectAttrs.addFlashAttribute("w",dto);	// 원래 입력한 값 돌려주기
			
			if(result.getFieldError("uid")!= null)
				redirectAttrs.addFlashAttribute("errUid","uid 값은 0보다 큰 정수이어야 합니다.");
			if(result.getFieldError("name")!= null)
				redirectAttrs.addFlashAttribute("errName","name 은 필수입니다.");
			
			page = "redirect:/board/write";	// 원래 폼으로 돌아가기
		}
		return page;
	}
	
	// 에러 출력 도우미 메소드
	public void showErrors(Errors errors) {
		if(errors.hasErrors()) {
			System.out.println("에러 개수: " + errors.getErrorCount());// 담긴 결과의 개수(에러의 개수)
			System.out.println("\t[field]\t|[code] ");
			List<FieldError> errList = errors.getFieldErrors();
			
			for(FieldError err: errList) {
				System.out.println("\t"+ err.getField() + "\t|" + err.getCode());
			}
		}else {
			System.out.println("에러 없음");
		}
	}
	
	// 이 컨트롤러에서 의 handler 에서 폼 데이터를 바인딩할 때 검증하는 객체 지정
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.setValidator(new BoardValidator());
		
		// validator 추가하기
		// binder.addValidators(null);
	}
}
