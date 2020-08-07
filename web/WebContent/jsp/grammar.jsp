<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
 第一个jsp 页面 ....

 <!-- jsp 的声明  :

 使用 声明的语法  , 所声明的 变量 ,方法 , 构造 函数 都会 被翻译到 对应的 servlet的成员变量, 成员方法  

-->
 <%!int m = 10;
	int n = 20;

	public void aa() {

	}%>

 <hr />
 <!--  jsp的  脚本 表达式 
	由于输出数据  使用   脚本 表达式  ,最终使用 的是 out对象输出的 ,而 out 是 jsp 中的一个内置的对象,所以 
	以后 可以 使用  使用 out 输出数据 

 -->
 <%="aaaa"%>
 <%="bbbb" + "cccc"%>

 <!-- jsp 的java代码片段 
 -->
 <%
 	// 通过 这种 形式, 可以写任意的java代码片段
 int p = 99;
 int q = 100;
 %>


 <%
 	for (int i = 0; i < 9; i++) {
 %>
 <font color="red" size="8"><%=i%></font>
 <%
 	}
 %>
 <hr />
 <%
 	request.setAttribute("name", "二蛋蛋");
 String value = (String) request.getAttribute("name");
 out.print(value);
 %>
 <%=value%>
 <%=request.getAttribute("name")%>
 <hr />
 ${name }
</body>
</html>