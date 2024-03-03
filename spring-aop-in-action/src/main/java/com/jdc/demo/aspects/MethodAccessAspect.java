package com.jdc.demo.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

import com.jdc.demo.dto.Student;

public class MethodAccessAspect {

	public void BeforeExecution() {
		// Before execution
		System.out.println("Before Execution");

	}

	public void afterFinally() {
		// After finally
		System.out.println("After Finally");
	}

	public void afterReturning(Student student) {
		// After returning
		System.out.println("After Returning");
		System.out.println(student);

	}

	public void afterThrowing(JoinPoint joinPoint ,RuntimeException exception) {
		// After throwing
		System.out.println("After Throwing");
		System.out.println(exception.getLocalizedMessage());
		
		System.out.println(joinPoint.getTarget().getClass().getName());
		System.out.println(joinPoint.getSignature().getName());
		
	}

	public Object aroundInvocation(ProceedingJoinPoint joinPoint) throws Throwable {

		Object result = null;

		try {
			// Before execution
			System.out.println("Before Execution");

			result = joinPoint.proceed();

			// After returning
			System.out.println("After Returning");

			return result;
		} catch (Exception e) {
			// After throwing
			System.out.println("After Throwing");

			throw new RuntimeException(e);

		} finally {
			// After finally
			System.out.println("After Finally");
		}
	}

}
