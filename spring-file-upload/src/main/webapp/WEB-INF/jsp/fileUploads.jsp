<%--
  Created by IntelliJ IDEA.
  User: 胡睿毅
  Date: 2023/5/10
  Time: 11:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<title>Title</title>
</head>
<body>
  <form:form method="POST" action="${pageContext.request.contextPath}/uploadMultiFile" enctype="multipart/form-data">
    <table>
      <tr>
        <td>Select a file to upload</td>
        <td>
          <input type="file" name="files" />
        </td>
      </tr>
      <tr>
        <td>Select a file to upload</td>
        <td>
          <input type="file" name="files" />
        </td>
      </tr>
      <tr>
        <td>Select a file to upload</td>
        <td>
          <input type="file" name="files" />
        </td>
      </tr>
      <tr>
        <td>
          <input type="submit" value="Submit" />
        </td>
      </tr>
    </table>
  </form:form>
</body>
</html>
