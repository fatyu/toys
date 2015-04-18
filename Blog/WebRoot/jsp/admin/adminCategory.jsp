<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<c:set var="path" value="${pageContext.request.contextPath}" />
<%@ page import="java.util.*"%>
<%@page import="com.rankerBlog.dto.Category"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%
	List clist = (List) request.getAttribute("list");
	Category category = null;
%>
<html>
	<head>
		<title>博文管理页面</title>
		<script type="text/javascript">
			function checkdelete(){
			var msg = "您确定要删除吗?";   
			if (confirm(msg)==true){   
			return true;   
			}else{   
			return false;   
			} 
			}
		</script>
	</head>

	<body>
		<div align="center">
			<p>
				类别管理
			</p>
			<table width="552" height="56" border="1">
				<tr>
					<td width="152" align="center" valign="middle" bgcolor="#CCCCCC">
						类别编号
					</td>
					<td width="218" align="center" valign="middle" bgcolor="#CCCCCC">
						类别名称
					</td>
					<td width="79" align="center" valign="middle" bgcolor="#CCCCCC">
						操作
					</td>
				</tr>
				<%
					for (int i = 0; i < clist.size(); i++) {
						category = (Category) clist.get(i);
				%>
				<tr>
					<td align="center" valign="middle" bgcolor="#CCCCCC"><%=category.getId()%></td>
					<td align="center" valign="middle" bgcolor="#CCCCCC"><%=category.getName()%></td>
					<td align="center" valign="middle" bgcolor="#CCCCCC">
						||
						<a
							href="${path}/category?method=beforeEdit&&id=<%=category.getId()%>">修改</a>
						||
						<a
							href="${path}/category?method=deleteCategory&&id=<%=category.getId()%>"
							onclick="javascript:return checkdelete()">删除</a>||
					</td>
				</tr>
				<%
					}
				%>

			</table>
			<p>
				&nbsp;
			</p>
		</div>
	</body>
</html>
