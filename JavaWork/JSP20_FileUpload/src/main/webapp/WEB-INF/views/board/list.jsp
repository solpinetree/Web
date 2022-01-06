<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%-- JSTL 버젼으로 바뀌니, import 의 번잡함도 사라진다!  JAVA 변수 선언도 사라진다! --%>
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

	<c:choose>
		<c:when test="${empty list || fn:length(list) == 0 }">
		</c:when>
		<c:otherwise>
			<c:forEach var="dto" items="${list }">
			<tr>
				<td>${dto.uid }</td>
				<td><a href="view.do?uid=${dto.uid }">${dto.subject }</a></td>
				<td>${dto.name }</td>
				<td>${dto.viewCnt }</td>
				<td>${dto.regDateTime }</td> <%-- getRegDateTime() 사용 --%>
			</tr>
			</c:forEach>
		</c:otherwise>
	</c:choose>	
		
		</tbody>
        </table>
        <div class="row">
            <div class="col-12">
                <button type="button" class="btn btn-outline-dark" onclick="location.href = 'write.do'">작성</button>
            </div>
        </div>
    </div>
</body>
</html>




