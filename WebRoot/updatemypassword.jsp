<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>修改我的密码</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="stylesheet" type="text/css" href="css/updatemypassword.css">
	<script type="text/javascript">
		function check(){
			var p0 = document.all("oldpassword").value;
			var p1 = document.all("newpassword1").value;
			var p2 = document.all("newpassword2").value;
			if(p0!=""&&p1!=""&&p2!=""&&p1==p2){
			document.all("form").submit();
			}else if(p0!=""&&p1!=""&&p2!=""&&p1!=p2){
			alert("密码不一致！");
			}else{
			alert("请输入密码！");
			}
		}
		/* function pass(){
			var p1 = document.all("newpassword1").value;
			var p2 = document.all("newpassword2").value;
			if(p1!=p2){
			alert("密码不一致！");
			}
		} */
	</script>

  </head>
  
  <body>
    <div class="title">
		<i>修改密码</i>
	</div>
	<div class="return">
		当前管理员：<span><%=session.getAttribute("an")%></span> 
		<a href="adminlogin.jsp">退出>></a>
	</div>
	<div class="column">
	    <a href="mainadmin.jsp" class="back">宠物管理</a>
	    <span class="span">>>修改我的密码&nbsp;</span>
	</div>
	<hr><br>

	<div>
		<form action="UpdateMyPasswordServlet" method="post" id="form">
			<table class="table">
				<input type="hidden" value=""/>
				<tr>
					<td>验证原密码：</td>
					<td><input type="text" value="" class="input1" name="oldpassword" /></td>
				</tr>
				<tr>
					<td>输入新密码：</td>
					<td><input type="password" value="" class="input1" name="newpassword1" /></td>
				</tr>
				<tr>
					<td>确认新密码：</td>
					<td><input type="password" value="" class="input1" onblur="pass()" name="newpassword2" /></td>
				</tr>
				<tr>
				<td colspan="2">
				<input type="button" value="修改密码" class="input2" onclick="check()"/>
				</td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>
