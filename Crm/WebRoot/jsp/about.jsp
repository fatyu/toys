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
			<LINK rel="stylesheet" type="text/css" href="<%=basePath %>css/base.css">
				<LINK rel="stylesheet" type="text/css" href="<%=basePath %>css/style.css">
	</HEAD>
	<BODY class="root-help">
		<DIV id="canvas" class="canvas">
			<DIV id="canvasInt" class="canvasInt">

				<DIV id="page-help" class="page-help">

					<DIV class="appHead">
						<H3>
							关于公司
						</H3>
					</DIV>

					<DIV class="appBody">
						<DIV class="appContent">
							<P align="center">
								<IMG src="<%=basePath %>images/about.jpg" alt="客户至上" width="552" height="257"
									style="margin: 0 auto 10px;">
							</P>

							<P>
								我们相信，创造和控制客户的信息，是员工的基本义务。公司连接你和你的客户，帮助用户创造和控制客户的信息，交付更加丰富、安全、有趣和可靠的沟通体验，无论何时、何地、通过何种设备。
							</P>

							<P>
								我们相信，良好的沟通创造良好的效益。社会发展中，人们生产爱也给予爱，生产快乐也给予快乐。公司里，正直的人受爱戴，诚信的人受尊重。公司里，每个人都满载希望，一份耕耘一份收获。
							</P>
						</DIV>
					</DIV>
				</DIV>
			</DIV>
		</DIV>
	</BODY>
</HTML>