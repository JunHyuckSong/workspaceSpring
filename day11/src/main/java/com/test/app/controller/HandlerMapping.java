package com.test.app.controller;

import java.util.HashMap;
import java.util.Map;

import com.test.app.board.BoardController;
import com.test.app.board.MainController;
import com.test.app.member.LoginController;
import com.test.app.member.LogoutController;

//사용자의 요청을 보고 Controller객체를 검색해준다!!!!! --> DispatcherServlet.java에서 if(action.equals("/login.do"))를 담당하는 Part
// ***************************************
//	결론적으로 HandlerMapping은 Controller파트이다. 
// ***************************************
public class HandlerMapping {
	private Map<String, Controller> mappings; // value에 Controller객체가 들어간다 보장을 해주기 위해 Controller인터페이스를 만들어 준것이었다.
	
	public HandlerMapping() {
		//기본 생성자
		mappings = new HashMap<String, Controller>();
		mappings.put("/login.do", new LoginController()); // 비즈니스 메서드 수만큼 만들어주어야 한다.
		mappings.put("/logout.do", new LogoutController());
		mappings.put("/main.do", new MainController());
		mappings.put("/board.do", new BoardController());
	}
	
	public Controller getController(String action) {//if(action.equals("/login.do"))
		//action을 넣어주면 내가 가진 컨트롤러 줄께
		return mappings.get(action);
	}
	
}
