<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "java.sql.*"%>  <%-- JDBC 관련 클래스 import --%>
<%@ page import = "java.time.*, java.time.format.*" %>

<% // parameter 받아오기
	int uid = Integer.parseInt(request.getParameter("uid"));
	// ※ 이 단계에서 parameter 검증 필요
	
	int curPage = 1;   // 현재페이지. 디폴트는 1 page
	String pageParam = request.getParameter("page");
	
	if(pageParam != null && !pageParam.trim().equals("")){
		try{			
			curPage = Integer.parseInt(pageParam);
		} catch(NumberFormatException e){
			
		}
	}
%>
<%!
	// JDBC 관련 기본 객체 변수들 선언
	Connection conn = null;
	Statement stmt = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;       // executeQuery(), SELECT 결과
	int cnt = 0;               // executeUpdate(), DML 결과
	
	// Connection 에 필요한 값 세팅
	static final String DRIVER = "com.mysql.cj.jdbc.Driver";  // MySQL 8.x 이상의 드라이버 클래스
	static final String URL = "jdbc:mysql://localhost:3306/mydb811";   // DB url, DB 정보
	static final String USERID = "myuser811";    // DB 사용자 계정정보
	static final String USERPW = "1234";
%>
<%!
	// 쿼리문 준비
	final String SQL_WRITE_INC_VIEWCNT = 
		"UPDATE test_write SET wr_viewcnt = wr_viewcnt + 1 WHERE wr_uid = ?";
	final String SQL_WRITE_SELECT_BY_UID = 
		"SELECT wr_uid uid, wr_subject subject, wr_content content, " + 
		"wr_name name, wr_viewcnt viewcnt, wr_regdate regdate " +
		"FROM test_write WHERE wr_uid = ?";
%>
<%
	String name = "";
	String subject = "";
	String content = "";
	String regdate = "";
	int viewcnt = 0;
%>

<%
	try{
		Class.forName(DRIVER);
		//out.println("드라이버 로딩 성공<br>");
		conn = DriverManager.getConnection(URL, USERID, USERPW);
		//out.println("conn 성공<br>");
		
		// 여러 쿼리문을 하나의 트랜잭션으로 실행
		conn.setAutoCommit(false);   // 일단 auto-commit 을 false
		
		// 1. uid 의 글 조회수 +1 증가
		pstmt = conn.prepareStatement(SQL_WRITE_INC_VIEWCNT);
		pstmt.setInt(1, uid);
		cnt = pstmt.executeUpdate();
		
		pstmt.close();
		
		// 2. uid 의 글 읽어오기
		pstmt = conn.prepareStatement(SQL_WRITE_SELECT_BY_UID);
		pstmt.setInt(1, uid);
		rs = pstmt.executeQuery();
		
		// 한개의 레코드만 select 된다
		if(rs.next()){
			uid = rs.getInt("uid");
			subject = rs.getString("subject");
			name = rs.getString("name");
			content = rs.getString("content");
			if(content == null) content = "";
			viewcnt = rs.getInt("viewcnt");
			
			LocalDateTime t = rs.getObject("regdate", LocalDateTime.class);
			regdate = t.format(DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss"));
		} else {
			// 그렇지 않다면 uid 값의 글이 없는 거다!
%>
	<script>
		alert("해당 정보가 삭제되거나 없습니다");
		history.back();
	</script>			
<%		
			return;  // 더이상 JSP 프로세싱 하지 않고 종료
		}				
		conn.commit();   // 트랜잭션이 성공적으로 끝나면 commit 한다
	} catch(Exception e){
		e.printStackTrace();
		// ※ 예외 처리를 하든지, 예외 페이지를 설정해주어야 한다.
		
		conn.rollback();  // 트랜잭션 중간에 실패하면 rollback
		
	} finally {
		// DB 리소스 해제
		try{
			if(rs != null) rs.close();
			if(stmt != null) stmt.close();
			if(pstmt != null) pstmt.close();			
			if(conn != null) conn.close();
		} catch(Exception e){
			e.printStackTrace();
		}		
	}
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
		location.href = 'deleteOk.jsp?uid=' + uid;
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

            <button type="button" class="btn btn-outline-dark" onclick="location.href='update.jsp?uid=<%= uid %>'">수정</button>
            <button type="button" class="btn btn-outline-dark" onclick="location.href='list.jsp?page=<%= curPage%>'">목록</button>
            <button type="button" class="btn btn-outline-dark" onclick="chkDelete(<%= uid %>)">삭제</button>
            <button type="button" class="btn btn-outline-dark" onclick="location.href='write.jsp'">작성</button>

        </section>        
	</div>
</body>
</html>














