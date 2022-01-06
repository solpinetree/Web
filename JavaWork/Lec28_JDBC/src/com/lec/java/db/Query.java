package com.lec.java.db;

public interface Query {
	// 1. MySQL 연동을 위한 정보들(상수들)을 정의(세팅)
	// JDBC 드라이버 클래스 정보
	public static final String DRIVER =
			"com.mysql.cj.jdbc.Driver";
	// DB 서버 정보
	public static final String URL =
			"jdbc:mysql://localhost:3306/mydb811";
	// DB 사용자 계정 정보
	public static final String USER = "myuser811";
	public static final String PASSWD = "1234";
	
	// PreparedStatement에서 사용될 SQL 문장
	public static final String SQL_SELECT_ALL =
			"SELECT * FROM test_member";
	
	public static final String SQL_INSERT =
			"INSERT INTO test_member(mb_name, mb_age) VALUES(?, ?)";
	
	public static final String SQL_UPDATE_REGDATE=
			"UPDATE test_member "
			+ "SET mb_regdate = ? "
			+ "WHERE mb_no = ?"		
			;

	public static final String SQL_SELECT_BY_NAME =
			"SELECT mb_no no, mb_name name, mb_age age FROM test_member "
			+ "WHERE mb_name = ? "
			+ "ORDER BY mb_no DESC"
			;
} // end Query(I)
