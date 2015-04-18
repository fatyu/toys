<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<HTML>
	<HEAD>
		<LINK href="<%=basePath %>css/admin.css" type="text/css" rel="stylesheet">
	</HEAD>
	<BODY>
		<TABLE cellSpacing=0 cellPadding=0 width="100%"
			background="<%=basePath %>images/header_bg.jpg" border=0>
			<TR height=56>
				<TD width=260>
					<IMG height=56 src="<%=basePath %>images/header_left.jpg" width=260>
				</TD>
			</TR>
		</TABLE>
		<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
			<TR bgColor=#1c5db6 height=4>
				<TD></TD>
			</TR>
		</TABLE>
	</BODY>
</HTML>
