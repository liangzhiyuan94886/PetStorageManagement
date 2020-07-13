<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

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
	
	<link rel="stylesheet" type="text/css" href="css/bespoke.css">
	<script type="text/javascript" src="js/jquery.js"></script>
	<script type="text/javascript">
	function change() {
	var type = document.getElementById('type').value;
	if (type == "宠物狗") {
		document.getElementById("pet1").name = 'pets';
		document.getElementById("pet2").name = 'null';
		document.getElementById("pet3").name = 'null';
	} else if (type == "宠物猫") {
		document.getElementById("pet2").name = 'pets';
		document.getElementById("pet1").name = 'null';
		document.getElementById("pet3").name = 'null';
	} else if (type == "其他宠物") {
		document.getElementById("pet3").name = 'pets';
		document.getElementById("pet1").name = 'null';
		document.getElementById("pet2").name = 'null';
	}
}
	//联动选择器
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
    <div class="top-div">
    	<label class="lable1">预约寄存</label>
    	<a href="signout.jsp" class="a-signout">退出</a>
    	<a href="welcome.jsp" class="a-back">首页</a>
    	<a href="userinfo.jsp" class="a-personal">个人中心</a>
    	<label class="lable2"><%=session.getAttribute("un")%></label>
    	<input type="hidden" name="un" value="<%=session.getAttribute("un")%>"/>
    </div>
    <table>
   	   <form action="AddBespokeServlet" method="post" id="form">
   	   <input type="hidden" name="userid" value="${sessionScope.userinfo.u_id}" >
    	<tr>
    		<td>寄存人：</td>
    		<td><input type="text" name="username" class="input1" required/></td>
    	</tr>
    	<tr>
    		<td>宠物类型：</td>
    		<td>
    			<select id="type" name="pettype" class="select" onchange="change()">
							<option value="null">选择宠物种类--</option>
							<option>宠物狗</option>
							<option>宠物猫</option>
							<option>其他宠物</option>
						</select> 
						<select class="pet">
								<option>选择宠物--</option>
						</select> 
						<select class="pet" id="pet1" name="">
								<option>金毛犬</option>
								<option>贵宾犬</option>
								<option>哈士奇</option>
								<option>泰迪</option>
								<option>博美犬</option>
						</select> 
						<select class="pet" id="pet2" name="">
								<option>布偶猫</option>
								<option>异国短毛猫</option>
								<option>挪威森林猫</option>
								<option>波斯猫</option>
								<option>暹罗猫</option>
						</select> 
						<select class="pet" id="pet3" name="">
								<option>磨光兔</option>
								<option>仓鼠</option>
								<option>豚鼠</option>
								<option>大耳白兔</option>
								<option>龙猫</option>
						</select>
    		</td>
    	</tr>
    	<tr>
    		<td>联系电话：</td>
    		<td><input type="text" name="tel" class="input1" required/></td>
    	</tr>
    	<tr>
    		<td>到店时间：</td>
    		<td><input type="datetime-local" name="comedate" class="input1"/></td>
    	</tr>
    	<tr>
    		<td></td>
    		<td><input type="submit" class="input2"/></td>
    	</tr>
       </form>
    </table>
  </body>
</html>
