package com.example.demo.servlet;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 *  编写 快速入门的serlvet 程序 
 *  	所以 , 结论是 , 以后写servlet时,  只需要去覆盖 doGet,doPost方法, 而不要去覆盖  service方法 .... 
 */
@WebServlet(urlPatterns = "/shello", initParams = { 
		@WebInitParam(name = "name1", value = "name1_value"),
		@WebInitParam(name = "name2", value = "name2_value") })
public class HelloServlet extends HttpServlet {

	private static final long serialVersionUID = 3461742286264598454L;

	// alt+shift +s
	// 覆盖 doGet和 doPost方法
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("doGet  执行了 , servlet 被执行了");
	}

	@Override
	public void init() throws ServletException {
		ServletConfig config = getServletConfig();

		// 获得单个 的
		String value1 = config.getInitParameter("name1");
		String value2 = config.getInitParameter("name2");
		System.out.println("name1 :" + value1);
		System.out.println("name2 :" + value2);

		System.out.println("===========");

		// 拿到 枚举 集合, 然后 再 遍历 枚举集合, 拿到 每个值
		Enumeration<?> names = config.getInitParameterNames();

		while (names.hasMoreElements()) {
			String name = (String) names.nextElement();
			String vl = config.getInitParameter(name);
			System.out.println("+++++++ name : " + vl);
		}

	}

}
