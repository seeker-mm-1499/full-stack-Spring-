package com.jdc.test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.jdc.demo.BusinessInterface;


@SpringJUnitConfig(locations = "classpath:context.xml")
public class AopTest {
	
	@Autowired
	private BusinessInterface businessInterface;
	
	
	@Test
	void demo() {
		assertNotNull(businessInterface);
		businessInterface.doBusiness("Hello AOP","Hello Spring");
		
		
	}

}
