<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%!
	public static final String ADMIN_ID = "admin";
	public static final String ADMIN_PW = "1234";
%>   
<%
	String userid = request.getParameter("userid");
	String pw = request.getParameter("pw");
	
	String cookieName = "userid";
	String cookieValue = userid;
	
	// 로그인 성공하면 쿠키 생성
	if(ADMIN_ID.equalsIgnoreCase(userid)&&ADMIN_PW.equals(pw)){
		out.println("<script>");
		out.println("alert('로그인 성공');");
		out.println("</script>");
		
		Cookie cookie = new Cookie(cookieName, cookieValue);
		cookie.setMaxAge(30);
		response.addCookie(cookie);
	}else{
		out.println("<script>");
		out.println("alert('로그인 실패');");
		out.println("</script>");
		
		Cookie cookie = new Cookie(cookieName, cookieValue);
		cookie.setMaxAge(30);
		response.addCookie(cookie);		
	}
%>
<script>
location.href = "login.jsp";
</script>