<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%  // Controller 로부터 결과 데이터 받음
	int cnt = (Integer)request.getAttribute("result");
%>

<%-- 위에서 필요한 트랜잭션이 마무리 되면 페이지에 보여주기 --%>
<% if(cnt == 0){ %>
	<script>
		alert("삭제 실패");
		history.back();
	</script>
<% } else { %>
	<script>
		alert("삭제 성공");
		location.href = "list.do";
	</script>
<% } %>















