<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- JSTL core --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>JSTL Core</title>
</head>
<body>
<h2>set, remove, out</h2>
이름: <c:out value='jang'/><br>
<c:set var="name" value="홍길동"/>
이름: <c:out value='${ name}'/><br>	<%-- JSTL 의 변수는 -> EL에서 사용 가능 --%>
이름: ${name }<br>
이름: ${pageScope.name }<br>

<c:remove var='name'/>	<%-- 변수 삭제 --%>
이름: ${name }<br>
<hr>
<%
	int age = 10;
%>
나이: ${age }<br>		<!--  Java 변수 -> EL (x)  -->
<c:set var="age" value="<%= age %>"/>
나이: ${age }<br>		<%-- Java 변수 -> JSTL -> EL (o) --%>
<hr>

<h2>catch</h2>

<c:catch var="error">
<%-- 이 안에서 예외 발생하면 예외 객체를 error 변수에 담는다 --%>
	<%= 2/0 %>
</c:catch>
<br>
<c:out value="${error }"/>

<br>
<c:catch var="ex">
name parameter 값 = <%= request.getParameter("name") %><br>
<% if(request.getParameter("name").equals("test")){ %>
	${param.name } 은 test 입니다.
<%} %>
</c:catch>

<c:if test="${ex != null }">
예외발생: ${ex }<br>
</c:if>









</body>
</html>