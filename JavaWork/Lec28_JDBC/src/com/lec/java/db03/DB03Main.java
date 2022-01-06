package com.lec.java.db03;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.lec.java.db.Query;

// 공통적으로 사용하는 상수들 인터페이스에 담아서 처리.
public class DB03Main implements Query {

	public static void main(String[] args) {
		System.out.println("DB 3 - PreparedStatement");
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		int cnt = 0;
		
		try {
			Class.forName(DRIVER);
			System.out.println("드라이버 클래스 로딩 성공");
			
			conn = DriverManager.getConnection(URL,USER, PASSWD);
			System.out.println("DB connection 성공");
			
			// PreparedStatement 인스턴스 생성
			System.out.println("INSERT");
			pstmt = conn.prepareStatement(SQL_INSERT);	// (?,?)
			// "INSERT INTO test_member(mb_name, mb_age) VALUES(?, ?)"
			pstmt.setString(1, "헐크");	// 첫번째 ? 는 1번
			pstmt.setInt(2,  36);	// 두번째 ?
			cnt += pstmt.executeUpdate(); // 쿼리 실행
			
			pstmt.setString(1,  "호슨배");
			pstmt.setInt(2,  40);
			cnt += pstmt.executeUpdate();
			
			System.out.println(cnt + "개 행(row) INSERT 성공");
			
			pstmt.close();   // 재할당 받기전에 꼭 자원 해제!
			
			// UPDATE
			pstmt = conn.prepareStatement(SQL_UPDATE_REGDATE);
			
			pstmt.setString(1, "1968-08-16");
			pstmt.setInt(2, 10);
			
			cnt=pstmt.executeUpdate();
			System.out.println(cnt+"개 행(row) UPDATE 성공");
			
			
			// SELECT 
			System.out.println("SELECT");
			pstmt.close();
				
			pstmt = conn.prepareStatement(SQL_SELECT_BY_NAME);
			String name = "마징가";
			
			pstmt.setString(1,  name);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				int no = rs.getInt("no");	// mb_no로 하면 안된다!
				String nm = rs.getString("name");
				int age = rs.getInt("age");
				
				System.out.printf("%d \t| %s \t| %d\n", no, nm, age);
			}
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
				try {
					if(rs != null)	rs.close();
					if(pstmt != null)	pstmt.close();
					if(conn!=null) conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
	} // end main()

} // end class DB03Main






















