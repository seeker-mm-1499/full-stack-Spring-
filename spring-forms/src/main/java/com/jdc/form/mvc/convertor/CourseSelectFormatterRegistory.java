package com.jdc.form.mvc.convertor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.FormatterRegistry;
import org.springframework.stereotype.Component;

@Component
public class CourseSelectFormatterRegistory {

	@Autowired
	private CourseSelectFormatter formatter;
	
	@Autowired
	public void addFormatters(FormatterRegistry registry) {
		registry.addFormatter(formatter);
	}
	
}
