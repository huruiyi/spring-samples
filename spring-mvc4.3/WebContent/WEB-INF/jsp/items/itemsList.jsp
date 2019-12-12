<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>查询商品列表</title>
<link href="${pageContext.request.contextPath }/assets/bootstrap/css/bootstrap.css" rel="stylesheet">

</head>
<body class="container">
	<form action="${pageContext.request.contextPath }/item/queryItem.action" method="post">
		查询条件：
		<table class="table table-bordered">
			<tr>
				<td>
					<input class="btn" type="submit" value="查询" />
				</td>
			</tr>
		</table>
		商品列表：
		<table class="table table-bordered">
			<tr>
				<td>商品名称</td>
				<td>商品价格</td>
				<td>生产日期</td>
				<td>商品描述</td>
				<td>操作</td>
			</tr>
			<c:forEach items="${itemsList }" var="item">
				<tr>
					<td>${item.name }</td>
					<td>${item.price }</td>
					<td>
						<fmt:formatDate value="${item.createtime}" pattern="yyyy-MM-dd HH:mm:ss" />
					</td>
					<td>${item.detail }</td>
					<td>
						<a href="${pageContext.request.contextPath }/items/editItems.action?id=${item.id}">修改</a>
					</td>
				</tr>
			</c:forEach>
		</table>
	</form>
</body>

</html>