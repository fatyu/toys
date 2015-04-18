<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">
		<title>导入数据</title>
		<link rel="stylesheet" type="text/css" href="<%=basePath%>css/importdata.css" />
		<script type="text/javascript">
			function check() {
				if(up.excel.value==""){
					alert("请选择Excel文件.");
				return false;
				}
				var type = up.excel.value.match(/^(.*)(\.)(.{1,8})$/)[3];
				type = type.toUpperCase();
				if (type == "XLS") {
					return true;
				} else {
					alert("上传文件类型只能是xls");
					return false;
				}
			}
		</script>
	</head>



	<body>

		<DIV class="content_a"  style=" background-image:url(<%=basePath %>images/content.png);">
					<DIV class="content_aa">
						
					</DIV>
					<DIV class="content_aa">
						<div style="padding:0px 0px 0px 20px; ">
						<form name="up" action="<%=basePath%>UploadServlet"
						enctype="multipart/form-data" method="post"
						onsubmit="return(check())">
						<br/>
						<input type="file" name="excel" size="80">
						<br/><br/>
						<input type="submit" value="导入数据">
					</form>
					</div>
					</DIV>
			   </DIV>

			<div class="content_d">
				<div class="content_da" style="padding-top: 5px;">
					<font color="blue">1.文件格式为xls文件</font>
				</div>
			</div>
	</body>
</html>
