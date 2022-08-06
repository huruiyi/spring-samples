package com.example.demo.request;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.ResourceBundle;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.demo.cookie.utils.HTMLFilter;

@WebServlet(urlPatterns = "/request/header")
public class RequestHeaderExample extends HttpServlet {

	private static final long serialVersionUID = 1L;

	ResourceBundle rb = ResourceBundle.getBundle("LocalStrings");

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		response.setContentType("text/html");

		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<body bgcolor=\"white\">");
		out.println("<head>");

		String title = rb.getString("requestheader.title");
		out.println("<title>" + title + "</title>");
		out.println("</head>");
		out.println("<body>");

		out.println("<h3>" + title + "</h3>");

		out.println("<table border=0>");
		Enumeration<String> e = request.getHeaderNames();
		while (e.hasMoreElements()) {
			String headerName = (String) e.nextElement();
			String headerValue = request.getHeader(headerName);
			out.println("<tr><td bgcolor=\"#CCCCCC\">");
			out.println(HTMLFilter.filter(headerName));
			out.println("</td><td>");
			out.println(HTMLFilter.filter(headerValue));
			out.println("</td></tr>");
		}
		out.println("</table>");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		doGet(request, response);
	}

}
