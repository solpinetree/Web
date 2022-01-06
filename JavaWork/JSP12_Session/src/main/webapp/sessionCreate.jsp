<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.time.*, java.time.format.*" %>
<%
	String sessionName1 = "num1";
	String sessionValue1 = "" + (int)(Math.random()*100);
	
	// 세션 attr 생성 : name-value 생성 
	// setAttribute(String name, Object value)
	session.setAttribute(sessionName1, sessionValue1);
	
	String sessionName2 = "datetime";
	String sessionValue2 = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss"));
	session.setAttribute(sessionName2, sessionValue2);
%>

<script>
alert("세션 attr 생성 : <%=sessionName1 %>, <%=sessionName2%> ");
location.href="sessionList.jsp";
</script>