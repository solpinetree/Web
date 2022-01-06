package com.lec.spring.controller;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lec.spring.domain.WriteDAO;
import com.lec.spring.domain.WriteDTO;

@RestController
@RequestMapping("/MyRest")
public class MyRestController {

	private WriteDAO mapper;
	
	@Autowired
	public MyRestController(SqlSession sqlSession) {
		mapper = sqlSession.getMapper(WriteDAO.class);
	}
	
	// 테스트 데이터
	@RequestMapping("/")
	public String helloTEXT() {
		return "<h2>Hello <i>REST</i></h2>"; 	// 리턴되는 문자열을 response	
	}
	
	// 객체 리턴 -> JSON
	@RequestMapping("helloJSON")
	public WriteDTO helloJSON(){
		WriteDTO dto = new WriteDTO(100,"안녕하세요","REST","김동호", 123, LocalDateTime.now());
		return dto;
	}
	
	// JSON 배열 <- 자바 List<T>
	@RequestMapping("/listJSON")
	public List<WriteDTO> listJSON(){
		List<WriteDTO> list = mapper.select();
		return list;
	}
	
	// JSON 배열 <- 자바 배열
	@RequestMapping("/arrJSON")
	public WriteDTO [] arrJSON(){
		List<WriteDTO> list = mapper.select();
		WriteDTO[] arr = new WriteDTO[list.size()];
		return list.toArray(arr);
	}
	
	// JSON object <- 자바 Map<k, v>
	@RequestMapping("/mapJSON")
	public Map<Integer, WriteDTO> mapJSON(){
		List<WriteDTO> list = mapper.select();
		
		Map<Integer, WriteDTO> map = new HashMap<Integer, WriteDTO>();
		
//		for(WriteDTO dto : list) {
//			map.put(dto.getUid(), dto);
//		}
		
		list.forEach(dto -> map.put(dto.getUid(), dto));
		
		return map;
	}
	
//	@RequestMapping("/read/{uid}")
//	public List<WriteDTO> read(@PathVariable("uid") int uid){
//		return mapper.selectByUid(uid);
//	}
	
	@RequestMapping("/read/{uid}")
	public ResponseEntity<List<WriteDTO>> read(@PathVariable("uid") int uid){
		List<WriteDTO> list = mapper.selectByUid(uid);
		
		// 실패
		if(list==null || list.size() ==0) {
			return new ResponseEntity<List<WriteDTO>>(HttpStatus.NOT_FOUND);	//	404
		}
		
		// 성공
		return new ResponseEntity<>(list, HttpStatus.OK);	//	200
	}
	
}
