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
		<title>�绰��Ϣ��ѯ</title>
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
				��ѯ����:
				<select name="kind">
					<option value="1" selected="selected">
						��Ա����
					</option>
					<option value="2">
						�칫�绰
					</option>
					<option value="3">
						��ͥ�绰
					</option>
					<option value="4">
						�ֻ�����
					</option>
				</select>
				��ѯ����:
				<input id="keywordid" type="text" name="keyword"
					style="border: #00f 1px dotted;" />
					<input  type="hidden" name="admin" value="admin"
					 /><div id="tip" style="display: none;">
					<font color="blue" size="2px">�������ѯ����</font>
				</div>
					 ѡ������λ:
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
				<input type="submit" value="��  ѯ">
			</form>
		</body>
</html>