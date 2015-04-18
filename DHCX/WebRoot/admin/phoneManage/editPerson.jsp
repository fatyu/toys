<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<HTML>
	<HEAD>
	<meta http-equiv="Content-Type" content="text/html; charset=gbk">
		<LINK href="<%=basePath%>css/admin.css" type="text/css"
			rel="stylesheet">
			<script type="text/javascript">
			
			function checkValue(){
		var pattern = /[A-Za-z\u4e00-\u9fa5]/;
		var phonenumber = document.getElementById("phonenumber").value;
		var homenumber = document.getElementById("homenumber").value;
		var officenumber = document.getElementById("officenumber").value;
		var name =  document.getElementById("name").value;
		var address =  document.getElementById("address").value;
		var company =  document.getElementById("company").value;
		if(name==null||name.replace(/^\s*/, "").replace(/\s*$/, "") == ""){
			alert("用户名不能为空.");
			return false;
		}
		if(address==null||address.replace(/^\s*/, "").replace(/\s*$/, "") == ""){
			alert("办公地点不能为空.");
			return false;
		}
		if(company==null||company.replace(/^\s*/, "").replace(/\s*$/, "") == ""){
			alert("公司不能为空.");
			return false;
		}
		
		if(phonenumber!=null&&phonenumber.replace(/^\s*/, "").replace(/\s*$/, "") != ""){
			if (pattern.exec(phonenumber)||phonenumber.toString().length<11||phonenumber.toString().length>30){
				alert("手机号码不能含有字母并且长度不得小于11大于30.");
				return false
			}   
		}
		if(homenumber!=null&&homenumber.replace(/^\s*/, "").replace(/\s*$/, "") != ""){
			if (pattern.exec(homenumber)||homenumber.toString().length>30){
				alert("家庭电话不能含有字母并且长度小于30.");
				return false
			}   
		}
		
		if(officenumber!=null&&officenumber.replace(/^\s*/, "").replace(/\s*$/, "") != ""){
			if (pattern.exec(officenumber)||officenumber.toString().length>30){
				alert("办公电话不能含有字母并且长度小于30.");
				return false
			}   
		}
		return true;
	}
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
					更新电话信息
				</TD>
			</TR>
			<TR bgColor=#ecf4fc height=12>
				<TD></TD>
			</TR>
			<TR height=20>
				<TD></TD>
			</TR>
		</TABLE>
		<form action="<%=basePath%>EditPersonServlet"
			method="post" onsubmit="return checkValue()">
			<TABLE cellSpacing=0 cellPadding=2 width="95%" align=center border=0>
				<TR>
					<TD align=left width=100>
						职员姓名:
					</TD>
					<TD style="COLOR: #880000">
						<input id ="name" type="text" name="name" value="${person.name }">
					</TD>
				</TR>

				<TR>
					<TD align=left width=100>
						工作单位:
					</TD>
					<TD style="COLOR: #880000">
						<input type="text" id="company" name="company" value="${person.company }">
					</TD>
				</TR>
				<TR>
					<TD align=left width=100>
						单位部门:
					</TD>
					<TD style="COLOR: #880000">
						<input type="text" id="department" name="department" value="${person.department }">
					</TD>
				</TR>
				<TR>
					<TD align=left width=100>
						职务
					</TD>
					<TD style="COLOR: #880000"><input type="text" name="title" value="${person.title }">
					</TD>
				</TR>
				<TR>
					<TD align=left width=100>
						办公地点:
					</TD>
					<TD style="COLOR: #880000">
						<input type="text" id="address" name="address" value="${person.address }">
					</TD>
				</TR>

				<TR>
					<TD align=left width=100>
						办公电话:
					</TD>
					<TD style="COLOR: #880000">
						<input type="text" id="officenumber" name="officenumber" value="${person.officeNumber }">
					</TD>
				</TR>

				<TR>
					<TD align=left width=100>
						家庭电话:
					</TD>
					<TD style="COLOR: #880000">
						<input type="text" id="homenumber" name="homenumber" value="${person.homeNumber }">
					</TD>
				</TR>
				<TR>
					<TD align=left width=100>
						手机号码:
					</TD>
					<TD style="COLOR: #880000">
						<input type="text" name="phonenumber" id="phonenumber"  value="${person.phoneNumber }">
						<input type="hidden" name="username" value="${sessionScope.user.username}">
						<input type="hidden" name="uuid" value="${person.id }">
						
					</TD>
				</TR>
				<TR>
					<TD align=center width=100>
						<input type="submit" value="更  新">
					</TD>
					<TD style="COLOR: #880000">
						<input type="reset" value="重  置">
					</TD>
				</TR>
			</TABLE>
		</form>

	</BODY>
</HTML>