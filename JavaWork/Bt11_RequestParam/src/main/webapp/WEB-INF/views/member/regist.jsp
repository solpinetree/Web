<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- action 의 url 과 method 주목 ! --%>
<form action="regOk" method="GET">
	<input type="text" name="name" value="GET"/>
	<input type="submit" value="GET요청"/>
</form>
<hr>
<form action="regOk" method="POST">
	<input type="text" name="name" value="POST"/>
	<input type="submit" value="POST요청"/>
</form>
<hr>
<form action="regOk2" method="GET">
	<input type="text" name="name" value="GET-regOk2"/>
	<input type="submit" value="GET요청"/>
</form>
<hr>
<form action="regOk2" method="POST">
	<input type="text" name="name" value="POST-regOk2"/>
	<input type="submit" value="POST요청"/>
</form>
