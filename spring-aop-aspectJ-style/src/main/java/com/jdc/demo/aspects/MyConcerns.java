package com.jdc.demo.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.Configuration;

import com.jdc.demo.dto.Result;

@Aspect
@Configuration
public class MyConcerns {
/*
	@After(value = "bean(myService) && args(names,number)", argNames = "names,number")
	void afterMethod(String names, int number) {
		System.out.println("\nAfter Finally");
		System.out.println("String name is %s".formatted(names));
		System.out.println("Integer number  is %s \n".formatted(number));
	}
	
	@AfterReturning(pointcut = "bean(myService) && execution(com.jdc.demo..Result *(..)) and args(name,count)",
			argNames = "result,name,count",returning = "result")
	void afterReturningMethod(Result result,String name, int count) {
		System.out.println("After returning.");
		System.out.println(result);
		System.out.println("String name : %s ".formatted(name));
		System.out.println("Inter count : %s ".formatted(count));
	}

	@Before("bean(myService)")
	void beforeMethod() {
		System.out.println("Before Execution");
	}
	
*/

	@AfterThrowing(pointcut = "bean(myService) and execution(int *(..)) and args(a,b)",
			argNames = "ex,a,b",
			throwing = "ex")
	void afterAllMethod(RuntimeException ex, int a, int b) {
		System.out.println("After Throwing");
		System.out.println(ex);
		System.out.println("Integer %s is divided by integer %s".formatted(a,b));
	}

/*
	@Around("bean(myService)")
	Object aroundInvoke(ProceedingJoinPoint joinPoint) {
		Object result = null;
		try {
			System.out.println("Before in around");
			result = joinPoint.proceed();
			System.out.println("After returning in around");
		} catch (Throwable e) {
			System.out.println("After throwing in around");
			throw new RuntimeException();
		} finally {
			System.out.println("After finally in around.");
		}
		return result;
	}
*/
}
