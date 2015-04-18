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
		<LINK href="<%=basePath%>css/admin.css" type="text/css"
			rel="stylesheet">
		<script src="<%=basePath%>js/prototype.js" type="text/javascript"></script>
		<script src="<%=basePath%>js/effects.js" type="text/javascript"></script>
		<script src="<%=basePath%>js/validation_cn.js" type="text/javascript"></script>
		<link rel="stylesheet" type="text/css"
			href="<%=basePath%>css/style_min.css" />
		<script>
	var valid = new Validation('type');
</script>

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
					添加类型
				</TD>
			</TR>
			<TR bgColor=#ecf4fc height=12>
				<TD></TD>
			</TR>
			<TR height=20>
				<TD></TD>
			</TR>
		</TABLE>
		<form id="type" action="<%=basePath%>admin/customerTypeManage!add"
			method="post" class='required-validate'>
			<TABLE cellSpacing=0 cellPadding=2 width="95%" align=center border=0>
				<TR>
					<TD align=left width=100>
						类型编号：
					</TD>
					<TD style="COLOR: #880000">
						<input type="text" name="typeId"
							class="required min-value-01  max-value-19">
					</TD>
				</TR>
				<TR>
					<TD align=left width=100>
						类型名称：
					</TD>
					<TD style="COLOR: #880000">
						<input type="text" name="typeName" class="required max-length-10 ">
					</TD>
				</TR>

				<TR>
					<TD align=center width=100>
						<input type="submit" value="添加">
					</TD>
					<TD style="COLOR: #880000">
						<input type="reset" value="重置">
					</TD>
				</TR>
			</TABLE>
		</form>
	</BODY>
</HTML>