package com.example.demo.response;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/response2/login")
public class ResponseDemo2 extends HttpServlet {

	private static final long serialVersionUID = 613274563947518305L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// 获得用户 名 个和 密码
		String username = request.getParameter("username");
		String password = request.getParameter("password");

		// 这里 将 字符串 admin 写 在 前面 是 为了 避免 表单 没有 带 username 或password 时 出现 空指针 异常
		if ("admin".equals(username) && "admin".equals(password)) {

			// 如果进来, 则说明用户名和密码正确, 登录成功

			// 302 + location

			// response.setStatus(302);
			// response.setHeader("location", "/day09_response/index.html"); // value 值 就是
			// 重定向到 首页的地址

			// 这行代码 与上面两行的代码的效果是一样的, 查看源代码, 发现这个方法中 调用了如上两行代码
			//
			/*
			 * setStatus(SC_FOUND); setHeader("Location", absolute);
			 * 
			 */

			response.sendRedirect("/JavaWeb/jsp/response2/index.html");

		}

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
