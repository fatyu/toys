<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<c:set var="path" value="${pageContext.request.contextPath}" />
<%@ page import="com.rankerBlog.dto.Blog"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<html>
	<head>
		<title>编辑博客页面</title>
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
	Blog blog = (Blog)request.getAttribute("blog");

%>
	<body>
		<FORM METHOD=POST ACTION="${path}/blog?method=finishEdit">
			<TABLE>
			<TR>
					<TD>
						编号:
					</TD>
					<TD>
						<INPUT TYPE="text" NAME="id" value=<%=blog.getId()%> readonly="readonly">
					</TD>
				</TR>
				<TR>
					<TD>
						标题:
					</TD>
					<TD>
						<INPUT TYPE="text" NAME="title" value=<%=blog.getTitle()%>>
					</TD>
				</TR>
				<TR>
					<TD>
						类别:
					</TD>
					<TD>
						<SELECT NAME="catalog">
							<OPTION VALUE="1" SELECTED>
								心情故事
							</OPTION>
							<OPTION VALUE="2">
								java开发
							</OPTION>
						</SELECT>
					</TD>
				</TR>
				<TR>
					<TD>
						内容:
					</TD>
					<TD>
						<TEXTAREA NAME="content" ROWS="10" COLS="50"><%=blog.getContent()%></TEXTAREA>
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
