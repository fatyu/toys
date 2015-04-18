<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<c:set var="path" value="${pageContext.request.contextPath}" />
<%@ page import="java.util.*"%>
<%@page import="com.rankerBlog.dto.Comment"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%
	List clist = (List) request.getAttribute("list");
	Comment comment = null;
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
		<table width="753" height="56" border="0">
			<tr>
				<td width="106" bgcolor="#FFCC33">
					<div align="center">
						编号
					</div>
				</td>
				<td width="156" bgcolor="#FFCC33">
					<div align="center">
						评论人
					</div>
				</td>
				<td width="342" bgcolor="#FFCC33">
					<div align="center">
						评论内容
					</div>
				</td>
				<td width="131" bgcolor="#FFCC33">
					<div align="center">
						操作
					</div>
				</td>
			</tr>
			<%
			if(clist!=null){
				for (int i = 0; i < clist.size(); i++) {
					comment = (Comment) clist.get(i);
			%>
			<tr>
				<td bgcolor="#FFCC33">
					<div align="center">
						<%=comment.getId()%>
					</div>
				</td>
				<td bgcolor="#FFCC33">
					<div align="center">
						<%=comment.getUsername()%>
					</div>
				</td>
				<td bgcolor="#FFCC33">
					<div align="center">
						<%=comment.getContent()%>
					</div>
				</td>
				<td bgcolor="#FFCC33">
					<div align="center">
						||
						<a
							href="${path}/comment?method=deleteComment&&id=<%=comment.getId()%>&&bid=<%=comment.getBlog_id() %>"
							onclick="checkdelete">删除</a>||
					</div>
				</td>
			</tr>

			<%
				}
			}
			%>

		</table>
	</body>
</html>
