package com.naresh.aspects;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class LoggingAspect {

	@Before("execution(* com.naresh.service.UserService.addUser(..))")
	public void logBefore(JoinPoint joinPoint) {

		System.out.println("logBefore() started");
		System.out.println("Method Name:" + joinPoint.getSignature().getName());
		System.out.println("logBefore() completed!");
		System.out.println("******");
	}

	@After("execution(* com.naresh.service.UserService.addUser(..))")
	public void logAfter(JoinPoint joinPoint) {

		System.out.println("logAfter() started");
		System.out.println("Method Name:" + joinPoint.getSignature().getName());
		System.out.println("logAfter() completed!");
		System.out.println("******");
	}

	@AfterReturning(pointcut = "execution(* com.naresh.service.UserService.addUserReturnValue(..))", returning = "result")
	public void logAfterReturning(JoinPoint joinPoint, Object result) {

		System.out.println("logAfterReturning() started!");
		System.out.println("Method Name : " + joinPoint.getSignature().getName());
		System.out.println("Method returned value is : " + result);
		System.out.println("******");

	}

	@AfterThrowing(pointcut = "execution(* com.naresh.service.UserService.addUserThrowException(..))", throwing = "error")
	public void logAfterThrowing(JoinPoint joinPoint, Throwable error) {

		System.out.println("logAfterThrowing() is running!");
		System.out.println("Method Signature : " + joinPoint.getSignature().getName());
		System.out.println("Exception : " + error);
		System.out.println("******");

	}

	@Around("execution(* com.naresh.service.UserService.addUserAround(..))")
	public void logAround(ProceedingJoinPoint joinPoint) throws Throwable {

		System.out.println("logAround() is running!");
		System.out.println("Method Signature : " + joinPoint.getSignature().getName());
		System.out.println("Method arguments : " + Arrays.toString(joinPoint.getArgs()));

		System.out.println("Around before is running!");
		joinPoint.proceed(); // continue on the intercepted method
		System.out.println("Around after is running!");

		System.out.println("******");

	}

}
