package com.jdc.test;

import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class JavaBaseConfigDemo {

	@Test
	void test() {
		try(var context=new AnnotationConfigApplicationContext()){
			context.scan("com.jdc.spring.demo.beans");
			context.refresh();
			
			var date =context.getBean("todayDate");
			System.out.println(date);
		}
	}
}
