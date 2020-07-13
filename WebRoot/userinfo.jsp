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
    
    <title>个人中心</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="stylesheet" type="text/css" href="css/userinfo.css">
	<script type="text/javascript" src="js/userinfo.js"></script>

  </head>
  
  <body>
     <div class="title">
     	<a href="welcome.jsp" class="a-back">首页</a>
     	<label class="lable">Hi，<%=session.getAttribute("un")%></label>
     	<a href="leavemessage.jsp" class="message">我要留言</a>
     	
     	<a href="signout.jsp" class="a-signout">退出</a>
     	<a href="bespoke.jsp" class="a-bespoke">我要预约</a>
        <div id="title1" class="title1" onclick="div1OnClick(this)">个人信息</div>
        <div id="title2" class="title2"onclick="div2OnClick(this)">我的寄存</div>
        <div id="title3" class="title3" onclick="div3OnClick(this)">修改密码</div>
     </div>
     <div id="personal">
         <form action="UpdateUserInfoServlet" method="post">
            <table class="table1">
                  <tr>
                      <td>用户名：</td>
                      <td><input type="text" class="input1" name="un"  value="${sessionScope.userinfo.userName}" disabled></input></td>
                      <td><span class="span1">*用户名不可修改</span><td>
                  </tr>
                  <tr>
                      <td>电子邮箱：</td>
                      <td><input type="mail" class="input1" name="mail" required value="${sessionScope.userinfo.mail}"></input></td>
                  </tr>
                  <tr>
                      <td>手机号码：</td>
                      <td><input type="text" class="input1" name="tel" required value="${sessionScope.userinfo.tel}"></input></td>
                  </tr>
                  
                  <tr>
                      <td></td>
                      <td><input type="submit" value="确认修改" class="input2"></input></td>
                  </tr>
            </table>
          </form>
      </div>
      
      <div id="order" class="order">
      	 <table class="table2">
			<tr class="tr2">
				<th class="th2">宠物照片</th>
				<th class="th2">宠物用户</th>
				<th class="th2">宠物类别</th>
				<th class="th2">宠物名称</th>
				<th class="th2">寄存套餐</th>
				<th class="th2">其他服务</th>
				<th class="th2">来店时间</th>
				<th class="th2">离店时间</th>
				<th class="th2">寄存时长</th>
				<th class="th2">消费金额/元</th>
				<th class="th2">操作员</th>
			</tr>
   			<c:forEach var="order" items="${sessionScope.order}">
   			<tr>
   				<td class="td2"><img alt="照片" src="/pet/${order.p_filename}" style="width: 85px;height: 85px;"></td>
   				<td class="td2">${order.p_user}</td>
   				<td class="td2">${order.p_type}</td>
   				<td class="td2">${order.p_pet}</td>
   				<td class="td2">${order.p_combo}${order.p_price1}/天</td>
   				<td class="td2">${order.p_other}${order.p_price2}/次</td>
   				<td class="td2">${order.p_time}</td>
   				<td class="td2">${order.p_leavetime}</td>
   				<td class="td2">${order.p_day}天${order.p_hours}小时</td>
   				<td class="td2">${order.p_spend}</td>
   				<td class="td2">${order.p_operator}</td>
   			</tr>
   			</c:forEach>
         </table>
      </div>
      
      <div id="modifypassword" class="modifypassword">
          <form action="UpdatePasswordServlet" method="post">
              <table class="table3">
                  <tr>
                    <td>当前用户：</td>
                    <td><input type="text" class="input1" name="un" value="${sessionScope.userinfo.userName}" disabled></input></td>
                  </tr>
                  <tr>
                    <td>原密码 &nbsp;：</td>
                    <td><input type="password" class="input1" name="up" required></input></td>
                  </tr>
                  <tr>
                    <td>新密码 &nbsp;：</td>
                    <td><input type="password" class="input1" name="nup" required></input></td>
                  </tr>
                  <tr>
                    <td>确认密码：</td>
                    <td><input type="password" class="input1" name="ucp" onblur="btclick()" required></input></td>
                  </tr>
                  <tr>
                    <td></td>
                    <td><input type="submit" class="input2" value="提交修改"></input></td>
                  </tr>
              </table>
       </form>
      </div>
  </body>
</html>
