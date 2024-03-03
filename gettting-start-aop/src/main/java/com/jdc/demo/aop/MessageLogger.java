package com.jdc.demo.aop;

public class MessageLogger {

	public void doBefore(String[] array) {

		System.out.println("Before Execution.");

		System.out.print("[");
		for(String str : array) {
			System.out.print(str + ",");
		}
		System.out.println("]");
		
	}

	public void doAfter() {
		System.out.println("After business method invocation");
	}
}
