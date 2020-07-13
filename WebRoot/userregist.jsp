<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>用户注册</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="stylesheet" type="text/css" href="css/userregist.css">
	<script type="text/javascript" src="js/userregist.js"></script>

  </head>
  
  <body>
    <div id="top">
        <a href="userlogin.jsp" id="a1">登陆</a>
        <a href="welcome.jsp" class="a2">首页</a>
    </div>
    <div id="form_div">
    <form action="UserRegistServlet" method="post">
       <table>
           <tr>
              <td>用户名</td>
              <td><input type="text" id="input1" name="un" required></input></td>
           </tr>
           <tr>
              <td>设置密码</td>
              <td><input type="password" id="input1" name="up" required></input></td>
           </tr>
           <tr>
              <td>确认密码</td>
              <td><input type="password" id="input1" name="ucp" onblur="btclick()" required></input></td>
           </tr>
           <tr>
              <td>电子邮箱</td>
              <td><input type="email" id="input1" name="mail" required></input></td>
           </tr>
           <tr>
              <td>手机号码</td>
              <td><input type="text" id="input1" name="tel" required></input></td>
           </tr>
       </table>
       <input type="submit" id="input2" value="立即注册"></input>
    </form>
    </div>
    
    <div class="wdiv">
            <span class="sp2">
                                                注册成为我们的的用户后，您可以：
            </span>
            <ul>
                <li>享受超低寄存<span class="sp3">价格</span>和<span class="sp3">优质</span>服务！</li><br>
                <li>提前<span class="sp3">预约</span>有惊喜！</li><br>
                <li>查询、计划您的<span class="sp3">订单</span>信息。</li><br>
                <li>参与我们的<span class="sp3">留言</span>活动。</li>
            </ul>
            <img alt="宣传图片" src="images/img-regist.jpg" style="width: 300px;height: 300px">
       </div>
  </body>
</html>
