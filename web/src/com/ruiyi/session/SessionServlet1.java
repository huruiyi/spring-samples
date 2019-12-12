package com.ruiyi.session;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(urlPatterns = "/session1")
public class SessionServlet1 extends HttpServlet {

	private static final long serialVersionUID = -930656865398343382L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// 使用 session 去保存 数据 ,实现数据 共享

		// 注意: session对象的创建 不是 你自己 new 出来的

		// 内部的原理是, 你来访问的时候, 如果 没有为你的浏览器
		// 去 创建过 session 对象, 那么就 会新创建, 如果 已经创建过,
		// 那么就拿 已经创建的session 对象去 为你 服务 .

		HttpSession session = request.getSession();
		session.setAttribute("name", "博博");

		// Set-Cookie: JSESSIONID=FFBF0609C8D8D9EA44777A69A79AA34E
		// 回写同名的 cookie
		// 通过 session.getId() 获得具体的id号
		Cookie cookie = new Cookie("JSESSIONID", session.getId());
		cookie.setMaxAge(60 * 60 * 24);
		cookie.setPath("/");
		response.addCookie(cookie);

		// http://localhost:8080/day11_session/session2;jsessionid=C0C3F33A21C18DF175005E67A466AC77
		// /day11_session/session2
		String url = response.encodeRedirectURL("/day11_session/session2");

		response.getWriter().print("<a href='" + url + "'>session2</a>");

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
