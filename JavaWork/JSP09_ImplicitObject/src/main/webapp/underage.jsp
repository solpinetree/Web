<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>미성년자 페이지</title>
</head>
<body>
<%
	int age = Integer.parsInt(request.getParameter("age"));
%>
당신은 <%= age %>세 입니다
미성년자 입니다. 사이트 이용이 불가합니다.<br>
<%= (19-age) %>년 뒤에 사용 가능합니다. 
<a href="input_age.html">처음으로</a>
</body>
</html>