package com.test.app.common;

import org.aspectj.lang.JoinPoint;

import com.test.app.board.BoardVO;
import com.test.app.member.MemberVO;

public class AfterReturningAdvice {
	public void afterLog(JoinPoint jp, Object obj) {//Object obj =>"바인드 변수"☆-> BindTest1,2 보기
		System.out.println("비즈니스 메서드 수행 후에 출력됨!");
		String coreMethod = jp.getSignature().getName();
		System.out.println("현재 수행중인"+coreMethod+"()이후에 출력됨");
		
		if(obj instanceof MemberVO) {	  // 캐스팅 하기전에 조건문 필요
			MemberVO vo = (MemberVO) obj; // 캐스팅을 꼭 해줘야 한다
			System.out.println("리턴된 객체는 " +vo+"입니다");
		}
		else if(obj instanceof BoardVO) {
			BoardVO vo = (BoardVO) obj;
			System.out.println("리턴된 객체는 " +vo+"입니다");
		}
		else {
			System.out.println("캐스팅 오류");
		}
		
	}
	
}
