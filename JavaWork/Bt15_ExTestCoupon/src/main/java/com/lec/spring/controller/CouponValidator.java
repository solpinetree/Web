package com.lec.spring.controller;

import java.util.regex.Pattern;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.lec.spring.domain.WriteDTO;


// 이 Validator 는 Controller 에 등록되어 동작하게 된다.
public class CouponValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return WriteDTO.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		WriteDTO dto = (WriteDTO) target;
//		int cp_uid = dto.getCp_uid();
		String cp_name = dto.getCp_name();
		String cp_kind = dto.getCp_kind();
		String cp_sno = dto.getCp_sno();
		if(cp_name == null || cp_name.trim().isEmpty()) {
			errors.rejectValue("cp_name", "null or empty cp_name value");
		}
		if(cp_sno == null || cp_sno.trim().isEmpty()) {
			errors.rejectValue("cp_sno", "null or empty cp_sno value");
		}else {
			String pattern= "^[a-zA-Z0-9]{4}+-[a-zA-Z0-9]{2}+-[a-zA-Z0-9]{2}$";
			if(!Pattern.matches(pattern, cp_sno)) {
				errors.rejectValue("cp_sno", "no matching data for cp_sno" );
			}
		}
	}
	
}
