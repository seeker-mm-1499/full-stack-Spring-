package com.jdc.mappings.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("multi")
public class MultiController {

	@RequestMapping
	public void index() {
		
	}
	/* 
	 * multi/action1
	 */
	@GetMapping("action1")
	public String action1(ModelMap model) {
		model.put("message", "Action 1");
		return "multi";
	}
	/* 
	 * multi/action1 with param
	 */
	@GetMapping(value="action1",params = "id")
	public String action1WithParam(ModelMap model) {
		model.put("message", "Action 1 with id param");
		return "multi";
	}
	/* 
	 * multi/action2
	 */
	@RequestMapping("action2")
	public String action2(ModelMap model) {
		model.put("message", "Action 2");
		return "multi";
	}
	/* 
	 * multi/**
	 */
	@RequestMapping("**")
	public String actionWildCard(ModelMap model) {
		model.put("message", "Other Action");
		return "multi";
	}
	/* 
	 * multi/digti no
	 */
	@RequestMapping("{:\\d+}")
	public String actionDigit(ModelMap model) {
		model.put("message", "Digit Action");
		return "multi";
	}
}
