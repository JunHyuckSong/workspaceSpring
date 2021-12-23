package com.test.app.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import com.test.app.member.MemberVO;
import com.test.app.member.impl.MemberDAO;

/**
 * Servlet implementation class DispatcherServlet
 */
public class DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DispatcherServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doAction(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doAction(request,response);
	}
	
	private void doAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String uri = request.getRequestURI();
		System.out.println(uri);
		String action = uri.substring(uri.lastIndexOf("/"));
		
		ActionForward forward = null;
		if(action.equals("/login.do")) {
			MemberVO vo = new MemberVO();
			vo.setMid(request.getParameter("mid"));
			vo.setPassword(request.getParameter("password"));
			
			MemberDAO dao = new MemberDAO();
			MemberVO data = dao.selectOne(vo);
			if(data!=null) {
				//세션에 저장한 후
				//main.jsp
				response.sendRedirect("main.jsp");
			}
			else {
				//login.jsp
				response.sendRedirect("login.jsp");
			}
			
			
		}
		else if(action.equals("/logout.do")) {
			HttpSession session = request.getSession();
			session.invalidate();
			response.sendRedirect("login.jsp");
		}
				
	}

}
