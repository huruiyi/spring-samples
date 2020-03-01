package com.ruiyi.listener;

@WebListener
public class DynRegListener implements ServletContextListener {

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
	}

	// use createServlet to obtain a Servlet instance that can be
	// configured prior to being added to ServletContext
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

		// the servlet may not be annotated with @WebServlet
		ServletRegistration.Dynamic dynamic = servletContext.addServlet("firstServlet", firstServlet);
		dynamic.addMapping("/dynamic");
	}
}