<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<c:set var="path" value="${pageContext.request.contextPath}" />
<%@ page import="com.rankerBlog.dto.Category"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<html>
	<head>
		<title>编辑类别页面</title>
	</head>
	<%
		Category category = (Category) request.getAttribute("category");
	%>
	<body>
		<FORM METHOD=POST ACTION="${path}/category?method=finishEdit">
			<TABLE>
				<TR>
					<TD>
						类别编号:
					</TD>
					<TD>
						<INPUT TYPE="text" NAME="id" value=<%=category.getId()%>
							readonly="readonly">
					</TD>
				</TR>
				<TR>
					<TD>
						类别名称:
					</TD>
					<TD>
						<INPUT TYPE="text" NAME="name" value=<%=category.getName()%>>
					</TD>
				</TR>
				<TR>
					<TD>
						类别级别:
					</TD>
					<TD>
						<INPUT TYPE="text" NAME="content" value=<%=category.getLevel()%>>
					</TD>
				</TR>
				<TR>
					<TD>
						<INPUT TYPE="submit" VALUE="提交">
					</TD>
					<TD>
						<INPUT TYPE="reset" VALUE="重置">
					</TD>
				</TR>
			</TABLE>
		</FORM>
	</body>
</html>
