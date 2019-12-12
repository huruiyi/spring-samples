package com.ruiyi.session.execises;

import java.io.IOException;
import java.net.InetAddress;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ruiyi.cookie.utils.CookieUtils;

@WebServlet(urlPatterns = "/shoppingCart/showinfo")
public class ShowInfoSerlvet extends HttpServlet {

	private static final long serialVersionUID = 8956150224485355102L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// 获得 点击的 书的 id号
		String id = request.getParameter("id");

		// 获得带过来的cookie 数组 ,查看 有没有 目标的 cookie 对象
		Cookie[] cookies = request.getCookies();

		Cookie targetCookie = CookieUtils.findTargetCookie(cookies, "history");

		if (targetCookie == null) {

			// 说明 没有浏览记录 , 就将当前的 书的id 带过去
			Cookie cookie = new Cookie("history", id);
			cookie.setMaxAge(60 * 60 * 24); // 设置 有效期
			cookie.setPath("/"); // 设置有效路径
			response.addCookie(cookie);

		} else {

			// 说明之前 有浏览记录 ,
			// 如果没有浏览过, 就 将这次的 id 拼接上去 , 如果浏览过, 就什么都不做
			String value = targetCookie.getValue(); // 1-5-3-2

			String[] records = value.split("-");

			if (!checkExistId(records, id)) {
				// 则需要将当前的id 拼接上去 // 1-5-3-2-4
				Cookie cookie = new Cookie("history", value + "-" + id);
				cookie.setMaxAge(60 * 60 * 24); // 设置 有效期
				cookie.setPath("/"); // 设置有效路径
				response.addCookie(cookie);
			}
		}
		String path = this.getServletContext().getContextPath();
		InetAddress inetAddress = InetAddress.getLocalHost();
		System.out.println("Host Address = " + inetAddress.getHostAddress());

		String scheme = request.getScheme();
		String serverName = request.getServerName();
		int serverPort = request.getServerPort();

		String url = String.format("%s://%s:%d", scheme, serverName, serverPort);
		System.out.println(url);

		response.setContentType("text/html;charset=utf-8");
		String vpath = String.format("浏览商品成功.... <a href='%s/%s/jsp/shoppingCart/products.jsp'>继续浏览</a>", url, path);
		response.getWriter().print(vpath);

	}

	// 判断 是否 包含 当前点击的书的id 号
	private boolean checkExistId(String[] records, String id) {
		for (String record : records) {
			if (record.equals(id)) {
				// 如果进来,则说明找到了 当前点击的书
				return true;
			}
		}
		return false;
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
