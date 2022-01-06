package com.lec.spring.di01;

import com.lec.spring.beans.MessageBean;

public class DIMain01 {

	// 이 클래스는 MessageBean 에 '의존'하는 개체
	private MessageBean msg;
	
	public static void main(String[] args) {
		System.out.println("Main 시작");
		
		DIMain01 app = new DIMain01();
		app.test();
		
		System.out.println("Main 종료");
	}

	public void test() {
		//	필요한 MessageBean 객체를
//		msg = new MessageKor();	//	직접 만들어(new) 사용
// 		msg.sayHello();
		
		// 나중에 설계 변경등이 발생되어 업데이트 하려면? 
		msg = new MessageEng();
		msg.sayHello();
	}

}
