package com.example.demo.session.execises;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 *   清空商品的浏览记录 
 *   	就是将 存在 与 浏览器 缓存中的 cookie 给删除 
 * 
 */
@WebServlet(urlPatterns = "/shoppingCart/clearrecords")
public class ClearRecordsServlet extends HttpServlet {

	private static final long serialVersionUID = -4233194207837291267L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Cookie cookie = new Cookie("history", "");
		cookie.setMaxAge(0); // 设置 为 0 删除 cookie
		cookie.setPath("/"); // 设置为 / 才能去删除

		response.addCookie(cookie);

		response.sendRedirect(request.getContextPath() + "/jsp/shoppingCart/buy.jsp");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
