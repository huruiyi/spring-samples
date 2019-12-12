<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		HttpSession hsession = request.getSession();
		Object obj = hsession.getAttribute("projects");
		if (obj != null && !obj.toString().isEmpty()) {
			response.getWriter().print("服务器已经存在该【projects】了，projects值是：" + obj.toString());
		} else {
			response.getWriter().print("Session 【projects】 不存在或已过期");
		}
	%>
</body>
</html>