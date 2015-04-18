<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<c:set var="path" value="${pageContext.request.contextPath}" />

<%@ page import="com.rankerBlog.dto.Blog"%>
<%@ page import="com.rankerBlog.dto.Comment"%>
<%@ page import="java.util.*"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%
	Blog b = (Blog) request.getAttribute("blog");
	List list = (List) request.getAttribute("list");
%>
<html>
	<head>
		<title>博文页面</title>
	</head>

	<body>
		<TABLE>
			<TR>
				<TD>
					标题:
				</TD>
				<TD>
					<%=b.getTitle()%>
				</TD>
			</TR>
			<TR>
				<TD>
					类别:
				</TD>
				<TD>
					<%=b.getCatalog()%>
				</TD>
			</TR>
			<TR>
				<TD>
					内容:
				</TD>
				<TD>
					<%=b.getContent()%>
				</TD>
			</TR>
			<TR>
				<TD>
					创建时间:
				</TD>
				<TD>
					<%=b.getCreatedtime()%>
				</TD>
			</TR>
		</TABLE>
		<table width="590" border="0">
			<%
			if(list!=null){
				for (int i = 0; i < list.size(); i++) {
					Comment comment = (Comment) list.get(i);
			%>
			<tr>
				<td width="87" bgcolor="#99CC66">
					评论人：
				</td>
				<td width="414" bgcolor="#99CC66">
					<%=comment.getUsername()%>
				</td>
			</tr>
			<tr>
				<td bgcolor="#99CC66">
					评论内容：
				</td>
				<td bgcolor="#99CC66">
					<%=comment.getContent()%>
				</td>
			</tr>
			<tr>
				<td bgcolor="#99CC66">
					评论时间：
				</td>
				<td bgcolor="#99CC66">
					<%=comment.getCreatedtime()%>
				</td>
			</tr>
			<%
				}
			}
			%>
			
		</table>
		<p>
			&nbsp;
		</p>
		<form method="post" action="${path}/comment?method=addComment">
			<input type="hidden" name="id" value="<%=b.getId()%>">
			<table width="590" border="0">
				<tr>
					<td width="87" bgcolor="#99CC66">
						评论人：
					</td>
					<td width="414" bgcolor="#99CC66">
						<label>
							<input name="username" type="text" value="匿名" />
						</label>
					</td>
				</tr>
				<tr>
					<td bgcolor="#99CC66">
						评论内容：
					</td>
					<td bgcolor="#99CC66">
						<label>
							<textarea name="content" cols="45" rows="5">请填写评论内容</textarea>
						</label>
					</td>
				</tr>
				<tr>
					<td bgcolor="#99CC66">
						<label>
							<input type="submit" value="提交" />
						</label>
					</td>
					<td bgcolor="#99CC66">
						<label>
							<input type="reset" value="重置" />
						</label>
					</td>
				</tr>
			</table>
			<p></p>
		</form>
		<p>
			&nbsp;
		</p>
		<center>
			<font color="RED">
				<a href="${path}/comment?method=getMyComment&&id=<%=b.getId()%>">
					管理此博文的评论
				</a>
			</font>
		</center>
	</body>
</html>
