package com.lec.spring;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.lec.spring.domain.WriteDTO;

@Controller
public class HomeController {
	
	//@RequestMapping(value = "/member/delete")	// 어떤 방식 GET, POST .. 이든지 모두 매핑 함.
	@RequestMapping(value = "/member/delete", method=RequestMethod.GET)	// GET방식 request 만 매핑함
	//public void delMember(HttpServletRequest request, Model model) {
	public void delMember(Model model, HttpServletRequest request) {	// 핸들러 매개변수 순서 바뀌어도 잘 동작!
		String id = request.getParameter("id");
		model.addAttribute("mbId",id);
	}
	
//	@RequestMapping(value = "/member/regOk", method=RequestMethod.GET)
	@GetMapping("member/regOk")
	public void registGET() {
		System.out.println("/member/regOk : GET");
	}
	
//	@RequestMapping(value = "/member/regOk", method=RequestMethod.POST)
	@PostMapping("member/regOk")
	public void registPOST() {
		System.out.println("/member/regOk : POST");
	}
	
	// GET, POST 두가지를 매핑하려면
	@RequestMapping(value = "/member/regOk2", method = {RequestMethod.GET, RequestMethod.POST})
	public String regOkMember2(HttpServletRequest request) {
		System.out.println("/member/regOk2 : " + request.getMethod());
		return "member/regOk";
	}
	
	// PUT, DELETE, PATCH 방식
	// [!] JSP 를 뷰로 사용하는 경우 forwarding 하는 과정에서 405 에러 발생함.
	// 	"error": "Method Not Allowed",
	// "message" : "JSPs only permit GET, POST, or HEAD. Jasper also permits OPTIONS"
	@PutMapping("member/regOk")
	public void registPut() {
		System.out.println("/member/regOk : PUT");
	}
	
	@DeleteMapping("member/regOk")
	public void registDelete() {
		System.out.println("/member/regOk : DELETE");
	}
	
	@PatchMapping("member/regOk")
	public void registPatch() {
		System.out.println("/member/regOk : PATCH");
	}
	
	@RequestMapping("/member/regist")
	public void registMember() {
	}
	
	//-----------------------
	
	@RequestMapping("member/find")
//	public void findMember(String id, String name, Model model) {
//		System.out.println("member/find : id ="+id+" name= "+name);
//		model.addAttribute("id", id);
//		model.addAttribute("name", name);
//	}
	// 숫자 타입이면 PARsing 하여 받을 수 있다. 
//	public void findMember(Double id, String name, Model model) {	// primitive 타입인데, parameter 에 없는 경우 에러 발생
//		System.out.println("member/find : id ="+id+" name= "+name);	// wrapper 타입이면, parameter 없어도 Null 값으로받아옴.
//		model.addAttribute("id", id);
//		model.addAttribute("name", name);
//	}
	// 동일한 Name 의 parameter(들) --> '배열' 매개변수로 받을 수 있다.
//	public void findMember(int [] id, String [] name, Model model) {	
//		System.out.println("member/find : id ="+Arrays.toString(id)+" name= "+Arrays.toString(name));	
//		model.addAttribute("id", Arrays.toString(id));
//		model.addAttribute("name", Arrays.toString(name));
//	}
	
	//만약 request parameter 의 name 과 매개변수가 같을 수 없는 상황이면 
//	public void findMember(
//			@RequestParam("id") String userid,	// id 란 name 의 parameter 값을 userid 매개변수가 받는다 
//			@RequestParam("name") String username, 
//			Model model) {
//	System.out.println("member/find : id ="+userid+" name= "+username);
//	model.addAttribute("id", userid);
//	model.addAttribute("name", username);
//	}
	
	// 위의 경우 ID 값이 없거나 변환 불가능하면 에러 발생한다.
	// @RequestParma(value="test", required=fales, defaultValue="0")을 이용하면 가능하긴 하다. 
	// 또한, @RequestParam 과 Map<name, value> 을 사용하면 된다.
//	public void findMember(
//			@RequestParam(value= "id", required=false, defaultValue="0") String userid,	// id 란 name 의 parameter 값을 userid 매개변수가 받는다 
//			@RequestParam("name") String username, 
//			Model model) {
//	System.out.println("member/find : id ="+userid+" name= "+username);
//	model.addAttribute("id", userid);
//	model.addAttribute("name", username);
//	}	
	
	// 또한, @RequestParam 과 Map<name, value> 을 사용하면 된다.
	public void findMember(
			@RequestParam	Map<String, String> map, 
			Model model) {
	System.out.println("member/find : id ="+map.get("id")+" name= "+map.get("name"));
	model.addAttribute("id", map.get("id"));
	model.addAttribute("name", map.get("name"));
	}	
	
	// ----------------------------------------------------------------------------
	// 커맨드 객체 (Command Object) 사용
	
	// 게시글 등록 form
	@RequestMapping("/board/write")
	public void writeBoard() {
		

	}
	
	// 기존방식
	// 매 parameter 들을 매개변수화 하는 것은 힘들다.
	@PostMapping("/board/writeOk")
//	public void writeOkBoard(
//			Model model, 
//			@RequestParam("name") String name, 
//			@RequestParam("subject") String subject, 
//			@RequestParam("content") String content
//			) {
//		WriteDTO dto = new WriteDTO();
//		dto.setName(name);
//		dto.setSubject(subject);
//		dto.setContent(content);
//		System.out.println(dto);
//		
//		model.addAttribute("dto",dto);
//	}
	
	// 커맨드 객체 사용
	// 잔코딩이 매우 많이 줄어든다.
//	public void writeOkBoard(WriteDTO dto) {
//		System.out.println(dto);
//	}

	//@ModelAttribute : 커맨드 객체의 model attribute 이름을 변경할 수 있다.
	public void writeOkBoard(@ModelAttribute("DTO") WriteDTO dto) {
		System.out.println(dto);
	}
	
	// ---------------------------------------------------
	// @ParamVariable 사용
	@RequestMapping("/board/writePath/{name}/{subject}/{content}")
	public String writePathBoard(
			Model model,
			@PathVariable String name,
			@PathVariable String subject, 
			@PathVariable String content
			) {
		
		model.addAttribute("name", name);
		model.addAttribute("subject", subject);
		model.addAttribute("content", content);
		
		return "board/writepath";
	}
	
	// --------------------------------------------
	// redirect:
	@RequestMapping("/member/ageCheck")
	public String chkAge(int age
			, RedirectAttributes redirectAttrs
			) {
		redirectAttrs.addAttribute("age", age);
		if(age<19) {
			return "redirect:/member/underAge";
		}else {
			return	"redirect:/member/adult";
		}
	}
	
	@RequestMapping("/member/underAge")
	public String pageUnderAge(Model model,
			@RequestParam("age") int age) {
		model.addAttribute("age", age);
		return "member/ageUnder";
	}
	
	@RequestMapping("/member/adult")
	public String pageAdult(Model model,
			@RequestParam("age") int age) {
		model.addAttribute("age",age);
		return "member/ageAdult";
	}
}	// end controller
