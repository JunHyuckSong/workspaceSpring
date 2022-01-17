package com.test.app.common;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect // Ⱦ�ܰ��ɰ� "����"�� �� �Ҹ��� ����Ʈ��Ŭ����
public class PointcutCommon {
	
	@Pointcut("execution(* com.test.app..*Impl.*(..))")
	public void aPointCut() {
		
	}
	@Pointcut("execution(* com.test.app..*Impl.select*(..))")
	public void bPointCut() {
		
	}
}
