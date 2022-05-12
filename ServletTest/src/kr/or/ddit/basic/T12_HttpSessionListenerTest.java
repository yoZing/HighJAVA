package kr.or.ddit.basic;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class T12_HttpSessionListenerTest extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession httpSession = req.getSession();  // true가 디폴트
		
		httpSession.invalidate(); // 세션 삭제
		
		// 속성값 관련...
		req.getSession().setAttribute("ATTR1", "속성1");
		req.getSession().setAttribute("ATTR1", "속성11");
		req.getSession().setAttribute("ATTR2", "속성2");
		req.getSession().removeAttribute("ATTR1");
		
		// Http세션 영역 내에 HttpSessionBindingListener를 구현한 객체가
		// 바인딩 되면 호출됨.
		MySessionBindingListener bindingListener = new MySessionBindingListener();
		
		req.getSession().setAttribute("obj", bindingListener);
		req.getSession().removeAttribute("obj");
		
		
		
		
		
		
		
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
	
}
