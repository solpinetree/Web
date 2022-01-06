package com.lec.spring.domain;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;


// VO : Volume Object <-- DTO와 거의 동일
//		read only 속성(immutable), 원래는 setter가 있으면 안됨

@Data
@AllArgsConstructor
public class MemberVO {
	private int no;
	private String  id;
	private String pw;
	private String name;
	private LocalDateTime regdate;
}
