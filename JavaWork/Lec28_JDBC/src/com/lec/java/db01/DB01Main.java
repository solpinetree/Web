package com.lec.java.db01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/*
JDBC (Java DataBase Connectivity) 사용
 0. 라이브러리(jar) 추가:
  1) 이클립스 프로젝트 폴더에 libs 폴더를 생성
  2) mysql/mysql-connctor-java/8.0.26 MYSQL J Connector 라이브러리 다운로드
  3) 복사한 라이브러리를 빌드패스에 추가   
		BulidPath - Configure Build Path..
		Libraries 탭에서  [Add JARs..]   ->  위 libs 폴더의 jar 파일 추가
		Order and Export 탭에서  우선순위 Up (권장)

 1. MySQL 연동을 위한 정보들(상수들)을 정의(세팅)
 2. JDBC 드라이버 클래스를 메모리에 로드
 3. DB와 connection(연결)을 맺음
 4. Statement 인스턴스를 생성 (SQL을 사용하기 위한 인스턴스)
 5. SQL 문장 작성(SELECT, INSERT, UPDATE, DELETE)
 6. SQL 문장을 DB 서버로 전송
 7. 실행 결과 확인
 8. 리소스 해제
*/

// er-diagram 만들기
// http://ermaster.sourceforge.net/update-site


public class DB01Main {

	// 1. MySQL 연동을 위한 정보들(상수들)을 정의(세팅)
	// JDBC 드라이버 클래스 정보
	public static final String DRIVER = "com.mysql.cj.jdbc.Driver";
	
	// DB 서버 정보
	public static final String URL = "jdbc:mysql://localhost:3306/mydb811";
	
	// DB 사용자 계정 정보
	public static final String USER = "myuser811";
	public static final String PASSWD = "1234";
		
	public static void main(String[] args) {
		System.out.println("DB 1 : JDBC 프로그래밍");
		
		Connection conn = null;
		Statement stmt = null;		// java.sql.Statement
		ResultSet rs = null;
		
		try {
			//  2. JDBC 드라이버 클래스를 메모리에 로드
			Class.forName(DRIVER);	// <-- 동적 클래스 로딩(메소드 영역에 로딩됨)
			System.out.println("드라이버 클래스 로딩 성공");
			
			// 3. DB와 connection(연결)을 맺음
			conn = DriverManager.getConnection(URL, USER, PASSWD);
			System.out.println("DB connect 성공");
			
//			4. Statement 인스턴스를 생성 (SQL을 사용하기 위한 인스턴스)
			stmt=conn.createStatement();
			System.out.println("Statement 생성 성공");
			
//			 5. SQL 문장 작성(SELECT, INSERT, UPDATE, DELETE)
			String sql_insert="INSERT INTO test_member(mb_name, mb_age) VALUES('마징가',25)";
			System.out.println(sql_insert);
			
//			 6. SQL 문장을 DB 서버로 전송
			int cnt = stmt.executeUpdate(sql_insert);	// 'DML'의 경우 executeUpdate()로 실행. 리턴값은 정수(Int)
			System.out.println(cnt + "개 row(행)이 INSERT 됨");
			
			System.out.println();
			
			String sql_select="SELECT * FROM test_member";
			System.out.println(sql_select);

			rs = stmt.executeQuery(sql_select);	// 'SELECT 및 기타쿼리' 의 경우 executeQuery()로 실행
												// 리턴값은 ResultSet 객체
			
//			 7. ResultSet에서 result 데이터 확인
			
			// 7-1 컬럼 이름으로 확인
//			while(rs.next()) {	//	next() 레코드 하나 추출하고 true 리턴. 추출할 레코드 없으면 false 리턴 
//				String no = rs.getString("mb_no");	// getXXX() 에 '컬럼명' 혹은 '별명' 명시
//				String name = rs.getString("mb_name");
//				String age = rs.getString("mb_age");
//				String regDate = rs.getString("mb_regdate");
//				String result = String.format("%s \t| %s \t| %s \t| %s",no, name, age,regDate);
//				System.out.println(result);
//			}
			
			// 7-2 컬럼 인덱싱으로 받기
//			while(rs.next()) {	//	next() 레코드 하나 추출하고 true 리턴. 추출할 레코드 없으면 false 리턴 
//				String no = rs.getString(1);	// getXXX() 에 컬럼 인덱스 명시 (1부터 시작!)
//				String name = rs.getString(2);
//				String age = rs.getString(3);
//				String regDate = rs.getString(4);
//				String result = String.format("%s \t| %s \t| %s \t| %s",no, name, age,regDate);
//				System.out.println(result);
//			}
			
			// 7-3 개별적인 타입으로 받기
			while(rs.next()) {
				int no = rs.getInt("mb_no");
				String name = rs.getString("mb_name");
				int age = rs.getInt("mb_age");
				LocalDateTime localDateTime = null;
				localDateTime = rs.getObject("mb_regdate", LocalDateTime.class);
				String result = String.format("%s \t| %s \t| %s \t| %s",no, name, age,
						localDateTime.format(DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss")));
				System.out.println(result);
			}
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			// 8. 리소스 해제
			try {
				// 나중에 만들어진 인스턴스부터 close 한다.
				rs.close();
				stmt.close();	
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		System.out.println("프로그램 종료");
	} // end main()

} // end class DB01Main













