package com.lec.spring.di05;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import com.lec.spring.beans.Score;
import com.lec.spring.beans.Student;

@Configuration
public class Config05 {

	public Config05() {
		System.out.println("Config05() 생성");
	}
	
	@Bean
	public Score scoreA() {
		return new Score(77,55,89,"괜찮아요");
	}
	
	@Bean
	@Primary // 동일 타입의 bean 이 여러개 있을 때 autowired 되는 우선순위
	public Student stu1() {
		return new Student("박쭈", 19, scoreA());
	}
	
	@Bean(name = "Hong")
	public Student stu2() {
		return new Student("길동", 25, scoreA());
	}
	
	@Bean(name = "Choi")
	public Student stu3() {
		return new Student("최진섭", 25, scoreA());
	}
}
