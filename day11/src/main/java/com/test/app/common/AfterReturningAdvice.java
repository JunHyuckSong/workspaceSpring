package com.test.app.common;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;

import com.test.app.board.BoardVO;
import com.test.app.member.MemberVO;

@Service
@Aspect
public class AfterReturningAdvice {
	
	
	
	@AfterReturning(pointcut = "PointcutCommon.bPointCut()",returning = "obj")
	public void afterLog(JoinPoint jp, Object obj) {//Object obj =>"���ε� ����"��-> BindTest1,2 ���� / �� ������ applicationContext.xml���� returning �Ӽ��� �߰�������� 
		System.out.println("����Ͻ� �޼��� ���� �Ŀ� ��µ�!");
		String coreMethod = jp.getSignature().getName();
		System.out.println("���� ��������"+coreMethod+"()���Ŀ� ��µ�");
		
		if(obj instanceof MemberVO) {	  // ĳ���� �ϱ����� ���ǹ� �ʿ�
			MemberVO vo = (MemberVO) obj; // ĳ������ �� ����� �Ѵ�
			System.out.println("���ϵ� ��ü�� " +vo+"�Դϴ�");
		}
		else if(obj instanceof BoardVO) {
			BoardVO vo = (BoardVO) obj;
			System.out.println("���ϵ� ��ü�� " +vo+"�Դϴ�");
		}
		else {
			System.out.println("ĳ���� ����");
		}
		
	}
	
}
