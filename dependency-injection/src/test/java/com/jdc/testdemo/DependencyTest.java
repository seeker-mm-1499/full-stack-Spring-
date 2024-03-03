package com.jdc.testdemo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.jdc.dependency.AppConfig;
import com.jdc.dependency.injection.MyClient;

@SpringJUnitConfig(classes = AppConfig.class)
public class DependencyTest {
	
	@Autowired
	private MyClient client;
	
	@Test
	void test() {
		client.work();
	}

}
