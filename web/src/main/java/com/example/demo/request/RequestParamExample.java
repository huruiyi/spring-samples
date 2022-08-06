package com.example.demo.request;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ResourceBundle;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.demo.cookie.utils.HTMLFilter;

@WebServlet(urlPatterns = "/request/param")
public class RequestParamExample extends HttpServlet {

	private static final long serialVersionUID = 1L;

	ResourceBundle rb = ResourceBundle.getBundle("LocalStrings");

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		response.setContentType("text/html");

		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<body>");
		out.println("<head>");

		String title = rb.getString("requestparams.title");
		out.println("<title>" + title + "</title>");
		out.println("</head>");
		out.println("<body bgcolor=\"white\">");

		out.println("<h3>" + title + "</h3>");
		String firstName = request.getParameter("firstname");
		String lastName = request.getParameter("lastname");
		out.println(rb.getString("requestparams.params-in-req") + "<br>");
		if (firstName != null || lastName != null) {
			out.println(rb.getString("requestparams.firstname"));
			out.println(" = " + HTMLFilter.filter(firstName) + "<br>");
			out.println(rb.getString("requestparams.lastname"));
			out.println(" = " + HTMLFilter.filter(lastName));
		} else {
			out.println(rb.getString("requestparams.no-params"));
		}
		out.println("<P>");
		out.print("<form action=\"");
		out.print("RequestParamExample\" ");
		out.println("method=POST>");
		out.println(rb.getString("requestparams.firstname"));
		out.println("<input type=text size=20 name=firstname>");
		out.println("<br>");
		out.println(rb.getString("requestparams.lastname"));
		out.println("<input type=text size=20 name=lastname>");
		out.println("<br>");
		out.println("<input type=submit>");
		out.println("</form>");

		out.println("</body>");
		out.println("</html>");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		doGet(request, response);
	}
}
