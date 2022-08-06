<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${pageContext.request.contextPath}</title>

<%
String path = request.getContextPath();
String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>

<base href="<%=basePath%>">
<style type="text/css">
.ryupload {
	position: relative;
	display: inline-block;
	background: #D0EEFF;
	border-radius: 4px;
	overflow: hidden;
	color: #1E88C7;
	text-decoration: none;
	text-indent: 0;
	padding: 0;
}

.ryupload:hover {
	background: #D0EEE6;
}

.ryupload label {
	position: relative;
	display: inline-block;
	overflow: hidden;
	height: 40px;
	width: 100px;
	text-align: center;
	line-height: 40px;
	font-size: 20px;
	width: 100px;
	text-align: center;
	line-height: 40px;
}

.ryupload input[type=file] {
	position: absolute;
	font-size: 100px;
	right: 0;
	top: 0;
	opacity: 0;
}

.ryupload input[type=file]:hover {
	background-color: #fff;
	cursor: pointer;
}

input[type=submit] {
	text-indent: 0;
	background-color: #D0EEFF;
	width: 80px;
	height: 30px;
	background: #D0EEFF;
	border-radius: 4px;
	border: 0px;
	color: #1E88C7;
	display: inline-block;
	overflow: hidden;
	color: #1E88C7;
	outline: none;
}

input[type=submit]:active {
	color: white;
	border-radius: 5px;
	background: #1E88C7;
	opacity: 0.5;
}
</style>
<script type="text/javascript">
	var ryupload = {
		upload : function() {

		},
		init : function(objId) {
			var item = document.getElementById(objId);
			console.log(item);
		}
	};
	window.onload = function() {
		ryupload.init("ry1");
	}
</script>
</head>
<body>
	<fieldset style="color: blue; border: 1px solid blue;">
		<legend style="color: blue">文件上传实验</legend>
		<form action="<%=basePath%>upload" method="post" enctype="multipart/form-data">
			<span class="ryupload" id="ry1"> <label>upload</label> <input name="f1" type="file" title="请选择要上传的文件">
			</span> <span class="ryupload" id="ry1"> <label>upload</label> <input name="f2" type="file" title="请选择要上传的文件">
			</span> <input type="submit" style="" value="上传">
		</form>
	</fieldset>
</body>
</html>