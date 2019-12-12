package com.ruiyi.request;

import java.io.IOException;
import java.util.Enumeration;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 *  获得请求头的信息
 * 
 */
@WebServlet(urlPatterns = "/request2")
public class RequestDemo2 extends HttpServlet {

	private static final long serialVersionUID = 1937544123148814896L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String header = request.getHeader("User-Agent");
		System.out.println("User-Agent=" + header);
		System.out.println("====");
		Enumeration<?> names = request.getHeaderNames();
		while (names.hasMoreElements()) {
			String name = (String) names.nextElement();
			String value = request.getHeader(name);
			System.out.println(name + " = " + value);
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
