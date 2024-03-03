package com.jdc.spring.demo.beans;

import java.util.Date;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyClientInstanceFactory {
	
	@Bean
	public MyClient getBean() {
		return new MyClient();
	}
	
	@Bean(name = {
			"createDate",
			"todayDate"
	})
	Date currentDate() {
		return new Date();
	}

}
