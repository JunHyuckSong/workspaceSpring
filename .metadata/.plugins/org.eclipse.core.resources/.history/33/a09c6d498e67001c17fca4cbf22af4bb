package com.test.app.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.test.app.board.impl.BoardDAO;
import com.test.app.controller.Controller;

public class BoardController implements Controller{

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		BoardVO vo = new BoardVO();
		vo.setBid(Integer.parseInt(request.getParameter("bid")));
		
		BoardDAO dao = new BoardDAO();
		BoardVO data = dao.selectOne(vo);
		
		HttpSession session=request.getSession();
		session.setAttribute("data", data);
		return "board"; // 이 반환값이 DispatcherServlet에서 viewName이됨
		//ViewResolver가 viewName처리
	}

}
