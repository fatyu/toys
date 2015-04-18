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
					结果信息
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
					个人客户名称
				</TD>

				<TD style="COLOR: #880000">
					客户联系方式
				</TD>
				<TD style="COLOR: #880000">
				</TD>
				<TD style="COLOR: #880000">
					数据操作
				</TD>
				<TD style="COLOR: #880000">
				</TD>
<TD style="COLOR: #880000">发送邮件
				</TD>
			</TR>
			<s:iterator value="#request.personCustomers">
				<TR>
					<TD style="COLOR: #880000">
						<s:property value="personCustomerName" />
					</TD>
					<TD style="COLOR: #880000">
						<s:property value="personCustomerPhoneNum" />
						<TD style="COLOR: #880000">
							<a
								href='<%=basePath%>admin/personCustomerManage!detail?personCustomer.personCustomerId=<s:property value="personCustomerId"/>'>查看详细信息</a>
						</TD>
						<TD style="COLOR: #880000">
							<a
								href='<%=basePath%>admin/personCustomerManage!delete?personCustomer.personCustomerId=<s:property value="personCustomerId" />'>删除客户</a>
						</TD>
						<TD style="COLOR: #880000">
							<a
								href='<%=basePath%>admin/personCustomerManage!preUpdate?personCustomer.personCustomerId=<s:property value="personCustomerId" />'>修改客户信息</a>
						</TD>
						
												<TD style="COLOR: #880000">
							<a
								href='mailto:<s:property value="personCustomerEmail" />'>发送邮件</a>
						</TD>
				</TR>
			</s:iterator>
		</TABLE>
		
		<TABLE cellSpacing=0 cellPadding=0 width="95%" align=center border=0>
			<TR height=20>
				<TD></TD>
			</TR>
			<TR height=22>
				<TD style="PADDING-LEFT: 20px; FONT-WEIGHT: bold; COLOR: #000000"
					align="center">
					<a href="<%=basePath %>jsp/admin/customerManage/addPersonCustomer.jsp"><img src="<%=basePath %>images/add.png"><br/>添加个人客户</a>
				</TD>
			</TR>
			</TABLE>
	</BODY>
</HTML>