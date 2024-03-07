package com.jdc.hello.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

@Component
public class LeagacyController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		var modelView = new ModelAndView("old-style");
		modelView.getModel().put("message", "Hello from leagacy Controller");
		return modelView;
	}

}
