package com.test.app.common;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

//@ControllerAdvice("com.test.app") //"com.test.app" <- 이곳에서 에러발생시 해당 클래스로 오게끔 한다. DispatcherServlet.xml에 있는 <mvc:annotation-driven></mvc:annotation-driven>과 짝꿍임
public class CommonExceptionHandler { // 에러페이지의 경우 변경이 많이 일어나지 않으므로 .xml로 설정해주는 경우가 많다.
	
	@ExceptionHandler(NullPointerException.class)
	public ModelAndView excep1(Exception e) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("exception", e);
		mav.setViewName("errors/error.jsp");
		return mav;
	}
	
	@ExceptionHandler(IllegalArgumentException.class)
	public ModelAndView excep2(Exception e) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("exception", e);
		mav.setViewName("errors/errorId.jsp");
		return mav;
	}
	
	public void excep3() {
	
	}
}
