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
					�绰��Ϣ
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
					������λ
				</TD>
				<TD style="COLOR: #0000ff;border-bottom: 1px solid #0000ff;">
					��λ����
				</TD>
				<TD style="COLOR: #0000ff;border-bottom: 1px solid #0000ff;">
					ְ��
				</TD>
				<TD style="COLOR: #0000ff;border-bottom: 1px solid #0000ff;">
					����
				</TD>
				<TD style="COLOR: #0000ff;border-bottom: 1px solid #0000ff;">
					�칫����
				</TD>
				<TD style="COLOR: #0000ff;border-bottom: 1px solid #0000ff;">
					סլ�绰
				</TD>
				<TD style="COLOR: #0000ff;border-bottom: 1px solid #0000ff;">
					�ֻ�
				</TD>
				<TD style="COLOR: #0000ff;border-bottom: 1px solid #0000ff;">
					�칫��ַ
				</TD>
				<%
				User  username = (User)request.getSession().getAttribute("user");
					if(username!=null){%>
				<TD style="COLOR: #0000ff;border-bottom: 1px solid #0000ff;" colspan="2" align="center">
					���ݲ���
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
					<a href='<%=basePath%>PreUpdateServlet?uuid=<%=person.getId()%>'>�༭��Ϣ</a>
				</TD>
				<TD style="COLOR: #880000;border-bottom: 1px solid #000000;">
					<a href='<%=basePath%>DeletePersonServlet?uuid=<%=person.getId()%>' onclick="return confirm('ȷʵɾ���˼�¼?')">ɾ����Ϣ</a>
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
						<font color="red">�������ѯ����,���в�ѯ.</font>
					</center>
				</TD>
			</TR>
			<%
				}
			%>
		</TABLE>
	</BODY>
</HTML>