<%@page import="com.example.demo.cookie.utils.CookieUtils"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
 <h3>某东网站出售的商品列表</h3>
 九阴真经:
 <a href="${pageContext.request.contextPath}/showinfo?id=1">查看</a>
 <br />
 如来神掌:
 <a href="${pageContext.request.contextPath}/showinfo?id=2">查看</a>
 <br />
 这书能让你戒烟:
 <a href="${pageContext.request.contextPath}/showinfo?id=3">查看</a>
 <br />
 别太单纯,也别太不单纯:
 <a href="${pageContext.request.contextPath}/showinfo?id=4">查看</a>
 <br />
 辟邪剑谱:
 <a href="${pageContext.request.contextPath}/showinfo?id=5">查看</a>
 <br />
 <hr />
 <br />
 <br />
 <a href="${pageContext.request.contextPath}/shoppingCart/clearrecords">清空商品的浏览记录</a>
 <br />
 <br />
 <br />
 <a href="/JavaWeb/jsp/shoppingCart/buy.jsp">去购物去</a>
 <hr />
 <%
 	Cookie[] cookies = request.getCookies();

 Cookie targetCookie = CookieUtils.findTargetCookie(cookies, "history");
 if (targetCookie == null) {
 	out.print("你还没有浏览过任何的商品.... <a href='/JavaWeb/jsp/shoppingCart/buy.jsp'>去浏览</a>");
 } else {
 	String value = targetCookie.getValue(); // 1-5-3-4-2
 	String[] records = value.split("-");
 	String[] bookNames = { "九阴真经", "如来神掌", "这书能让你戒烟", "别太单纯,也别太不单纯", "辟邪剑谱" };
 	out.print("您浏览过的商品有: <br/>");
 	for (String record : records) {
 		out.print("书名: " + bookNames[Integer.parseInt(record) - 1] + "<br/>");
 	}

 }
 %>
</body>
</html>