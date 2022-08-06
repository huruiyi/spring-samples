package com.example.demo.response;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 *   使用 refresh 头实现页面定时刷新 
 * 
 */
@WebServlet(urlPatterns = "/response3")
public class ResponseDemo3 extends HttpServlet {

	private static final long serialVersionUID = 3650658213754891412L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// 5 秒后 刷新 , 在 原 页面刷新
		// response.setHeader("refresh", "5");

		// 实现5 秒后刷新到其他的页面去 ---- tomcat服务器首页
		response.setHeader("refresh", "5;url=http://localhost:8080");

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
