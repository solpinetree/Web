package com.lec.spring.di05;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.lec.spring.beans.Student;

/*
 * Autowired (자동주입) 는 세군데 발생
 * - 생성자  (constructor injection)
 * - 멤버변수 (field injection)
 * - setter (setter injection)
 */


@SpringBootApplication
public class DIMain05 implements CommandLineRunner{

	Student stu1;
	Student stu2;
	
	// Sprig 4.3 <= 부터는 
	// 생성자가 '하나만' 있는 경우 생성자 @Autowired 생략가능
	
	// ↓ 생성자 복수개 이고 default constructor 없고,  생성자 autowired  도 없으면 에러
	public DIMain05(Student stu) {
		System.out.println("DIMain05(" + stu + ") 생성");
		this.stu1 = stu;
		this.stu2 = stu;
	}
	
	
	// 기본적으로 자동주입(autowired) 는
	// 1. 같은 타입의  bean 이 주입
	// 2. 같은 타입이 여러개 이면, name 이 같거나 (혹은 유사) 한것이 주입
	// 3. @Qualifier, @Primary 등으로 특정 이름의 bean 주입

	@Autowired
	public DIMain05(@Qualifier("Choi") Student stu1, Student stu2) {
		System.out.println("DIMain05(Student, Student) 생성");
		this.stu1 = stu1;
		this.stu2 = stu2;
	}
	
	
	public static void main(String[] args) {
		System.out.println("Main 시작");
		SpringApplication.run(DIMain05.class, args);
		System.out.println("Main 종료");
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println(stu1);
		System.out.println(stu2);
	}
}
