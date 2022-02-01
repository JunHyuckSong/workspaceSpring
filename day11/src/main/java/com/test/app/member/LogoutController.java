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
		System.out.println("로그: logout() @컨트롤러");
		session.invalidate();
		return "index.jsp";
	}*/
	
	/*@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		// 로그아웃 과정이 진행되어야 함. --> 세션만료시키기
		HttpSession session = request.getSession();
		session.invalidate();
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:index.jsp");
		
		//return "login"; // 이 반환값이 DispatcherServlet에서 viewName이됨
		return mav;
	}
*/
}
