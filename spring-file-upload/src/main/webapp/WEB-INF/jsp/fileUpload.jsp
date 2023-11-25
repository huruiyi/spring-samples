<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<title>Title</title>
</head>
<body>
  <form:form method="POST" action="${pageContext.request.contextPath}/uploadFile" enctype="multipart/form-data">
    <table>
      <tr>
        <td>
          <input type="file" name="file" />
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
