package com.example.demo.session.execises;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/shoppingCart/login")
public class LoginServlet extends HttpServlet {

	private static final long serialVersionUID = 5075109230873308730L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");

		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String checkcode = request.getParameter("checkcode");

		String checkcode_session = (String) request.getSession().getAttribute("checkcode_session");

		if (checkcode == null || !checkcode.equalsIgnoreCase(checkcode_session)) {
			request.setAttribute("message", "对不起, 您输入验证码信息不正确...");
			request.getRequestDispatcher("/jsp/shoppingCart/login.jsp").forward(request, response);
			return;
		}

		if ("admin".equals(username) && "admin".equals(password)) {
			request.getSession().setAttribute("loginUser", "admin");
			response.sendRedirect(request.getContextPath() + "/jsp/shoppingCart/buy.jsp");

		} else {
			request.setAttribute("message", "对不起, 您 是用户名或密码不正确...");
			request.getRequestDispatcher("/jsp/shoppingCart/login.jsp").forward(request, response);
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
