<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>작성</title>
</head>
<script>
// form 검증(validation)
function chkSubmit(){
	
	frm = document.forms['frm'];
	
	var name = frm['name'].value.trim();
	var subject = frm.['text'].value.trim();
	
	if(name == ""){
		alert("작성자는 반드시 입력해야 합니다");
		frm['name'].focus();
		return false;
	}
	
	if(subject == ""){
		alert("제목은 반드시 작성해야 합니다");
		frm['subject'].focus();
		return false;
	}
	
	return true;
}
</script>
<body>
<h2>글작성</h2>
<%-- 글 내용이 많을 수 있기 때문에 POST 방식 사용 --%>
<form name="frm" action="writeOk.jsp" method="POST" onsubmit="return chkSubmit()">
작성자:
<input type="text" name="name"/><br>
제목:
<input type="text" name="subject"/><br>
내용: 
<textarea name="content"></textarea>
<br><br>
<input type="submit" value="등록"/>
</form>
<br>
<button type="button" onclick="location.href='list.jsp'">목록으로</button>
</body>
</html>