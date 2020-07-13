<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>管理员登陆</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="stylesheet" type="text/css" href="css/adminlogin.css">
	<script type="text/javascript" src="js/adminlogin.js"></script>

  </head>
  
  <body>
    <div class="admindiv">
    	<span>管理员登录</span>
    </div>
    <div id="form_div">
     <form action="AdminLoginServlet" method="post">
		<input type="text" placeholder="管理员" id="input-text" name="an" required></input>
		<input type="password" placeholder="密码" id="input-password" name="ap" required></input> 
		<input type="submit" value="登 &nbsp;&nbsp;陆" id="input-button" onmouseover="btMouseOver(this)" onmouseout="btMouseOut(this)"></input>
	 </form>
     </div>
  </body>
</html>
