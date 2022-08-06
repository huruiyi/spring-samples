package com.example.demo.response;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 *   使用 getWriter 输出 字符数据 
 * 
 */
@WebServlet(urlPatterns = "/response5")
public class ResponseDemo5 extends HttpServlet {

	private static final long serialVersionUID = 3484374884638546995L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 老外 喜欢用 iso8859-1 , 西欧的编码, 不支持中文.
		// 二球--- 变成 二进制 -----

		// response.getWriter().print("xxxxxxxxxxxxxxxxxxx");
		response.setCharacterEncoding("gbk");

		// 还要告诉 浏览器 以 什么编码去解 收到的二进制数据
		// 告诉 浏览器 以 UTF-8 码表去解 二进制数据
		// response.setContentType("text/html;charset=utf-8");

		// 注意: 以上解决乱码 ,可以 只写 一行代码解决
		// 由于 charset=utf-8 会 覆盖 setCharacterEncoding 的编码 ,所以这里只调用这一行代码就行了
		response.setContentType("text/html;charset=utf-8");

		// 注意:设置编码时， 要先设置编码 ，然后 再调用 getWriter().print

		response.getWriter().print("二球xxx");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
