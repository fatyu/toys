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
					详细信息
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
					雇员Id
				</TD>
				<TD style="COLOR: #880000">
					雇员名称
				</TD>
				<TD style="COLOR: #880000">
					雇员住址
				</TD>
				<TD style="COLOR: #880000">
					雇员工资
				</TD>
				<TD style="COLOR: #880000">
					性别
				</TD>
				<TD style="COLOR: #880000">
					民族
				</TD>
			</TR>

			<TR>
				<TD style="COLOR: #880000">
					<s:property value="#employee.getEmployeeId()" />
				</TD>
				<TD style="COLOR: #880000">
					<s:property value="#employee.getEmployeeName()" />
				</TD>
				<TD style="COLOR: #880000">
					<s:property value="#employee.getEmployeeAddress()" />
				</TD>
				<TD style="COLOR: #880000">
					<s:property value="#employee.getEmployeeSalary()" />
				</TD>
				<TD style="COLOR: #880000">
					<s:property value="#sex.getSexName()" />
				</TD>
				<TD style="COLOR: #880000">
					<s:property value="#nation.getNationName()" />
				</TD>
			</TR>
		</TABLE>
	</BODY>
</HTML>