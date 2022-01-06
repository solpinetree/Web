<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.lec.beans.Person, java.util.*" %>
<%-- JSTL core --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>JSTL & Bean</title>
</head>
<body>
<%
	Person kim = new Person();
	kim.setName("제임스");
	kim.setAge(200);
%>
<c:set var="dto" value="<%=kim %>"/>
이름: ${dto.name }<br>	<%-- dto.getName() 값 출력 --%>
나이: ${dto.age }<br>		<%-- dto.getAge() 값 출력 --%>
dto: ${dto }<br>	<%-- toString() 값 출력 --%>


<hr>
<%-- 빈(bean) 배열의 경우 --%>
<%
	Person p1 = new Person();
	p1.setName("고질라");
	p1.setAge(100);
	Person p2 = new Person();
	p2.setName("킹기도라");
	p2.setAge(200);
	Person p3 = new Person();
	p3.setName("모스라");
	p3.setAge(80);
	
	Person [] arr={p1,p2,p3};
%>

<c:set var="dtoArr" value="<%=arr %>"/>
<c:forEach var="p" items="${dtoArr }">
	${p.name }<br>
	${p.age }<br>
	${p }<br>
</c:forEach>
<hr>

<%
	List<Person> list = new ArrayList<Person>();
	list.add(p1);
	list.add(p2);
	list.add(p3);
%>

<c:set var="dtoArr" value="<%= list %>"/>
<c:forEach var="p"	items="${dtoArr }">
	${p.name }<br>
	${p.age }<br>
	${p }<br>
</c:forEach>
<hr>

${dtoArr[0].name }<br>
${dtoArr[1].name }<br>
${dtoArr[2].name }<br>
${dtoArr[3].name }<br>
<hr>

</body>
</html>