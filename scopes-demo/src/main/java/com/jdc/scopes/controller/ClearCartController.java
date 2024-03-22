package com.jdc.scopes.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

@Controller
@SessionAttributes("cart")
public class ClearCartController {

	@GetMapping("/clear-session")
	String clear(SessionStatus status) {
		status.setComplete();
		return "redirect:/";
	}
}
