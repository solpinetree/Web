<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "java.sql.*"%>	<%-- JDBC 관련 클래스 import --%>
<%
	request.setCharacterEncoding("utf-8");	// 한글 인코딩 받아올 때 꼭!
	// 입력한 값들 받아오기 
	String name = request.getParameter("name");
	String subject = request.getParameter("subject");
	String content = request.getParameter("content");
	
	// 유효성 검증 null 이거나, 빈 문자열이면 이전화면으로 돌아가기
	if((name==null || subject == null)||
		name.trim().equals("") || subject.trim().equals("")){
%>
	<script>
		alert("작성자이름, 글제목을 꼭 입력하세요!!");
		history.back(); // 브라우저가 기억하는 이전 페이지로 돌아가는 js code
	</script>

<% 			
		return;		// [!] 더이상 JSP 프로세싱을 하지 않도록 여기서 종료 [!]
	}	// end if
%>
<%!
	// JDBC 관련 기본 객체 변수들 선언
	Connection conn = null;
	Statement stmt = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;	// executeQuery(), SELECT 결과
	int cnt = 0;	// executeUpdate(), DML 결과
	
	// Connection 에 필요한 값 세팅
	static final String DRIVER = "com.mysql.cj.jdbc.Driver"; // MySQL 8.x 이상의 드라이버 클래스
	static final String URL = "jdbc:mysql://localhost:3306/mydb811";	// DB url, DB 정보
	static final String USERID = "myuser811";	// DB 사용자 계정 정보
	static final String USERPW = "1234";
%>
<%!
	// 쿼리문 준비 
	final String SQL_WRITE_INSERT = "INSERT INTO test_write" +
		"(wr_subject,wr_content, wr_name) " + 
		"VALUES(?, ?, ?)";

	int uid;	//	auto-generated key 값 (wr_uid 컬럼값)
%>
<%
	try{
		Class.forName(DRIVER);
		out.println("드라이버 로딩 성공<br>");
		conn = DriverManager.getConnection(URL, USERID, USERPW);
		out.println("conn 성공<br>");
		
		// auto-generated 컬럼
		String[] generatedCols = {"wr_uid"};
		
		// 트랜잭션 실행
		pstmt = conn.prepareStatement(SQL_WRITE_INSERT, generatedCols);
		pstmt.setString(1, subject);
		pstmt.setString(2, content);
		pstmt.setString(3, name);
		
		cnt = pstmt.executeUpdate();
		
		
		if(cnt >0){
			// auto-generated key 값 가져오기
			rs = pstmt.getGeneratedKeys();
			if(rs.next()){
				uid = rs.getInt(1);
			}
		}
		
	}catch(Exception e){
		e.printStackTrace();
		// [!] 예외 처리를 하든지, 예외 페이지를 설정해주어야 한다.
	}finally{
		// DB 리소스 해제
		try{
			if(rs!=null)	rs.close();
			if(stmt != null)	stmt.close();
			if(pstmt != null)	pstmt.close();
			if(conn!=null)	conn.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
%>
<%-- 위에서 필요한 트랜잭션이 마무리 되면 페이지에 보여주기 --%>
<% if(cnt == 0){ %>
	<script>
		alert("등록 실패");
		history.back();
	</script>
<%}else{ %>
	<script>
		alert("등록 성공");
		location.href="view.jsp?uid=<%= uid%>";
	</script>
<% } %>
