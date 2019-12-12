package com.ruiyi.context;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 *     统计网站的访问次数 小练习 :
 *     
 *     	1. 在init 方法中 搞个计数器的初始值  是 0, 并且存到 servletContext域 中去
 *      2. 在doGet 方法中,取出 原有的值, 然后 +1 ,然后再 放回去 .
 *      3. 取出  存在  servletContext 的次数, 显示一下. 
 * 
 */
public class AccessTimesServlet extends HttpServlet {

	private static final long serialVersionUID = -2758872636528299105L;

	@Override
	public void init() throws ServletException {
		getServletContext().setAttribute("times", 0);
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int times = (Integer) getServletContext().getAttribute("times");

		times++;

		getServletContext().setAttribute("times", times);

		response.setContentType("text/html;charset=utf-8"); // 解决中文的乱码
		response.getWriter().print("哥们,您当前的是 第  " + times + "位 来访问 本网站的 用户 ");
	}

}
