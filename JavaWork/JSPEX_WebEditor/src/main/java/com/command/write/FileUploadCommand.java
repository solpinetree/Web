package com.command.write;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.oreilly.servlet.multipart.FileRenamePolicy;

public class FileUploadCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String saveDirectory = "";
		//saveDirectory = "/Users/sollee/Desktop/tomcat/upload";
		
		ServletContext context = request.getServletContext();
		// 서블릿 상의 upload 폴더 경로를 알아온다
		saveDirectory = context.getRealPath("ckupload");
		
		System.out.println("업로드 경로: "+ saveDirectory);
		
		int maxPostSize = 5*1024*1024; 	// POST 받기, 최대 5M byte
		String encoding = "utf-8";	//	인코딩
		FileRenamePolicy policy = new DefaultFileRenamePolicy(); // 업로딩 파일 이름 중복에 대한 rename 정책
		
		MultipartRequest multi = null;
		
		// MultipartRequest 생성 단계에서 이미 파일 저장까지 마무리 됨.
		try {
			multi = new MultipartRequest(
					request,	// 내부객체 request
					saveDirectory, 	// 업로드된 파일 저장 경로
					maxPostSize, 	// 최대 파일 크기(post 크기)
					encoding, 
					policy
					);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		Enumeration names = null;
		String name = null; //parameter로 넘어오는 name 값
		String originalFileName = null;	// 원본파일이름
		String fileSystemName = null;	// 실제 저장되는 파일 이름
		String fileType = null;	//	 파일 MIME 타입
		String fileUrl = null;	// 업로드된 파일의 URL --> 나중에 ckeditor로의 response에 담겨야 한다. 
		
		// 2. File 정보 추출
		names = multi.getFileNames();	// type='file' 요소 name(들) 추출
		while(names.hasMoreElements()){
			name = (String)names.nextElement();
			System.out.println("input name: "+ name );
			
			// 원본 파일 이름
			originalFileName = multi.getOriginalFileName(name);
			System.out.println("원본파일 이름: "+originalFileName);
			
			// 업로딩된 파일 이름
			fileSystemName = multi.getFilesystemName(name);
			System.out.println("파일시스템 이름: "+fileSystemName);
			
			// 업로딩된 파일의 타입 : MIME 타입
			fileType = multi.getContentType(name);
			System.out.println("파일타입: "+fileType);
			
			// 파일 url
			fileUrl = request.getContextPath() + "/ckupload/" + fileSystemName;
			System.out.println("fileUrl: "+fileUrl);
			
		}	//	 end while
		
		// CKEDITOR 측에 보내줄 response(JSON)
		
		String jsonString= "{\n"
				+ "    \"uploaded\": 1,\n"
				+ "    \"fileName\": \""+fileSystemName+"\",\n"
				+ "    \"url\": \""+ fileUrl+"\"\n"
				+ "}\n"
				+ "";
		
		
		try {
			response.setContentType("application/json; charset=utf-8");
			response.getWriter().write(jsonString);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
