package com.test.app.common;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;

@Service
@Aspect  // -> 스프링컨테이너가 실행시간에 위빙처리를 진행.
public class LogAdvice3 { // 횡단관심1개 +포인트컷2개 => 모든 횡단관심에 포인트컷을 넣어준다??NO => 포인트컷 클래스 생성예정
	
	
	
	@Before("PointcutCommon.aPointCut()") // --> 애스팩트(aspect) 설정완료
	public void printLog3() {
		System.out.println("횡단관심");
	}
	
	
}
