package com.jdc.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jdc.demo.repo.CourseRepo;

@Controller
@RequestMapping("/")
public class HelloController {
	
	@Autowired
	private CourseRepo repo;

	@GetMapping
	String home(ModelMap model) {
		model.put("message", "Hello Spring Boot Project");
		model.put("courses", repo.findAll());
		return "hello";
	}
}
