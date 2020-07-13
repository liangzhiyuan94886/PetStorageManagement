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
    
    <title>饲养员信息</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="stylesheet" type="text/css" href="css/feederinfo.css">
	<script type="text/javascript" src="js/feederinfo.js"></script>
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
		<i>饲养员信息</i>
	</div>
	<div class="out">
		Hi，<span><%=session.getAttribute("an")%></span> 
		<a href="adminlogin.jsp">退出>></a>
	</div>
	<div class="column">
	    <a href="mainadmin.jsp" class="back">宠物管理</a>
	    <span class="span">>>饲养员信息&nbsp;</span>
	</div>
	<hr><br>
	<div class="left-column">
	      <a href="feederinfo.jsp">返回饲养员信息</a><br>
	      <a href="javascript:;" onclick="addclick(this)">添加饲养员信息</a>
	</div>
	<div class="list" id="list">
		<table class="listtable">
			<tr>
				<th class="th1">照片</th>
				<th class="th1">工号</th>
				<th class="th1">姓名</th>
				<th class="th1">性别</th>
				<th class="th1">身份证</th>
				<th class="th1">电话</th>
				<th style="width: 160px">住址</th>
				<th class="th1">备注</th>
				<th class="th1">操作</th>
			</tr>
			<c:forEach var="feeder" items="${sessionScope.feederlist}">
			<tr>
				<td class="td1"><img alt="" class="img1" src="/feeder/${feeder.f_filename}"/></td>
				<td class="td1">${feeder.f_number}</td>
				<td class="td1">${feeder.f_name}</td>
				<td class="td1">${feeder.f_sex}</td>
				<td class="td1">${feeder.f_idcard}</td>
				<td class="td1">${feeder.f_tel}</td>
				<td class="td1">${feeder.f_address}</td>
				<td class="td1">${feeder.f_notes}</td>
				<td class="td1">
				   <a href="QueryFeederInfoByIdServlet?id=${feeder.f_id}">修改</a>
				   <a href="javascript:if(confirm('确定要删除吗?'))location='DeleteFeederInfoServlet?id=${feeder.f_id}'">删除</a>
				</td>
			</tr>
			</c:forEach>
		</table>
	</div>
	<div class="addinfo" id="add">
		<form method="post" action="AddFeederInfoServlet" enctype="multipart/form-data">
			<table class="add-tb">
				<tr>
					<td>工号</td>
					<td><input type="text" name="number" class="input1" required /></td>
				</tr>
				<tr>
					<td>姓名</td>
					<td><input type="text" name="fname" class="input1" required /></td>
				</tr>
				<tr>
					<td>性别</td>
					<td><input type="text" name="sex" class="input1" required /></td>
				</tr>
				<tr>
					<td>身份证</td>
					<td><input type="text" name="idcard" class="input1" required /></td>
				</tr>
				<tr>
					<td>电话</td>
					<td><input type="text" name="tel" class="input1" required /></td>
				</tr>
				<tr>
					<td>住址</td>
					<td><input type="text" name="address" class="input1" required /></td>
				</tr>
				<tr>
					<td>备注</td>
					<td><input type="text" name="notes" class="input1" required /></td>
				</tr>
				<tr>
					<td></td>
					<td><input type="submit" class="input2" value="提&nbsp;&nbsp;交" /></td>
				</tr>
			</table>
			<div class="img-div">
				<img alt="照片" src="" id="img" class="img2">
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
