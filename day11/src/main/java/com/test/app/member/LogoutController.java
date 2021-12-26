package com.test.app.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.test.app.controller.Controller;

public class LogoutController implements Controller{

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		// 로그아웃 과정이 진행되어야 함. --> 세션만료시키기
		HttpSession session = request.getSession();
		session.invalidate();
		return "login"; // 이 반환값이 DispatcherServlet에서 viewName이됨
	}

}
