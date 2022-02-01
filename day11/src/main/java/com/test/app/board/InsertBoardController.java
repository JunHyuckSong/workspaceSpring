package com.test.app.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


import com.test.app.board.impl.BoardDAO;

//@Controller  //<bean/>대체
public class InsertBoardController{
	//Servlet에 대한 강제가 들어가게 되어, POJO라고 생각하지 않음 -> 경량X,무거운 파일 => implements Controller을 쓰지 않게된다.
	
	/*@RequestMapping(value="insertBoard.do") //HandlerMapping 대체
	public String insertBoard(BoardVO vo, BoardDAO dao) {
		System.out.println("로그 : insertBoard() @Controller");
		dao.insertBoard(vo);
		return "main.do";
		//BoardDAO dao = new BoardDAO(); // 더 이상 BoardDAO를 new해줄 필요가 사라짐
	}*/
	
	/*@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		BoardVO vo = new BoardVO();
		vo.setTitle(request.getParameter("title"));
		vo.setWriter(request.getParameter("writer"));
		vo.setContent(request.getParameter("content"));
		
		BoardDAO dao = new BoardDAO();
		dao.insertBoard(vo);
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:main.do");
		
		return mav;
	}*/

}
