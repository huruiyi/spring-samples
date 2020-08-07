<%@page import="java.util.Map"%>
<%@page import="java.util.Set"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
 <a href="${pageContext.request.contextPath}/clearcart">清空购物车</a>

 <%
 	//拿到购物车
 @SuppressWarnings(value = "unchecked")
 Map<String, Integer> cart = (Map<String, Integer>) request.getSession().getAttribute("cart");

 if (cart == null) {
 	out.print("您还没有购买任何商品... <a href='/JavaWeb/jsp/shoppingCart/buy.jsp'>去购买</a>");
 } else {

 	// 遍历 购物车 ,取出 商品信息

 	Set<String> keys = cart.keySet();

 	out.print("哥们, 您 购买的商品 有 :  <br/>");
 	for (String key : keys) {
 		Integer count = cart.get(key);
 		out.print("商品名称 : " + key + ", 数量: " + count + "<br/>");
 	}
 }
 %>
</body>
</html>