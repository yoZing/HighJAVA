package kr.or.ddit.member.controller;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.member.service.IMemberService;
import kr.or.ddit.member.service.MemberServiceImpl;
import kr.or.ddit.member.vo.MemberVO;

@WebServlet("/member/delete.do")
public class DeleteMemberServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// 1. 파라미터정보 가져오기
		String memId = req.getParameter("memId");
		
		// 2. 서비스 객체 가져오기
		IMemberService memberService = MemberServiceImpl.getInstance();
		
		// 3. 회원정보 삭제
		int cnt = memberService.delete(memId);
		
		String msg = "";
		
		if(cnt > 0 ) {
			msg = "성공";
		} else {
			msg = "실패";
		}
		
		
		// 4. 목록 조회화면으로 이동
//		req.getRequestDispatcher("/member/list.do").forward(req, resp);
		
		String redirectrUrl = req.getContextPath() + "/member/list.do?msg=" + URLEncoder.encode(msg, "UTF-8");
//				
		resp.sendRedirect(redirectrUrl); // 목록조회 화면으로 리다이렉트
		
//		// 결과를 VIEW화면에 출력하기
//		req.getRequestDispatcher("/views/member/insert.do").forward(req, resp);
		
		
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
