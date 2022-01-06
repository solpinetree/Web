<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.time.*, com.lec.benas.*" %>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>EL request</title>
</head>
<body>
<%
	//EL 을 사용하면 request 객체 안의 내용을 손쉽게 출력 가능

	// 아래 pageContext 와 request 는 우선순위가 다르다
	// scope 우선순위 page > request > session > application
	
	pageContext.setAttribute("myage", "몰라요");
	request.setAttribute("myage", 30);
	request.setAttribute("mydto", new WriteDTO(100, "제목", "내용", "작성자", 3, LocalDateTime.now()));
	
	
%>
	${myage }<br>	<%-- scope 우선순위! --%>
	${requestScope.myage }<br>	<%-- 콕 찝어서 request 의 attribute 값 --%>
	
	${mydto }<br>	<%-- toString() 값 --%>
	${mydto.uid }<br>
	${mydto.subject }<br>
	${mydto.content }<br>
	${mydto.regDate }<br>
	${mydto.regDateTime }<br>
</body>
</html>