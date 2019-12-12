package com.ruiyi.session;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(urlPatterns = "/session2")
public class SessionServlet2 extends HttpServlet {

	private static final long serialVersionUID = -2901263007306450989L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// 获得session 对象的引用
		HttpSession session = request.getSession();

		// 获得 session 中存的数据
		String name = (String) session.getAttribute("name");

		response.setContentType("text/html;charset=utf-8");
		response.getWriter().print("name :" + name);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
