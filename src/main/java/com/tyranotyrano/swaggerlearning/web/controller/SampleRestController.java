package com.tyranotyrano.swaggerlearning.web.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;

@RestController
public class SampleRestController {

	@ApiOperation("Query Parameter 를 사용한 API")
	@ApiImplicitParam(
		name = "id",
		dataType = "long",
		required = true,
		paramType = "query",
		defaultValue = "1",
		value = "Query Parameter 로 받은 ID")
	@GetMapping("/tmp")
	public String readByQueryParameter(@RequestParam(value = "id") Long id) {
		return "[GET] Read With Query Parameter. id = " + id;
	}

	@ApiOperation("Path Variable 을 사용한 API")
	@ApiImplicitParam(
		name = "id",
		dataType = "long",
		required = true,
		paramType = "path",
		defaultValue = "1",
		value = "Path Variable 로 받은 ID")
	@GetMapping("/tmp/{id}")
	public String readByPathVariable(@PathVariable("id") Long id) {
		return "[GET] Read With Path Variable. id = " + id;
	}
}
