package kr.co.test.common;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

// advice : 공통 업무를 지원하는 클래스 (실질적으로 어떤 일을 해야할 지에 대한 것, 실질적인 부가기능을 담은 구현체)

@Component
@Aspect
public class LoggerAspect {
	protected Logger log = LoggerFactory.getLogger(LoggerAspect.class); 
	
	//@before(해당 대상이 호출전)
	// 컨트롤러의 모든 메소드에 대한 수행시간을 출력해보기
	@Around("execution (* kr.co.test.controller.*Controller.*(..))")
	public Object logPrint(ProceedingJoinPoint jointPoint) throws Throwable {
		// 핵심업무 실행전
		Object result = null;
		String type = jointPoint.getSignature().getDeclaringTypeName();
		long start = System.currentTimeMillis();
		
		// 핵심업무 실행
		result = jointPoint.proceed();
		
		// 핵심업무 실행후
		long end = System.currentTimeMillis();
		log.info("--->" + type + " : 수행시간 " + (end - start) + "밀리초");
		
		return result;
	}
	
}
