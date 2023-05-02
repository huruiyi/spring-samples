<%--
  Created by IntelliJ IDEA.
  User: hurui
  Date: 2018/12/13
  Time: 15:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
<title>${message}</title>
</head>
<body>
 <form method="post" action="fileupload" enctype="multipart/form-data">
  <input type="file" name="uploadfile">
  <input type="file" name="uploadfile">
  <input type="submit">
 </form>
 
 
 
<fieldset>
    <legend>多文件上传</legend>
    <form action="uploads" method="post" enctype="multipart/form-data">
        <input type="file" name="file"> <br/>
        <input type="file" name="file"> <br/>
        <input type="file" name="file"> <br/>
        <input type="file" name="file"> <br/>
        <input type="submit" value="submit">
    </form>
</fieldset>
</body>
</html>
