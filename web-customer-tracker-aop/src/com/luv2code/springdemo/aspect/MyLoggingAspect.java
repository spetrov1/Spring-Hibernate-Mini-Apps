package com.luv2code.springdemo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.jboss.logging.Logger;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyLoggingAspect {
	
	private Logger myLogger = Logger.getLogger(getClass().getName());
	
	
	@Pointcut("execution (* com.luv2code.springdemo.controller.*.*(..)) ")
	private void forControllerPackage() {}
	
	@Pointcut("execution (* com.luv2code.springdemo.service.*.*(..)) ")
	private void forServicePackage() {}
	
	@Pointcut("execution (* com.luv2code.springdemo.dao.*.*(..)) ")
	private void forDaoPackage() {}
	
	@Pointcut("forControllerPackage() || forServicePackage() || forDaoPackage()")
	private void forAppFlow() {}
	
	
	@Before("forAppFlow()")
	private void before(JoinPoint theJoinPoint) {
		System.out.println("\n ======> @Before method applied to method: " + theJoinPoint.getSignature().toShortString());
		
		for (Object arg : theJoinPoint.getArgs())
			System.out.println("arg: " + arg);
		
	}
	
	@AfterReturning(pointcut="forAppFlow()", returning="result")
	private void afterReturning(JoinPoint theJoinPoint, Object result) {
		System.out.println("\n ======> @AfterReturning method applied to method: " + theJoinPoint.getSignature().toShortString());
		System.out.println("\n ======> @AfterReturning ... returns: " + result);
}
	
}
