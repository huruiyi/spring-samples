package com.example.demo.session.execises;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 *   处理 用户 购买请求的servlet 程序 :
 *   
 *   	1. 获得购买的商品的信息
 *   	2. 获得session 中购物车 , 去判断 购物车中是否有 当前点击的商品
 *   		  有:　　就将原有的数量取出来 +1 , 再放进去
 *   		没有： 就将现有商品 存进去, 数量设置1 
 *   	3. 需要将购物车存到 session 中去
 *   	4. 给用户提示 , 添加商品到购物车成功... 
 */

@WebServlet(urlPatterns = "/shoppingCart/buy")
public class BuyServlet extends HttpServlet {

	private static final long serialVersionUID = 6666696323375847524L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// 获得id
		String id = request.getParameter("id");

		String[] bookNames = { "C罗必杀技", "夏天来了,你懂得", "辟邪剑谱", "android系统开发原理", "鸟哥的私房菜" };

		// 拿到 书的名字
		String bookName = bookNames[Integer.parseInt(id) - 1];

		// 获得购物车
		@SuppressWarnings("deprecation")
		Object value = request.getSession().getValue("cart");
		System.out.println(value);
		@SuppressWarnings(value = "unchecked")
		Map<String, Integer> attribute = (Map<String, Integer>) request.getSession().getAttribute("cart");
		Map<String, Integer> cart = attribute;

		if (cart == null) {
			// 如果进来,则说明没有 购买国商品,则 new 一个 购物车出来
			cart = new HashMap<String, Integer>();
		}

		if (cart.containsKey(bookName)) {
			// 则说明 之前购买过 这本书 , 获得原有数量, 然后 +1 ,放进去
			Integer count = cart.get(bookName);
			cart.put(bookName, count + 1);
		} else {
			// 没有购买过, 直接 put 进去, 数量为1
			cart.put(bookName, 1);
		}

		// 需要将购物车存到 session 中去
		request.getSession().setAttribute("cart", cart);

		// 给用户提示 , 添加商品到购物车成功.
		response.setContentType("text/html;charset=utf-8");
		response.getWriter().print("添加商品到购物车成功....  <a href='/JavaWeb/jsp/shoppingCart/buy.jsp'>继续购买</a>");

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
