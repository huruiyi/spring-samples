<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

 <%
 	Cookie cookieuname = new Cookie("uName", "CookeValue1");
    cookieuname.setHttpOnly(true);
    response.addCookie(cookieuname);
   
    Cookie cookieid = new Cookie("uid", "1634547445145");
    cookieid.setHttpOnly(true);
    response.addCookie(cookieid);
 %>
</body>
</html>