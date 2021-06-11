package com.example.demo.response;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 *   设置常用的状态码 
 * 
 * 		200, 302, 304 , 404 ,500
 * 
 */
@WebServlet(urlPatterns = "/response1")
public class ResponseDemo1 extends HttpServlet {

	private static final long serialVersionUID = 8708342750960632992L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setStatus(500);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
