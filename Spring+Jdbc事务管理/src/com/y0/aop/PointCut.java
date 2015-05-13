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
	// 一个切入点 @Pointcut("execution (返回值  包名..类名.方法名(参数))")
	//@Pointcut("execution (* com.y0.service.impl.LoginServiceImpl.*(..))")
	public void anyMethod() {}
	
	//@Before("anyMethod() && args(name)")
	public void before() 
	{
		System.out.println("前置通知 ");
	}
	//@AfterReturning(pointcut = "anyMethod()", returning = "result")
	public void after ()
	{
		System.out.println("后置通知");
	}
	
	//@Around("anyMethod()")
	public Object around(ProceedingJoinPoint pjp) throws Throwable {
		
		Object obj = pjp.proceed();
		
		return obj;
	}
}
