package com.test.app.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


import com.test.app.board.impl.BoardDAO;

//@Controller
public class DeleteBoardController{
	
	/*@RequestMapping("/deleteBoard.do")
	public String deleteBoard(BoardVO vo, BoardDAO dao) {
		System.out.println("로그: deleteBoard() @컨트롤러");
		dao.deleteBoard(vo);
		return "main.do";
	}*/
	
	/*@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		BoardVO vo = new BoardVO();
		vo.setBid(Integer.parseInt(request.getParameter("bid")));
		
		BoardDAO dao = new BoardDAO();
		dao.deleteBoard(vo);
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:main.do");
		
		return mav;
	}*/

}
