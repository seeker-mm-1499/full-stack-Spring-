package com.jdc.test;

import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.jdc.spring.demo.beans.MyClient;

public class AnnotationDemo {
	
	@Test
	void demo() {
		try(var context = new AnnotationConfigApplicationContext()){
			context.scan("com.jdc.spring.demo");
			context.refresh();
			
			var bean = context.getBean(MyClient.class);
			bean.hello();
		}
	}

}
