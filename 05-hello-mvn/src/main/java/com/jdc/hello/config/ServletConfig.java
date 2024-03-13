package com.jdc.hello.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.function.EntityResponse;
import org.springframework.web.servlet.function.RouterFunction;
import org.springframework.web.servlet.function.RouterFunctions;
import org.springframework.web.servlet.function.ServerResponse;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.jdc.hello.controller.LeagacyController;

@Configuration
@EnableWebMvc
@ComponentScan("com.jdc.hello.controller")
public class ServletConfig implements WebMvcConfigurer  {

	@Autowired
	private HandlerInterceptor interceptor;
	
	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addRedirectViewController("/", "/hello");
		//registry.addViewController("/").setViewName("hello");
	}
	/*
	@Override
	public void configureViewResolvers(ViewResolverRegistry registry) {
		registry.jsp().prefix("/views/").suffix(".jsp");
		WebMvcConfigurer.super.configureViewResolvers(registry);
	}
	*/
	@Bean
	public ViewResolver jspViewResolver(){
		return new InternalResourceViewResolver("/views/",".jsp");
	}
	
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(interceptor);
	}
	
	@Bean("/legacy")
	public LeagacyController leagacyController(){
		return new LeagacyController();
	}
	
	@Bean
	public RouterFunction<ServerResponse> routerDemo(){
		var message  = new Message("hello", "Hello from Router Function");
		var response = EntityResponse.fromObject(message).build();
		return RouterFunctions.route().GET("/router-demo",req -> response).build();
	}
}
