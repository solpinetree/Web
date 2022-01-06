package com.lec.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Bt01HelloApplication {

	public static void main(String[] args) {
		SpringApplication.run(Bt01HelloApplication.class, args);
		System.out.println("Hello SpringBoot");
	}

}
