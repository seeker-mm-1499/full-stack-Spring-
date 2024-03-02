package com.jdc.hello.initializer;


import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.XmlWebApplicationContext;
import org.springframework.web.servlet.support.AbstractDispatcherServletInitializer;

public class MvcAppInitializer extends AbstractDispatcherServletInitializer {

	@Override
	protected WebApplicationContext createServletApplicationContext() {
		var servletContext = new XmlWebApplicationContext();
		servletContext.setConfigLocation("/WEB-INF/mvc-config.xml");
		return servletContext;
	}

	@Override
	protected String[] getServletMappings() {
		return new String[] {"/"};
	}

	@Override
	protected WebApplicationContext createRootApplicationContext() {
		var rootContext = new XmlWebApplicationContext();
		rootContext.setConfigLocation("/WEB-INF/root-config.xml");
		return rootContext;
	}
	
}
