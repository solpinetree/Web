package com.lec.beans;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class WriteDTO {
	 private int uid;   // wr_uid
	 private String subject;  // wr_subject
	 private String content;  // wr_content
	 private String name;     // wr_name
	 private int viewCnt;     // wr_viewcnt
	 private LocalDateTime regDate;  //wr_regdate
	 
	// 웹개발시...
	// 가능한, 다음 3가지는 이름을 일치시켜주는게 좋습니다.
	// 클래스 필드명 = DB 필드명 = form의 name명
	 
	// 기본생성자
	 public WriteDTO() {}
	 
	 // 매개변수 받는 생성자
	 
	 public WriteDTO(int uid, String subject, String content, String name, int viewCnt, LocalDateTime regDate) {
		 super();
		 this.uid = uid;
		 this.subject = subject;
		 this.content = content;
		 this.name = name;
		 this.viewCnt = viewCnt;
		 this.regDate = regDate;
	 }
	 
	 

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getViewCnt() {
		return viewCnt;
	}

	public void setViewCnt(int viewCnt) {
		this.viewCnt = viewCnt;
	}

	public LocalDateTime getRegDate() {
		return regDate;
	}

	public void setRegDate(LocalDateTime regDate) {
		this.regDate = regDate;
	}
	 

	// regDate 를 String 으로 리턴하는 getter
	public String getRegDateTime() {
		if(this.regDate == null) return "";
		return this.regDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss"));
	}
	
	@Override
	public String toString() {
		return String.format("WriteDTO] %d : %s : %s : %s : %d : %s", 
				uid, subject, content, name, viewCnt, regDate);
	}
	 
}


















