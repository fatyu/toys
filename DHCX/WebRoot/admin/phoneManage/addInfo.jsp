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
			alert("�û�������Ϊ��.");
			return false;
		}
		if(address==null||address.replace(/^\s*/, "").replace(/\s*$/, "") == ""){
			alert("�칫�ص㲻��Ϊ��.");
			return false;
		}
		if(company==null||company.replace(/^\s*/, "").replace(/\s*$/, "") == ""){
			alert("��˾����Ϊ��.");
			return false;
		}
		
		if(phonenumber!=null&&phonenumber.replace(/^\s*/, "").replace(/\s*$/, "") != ""){
			if (pattern.exec(phonenumber)||phonenumber.toString().length<11||phonenumber.toString().length>30){
				alert("�ֻ����벻�ܺ�����ĸ�����Ĳ��ҳ��Ȳ���С��11����30.");
				return false
			}   
		}
		if(homenumber!=null&&homenumber.replace(/^\s*/, "").replace(/\s*$/, "") != ""){
			if (pattern.exec(homenumber)||homenumber.toString().length>30){
				alert("��ͥ�绰���ܺ�����ĸ�����Ĳ��ҳ���С��30.");
				return false
			}   
		}
		
		if(officenumber!=null&&officenumber.replace(/^\s*/, "").replace(/\s*$/, "") != ""){
			if (pattern.exec(officenumber)||officenumber.toString().length>30){
				alert("�칫�绰���ܺ�����ĸ�����Ĳ��ҳ���С��30.");
				return false
			}   
		}
		return true;
	}
	
	</script>
	<meta http-equiv="Content-Type" content="text/html; charset=gbk">
		<LINK href="<%=basePath%>css/admin.css" type="text/css"
			rel="stylesheet">
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
					���ӵ绰��Ϣ
				</TD>
			</TR>
			<TR bgColor=#ecf4fc height=12>
				<TD></TD>
			</TR>
			<TR height=20>
				<TD></TD>
			</TR>
		</TABLE>
		<form action="<%=basePath%>AddRecordServlet"
			method="post" onsubmit="return checkValue()">
			<TABLE cellSpacing=0 cellPadding=2 width="95%" align=center border=0>
				<TR>
					<TD align=left width=100>
						ְԱ����:
					</TD>
					<TD style="COLOR: #880000">
						<input id="name" type="text" name="name">
					</TD>
				</TR>

				<TR>
					<TD align=left width=100>
						������λ:
					</TD>
					<TD style="COLOR: #880000">
						<input id="company" type="text" name="company">
					</TD>
				</TR>
				<TR>
					<TD align=left width=100>
						��λ����:
					</TD>
					<TD style="COLOR: #880000">
						<input id="department" type="text" name="department">
					</TD>
				</TR>
				<TR>
					<TD align=left width=100>
						ְ��:
					</TD>
					<TD style="COLOR: #880000"><input type="text" name="title">
					</TD>
				</TR>
				<TR>
					<TD align=left width=100>
						�칫�ص�:
					</TD>
					<TD style="COLOR: #880000">
						<input id="address" type="text" name="address">
					</TD>
				</TR>

				<TR>
					<TD align=left width=100>
						�칫�绰:
					</TD>
					<TD style="COLOR: #880000">
						<input type="text" name="officenumber">
					</TD>
				</TR>

				<TR>
					<TD align=left width=100>
						��ͥ�绰:
					</TD>
					<TD style="COLOR: #880000">
						<input type="text" name="homenumber">
					</TD>
				</TR>
				<TR>
					<TD align=left width=100>
						�ֻ�����:
					</TD>
					<TD style="COLOR: #880000">
						<input type="text" name="phonenumber">
						<input type="hidden" name="username" value="${sessionScope.user.username}">
						
					</TD>
				</TR>
				<TR>
					<TD align=center width=100>
						<input type="submit" value="��  ��">
					</TD>
					<TD style="COLOR: #880000">
						<input type="reset" value="��  ��">
					</TD>
				</TR>
			</TABLE>
		</form>

	</BODY>
</HTML>