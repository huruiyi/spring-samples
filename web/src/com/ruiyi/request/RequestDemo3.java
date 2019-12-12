package com.ruiyi.request;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 * 
 *  referer 实现资源防盗链  
 * 
 */
@WebServlet(urlPatterns = "/request3")
public class RequestDemo3 extends HttpServlet {

	private static final long serialVersionUID = 7440772048171963008L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String referer = request.getHeader("referer");

		// 如果 referer信息的值 等于 空, 或者 不等于 http://localhost:8080/day09_request/1.html , 就认为是
		// 盗链过来 的

		response.setContentType("text/html;charset=utf-8");

		// 主机名 是否是 这个网站的主机名
		if (referer == null || !"http://localhost:8080/day09_request/1.html".equals(referer)) {

			// 如果进来,则说明是 盗链过来的 .
			response.getWriter().print("盗链真无耻.. 先看 广告把....  然后去再 去看采访 页面 ....");
		} else {
			response.getWriter().print("詹姆斯说, 明天晚上 约到  凌云大厦来打篮球...");
		}

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
