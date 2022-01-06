package com.lec.spring.di06;

import lombok.Data;

public interface DAO {}

@Data
class DAOImpl implements DAO{
	
	String uid;
	
	public DAOImpl() {
		super();
		System.out.println("DAOImpl() 생성");
	}

	public DAOImpl(String uid) {
		super();
		System.out.printf("DAOImpl(%s) 생성\n", uid);
		this.uid = uid;
	}

	
}