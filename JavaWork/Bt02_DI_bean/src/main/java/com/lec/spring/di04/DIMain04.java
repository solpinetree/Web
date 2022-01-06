package com.lec.spring.di04;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.lec.spring.beans.MessageBean;
import com.lec.spring.beans.Score;

//동일 타입 빈이 컨테이너 안에 여러개 생성된 경우

/*
* Bean  에 이름을 지정하는 방법
* 1) 이름을 명시하지 않는 경우
* @Component: 소문자로 시작하는 클래스이름이 자동으로 사용됨.
* @Bean: 소문자로 시작하는 메서드이름이 자동으로 사용됨.
* 
* 2) 이름을 명시하는 경우
* @Component: @Component("이름") 으로 이름 명시
* @Bean: @Bean(name="이름") 으로 이름 명시
*/

//@SpringBootApplication
public class DIMain04 implements CommandLineRunner{
	
	@Autowired
	@Qualifier("score1")
	Score scoreA;
	
	@Autowired
	@Qualifier("score2")
	Score scoreB;

	MessageBean msg1;
	MessageBean msg2;

	@Autowired
	@Qualifier("KOR")	// 컨테이너 안에서 "KOR" 이라는 name의 bean을 자동 주입
	public void setMsg1(MessageBean msg1) {
		this.msg1 = msg1;
	}

	@Autowired
	@Qualifier("ENG")
	public void setMsg2(MessageBean msg2) {
		this.msg2 = msg2;
	}	
	
	public static void main(String[] args) {
		System.out.println("Main 시작");
		SpringApplication.run(DIMain04.class, args);

		System.out.println("Main 종료");
	}
	
	@Override
	public void run(String... args) throws Exception {
		msg1.sayHello();
		msg2.sayHello();
		
		System.out.println(scoreA);
		System.out.println(scoreB);
	}

}
