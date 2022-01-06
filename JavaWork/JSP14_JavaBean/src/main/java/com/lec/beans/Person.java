package com.lec.beans;

public class Person {
	// 필드
	private String name;
	private int age;
	private int id;
	private String gender;
	
	// 생성자
	public Person() {
		System.out.println("Person() 생성");
	}
	
	// getter / setter
	public String getName() {
		System.out.println("getName() 호출");
		return name;
	}

	public void setName(String name) {
		System.out.println("setName(" + name + ") 호출");
		this.name = name;
	}
	
	public void setname(String name) {
		System.out.println("setname(" + name + ") 호출");
		this.name = name;
	}

	public int getAge() {
		System.out.println("getAge() 호출");
		return age;
	}

	public void setAge(int age) {
		System.out.println("setAge(" + age + ") 호출");
		this.age = age;
	}

	public int getId() {
		System.out.println("getId() 호출");
		return id;
	}

	public void setId(int id) {
		System.out.println("setId(" + id + ") 호출");
		this.id = id;
	}

	public String getGender() {
		System.out.println("getGender() 호출");
		return gender;
	}

	public void setGender(String gender) {
		System.out.println("setGender(" + gender + ") 호출");
		this.gender = gender;
	}




}
