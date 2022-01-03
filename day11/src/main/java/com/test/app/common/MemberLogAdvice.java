package com.test.app.common;

import org.aspectj.lang.JoinPoint;

public class MemberLogAdvice {
	public void printLog2(JoinPoint jp){
		Object[] args = jp.getArgs();
		for (Object v : args) {
			System.out.print(v + " ");
		}
		
	}
}
