<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
 <h3>本网站出售如下商品</h3>
 C罗必杀技 :
 <a href="${pageContext.request.contextPath}/shoppingCart/buy?id=1">购买</a>
 <br />
 夏天来了,你懂得 :
 <a href="${pageContext.request.contextPath}/shoppingCart/buy?id=2">购买</a>
 <br />
 辟邪剑谱 :
 <a href="${pageContext.request.contextPath}/shoppingCart/buy?id=3">购买</a>
 <br />
 android系统开发原理 :
 <a href="${pageContext.request.contextPath}/shoppingCart/buy?id=4">购买</a>
 <br />
 鸟哥的私房菜 :
 <a href="${pageContext.request.contextPath}/shoppingCart/buy?id=5">购买</a>
 <br />
 <hr />
 <a href="${pageContext.request.contextPath}/jsp/shoppingCart/cart.jsp">查看购物车</a>
 <hr />
 <br />
 <a href="${pageContext.request.contextPath}/shoppingCart/clearcart">清空购物车</a>
</body>
</html>