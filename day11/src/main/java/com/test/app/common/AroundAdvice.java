package com.test.app.common;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;
import org.springframework.util.StopWatch;

@Service
@Aspect
public class AroundAdvice { //인자로 pjp를 가지며 리턴타입은 Object이다.
	
	
	
	@Around("PointcutCommon.bPointCut()")
	public Object aroundLog(ProceedingJoinPoint pjp) throws Throwable {
		//================================================
		// 기초적인 aroundLog
		/*System.out.println("[비즈니스 메서드 수행전]");		
		Object obj = pjp.proceed(); //비즈니스 메서드를 탈취, Spring이 pjp를 알아서 new 해준다.
		System.out.println("[비즈니스 메서드 수행후]");*/
		//================================================
		
		System.out.println(pjp.getSignature().getName()+"() 비즈니스 메서드 실행중..");
		System.out.println("[비즈니스 메서드 수행전]");
		StopWatch sw = new StopWatch(); //스프링프레임워크에서 제공해준다.
		sw.start();
		Object obj = pjp.proceed(); // 비즈니스 메서드를 탈취
		sw.stop();
		// sw.start()와 sw.stop() 사이에는 실행되기 원하는 메서드 딱 하나만 넣어주는것이 제일 정확하다
		System.out.println("[비즈니스 메서드 수행후]");
		System.out.print(pjp.getSignature().getName() + "() 비즈니스메서드 실행에 소요된 시간은 ");
		System.out.println(sw.getTotalTimeMillis()+"입니다.");
		return obj;
	}
}
