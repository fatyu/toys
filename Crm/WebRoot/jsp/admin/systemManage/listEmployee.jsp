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
					雇员名称
				</TD>

				<TD style="COLOR: #880000">
					雇员地址
				</TD>
				<TD style="COLOR: #880000">
					雇员年龄
				</TD>
				<TD style="COLOR: #880000">
				</TD>
				<TD style="COLOR: #880000">
					数据操作
				</TD>
				<TD style="COLOR: #880000">
				</TD>

			</TR>
			<s:iterator value="#request.employees">
				<TR>
					<TD style="COLOR: #880000">
						<s:property value="employeeName" />
					</TD>
					<TD style="COLOR: #880000">
						<s:property value="employeeAddress" />
					</TD>
					<TD style="COLOR: #880000">
						<s:property value="employeeAge" />
						<TD style="COLOR: #880000">
							<a
								href='<%=basePath%>admin/employeeManage!detail?employee.employeeId=<s:property value="employeeId"/>'>查看详细信息</a>
						</TD>
						<TD style="COLOR: #880000">
							<a
								href='<%=basePath%>admin/employeeManage!delete?employee.employeeId=<s:property value="employeeId"/>'>删除雇员信息</a>
						</TD>
						<TD style="COLOR: #880000">
						<a
								href='<%=basePath%>admin/employeeManage!preUpdate?employee.employeeId=<s:property value="employeeId"/>'>修改雇员信息</a>
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
					<a
						href="<%=basePath%>jsp/admin/systemManage/addEmployee.jsp"><img
							src="<%=basePath%>images/add.png">
						<br />添加雇员</a>
				</TD>
			</TR>
		</TABLE>
	</BODY>
</HTML>