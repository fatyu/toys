<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<c:set var="path" value="${pageContext.request.contextPath}" />

<html>
  <head>
    <title>登陆页面</title>
  </head>
  <body>
  <%
  	if(request.getAttribute("message")!=null)
  	{
  		out.print("<font color='RED'>"+request.getAttribute("message")+"<font>");
  	}
  %>
  <form method="post" action="${path}/user?method=login">

   <table width="737" border="0" align="center">
  <tr>
    <td colspan="2" bgcolor="#66CCFF"><div align="center"><strong>登陆</strong></div></td>
  </tr>
  <tr>
    <td width="123" bgcolor="#66CCFF"><div align="center">用户名：</div></td>
    <td width="598" bgcolor="#66CCFF"><label>
      <div align="left">
        <input type="text" name="username"/>
      </div>
    </label></td>
  </tr>
  <tr>
    <td bgcolor="#66CCFF"><div align="center">密码：    </div></td>
    <td bgcolor="#66CCFF"><label>
      <div align="left">
        <input type="password" name="password"/>
      </div>
    </label></td>
  </tr>
  <tr>
    <td bgcolor="#66CCFF"><label>
      <div align="center">
        <input type="submit" value="提交" />
      </div>
    </label></td>
    <td bgcolor="#66CCFF"><label>
        <div align="left">
        <input type="reset" value="重置" />
      </div>
    </label></td>
  </tr>
</table>
  </form>
  
  </body>
</html>
