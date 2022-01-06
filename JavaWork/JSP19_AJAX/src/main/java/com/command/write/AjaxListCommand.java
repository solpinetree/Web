package com.command.write;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.lec.beans.AjaxWriteListJSON;
import com.lec.beans.AjaxWriteListXML;
import com.lec.beans.WriteDTO;

public class AjaxListCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// parameter 받아오기, 없으면 json 동작(디폴트)
		String reqType = request.getParameter("reqType");
		if(reqType == null) reqType = "json";
		
		// "xml" 혹은 "json" 으로 response
		switch(reqType) {
		case "xml":
			responseXML(request, response);
			break;
		default:  // "json" 혹은 다른경우
			responseJSON(request, response);
		}

	}

	private void responseJSON(HttpServletRequest request, HttpServletResponse response) {
		
		List<WriteDTO> list = (List<WriteDTO>)request.getAttribute("list");
		
		AjaxWriteListJSON obj = new AjaxWriteListJSON();  // response 할 Java객체
		
		if(list == null) {
			obj.setStatus("FAIL");
		} else {
			obj.setStatus("OK");
			obj.setCount(list.size());
			obj.setList(list);
		}
		
		ObjectMapper mapper = new ObjectMapper();  // Java -> JSON 매핑할 Mapper 객체
		
		try {
			String output = null;
			output = mapper.writeValueAsString(obj);
			System.out.println(output);
			//output = "{\"name\":\"hong\", \"age\":24, \"address\":\"서울\"}";
			response.setContentType("application/json; charset=utf-8"); // MIME 설정
			response.getWriter().write(output);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void responseXML(HttpServletRequest request, HttpServletResponse response) {
		
		List<WriteDTO> list = (List<WriteDTO>)request.getAttribute("list");
		
		AjaxWriteListXML obj = new AjaxWriteListXML();  // response 할 Java객체
		
		if(list == null) {
			obj.setStatus("FAIL");
		} else {
			obj.setStatus("OK");
			obj.setCount(list.size());
			obj.setList(list);
		}
		
		XmlMapper mapper = new XmlMapper();  // Java -> XML 매핑할 Mapper객체
		
		try {
			String output = null;
			output = mapper.writeValueAsString(obj);  // XML <- Java
			System.out.println(output);
			//output = "<WriteList><name>hong</name><age>24</age><address>서울</address></WriteList>";
			response.setContentType("application/xml; charset=utf-8"); // MIME 설정
			response.getWriter().write(output);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}














