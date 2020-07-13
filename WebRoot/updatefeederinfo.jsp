<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>修改饲养员信息</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="stylesheet" type="text/css" href="css/updatefeederinfo.css">
	<script type="text/javascript" src="js/jquery.js"></script>
	<script type="text/javascript">
	function uplode(obj) {
		//var filename=document.all("haha");
		//console.log(obj.files[0].name);
		//将名字复制给haha控件
		//filename.value=obj.files[0].name;
		//获得图的url
		console.log(obj.files[0].name);

		var url = window.URL.createObjectURL(obj.files[0]);
		console.log(url);
		//找到控件
		var filename1 = document.all("filename1");
		//给控件的value赋值
		filename1.value = obj.files[0].name;
		 var Img=document.all("img");
		Img.src=url; 
	}
</script>

  </head>
  
  <body>
     <div class="title">
		<i>修改饲养员信息</i>
	</div>
	<div class="return">
		Hi，<span><%=session.getAttribute("an")%></span> 
		<a href="adminlogin.jsp">退出>></a>
	</div>
	<div class="column">
	    <a href="mainadmin.jsp" class="back">宠物管理</a>
	    <span>>></span>
	    <a href="feederinfo.jsp" class="back">饲养员信息</a>
	    <span class="span">>>修改信息&nbsp;</span>
	</div>
	<hr><br><br>
	
	<div class="">
		<form method="post" action="UpdateFeederInfoServlet" enctype="multipart/form-data">
		<input type="hidden" value="${feederinfo.f_id}" name="id"/>
			<table class="add-tb">
				<tr>
					<td>工号</td>
					<td><input type="text" value="${feederinfo.f_number}" name="number" class="input1" required /></td>
				</tr>
				<tr>
					<td>姓名</td>
					<td><input type="text" value="${feederinfo.f_name}" name="fname" class="input1" required /></td>
				</tr>
				<tr>
					<td>性别</td>
					<td><input type="text" value="${feederinfo.f_sex}" name="sex" class="input1"  /></td>
				</tr>
				<tr>
					<td>身份证</td>
					<td><input type="text" value="${feederinfo.f_idcard}" name="idcard" class="input1" /></td>
				</tr>
				<tr>
					<td>电话</td>
					<td><input type="text" value="${feederinfo.f_tel}" name="tel" class="input1"  /></td>
				</tr>
				<tr>
					<td>住址</td>
					<td><input type="text" value="${feederinfo.f_address}" name="address" class="input1"  /></td>
				</tr>
				<tr>
					<td>备注</td>
					<td><input type="text" value="${feederinfo.f_notes}" name="notes" class="input1" /></td>
				</tr>
				<tr>
					<td></td>
					<td><input type="submit" class="input2" value="提&nbsp;&nbsp;交" /></td>
				</tr>
			</table>
			<div class="img-div">
				<img alt="照片" src="/feeder/${feederinfo.f_filename}" id="img" class="img2">
				<input type="file"  name="uploadFile" class="file-input" onchange="uplode(this)"/>
				<div class="upload">
					<a href="javascript:;" class="a-img">选择照片</a>
					<input type="text" id="filename1" class="text-input"/>
				</div>
			</div>

		</form>
	</div>
  </body>
</html>
