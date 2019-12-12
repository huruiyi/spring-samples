<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!-- 表示页面 5 秒钟后跳转到网站的首页 -->
<meta http-equiv="refresh" content="5;url=http://localhost:8080">

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<base href="<%=basePath%>">

<script type="text/javascript">
	var i = 5;
	function init() {
		document.getElementById("timer").innerHTML = i;
		i--;
		window.setTimeout("init();", 1000); // 1秒后 重新执行 init 函数 
	}
</script>


</head>

<body onload="init();">
	<%=basePath%>
	哥们,
	<span id="timer"></span>
	秒后会跳转到Tomcat服务器首页
</body>
</html>