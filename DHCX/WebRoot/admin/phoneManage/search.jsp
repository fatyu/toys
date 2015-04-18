<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<meta http-equiv="Content-Type" content="text/html; charset=gbk">
	<head>
		<title>电话信息查询</title>
		<script type="text/javascript" src="<%=basePath %>js/xml.js"></script>
		<script type="text/javascript">
function getfocus() {
	var node = document.getElementById("keywordid").focus();
}

function recheck() {
	var value = document.getElementById("keywordid").value;
	if (value.replace(/^\s*/, "").replace(/\s*$/, "") == "" || value == null) {
		document.getElementById("tip").style.display = "inline";
		return false;
	} else {
		document.getElementById("tip").style.display = "none";
		return true;
	}
}
</script>
		
	</head>
	<body onload="getfocus()">
			<form action="<%=basePath%>QueryServlet" method="post"
				name="searchform" onsubmit="return recheck()">
				查询类型:
				<select name="kind">
					<option value="1" selected="selected">
						人员姓名
					</option>
					<option value="2">
						办公电话
					</option>
					<option value="3">
						家庭电话
					</option>
					<option value="4">
						手机号码
					</option>
				</select>
				查询条件:
				<input id="keywordid" type="text" name="keyword"
					style="border: #00f 1px dotted;" />
					<input  type="hidden" name="admin" value="admin"
					 /><div id="tip" style="display: none;">
					<font color="blue" size="2px">请输入查询条件</font>
				</div>
					 选择工作单位:
				<select id="companyNode" name="company"  >
				<%
					List list = (List) request.getSession().getAttribute("list");
					for (int i = 0; i < list.size(); i++) {
						String result =  (String)list.get(i);
				%>
					<option value=<%=result %>><%=result %></option>
					<%
					}
				%>
				</select>	 
				<input type="submit" value="查  询">
			</form>
		</body>
</html>