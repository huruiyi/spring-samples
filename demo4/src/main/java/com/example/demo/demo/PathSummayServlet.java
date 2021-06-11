package com.example.demo.demo;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 *   web开发中 路径的写法小结 
 * 
 *     你 每次写路径时, 你自问 自,  你写路径是给谁 用的 ? 
 *     
 *     上来 先写个  / 再说 .
 *     
 *     // 给 浏览器 用的   ----- /  , 那么 / 表示的是当前的主机名 
 *     // 给  web应用的  -----/  ,  那么/ 表示 当前 web应用的 根目录 
 * 
 */
@WebServlet(urlPatterns = "/summary")
public class PathSummayServlet extends HttpServlet {

	private static final long serialVersionUID = 489027364330533617L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getContextPath();

		String path = getServletContext().getRealPath("/");
		String path2 = request.getSession().getServletContext().getRealPath("/");
		System.out.println(path + "--------------" + System.getProperty("user.dir"));
		System.out.print(path2 + "--------------");

		// 1. 转发 的时候
		request.getRequestDispatcher("/servlet2").forward(request, response);

		// 2. 重定向的时候
		response.sendRedirect("/day11/1.html");

		// 3. 读取 web应用下资源文件的时候 --- 在web 应用根目录下有一个 1.txt 文件
		getServletContext().getRealPath("/1.txt");

		// 4. 表单 提交数据的时候
		// <form action="/day11/servlet2">

		// 5. 超链接 a 标签 的时候
		// <a href="/day12/1.jsp"></a>

		// 6. 写了 img 标签, src
		// <img src="/day11/checkimage">

		// 7. url重写 http://.../servlet;jsessionid=KSDFLKDSJFLKJDS
		response.encodeURL("/day11/servlet2");

		// =========================================================

		// 8. 使用类加载器 获得文件的 路径的时候
		PathSummayServlet.class.getClassLoader().getResource("4.txt");

		InputStream in1 = PathSummayServlet.class.getClassLoader().getResourceAsStream("6.jpg");

		InputStream in2 = getServletContext().getResourceAsStream("/WEB-INF/classes/6.jpg");
		in1.close();
		in2.close();

		PathSummayServlet.class.getResource("/4.txt");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
