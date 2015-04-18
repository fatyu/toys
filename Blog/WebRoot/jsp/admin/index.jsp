<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<c:set var="path" value="${pageContext.request.contextPath}" />
<%@ page import="com.rankerBlog.dto.Users"%>
<html>
	<head>
		<title>博客首页</title>
	</head>

	<body>
	
		<form name="form1" method="post" action="">
			<%
				Users user = (Users) session.getAttribute("user");
			%>
			<%
				if (user != null) {
					out.print("<p align='center'><strong>" + user.getUsername()
							+ ",欢迎光临</strong></p>");
				}
			%>

			<table width="200" border="1" align="center">
				<tr>
					<td bgcolor="#99CC00">
						<a href="${path}/user?method=logout">退出</a>
					</td>
				</tr>
				<tr>
					<td bgcolor="#99CC00">
						<a href="${path}/category?method=getCategory">添加博文</a>
					</td>
				</tr>
				<tr>
					<td bgcolor="#99CC00">
						<a href="${path}/blog?method=listBlog">查看所有博文</a>
					</td>
				</tr>
				<tr>
					<td bgcolor="#99CC00">
						<a href="${path}/blog?method=adminBlog">管理博文</a>
					</td>
				</tr>
				<tr>
					<td bgcolor="#99CC00">
						<a href="${path}/jsp/admin/addCategory.jsp">添加类别</a>
					</td>
				</tr>
				<tr>
					<td bgcolor="#99CC00">
						<a href="${path}/category?method=listCategory">管理类别</a>
					</td>
				</tr>
			</table>
		</form>

	</body>
</html>
