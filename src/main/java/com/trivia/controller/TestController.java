package com.trivia.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/StarWarsTrivia")
@CrossOrigin
public class TestController {

	@GetMapping
	public String testOutput() {
		return "test";
	}
}
