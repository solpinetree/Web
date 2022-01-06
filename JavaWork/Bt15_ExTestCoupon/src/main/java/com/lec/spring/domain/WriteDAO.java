package com.lec.spring.domain;

import java.util.List;

public interface WriteDAO {

	// 전체 목록 읽기
	List<WriteDTO> select();

	int insert(WriteDTO dto);
	
	// 특정 uid 글 내용 읽기, 조회수 증가
	// viewcnt 도 1 증가 해야 하고, 읽어와야 한다. --> 트랜잭션 처리
	//public abstract List<WriteDTO> readByUid(int uid);
	
	// 특정 uid 글 내용 읽기,
	public abstract List<WriteDTO> selectByUid(int uid);
	
	// 특정 uid 글 수정 ( 제목, 내용 )
	public abstract int update(WriteDTO dto);
	
	// 특정 uid 글 삭제하기
	public abstract int deleteByUid(int uid);
	
	

}
