package com.lec.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/ConPath")
public class ContextPath extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public ContextPath() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// URL : Uniform Resource Locator
		StringBuffer url = request.getRequestURL();
		// URI : Uniform Resource Identifier
		String uri = request.getRequestURI();
		// Context Path
		String conPath = request.getContextPath();
		// domain 추출
		String url_domain = request.getScheme() + "://" + request.getServerName()+":"+request.getServerPort();
		
		
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println("URL: "+url+"<br>");
		out.println("URI: "+uri+"<br>");
		out.println("ContextPath: "+conPath+"<br>");		
		out.println("URL_domain: "+url_domain+"<br>");
		out.println("<hr>");
		
		out.flush();
		out.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
