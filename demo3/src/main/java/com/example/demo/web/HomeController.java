package com.example.demo.web;

import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {

	@RequestMapping(value = "/amecria")
	@ResponseBody
	@Secured("ROLE_USER")
	public String hello() {
		return "Hello World";
	}

	@RequestMapping(value = "/china")
	@ResponseBody
	@Secured("ROLE_ADMIN")
	public String world() {
		return "世界你好";
	}
}
