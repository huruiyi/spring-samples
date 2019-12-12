package com.example.ssm.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.ssm.po.Items;

@Controller
public class ItemsController4 {
	// http://localhost:8080/SpringMvc/itemList.action
	@RequestMapping("/itemList.action")
	public ModelAndView itemList() {

		List<Items> itemList = new ArrayList<Items>();
		itemList.add(new Items(1, "imac", (float) 20000, new Date(), "苹果本很贵"));
		itemList.add(new Items(2, "imac1", (float) 20000, new Date(), "苹果本很贵"));
		itemList.add(new Items(3, "imac2", (float) 20000, new Date(), "苹果本很贵"));
		itemList.add(new Items(4, "imac3", (float) 20000, new Date(), "苹果本很贵"));
		itemList.add(new Items(5, "imac4", (float) 20000, new Date(), "卧槽，苹果本很贵啦！"));

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("itemsList", itemList);
		// 设置展示数据的视图，即jsp
		// modelAndView.setViewName("/WEB-INF/jsp/itemList.jsp");

		// 配置完视图解析器之后只需要返回返回jsp的名称即可
		// 如果这时返回全路径，即/WEB-INF/jsp/itemList.jsp，就不好使了。
		modelAndView.setViewName("items/itemsList");

		// 返回结果
		return modelAndView;
	}

	@RequestMapping(value = "itemDetail1")
	public String sayHello1(Model model) {
		model.addAttribute("hello", "hello World");
		return "/items/itemDetail";
	}

	@RequestMapping(value = "itemDetail2")
	public ModelAndView sayHello2(@RequestParam Map<String, String> params) {
		ModelAndView v = new ModelAndView();
		v.addObject("hello", "hello World");
		v.setViewName("/items/itemDetail");
		return v;
	}

	@RequestMapping(value = "itemDetail3")
	public String sayHello3(@RequestParam Map<String, String> params, Model model) {
		model.addAttribute("hello", "hello World");
		return "/items/itemDetail";
	}
}
