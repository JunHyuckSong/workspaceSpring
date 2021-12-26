package com.test.app.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.test.app.controller.Controller;

public class LogoutController implements Controller{

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		// �α׾ƿ� ������ ����Ǿ�� ��. --> ���Ǹ����Ű��
		HttpSession session = request.getSession();
		session.invalidate();
		return "login"; // �� ��ȯ���� DispatcherServlet���� viewName�̵�
	}

}