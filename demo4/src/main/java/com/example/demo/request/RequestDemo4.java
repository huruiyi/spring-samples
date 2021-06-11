package com.example.demo.request;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 *   获得客户端 提交过来的请求的参数
 *   
 *   	不管是 get还是 post请求,要获得请求参数 , 都可以使用 getParameter方法来获得
 *   	这个方法 获得时, 需要将具体的参数名字传进来,根据名字获得具体的参数的值 
 * 
 * 
 * 		小结:  以后 表单提交, 用post , 一行代码解决 乱码 
 * 
 */
@WebServlet(urlPatterns = "/request4")
public class RequestDemo4 extends HttpServlet {

	private static final long serialVersionUID = 9041911226013121112L;

	// get 执行这个
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String value = request.getParameter("name");

		// 重新将 乱码的值 按照 iso8859-1 编回去, 然后
		// 再以 UTF-8的编码去解码就可以了.
		byte[] bytes = value.getBytes("ISO8859-1");

		value = new String(bytes, "UTF-8");

		System.out.println("get ... name :" + value);
	}

	// post 执行这个
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// 这个对post请求 时 有效, 覆盖请求体中 参数的 编码
		request.setCharacterEncoding("UTF-8");

		String value = request.getParameter("name");
		System.out.println("post ... name :" + value);
	}
}
