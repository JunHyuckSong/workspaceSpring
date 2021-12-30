package com.test.app.board;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


import com.test.app.board.impl.BoardDAO;

@Controller
public class MainController{

	@RequestMapping(value="/main.do")
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		BoardVO vo = new BoardVO();// �˻��� ���� vo�Ķ���� ����������, ���� �����ȵȱ��
		
		BoardDAO dao = new BoardDAO();
		ArrayList<BoardVO> datas = dao.selectAll(vo);
		
		//HttpSession session=request.getSession(); // ������ �������� ó��
		//session.setAttribute("datas", datas);
		//ModelAndView ����� �̿��ϸ� ���̻� session�� ��Ƶ��� �ʾƵ� �ȴ�.
		
		/*ModelAndView mav = new ModelAndView();
		mav.addObject("datas", datas);
		mav.setViewName("main"); //    /WEB-INF/test/main.jsp �� ������־�� ��!! -> ViewResolver�� ���ľ��Ѵ�
		
		//return "main"; // �� ��ȯ���� DispatcherServlet���� viewName�̵�
		//ViewResolver�� viewNameó��
		return mav;*/
		return "";
	}

}
