package com.lec.spring.domain;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.DynamicInsert;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@Entity(name = "TBL_WRITE")
@DynamicInsert	// insert 시 null 인 필드 제외
public class Write {
	@Id
	@GeneratedValue
	private Long uid;
	
	@NonNull
	@NotNull // NOT NULL
	private String subject;
	private String content; 

	@NonNull
	@NotNull // NOT NULL
	private String name; 
	
	@Column(columnDefinition = "integer default 0")
	private int viewCnt;  
	
	@Column(columnDefinition = "timestamp default CURRENT_TIMESTAMP")
	private LocalDateTime regDate;
	
}
