<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<c:set var="path" value="${pageContext.request.contextPath}" />
<%@ page import="java.util.*"%>
<%@ page import="com.rankerBlog.dto.Category"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<html>
	<head>
		<title>添加博客页面</title>
		<script type="text/javascript" src="${path}/fckeditor/fckeditor.js">
		</script>
		<script type="text/javascript">
			window.onload = function(){
			var oFCKeditor = new FCKeditor( 'content') ;
			oFCKeditor.BasePath = "${path}/fckeditor/" ;
			oFCKeditor.ToolbarSet = "Basic";
			oFCKeditor.Height  = 300;
			oFCKeditor.ReplaceTextarea() ;
			}
		</script>
	</head>
	<%
		List list = null;
	%>
	<%
		if (request.getAttribute("list") != null) {
			list = (List) request.getAttribute("list");
		}
	%>
	<body>
		<FORM METHOD=POST ACTION="${path}/blog?method=addBlog">
			<TABLE>
				<TR>
					<TD>
						标题:
					</TD>
					<TD>
						<INPUT TYPE="text" NAME="title">
					</TD>
				</TR>
				<TR>
					<TD>
						类别:
					</TD>
					<TD>
						<SELECT NAME="catalog">
							<OPTION VALUE="-1" SELECTED>
								请选择类别
							</OPTION>
							<%
								if (list != null) {
									for (int i = 0; i < list.size(); i++) {
										Category category = (Category) list.get(i);
							%>
							<OPTION VALUE="<%=category.getId()%>">
								<%=category.getName()%>
							</OPTION>
							<%
								}
								}
							%>
						</SELECT>
					</TD>
				</TR>
				<TR>
					<TD>
						内容:
					</TD>
					<TD>
						<TEXTAREA NAME="content" ROWS="10" COLS="50"></TEXTAREA>
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
