package com.jdc.scopes.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.jdc.scopes.model.StringCart;

@Controller
@SessionAttributes("cart")
public class CreateCartController {

	@GetMapping("/create-session")
	String index() {
		return "cart-view";
	}

	@ModelAttribute("cart")
	StringCart loadCart() {
		return new StringCart();
	}
}
