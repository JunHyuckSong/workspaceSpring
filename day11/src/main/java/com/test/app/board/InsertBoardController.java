package com.test.app.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


import com.test.app.board.impl.BoardDAO;

//@Controller  //<bean/>��ü
public class InsertBoardController{
	//Servlet�� ���� ������ ���� �Ǿ�, POJO��� �������� ���� -> �淮X,���ſ� ���� => implements Controller�� ���� �ʰԵȴ�.
	
	/*@RequestMapping(value="insertBoard.do") //HandlerMapping ��ü
	public String insertBoard(BoardVO vo, BoardDAO dao) {
		System.out.println("�α� : insertBoard() @Controller");
		dao.insertBoard(vo);
		return "main.do";
		//BoardDAO dao = new BoardDAO(); // �� �̻� BoardDAO�� new���� �ʿ䰡 �����
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
