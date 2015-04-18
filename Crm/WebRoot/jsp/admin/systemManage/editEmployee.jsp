<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<HTML>
	<HEAD>
		<LINK href="<%=basePath%>/css/admin.css" type="text/css"
			rel="stylesheet">
		<script src="<%=basePath%>js/prototype.js" type="text/javascript"></script>
		<script src="<%=basePath%>js/effects.js" type="text/javascript"></script>
		<script src="<%=basePath%>js/validation_cn.js" type="text/javascript"></script>
		<link rel="stylesheet" type="text/css"
			href="<%=basePath%>css/style_min.css" />
		<script>
	var valid = new Validation('empl');
</script>
	</HEAD>
	<BODY>
		<TABLE cellSpacing=0 cellPadding=0 width="100%" align=center border=0>
			<TR height=28>
				<TD background=<%=basePath%> /images/title_bg1.jpg>
					&nbsp;
				</TD>
			</TR>
			<TR>
				<TD bgColor=#b1ceef height=1></TD>
			</TR>
			<TR height=20>
				<TD background=<%=basePath%> /images/shadow_bg.jpg></TD>
			</TR>
		</TABLE>
		<TABLE cellSpacing=0 cellPadding=0 width="95%" align=center border=0>
			<TR height=20>
				<TD></TD>
			</TR>
			<TR height=22>
				<TD style="PADDING-LEFT: 20px; FONT-WEIGHT: bold; COLOR: #ffffff"
					align="center" background="<%=basePath%>images/title_bg2.jpg">
					编辑雇员信息
				</TD>
			</TR>
			<TR bgColor=#ecf4fc height=12>
				<TD></TD>
			</TR>
			<TR height=20>
				<TD></TD>
			</TR>
		</TABLE>
		<form id="empl" action="<%=basePath%>admin/employeeManage!update"
			method="post" class='required-validate'>
			<TABLE cellSpacing=0 cellPadding=2 width="95%" align=center border=0>
				<TR>
					<TD align=left width=100>
						雇员ID：
					</TD>
					<TD style="COLOR: #880000">
						<input type="text" name="employee.employeeId"
							value='<s:property value="#emp.getEmployeeId()" />'
							readonly="readonly">
					</TD>
				</TR>

				<TR>
					<TD align=left width=100>
						雇员名称：
					</TD>
					<TD style="COLOR: #880000">
						<input type="text" name="employee.employeeName"
							value='<s:property value="#emp.getEmployeeName()" />'
							class="required max-length-30">
					</TD>
				</TR>
				<TR>
					<TD align=left width=100>
						性别：
					</TD>
					<TD style="COLOR: #880000">
						<select name="employee.employeeSex">
							<option value="1" selected="selected">
								男
							</option>
							<option value="2">
								女
							</option>
						</select>
					</TD>
				</TR>
				<TR>
					<TD align=left width=100>
						民族：
					</TD>
					<TD style="COLOR: #880000">

						<select name="employee.employeeNation">

							<option value="01" selected="selected">
								汉族
							</option>
							<option value="02">
								蒙古族
							</option>
							<option value="03">
								回族
							</option>
							<option value="04">
								藏族
							</option>
							<option value="05">
								维吾尔族
							</option>
							<option value="06">
								苗族
							</option>
							<option value="07">
								彝族
							</option>
							<option value="08">
								壮族
							</option>
							<option value="09">
								布依族
							</option>
							<option value="10">
								朝鲜族
							</option>
							<option value="11">
								满族
							</option>
							<option value="12">
								侗族
							</option>
							<option value="13">
								瑶族
							</option>
							<option value="14">
								白族
							</option>
							<option value="15">
								土家族
							</option>
							<option value="16">
								哈尼族
							</option>
							<option value="17">
								哈萨克族
							</option>
							<option value="18">
								傣族
							</option>
							<option value="19">
								黎族
							</option>
							<option value="20">
								傈僳族
							</option>
							<option value="21">
								佤族
							</option>
							<option value="22">
								畲族
							</option>
							<option value="23">
								高山族
							</option>
							<option value="24">
								拉祜族
							</option>
							<option value="25">
								水族
							</option>
							<option value="26">
								东乡族
							</option>
							<option value="27">
								纳西族
							</option>
							<option value="28">
								景颇族
							</option>
							<option value="29">
								柯尔克孜族
							</option>
							<option value="30">
								土族
							</option>
							<option value="31">
								达斡尔族
							</option>
							<option value="32">
								仫佬族
							</option>
							<option value="33">
								羌族
							</option>
							<option value="34">
								布朗族
							</option>
							<option value="35">
								撒拉族
							</option>
							<option value="36">
								毛难族
							</option>
							<option value="37">
								仡佬族
							</option>
							<option value="38">
								锡伯族
							</option>
							<option value="39">
								阿昌族
							</option>
							<option value="40">
								普米族
							</option>
							<option value="41">
								塔吉克族
							</option>
							<option value="42">
								怒族
							</option>
							<option value="43">
								乌孜别克族
							</option>
							<option value="44">
								俄罗斯族
							</option>
							<option value="45">
								鄂温克族
							</option>
							<option value="46">
								崩龙族
							</option>
							<option value="47">
								保安族
							</option>
							<option value="48">
								裕固族
							</option>
							<option value="49">
								京族
							</option>
							<option value="50">
								塔塔尔族
							</option>
							<option value="51">
								独龙族
							</option>
							<option value="52">
								鄂伦春族
							</option>
							<option value="53">
								赫哲族
							</option>
							<option value="54">
								门巴族
							</option>
							<option value="55">
								珞巴族
							</option>
							<option value="56">
								基诺族
							</option>
							<option value="98">
								外国血统
							</option>
							<option value="99">
								其他
							</option>
						</select>
					</TD>
				</TR>
				<TR>
					<TD align=left width=100>
						雇员年龄：
					</TD>
					<TD style="COLOR: #880000">
						<input type="text" name="employee.employeeAge"
							value='<s:property value="#emp.getEmployeeAge()" />'
							class="required max-value-60 min-value-18">
					</TD>
				</TR>
				<TR>
					<TD align=left width=100>
						雇员密码：
					</TD>
					<TD style="COLOR: #880000">
						<input type="password" name="employee.employeePassword"
							value='<s:property value="#emp.getEmployeePassword()" />'
							class="required max-length-16" />
					</TD>
				</TR>
				<TR>
					<TD align=left width=100>
						雇员地址：
					</TD>
					<TD style="COLOR: #880000">
						<input type="text" name="employee.employeeAddress"
							value='<s:property value="#emp.getEmployeeAddress()" />'
							class="required">
					</TD>
				</TR>
				<TR>
					<TD align=left width=100>
						雇员月薪：
					</TD>
					<TD style="COLOR: #880000">
						<input type="text" name="employee.employeeSalary"
							value='<s:property value="#emp.getEmployeeSalary()" />'
							class="required min-value-1">
					</TD>
				</TR>
				<TR>
					<TD align=left width=100>
						雇员权限：
					</TD>
					<TD style="COLOR: #880000">
						<select name="employee.roleId">
							<option value="1" selected="selected">
								客户经理
							</option>
							<option value="2">
								客户服务人员
							</option>
							<option value="3">
								投诉处理人员
							</option>
						</select>
					</TD>
				</TR>
				<TR>
				<TD align=center width=100>
					<input type="submit" value="更新">
				</TD>
				<TD style="COLOR: #880000">
					<input type="reset" value="重置">
				</TD>
				</TR>
			</TABLE>
		</form>
	</BODY>
</HTML>