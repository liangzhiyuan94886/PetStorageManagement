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
    
    <title>宠物管理</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="stylesheet" href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css">
	<link rel="stylesheet" type="text/css" href="css/mainadmin.css">
	<script type="text/javascript" src="js/mainadmin.js"></script>
	<script type="text/javascript" src="js/jquery.js"></script>
	<script>
      $(function(){
        //垂直导航栏，点击下拉子菜单
        $(".main>a").click(function(){
          $(this).next().slideToggle(500)
          .parent().siblings().find(".child").slideUp(500);
        });
          
        //水平导航栏，鼠标经过下拉导航栏
        $(".hmain").hover(function(){
          $(this).find(".child").slideToggle(500)
            .parent().siblings().find(".child").slideUp();
        });
      });
    </script>
    
    
  </head>
  
  <body onload="onload()">
      <div class="title">
         <i>宠物管理</i>
      </div>
      <div class="out">
         Hi，<span><%=session.getAttribute("an")%></span>
         <input type="hidden" name="an" value="<%=session.getAttribute("an")%>"/>
         <a href="index.jsp">退出>></a>
      </div>
      <hr>
      
      <div class="search">
		<form action="QueryPetInfoByLikeServlet" method="post" id="form">
			按条件查找：<input type="text" placeholder="用户、电话或宠物类别" class="input1" name="content1"/>
			<input type="text" placeholder="套餐或其他服务" class="input1" name="content2"/>
			<input type="date"  class="input0" name="date1" />至
			<input type="date" class="input0" name="date2"/>&nbsp;&nbsp;&nbsp;&nbsp;
			<input type="button" class="input2" value="搜&nbsp;索" onclick="searchclick()"/>
		</form>
	  </div>
	  
	  

	<ul class="content">
      <li class="main"><a>寄存信息管理</a>
        <ul class="child">
          <li><a href="addpetinfo.jsp">添加寄存信息</a></li>
          <li><a href="QueryBespokeServlet">预约寄存信息</a></li>
          <li><a href="QueryPetInformationServlet">宠物详细资料</a></li>
          <li><a href="QueryCompletedOrderServlet">已完成寄存</a></li>
        </ul>
      </li>
      <li class="main"><a>统计信息管理</a>
        <ul class="child">
          <li><a href="totalrevenue.jsp">营收统计</a></li>
        </ul>
      </li>
      <li class="main"><a>员工信息</a>
        <ul class="child">
          <li><a href="QueryAdminInfoServlet">管理员信息</a></li>
          <li><a href="QueryFeederInfoServlet">饲养员信息</a></li>
          <li><a href="QueryAccountInfoServlet" id="super">账号管理</a></li>
        </ul>
      </li>
      <li class="main"><a>留言信息</a>
        <ul class="child">
          <li><a href="QueryAllMessageServlet">查看用户留言</a></li>
        </ul>
      </li>
      <li class="main"><a>我的信息</a>
        <ul class="child">
          <li><a href="QueryMyInfoServlet">更新个人信息</a></li>
          <li><a href="updatemypassword.jsp">修改密码</a></li>
        </ul>
      </li>
    </ul>

	<div class="detail">
         <table class="tb">
			<tr class="tr1">
				<th>用户</th>
				<th>联系方式</th>
				<th>宠物类别</th>
				<th>宠物名称</th>
				<th>寄存套餐</th>
				<th>其他服务</th>
				<th>寄存时间</th>
				<th>详细信息</th>
				<th>操作</th>
			</tr>
			<c:forEach var="petinfo" items="${sessionScope.petlist}">
   				<tr onmouseover="trMouseOver(this)" onmouseout="trMouseOut(this)">
   					<td>${petinfo.p_user}</td>
   					<td>${petinfo.p_tel}</td>
   					<td>${petinfo.p_type}</td>
   					<td>${petinfo.p_pet}</td>
   					<td>${petinfo.p_combo}</td>
   					<td>${petinfo.p_other}</td>
   					<td>${petinfo.p_time}</td>
   					<td><a href="QueryPetDetailInfoServlet?id=${petinfo.p_id}">查看详细</a></td>
   					<td>
   					   <a href="QueryPetInfoByIdServlet?id=${petinfo.p_id}"><span class="glyphicon glyphicon-edit"></span></a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
   					   <a href="javascript:if(confirm('确定要删除吗?'))location='DeletePetInfoServlet?id=${petinfo.p_id}'"><span class="glyphicon glyphicon-trash"></span></a>
   					</td>
   				</tr>
   			</c:forEach>
         </table>
      </div>
      
      
  </body>
</html>
