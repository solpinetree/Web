<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<h1>test_response.jsp</h1>
<%
	int age;
	String str = request.getParameter("age");
	age = Integer.parseInt(str);
	
	if(age>=19){
		response.sendRedirect("adult.jsp?age="+age);
	}else{
		response.sendRedirect("underage.jsp?age"+age);
	}
%>