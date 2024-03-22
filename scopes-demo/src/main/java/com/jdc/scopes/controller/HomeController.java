package com.jdc.scopes.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import com.jdc.scopes.model.Counter;

@Controller
public class HomeController {

	@Autowired
	private Counter requestCounter;
	
	@Autowired
	private Counter sessionCounter;
	
	@Autowired
	private Counter applicationCounter;
	
	@GetMapping
	public String index(ModelMap model, HttpServletRequest request,HttpSession session) {
		model.addAttribute("requestCount", requestCounter.countUp());
		model.addAttribute("sessionCount", sessionCounter.countUp());
		model.addAttribute("applicationCount", applicationCounter.countUp());
		
		request.setAttribute("counter", requestCounter);
		session.setAttribute("counter", sessionCounter);
		request.getServletContext().setAttribute("counter", applicationCounter);
		return "home";
	}
}
