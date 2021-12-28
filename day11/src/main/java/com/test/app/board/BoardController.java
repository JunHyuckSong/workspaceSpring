package com.test.app.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.test.app.board.impl.BoardDAO;

public class BoardController implements Controller{

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
		BoardVO vo = new BoardVO();
		vo.setBid(Integer.parseInt(request.getParameter("bid")));
		
		BoardDAO dao = new BoardDAO();
		BoardVO data = dao.selectOne(vo);
		
		//HttpSession session=request.getSession();
		//session.setAttribute("data", data);
		//ModelAndView 방식을 이용하면 더이상 session에 담아두지 않아도 된다.
		
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("data", data);
		mav.setViewName("board");
		//return "board"; // 이 반환값이 DispatcherServlet에서 viewName이됨
		//ViewResolver가 viewName처리
		
		return mav;
	}

}
