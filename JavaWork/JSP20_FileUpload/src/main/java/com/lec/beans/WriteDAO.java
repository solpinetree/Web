package com.lec.beans;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import common.D;

//DAO : Data Access Object
//특정 데이터 리소스(ex: DB) 에 접속하여 트랜잭션등을 전담하는 객체
//데이터 리소스별로 작성하거나, 
//혹은 기능별로 작성가능 (ex: 게시판용 DAO, 회원관리용 DAO, ...)
public class WriteDAO {

	private Connection conn;
	private PreparedStatement pstmt;
	private Statement stmt;
	private ResultSet rs;

	// DAO 객체가 생성될때 Connection 도 생성된다.
	public WriteDAO() {
		try {
			Class.forName(D.DRIVER);
			conn= DriverManager.getConnection(D.URL, D.USERID, D.USERPW);
//			System.out.println("WriteDAO 생성,  데이터베이스 연결");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// DB 자원 반납 
	public void close() throws SQLException{
		if(rs != null) rs.close();
		if(stmt != null) stmt.close();
		if(pstmt != null) pstmt.close();			
		if(conn != null) conn.close();
	}
	
	
	// 새글작성 <-- dTO
	public int insert(WriteDTO dto) throws SQLException{
		
		int cnt = 0;
		
		String subject= dto.getSubject();
		String content = dto.getContent();
		String name = dto.getName();
		
		int uid;  // auto-generated key 값
		String [] generatedCols = {"wr_uid"};
		
		try {
			pstmt = conn.prepareStatement(D.SQL_WRITE_INSERT, generatedCols);
			pstmt.setString(1, subject);
			pstmt.setString(2, content);
			pstmt.setString(3, name);
			
			cnt = pstmt.executeUpdate();
			
			if(cnt > 0){
				// auto-generated key 값 가져오기
				rs = pstmt.getGeneratedKeys();
				if(rs.next()){
					uid = rs.getInt(1);
					dto.setUid(uid);   
				}
			}		
		} finally {
			close();
		}
		
		return cnt;
	}
	
	
	// 글 목록 읽기
	// ResultSet --> List 로 리턴
	public List<WriteDTO> buildList(ResultSet rs) throws SQLException{
		List<WriteDTO> list = new ArrayList<>();
		
		while(rs.next()){
			int uid = rs.getInt("uid");
			String subject = rs.getString("subject");
			String name = rs.getString("name");
			String content = rs.getString("content");
			if(content == null) content = "";
			int viewcnt = rs.getInt("viewcnt");
			
			LocalDateTime regDate = rs.getObject("regdate", LocalDateTime.class);
	
			WriteDTO dto = new WriteDTO(uid, subject, content, name, viewcnt, regDate);
			
			list.add(dto);
		}
		
		return list;
	}
	
	// 전체 SELECT
	public List<WriteDTO> select() throws SQLException {
		List<WriteDTO> list = null;
		try {
			pstmt = conn.prepareStatement(D.SQL_WRITE_SELECT);
			rs = pstmt.executeQuery();
			list = buildList(rs);
		} finally {
			close();
		}
		return list;
	}
	
	// 특정 uid 의 글 하나 SELECT --> List<DTO> 리턴
	// update 에 필요
	public List<WriteDTO> selectByUid(int uid) throws SQLException {
		List<WriteDTO> list = null;
		
		try {
			pstmt = conn.prepareStatement(D.SQL_WRITE_SELECT_BY_UID);
			pstmt.setInt(1, uid);
			rs = pstmt.executeQuery();
			list = buildList(rs);
		} finally {
			close();
		}
		
		return list;
	} // selectByUid
	
	// 특정 uid 글 하나 SELECT + 조회수 증가 : view.jsp
	// viewcnt 로 +1 증가해야 하고, 글 하나 읽어와야 한다, 트랜잭션 처리
	// -> List<DTO> 로 리턴 
	public List<WriteDTO> readByUid(int uid) throws SQLException {
		List<WriteDTO> list = null;
		int cnt = 0;
		
		try {
			// 트랜잭션 처리
			conn.setAutoCommit(false);
			
			pstmt = conn.prepareStatement(D.SQL_WRITE_INC_VIEWCNT);
			pstmt.setInt(1, uid);
			cnt = pstmt.executeUpdate();
			
			pstmt.close();
			
			pstmt = conn.prepareStatement(D.SQL_WRITE_SELECT_BY_UID);
			pstmt.setInt(1, uid);
			rs = pstmt.executeQuery();
			list = buildList(rs);
			
			conn.commit();
		} catch(SQLException e) {
			conn.rollback();
			throw e;
		} finally {
			close();
		}
		
		return list;
	} // end readByUid

	// 특정 uid 글 수정 <- (uid, 제목, 내용)
	public int update(int uid, String subject, String content) throws SQLException {
		int cnt = 0;
		
		try {
			pstmt = conn.prepareStatement(D.SQL_WRITE_UPDATE);
			pstmt.setString(1,  subject);
			pstmt.setString(2, content);
			pstmt.setInt(3, uid);
			cnt = pstmt.executeUpdate();
		} finally {
			close();
		}		
		return cnt;
	} // end update()
	
	// 특정 uid 글 삭제하기
	public int deleteByUid(int uid) throws SQLException{
		int cnt = 0;
		
		try {
			pstmt = conn.prepareStatement(D.SQL_WRITE_DELETE_BY_UID);
			pstmt.setInt(1, uid);
			cnt = pstmt.executeUpdate();
		} finally {
			close();
		}
		
		return cnt;
	}
	
	
} // end DAO





































































