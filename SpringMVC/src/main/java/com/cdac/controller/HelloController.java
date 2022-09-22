package com.cdac.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {

	@RequestMapping("/hello.cdac")
	public String hello(Map model) {
		model.put("message", "Welcome to the Spring MVC");
		return "Hello.jsp";
	}
}
