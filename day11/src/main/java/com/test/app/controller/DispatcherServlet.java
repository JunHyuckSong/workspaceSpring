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
     
	private HandlerMapping handlerMapping;
	private ViewResolver viewResolver;
	
	public void init() { // 초기화 메서드
		//************************************************
		//		추후에 .xml에 initMethod로 불러내기 가능(bean이나 annotation으로 수정될 에정)
		//************************************************
		handlerMapping = new HandlerMapping();
		viewResolver = new ViewResolver();
		viewResolver.setPrefix("./");
		viewResolver.setSuffix(".jsp");
	}
	
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
		String action = uri.substring(uri.lastIndexOf("/")); //		1. action을 request로부터 받늗다.
		
		Controller ctrl = handlerMapping.getController(action); //	2. action을 실행시켜줄 "Controller객체"를 HashMap에서 찾는다.
		String viewName = ctrl.handleRequest(request, response); // 3. 해당 "Controller객체"에서 "요청처리"를 진행 후 경로를 반환
		//바로 .do 요청을 수행
		//혹은 viewName 앞뒤로 접사 붙여주기
		if (!viewName.contains(".do")) {			
			viewResolver.getView(viewName); // viewName에 prefix와 suffix를 붙여주기
		}
		
		
		response.sendRedirect(viewName);
				
	}

}
