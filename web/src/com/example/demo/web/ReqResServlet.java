package com.example.demo.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ReqResServlet extends HttpServlet {
	 
	private static final long serialVersionUID = 980368331750042592L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		super.doGet(req, resp);
		String name = req.getParameter("name");
		int age = Integer.parseInt(req.getParameter("age"));
		System.out.println("姓名:" + name + ",年龄:" + age);
		resp.setContentType("text/html;charset=utf-8");
		// resp.setCharacterEncoding("gb2312");
		resp.getWriter().println("姓名:" + name + ",年龄:" + age);
	}

}
