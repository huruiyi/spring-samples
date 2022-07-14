<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>查询商品列表</title>
<link href="${pageContext.request.contextPath }/public/bootstrap/css/bootstrap.css" rel="stylesheet">
</head>
<body class="container">
 <form class="form-inline" action="${pageContext.request.contextPath }/search" method="post">
  查询条件：
  <div class="row">
   <div class="col-md-5 form-group">
    <label class="col-md-3"> 商品名称</label>
    <div class="col-md-9">
     <input class="form-control" style="width: 100%" type="text" name="items.name" />
    </div>
   </div>
   <div class="col-md-5 form-group">
    <label class="col-md-3"> 商品价格</label>
    <div class="col-md-9">
     <input class="form-control" style="width: 100%" type="text" name="items.price" />
    </div>
   </div>
   <div class="col-md-2  form-group">
    <input class="btn btn-primary" type="submit" value="查询" />
   </div>
  </div>
 </form>

 <table class="table table-bordered">
  <thead>商品列表：
  </thead>
  <tr>
   <td>商品名称</td>
   <td>商品价格</td>
   <td>生产日期</td>
   <td>商品描述</td>
   <td>操作</td>
  </tr>
  <c:forEach items="${itemList }" var="item">
   <tr>
    <td>${item.name }</td>
    <td>${item.price }</td>
    <td>
     <fmt:formatDate value="${item.createtime}" pattern="yyyy-MM-dd HH:mm:ss" />
    </td>
    <td>${item.detail }</td>

    <td>
     <a href="${pageContext.request.contextPath }/itemEdit?id=${item.id}">修改</a>
    </td>

   </tr>
  </c:forEach>
 </table>
</body>

</html>