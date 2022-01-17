package com.test.app.common;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;
import org.springframework.util.StopWatch;

@Service
@Aspect
public class AroundAdvice { //���ڷ� pjp�� ������ ����Ÿ���� Object�̴�.
	
	
	
	@Around("PointcutCommon.bPointCut()")
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
		Object obj = pjp.proceed(); // ����Ͻ� �޼��带 Ż��
		sw.stop();
		// sw.start()�� sw.stop() ���̿��� ����Ǳ� ���ϴ� �޼��� �� �ϳ��� �־��ִ°��� ���� ��Ȯ�ϴ�
		System.out.println("[����Ͻ� �޼��� ������]");
		System.out.print(pjp.getSignature().getName() + "() ����Ͻ��޼��� ���࿡ �ҿ�� �ð��� ");
		System.out.println(sw.getTotalTimeMillis()+"�Դϴ�.");
		return obj;
	}
}
