<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>request</title>
</head>
<body>

<%
 	out.println("서버 : " + request.getServerName() + "<br>");
 	out.println("포트 : " + request.getServerPort() + "<br>");
 	out.println("요청방식 :" + request.getMethod() + "<br>");
 	out.println("프로토콜 :" + request.getProtocol() + "<br>");
 	out.println("URL :" + request.getRequestURL() + "<br>");
 	out.println("URI :" + request.getRequestURI() + "<br>");
 	out.println("ContextPath :" + request.getContextPath() + "<br>");
 	out.println("쿼리문자열: " + request.getQueryString() + "<br>"); 
	out.println("a = " + request.getParameter("a")+"<br>");
	out.println("b = " + request.getParameter("b")+"<br>");
	out.println("c = " + request.getParameter("c")+"<br>");
%>
</body>
</html>