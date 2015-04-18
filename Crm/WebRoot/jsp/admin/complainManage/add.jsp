<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
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
		<script src="<%=basePath%>js/prototype.js" type="text/javascript"></script>
		<script src="<%=basePath%>js/effects.js" type="text/javascript"></script>
		<script src="<%=basePath%>js/validation_cn.js" type="text/javascript"></script>
		<link rel="stylesheet" type="text/css"
			href="<%=basePath%>css/style_min.css" />
		<script>
	var valid = new Validation('complain');
</script>
	</HEAD>
	<BODY>
		<FORM id="complain" METHOD=POST ACTION="<%=basePath%>admin/complainManage!addComplain" class='required-validate'>
			<TABLE>
				<TR>
					<TD>
						投诉人:
					</TD>
					<TD>
						<INPUT TYPE="text" NAME="complain.complainName" class="required max-length-50">
					</TD>
				</TR>
				<TR>
					<TD>
						投诉信息类别:
					</TD>
					<TD>
						<select name="complain.complainType">
							<option value="产品质量">
								产品质量
							</option>
							<option value="售后服务" selected="selected">
								售后服务
							</option>
						</select>
					</TD>
				</TR>
				<TR>
					<TD>
						投诉信息内容:
					</TD>
					<TD>
						<TEXTAREA name="complain.complainContent" ROWS="10" COLS="50"
							class="required max-length-100"></TEXTAREA>
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
