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
    
    <title>查看管理员信息</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="stylesheet" type="text/css" href="css/admininfo.css">
	

</head>
  
  <body>
    <div class="title">
		<i>管理员信息</i>
	</div>
	<div class="return">
		当前管理员：<span id="q"><%=session.getAttribute("an")%></span>
		<a href="adminlogin.jsp">退出>></a>
	</div>
	<div class="column">
	    <a href="mainadmin.jsp" class="back">宠物管理</a>
	    <span class="span">>>查看管理员信息&nbsp;</span>
	</div>
	<hr><br>
	
	<div class="list">
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
			</tr>
			<c:forEach var="admin" items="${sessionScope.adminlist}">
			<tr>
				<td class="td1"><img alt="" class="img1" src="/admin/${admin.a_filename}"/></td>
				<td class="td1">${admin.a_number}</td>
				<td class="td1">${admin.a_name}</td>
				<td class="td1">${admin.a_sex}</td>
				<td class="td1">${admin.a_idcard}</td>
				<td class="td1">${admin.a_tel}</td>
				<td class="td1">${admin.a_address}</td>
				<td class="td1">${admin.a_notes}</td>
			</tr>
			</c:forEach>
		</table>
	</div>
  </body>
</html>
