<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
 <jsp:useBean id="date" class="com.ruiyi.web.DateFormatBean">
  <jsp:setProperty name="date" property="format" value="EEE, d MMM yyyy HH:mm:ss z" />
 </jsp:useBean>

 <h2>
  Today's Date is
  <jsp:getProperty name="date" property="date" /></h2>
</body>
</html>