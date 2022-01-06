package com.lec.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lec.spring.domain.WriteDAO;
import com.lec.spring.domain.WriteDTO;

// Service 단 : Transaction 역할

@Service
public class CouponService {

	WriteDAO dao;
	
	@Autowired
	public void setDao(WriteDAO dao) {
		this.dao = dao;
	}
	
	public CouponService() {
		System.out.println("BoardService() 생성");
	}

	public List<WriteDTO> list() {
		return dao.select();
	}

	public int write(WriteDTO dto) {
		return dao.insert(dto);
	}
	
	// 특정 uid 의 글 읽어오기
	public List<WriteDTO> viewByUid(int uid){
		return dao.selectByUid(uid);  // 읽어오기
	}
	
	// 특정 uid 의 글 읽어오기  (update 에서 필요)
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
	
	
	
	
} // end Service






















