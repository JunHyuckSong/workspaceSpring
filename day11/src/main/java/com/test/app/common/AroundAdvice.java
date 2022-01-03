package com.test.app.common;

import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.util.StopWatch;

public class AroundAdvice { //���ڷ� pjp�� ������ ����Ÿ���� Object�̴�.
	public Object aroundLog(ProceedingJoinPoint pjp) throws Throwable {
		//================================================
		// �������� aroundLog
		/*System.out.println("[����Ͻ� �޼��� ������]");		
		Object obj = pjp.proceed(); //����Ͻ� �޼��带 Ż��, Spring�� pjp�� �˾Ƽ� new ���ش�.
		System.out.println("[����Ͻ� �޼��� ������]");*/
		//================================================
		
		System.out.println(pjp.getSignature().getName()+"() ����Ͻ� �޼��� ������..");
		System.out.println("[����Ͻ� �޼��� ������]");
		StopWatch sw = new StopWatch(); //�����������ӿ�ũ���� �������ش�.
		sw.start();
		Object obj = pjp.proceed();
		sw.stop();
		// sw.start()�� sw.stop() ���̿��� ����Ǳ� ���ϴ� �޼��� �� �ϳ��� �־��ִ°��� ���� ��Ȯ�ϴ�
		System.out.println("[����Ͻ� �޼��� ������]");
		return obj;
	}
}
