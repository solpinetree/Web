<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>cookie 리스트</title>
</head>
<body>
<%
	// client 안의 쿠키 정보는 request 시 서버에 전달됨.
	// request.getCookies()로 쿠키정보 읽어온다 
	Cookie [] cookies = request.getCookies();	// Cookie [] 배열을 리턴
	
	if(cookies != null){	//만약 쿠키가 하나도 없다면 null이 리턴된다.
		for(int i=0;i<cookies.length;i++){
			String name = cookies[i].getName();	// 쿠키 '이름'
			String value = cookies[i].getValue();	// 쿠키 '값' 
			out.println((i+1)+"] "+name+" : "+value+"<br>");
		}
	}else{
		out.println("쿠키가 없습니다<br>");
	}
%>

<br>
<button onclick="location.href = 'cookieCreate.jsp'">쿠키생성&갱신</button>
<br>
<button onclick="location.href = 'cookieDelete.jsp'">쿠키 삭제</button>

</body>
</html>