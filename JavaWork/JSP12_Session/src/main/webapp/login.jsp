<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%!
		int i = 0;
	
	%>
	<%
		Enumerating<String> enumNames = session.getAttributeNames(); 
		String cookieName = "userid"; 	// 로그인 성공하면 발급되는 쿠키 이름
		
		if(cookies != null){
			for(i = 0;i<cookies.length;i++){
				if(cookieName.equals(cookies[i].getName())){
					break;	//	쿠키 있으면 for 종료
				}
			}
		}
		
		while(enumNames.hasMoreElements()){
			sessionName = enumNames.nextElement();
			// session.getAttribute('name')
			//  <-- 특정 세션 attr value 추출. 리턴타입 Object. 해당 name 이 없으면 null 리턴
			sessionBalue = session.getAttribute(sessionName).toString();
			out.println((i+1)+"] "+sessionName +":"+sessionValue +"<br>");
		}
	%>
	
	<%if(cookies == null|| i==cookies.length){%>
		<h2>로그인 상태가 아닙니다</h2>
		<form action="loginOk.jsp">
			id: <input type="text" name="userid"><br>
			pw: <input type="password" name="pw"><br>
			<input type = "submit" value="로그인"><br>
		</form>
	<%}else{ %>
		<h2>로그인 상태입니다</h2>
		<form> action="logout.jsp"</form>
	<%} %>
</body>
</html>