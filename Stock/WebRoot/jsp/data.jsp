<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.stock.entity.Stock"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>



<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>首页</title>
		<link href="<%=basePath%>css/border.css" type="text/css"
			rel="stylesheet">
	</head>
	<body>
		<center>
			<a href="<%=basePath%>index.jsp"><font color="#333">重新查找数据</font></a>
		</center>
		<hr align="center" color="red" noshade="noshade" width="700" size="1">

		<div align="center">
			<table id="mytable" cellspacing="0">
				<tr>
					<th scope="col">
						股票代码
					</th>
					<th scope="col">
						日期
					</th>
					<th scope="col">
						时间
					</th>
					<th scope="col">
						开盘价
					</th>
					<th scope="col">
						收盘价
					</th>
					<th scope="col">
						最高价
					</th>
					<th scope="col">
						最低价
					</th>
					<th scope="col">
						成交量
					</th>
				</tr>
				<%
					List list = (List) request.getAttribute("sbs");
					Stock stock = null;
					for (int i = 0; i < list.size(); i++) {
						stock = (Stock) list.get(i);
				%>
				<tr>
					<td class="row">
						<%=stock.getTicker()%>
					</td>
					<td class="row">
						<%=stock.getDate().substring(0, 10)%>
					</td>
					<td class="row">
						<%=stock.getTime()%>
					</td>
					<td class="row">
						<%=stock.getOpenPrice()%>
					</td>
					<td class="row">
						<%=stock.getClosePrice()%>
					</td>
					<td class="row">
						<%=stock.getHighPrice()%>
					</td>
					<td class="row">
						<%=stock.getLowPrice()%>
					</td>
					<td class="row">
						<%=stock.getVolume()%>
					</td>

				</tr>


				<%
					}
				%>
			</table>
		</div>
	</body>
</html>