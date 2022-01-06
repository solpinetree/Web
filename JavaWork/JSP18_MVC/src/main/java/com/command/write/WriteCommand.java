package com.command.write;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lec.beans.WriteDAO;
import com.lec.beans.WriteDTO;

public class WriteCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		int cnt = 0;
		WriteDAO dao= new WriteDAO();
		
		
		// 입력한 값 받아오기
		String name = request.getParameter("name");
		String subject = request.getParameter("subject");
		String content = request.getParameter("content");
		
		WriteDTO dto = new WriteDTO();
		dto.setName(name);
		dto.setSubject(subject);
		dto.setContent(content);
		
		// 유효성 체크
		if(name!=null&&subject!=null&&name.trim().length()>0&&subject.trim().length()>0) {
			try {
				cnt=dao.insert(dto);
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		
		request.setAttribute("result", cnt);
		request.setAttribute("dto",dto);	//	auto-generated key(uid)
	}

}
