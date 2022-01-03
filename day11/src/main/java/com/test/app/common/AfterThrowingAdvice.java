package com.test.app.common;

import org.aspectj.lang.JoinPoint;

public class AfterThrowingAdvice {
	public void exceptionLog(JoinPoint jp, Exception excep) { //바인드 변수
		String coreMethod = jp.getSignature().getName();
		System.out.println("현재 수행중인"+coreMethod+"()이후에 출력됨");
		System.out.println("예외메세지:"+excep.getMessage());
		
		if(excep instanceof IllegalArgumentException) {
			System.out.println("사용하지 않는 매개변수입니다");
		}
		else if(excep instanceof NullPointerException) {
			System.out.println("객체생성 실패했습니다");
		}
		else {
			System.out.println("현제 예외는 파악되지않은 예외입니다. 분석필요!");
		}
	}
}
