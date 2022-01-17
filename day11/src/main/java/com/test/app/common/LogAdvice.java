package com.test.app.common;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;

@Service // 1. ������̼� ��ĵ������ �߰�(<aop:aspectj-autoproxy>)
@Aspect  // 4. �ֽ���Ʈ ���� -> �ǽð� ����ó��
public class LogAdvice {
	
	//JoinPoint : ������ �����̳ʰ� new JoinPoint()�� ���ְ�
	//			   ���� ����Ǵ� ����Ͻ��޼��� ������ ����! --> jp.getSignature().getName();���� �޼��� �̸� �̾Ƴ� �� �ִ�.
	
	/*@Pointcut("execution(* com.test.app..*Impl.select*(..))")  // 2. ����Ʈ�� �߰�
	public void bPointCut() {
		
	}*/
	@Before("PointcutCommon.bPointCut()")//3. �����̽� ���� + ���۽���(before,after,around ���)
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
