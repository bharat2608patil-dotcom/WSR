package com.wsr_management_service.config;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Aspect
@Component
@Slf4j
public class LoggingAspect {

	@Before("execution(* com.wsr_management_service.service.*.*(..))")
	public void logBefore(JoinPoint joinPoint) {

		log.info("Method Called : {}", joinPoint.getSignature());
	}

	@AfterReturning(pointcut = "execution(* com.wsr_management_service.service.*.*(..))", returning = "result")
	public void logAfter(JoinPoint joinPoint, Object result) {

		log.info("Method Executed : {}", joinPoint.getSignature());
	}
}