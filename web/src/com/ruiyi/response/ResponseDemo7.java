package com.ruiyi.response;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 *  使用servlet 输出数据时 注意的问题
 *  
 *  	1. 再一次请求中, 不能同时去调用getWriter和 getOutputStream .  否则出现如下异常
 *  		getWriter() has already been called for this response
 *  		
 *  		为什么?  一次请求中, 不好控制 输出的先后顺序, 以及 不好控制编码问题, 所以 就 不让同时调用. 
 *  		实际上就是要让两个方法 互斥.( 定义个布尔值, 然后  在 调用某个之后, 立刻将布尔值 更改下,然后 再 后面又 调用另外的 一方时,进行判断, 如果
 *  		发现 布尔值 更改过, 直接抛 异常..)
 *  	2.  一般 javaio 不用了之后要关闭, 但是 由于这里是在serlvet中, 我们调用了getOutputStream , getWriter 之后, 如果没有
 *  		关闭,服务器 会检查 是否已经, 没有关, 就 会自己去关闭. 
 *  		调用close的时候，应该会调用flushBuffer 
 * 
 */
@WebServlet(urlPatterns = "/response7")
public class ResponseDemo7 extends HttpServlet {

	private static final long serialVersionUID = 88002864824340572L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.getOutputStream().print("bbbbbbbbbbbb");

		response.getWriter().print("hhhhhhhhhh");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
