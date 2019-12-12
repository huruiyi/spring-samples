<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

</head>
<body class="row justify-content-center">

	<%
		Cookie[] cookies = request.getCookies();
		response.getWriter().write("<table>");
		for (int i = 0; i < cookies.length; i++) {
			response.getWriter().write("<tr>");
			response.getWriter().write("<td>");
			response.getWriter().println(cookies[i].getName());
			response.getWriter().write("</td>");

			response.getWriter().write("<td>");
			response.getWriter().println(cookies[i].getValue());
			response.getWriter().write("</td>");
			response.getWriter().write("</tr>");
		}
		response.getWriter().write("</table>");
	%>
</body>
</html>