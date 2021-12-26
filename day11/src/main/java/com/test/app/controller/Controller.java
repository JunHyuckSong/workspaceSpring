package com.test.app.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Controller {
	String handleRequest(HttpServletRequest request, HttpServletResponse response);
	// : request, response 사용자의 요청정보를 받아서 화면 네비게이션
	//parameter가 request, response인 이유 -> request.getParameter을 쓰려고
	//반환타입이 String인 이유 -> '경로'를 리턴해 View로 넘겨줘야하니까.. 경로는 String타입이다.
	
	
}
