package com.test.app.common;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect // 횡단관심과 "결합"될 떄 불리는 포인트컷클래스
public class PointcutCommon {
	
	@Pointcut("execution(* com.test.app..*Impl.*(..))")
	public void aPointCut() {
		// 포인트컷을 설정할 때는 인/아웃풋 없고, 메서드 body또한 존재하지 않는다.
	}
	@Pointcut("execution(* com.test.app..*Impl.select*(..))")
	public void bPointCut() {
		
	}
}
