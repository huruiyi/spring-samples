package com.ruiyi.response;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 *   练习  生成 xml 格式的文件输出 
 * 	
 * 		mime 类型 可以在 tomcat 服务器的 conf目录下的 web.xml文件中找到 
 * 
 */
@WebServlet(urlPatterns = "/response6")
public class ResponseDemo6 extends HttpServlet {

	private static final long serialVersionUID = 9034575370542690300L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// contentType中告诉 浏览器 打过去的数据是什么 格式的数据
		// 需要直到 xml 文件对应的 mime 类型
		//
		response.setContentType("application/xml;charset=utf-8");
		response.getWriter().println("<world>");
		response.getWriter().println("<china>");
		response.getWriter().println("<beijing>北京</beijing>");
		response.getWriter().println("</china>");
		response.getWriter().println("</world>");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
