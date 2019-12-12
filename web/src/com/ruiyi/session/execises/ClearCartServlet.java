package com.ruiyi.session.execises;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 *   清空购物车 , 实际上就是 将  购物车中的商品 给移除 
 *   
 *   	两种方式:
 *   	一:  由于 购物车是存在session中的, 所以可以将session 手动的给销毁
 *   			session.invalidate();
 *   	二:  将购物车从session 中移除 
 *   			session.removetAttribute("cart");
 * 
 */
@WebServlet(urlPatterns = "/shoppingCart/clearcart")
public class ClearCartServlet extends HttpServlet {

	private static final long serialVersionUID = 578362827155130117L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// request.getSession().invalidate();

		request.getSession().removeAttribute("cart");

		// 重定向 回到 购物车 页面
		response.sendRedirect(request.getContextPath() + "/jsp/shoppingCart/buy.jsp");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
