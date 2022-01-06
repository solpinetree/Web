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
<c:set var="name" value="홍길동"/>	<%-- 서버 컨테이너 내부적으로 변수가 만들어짐 --%>
이름: <c:out value='${name }'/><br>	<%-- JSTL 변수는 EL으로 접근 가능 --%>
이름: ${name }<br>
이름: ${pageScope.name }<br>	<%-- set 결과 생성된 변수는 page의 attribute로 저장됨 --%>

<c:remove var="name"/>	<%-- 변수 삭제 --%>
이름: ${name }<br>
<hr>
<%
	int age = 10;
%>
나이: ${age }<br>		<%-- Java 변수 -> EL에서 다이렉트로 사용 불가--%>
<c:set var="age" value="<%= age %>"/>	<%-- Java 변수 -> JSTL -> EL(o) --%>
나이: ${age }<br>	


</body>
</html>