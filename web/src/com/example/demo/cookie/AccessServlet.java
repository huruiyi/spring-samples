package com.example.demo.cookie;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 *   实现 用户上次的访问 时间 代码 实现 
 */
@WebServlet(urlPatterns = "/access")
public class AccessServlet extends HttpServlet {

	private static final long serialVersionUID = -1689460302771112587L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Cookie[] cookies = request.getCookies();

		Cookie tagetCookie = findTargetCookie(cookies, "lastvisit");

		response.setContentType("text/html;charset=utf-8");
		if (tagetCookie == null) {
			response.getWriter().print("姐们, 您是第一次访问本网站哦....");
		} else {
			String value = tagetCookie.getValue();

			long time = Long.parseLong(value);

			response.getWriter().print("姐们, 您上次的访问时间是 : " + new Date(time));
		}

		// 将当前的时间 写 回去
		Cookie cookie = new Cookie("lastvisit", System.currentTimeMillis() + "");

		// 设置 有效 路径 , 这里 的 / 表示 当前 主机名 localhost , 那么就表示 只有访问 localhost主机名下的某个资源的时候才会带过去
		cookie.setPath("/");

		// http://www.baidu.com/mail/servlet1 --- >> / www.baidu.com

		cookie.setMaxAge(60 * 60 * 24 * 7); // 以 当前的时间 开始, 保存 一个 星期 , 以秒为单位
		response.addCookie(cookie); // 将 cookie 写给用户的浏览器...
	}

	// 用于 从 cookie 数组中, 找到 带过来的目标的cookie
	private Cookie findTargetCookie(Cookie[] cookies, String name) {
		if (cookies == null) {
			return null;
		}
		for (Cookie cookie : cookies) {
			if (cookie.getName().equals(name)) {
				return cookie;
			}
		}
		return null;
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
