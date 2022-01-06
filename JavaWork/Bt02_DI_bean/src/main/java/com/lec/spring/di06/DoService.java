package com.lec.spring.di06;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.Data;

/*
 * 참고로.  우리가 JSP Model2 에서 Command 라 배웠던 객체를
 * SpringMVC 에선 Service 단이라고도 한다.
 */

public interface DoService {}

@Service
@Data
class RegisterService implements DoService{
	
	DAO dao;

	// 기본생성자는 없다.
	
	// 생성자는 하나. DAO 자동주입 받는다.
	public RegisterService(DAO dao) {
		super();
		System.out.printf("RegisterService(%s) 생성\n", dao);
		this.dao = dao;
	}
}


@Service
@Data
class ReadService implements DoService{
	DAO dao;
	
	public ReadService() {
		System.out.println("ReadService() 생성");
	}
	
	@Autowired
	public ReadService(DAO dao) {
		System.out.printf("ReadService(%s) 생성\n", dao);
		this.dao = dao;
	}
}


@Service("update")	// command = service 
@Data
class UpdateService implements DoService{
	
	@Autowired
	DAO dao;
	
	public UpdateService() {
		System.out.println("UpdateService() 생성: " + dao);
	}
	
}