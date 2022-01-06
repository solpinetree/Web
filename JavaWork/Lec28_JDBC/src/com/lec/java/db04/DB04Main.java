package com.lec.java.db04;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.lec.java.db.Query;

/* auto-generated keys 값
 * 	SEQUENCE (ORACLE),  AUTO_INCREMENET (mysql),  IDENTITY (mssql) 등으로
 *  새로운 레코드 INSERT 시 자동 생성된 key 값 알아내기
 *  
 *  ex) 새로운 게시글 작성시 첨부파일(들) 도 같이 저장되어야 할때.
 *      먼저 게시글 이 먼저 INSERT 된뒤 auto-generated key 값을 얻어와서 첨부파일을 저장해야 한다.    
 */
public class DB04Main implements Query {

	public static void main(String[] args) {
		System.out.println("DB 4 - generated id값");
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		// 자동생성되는 컬럼의 이름(들) 이 담긴 배열 준비 (auto-generated keys 배열)
		String[] generatedCols = {"mb_no"};
		
		try {
			// OracleDriver 클래스를 메모리에 로딩
			Class.forName(DRIVER);
			System.out.println("드라이버 클래스 로딩 성공");
			
			// DB Connection
			conn = DriverManager.getConnection(URL, USER, PASSWD);
			System.out.println("DB Connection 성공");
			
			System.out.println();
			System.out.println("INSERT");
			// Statement 나 PreparedStatement 생성시 두번째 매개변수로 auto-generated keys 배열 넘겨줌
			pstmt = conn.prepareStatement(SQL_INSERT, generatedCols);
			pstmt.setString(1,  "로키");
			pstmt.setInt(2, 200);
			int cnt = pstmt.executeUpdate();
			System.out.println(cnt + "개 행(row) INSERT 성공");
			
			// auto-generated keys 값 뽑아오기
			pstmt.getGeneratedKeys();
						
			// SELECT -> executeQuery()
			System.out.println();
			System.out.println("SELECT");
			pstmt = conn.prepareStatement(SQL_SELECT_ALL);
			
			// SQL 전송/실행
			rs = pstmt.executeQuery();
			if(rs.next()) {
				long no = rs.getLong(1);
				System.out.println("Generated Key (mb_no) = " + no);
			}
						
			while (rs.next()) {
				String no = rs.getString("mb_no");
				String name = rs.getString("mb_name");
				String birthdate = rs.getString("mb_regdate");
				System.out.println(no + " | " + name + " | " + birthdate);
			} // end while
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			// SQL 에러 메세지는 SQLException 에서 확인가능
			System.out.println("SQL 에러: " + e.getMessage());
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (pstmt != null) {
					pstmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} // end try-catch

	} // end main()

} // end class DB03Main






















