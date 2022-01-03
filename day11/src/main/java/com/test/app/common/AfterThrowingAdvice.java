package com.test.app.common;

import org.aspectj.lang.JoinPoint;

public class AfterThrowingAdvice {
	public void exceptionLog(JoinPoint jp, Exception excep) { //���ε� ����
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
