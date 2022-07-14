package com.example.demo.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.pojo.Items;
import com.example.demo.pojo.QueryVo;
import com.example.demo.service.ItemService;

@Controller
public class ItemController {

	@Autowired
	private ItemService itemService;

	@RequestMapping(value = "/item/itemlist.action")
	public ModelAndView itemList() {
		List<Items> list = itemService.selectItemsList();
		ModelAndView mav = new ModelAndView();
		mav.addObject("itemList", list);
		mav.setViewName("itemList");
		return mav;
	}

	@RequestMapping(value = "/itemEdit2.action")
	public ModelAndView toEdit(Integer id, HttpServletRequest request, HttpServletResponse response,
			HttpSession session, Model model) {
		System.out.println(Integer.parseInt(request.getParameter("id")));
		Items items = itemService.selectItemsById(id);
		ModelAndView mav = new ModelAndView();
		mav.addObject("item", items);
		mav.setViewName("editItem");
		return mav;
	}

	@RequestMapping(value = "/itemEdit.action")
	public ModelAndView toEdit(@RequestParam(value = "id", required = false, defaultValue = "1") Integer id2,
			HttpSession session, Model model) {
		Items items = itemService.selectItemsById(id2);
		ModelAndView mav = new ModelAndView();
		mav.addObject("item", items);
		mav.setViewName("editItem");
		return mav;
	}

	// 提交修改页面 入参 为 Items对象
	@RequestMapping(value = "/updateitem.action")
	public ModelAndView updateitem(QueryVo vo) {
		itemService.updateItemsById(vo.getItems());
		ModelAndView mav = new ModelAndView();
		mav.setViewName("success");
		return mav;
	}

}
