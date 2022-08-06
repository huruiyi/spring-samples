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
		hsession.setAttribute("projects", "JavaWeb編程");
		//Session 过期时间 单位:秒
		hsession.setMaxInactiveInterval(10);
		String sessionId = hsession.getId();
		//判断session是不是新创建的
		if (hsession.isNew()) {
			response.getWriter().print("session创建成功，session的id是：" + sessionId);
		} else {
			response.getWriter().print("服务器已经存在该session了，session的id是：" + sessionId);
		}
	%>
</body>
</html>