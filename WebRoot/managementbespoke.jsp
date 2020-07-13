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
    
    <title>预约寄存</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">

	<link rel="stylesheet" type="text/css" href="css/managementbespoke.css">
	

  </head>
  
  <body>
    <div class="title">
		<i>预约信息</i>
	</div>
	<div class="return">
		Hi，<span><%=session.getAttribute("an")%></span> 
		<a href="adminlogin.jsp">退出>></a>
	</div>
	<div class="column">
	    <a href="mainadmin.jsp" class="back">宠物管理</a>
	    <span class="span">>>处理预约&nbsp;</span>
	</div>
	<hr><br>
	
	<table class="table">
            <tr class="tr1">
               <th>寄存人</th>
               <th>宠物类别</th>
               <th>宠物名称</th>
               <th>联系电话</th>
               <th>到店时间</th>
               <th>操作</th>
               <th>操作</th>
            </tr>
            <c:forEach var="bespoke" items="${sessionScope.bespoke}">
            <tr class="tr2">
               <td>${bespoke.b_username}</td>
               <td>${bespoke.b_type}</td>
               <td>${bespoke.b_pet}</td>
               <td>${bespoke.b_tel}</td>
               <td>${bespoke.b_date}</td>
               <td>
                  <a href="QueryBespokeByIdServlet?id=${bespoke.b_id}">处理订单</a>
               </td>
               <td>
                  <a href="javascript:if(confirm('确定要删除吗?'))location='DeleteBespokeByIdServlet?id=${bespoke.b_id}'">删除</a>
               </td>
            </tr>
            </c:forEach>
         </table>
  </body>
</html>
