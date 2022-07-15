<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="${pageContext.request.contextPath }/public/bootstrap/css/bootstrap.css" rel="stylesheet">
<script type="text/javascript" src="${pageContext.request.contextPath }/public/js/jquery-1.4.4.min.js"></script>
<title>查询商品列表</title>
<script type="text/javascript">
	function sendJson() {
		$.ajax({
			type : "post",
			url : "${pageContext.request.contextPath }/items/sendJson",
			contentType : "application/json;charset=utf-8",
			data : '{"name":"测试商品","price":99.9}',
			success : function(data) {
				alert(JSON.stringify(data));
			}
		});
	}
</script>
</head>
<body class="container">
 <input class="btn btn-primary" type="button" value="Post Json" onClick="sendJson()" />
 <form action="${pageContext.request.contextPath }/updateAll" method="post">
  查询条件：
  <table class="table table-bordered">
   <tr>
    <td>
     <label style="line-height: 34px; float: right;">商品名称:</label>
    </td>
    <td>
     <input class="form-control" type="text" name="items.name" />
    </td>
    <td>
     <label style="line-height: 34px; float: right;">商品价格:</label>
    </td>
    <td>
     <input class="form-control" type="text" name="items.price" />
    </td>
    <td>
     <input class="btn btn-danger" type="submit" value="批量修改" />
    </td>
   </tr>
  </table>
  商品列表：
  <table class="table table-bordered">
   <tr>
    <td></td>
    <td>商品名称</td>
    <td>商品价格</td>
    <td>生产日期</td>
    <td>商品描述</td>
    <td>操作</td>
   </tr>
   <c:forEach items="${itemList }" var="item" varStatus="status">
    <tr>
     <!-- name属性名称要等于vo中的接收的属性名 -->
     <!-- 如果批量删除,可以用List<pojo>来接收,页面上input框的name属性值= vo中接收的集合属性名称+[list的下标]+.+list泛型的属性名称 -->
     <td>
      <input class="btn btn-primary" type="checkbox" name="ids" value="${item.id }" />
      <input type="hidden" name="itemsList[${status.index }].id" value="${item.id }" />
     </td>
     <td>
      <input class="form-control" type="text" name="itemsList[${status.index }].name" value="${item.name }" />
     </td>
     <td>
      <input class="form-control" type="text" name="itemsList[${status.index }].price" value="${item.price }" />
     </td>
     <td>
      <input class="form-control" type="text" name="itemsList[${status.index }].createtime" value="<fmt:formatDate value="${item.createtime}" pattern="yyyy-MM-dd HH:mm:ss"/>" />
     </td>
     <td>
      <input class="form-control" type="text" name="itemsList[${status.index }].detail" value="${item.detail }" />
     </td>

     <td>
      <a class="btn btn-primary" href="${pageContext.request.contextPath }/items/itemEdit/${item.id}">修改</a>
     </td>

    </tr>
   </c:forEach>

  </table>
 </form>
</body>

</html>