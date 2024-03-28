<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Hello World!</title>
</head>
<body>
<h2><s:property value="messageStore.message"/></h2>
<p><s:property value="messageStore"/></p>

<p>I've said hello <s:property value="helloCount"/> times!</p>

<s:url action="hello" var="helloLink">
    <s:param name="userName">nida</s:param>
</s:url>

<p><a href="${helloLink}">Hello</a></p>


<p>Get your own personal hello by filling out and submitting this form.</p>

<s:form action="hello">
    <s:textfield name="userName" label="Your name"/>
    <s:submit value="Submit"/>
</s:form>

<p><a href="register.jsp">Please register</a> for our prize drawing.</p>

</body>
</html>