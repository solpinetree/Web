package com.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.command.write.AjaxListCommand;
import com.command.write.Command;
import com.command.write.ListCommand;

@WebServlet("*.ajax")
public class AjaxController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AjaxController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ajaxAction(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ajaxAction(request, response);
	}

	protected void ajaxAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("ajaxAction() 호출");
		
		request.setCharacterEncoding("utf-8");
		
		// URL로부터 URI, ContextPath, Command
		String uri = request.getRequestURI();
		String conPath = request.getContextPath();
		String com = uri.substring(conPath.length());
		
		// 테스트 출력
//		System.out.println("uri: " + uri);
//		System.out.println("conPath: " + conPath);
//		System.out.println("com:" + com);
//		
		Command command = null;  // 어떠한 로직을 수행할지
		
		// 컨트롤러는 커맨드에 따라, 로직을 수행
		switch(com) {
		case "/list.ajax":  // 글목록 AJAX요청
			// 일단 글 목록 읽기
			new ListCommand().execute(request, response);
			// 읽어온 데이터를 다음 커맨드에 넘겨줌.
			new AjaxListCommand().execute(request, response);
			break;
		} // end switch
					
		// 트랜잭션 처리하고 결과를 html 이 아닌 '데이터로'
		// response 할것이기 땜에 jsp forwarding 불필요
		
	}  // end ajaxAction()

	
	
	
} //end Controller




















