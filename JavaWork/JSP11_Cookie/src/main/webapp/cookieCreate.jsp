<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import ="java.time.*, java.time.format.*" %>
<%--
쿠키 생성 절차
1. 쿠키(javax.servlet.http.Cookie) 클래스로 생성  
2. 쿠키속성 설정(setter)  
3. 쿠키의 전송 (response 객체에 탑재:addCookie())
 --%>

 <%
	String cookieName = "num1";
 	String cookieValue = "" + (int)(Math.random()*10);
 	Cookie cookie = new Cookie(cookieName, cookieValue); // 이름-값 쌍으로 쿠키 생성
 	cookie.setMaxAge(30);	//	 쿠키 파기(expiry) 시간 설정(생성시점으로부터 30초 후)
 	response.addCookie(cookie);	// response에 쿠키 정보 추가
 
 	// 쿠키는 얼마든지 생성 가능
 	String cookieName2 = "datetime";
 	String cookieValue2 = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddhhmmss"));
 	Cookie cookie2 = new Cookie(cookieName2, cookieValue2);
 	cookie2.setMaxAge(40);
 	response.addCookie(cookie2);
 %>
 
 
<script>
alert("<%= cookieName%> 쿠키 생성");
location.href = "cookieList.jsp";
</script>