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
		// ModelAndView ==> 정보(Model) + 목적지(View)
		MemberVO vo = new MemberVO();
		vo.setMid(request.getParameter("mid"));
		vo.setPassword(request.getParameter("password"));
		
		MemberDAO dao = new MemberDAO();
		MemberVO data = dao.selectOne(vo);
		System.out.println("LC로깅용 : "+data);
		
		ModelAndView mav = new ModelAndView();
	
		if(data!=null) {
			//세션에 저장한 후
			//HttpSession session = request.getSession();
			//session.setAttribute("member", data);
			//main.jsp
			//response.sendRedirect("main.jsp");
			
			mav.addObject("member", data);
			mav.setViewName("redirect:main.do"); //  /WEB-INF/test/main.do.jsp 로 만들어주지 않기 위해서
			
			//return "main.do"; // main페이지에서 정보를 출력해야하므로 
		}
		else {
			//login.jsp
			//response.sendRedirect("login.jsp");
			//return "login.jsp"; // login페이지에는 별다른 내용을 출력할 필요 없으므로
			
			mav.setViewName("redirct:index.jsp");
			
			//return "login"; // 이 반환값이 DispatcherServlet에서 viewName이됨
			//ViewResolver에서는 확장자가 없으면 .jsp를 자동추가해줌
		}
		return mav;
	}

}
