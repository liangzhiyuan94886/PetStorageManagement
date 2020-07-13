<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>添加宠物资料信息</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="stylesheet" type="text/css" href="css/addpetinformation.css">
	<script type="text/javascript" src="js/addpetinformation.js"></script>
	<script type="text/javascript" src="js/jquery.js"></script>
	<script type="text/javascript"> 
var currentShowCity=0;
$(document).ready(function(){
   $("#type").change(function(){
	   $("#type option").each(function(i,o){
		   if($(this).attr("selected"))
		   {
			   $(".pet").hide();
			   $(".pet").eq(i).show();
			   currentShowCity=i;
		   }
	   });
   });
   $("#type").change();
});

</script>

  </head>
  
  <body>
    <div class="title">
		<i>添加宠物详细信息</i>
	</div>
	<div class="return">
		Hi，<span><%=session.getAttribute("an")%></span> 
		<a href="adminlogin.jsp">退出>></a>
	</div>
	<div class="column">
	    <a href="mainadmin.jsp" class="back">宠物管理</a>
	    <span>>></span>
	    <a href="petinformation.jsp" class="back">资料查看</a>
	    <span class="span">>>添加信息&nbsp;</span>
	</div>
	<hr><br>
	
	<div>
      <form action="AddPetInformationServlet" id="form" method="post">
          <table class="table">
              <tr>
                 <td>宠物名字</td>
                 <td><input type="text" class="input1" name="petname" /></td>
              </tr>
              <tr>
                 <td>宠物类型</td>
                 <td>
                 <select id="type" name="pettype" class="select" onchange="change()">
							<option value="null">选择宠物种类--</option>
							<option>宠物狗</option>
							<option>宠物猫</option>
							<option>其他宠物</option>
					</select>
					<select class="pet" >
							<option>选择宠物--</option>
					</select> <select class="pet" id="pet1" name="">
							<option>金毛犬</option>
							<option>贵宾犬</option>
							<option>哈士奇</option>
							<option>泰迪</option>
							<option>博美犬</option>
					</select> <select class="pet" id="pet2" name="">
							<option>布偶猫</option>
							<option>异国短毛猫</option>
							<option>挪威森林猫</option>
							<option>波斯猫</option>
							<option>暹罗猫</option>
					</select> <select class="pet" id="pet3" name="">
							<option>磨光兔</option>
							<option>仓鼠</option>
							<option>豚鼠</option>
							<option>大耳白兔</option>
							<option>龙猫</option>
					</select>
					</td>
              </tr>
              <tr>
                 <td>外表颜色</td>
                 <td><input type="text" class="input1" name="petcolor" /></td>
              </tr>
              <tr>
                 <td>体重</td>
                 <td><input type="text"  class="input1" name="petweight" /></td>
              </tr>
              <tr>
                 <td>年龄</td>
                 <td><input type="text" class="input1" name="petage" /></td>
              </tr>
              <tr>
                 <td>宠物主人</td>
                 <td><input type="text" class="input1" name="petowner" /></td>
              </tr>
          </table>
   
   <input type="submit" class="input2" value="提交"/>
   </form>
      </div>
  </body>
</html>
