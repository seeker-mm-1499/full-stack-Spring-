package com.jdc.demo.test;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.jdc.demo.config.AppConfig;
import com.jdc.demo.service.MyService;

@SpringJUnitConfig(classes = AppConfig.class)
public class AspectJTest {

	@Autowired
	private MyService service;
	
	@Test
	void test() {
		
		service.divided(10, 0);
	}
}
