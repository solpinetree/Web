package com.command.write;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lec.beans.WriteDAO;
import com.lec.beans.WriteDTO;

public class DeleteCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		int cnt = 0;
		WriteDAO dao = new WriteDAO(); 	//DAO 객체 생성
		
		int uid = Integer.parseInt(request.getParameter("uid"));	//	매개변수 검증 필요
		
		
		try {
			// 트랜잭션 수행
			cnt = dao.deleteByUid(uid);
			request.setAttribute("result", cnt);
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		request.setAttribute("result", cnt);
	}


}
