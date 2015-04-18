<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<HTML>
	<HEAD>
	<meta http-equiv="Content-Type" content="text/html; charset=gbk">
		<LINK href="<%=basePath%>/css/admin.css" type="text/css"
			rel="stylesheet">
	</HEAD>
	<BODY>
		<TABLE cellSpacing=0 cellPadding=0 width="100%" align=center border=0>
			<TR height=28>
				<TD background=<%=basePath%> /images/title_bg1.jpg>
					&nbsp;
				</TD>
			</TR>
			<TR>
				<TD bgColor=#b1ceef height=1></TD>
			</TR>
			<TR height=20>
				<TD background=<%=basePath%> /images/shadow_bg.jpg></TD>
			</TR>
		</TABLE>
		<TABLE cellSpacing=0 cellPadding=0 width="95%" align="center" border=0>
			<TR height=20>
				<TD></TD>
			</TR>
			<TR height=22>
				<TD style="PADDING-LEFT: 20px; FONT-WEIGHT: bold; COLOR: #ffffff"
					align="center" background="<%=basePath%>images/title_bg2.jpg">
					修改密码
				</TD>
			</TR>
			<TR bgColor=#ecf4fc height=12>
				<TD></TD>
			</TR>
			<TR height=20>
				<TD></TD>
			</TR>
		</TABLE>
		<form action="<%=basePath%>EditPasswordServlet" method="post" >
			<TABLE cellSpacing=0 cellPadding=2 width="95%" align="center" border=0>
				<TR >
					<TD width=100>
						原密码:
					</TD>
					<TD style="COLOR: #880000">
						<input type="password" name="lastpasswrod" value="">
						<input type="hidden" name="currentUserPwd" value="${sessionScope.user.password }">
						<input type="hidden" name="username" value="${sessionScope.user.username }">
					</TD>
				</TR>
				<TR >
					<TD width=100>
						新密码:
					</TD>
					<TD style="COLOR: #880000">
						<input type="password" name="password" value="" />
					</TD>
				</TR>
				<TR >
					<TD width=100>
						确认密码:
					</TD>
					<TD style="COLOR: #880000">
						<input type="password" name="repassword" value="" />
					</TD>
				</TR>
				<TR >
					<TD width=100>
						<input type="submit" value="修  改">
					</TD>
					<TD style="COLOR: #880000">
						<input type="reset" value="重  置">
					</TD>
				</TR>
			</TABLE>
		</form>
	</BODY>
</HTML>