package com.lec.spring.domain;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;

class UserTest {

	@Test
	void test() {
		User user1 = new User();
		user1.setCreatedAt(LocalDateTime.now());
		user1.setCreatedAt(LocalDateTime.now());
		user1.setName("john");
		user1.setEmail("jj@mail.com");
		
		User user2 = User.builder()
				.name("홍길동")
				.email("hong@naver.com")
				.build()
				;
		
		System.out.println(user2);
	}

}
