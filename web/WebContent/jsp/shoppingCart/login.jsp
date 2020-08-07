<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function changeImage() {

		document.getElementById("myimage").src = "/JavaWeb/shoppingCart/checkimage?"
				+ new Date().getTime();
	}
</script>
</head>
<body>
 <h3>XX网站的登录页面</h3>
 <font color="red" size="5">${message }</font>
 <form action="${pageContext.request.contextPath}/shoppingCart/login" method="post">
  用户名:
  <input type="text" name="username">
  <br />
  密码:
  <input type="password" name="password">
  <br />
  验证码:
  <input type="text" name="checkcode">
  <img src="${pageContext.request.contextPath}/shoppingCart/checkimage" style="cursor: pointer" onclick="changeImage();" id="myimage">
  <br />
  <input type="submit" value="登录">
 </form>
</body>
</html>