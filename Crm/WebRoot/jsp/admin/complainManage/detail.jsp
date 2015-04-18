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
				<TD background=<%=basePath%>images/title_bg1.jpg>
					&nbsp;
				</TD>
			</TR>
			<TR>
				<TD bgColor=#b1ceef height=1></TD>
			</TR>
			<TR height=20>
				<TD background=<%=basePath%>images/shadow_bg.jpg></TD>
			</TR>
		</TABLE>

		<TABLE cellSpacing=0 cellPadding=0 width="95%" align=center border=0>
			<TR height=20>
				<TD></TD>
			</TR>
			<TR height=22>
				<TD style="PADDING-LEFT: 20px; FONT-WEIGHT: bold; COLOR: #ffffff"
					align="center" background=<%=basePath%>images/title_bg2.jpg>
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
		
		<TABLE align="center">
				<TR>
					<TD>
						投诉人:
					</TD>
					<TD style="COLOR: #880000">
						<s:property value='#complain.getComplainName()'/>			</TD>
				</TR>
				<TR>
					<TD>
						投诉信息类别:
					</TD>
					<TD style="COLOR: #880000">
							<s:property value='#complain.getComplainType()'/>
					</TD>
				</TR>
				<TR>
					<TD>
						投诉信息内容:
					</TD>
					<TD style="COLOR: #FF0000">
							<s:property value='#complain.getComplainContent() ' />
					</TD>
				</TR>
				<TR>
					<TD>
						投诉信息日期:
					</TD>
					<TD style="COLOR: #880000">
										<s:property value='#complain.getComplainDate() ' />
					</TD>
				</TR>
								<TR>
					<TD>
						投诉人满意程度:
					</TD>
					<TD style="COLOR: #880000">
											
							<s:property value='#complain.getFeeling() ' />
					</TD>
				</TR>
												<TR>
					<TD>
						投诉解决方案:
					</TD>
					<TD style="COLOR: #880000">
											<s:property value='#complain.getClearType() ' />
					</TD>
				</TR>
												<TR>
					<TD>
						投诉信息状态:
					</TD>
					<TD style="COLOR: #880000">
							投诉已处理 
					</TD>
				</TR>
			</TABLE>
	</BODY>
</HTML>