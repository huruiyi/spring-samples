package com.example.demo.servlet;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/*
 *  servlet的声明周期方法 的执行 
 * 
 * 		为了 解决线程安全的问题, 就是 servlet中 不要有成员 变量就可以了 ...
 * 		通过 <load-on-startup>2</load-on-startup>  配置 servlet 在 web应用启动时 就加载
 * 
 */

public class LifeCycleSerlvet implements Servlet {

	public LifeCycleSerlvet() {
		System.out.println("LifeCycleSerlvet  创建了  ....");
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		System.out.println("init ...");
	}

	/*
	 * request.getRequestDispatcher("").include(request, response);
	 * request.getRequestDispatcher("").forward(request, response);
	 */

	@Override
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
		int i = 1;
		System.out.println("service ...");

		i++;
		System.out.println(i);

		String yy = "hah";
		System.out.println(yy);
	}

	@Override
	public void destroy() {
		System.out.println("destroy ...");
	}

	@Override
	public ServletConfig getServletConfig() {
		return null;
	}

	@Override
	public String getServletInfo() {
		return null;
	}

}
