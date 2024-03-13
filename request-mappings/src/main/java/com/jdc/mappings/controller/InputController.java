package com.jdc.mappings.controller;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.MatrixVariable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jdc.mappings.model.dto.Level;

@Controller
@RequestMapping("inputs")
public class InputController {
	@GetMapping
	public void index() {

	}

	// /inputs/${pathVaribale}/search/{id:\\d+}
	@RequestMapping("{type}/search/{id:\\d+}")
	public String home(@PathVariable String type, @PathVariable Integer id, Model model) {
		model.addAttribute("type", type);
		model.addAttribute("id", id);
		return "inputs";
	}

	@RequestMapping("{date:\\d{4}\\-\\d{2}\\-\\d{2}}")
	public String dateInput(
			@PathVariable 
			@DateTimeFormat(pattern = "yyyy-MM-dd") 
			LocalDate date,
			Model model) {
		model.addAttribute("date",date);
		return "inputs";
	}
	@GetMapping("{level:Basic|Intermediate|Advance}")
	public String enumInput(@PathVariable Level level,Model model) {
		model.addAttribute("level",level);
		return "inputs";
	}
	@GetMapping("matrix/{product}")
	public String matrixInput(
			@PathVariable String product,
			@MatrixVariable String size,
			@MatrixVariable int count,
			Model model
			) {
		var message="Product: %s , Size: %s , Count: %d".formatted(product,size,count);
		model.addAttribute("Message",message);
		return "inputs";
	}
	@GetMapping("request")
	public String requestParam(
			@RequestParam("p") String product,
			@RequestParam("w") int width,
			@RequestParam("l") int length,
			Model model
			) {
		var type = "Prodcut: %s , Width: %d , Length: %d".formatted(product,width,length);
		model.addAttribute("date",type);
		return "inputs";
	}

}
