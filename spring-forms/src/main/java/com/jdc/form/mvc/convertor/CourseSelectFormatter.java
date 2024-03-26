package com.jdc.form.mvc.convertor;

import java.text.ParseException;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.jdc.form.root.dao.CourseRepository;
import com.jdc.form.root.dto.Course;

@Component
public class CourseSelectFormatter implements Formatter<Course>{

	@Autowired
	private CourseRepository courseRepo;

	@Override
	public String print(Course object, Locale locale) {
		if(null != object) {
			return object.getName();
		}
		return null;
	}

	@Override
	public Course parse(String values, Locale locale) throws ParseException {
		if(StringUtils.hasLength(values)) {
			var id = Integer.parseInt(values);
			return courseRepo.findById(id);
		}
		return null;
	}
	
	
}
