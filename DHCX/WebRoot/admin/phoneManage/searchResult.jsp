<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ page import="com.itlamp.bean.Person"%>
<%@ page import="com.itlamp.bean.User"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<HTML>
	<HEAD>
		<meta http-equiv="Content-Type" content="text/html; charset=gbk">
		<LINK href="<%=basePath %>css/admin.css" type="text/css"
			rel="stylesheet">
	</HEAD>
	<BODY>

		<div>
			<jsp:include page="search.jsp" />
		</div>
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
					电话信息
				</TD>
			</TR>
			<TR bgColor=#ecf4fc height=12>
				<TD></TD>
			</TR>
			<TR height=20>
				<TD></TD>
			</TR>
		</TABLE>
		<TABLE cellSpacing=0 cellPadding=2 width="95%" align=center >
			<TR style="border-bottom: 1px solid #C1DAD7;">
			<TD style="COLOR: #0000ff;border-bottom: 1px solid #0000ff;">
					工作单位
				</TD>
				<TD style="COLOR: #0000ff;border-bottom: 1px solid #0000ff;">
					单位部门
				</TD>
				<TD style="COLOR: #0000ff;border-bottom: 1px solid #0000ff;">
					职务
				</TD>
				<TD style="COLOR: #0000ff;border-bottom: 1px solid #0000ff;">
					姓名
				</TD>
				<TD style="COLOR: #0000ff;border-bottom: 1px solid #0000ff;">
					办公号码
				</TD>
				<TD style="COLOR: #0000ff;border-bottom: 1px solid #0000ff;">
					住宅电话
				</TD>
				<TD style="COLOR: #0000ff;border-bottom: 1px solid #0000ff;">
					手机
				</TD>
				<TD style="COLOR: #0000ff;border-bottom: 1px solid #0000ff;">
					办公地址
				</TD>
				<%
				User  username = (User)request.getSession().getAttribute("user");
					if(username!=null){%>
				<TD style="COLOR: #0000ff;border-bottom: 1px solid #0000ff;" colspan="2" align="center">
					数据操作
				</TD>
				<%
					}
				%>
			</TR>
			<%
					List list = (List) request.getAttribute("list");
			if (list != null) {
				for (int i = 0; i < list.size(); i++) {
					Person person  = (Person) list.get(i);
				%>
			<TR onmouseover="this.bgColor='#E8F999';" onmouseout="this.bgColor='#FFFFFF'" style="border-bottom: 1px solid #C1DAD7;">
				<TD style="COLOR: #880000;border-bottom: 1px solid #000000;"><%=person.getCompany()%>&nbsp;
				</TD>
				<TD style="COLOR: #880000;border-bottom: 1px solid #000000;"><%=person.getDepartment()%>&nbsp;
				</TD>
				<TD style="COLOR: #880000;border-bottom: 1px solid #000000;"><%=person.getTitle()%>&nbsp;
				</TD>
				<TD style="COLOR: #880000;border-bottom: 1px solid #000000;"><%=person.getName()%>&nbsp;
				</TD>
				<TD style="COLOR: #880000;border-bottom: 1px solid #000000;"><%=person.getOfficeNumber()%>&nbsp;
				</TD>
				<TD style="COLOR: #880000;border-bottom: 1px solid #000000;"><%=person.getHomeNumber()%>&nbsp;
				</TD>
				<TD style="COLOR: #880000;border-bottom: 1px solid #000000;"><%=person.getPhoneNumber()%>&nbsp;
				</TD>
				<TD style="COLOR: #880000;border-bottom: 1px solid #000000;"><%=person.getAddress()%>&nbsp;
				</TD>
				<%
				User  username1 = (User)request.getSession().getAttribute("user");
					if(username1!=null){%>
				<TD style="COLOR: #880000;border-bottom: 1px solid #000000;">
					<a href='<%=basePath%>PreUpdateServlet?uuid=<%=person.getId()%>'>编辑信息</a>
				</TD>
				<TD style="COLOR: #880000;border-bottom: 1px solid #000000;">
					<a href='<%=basePath%>DeletePersonServlet?uuid=<%=person.getId()%>' onclick="return confirm('确实删除此记录?')">删除信息</a>
				</TD>
				<%
					}
				%>

			</TR>
			<%
				}
				} else {
			%>
			<TR>
				<TD style="COLOR: #880000" colspan="8">
					<center>
						<font color="red">请输入查询条件,进行查询.</font>
					</center>
				</TD>
			</TR>
			<%
				}
			%>
		</TABLE>
	</BODY>
</HTML>