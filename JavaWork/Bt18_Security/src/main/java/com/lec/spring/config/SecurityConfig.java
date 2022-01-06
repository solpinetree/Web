 package com.lec.spring.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

// 스프링 시큐리티 설정
@Configuration	// 컨테이너에 빈 으로 생성되어야 한다.
@EnableWebSecurity	// Web Security 활성화
			// 아래 스프링 시큐리티 필터가 스프링 필터 체인에 등록된다.

			// SecurityCongif => 등록할 필터 객체 
public class SecurityConfig extends WebSecurityConfigurerAdapter{

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable();   	// CSRF 비활성화
		
		// TODO: 설정
		// 스프링 시큐리티에 대한 설정들이 이 안에서 메소드 체이닝으로 설정된다. 
		// 모든 건 http로 시작
		
		http
			// 1. request URL에 대한 접근 권한 세팅
			.authorizeRequests()	// 인가 -> 권한을 부여
			
			// /sample/user/** 주소로 들어오는 요청은 인증이 필요.
			.antMatchers("/sample/user/**").authenticated()
			
			// /sample/member/** 주소로 들어오는 요청은 '인증' 뿐 아니라 ROLE_MEMBER 나 ROLE_ADMIN 권한을 갖고 있어야 한다('인가')
			.antMatchers("/sample/member/**").access("hasRole('ROLE_MEMBER') or hasRole('ROLE_ADMIN')")
			
			// /sample/admin/** 주소로 들어오는 요청은 '인증' 뿐 아니라 ROLE_ADMIN 권한을 갖고 있어야 한다('인가')
			.antMatchers("/sample/admin/**").access("hasRole('ROLE_ADMIN')")
			
			// TODO
			// 그 밖의 다른 요청은 모두 permit!
			.anyRequest().permitAll()
			
			
			
			.and()		// 다시, HttpSecurity 객체 리턴. 다른 세팅 전환시 중간에 호출
			
			
			// 2. 로그인 세팅
			.formLogin()	// form 기반 인증 페이지 활성화. 만약 .loginPage(url)가 세팅되어 있지 않으면 '디폴트 로그인' form 페이지가 활성화
			.loginPage("/login")	// 로그인 필요한 상황 발생시 매개변수의 URL(로그인 폼) 로 Request 발생
			// 로그인 처리'
			.loginProcessingUrl("/loginOk")	// "/loginOk" url로 POST request가 들어오면 시큐리티가 낚아채서 처리, 대신 로그인을 진행해준다.
											// 이와 같이 하면 Controller에서 /loginOk를 만들지 않아도 된다!
			.defaultSuccessUrl("/")	// 직접 /login -> /loginOk에서 성공하면 "/" 로 이동시키기
									// 만약 다른 특정페이지에 진입하려다 로그인 하여 성공하면 해당 페이지로 이동(너무 편리!)
			
			
			;
	}	// end configure
}	// end SecurityConfig
