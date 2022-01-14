package com.lec.spring.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lec.spring.domain.UserDTO;
import com.lec.spring.service.UserService;

@Controller
public class IndexController {

	@Autowired
	UserService userService;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	
	@RequestMapping({"", "/"})
	@ResponseBody
	public String sayHello() {
		return "<h2>/ : Hello</h2>";
	}
	
	// Spring Security(이하 '시큐리티') 가 적용되면
	// /login 등의 url 로의 request 를  시큐리티가 모두 낚아 챕니다.
	// ※ 나중에 SecurityConfig 가 설정되면 낚아 채지 않게 된다.
	@GetMapping("/login")
//	@ResponseBody
	public String login(HttpServletRequest request) {
		System.out.println("GET: /login");
//		return "<h2>/login : login 페이지</h2>";
		
		// 로그인 직전의 url 을 Session 에 기록
		String referer = request.getHeader("Referer");
		if(referer != null)
			request.getSession().setAttribute("url_prior_login", referer);
		
		return "loginForm";
	}
	
	@PostMapping("/login")
	public String loginFail() {
		System.out.println("POST: /login");
		return "loginForm";
	}
	
	// 현재로그인한 정보 Authentication 보기
	@RequestMapping("/auth")
	@ResponseBody
	public Authentication auth(HttpSession session) {
		return SecurityContextHolder.getContext().getAuthentication();
	}
	
	@GetMapping("/join")
	public String join() {
		return "joinForm";
	}
	
	@PostMapping("/joinOk")
	public String joinOk(UserDTO user) {
		System.out.println("/joinOk: " + user);
		
		// password 는 암호화 하여 저장
		String rawPassword = user.getPw();
		String encPassword = passwordEncoder.encode(rawPassword);
		user.setPw(encPassword);
		
		int cnt = userService.addMember(user);
		
		return "redirect:/login";		
	}
	
	@RequestMapping("/accessError")
	public void accessError() {}
	
}








































