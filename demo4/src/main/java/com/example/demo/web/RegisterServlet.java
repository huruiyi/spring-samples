package com.example.demo.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/register", asyncSupported = true)
public class RegisterServlet extends HttpServlet {

	private static final long serialVersionUID = -3072109741540632145L;

	public RegisterServlet() {
		super();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter writer = resp.getWriter();
		writer.write("Hello doGet");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		resp.setContentType("text/html;charset=utf-8");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");

		String name = req.getParameter("name");
		String title = req.getParameter("title");
		String category = req.getParameter("category");
		String[] features = req.getParameterValues("features");
		String provinceid = req.getParameter("provinceid");
		String remark = req.getParameter("remark");

		StringBuilder sbfeatures = new StringBuilder();
		sbfeatures.append("[");
		for (int i = 0; i < features.length; i++) {
			sbfeatures.append(features[i] + " ");
		}
		sbfeatures.append("]");
		resp.getWriter().write("doPost接收到的数据: " + name + "  " + title + " " + category + " " + sbfeatures + "  "
				+ provinceid + "  " + remark);
		System.out.println("doPost接收到的数据: " + name + "  " + title + " " + category + " " + sbfeatures + "  "
				+ provinceid + "  " + remark);
	}
}
