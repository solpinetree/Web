package com.lec.spring.di06;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

@Controller
public class BoardController {
	
	@Autowired
	@Qualifier("update")
	DoService service;
	
	public BoardController() {
		System.out.println("BoardController() 생성: " + service);
	}
	
	public void doService() {
		System.out.println(service);
	}
}
