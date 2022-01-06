<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.net.*"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>param2</title>
</head>
<body>
<p>지금 현재 페이지는 param2 페이지 입니다 </p>
<%
	int num = 788;
	String id = "홍길동";	// 한글
%>
<jsp:include page="subParam.jsp">
	<jsp:param name="id" value='<%= URLEncoder.encode(id, "utf-8") %>'/>
	<jsp:param name="pw" value="<%= num %>"/>
</jsp:include>
<p>위 라인의 내용은 subParam 의 내용입니다</p>
</body>
</html>