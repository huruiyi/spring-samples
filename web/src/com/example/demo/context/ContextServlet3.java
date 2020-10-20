package com.example.demo.context;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ContextServlet3 extends HttpServlet {

	private static final long serialVersionUID = 203839523740170076L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// 获得对 serlvetContext 对象的引用
		ServletContext context = getServletContext();

		context.removeAttribute("name");

		String name = (String) context.getAttribute("name");

		response.setContentType("text/html;charset=utf-8");
		response.getWriter().print("name : " + name);

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}