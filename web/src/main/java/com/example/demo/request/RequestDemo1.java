package com.example.demo.request;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 *  request 获得 客户机信息
 * 
 */
@WebServlet(urlPatterns = "/request/request1")
public class RequestDemo1 extends HttpServlet {

	private static final long serialVersionUID = 6041209371199830764L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		StringBuffer requestURL = request.getRequestURL();
		String requestURI = request.getRequestURI();
		String ip = request.getRemoteAddr();
		String method = request.getMethod();
		String contextPath = request.getContextPath();

		// URI (统一资源标识符) 和url(统一资源 链接 ) 的区别?
		// 一个是爸爸, 一个是 儿子
		System.out.println("requestURL : " + requestURL);
		System.out.println("requestURI : " + requestURI);

		// 来访者的ip地址
		System.out.println("ip : " + ip);

		System.out.println("method : " + method);

		// web工程的对外访问的路径 : /day09_request
		System.out.println("contextPath : " + contextPath);
		System.out.println("=========");

		// 思考： 如何获得当前请求 访问资源路径 ？ ---->>> /request1

		// 学习过滤器 以及 综合 练习时 会使用到 ...
		String path = requestURI.substring(contextPath.length());
		System.out.println("path :" + path);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
