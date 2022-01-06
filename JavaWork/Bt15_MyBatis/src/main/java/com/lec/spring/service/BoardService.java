package com.lec.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lec.spring.domain.WriteDAO;
import com.lec.spring.domain.WriteDTO;

// Service 단 : Transaction 역할

@Service
public class BoardService {

	WriteDAO dao;
	
	@Autowired
	public void setDao(WriteDAO dao) {
		this.dao = dao;
	}

	public BoardService() {
		System.out.println("BoardService() 생성");
	}

	public List<WriteDTO> list() {
		return dao.select();
	}
	
	public int write(WriteDTO dto) {
		return dao.insert(dto);
	}
	
	// 특정 uid의 글 읽어오기, + 조회수 증가
	@Transactional	// 해당 메소드는 하나의 트랜잭션으로 처리함.  
	public List<WriteDTO> viewByUid(int uid){
		dao.incViewCnt(uid);	// 조회수 증가
		return dao.selectByUid(uid);	// 읽어오기
	}
	
	// 특정 uid의 글 읽어오기 (update)
	public List<WriteDTO> selectByUid(int uid){
		return dao.selectByUid(uid);
	}
	
	// 글 수정
	public int update(WriteDTO dto) {
		return dao.update(dto);
	}
	
	// 글 삭제
	public int deleteByUid(int uid) {
		return dao.deleteByUid(uid);
	}
	
}
