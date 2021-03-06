package com.test.app.common;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;

@Service // 1. 어노테이션 스캔범위에 추가(<aop:aspectj-autoproxy>)
@Aspect  // 4. 애스팩트 설정 -> 실시간 위빙처리
public class LogAdvice {
	
	//JoinPoint : 스프링 컨테이너가 new JoinPoint()도 해주고
	//			   현재 수행되는 비즈니스메서드 정보를 셋팅! --> jp.getSignature().getName();으로 메서드 이름 뽑아낼 수 있다.
	
	/*@Pointcut("execution(* com.test.app..*Impl.select*(..))")  // 2. 포인트컷 추가
	public void bPointCut() {
		
	}*/
	@Before("PointcutCommon.bPointCut()")//3. 어드바이스 설정 + 동작시점(before,after,around 등등)
	public void printLog(JoinPoint jp){
		System.out.println("JP실습중...");
		String coreMethod = jp.getSignature().getName();// 지금 실행중인 비즈니스메서드의 이름을 메서드 시그니쳐로부터 뽑아낼 수 있다.
		System.out.println("처리중인 비즈니스 메서드명:" + coreMethod);
		Object[] args = jp.getArgs();// 매개변수(== 인자, 파라미터)들을 확인  
		System.out.println();
		for (Object v : args) {
			System.out.print(v + " ");
		}
		System.out.println();
		
	}
}
