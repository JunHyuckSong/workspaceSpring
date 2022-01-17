package com.test.app.common;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;

@Service
@Aspect
public class AfterThrowingAdvice {
	
	
	
	@AfterThrowing(pointcut="PointcutCommon.aPointCut()", throwing="excep")
	public void exceptionLog(JoinPoint jp, Exception excep) { //���ε� ����, �� ������ applicationContext.xml���� throwing �Ӽ��� �߰��������
		String coreMethod = jp.getSignature().getName();
		System.out.println("���� ��������"+coreMethod+"()���Ŀ� ��µ�");
		System.out.println("���ܸ޼���:"+excep.getMessage());
		
		if(excep instanceof IllegalArgumentException) {
			System.out.println("������� �ʴ� �Ű������Դϴ�");
		}
		else if(excep instanceof NullPointerException) {
			System.out.println("��ü���� �����߽��ϴ�");
		}
		else {
			System.out.println("���� ���ܴ� �ľǵ������� �����Դϴ�. �м��ʿ�!");
		}
	}
}
