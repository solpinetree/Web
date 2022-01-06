<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String cookieName = "userid";
	Cookie cookie = new Cookie(cookieName, "");
	cookie.setMaxAge(0);
	response.addCookie(cookie);
%>

<script>
alert('로그아웃 되었습니다');
location.href = 'login.jsp';oog
</script>