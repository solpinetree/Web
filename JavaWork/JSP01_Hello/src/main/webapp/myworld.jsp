<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>my jsp</title>
</head>
<body>
<% 
	// JSP 태그 영역, Java 코드 작성
	for(int i =0;i<10;i++){
		// 콘솔에 출력
		System.out.println("System.out.println() 출력 : ");
	}
%>
<hr>
<% 
	for(int i =0;i<10;i++){
		// HTML response 에 출력
		out.println("System.out.println() 출력 : "+i+"<br>");
	}
%>
</body>
</html>