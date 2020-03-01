package com.ruiyi.response;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 *   控制浏览器禁止缓存 
 *   
 *   	禁止缓存的时候, 这三个 头 都写一下, 由于 市面 的 浏览器 太多了, 有的浏览支持这个, 有的支持那个..
 * 
 */
@WebServlet(urlPatterns = "/response4")
public class ResponseDemo4 extends HttpServlet {

	private static final long serialVersionUID = -288204452719808431L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// 设置浏览器 禁止缓存
		response.setHeader("cache-control", "no-cache");
		response.setHeader("pragma", "no-cache");
		response.setDateHeader("expires", -1);

		response.getWriter().print(new Date());
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
