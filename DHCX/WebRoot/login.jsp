<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<HTML>
	<HEAD>
		<TITLE>电话信息管理系统</TITLE>
		<meta http-equiv="Content-Type" content="text/html; charset=gbk">
		<LINK href="<%=basePath%>css/admin.css" type="text/css"
			rel="stylesheet">
		<script type="text/javascript">
function getfocus() {
	var node = document.getElementById("username").focus();
}
function checkInput() {//判断用户名或密码是否为空
	var username = document.getElementById("username").value;
	var password = document.getElementById("password").value;

	if (username.replace(/^\s*/, "").replace(/\s*$/, "") == ""
			|| username == null
			|| password.replace(/^\s*/, "").replace(/\s*$/, "") == ""
			|| password == null) {
		alert("用户名或密码不能为空.")
		return false;
	} else {
		return true;
	}
}
</script>
	</HEAD>
	<BODY onload="getfocus()">
	<br/>
	<center>
	<fieldset title="用户登录" style="width:300px"> 

<legend>用户登录</legend>
	<FORM name="login" action="<%=basePath%>CheckUserServlet"
			method="post" onsubmit="return checkInput();">
			用户名
			<INPUT name="username" id="username" 
				style="BORDER-RIGHT: #000000 1px solid; BORDER-TOP: #000000 1px solid; BORDER-LEFT: #000000 1px solid; BORDER-BOTTOM: #000000 1px solid"
				type="text" maxLength=30 size=24 />
				<br/>
				<br/>
			密&nbsp;&nbsp;&nbsp;码
			<INPUT name="password"
				style="BORDER-RIGHT: #000000 1px solid; BORDER-TOP: #000000 1px solid; BORDER-LEFT: #000000 1px solid; BORDER-BOTTOM: #000000 1px solid"
				type="password" maxLength=30 size=24>
				<br/><br/>
				
			<input type="submit" value="登  陆">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<input type="reset" value="重  置">
		</FORM>
	</fieldset>
		</center>
	</BODY>
</HTML>
