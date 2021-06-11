package com.example.demo.listener;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/dynamicAnnotation")
public class DynamicServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private String name = "defaultDynamicServlet";

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter writer = response.getWriter();
		writer.println("<html><head><title>First servlet" + "</title></head><body>" + name);
		writer.println("</body></head>");
	}

	public void setName(String name) {
		this.name = name;
	}
}