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
		<LINK href="<%=basePath%>css/admin.css" type="text/css"
			rel="stylesheet">
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
		<FORM id="complain" METHOD=POST
			ACTION="<%=basePath%>admin/complainManage!update"
			class='required-validate'>
			<TABLE>
				<TR>
					<TD>
						投诉人:
					</TD>
					<TD>
						<INPUT TYPE="text" NAME="complain.complainName"
							value="<s:property value='#complain.getComplainName()'/>"
							readonly="readonly" 
							style="color: rgb(0, 0,0); border-left: medium none; border-right: medium none; border-top: medium none; border-bottom: medium none"/>
					</TD>
				</TR>
				<TR>
					<TD>
						投诉信息类别:
					</TD>
					<TD>
						<INPUT TYPE="text" NAME="complain.complainType"
							value="<s:property value='#complain.getComplainType()'/>"
							readonly="readonly" 
							style="color: rgb(0, 0,0); border-left: medium none; border-right: medium none; border-top: medium none; border-bottom: medium none"/>
					</TD>
				</TR>
				<TR>
					<TD>
						投诉信息内容:
					</TD>
					<TD>
						<input name="complain.complainContent" size="150"
							readonly="readonly"
							value="<s:property value='#complain.getComplainContent() ' />"
							style="color: rgb(0, 0,255); border-left: medium none; border-right: medium none; border-top: medium none; border-bottom: medium none">
					</TD>
				</TR>
				<TR>
					<TD>
						投诉信息状态:
					</TD>
					<TD style="COLOR: #880000">
						<select name="complain.clear">
							<option  value="Y" selected="selected">投诉已处理</option>
							<option value="N">投诉未处理</option>
						</select>
					</TD>
				</TR>
				<TR>
					<TD>
						投诉解决方案:
					</TD>
					<TD style="COLOR: #880000">
						<select name="complain.clearType">
							<option  value="现场解决" >现场解决</option>
							<option value="电话支持" selected="selected">电话支持</option>
						</select>
					</TD>
				</TR>
				<TR>
					<TD>
						投诉人满意程度:
					</TD>
					<TD style="COLOR: #880000">
						<select name="complain.feeling">
							<option  value="非常满意" selected="selected" >非常满意</option>
							<option value="比较满意" >比较满意</option>
								<option value="不太满意" >不太满意</option>
									<option value="很不满意" >很不满意</option>
						</select>
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
