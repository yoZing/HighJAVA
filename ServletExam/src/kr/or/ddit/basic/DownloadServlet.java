package kr.or.ddit.basic;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/download")
public class DownloadServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String fileName = "Tulips.jpg";
		
		// 파일 다운로드 처리를 위한 응답헤더 정보 설치하기
		resp.setContentType("image/jpeg");
//		resp.setHeader("Content-Disposition", "; filename=\"" + fileName + "\"");
		/*
		Content-Disposition 헤더에 대하여...
		
		1. response header에서 사용되는 경우... ex) 파일 다운로드
		  Content-Disposition: inline (default)
		  Content-Disposition: attachment  // 파일 다운로드
		  Content-Disposition: attachment; filename="a.jpg"  // 해당 이름으로 파일 다운로드
		*/
		BufferedInputStream bis = new BufferedInputStream(new FileInputStream("D:\\D_Other\\download/대나무숲.jfif"));
		BufferedOutputStream bos = new BufferedOutputStream(resp.getOutputStream());
		
		int c = 0;
		while ((c = bis.read()) != -1) {
				bos.write(c);
		}
		bis.close();
		bos.close();
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
