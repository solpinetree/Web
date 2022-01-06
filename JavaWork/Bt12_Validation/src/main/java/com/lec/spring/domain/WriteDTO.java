package com.lec.spring.domain;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class WriteDTO {
	private Integer uid;	// wr_uid
	private String subject;	// wr_subject
	private String content;	// wr_content
	private String name;	// wr_name
	private int viewCnt;	//wr_viewcnt
	private LocalDateTime regDate;	// wr_regdate
	
	// 웹개발시 ... 
	// 가능한, 다음 3가지는 이름을 일치시켜주는 게 좋습니다. 
	// 클래스 필드명 = DB 필드명 = form의 name 명
	
	public WriteDTO() {
		super();
		System.out.println("WriteDTO() 객체 생성");
	}

	public WriteDTO(Integer uid, String subject, String content, String name, int viewCnt, LocalDateTime regDate) {
		super();
		this.uid = uid;
		this.subject = subject;
		this.content = content;
		this.name = name;
		this.viewCnt = viewCnt;
		this.regDate = regDate;
		System.out.println("WriteDTO(...) 객체 생성");
	}
	
}
