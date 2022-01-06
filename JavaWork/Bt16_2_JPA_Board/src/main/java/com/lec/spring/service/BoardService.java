package com.lec.spring.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lec.spring.domain.Write;
import com.lec.spring.repository.WriteRepository;

// Service 단 : Transaction 역할

@Service
public class BoardService {

	private WriteRepository repository;
	
	@Autowired
	public void setRepository(WriteRepository repository) {
		this.repository = repository;
	}

	public BoardService() {
		System.out.println("BoardService() 생성");
	}

	public List<Write> list() {
		return repository.findAll(Sort.by(Direction.DESC, "uid"));
	}
	
	public int write(Write dto) {
		dto.setRegDate(LocalDateTime.now());
		repository.saveAndFlush(dto);
		return 1;
	}
	
	// 특정 uid의 글 읽어오기, + 조회수 증가
	@Transactional	// 해당 메소드는 하나의 트랜잭션으로 처리함.  
	public List<Write> viewByUid(long uid){
		
		List<Write> list = new ArrayList<>();
		
		Write data = repository.findById(uid).orElse(null);
		if(data != null) {
			data.setViewCnt(data.getViewCnt()+1);
			repository.saveAndFlush(data);
			list.add(data);
		}
		;	// 조회수 증가
		return list;	// 읽어오기
	}
	
	// 특정 uid의 글 읽어오기 (update에서 필요함)
	public List<Write> selectByUid(long uid){
		List<Write> list = new ArrayList<>();
		list.add(repository.findById(uid).orElse(null));
		return list;
	}
	
	// 글 수정
	public int update(Write dto) {
		int cnt = 0;
		Write data = repository.findById(dto.getUid()).orElse(null);
		if(data != null) {
			data.setContent(dto.getContent());
			data.setSubject(data.getSubject());
			repository.saveAndFlush(data);	// UPDATE
			cnt = 1;
		}
		
		return cnt;
	}
	
	// 글 삭제
	public int deleteByUid(long uid) {
		repository.deleteById(uid);
		return 1;
	}
	
}	//	end Service
