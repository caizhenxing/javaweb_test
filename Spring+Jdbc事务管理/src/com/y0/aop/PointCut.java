package com.y0.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect @Component
public class PointCut {
	// һ������� @Pointcut("execution (����ֵ  ����..����.������(����))")
	//@Pointcut("execution (* com.y0.service.impl.LoginServiceImpl.*(..))")
	public void anyMethod() {}
	
	//@Before("anyMethod() && args(name)")
	public void before() 
	{
		System.out.println("ǰ��֪ͨ ");
	}
	//@AfterReturning(pointcut = "anyMethod()", returning = "result")
	public void after ()
	{
		System.out.println("����֪ͨ");
	}
	
	//@Around("anyMethod()")
	public Object around(ProceedingJoinPoint pjp) throws Throwable {
		
		Object obj = pjp.proceed();
		
		return obj;
	}
}
