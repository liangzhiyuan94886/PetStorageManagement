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
    
    <title>宠物资料</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="stylesheet" type="text/css" href="css/petinformation.css">
	<script type="text/javascript" src="js/petinformation.js"></script>

  </head>
  
  <body>
     <div class="title">
		<i>宠物资料</i>
	</div>
	<div class="return">
		Hi，<span><%=session.getAttribute("an")%></span> 
		<a href="adminlogin.jsp">退出>></a>
	</div>
	<div class="column">
	    <a href="mainadmin.jsp" class="back">宠物管理</a>
	    <span class="span">>>资料查看&nbsp;</span>
	</div>
	<hr><br><br>
	
      <div class="adddiv" onmouseover="Mouseover(this)" onmouseout="Mouseout(this)">
      <a href="addpetinformation.jsp" class="tianjia">添加</a>
      </div>
      <div>
         <table class="table">
            <tr class="tr1">
               <th>宠物名字</th>
               <th>宠物类别</th>
               <th>宠物名称</th>
               <th>外表颜色</th>
               <th>体重/kg</th>
               <th>年龄/月</th>
               <th>宠物主人</th>
               <th>操作</th>
            </tr>
            <c:forEach var="pet" items="${sessionScope.petinformation}">
            <tr class="tr2">
               <td>${pet.m_name}</td>
               <td>${pet.m_type}</td>
               <td>${pet.m_pets}</td>
               <td>${pet.m_color}</td>
               <td>${pet.m_weight}</td>
               <td>${pet.m_age}</td>
               <td>${pet.m_owner}</td>
               <td>
                  <a href="QueryPetInformationByIdServlet?id=${pet.m_id}">修改</a>
                  <a href="javascript:if(confirm('确定要删除吗?'))location='DeletePetInformationServlet?id=${pet.m_id}'">删除</a>
               </td>
            </tr>
            </c:forEach>
         </table>
      </div>
  </body>
</html>
