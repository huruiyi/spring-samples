package com.example.demo.listener;

import javax.servlet.Servlet;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.ServletRegistration;
import javax.servlet.annotation.WebListener;

@WebListener
public class DynRegListener implements ServletContextListener {

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
	}

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		ServletContext servletContext = sce.getServletContext();

		Servlet servlet = null;
		try {
			servlet = servletContext.createServlet(DynamicServlet.class);
		} catch (Exception e) {
			e.printStackTrace();
		}

		if (servlet != null && servlet instanceof DynamicServlet) {
			((DynamicServlet) servlet).setName("Dynamically registered servlet");
		}

		ServletRegistration.Dynamic dynamic = servletContext.addServlet("firstServlet", servlet);
		dynamic.addMapping("/dynamic");
	}
}