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
					管理数据字典
				</TD>
			</TR>

		</TABLE>
		<br />
		<br />
		<table cellSpacing=0 cellPadding=0 width="80%" align="center">
			<TR height=20>

				<TD align="center">
					<A href="<%=basePath%>admin/sexManage!list"><img
							src="<%=basePath%>images/sex.gif" border="0"
							onmouseover="this.src='<%=basePath%>images/sex1.gif';this.reload();"
							onmouseout="this.src='<%=basePath%>images/sex.gif';this.reload();" />
					</A>
				</TD>
				<TD align="center">
					<A href="<%=basePath%>admin/nationManage!list"><img
							src="<%=basePath%>images/nation.gif" border="0"
							onmouseover="this.src='<%=basePath%>images/nation1.gif';this.reload();"
							onmouseout="this.src='<%=basePath%>images/nation.gif';this.reload();" />
					</A>
				</TD>
				<TD align="center">
					<A href="<%=basePath%>admin/customerTypeManage!list"><img
							src="<%=basePath%>images/type.gif" border="0"
							onmouseover="this.src='<%=basePath%>images/type1.gif';this.reload();"
							onmouseout="this.src='<%=basePath%>images/type.gif';this.reload();" />
					</A>
				</TD>
			</TR>
		</table>
	</BODY>
</HTML>