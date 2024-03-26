package com.jdc.form.mvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jdc.form.mvc.validator.UserInputValidator;
import com.jdc.form.root.dao.CourseRepository;
import com.jdc.form.root.dao.DataHolder;
import com.jdc.form.root.dto.Course;
import com.jdc.form.root.dto.UserInput;

@Controller
@RequestMapping
public class FormController {
	@Autowired
	private DataHolder repo;

	@Autowired
	private CourseRepository courseRepo;

	@Autowired
	private UserInputValidator validator;

	@GetMapping
	String index() {
		return "form";
	}

	@PostMapping
	String create(@Validated @ModelAttribute("userInput") UserInput data, BindingResult result, ModelMap model) {
		if (result.hasErrors()) {			
			return "form";
		}

		repo.add(data);
		return "redirect:/";
	}

	@InitBinder
	void intWebBinder(WebDataBinder binder) {
		binder.addValidators(validator);
	}

	@ModelAttribute("list")
	List<UserInput> getAllData() {
		return repo.getAllData();
	}

	@ModelAttribute("userInput")
	UserInput userInput() {
		var data = new UserInput();
		/*
		 * data.setName("Myint Sein"); data.setPhone("09442065638");
		 * data.setAgree(true); data.setCourse("Flutter");
		 * data.setEmail("myintsein1999.mm9@gmail.com"); data.setFoundations(new
		 * String[] { "HTML", "CSS" }); data.setGender(Gender.Male);
		 * data.setRemark("Hello Spring Forms");
		 */

		return data;
	}

	@ModelAttribute("courses")
	List<Course> course() {
		return courseRepo.getCourse();
	}
	/*
	 * @ModelAttribute("courses") List<String> course() { return
	 * List.of("Java Basic", "Spring Angular", "Flutter", "AWS Cloud"); }
	 */

	@ModelAttribute("knowledges")
	List<String> knowledges() {
		return List.of("HTML", "CSS", "JavaScript", "Angular");
	}
}
