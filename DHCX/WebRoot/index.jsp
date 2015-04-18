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
			<meta http-equiv="Content-Type" content="text/html; charset=gbk">
		<TITLE>电话信息管理 V1.0</TITLE>
		<LINK href="<%=basePath %>css/admin.css" type="text/css" rel="stylesheet">
	</HEAD>
	<FRAMESET border=0 frameSpacing=0 rows="60, *">
		<FRAME name=header src="<%=basePath %>header.jsp" frameBorder=0 noResize
			scrolling=no>
		<FRAMESET cols="170, *">
			<FRAME name=menu src="<%=basePath %>menu.jsp" frameBorder=0 noResize>
			<FRAME name=main src="<%=basePath %>main.jsp" frameBorder=0 noResize scrolling=yes>
		</FRAMESET>
	</FRAMESET>
	<noframes>
	</noframes>
</HTML>
