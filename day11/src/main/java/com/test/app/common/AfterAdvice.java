package com.test.app.common;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;

@Service
@Aspect
public class AfterAdvice {
	
	@After("PointcutCommon.aPointCut()")
	public void finallyLog() {
		System.out.println("����Ͻ� �޼��� ���� �� ������ ��µ�!!");
	}
}
