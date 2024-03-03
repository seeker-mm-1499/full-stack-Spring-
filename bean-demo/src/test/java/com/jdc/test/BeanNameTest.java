package com.jdc.test;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.context.support.GenericXmlApplicationContext;

public class BeanNameTest {

	@Test
	void test() {
		try(var context=new GenericXmlApplicationContext()){
			context.load("classpath:context.xml");
			context.refresh();
			
			var bean1=context.getBean("myClient-2");
			var bean2=context.getBean("otherBean");
			assertTrue(bean1==bean2);
		}
	}
}
