package com.example.demo.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(asyncSupported = true, urlPatterns = "/log")
public class LogServlet extends HttpServlet {

	private static final long serialVersionUID = -5860880306008483902L;

	@Override
	public void init() throws ServletException {
		super.init();
		log("MyServlet initialized at:" + new Date());
	}

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		super.service(req, res);
		res.setContentType("text/html");
		PrintWriter out = res.getWriter();
		out.println("<html><head><title>" + "Professional JSP 2, 4th Edition</title>");
		out.println("<body><h2>" + getServletName() + "</h2>");
		out.println("This is a basic servlet.<br>");
		out.println("<hr></body></html>");
		out.close();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		super.doGet(req, resp);
	}

	@Override
	public void destroy() {
		super.destroy();
		log("MyServlet was destroyed at:" + new Date());
	}
}
