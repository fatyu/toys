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
				<TD vAlign="top" align="center">
					<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>

						<TR>
							<TD height=10></TD>
						</TR>
					</TABLE>
					<TABLE cellSpacing=0 cellPadding=0 width=150 border=0>

						<TR height=22>
							<TD style="PADDING-LEFT: 30px" background=<%=basePath %>images/menu_bt.jpg>
								<A class=menuParent onclick=expand(1);
									href="javascript:void(0);">客户基本信息管理 </A>
							</TD>
						</TR>
						<TR height=4>
							<TD></TD>
						</TR>
					</TABLE>
					<TABLE id=child1 style="DISPLAY: none" cellSpacing=0 cellPadding=0
						width=150 border=0>
						<TR height=20>
							<TD align="center" width=30>
								<IMG height=9 src="<%=basePath %>images/menu_icon.gif" width=9>
							</TD>
							<TD>
								<A class=menuChild href="<%=basePath %>crm!listGroup" target=main>集团客户管理
								</A>
							</TD>
						</TR>
						<TR height=20>
							<TD align="center" width=30>
								<IMG height=9 src="<%=basePath %>images/menu_icon.gif" width=9>
							</TD>
							<TD>
								<A class=menuChild href="<%=basePath %>crm!listPerson" target=main>个人客户管理
								</A>
							</TD>
						</TR>
						<TR height=20>
							<TD align="center" width=30>
								<IMG height=9 src="<%=basePath %>images/menu_icon.gif" width=9>
							</TD>
							<TD>
								<A class=menuChild href="<%=basePath %>crm!createChart" target=main>客户比例图表
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
								<A class=menuParent onclick=expand(2);
									href="javascript:void(0);">客户关怀 </A>
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
								<A class=menuChild href="<%=basePath %>crm!careCustomer" target=main>关怀客户</A>
							</TD>
						</TR>
						<TR height=20>
							<TD align="center" width=30>
								<IMG height=9 src="<%=basePath %>images/menu_icon.gif" width=9>
							</TD>
							<TD>
								<A class=menuChild href="<%=basePath %>crm!infoManage" target=main>管理关怀信息</A>
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
									href="javascript:void(0);">客户服务跟踪管理 </A>
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
								<A class=menuChild href="<%=basePath %>crm!addComplain" target=main>客户投诉记录</A>
							</TD>
						</TR>
						<TR height=20>
							<TD align="center" width=30>
								<IMG height=9 src="<%=basePath %>images/menu_icon.gif" width=9>
							</TD>
							<TD>
								<A class=menuChild href="<%=basePath %>crm!updateComplain" target=main>投诉回执处理</A>
							</TD>
						</TR>
						<TR height=4>
							<TD colSpan=2></TD>
						</TR>
					</TABLE>
					<TABLE cellSpacing=0 cellPadding=0 width=150 border=0>
						<TR height=22>
							<TD style="PADDING-LEFT: 30px" background=<%=basePath %>images/menu_bt.jpg>
								<A class=menuParent onclick=expand(4);
									href="javascript:void(0);">系统维护</A>
							</TD>
						</TR>
						<TR height=4>
							<TD></TD>
						</TR>
					</TABLE>
					<TABLE id=child4 style="DISPLAY: none" cellSpacing=0 cellPadding=0
						width=150 border=0>
						<TR height=20>
							<TD align="center" width=30>
								<IMG height=9 src="<%=basePath %>images/menu_icon.gif" width=9>
							</TD>
							<TD>
								<A class=menuChild  href="<%=basePath%>crm!importdata" target=main>导入客户数据</A>
							</TD>
						</TR>
						<TR height=20>
							<TD align="center" width=30>
								<IMG height=9 src="<%=basePath %>images/menu_icon.gif" width=9>
							</TD>
							<TD>
								<A class=menuChild href="<%=basePath%>crm!backup" target=main>备份客户数据</A>
							</TD>
						</TR>
						<TR height=20>
							<TD align="center" width=30>
								<IMG height=9 src="<%=basePath %>images/menu_icon.gif" width=9>
							</TD>
							<TD>
								<A class=menuChild href="<%=basePath%>crm!emplManage" target=main>用户管理</A>
							</TD>
						</TR>
						<TR height=20>
							<TD align="center" width=30>
								<IMG height=9 src="<%=basePath %>images/menu_icon.gif" width=9>
							</TD>
							<TD>
								<A class=menuChild href="<%=basePath%>crm!data" target=main>数据字典管理</A>
							</TD>
						</TR>
						<TR height=4>
							<TD colSpan=2></TD>
						</TR>
					</TABLE>
					<TABLE cellSpacing=0 cellPadding=0 width=150 border=0>
						<TR height=22>
							<TD style="PADDING-LEFT: 30px" background=<%=basePath %>images/menu_bt.jpg>
								<A class=menuParent onclick=expand(5);
									href="javascript:void(0);">关于公司</A>
							</TD>
						</TR>
						<TR height=4>
							<TD></TD>
						</TR>
					</TABLE>
					<TABLE id=child5 style="DISPLAY: none" cellSpacing=0 cellPadding=0
						width=150 border=0>
						<TR height=20>
							<TD align="center" width=30>
								<IMG height=9 src="<%=basePath %>images/menu_icon.gif" width=9>
							</TD>
							<TD>
								<A class=menuChild href="<%=basePath%>crm!company" target=main>公司介绍</A>
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
