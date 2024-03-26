package com.jdc.form.root.dao;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.ApplicationScope;

import com.jdc.form.root.dto.Course;

@Service
@ApplicationScope
public class CourseRepository {
	
	private List<Course> courses = List.of(
			new Course(1,"Java Basic",150000),
			new Course(2, "Spring Angular", 250000),
			new Course(3, "Flutter", 200000),
			new Course(4, "Spring Boot", 350000));
	
	public List<Course> getCourse(){
		return courses;
	}

	public Course findById(int id) {
		return courses.stream().filter(a->a.getId() == id).findFirst().orElse(null);
	}
	
}
