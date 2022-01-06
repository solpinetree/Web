<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "java.sql.*"%>  <%-- JDBC 관련 클래스 import --%>
<%@ page import = "java.time.*, java.time.format.*" %>
<%
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
	
	// 글 목록 전체 개수 가져오기
	final String SQL_WRITE_COUNT_ALL = "SELECT count(*) FROM test_write";
	
	// fromRow 부터 pageRows 만큼 SELECT
	final String SQL_WRITE_SELECT_FROM_ROW = 
		"SELECT wr_uid uid, wr_subject subject, wr_content content, " + 
		"wr_name name, wr_viewcnt viewcnt, wr_regdate regdate " + 
		"FROM test_write ORDER BY wr_uid DESC " +
		"LIMIT ?, ?"
		;
	
	// 페이징 관련 세팅 값들
	int writePages = 10;  // 한 [페이징] 에 몇개의 '페이지' 를 표현할 것인가?
	int pageRows = 8;   // 한 '페이지' 에 몇개의 글을 리스트 할것인가?
	int totalPage = 0;  // 총 '몇 페이지' 분량인가?
	
%>
<%
	int uid = 0;
	String name = "";
	String subject = "";
	String content = "";
	String regdate = "";
	int viewcnt = 0;
%>
<!DOCTYPE html>
<html lang="ko">
<head>
	<meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.bundle.min.js"></script>
	<script src="https://kit.fontawesome.com/bb29575d31.js"></script>
    <title>목록</title>
</head>
<body>

<%
	try{
		Class.forName(DRIVER);
		//out.println("드라이버 로딩 성공<br>");
		conn = DriverManager.getConnection(URL, USERID, USERPW);
		//out.println("conn 성공<br>");
		
		// 트랜잭션 실행
		pstmt = conn.prepareStatement(SQL_WRITE_COUNT_ALL);
		rs = pstmt.executeQuery();
		
		if(rs.next())
			cnt = rs.getInt(1);	//	 전체 개수 구하기
		
		rs.close();
		pstmt.close();
		
		totalPage = (int)Math.ceil(cnt/(double)pageRows);	// 총 몇페이지 분량
		
		// 몇번째 row 부터 출력?
		int fromRow = (curPage - 1)*pageRows;	// MySQL은 0-base 

		pstmt = conn.prepareStatement(SQL_WRITE_SELECT_FROM_ROW);
		pstmt.setInt(1,fromRow);	//	 몇번째 row부터 
		pstmt.setInt(2, pageRows);	//	한페이지당 몇개의 글을?
		rs = pstmt.executeQuery();
%>
    <div class="container mt-3">
        <h2>목록</h2>
        <hr>
        <div class="mb-3 mt-3 clearfix">
			<span calss="me-2">총 <%=cnt %>개</span>        
			<span>page <%=curPage %>/<%= totalPage %></span>
        </div>
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
		while(rs.next()){
			uid = rs.getInt("uid");
			subject = rs.getString("subject");
			name = rs.getString("name");
			content = rs.getString("content");
			if(content == null) content = "";
			viewcnt = rs.getInt("viewcnt");
			
			LocalDateTime t = rs.getObject("regdate", LocalDateTime.class);
			regdate = t.format(DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss"));
			
			out.println("<tr>");
			out.println("<td>" + uid + "</td>");
			out.println("<td><a href='view.jsp?uid=" + uid + "&page=" + curPage + "'>" + subject + "</a></td>");
			out.println("<td>" + name + "</td>");
			out.println("<td>" + viewcnt + "</td>");
			out.println("<td>" + regdate + "</td>");
			out.println("</tr>");
		} // end while
%>			
		</tbody>
        </table>
        <div class="row">
            <div class="col-12">
                <button type="button" class="btn btn-outline-dark" onclick="location.href = 'write.jsp'">작성</button>
            </div>
        </div>
    </div>
<%	
	} catch(Exception e){
		e.printStackTrace();
		// ※ 예외 처리를 하든지, 예외 페이지를 설정해주어야 한다.
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

<%-- [페이지] --%>
<jsp:include page="pagination.jsp">
	<jsp:param value="<%= writePages %>" name="writePages"/>
	<jsp:param value="<%= totalPage %>" name="totalPage"/>
	<jsp:param value="<%= curPage %>" name="curPage"/>
</jsp:include>


</body>
</html>