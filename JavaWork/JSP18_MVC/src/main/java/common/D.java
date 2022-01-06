package common;


public class D {
	// Connection 에 필요한 값 세팅
	public static final String DRIVER = "com.mysql.cj.jdbc.Driver";  // MySQL 8.x 이상의 드라이버 클래스
	public static final String URL = "jdbc:mysql://localhost:3306/mydb811";   // DB url, DB 정보
	public static final String USERID = "myuser811";    // DB 사용자 계정정보
	public static final String USERPW = "1234";
	
	
	// 게시물 관련 쿼리문
	// 쿼리문 준비
	public static final String SQL_WRITE_SELECT = 
		"SELECT wr_uid uid, wr_subject subject, wr_content content, " + 
		"wr_name name, wr_viewcnt viewcnt, wr_regdate regdate " + 
		"FROM test_write ORDER BY wr_uid DESC"
		;
	
	public static final String SQL_WRITE_INSERT = "INSERT INTO test_write" + 
			"(wr_subject, wr_content, wr_name) " +
			"VALUES(?, ?, ?)"
			;
	
	public static final String SQL_WRITE_INC_VIEWCNT = 
			"UPDATE test_write SET wr_viewcnt = wr_viewcnt + 1 WHERE wr_uid = ?";
	
	public static final String SQL_WRITE_SELECT_BY_UID = 
			"SELECT wr_uid uid, wr_subject subject, wr_content content, " + 
			"wr_name name, wr_viewcnt viewcnt, wr_regdate regdate " +
			"FROM test_write WHERE wr_uid = ?";
	
	public static final String SQL_WRITE_UPDATE =
			"UPDATE test_write SET wr_subject = ?, wr_content = ? WHERE wr_uid = ?";

	public static final String SQL_WRITE_DELETE_BY_UID = 
			"DELETE FROM test_write WHERE wr_uid = ?";
}
