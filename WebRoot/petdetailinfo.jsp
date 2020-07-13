<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    
    <title>宠物寄存详细信息</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="stylesheet" type="text/css" href="css/petdetailinfo.css">
	
	

  </head>
  
  <body>
    <div class="title">
		<i>详细信息</i>
	</div>
	<div class="return">
		当前管理员：<span><%=session.getAttribute("an")%></span> 
		<a href="adminlogin.jsp">退出>></a>
	</div>
	<div class="column">
	    <a href="mainadmin.jsp" class="back">宠物管理</a>
	    <span class="span">>>查看详细&nbsp;</span>
	</div>
	<hr><br><br>
    <img alt=""  class="img" src="/pet/${petinfo.p_filename}"/>
    <div>
         <table class="tb">
			<tr class="">
				<th>用户</th>
				<th>联系方式</th>
				<th>宠物类别</th>
				<th>宠物名称</th>
				<th>寄存套餐</th>
				<th>其他服务</th>
				<th>寄存时间</th>
				<th>操作人员</th>
			</tr>
   			<tr>
   				<td class="td1">${petinfo.p_user}</td>
   				<td class="td1">${petinfo.p_tel}</td>
   				<td class="td1">${petinfo.p_type}</td>
   				<td class="td1">${petinfo.p_pet}</td>
   				<td class="td1">${petinfo.p_combo}${petinfo.p_price1}/天</td>
   				<td class="td1">${petinfo.p_other}${petinfo.p_price2}/次</td>
   				<td class="td1">${petinfo.p_time}</td>
   				<td class="td1">${petinfo.p_operator}</td>
   			</tr>
         </table>
      </div>
      <br>
      <p class="wenzi">备注信息：</p>
      <textarea  class="note" >${petinfo.p_notes}</textarea>
      <div class="">
         <form action="CompleteOrderServlet" method="post">
            <input type="hidden" name="id" value="${petinfo.p_id}"/>
            <input type="hidden" name="operator" value="<%=session.getAttribute("an")%>"/>
            <table class="table">
               <tr>
                  <td class="td2">当前时间：</td>
                  <td class="td2"><input type="text" class="input1" name="nowtime" value="<%=sdf.format(new Date())%>" readonly="readonly" /></td>
               </tr>
               <tr>
                  <td class="td2">当前寄存：</td>
                  <td class="td2">
	                  <input type="text" class="input2" name="day" value="<%=session.getAttribute("day")%>" readonly="readonly"/>天
	                  <input type="text" class="input2" name="hour" value="<%=session.getAttribute("hour")%>" readonly="readonly"/>小时
                  </td>
               </tr>
               <tr>
                  <td class="td2">共花费：</td>
                  <td class="td2"><input type="text" class="input1" name="spend" value="<%=session.getAttribute("totalmoney")%>" readonly="readonly"/>元</td>
               </tr>
            </table>
            <input type="submit" class="input3" value="完成本次寄存"/>
         </form>
      </div>
  </body>
</html>
