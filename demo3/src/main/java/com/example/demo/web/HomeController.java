package com.example.demo.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {

	@RequestMapping(value = "/amecria")
	@ResponseBody
	public String hello() {
		return "Hello World";
	}

	@RequestMapping(value = "/china")
	@ResponseBody
	public String world() {
		return "世界你好";
	}
}
