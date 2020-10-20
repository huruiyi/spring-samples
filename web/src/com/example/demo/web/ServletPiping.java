package com.example.demo.web;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.DispatcherType;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ServletPiping")
//@WebServlet(asyncSupported = true, urlPatterns = "/hello")
public class ServletPiping extends HttpServlet {

	private static final long serialVersionUID = -2938246024891504395L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletPiping() {
		super();
	}

	@Override
	public void service(ServletRequest arg0, ServletResponse arg1) throws ServletException, IOException {
		System.out.println("public void service(ServletRequest arg0, ServletResponse arg1)");
		super.service(arg0, arg1);
	}

	@Override
	protected void service(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {
		System.out.println("protected void service(HttpServletRequest arg0, HttpServletResponse arg1)");
		super.service(arg0, arg1);
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.getWriter().append("Served at: ").append(req.getContextPath());

		String servletInfo = this.getServletInfo();
		String servletName = this.getServletName();
		String contextPath = req.getContextPath();
		String encoding = req.getCharacterEncoding();
		long lengthLong = req.getContentLengthLong();
		String contentType = req.getContentType();
		DispatcherType dispatcherType = req.getDispatcherType();
		Enumeration<String> names = req.getHeaderNames();

		while (names.hasMoreElements()) {
			System.out.println(names.nextElement() + " : " + req.getHeader(names.nextElement()));
		}

		System.out.println("doGet........" + ", ServletInfo: " + servletInfo + ", contextPath: " + contextPath
				+ ", encoding: " + encoding + ", lengthLong: " + lengthLong + ", contentType: " + contentType
				+ ", dispatcherType: " + dispatcherType + ", ServletName " + servletName);

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("doPost........");
	}

	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("doPut........");
	}

	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("doDelete........");
	}

	@Override
	protected void doHead(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {
		System.out.println("doHead........");
		super.doHead(arg0, arg1);
	}

	@Override
	protected void doOptions(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {
		System.out.println("doOptions........");
		super.doOptions(arg0, arg1);
	}

	@Override
	protected void doTrace(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {
		System.out.println("doTrace........");
		super.doTrace(arg0, arg1);
	}

	@Override
	public boolean equals(Object arg0) {
		return super.equals(arg0);
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}

	@Override
	public void destroy() {
		super.destroy();
	}

	@Override
	protected void finalize() throws Throwable {
		super.finalize();
	}

	@Override
	public String getInitParameter(String name) {
		return super.getInitParameter(name);
	}

	@Override
	public Enumeration<String> getInitParameterNames() {
		return super.getInitParameterNames();
	}

	@Override
	protected long getLastModified(HttpServletRequest req) {
		return super.getLastModified(req);
	}

	@Override
	public ServletConfig getServletConfig() {
		return super.getServletConfig();
	}

	@Override
	public ServletContext getServletContext() {
		return super.getServletContext();
	}

	@Override
	public String getServletInfo() {
		return super.getServletInfo();
	}

	@Override
	public String getServletName() {
		return super.getServletName();
	}

	@Override
	public int hashCode() {
		return super.hashCode();
	}

	@Override
	public void init() throws ServletException {
		System.out.println("public void init()");
		super.init();
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		System.out.println("public void init(ServletConfig config)");
		super.init(config);
	}

	public void log(String message, Throwable t) {
		System.out.println("public void log(String message, Throwable t)");
		super.log(message, t);
	}

	@Override
	public void log(String msg) {
		System.out.println("public void log(String msg)");
		super.log(msg);
	}

	@Override
	public String toString() {
		System.out.println("public String toString()");
		return super.toString();
	}

}
