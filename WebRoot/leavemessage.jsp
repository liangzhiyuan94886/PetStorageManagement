<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>我要留言</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="stylesheet" type="text/css" href="css/leavemessage.css">
	

  </head>
  
  <body>
    <div class="top-div">
    	<label class="lable1">参与留言</label>
    	<a href="signout.jsp" class="a-signout">退出</a>
    	<a href="welcome.jsp" class="a-back">首页</a>
    	<a href="userinfo.jsp" class="a-personal">个人中心</a>
    	<label class="lable2"><%=session.getAttribute("un")%></label>
    </div>
    <div class="text-div">
		<label class="lable3">写下你想说的话或者建议：</label><br>
		<form action="AddMessageServlet" method="post">
			<input type="hidden" value="<%=sdf.format(new Date())%>" name="date"/>
			<textarea class="messagetext" name="content"></textarea>
			<br>
			<br>
			<label class="lable4"><input type="checkbox" value="1" name="sign" />仅管理员可见</label>
			<br>
			<input type="submit" class="input1" value="发表留言" />
		</form>
	</div>
  </body>
</html>
