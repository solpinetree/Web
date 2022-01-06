package com.lec.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/board")
public class BoardController {

	@RequestMapping("/list")
	public String listBoard() {
		return "board/list_board";
	}
	
	@RequestMapping("/write")
	public String writeBoard() {
		return "board/write_board";
	}
	
	@RequestMapping("/view")
	public String viewBoard() {
		return "board/view_board";
	}
	
	@RequestMapping("/update")
	public String updateBoard() {
		return "board/update_board";
	}
	
	@RequestMapping("/delete")
	public String deleteBoard() {
		return "board/delete_board";
	}
	
}
