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
					集团客户ID
				</TD>
				<TD style="COLOR: #880000">
					集团客户名称
				</TD>
				<TD style="COLOR: #880000">
					集团代表身份证件号码
				</TD>
				<TD style="COLOR: #880000">
					集团地址
				</TD>
				<TD style="COLOR: #880000">
					集团类型
				</TD>
				<TD style="COLOR: #880000">
					集团联系电话
				</TD>
				<TD style="COLOR: #880000">
					集团邮编
				</TD>
			</TR>

			<TR>
				<TD style="COLOR: #880000">
					<s:property value="#gc.getGroupCustomerId()" />
				</TD>
				<TD style="COLOR: #880000">
					<s:property value="#gc.getGroupCustomerName()" />
				</TD>
				<TD style="COLOR: #880000">
					<s:property value="#gc.getGroupCustomerCardNum()" />
				</TD>
				<TD style="COLOR: #880000">
					<s:property value="#gc.getGroupCustomerAddress()" />
				</TD>
				<TD style="COLOR: #880000">
					<s:property value="#ct.getTypeName()" />
				</TD>
				<TD style="COLOR: #880000">
					<s:property value="#gc.getGroupCustomerPhoneNum()" />
				</TD>
				<TD style="COLOR: #880000">
					<s:property value="#gc.getGroupCustomerPostNum()" />
				</TD>
			</TR>
		</TABLE>
	</BODY>
</HTML>