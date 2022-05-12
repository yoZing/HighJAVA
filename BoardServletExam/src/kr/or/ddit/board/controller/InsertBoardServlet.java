package kr.or.ddit.board.controller;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.board.service.BoardService;
import kr.or.ddit.board.service.IBoardService;
import kr.or.ddit.board.vo.BoardVO;

@WebServlet("/board/insert.do")
public class InsertBoardServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/views/board/insert.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// 1. 요청 파라미터 정보 가져오기
		String boardTitle = req.getParameter("boardTitle");
		String boardWriter = req.getParameter("boardWriter");
		String boardContent = req.getParameter("boardContent");
		
		// 2. 서비스 객체 생성하기
		IBoardService boardService = BoardService.getInstance();
		
		// 3. 게시글 정보 등록
		BoardVO bv = new BoardVO();
		
		bv.setBoardTitle(boardTitle);
		bv.setBoardWriter(boardWriter);
		bv.setBoardContent(boardContent);
		
		int cnt = boardService.newPost(bv);
		
		String msg = "";
		
		if (cnt > 0) {
			msg = "성공";
		} else {
			msg = "실패";
		}
		
		req.setAttribute("msg", msg);
		
		// 목록 조회화면으로 이동
//		req.getRequestDispatcher("/WEB-INF/views/board/insert.jsp").forward(req, resp);
		
		// redirect 방식
		 String redirectUrl = req.getContextPath() + "/board/insert.do?msg=" + URLEncoder.encode(msg, "UTF-8");
		// resp.sendRedirect(redirectUrl); // 목록조회 화면으로 리다이렉트
		
	}
}
