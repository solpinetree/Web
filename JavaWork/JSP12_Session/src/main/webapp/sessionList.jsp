<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.Enumeration" %>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	// jsp 에선 session 내부 객체 사용
	// ※ 서블릿 에서는 request.getSession() 으로 Session 객체 얻어올수 있다.
	String sessionName, sessionValue;
	
	// 세션에 있는 모든 attr names 들 뽑기
	Enumerating<String> enumNames = session.getAttributeNames(); 
	int i= 0;
	
	while(enumNames.hasMoreElements()){
		sessionName = enumNames.nextElement();
		// session.getAttribute('name')
		//  <-- 특정 세션 attr value 추출. 리턴타입 Object. 해당 name 이 없으면 null 리턴
		sessionBalue = session.getAttribute(sessionName).toString();
		out.println((i+1)+"] "+sessionName +":"+sessionValue +"<br>");
	}

	if(i==0){
		out.println("세션 안에 attribute가 없습니다<br>");
	}
%>
</body>
<form action="sessionCreate.jsp" method="get">
<input type="submit" value="세션 attr 생성">
</form>

<br>

<form action="sessionDelete.jsp" method="get">
<input type="submit" value="세션 attr 삭제">
</form>


</html>