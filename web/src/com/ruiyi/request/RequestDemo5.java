package com.ruiyi.request;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 *    获得 复杂 表单的数据 (重要 )
  */
@WebServlet(urlPatterns = "/request5")
public class RequestDemo5 extends HttpServlet {

	private static final long serialVersionUID = 5513434565456938346L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// 一行代码解决乱码问题 , 只对 post请求时 有效
		request.setCharacterEncoding("UTF-8");

		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String gender = request.getParameter("gender");
		String birthday = request.getParameter("birthday");
		String city = request.getParameter("city");
		String introduction = request.getParameter("introduction");

		System.out.println("username : " + username);
		System.out.println("password : " + password);
		System.out.println("gender : " + gender);
		System.out.println("birthday : " + birthday);
		System.out.println("city : " + city);
		System.out.println("introduction : " + introduction);

		System.out.println("=======");

		// 以上的 getParameter只能 获得单个参数 参数值, 如果 提交过来的 某个参数 对应了有多个值, 那么 就需要使用下面这个方法了
		String[] hobbies = request.getParameterValues("hobbies");
		if (hobbies != null)
			for (String hobby : hobbies) {
				System.out.println("爱好: " + hobby);
			}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
