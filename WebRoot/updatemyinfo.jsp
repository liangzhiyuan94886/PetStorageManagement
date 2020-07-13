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
    
    <title>更新我的信息</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="stylesheet" type="text/css" href="css/updatemyinfo.css">
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
		<i>我的信息</i>
	</div>
	<div class="return">
		当前管理员：<span><%=session.getAttribute("an")%></span> 
		<a href="adminlogin.jsp">退出>></a>
	</div>
	<div class="column">
	    <a href="mainadmin.jsp" class="back">宠物管理</a>
	    <span class="span">>>我的信息&nbsp;</span>
	</div>
	<hr><br>
	
	<div class="">
		<form method="post" action="UpdateMyInfoServlet" enctype="multipart/form-data">
		<input type="hidden" value="${admininfo.a_id}" name="id"/>
			<table class="add-tb">
				<tr>
					<td>工号</td>
					<td><input type="text" value="${admininfo.a_number}" name="number" class="input1" required /></td>
				</tr>
				<tr>
					<td>姓名</td>
					<td><input type="text" value="${admininfo.a_name}" name="Aname" class="input1" required /></td>
				</tr>
				<tr>
					<td>性别</td>
					<td><select class="input1" name="sex">
							<option>请选择性别---</option>
							<option <c:if test="${admininfo.a_sex=='男'}">selected</c:if> >男</option>
							<option <c:if test="${admininfo.a_sex=='女'}">selected</c:if> >女</option>
					</select></td>
				</tr>
				<tr>
					<td>身份证</td>
					<td><input type="text" value="${admininfo.a_idcard}" name="idcard" class="input1" /></td>
				</tr>
				<tr>
					<td>电话</td>
					<td><input type="text" value="${admininfo.a_tel}" name="tel" class="input1"  /></td>
				</tr>
				<tr>
					<td>住址</td>
					<td><input type="text" value="${admininfo.a_address}" name="address" class="input1"  /></td>
				</tr>
				<tr>
					<td>备注</td>
					<td><input type="text" value="${admininfo.a_notes}" name="notes" class="input1" /></td>
				</tr>
				<tr>
					<td></td>
					<td><input type="submit" class="input2" value="更&nbsp;新&nbsp;信&nbsp;息" /></td>
				</tr>
			</table>
			<div class="img-div">
				<img alt="照片" src="/admin/${admininfo.a_filename}" id="img" class="img2">
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
