<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<c:set var="path" value="${pageContext.request.contextPath}" />
<%@ page import="java.util.*"%>
<%@ page import="com.rankerBlog.dto.Blog"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%
	List blist = (List)request.getAttribute("list");
	Blog blog = null;
%>
<html>
	<head>
		<title>博文页面</title>
	</head>

	<body>
<%
	for(int i =0;i<blist.size();i++){
		blog = (Blog)blist.get(i);
%>
		<TABLE>
			<TR>
				<TD>
					标题:
				</TD>
				<TD>
					<a href="${path}/comment?method=listComment&&id=<%=blog.getId()%>"><%=blog.getTitle()%></a>
				</TD>
			</TR>
			<TR>
				<TD>
					类别:
				</TD>
				<TD>
					<%=blog.getCatalog() %>
				</TD>
			</TR>
			<TR>
				<TD>
					内容:
				</TD>
				<TD>
					<%
						String content = blog.getContent();
						int length = content.length();
						if(length<200){
							out.print(content);
						}else{
							out.print(content.substring(0,200)+"...");
						}
					%>
				</TD>
			</TR>
			<TR>
				<TD>
					创建时间:
				</TD>
				<TD>
					<%=blog.getCreatedtime() %>
				</TD>
			</TR>
		</TABLE>
<%}%>
	<TABLE>
			<TR>
				<TD>
				<a href="${path}/jsp/login.jsp">登陆</a>	
				</TD>
				<TD>
				<a href="${path}/jsp/login.jsp">注册</a>	
				</TD>
			</TR>
		</TABLE>

	</body>
</html>
