package com.lec.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/member")	// -> /member 로 시작하는 request 를 처리하는 class 
public class MemberController {	// 처리하는 컨트롤러 클래스
	
		@RequestMapping("/save")	// -> /member + /save 
		public String saveMember() {	// -> = /member/save
			return "member/save";
		}
		
		@RequestMapping("/load")	// -> /member + /load 
		public String loadMember() {	// -> = /member/load
			return "member/load";
		}

		// mapping url 중복되면 에러! <- 서버가동시점에서 에러
//		@RequestMapping("/search")	// -> /member + /search 
//		public String searchMember() {	// -> = /member/search
//			return "member/search";
//		}
		
		// 핸들러 리턴값이 void 이면
		// mapping 되는 url문자열에 해당하는 .jsp 파일로 forwarding 된다
		// (일반적으로 많이 사용)
		@RequestMapping("/remove")	// -> /member + /remove
		public void removeMember() {	// 	=> /member/remove
										// JSP -> /member/remove.jsp
		}

}
