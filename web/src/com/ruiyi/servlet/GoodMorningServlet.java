package com.ruiyi.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 *   servlet 对 页面 美化 是不擅长的, 有其 缺点 (是致命的 )
 *   ---sun 公司, 后来 为了解决这个问题, 就参考了asp的语法 ,  弄出来 jsp 的技术规范 
 *   jsp, asp, php     
 *   jsp:   html代码(html,css,js ) , java代码 

 */
public class GoodMorningServlet extends HttpServlet {

	private static final long serialVersionUID = 2217256864231324369L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		response.getWriter().println("<html>");
		response.getWriter().println("<body>");
		response.getWriter().println("<font color='red'>早上好, 亲, 今天敲代码了 吗 ?????</font>");
		response.getWriter().println("</body>");
		response.getWriter().println("</html>");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
