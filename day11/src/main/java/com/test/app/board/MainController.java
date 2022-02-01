package com.test.app.board;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


import com.test.app.board.impl.BoardDAO;

//@Controller
public class MainController{

	/*@RequestMapping(value="/main.do")
	public ModelAndView main(BoardVO vo, BoardDAO dao, ModelAndView mav) { // 저장할 정보가 있기때문에 ModelAndView 사용
		System.out.println("로그: main() @컨트롤러");
		List<BoardVO> datas = dao.selectAll(vo);
		mav.addObject("datas",datas);
		mav.setViewName("main.jsp"); // 현재는 ViewResolver설정을 하지 않았으므로 .jsp를 붙여줘야함->나중에 없앨 에정
		
		return mav;
	}*/
	/*public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		BoardVO vo = new BoardVO();// 검색을 위해 vo파라미터 제작했으나, 현재 구현안된기능
		
		BoardDAO dao = new BoardDAO();
		ArrayList<BoardVO> datas = dao.selectAll(vo);
		
		//HttpSession session=request.getSession(); // 지금은 세션으로 처리
		//session.setAttribute("datas", datas);
		//ModelAndView 방식을 이용하면 더이상 session에 담아두지 않아도 된다.
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("datas", datas);
		mav.setViewName("main"); //    /WEB-INF/test/main.jsp 로 만들어주어야 함!! -> ViewResolver을 거쳐야한다
		
		//return "main"; // 이 반환값이 DispatcherServlet에서 viewName이됨
		//ViewResolver가 viewName처리
		return mav;
		return "";
	}*/

}
