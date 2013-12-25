/*
 * Name:ControllerAfterAdvice.java
 * Version:1.0
 * Author:puc
 * Date:2013/10/16
 */
package com.zt.aop;

import java.util.Arrays;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.springframework.stereotype.Component;

/*
 * 拦截类
 */
@Component
@Aspect
public class SpringAop {
	private static Log logger = LogFactory.getLog(SpringAop.class);

	@Before("execution(* com.zt..*.*Controller.*(..))")
	public void doBefore(JoinPoint jp) {
		System.out.println("before");
	}

	@AfterThrowing(pointcut = "execution(* com.zt..*.*Controller.*(..))", throwing = "e")
	public void afterThrowing(JoinPoint joinPoint, Throwable e) {
		System.out.println("throwing");
		Signature signature = joinPoint.getSignature();
		String methodName = signature.getName();
		String stuff = signature.toString();
		String arguments = Arrays.toString(joinPoint.getArgs());
		logger.error("We have caught exception in method: " + methodName
				+ " with arguments " + arguments + "\nand the full toString: "
				+ stuff + "\nthe exception is: " + e.getMessage(), e);
	}
}
