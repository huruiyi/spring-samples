package com.ruiyi.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/srequest1")
public class RequestSerlvet1 extends HttpServlet {

	private static final long serialVersionUID = -4299256560597588626L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// 使用 request 实现数据的 共享
		request.setAttribute("name", "测试name");

		// 不想处理来访者的请求

		// 将 请求转发给 B serlvet去 处理

		// 写的时候 , 必须要 加 / , 这个/ 表示 web 应用 .
		// 转发的时候, 只能够 转发到 当前 web应用 内部的 某个 资源. 不能 指向 当前 web应用 外部的资源.

		request.getRequestDispatcher("/srequest2").forward(request, response);

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
