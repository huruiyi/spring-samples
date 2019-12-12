package com.ruiyi.context;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 *  使用 serlvletContext 获得  web应用全局的初始化参数信息
 * 
 */
public class ContextSerlvet1 extends HttpServlet {

	private static final long serialVersionUID = -2587461639198040232L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletContext context = getServletContext();
		String value = context.getInitParameter("encoding");
		System.out.println("encoding : " + value);
		System.out.println("===========");

		Enumeration<?> names = context.getInitParameterNames();
		while (names.hasMoreElements()) {
			String name = (String) names.nextElement();
			String vl = context.getInitParameter(name);
			System.out.println("+++++++ name : " + vl);
		}
	}

}
