package com.jdc.dependency;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


@Configuration
@ComponentScan(basePackages = "com.jdc.dependency.injection")
public class AppConfig {
	/*
	@Bean
	@Qualifier("customService")
	MyCustomService myCustomService() {
		return new MyCustomService();
	}
	@Bean
	@Qualifier("defaultService")
	MyDefaultService myDefaultService() {
		return new MyDefaultService();
	}
	*/

}
