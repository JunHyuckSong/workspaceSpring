package com.test.app.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


import com.test.app.board.impl.BoardDAO;

//@Controller
public class UpdateBoardController{

	/*@RequestMapping("/updateBoard.do")
	public String updateBoard(BoardVO vo, BoardDAO dao) {
		System.out.println("·Î±×:updateBoard() @Controller");
		dao.updateBoard(vo);
		return "main.do";
	}*/
	
	/*@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		BoardVO vo = new BoardVO();
		vo.setTitle(request.getParameter("title"));
		vo.setBid(Integer.parseInt(request.getParameter("bid")));
		vo.setContent(request.getParameter("content"));
		
		BoardDAO dao = new BoardDAO();
		dao.updateBoard(vo);
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:main.do");
		
		return mav;
	}*/

}
