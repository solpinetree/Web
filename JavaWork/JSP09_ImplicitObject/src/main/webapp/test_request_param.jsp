<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "java.util.Arrays" %>
<%!
	String data1, data2;
	String name, id, pw, gender, local, memo;
	String [] hobbys;
%>

<%
	request.setCharacterEncoding("utf-8");	// 한글 인코딩
	data1 = request.getParameter("data1");
	data2 = request.getParameter("data2");
	name = request.getParameter("name");
	id = request.getParameter("name");
	pw = request.getParameter("pw");
	gender = request.getParameter("gender");
	local = request.getParameter("local");
	
	hobbys = request.getParameterValues("hobby");
	memo = request.getParameter("memo");
%>



<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>request parameter</title>
</head>
<body>

hidden : <%= data1 %>, <%= data2 %><br>
이름 : <%= name %><br>
아이디 : <%= id %><br>
비밀번호 : <%= pw %><br>
성별 : <%= gender %><br>
취미 : <%= Arrays.toString(hobbys) %><br>
지역 : <%= local %><br>
메모 : <%= memo %>

</body>
</html>