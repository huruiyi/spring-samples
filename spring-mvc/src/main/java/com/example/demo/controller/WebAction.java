package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.service.UserService;

@Controller
public class WebAction {

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/index")
	public String index() {
		return "index";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(@RequestParam("username") String username, @RequestParam("password") String password,
			ModelMap model) {
		if (!userService.isUserExist(username)) {
			model.addAttribute("msg", "用户名不存在！");
		} else {
			if (password.equals(userService.getPasswordByUsername(username))) {
				model.addAttribute("msg", "登录成功！");
			} else {
				model.addAttribute("msg", "密码错误！");
			}
		}
		return "index";
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String register(@RequestParam("username") String username, @RequestParam("password") String password,
			ModelMap model) {
		if (userService.isUserExist(username)) {
			model.addAttribute("msg", "用户名已存在！");
		} else {
			userService.addUser(username, password);
			model.addAttribute("msg", "注册成功！");
		}
		return "index";
	}

	@RequestMapping(value = "/modifyPassword", method = RequestMethod.POST)
	public String modifyPassword(@RequestParam("username") String username, @RequestParam("password") String password,
			@RequestParam("newpassword") String newpassword, ModelMap model) {
		if (!userService.isUserExist(username)) {
			model.addAttribute("msg", "用户名不存在！");
		} else {
			if (password.equals(userService.getPasswordByUsername(username))) {
				userService.modifyPasswordByUsername(username, newpassword);
				model.addAttribute("msg", "修改密码成功！");
			} else {
				model.addAttribute("msg", "密码错误！");
			}
		}
		return "index";
	}
}
