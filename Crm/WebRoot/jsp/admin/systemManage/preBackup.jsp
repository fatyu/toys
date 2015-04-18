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
					备份数据
				</TD>
			</TR>

		</TABLE>
		<br />
		<br />
		<table cellSpacing=0 cellPadding=0 width="80%" align="center">
			<TR height=20>
				<TD align="center">
					<A href="<%=basePath %>admin/generateExcel?type=gc"><img
							src="<%=basePath%>images/users.png" border="0" alt="备份集团客户数据"
 />
					</A>
				</TD>
				<TD align="center">
					<A href="<%=basePath %>admin/generateExcel?type=pc"><img
							src="<%=basePath%>images/user.png" border="0" alt="备份个人客户数据"
							/>
					</A>
				</TD>
			</TR>
						<TR height=20>
				<TD align="center">
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<A href="<%=basePath %>admin/generateExcel?type=pc">	<font color="blue">备份集团客户数据</font></A>
				</TD>
				<TD align="center">
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<A href="<%=basePath %>admin/generateExcel?type=pc"><font color="blue">备份个人客户数据</font></A>
				</TD>
			</TR>
		</table>
	</BODY>
</HTML>