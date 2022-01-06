package com.command.write;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lec.beans.WriteDAO;
import com.lec.beans.WriteDTO;

public class UpdateCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		WriteDAO dao = new WriteDAO();
		int cnt = 0;
		
		// 입력한 값 받아오기
		int uid = Integer.parseInt(request.getParameter("uid"));
		String subject = request.getParameter("subject");
		String content = request.getParameter("content");
		

		// 유효성 체크
		if(subject!=null&&subject.trim().length()>0) {
			try {
				cnt=dao.update(uid, subject, content);
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}	//	end if
		
		request.setAttribute("result", cnt);
	}

}
