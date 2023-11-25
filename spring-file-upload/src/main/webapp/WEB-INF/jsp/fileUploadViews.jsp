<%--
  Created by IntelliJ IDEA.
  User: 胡睿毅
  Date: 2023/5/10
  Time: 11:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>Title</title>
</head>
<body>
  <h2>Submitted Files</h2>
  <table>
    <c:forEach items="${files}" var="file">
      <tr>
        <td>OriginalFileName:</td>
        <td>${file.originalFilename}</td>
      </tr>
      <tr>
        <td>Type:</td>
        <td>${file.contentType}</td>
      </tr>
    </c:forEach>
  </table>
</body>
</html>
