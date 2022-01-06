package com.lec.spring.controller;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.lec.spring.domain.MemberVO;

@Controller
public class SampleController {
	
	@GetMapping("/sample1")
	public void sample1(Model model) {
		// -> /sample1.html   을 템플릿 엔진에 보냄(forwarding 아님!)   + webroot : [templates]
		model.addAttribute("greeting", "hello Thymeleaf");
		model.addAttribute("greeting", "타임리프입니다.");
	}
	
	@GetMapping("/sample2")
	public void sample2(Model model) {
		MemberVO vo = new MemberVO(123,"u00", "p00","홍길동", 
				LocalDateTime.now());
		model.addAttribute("vo", vo);
	}
	
	@GetMapping("/sample3")
	public void sample3(Model model) {
		List<MemberVO> list = new ArrayList<>();
		
		for(int i= 0;i<10;i++) {
			list.add(new MemberVO(123, "u0"+i, "p0"+i, "홍길동"+i, 
					LocalDateTime.now()));
		}
		
		model.addAttribute("list",list);
		
		String [] arr = {"ABC","DEF","GHI"};
		model.addAttribute("arr",arr);
	}
	
    @GetMapping("/sample4")
    public void sample4(Model model) {
        List<MemberVO> list = new ArrayList<>();
        for(int i = 0; i < 10; i++) {
            list.add(new MemberVO(i, "u000" + i % 3, "p0000" + i % 3, "홍길동" + i,
                        LocalDateTime.now()));
        }
        model.addAttribute("list", list);  
        
        model.addAttribute("test1", "aaa");
        model.addAttribute("test2", "");
        model.addAttribute("test3", null);
        model.addAttribute("test4", false);
    }

    @GetMapping("/sample5")
    public void sample5(Model model) {
        String result = "SUCCESS";
        model.addAttribute("result", result);
    }

    @GetMapping("/sample6")
    public void sample6(Model model) {
        List<MemberVO> list = new ArrayList<>();
       
        for(int i = 0; i < 10; i++) {
            list.add(new MemberVO(i, "u0" + i, "p0" + i, "홍길동" + i,
                        LocalDateTime.now()));
        }
       
        model.addAttribute("list", list);      
        model.addAttribute("list2", new ArrayList<>());
        model.addAttribute("list3", null);
    }


    @GetMapping("/sample7")
    public void sample7(Model model) {
        model.addAttribute("now1", LocalDateTime.now());
        model.addAttribute("now2", new Date());  // java.util.Date()
        model.addAttribute("price", 123456789);
        model.addAttribute("title", "This is just a sample.");
        model.addAttribute("options", Arrays.asList("AAAA","BBB","CCC","DDD"));
    }

    @GetMapping("/sample8")
    public void sample8(Model model) {
    	model.addAttribute("value1","John");
    	model.addAttribute("url1","sample1");
    }



}	// end controller
