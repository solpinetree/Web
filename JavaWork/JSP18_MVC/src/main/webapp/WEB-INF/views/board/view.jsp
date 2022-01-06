<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.lec.beans.*" %>
<%@ page import="java.util.*" %>
<% // Controller 로부터 결과 데이터 받음 
	List<WriteDTO> list = (List<WriteDTO>)request.getAttribute("list");
%>

<% if(list == null || list.size() == 0) {%>
	<script>
		alert("해당 정보가 삭제되거나 없습니다");
		history.back();
	</script>			
<%
		return;
	}

	WriteDTO dto = list.get(0);
%>

<%
	int uid = dto.getUid();
	String name = dto.getName();
	String subject = dto.getSubject();
	String content = dto.getContent();
	String regdate = dto.getRegDateTime();
	int viewcnt = dto.getViewCnt();
%>


<%-- 위에서 필요한 트랜잭션이 마무리 되면 페이지에 보여주기 --%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.bundle.min.js"></script>
	<title>조회 <%= subject %></title>  <!-- 제목에 내용을 넣을수도 있다 -->
</head>

<script>
function chkDelete(uid){
	// 삭제 여부, 다시 확인하고 진행
	var r = confirm("삭제하시겠습니까?");
	
	if(r){
		location.href = 'deleteOk.do?uid=' + uid;
	}
}
</script>

<body>
	<div class="container mt-3">
		<h2>조회 <%= subject %></h2>
		<hr>
		<div class="mb-3 mt-3 clearfix">
            <span class="float-start me-2">uid: <%= uid %></span>
            <span class="float-end ms-4">작성일: <%= regdate %></span>
            <span class="float-end">조회수: <%= viewcnt %></span>
        </div>
        <section>
            <div class="mb-3">
                <label for="name">작성자:</label>
                 <div class="border bg-light rounded p-2" ><%= name %></div>
            </div>    
            <div class="mb-3 mt-3">
                <label for="subject">제목:</label>
                 <div class="border bg-light rounded p-2" ><%= subject %></div>
            </div>    
            <div class="mb-3 mt-3">
                <label for="content">내용:</label>
                 <div class="border bg-light rounded p-2" ><%= content %></div>
            </div>    

            <button type="button" class="btn btn-outline-dark" onclick="location.href='update.do?uid=<%= uid %>'">수정</button>
            <button type="button" class="btn btn-outline-dark" onclick="location.href='list.do'">목록</button>
            <button type="button" class="btn btn-outline-dark" onclick="chkDelete(<%= uid %>)">삭제</button>
            <button type="button" class="btn btn-outline-dark" onclick="location.href='write.do'">작성</button>

        </section>        
	</div>
</body>
</html>














