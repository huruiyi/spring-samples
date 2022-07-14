package com.example.demo.controller;

import java.io.File;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.exception.MessageException;
import com.example.demo.pojo.Items;
import com.example.demo.pojo.QueryVo;
import com.example.demo.service.ItemService;

@Controller
public class ItemController {

	@Autowired
	private ItemService itemService;

	// 入门程序 第一 包类 + 类包 + 方法名
	/**
	 * 1.ModelAndView 无敌的 带着数据 返回视图路径 不建议使用 2.String 返回视图路径 model带数据 官方推荐此种方式 解耦 数据
	 * 视图 分离 MVC 建议使用 3.void ajax 请求 合适 json格式数据 （response 异步请求使用
	 * 
	 * @return
	 * @throws MessageException
	 */
	@RequestMapping(value = { "/item/itemlist", "/item/itemlisthaha" })
	public String itemList(Model model, HttpServletRequest request, HttpServletResponse response)
			throws MessageException {
		List<Items> list = itemService.selectItemsList();
		model.addAttribute("itemList", list);
		return "itemList";
	}

	// 去修改页面 入参 id
	@RequestMapping(value = "/itemEdit")
//	public ModelAndView toEdit(@RequestParam(value = "id",required = false,defaultValue = "1") Integer idaaq,
	public ModelAndView toEdit(Integer id, HttpServletRequest request, HttpServletResponse response,
			HttpSession session, Model model) {

//		String id = request.getParameter("id");

//		Items items = itemService.selectItemsById(Integer.parseInt(id));
		Items items = itemService.selectItemsById(id);
		ModelAndView mav = new ModelAndView();
		mav.addObject("item", items);
		mav.setViewName("editItem");
		return mav;
	}

	// 提交修改页面 入参 为 Items对象
	@RequestMapping(value = "/updateitem")
//	public ModelAndView updateitem(Items items){
	public String updateitem(QueryVo vo, MultipartFile pictureFile) throws Exception {
		String name = UUID.randomUUID().toString().replaceAll("-", "");
		String ext = FilenameUtils.getExtension(pictureFile.getOriginalFilename());
		pictureFile.transferTo(new File("D:\\upload\\" + name + "." + ext));
		vo.getItems().setPic(name + "." + ext);
		itemService.updateItemsById(vo.getItems());

//		ModelAndView mav = new ModelAndView();
//		mav.setViewName("success");
		return "redirect:/itemEdit?id=" + vo.getItems().getId();
//		return "forward:/item/itemlist";

	}

	// 删除多个
	@RequestMapping(value = "/deletes")
	public ModelAndView deletes(QueryVo vo) {

		ModelAndView mav = new ModelAndView();
		mav.setViewName("success");
		return mav;
	}

	// 修改
	@RequestMapping(value = "/updates", method = { RequestMethod.POST, RequestMethod.GET })
	public ModelAndView updates(QueryVo vo) {

		ModelAndView mav = new ModelAndView();
		mav.setViewName("success");
		return mav;
	}

	// json数据交互
	@RequestMapping(value = "/json")
	public @ResponseBody Items json(@RequestBody Items items) {
		System.out.println(items);
		return items;
	}

	// RestFul风格的开发
	@RequestMapping(value = "/itemEdit/{id}")
	public ModelAndView toEdit1(@PathVariable Integer id, HttpServletRequest request, HttpServletResponse response,
			HttpSession session, Model model) {
//		String id = request.getParameter("id");
//		Items items = itemService.selectItemsById(Integer.parseInt(id));
		Items items = itemService.selectItemsById(id);
		ModelAndView mav = new ModelAndView();
		// 数据
		mav.addObject("item", items);
		mav.setViewName("editItem");
		return mav;
	}

	// 去登陆的页面
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login() {
		return "login";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(String username, HttpSession httpSession) {
		httpSession.setAttribute("USER_SESSION", username);
		return "redirect:/item/itemlist";
	}
}
