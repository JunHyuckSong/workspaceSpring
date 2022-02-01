package com.test.app.common;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

//@ControllerAdvice("com.test.app") //"com.test.app" <- �̰����� �����߻��� �ش� Ŭ������ ���Բ� �Ѵ�. DispatcherServlet.xml�� �ִ� <mvc:annotation-driven></mvc:annotation-driven>�� ¦����
public class CommonExceptionHandler { // ������������ ��� ������ ���� �Ͼ�� �����Ƿ� .xml�� �������ִ� ��찡 ����.
	
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
