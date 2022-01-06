package com.lec.spring.controller;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.lec.spring.domain.WriteDTO;


// 이 Validator 는 Controller 에 등록되어 동작하게 된다.
public class BoardValidator implements Validator {

	// 이 Validator가 제공된 Class 의 인스턴스(class) 를 유효성 검사 할 수 있는가?
	@Override
	public boolean supports(Class<?> clazz) {
		System.out.println("supports(" + clazz.getName()+")");
		// ↓ 검증할 객체의 클래스 타입인지 확인 : WriteDTO = clazz; 가능 여부 
		return WriteDTO.class.isAssignableFrom(clazz);
	}

	// 주어진 객체(target)에 유효성검사를 하고 
	// 유효성검사에 오류가 있는 경우 주어진 객체에 이 오류들을 errors 에 등록 한다.
	// 아래 validate() 는 Spring 이 기본적인 binding이 수행한 이후에 호출된다.
	// 따라서, errors 에는 Spring이 수행한 binding 에러 들이 이미 담겨 있고
	// target 에는 binding 이 완료한 커맨드 객체가 전달된다.	
	@Override
	public void validate(Object target, Errors errors) {
		System.out.println("validate()");
		WriteDTO dto = (WriteDTO)target;
		
		Integer uid = dto.getUid();
		if(uid == null) {	// binding 이 실패하면 null 로 남아있을 것이다. 
			System.out.println("uid 오류");
			
			// 에러 등록 rejectValue(field, errorCode)
			errors.rejectValue("uid", "invalidUid");	// 필드명은 반드시 dto 의 필드명으로!
		}
		
		String name = dto.getName();
		if(name==null||name.trim().isEmpty()) {
			System.out.println("name 오류 : 반드시 한 글자라도 입력해야 합니다");
			errors.rejectValue("name", "emptyName");
		}
		
	}

	
	
}
