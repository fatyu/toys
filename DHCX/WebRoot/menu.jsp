<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<HTML>
	<HEAD>
	<meta http-equiv="Content-Type" content="text/html; charset=gbk">
		<LINK href="<%=basePath %>css/admin.css" type="text/css" rel="stylesheet">
		
		<SCRIPT language=javascript>
		function expand(el) {
			childObj = document.getElementById("child" + el);
	
			if (childObj.style.display == 'none') {
				childObj.style.display = 'block';
			} else {
				childObj.style.display = 'none';
			}
			return;
		}
		</SCRIPT>
	</HEAD>
	<BODY>
		<TABLE height="100%" cellSpacing=0 cellPadding=0 width=170
			background=<%=basePath %>images/menu_bg.jpg border=0>
			<TR>
				<TD vAlign="top" align="left">
					<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>

						<TR>
							<TD height=10></TD>
						</TR>
					</TABLE>
					<TABLE cellSpacing=0 cellPadding=0 width=150 border=0>

						<TR height=22>
							<TD style="PADDING-LEFT: 30px" background=<%=basePath %>images/menu_bt.jpg>
								<A class=menuParent onclick=expand(1);
									href="javascript:void(0);">工作单位 </A>
							</TD>
						</TR>
						<TR height=4>
							<TD></TD>
						</TR>
					</TABLE>
					<TABLE id=child1 style="DISPLAY: block" cellSpacing=0 cellPadding=0
						width=150 border=0>
						<%
					List list = (List) request.getSession().getAttribute("list");
					for (int i = 1; i < list.size(); i++) {
						String result =  (String)list.get(i);
				%>
				
						<TR height=20>
							<TD align="center" width=30>
								<IMG height=9 src="<%=basePath %>images/menu_icon.gif" width=9>
							</TD>
							<TD>
								<A class=menuChild href="<%=basePath %>QueryByCompanyServlet?company=<%=result %>" target=main><%=result %>
								</A>
							</TD>
						</TR>	<%
					}
				%>
				
						<TR height=4>
							<TD colSpan=2></TD>
						</TR>
					</TABLE>
					<TABLE cellSpacing=0 cellPadding=0 width=150 border=0>

						<TR height=22>
							<TD style="PADDING-LEFT: 30px" background=<%=basePath %>images/menu_bt.jpg>
								<A class=menuParent onclick=expand(2);
									href="javascript:void(0);">电话信息管理 </A>
							</TD>
						</TR>
						<TR height=4>
							<TD></TD>
						</TR>
					</TABLE>
					<TABLE id=child2 style="DISPLAY: none" cellSpacing=0 cellPadding=0
						width=150 border=0>
						<TR height=20>
							<TD align="center" width=30>
								<IMG height=9 src="<%=basePath %>images/menu_icon.gif" width=9>
							</TD>
							<TD>
								<A class=menuChild href="<%=basePath %>admin/phoneManage/addInfo.jsp" target=main>增加电话信息
								</A>
							</TD>
						</TR>
						<TR height=20>
							<TD align="center" width=30>
								<IMG height=9 src="<%=basePath %>images/menu_icon.gif" width=9>
							</TD>
							<TD>
								<A class=menuChild href="<%=basePath %>ListPersonServlet" target=main>查询全部信息
								</A>
							</TD>
						</TR>
						<TR height=20>
							<TD align="center" width=30>
								<IMG height=9 src="<%=basePath %>images/menu_icon.gif" width=9>
							</TD>
							<TD>
								<A class=menuChild href="<%=basePath %>admin/phoneManage/importData.jsp" target=main>从文件导入信息
								</A>
							</TD>
						</TR>
						<TR height=4>
							<TD colSpan=2></TD>
						</TR>
					</TABLE>
					<TABLE cellSpacing=0 cellPadding=0 width=150 border=0>
						<TR height=22>
							<TD style="PADDING-LEFT: 30px" background=<%=basePath %>images/menu_bt.jpg>
								<A class=menuParent onclick=expand(3);
									href="javascript:void(0);">用户信息管理 </A>
							</TD>
						</TR>
						<TR height=4>
							<TD></TD>
						</TR>
					</TABLE>
					<TABLE id=child3 style="DISPLAY: none" cellSpacing=0 cellPadding=0
						width=150 border=0>
						<TR height=20>
							<TD align="center" width=30>
								<IMG height=9 src="<%=basePath %>images/menu_icon.gif" width=9>
							</TD>
							<TD>
								<A class=menuChild href="<%=basePath %>admin/userManage/editPassword.jsp" target=main>修改密码</A>
							</TD>
						</TR>
						<TR height=20>
							<TD align="center" width=30>
								<IMG height=9 src="<%=basePath %>images/menu_icon.gif" width=9>
							</TD>
							<TD>
								<A class=menuChild href="<%=basePath %>login.jsp" target=main>用户登录</A>
							</TD>
						</TR>
						<TR height=4>
							<TD colSpan=2></TD>
						</TR>
					</TABLE>
				</TD>
			</TR>
		</TABLE>
	</BODY>
</HTML>
