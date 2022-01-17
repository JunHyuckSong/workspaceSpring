package com.test.app.common;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;

@Service
@Aspect  // -> �����������̳ʰ� ����ð��� ����ó���� ����.
public class LogAdvice3 { // Ⱦ�ܰ���1�� +����Ʈ��2�� => ��� Ⱦ�ܰ��ɿ� ����Ʈ���� �־��ش�??NO => ����Ʈ�� Ŭ���� ��������
	
	
	
	@Before("PointcutCommon.aPointCut()") // --> �ֽ���Ʈ(aspect) �����Ϸ�
	public void printLog3() {
		System.out.println("Ⱦ�ܰ���");
	}
	
	
}
