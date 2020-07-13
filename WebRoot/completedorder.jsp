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
    
    <title>宠物寄存历史记录</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="stylesheet" type="text/css" href="css/completedorder.css">
	

  </head>
  
  <body>
     <div class="title">
		<i>历史记录</i>
	</div>
	<div class="return">
		当前管理员：<span><%=session.getAttribute("an")%></span> 
		<a href="adminlogin.jsp">退出>></a>
	</div>
	<div class="column">
	    <a href="mainadmin.jsp" class="back">宠物管理</a>
	    <span class="span">>>查看历史&nbsp;</span>
	</div>
	<hr><br>
	<div>
	   <table class="tb">
			<tr class="">
				<th>用户</th>
				<th>联系方式</th>
				<th>宠物类别</th>
				<th>宠物名称</th>
				<th>寄存套餐</th>
				<th>其他服务</th>
				<th>来店时间</th>
				<th>离店时间</th>
				<th>寄存时长</th>
				<th>消费金额</th>
				<th>操作员</th>
			</tr>
			<c:forEach items="${sessionScope.history}" var="history">
   			<tr>
   				<td class="td1">${history.p_user}</td>
   				<td class="td1">${history.p_tel}</td>
   				<td class="td1">${history.p_type}</td>
   				<td class="td1">${history.p_pet}</td>
   				<td class="td1">${history.p_combo}${history.p_price1}/天</td>
   				<td class="td1">${history.p_other}${history.p_price2}/次</td>
   				<td class="td1">${history.p_time}</td>
   				<td class="td1">${history.p_leavetime}</td>
   				<td class="td1">${history.p_day}天${history.p_hours}小时</td>
   				<td class="td1">${history.p_spend}</td>
   				<td class="td1">${history.p_operator}</td>
   			</tr>
   			</c:forEach>
         </table>
	</div>
  </body>
</html>
