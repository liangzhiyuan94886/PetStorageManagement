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
    
    <title>查看留言</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="stylesheet" type="text/css" href="css/messageboard.css">
	

  </head>
  
  <body>
    <div class="top-div">
    	<a href="mainadmin.jsp" class="a1"><label><<</label>宠物管理</a>
    	<br>
    	<label class="label1">用户留言</label>
    	<label class="label2">当前管理员：<%=session.getAttribute("an")%>
    	<a href="index.jsp" class="a2">退出</a></label>
    </div>
	<table>
		<c:forEach var="message" items="${sessionScope.message}">
			<tr>
				<td><label class="lable3">来自${message.m_id}楼---${message.m_username}的留言：</label>
				<br> 
				<textarea class="textview">${message.m_content}</textarea><br>
				<label class="label4">${message.m_date}</label>
				</td>
				<td>
				<a href="javascript:if(confirm('确定删除该留言吗?'))location='DeleteMessageServlet?id=${message.m_id}'">
				<img src="images/delete.jpg" class="img-delete">
				</a>
				</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>
