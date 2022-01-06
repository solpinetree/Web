<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.lec.beans.*, java.util.*" %>
<% // Controller 로부터 결과 데이터 받음
	List<WriteDTO> list = (List<WriteDTO>)request.getAttribute("list");
%>
<!DOCTYPE html>
<html lang="ko">
<head>
	<meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.bundle.min.js"></script>

    <title>목록</title>
</head>
<body>
    <div class="container mt-3">
        <h2>목록</h2>
        <hr>
        <table class="table table-hover">
            <thead class="table-success">
                <tr>
                    <th>#</th>
                    <th>제목</th>
                    <th>작성자</th>
                    <th>조회수</th>
                    <th>작성일</th>
                </tr>
            </thead>
            <tbody>
<%
	if(list != null){
		for(WriteDTO dto : list){
%>
			<tr>
				<td><%= dto.getUid() %></td>
				<td><a href="view.do?uid=<%= dto.getUid()%>"><%= dto.getSubject() %></a></td>
				<td><%= dto.getName()  %></td>
				<td><%= dto.getViewCnt() %></td>
				<td><%= dto.getRegDateTime() %></td>
			</tr>
<%
		} // end for
	} // end if
%>
		
		</tbody>
        </table>
        <div class="row">
            <div class="col-12">
                <button type="button" class="btn btn-outline-dark" onclick="location.href = 'write.do'">작성</button>
            </div>
        </div>
    </div>

<%-- 위에서 필요한 트랜잭션이 마무리 되면 페이지에 보여주기 --%>

</body>
</html>




