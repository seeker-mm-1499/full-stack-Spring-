package com.jdc.dependency.injection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class MyClient {
	
	@Autowired
	@Qualifier("customService")
	private MyService service;
	
	
	public void work() {
		service.doWork();
	}
}
