package com.test.app.common;

import org.aspectj.lang.JoinPoint;

import com.test.app.board.BoardVO;
import com.test.app.member.MemberVO;

public class AfterReturningAdvice {
	public void afterLog(JoinPoint jp, Object obj) {//Object obj =>"���ε� ����"��-> BindTest1,2 ����
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
