<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<HTML>
	<HEAD>
		<LINK href="<%=basePath%>css/admin.css" type="text/css"
			rel="stylesheet">
	</HEAD>
	<BODY>
		<TABLE cellSpacing=0 cellPadding=0 width="100%" align=center border=0>
			<TR height=28>
				<TD background="<%=basePath%>images/title_bg1.jpg">
					&nbsp;
				</TD>
			</TR>
			<TR>
				<TD bgColor=#b1ceef height=1></TD>
			</TR>
			<TR height=20>
				<TD background="<%=basePath%>images/shadow_bg.jpg"></TD>
			</TR>
		</TABLE>

		<TABLE cellSpacing=0 cellPadding=0 width="95%" align=center border=0>
			<TR height=20>
				<TD></TD>
			</TR>
			<TR height=22>
				<TD style="PADDING-LEFT: 20px; FONT-WEIGHT: bold; COLOR: #ffffff"
					align="center" background="<%=basePath%>images/title_bg2.jpg">
					查看/处理投诉信息
				</TD>
			</TR>

		</TABLE>
		<br />
		<br />
		<table cellSpacing=0 cellPadding=0 width="80%" align="center">
			<TR height=20>
				<TD align="center">
					<A href="<%=basePath%>admin/complainManage!listUnclear"><img
							src="<%=basePath%>images/unclearc1.gif" border="0"
							onmouseover="this.src='<%=basePath%>images/unclearc.gif';this.reload();"
							onmouseout="this.src='<%=basePath%>images/unclearc1.gif';this.reload();" />
					</A>
				</TD>
				<TD align="center">
					<A href="<%=basePath%>admin/complainManage!listClear"><img
							src="<%=basePath%>images/clearc1.gif" border="0"
							onmouseover="this.src='<%=basePath%>images/clearc.gif';this.reload();"
							onmouseout="this.src='<%=basePath%>images/clearc1.gif';this.reload();" />
					</A>
				</TD>
			</TR>
		</table>
	</BODY>
</HTML>