<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>留言展示</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link rel="stylesheet" type="text/css" href="css/messageboard.css">
	

  </head>
  
  <body>
    <div><a href="welcome.jsp" style="color:#FBC02D;font-size: 25px;">首页</a></div>
    <table>
		<c:forEach var="messageonly" items="${sessionScope.messageonly}">
			<tr>
				<td><label class="lable3">来自${messageonly.m_id}楼---${message.m_username}的留言：</label>
				<br> 
				<textarea class="textview">${messageonly.m_content}</textarea><br>
				<label class="label4">${messageonly.m_date}</label>
				</td>
			</tr>
		</c:forEach>
	</table>
  </body>
</html>
