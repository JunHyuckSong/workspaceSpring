package com.test.app.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.test.app.member.impl.MemberDAO;

public class LoginController implements Controller{


	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
		// ModelAndView ==> ����(Model) + ������(View)
		MemberVO vo = new MemberVO();
		vo.setMid(request.getParameter("mid"));
		vo.setPassword(request.getParameter("password"));
		
		MemberDAO dao = new MemberDAO();
		MemberVO data = dao.selectOne(vo);
		System.out.println("LC�α�� : "+data);
		
		ModelAndView mav = new ModelAndView();
	
		if(data!=null) {
			//���ǿ� ������ ��
			//HttpSession session = request.getSession();
			//session.setAttribute("member", data);
			//main.jsp
			//response.sendRedirect("main.jsp");
			
			mav.addObject("member", data);
			mav.setViewName("redirect:main.do"); //  /WEB-INF/test/main.do.jsp �� ��������� �ʱ� ���ؼ�
			
			//return "main.do"; // main���������� ������ ����ؾ��ϹǷ� 
		}
		else {
			//login.jsp
			//response.sendRedirect("login.jsp");
			//return "login.jsp"; // login���������� ���ٸ� ������ ����� �ʿ� �����Ƿ�
			
			mav.setViewName("redirct:index.jsp");
			
			//return "login"; // �� ��ȯ���� DispatcherServlet���� viewName�̵�
			//ViewResolver������ Ȯ���ڰ� ������ .jsp�� �ڵ��߰�����
		}
		return mav;
	}

}
