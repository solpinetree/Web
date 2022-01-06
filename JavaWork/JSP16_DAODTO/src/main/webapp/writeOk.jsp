<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="dao" class="com.lec.beans.WriteDAO"/> 	<%-- DAO bean 생성 --%>
<%
	request.setCharacterEncoding("utf-8");  // 한글 인코딩 꼭!
%>
<jsp:useBean id="dto" class="com.lec.beans.WriteDTO"/>
<jsp:setProperty property="*" name="dto"/>

<%	// dao 를 사용한 트랜잭션
	int cnt = dao.insert(dto);
%>

<%-- 위에서 필요한 트랜잭션이 마무리 되면 페이지에 보여주기 --%>
<% if(cnt == 0){ %>
	<script>
		alert("등록 실패");
		history.back();
	</script>
<% } else { %>
	<script>
		alert("등록 성공");
		location.href = "view.jsp?uid=<%= dto.getUid()%>";
	</script>
<% } %>














