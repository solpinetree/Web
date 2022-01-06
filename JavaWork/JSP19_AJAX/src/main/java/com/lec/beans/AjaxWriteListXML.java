package com.lec.beans;

import java.util.List;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

@JacksonXmlRootElement(localName = "WriteList")   // <- 없으면 class 이름으로 태그 만들어짐
public class AjaxWriteListXML {
	int count;
	
	String status;
	
	@JacksonXmlElementWrapper(useWrapping = false)
	@JacksonXmlProperty(localName = "data")
	List<WriteDTO> list;
	
	// attribute 로 변환할 필드들.  클래스 element 의 attribute 가 된다.
	@JacksonXmlProperty(localName = "id", isAttribute = true)
	String id;
	
	@JacksonXmlProperty(localName = "pw", isAttribute = true)
	String pw;
	
	
	
	public List<WriteDTO> getList() {
		return list;
	}

	public void setList(List<WriteDTO> list) {
		this.list = list;
	}


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
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
