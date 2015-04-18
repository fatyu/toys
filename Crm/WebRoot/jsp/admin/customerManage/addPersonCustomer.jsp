<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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
	var valid = new Validation('person');
</script>
	</HEAD>
	<BODY>
		<TABLE cellSpacing=0 cellPadding=0 width="100%" align=center border=0>
			<TR height=28>
				<TD background="<%=basePath%>images/title_bg1.jpg">
					&nbsp;
				</TD>
			</TR>
			<TR>
				<TD bgColor=#b1ceef height=1></TD>
			</TR>
			<TR height=20>
				<TD background="<%=basePath%>images/shadow_bg.jpg"></TD>
			</TR>
		</TABLE>

		<TABLE cellSpacing=0 cellPadding=0 width="95%" align=center border=0>
			<TR height=20>
				<TD></TD>
			</TR>
			<TR height=22>
				<TD style="PADDING-LEFT: 20px; FONT-WEIGHT: bold; COLOR: #ffffff"
					align="center" background="<%=basePath%>images/title_bg2.jpg">
					添加个人客户
				</TD>
			</TR>
			<TR bgColor=#ecf4fc height=12>
				<TD></TD>
			</TR>
			<TR height=20>
				<TD></TD>
			</TR>
		</TABLE>
		<form id='person' action="<%=basePath%>admin/personCustomerManage!add"
			method="post" class='required-validate'>
			<TABLE cellSpacing=0 cellPadding=2 width="95%" align=center border=0>
				<TR>
					<TD align=left width=100>
						个人客户名称：
					</TD>
					<TD style="COLOR: #880000">
						<input type="text" name="personCustomer.personCustomerName" class="required max-length-16 ">
					</TD>
				</TR>

				<TR>
					<TD align=left width=100>
						个人客户地址：
					</TD>
					<TD style="COLOR: #880000">
						<input type="text" name="personCustomer.personCustomerAddress" class="required max-length-60">
					</TD>
				</TR>

				<TR>
					<TD align=left width=100>
						个人客户级别：
					</TD>
					<TD style="COLOR: #880000">
						<select name="personCustomer.personCustomerLeavle">
							<option  value="06" selected="selected">大客户</option>
							<option  value="07" >小客户</option>
							<option  value="08" >VIP</option>
							<option  value="09" >潜在客户</option>
						</select>
					</TD>
				</TR>

				<TR>
					<TD align=left width=100>
						个人客户联系电话：
					</TD>
					<TD style="COLOR: #880000">
						<input type="text" name="personCustomer.personCustomerPhoneNum" class="required validate-mobile-phone ">
					</TD>
				</TR>
				<TR>
					<TD align=left width=100>
						个人客户证件号：
					</TD>
					<TD style="COLOR: #880000">
						<input type="text" name="personCustomer.personCustomerCardNum" class="required validate-id-number">
					</TD>
				</TR>
				<TR>
					<TD align=left width=100>
						客户所在地邮编：
					</TD>
					<TD style="COLOR: #880000">
						<input type="text" name="personCustomer.personCustomerPostCode" class="required validate-zip">
					</TD>
				</TR>
				<TR>
					<TD align=left width=100>
						客户Email：
					</TD>
					<TD style="COLOR: #880000">
						<input type="text" name="personCustomer.personCustomerEmail" class="required validate-email ">
					</TD>
				</TR>
				<TR>
					<TD align=left width=100>
						个人客户性别：
					</TD>
					<TD style="COLOR: #880000">
					<select name="personCustomer.personCustomerSex">
							<option  value="1" selected="selected">男</option>
							<option  value="2" >女</option>
						</select>
					</TD>
				</TR>

				<TR>
					<TD align=left width=100>
						个人客户民族：
					</TD>
					<TD style="COLOR: #880000">
					<select name="personCustomer.personCustomerNation">

							<option  value="01" selected="selected">汉族</option>
							<option  value="02" >蒙古族</option>
							<option  value="03" >回族</option>
							<option  value="04" >藏族</option>
							<option  value="05" >维吾尔族</option>
							<option  value="06" >苗族</option>
							<option  value="07" >彝族</option>
							<option  value="08" >壮族</option>
							<option  value="09" >布依族</option>
							<option  value="10" >朝鲜族</option>
							<option  value="11" >满族</option>
							<option  value="12" >侗族</option>
							<option  value="13" >瑶族</option>
							<option  value="14" >白族</option>
							<option  value="15" >土家族</option>
							<option  value="16" >哈尼族</option>
							<option  value="17" >哈萨克族</option>
							<option  value="18" >傣族</option>
							<option  value="19" >黎族</option>
							<option  value="20" >傈僳族</option>
							<option  value="21" >佤族</option>
							<option  value="22" >畲族</option>
							<option  value="23" >高山族</option>
							<option  value="24" >拉祜族</option>
							<option  value="25" >水族</option>
							<option  value="26" >东乡族</option>
							<option  value="27" >纳西族</option>
							<option  value="28" >景颇族</option>
							<option  value="29" >柯尔克孜族</option>
							<option  value="30" >土族</option>
							<option  value="31" >达斡尔族</option>
							<option  value="32" >仫佬族</option>
							<option  value="33" >羌族</option>
							<option  value="34" >布朗族</option>
							<option  value="35" >撒拉族</option>
							<option  value="36" >毛难族</option>
							<option  value="37" >仡佬族</option>
							<option  value="38" >锡伯族</option>
							<option  value="39" >阿昌族</option>
							<option  value="40" >普米族</option>
							<option  value="41" >塔吉克族</option>
							<option  value="42" >怒族</option>
							<option  value="43" >乌孜别克族</option>
							<option  value="44" >俄罗斯族</option>
							<option  value="45" >鄂温克族</option>
							<option  value="46" >崩龙族</option>
							<option  value="47" >保安族</option>
							<option  value="48" >裕固族</option>
							<option  value="49" >京族</option>
							<option  value="50" >塔塔尔族</option>
							<option  value="51" >独龙族</option>
							<option  value="52" >鄂伦春族</option>
							<option  value="53" >赫哲族</option>
							<option  value="54" >门巴族</option>
							<option  value="55" >珞巴族</option>
							<option  value="56" >基诺族</option>
							<option  value="98" >外国血统</option>
							<option  value="99" >其他</option>

						</select>
					</TD>
				</TR>
				<TR>
					<TD align=left width=100>
						个人客户爱好：
					</TD>
					<TD style="COLOR: #880000">
						<input type="text" name="personCustomer.personCustomerHobby" class="required max-length-30">
					</TD>
				</TR>
				<TR>
					<TD align=left width=100>
						个人客户教育情况：
					</TD>
					<TD style="COLOR: #880000">
						<select name="personCustomer.personCustomerEdu">
							<option  value="博士" selected="selected">博士</option>
							<option  value="研究生" >研究生</option>
							<option  value="本科" >本科</option>
							<option  value="专科" >专科</option>
							<option  value="高" >高中</option>
							<option  value="小学" >小学</option>
						</select>
					</TD>
				</TR>
				<TR>
					<TD align=left width=100>
						个人客户年龄：
					</TD>
					<TD style="COLOR: #880000">
						<input type="text" name="personCustomer.personCustomerAge" class="required max-value-80 min-value-18  ">
					</TD>
				</TR>
				<TR>
					<TD align=left width=100>
						个人工作职位：
					</TD>
					<TD style="COLOR: #880000">
						<input type="text" name="personCustomer.personCustomerJobTitle" class="required max-length-20">
					</TD>
				</TR>
				<TR>
					<TD align=left width=100>
						个人工作类型：
					</TD>
					<TD style="COLOR: #880000">
						<input type="text" name="personCustomer.personCustomerJobType" class="required max-length-20">
					</TD>
				</TR>
				<TR>
					<TD align=center width=100>
						<input type="submit" value="添加">
					</TD>
					<TD style="COLOR: #880000">
						<input type="reset" value="重置">
					</TD>
				</TR>
			</TABLE>
		</form>
	</BODY>
</HTML>