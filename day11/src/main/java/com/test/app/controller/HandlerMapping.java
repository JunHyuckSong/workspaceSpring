package com.test.app.controller;

import java.util.HashMap;
import java.util.Map;

import com.test.app.board.BoardController;
import com.test.app.board.MainController;
import com.test.app.member.LoginController;
import com.test.app.member.LogoutController;

//������� ��û�� ���� Controller��ü�� �˻����ش�!!!!! --> DispatcherServlet.java���� if(action.equals("/login.do"))�� ����ϴ� Part
// ***************************************
//	��������� HandlerMapping�� Controller��Ʈ�̴�. 
// ***************************************
public class HandlerMapping {
	private Map<String, Controller> mappings; // value�� Controller��ü�� ���� ������ ���ֱ� ���� Controller�������̽��� ����� �ذ��̾���.
	
	public HandlerMapping() {
		//�⺻ ������
		mappings = new HashMap<String, Controller>();
		mappings.put("/login.do", new LoginController()); // ����Ͻ� �޼��� ����ŭ ������־�� �Ѵ�.
		mappings.put("/logout.do", new LogoutController());
		mappings.put("/main.do", new MainController());
		mappings.put("/board.do", new BoardController());
	}
	
	public Controller getController(String action) {//if(action.equals("/login.do"))
		//action�� �־��ָ� ���� ���� ��Ʈ�ѷ� �ٲ�
		return mappings.get(action);
	}
	
}