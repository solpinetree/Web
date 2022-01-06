package com.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.command.write.Command;
import com.command.write.DeleteCommand;
import com.command.write.FileUploadCommand;
import com.command.write.ListCommand;
import com.command.write.SelectCommand;
import com.command.write.UpdateCommand;
import com.command.write.ViewCommand;
import com.command.write.WriteCommand;

@WebServlet("*.do")
public class DoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public DoController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		actionDo(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		actionDo(request, response);
	}
	
	protected void actionDo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("actionDo() 호출");
		
		request.setCharacterEncoding("utf-8"); // 한글 인코딩
		
		// URL로부터 URI, ContextPath, Command
		String uri = request.getRequestURI();
		String conPath = request.getContextPath();
		String com = uri.substring(conPath.length());
		
		// 테스트 출력
		System.out.println("uri: " + uri);
		System.out.println("conPath: " + conPath);
		System.out.println("com:" + com);
		
		// 컨트롤러는 아래 두가지를 결정해야 한다.
		Command command = null;  // 어떠한 로직을 수행할지
		String viewPage = null;  // 어떠한 페이지(뷰) 를 보여줄지 결정
		
		// 컨트롤러는 커맨드에 따라, 로직을 수행하고
		// 결과를 내보낼 view 를 결정
		switch(com) {
		case "/list.do":
			command = new ListCommand();
			command.execute(request, response);
			viewPage = "list.jsp";
			break;
			
		case "/write.do":
			viewPage = "write.jsp";
			break;
		
		case "/writeOk.do":
			command = new WriteCommand();
			command.execute(request, response);
			viewPage = "writeOk.jsp";
			break;
			
		case "/view.do":
			command = new ViewCommand();
			command.execute(request, response);
			viewPage = "view.jsp";
			break;
		case "/update.do":
			command = new SelectCommand();  // '수정' 이지만, 일단 읽어오는것부터 시작이다.
			command.execute(request, response);
			viewPage = "update.jsp";
			break;
		case "/updateOk.do":
			command = new UpdateCommand();
			command.execute(request, response);
			viewPage = "updateOk.jsp";
			break;  // 디버깅 훈련, 이 break를 없애고, 찾아보기
		case "/deleteOk.do":
			command = new DeleteCommand();
			command.execute(request, response);
			viewPage = "deleteOk.jsp";
			break;			
			
		// 웹에디터용 파일 업로듳 ㅓ리
		case "/fileUpload.do":
			command = new FileUploadCommand();
			command.execute(request, response);
			break;
		} // end switch
		
		// response 를 위해, 위에서 결정된 페이지(viewPage) 에 forward 해줌.
		if(viewPage != null) {
			RequestDispatcher dispatcher =
					request.getRequestDispatcher("/WEB-INF/views/board/" + viewPage);
			dispatcher.forward(request, response);
		}
		
		
	}

}





























