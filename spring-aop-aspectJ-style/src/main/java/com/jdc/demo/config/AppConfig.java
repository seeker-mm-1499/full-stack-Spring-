package com.jdc.demo.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan(basePackages = {
		"com.jdc.demo.aspects",
		"com.jdc.demo.service",
		"com.jdc.demo.dto"
})
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class AppConfig {

}
