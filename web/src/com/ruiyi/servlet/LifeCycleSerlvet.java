package com.ruiyi.servlet;

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

	// 当serlvet创建的时候会执行
	@Override
	public void init(ServletConfig config) throws ServletException {
		System.out.println("init ...");
	}

	// 当serlvet 服务 客户端的请求的时候会执行
	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		int i = 1;
		System.out.println("service ...");
		/*
		 * req.getRequestDispatcher("").include(req, res);
		 * req.getRequestDispatcher("").forward(req, res);
		 */
		i++;
		System.out.println(i);

		String yy = "hah";
		System.out.println(yy);
	}

	// 当serlvet 服务销毁请求的时候会执行
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
