package com.lec.spring.beans;

import lombok.Data;

//@Data  // getter, setter, toString, equals, hashCode ..
//@Getter   // getter
//@Setter   // setter
//@ToString  // toString()
//@NoArgsConstructor  // 기본생성자
//@AllArgsConstructor  // 모든 필드 생성자
//@RequiredArgsConstructor // @NonNull 이 붙은 필드 생성자
//@EqualsAndHashCode // equals(), hashCode()

@Data
public class Score {
	int kor;
	int eng;
	int math;
	
	String comment;

	public Score() {
		super();
		System.out.println("Score() 생성");
	}

	
	public Score(int kor, int eng, int math, String comment) {
		super();
		System.out.printf("Score(%d, %d, %d, %s) 생성\n", kor, eng, math, comment);
		this.kor = kor;
		this.eng = eng;
		this.math = math;
		this.comment = comment;
	}
}
