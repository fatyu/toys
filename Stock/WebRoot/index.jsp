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
		<title>搜索一下，可能找到。</title>
		<script type="text/javascript" src="js/WdatePicker.js"></script>
		<script type="text/javascript" src="js/calendar.js"></script>
		<script type="text/javascript">
		function getfocus(){
			document.getElementById("tickerinput").focus();
			}

		function checkticker(){
			var value = document.getElementById("tickerinput").value;
			if(value==""||value==null){
				document.getElementById("tickertip").style.display="inline";
				}else{document.getElementById("tickertip").style.display="none";
					}
			}
		//function recheck(){
		//	var value = document.getElementById("tickerinput").value;
		//	if(value==""||value==null){
			//	document.getElementById("tickertip").style.display="inline";
				//return false;
			//	}else{document.getElementById("tickertip").style.display="none";
			//	return true;
			//		}
		//	}
		</script>
		<style>
body {
	font: 12px;
	text-align: center;
	background: #333;
	text-align: center;
}
</style>
	</head>
	<body onload="getfocus()">

		<br />
		<br />
		<img src="<%=basePath%>images/logo.jpg" width="200" height="80"
			alt="小小搜">
		<br />
		<br />
		<br />
		<fieldset style="background-color: #ccc">
		
		<label style="background-color: #fff"><font color="red">股票代码和起始日期必须填写任意一项</font></label>
			<form action="<%=basePath%>servlet/lbtServlet" method="post"
				name="stockform" onsubmit="return recheck();">
				股票代码:
				<input type="text" name="ticker" id="tickerinput"
					style="border: #f00 1px dotted;" onblur="checkticker()">
				<div id="tickertip" style="display: none;">
					<font color="red" size="2px">请输入美股的股票代码</font>
				</div>
				<br />
				<br />
				<br />
				<font color="blue">日期可不选择,默认查询全部数据,也可以只选择起始日期。</font>
				<br />
				从
				<input class="Wdate" type="text" onClick="WdatePicker()"
					name="startdate">
				开始,到
				<input class="Wdate" type="text" onClick="WdatePicker()"
					name="enddate">
				截止.
				<br />
				<br />
				<br />
				<input type="submit" value="搜一下">
			</form>
		</fieldset>
	</body>
</html>