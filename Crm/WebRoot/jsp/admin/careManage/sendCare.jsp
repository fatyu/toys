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
	var valid = new Validation('careinfo');
</script>
	</HEAD>
	<BODY>
		<FORM id="careinfo" METHOD=POST ACTION="<%=basePath%>admin/careInfoManage!send" class='required-validate'>
			<TABLE>
				<TR>
					<TD>
						标题:
					</TD>
					<TD>
						<INPUT TYPE="text" NAME="careInfo.infoTitle" class="required max-length-50">
						<input type="hidden" name="type"
							value='<s:property value="type"/>' >

					</TD>
				</TR>
				<TR>
					<TD>
						信息类别:
					</TD>
					<TD>
						<select name="careInfo.infoType">
							<option value="节日祝福">
								节日祝福
							</option>
							<option value="公司信息" selected="selected">
								公司信息
							</option>
							<option value="生日祝福">
								生日祝福
							</option>
						</select>
					</TD>
				</TR>
				<TR>
					<TD>
						信息内容:
					</TD>
					<TD>
						<TEXTAREA name="careInfo.infoDetail" ROWS="10" COLS="50"
							class="required max-length-1000"></TEXTAREA>
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
