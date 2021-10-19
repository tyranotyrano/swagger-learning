package com.tyranotyrano.swaggerlearning.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ViewController {

	@GetMapping("/")
	public String index(Model model) {
		model.addAttribute("message", "index : Hello Swagger!!!");
		return "index";
	}
}
