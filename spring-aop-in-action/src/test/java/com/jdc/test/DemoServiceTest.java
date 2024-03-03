package com.jdc.test;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.jdc.demo.service.DemoService;

@SpringJUnitConfig(locations = "classpath:context.xml")
public class DemoServiceTest {

	@Autowired
	private DemoService demoService;
	
	@Test
	void test() {
		
		demoService.divided(10, 0);
	}
}
