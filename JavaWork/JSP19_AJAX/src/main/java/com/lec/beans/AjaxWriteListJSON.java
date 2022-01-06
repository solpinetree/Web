package com.lec.beans;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public class AjaxWriteListJSON {
	
	int count;  // 데이터 개수
	String status;  // 처리 결과
	
	@JsonIgnore  // 제외할 필드
	String memo;  
	
	@JsonProperty("data")  // 매핑할 Json Property 이름과 Java 클래스 필드명이 다른 경우
	List<WriteDTO> list;
	
	public AjaxWriteListJSON() {}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	public List<WriteDTO> getList() {
		return list;
	}

	public void setList(List<WriteDTO> list) {
		this.list = list;
	}

	
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
}
