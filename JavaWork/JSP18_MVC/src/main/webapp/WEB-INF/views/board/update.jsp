<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.lec.beans.*" %>
<%@ page import="java.util.*" %>
<%
// Controller 로부터 결과 데이터 받음
	List<WriteDTO> list = (List<WriteDTO>)request.getAttribute("list");
%>

<% if(list == null || list.size() == 0){ %>
	<script>
		alert("해당 정보가 삭제되거나 없습니다");
		history.back();
	</script>			
<%
		return;   // 더 이상 JSP 프로세싱 하지 않고 종료
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
<meta charset="UTF-8">
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.bundle.min.js"></script>

    <title>수정 <%= subject %></title>
</head>
<script>
// form 검증(validation)
function chkSubmit(){
	
	frm = document.forms['frm'];
	
	var subject = frm['subject'].value.trim();
	
	if(subject == ""){
		alert("제목은 반드시 작성해야 합니다");
		frm["subject"].focus();
		return false;
	}
	
	return true;	
}
</script>
<body>
	<div class="container mt-3">
		<h2>수정</h2>
		<hr>
		<div class="mb-3 mt-3 clearfix">
            <span class="float-start me-2">uid: <%= uid %></span>
            <span class="float-end ms-4">작성일: <%= regdate %></span>
            <span class="float-end">조회수: <%= viewcnt %></span>
        </div>
        
		<form name="frm" action="updateOk.do" method="post" onsubmit="return chkSubmit()">
			<input type="hidden" name="uid" value="<%= uid %>"/>
			
			<div class="mb-3">
                <label for="name">작성자:</label>
                <div class="border bg-light rounded p-2" ><%= name %></div>
            </div>    
            <div class="mb-3 mt-3">
                <label for="subject">제목:</label>
                <input type="text" class="form-control" id="subject" placeholder="제목을 입력하세요" name="subject" value="<%= subject%>">
            </div>
            <div class="mb-3 mt-3">
                <label for="content">내용:</label>
                <textarea class="form-control" rows="5" id="content" placeholder="내용을 입력하세요" name="content"><%= content %></textarea>
            </div>
			
			<button type="submit" class="btn btn-outline-dark">수정완료</button>
			<button type="button" class="btn btn-outline-dark" onclick="history.back();">이전으로</button>
            <button type="button" class="btn btn-outline-dark" onclick="location.href='list.do'">목록</button>
		</form>
		
	</div>

</body>
</html>















