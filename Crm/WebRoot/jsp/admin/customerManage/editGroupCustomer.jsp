<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
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
		<LINK href="<%=basePath%>/css/admin.css" type="text/css"
			rel="stylesheet">
		<script src="<%=basePath%>js/prototype.js" type="text/javascript"></script>
		<script src="<%=basePath%>js/effects.js" type="text/javascript"></script>
		<script src="<%=basePath%>js/validation_cn.js" type="text/javascript"></script>
		<link rel="stylesheet" type="text/css"
			href="<%=basePath%>css/style_min.css" />
		<script>
	var valid = new Validation('group');
</script>
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
		<TABLE cellSpacing=0 cellPadding=0 width="95%" align=center border=0>
			<TR height=20>
				<TD></TD>
			</TR>
			<TR height=22>
				<TD style="PADDING-LEFT: 20px; FONT-WEIGHT: bold; COLOR: #ffffff"
					align="center" background=<%=basePath %>images/title_bg2.jpg>
					客户信息
				</TD>
			</TR>
			<TR bgColor=#ecf4fc height=12>
				<TD></TD>
			</TR>
			<TR height=20>
				<TD></TD>
			</TR>
		</TABLE>
		<form id="group"
			action="<%=basePath%>admin/groupCustomerManage!update" method="post"
			class='required-validate'>
			<TABLE cellSpacing=0 cellPadding=2 width="95%" align=center border=0>
				<TR>
					<TD align=left width=100>
						集团客户Id：
					</TD>
					<TD style="COLOR: #880000">
						<input type="text" name="groupCustomer.groupCustomerId"
							value='<s:property value="#gc.getGroupCustomerId()" />'
							readonly="readonly">
					</TD>
				</TR>
				<TR>
					<TD align=left width=100>
						集团客户名称：
					</TD>
					<TD style="COLOR: #880000">
						<input type="text" name="groupCustomer.groupCustomerName"
							value='<s:property value="#gc.getGroupCustomerName()" />'
							class="required max-length-30">
					</TD>
				</TR>

				<TR>
					<TD align=left width=100>
						集团地址：
					</TD>
					<TD style="COLOR: #880000">
						<input type="text" name="groupCustomer.groupCustomerAddress"
							value='<s:property value="#gc.getGroupCustomerAddress()" />'
							class="required max-length-50">
					</TD>
				</TR>
				<TR>
					<TD align=left width=100>
						集团邮箱地址：
					</TD>
					<TD style="COLOR: #880000">
						<input type="text" name="groupCustomer.groupCustomerEmail"
							value='<s:property value="#gc.getGroupCustomerEmail()" />'
							class="required  validate-email">
					</TD>
				</TR>

				<TR>
					<TD align=left width=100>
						集团类型：
					</TD>
					<TD style="COLOR: #880000">
						<select name="groupCustomer.groupCustomerType">
							<option  value="01" selected="selected">大型客户</option>
							<option  value="02" >中型客户</option>
							<option  value="03" >小型客户</option>
							<option  value="04" >VIP集团客户</option>
							<option  value="05" >潜在客户</option>
						</select>
					</TD>
				</TR>

				<TR>
					<TD align=left width=100>
						集团联系电话：
					</TD>
					<TD style="COLOR: #880000">
						<input type="text" name="groupCustomer.groupCustomerPhoneNum"
							value='<s:property value="#gc.getGroupCustomerPhoneNum()"/>'
							class="required validate-mobile-phone">
					</TD>
				</TR>
				<TR>
					<TD align=left width=100>
						集团法人证件号：
					</TD>
					<TD style="COLOR: #880000">
						<input type="text" name="groupCustomer.groupCustomerCardNum"
							value='<s:property value="#gc.getGroupCustomerCardNum()" />'
							class="required validate-id-number">
					</TD>
				</TR>
				<TR>
					<TD align=left width=100>
						集团邮编：
					</TD>
					<TD style="COLOR: #880000">
						<input type="text" name="groupCustomer.groupCustomerPostNum"
							value='<s:property value="#gc.getGroupCustomerPostNum()" />'
							class="required validate-zip">
					</TD>
				</TR>
				<TR>
					<TD align=center width=100>
						<input type="submit" value="更新">
					</TD>
					<TD style="COLOR: #880000">
						<input type="reset" value="重置">
					</TD>
				</TR>
			</TABLE>
		</form>
	</BODY>
</HTML>