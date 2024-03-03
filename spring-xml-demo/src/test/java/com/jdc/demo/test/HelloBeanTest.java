package com.jdc.demo.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.jdc.demo.HelloBean;

@SpringJUnitConfig(locations="classpath:/application.xml")
public class HelloBeanTest {

	@Autowired
	private HelloBean hello;
	
	@Test
	void test() {
		assertNotNull(hello);
		assertEquals("Hello Spring Xml Configuration", hello.getMessage());
	}
}
