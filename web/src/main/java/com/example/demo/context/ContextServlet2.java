package com.example.demo.context;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 *   使用  ServletContext 实现数据共享
 * 
 */
@WebServlet(urlPatterns = "/context/serlvet2")
public class ContextServlet2 extends HttpServlet {

	private static final long serialVersionUID = 2467631782607320630L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 获得对 serlvetContext 对象的引用
		ServletContext context = getServletContext();
		context.setAttribute("name", "玲玲");
	}

}
