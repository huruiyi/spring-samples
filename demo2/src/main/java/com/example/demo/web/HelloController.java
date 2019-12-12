package com.example.demo.web;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

	@RequestMapping(value = "/hello")
	@ResponseBody
	public String hello() {
		return "Hello World";
	}

	@RequestMapping(value = "world")
	public String success(Map<String, Object> paramMap) {
		paramMap.put("name", "thymeleaf");
		paramMap.put("age", 28);
		return "world";
	}

}
