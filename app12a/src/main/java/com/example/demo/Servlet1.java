package com.example.demo;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.HttpConstraint;
import javax.servlet.annotation.ServletSecurity;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 
 * <auth-constraint> 
 *	 <role-name>member</role-name>
 * 	 <role-name>manager</role-name> 
 * </auth-constraint>
 * 
 *  也可以指定多个角色
 * 
 * <role rolename="tomcat"/> <role rolename="admin"/> <role rolename="role1"/>
 * <role rolename="member"/>
 * <user username="member" password="member" roles="member"/>
 * <user username="tomcat" password="tomcat" roles="tomcat"/>
 * <user username="both" password="both" roles="tomcat,role1"/>
 * <user username="role1" password="role1" roles="role1,admin"/>
 *
 */
@WebServlet(urlPatterns = { "/servlet1" })
@ServletSecurity(@HttpConstraint(rolesAllowed = "member"))
public class Servlet1 extends HttpServlet {

	private static final long serialVersionUID = -11420L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/servlet1.jsp");
		dispatcher.forward(request, response);

	}
}
