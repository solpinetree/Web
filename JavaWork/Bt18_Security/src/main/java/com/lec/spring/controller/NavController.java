package com.lec.spring.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/nav")
public class NavController {

	@GetMapping("")
	public String navform(HttpServletRequest request) {
		
		request.getSession().setAttribute("url_prior_login", request.getRequestURL().toString());
		
		return "nav/navform";
	}
	
}
