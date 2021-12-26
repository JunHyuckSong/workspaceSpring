package com.test.app.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.test.app.controller.Controller;
import com.test.app.member.impl.MemberDAO;

public class LoginController implements Controller{

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		MemberVO vo = new MemberVO();
		vo.setMid(request.getParameter("mid"));
		vo.setPassword(request.getParameter("password"));
		
		MemberDAO dao = new MemberDAO();
		MemberVO data = dao.selectOne(vo);
		if(data!=null) {
			//���ǿ� ������ ��
			HttpSession session = request.getSession();
			session.setAttribute("member", data);
			//main.jsp
			//response.sendRedirect("main.jsp");
			return "main.do"; // main���������� ������ ����ؾ��ϹǷ� 
		}
		else {
			//login.jsp
			//response.sendRedirect("login.jsp");
			//return "login.jsp"; // login���������� ���ٸ� ������ ����� �ʿ� �����Ƿ�
			return "login"; // �� ��ȯ���� DispatcherServlet���� viewName�̵�
			//ViewResolver������ Ȯ���ڰ� ������ .jsp�� �ڵ��߰�����
		}
	}

}