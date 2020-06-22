package com.ruiyi.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.startup.VersionLoggerListener;

@WebServlet(asyncSupported = true, urlPatterns = "/hello")
public class HelloServlet extends HttpServlet {

	private static final long serialVersionUID = -9138115967681616058L;

	public HelloServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		PrintWriter writer = response.getWriter();
		writer.println("<html>");
		writer.println("<head>");
		writer.println("<title>Hello</title>");
		writer.println("</head>");
		writer.println("<body>");
		writer.println("<h1> Hello   " + request.getContextPath() + " </h1>");
		writer.println("</body>");
		writer.println("</html>");
		writer.append("Served at: ").append(request.getContextPath());
		writer.close();
  	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
