package com.test.app.common;

import org.aspectj.lang.JoinPoint;

public class LogAdvice {
	
	//JoinPoint : ������ �����̳ʰ� new JoinPoint()�� ���ְ�
	//			   ���� ����Ǵ� ����Ͻ��޼��� ������ ����! --> jp.getSignature().getName();���� �޼��� �̸� �̾Ƴ� �� �ִ�.
	
	public void printLog(JoinPoint jp){
		System.out.println("JP�ǽ���...");
		String coreMethod = jp.getSignature().getName();// ���� �������� ����Ͻ��޼����� �̸��� �޼��� �ñ״��ķκ��� �̾Ƴ� �� �ִ�.
		System.out.println("ó������ ����Ͻ� �޼����:" + coreMethod);
		Object[] args = jp.getArgs();// �Ű�����(== ����, �Ķ����)���� Ȯ��  
		System.out.println();
		for (Object v : args) {
			System.out.print(v + " ");
		}
		System.out.println();
	}
}
