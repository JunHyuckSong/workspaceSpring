package com.test.app.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

//@Controller
public class LogoutController{
	
	/*@RequestMapping("/logout.do")
	public String logout(HttpSession session) {
		System.out.println("�α�: logout() @��Ʈ�ѷ�");
		session.invalidate();
		return "index.jsp";
	}*/
	
	/*@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		// �α׾ƿ� ������ ����Ǿ�� ��. --> ���Ǹ����Ű��
		HttpSession session = request.getSession();
		session.invalidate();
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:index.jsp");
		
		//return "login"; // �� ��ȯ���� DispatcherServlet���� viewName�̵�
		return mav;
	}
*/
}
