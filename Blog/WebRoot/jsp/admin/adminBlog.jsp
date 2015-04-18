<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<c:set var="path" value="${pageContext.request.contextPath}" />
<%@ page import="java.util.*"%>
<%@ page import="com.rankerBlog.dto.Blog"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%
	List blist = (List) request.getAttribute("list");
	Blog blog = null;
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
				文章管理
			</p>
			<table width="552" height="56" border="1">
				<tr>
					<td width="152" align="center" valign="middle" bgcolor="#CCCCCC">
						文章编号
					</td>
					<td width="218" align="center" valign="middle" bgcolor="#CCCCCC">
						文章内容
					</td>
					<td width="79" align="center" valign="middle" bgcolor="#CCCCCC">
						操作
					</td>
				</tr>
				<%
					for (int i = 0; i < blist.size(); i++) {
						blog = (Blog) blist.get(i);
				%>
				<tr>
					<td align="center" valign="middle" bgcolor="#CCCCCC"><%=blog.getId()%></td>
					<td align="center" valign="middle" bgcolor="#CCCCCC"><%=blog.getTitle()%></td>
					<td align="center" valign="middle" bgcolor="#CCCCCC">
						||
						<a href="${path}/blog?method=beforeEdit&&id=<%=blog.getId()%>">修改</a> ||
						<a href="${path}/blog?method=deleteBlog&&id=<%=blog.getId()%>"
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
