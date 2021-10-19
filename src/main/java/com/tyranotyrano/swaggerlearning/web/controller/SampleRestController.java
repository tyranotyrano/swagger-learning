package com.tyranotyrano.swaggerlearning.web.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;

@RestController
public class SampleRestController {

	@ApiOperation("Sample Rest Api 입니다.")
	@GetMapping("/tmp")
	public String tmp() {
		return "Swagger Test Success";
	}
}
