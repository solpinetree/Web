<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String sessionName = "num1";
	
	session.removeAttribute(sessionName);
%>


<script>
alert("세션 attribute 삭제: <%= sessionName %>");
location.href="sessionList.jsp";
</script>