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
		<LINK href="<%=basePath %>css/admin.css" type="text/css" rel="stylesheet">
	</HEAD>
	<BODY>
		<TABLE cellSpacing=0 cellPadding=0 width="100%" align=center border=0>
			<TR height=28>
				<TD background=<%=basePath %>images/title_bg1.jpg>
					&nbsp;
				</TD>
			</TR>
			<TR>
				<TD bgColor=#b1ceef height=1></TD>
			</TR>
			<TR height=20>
				<TD background=<%=basePath %>images/shadow_bg.jpg></TD>
			</TR>
		</TABLE>

		<TABLE cellSpacing=0 cellPadding=0 width="95%" align=center border=0>
			<TR height=20>
				<TD></TD>
			</TR>
			<TR height=22>
				<TD style="PADDING-LEFT: 20px; FONT-WEIGHT: bold; COLOR: #ffffff"
					align="center" background=<%=basePath %>images/title_bg2.jpg>
					性别详细信息
				</TD>
			</TR>
			<TR bgColor=#ecf4fc height=12>
				<TD></TD>
			</TR>
			<TR height=20>
				<TD></TD>
			</TR>
		</TABLE>
		<TABLE cellSpacing=0 cellPadding=2 width="95%" align=center border=0>
			<TR>
				<TD style="COLOR: #880000">
					性别Id
				</TD>
				<TD style="COLOR: #880000">
					性别名称
				</TD>
				<TD style="COLOR: #880000">
					数据操作
				</TD>
			</TR>

			<s:iterator value="#request.sexs">
				<TR>
					<TD style="COLOR: #880000">
						<s:property value="sexId" />
					</TD>
					<TD style="COLOR: #880000">
						<s:property value="sexName" />
					</TD>
					<TD style="COLOR: #880000">
						<a
							href='<%=basePath%>admin/sexManage!preUpdate?sexId=<s:property value="sexId"  />'>修改性别信息</a>
					</TD>
				</TR>
			</s:iterator>
		</TABLE>
	</BODY>
</HTML>