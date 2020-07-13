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
    
    <title>处理预约寄存订单</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link rel="stylesheet" type="text/css" href="css/updatepetinfo.css">
	<script type="text/javascript" src="js/updatepetinfo.js"></script>
	<script type="text/javascript" src="js/jquery.js"></script>
	<script type="text/javascript">
	function uplode(obj) {
		//var filename=document.all("haha");
		//console.log(obj.files[0].name);
		//将名字复制给haha控件
		//filename.value=obj.files[0].name;
		//获得图的url
		console.log(obj.files[0].name);
		var url = window.URL.createObjectURL(obj.files[0]);
		console.log(url);
		//找到控件
		var filename1 = document.all("filename1");
		//给控件的value赋值
		filename1.value = obj.files[0].name;
		/* var Img=document.all("img");
		Img.src=url; */
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
  
  <body onload="onload()">
     <div class="title">
		<i>处理预约寄存</i>
	</div>
	<div class="return">
		Hi，<span><%=session.getAttribute("an")%></span>
		<a href="adminlogin.jsp">退出>></a>
	</div>
	<div class="column">
	    <a href="mainadmin.jsp" class="back">宠物管理</a>
	    <span class="span">>>预约寄存&nbsp;</span>
	</div>
	<hr><br>
	<div>
		<form action="AddPetInfoByYuYueServlet" method="post" enctype="multipart/form-data">
		<!-- 预约的用户寄存时insert userid辨认 -->
		<input type="hidden" value="${bespokeByid.b_userid}" name="userid"/>
		<!-- 根据b_id来update 哪一个b_sign=2 -->
		<input type="hidden" value="${bespokeByid.b_id}" name="b_id"/>
		<input type="hidden" value="<%=session.getAttribute("an")%>" name="operator"/>
			<table class="tb">
				<tr>
					<td>用户</td>
					<td><input type="text" class="input1" value="${bespokeByid.b_username}" name="user"/></td>
				</tr>
				<tr>
					<td>联系方式</td>
					<td><input type="text" class="input1" value="${bespokeByid.b_tel}" name="tel"/></td>
				</tr>
				<tr>
					<td>宠物类型</td>
					<td>
					   <select id="type" name="pettype" class="select" onchange="change()">
							<option <c:if test="${bespokeByid.b_type=='选择宠物类型--'}">selected</c:if> >选择宠物类型--</option>
							<option <c:if test="${bespokeByid.b_type=='宠物狗'}">selected</c:if> >宠物狗</option>
							<option <c:if test="${bespokeByid.b_type=='宠物猫'}">selected</c:if> >宠物猫</option>
							<option <c:if test="${bespokeByid.b_type=='其他宠物'}">selected</c:if> >其他宠物</option>
						</select> 
						<select class="pet">
								<option>选择宠物--</option>
						</select> 
						<select class="pet" id="pet1" name="">
								<option <c:if test="${bespokeByid.b_pet=='金毛犬'}">selected</c:if> >金毛犬</option>
								<option <c:if test="${bespokeByid.b_pet=='贵宾犬'}">selected</c:if> >贵宾犬</option>
								<option <c:if test="${bespokeByid.b_pet=='哈士奇'}">selected</c:if> >哈士奇</option>
								<option <c:if test="${bespokeByid.b_pet=='泰迪'}">selected</c:if> >泰迪</option>
								<option <c:if test="${bespokeByid.b_pet=='博美犬'}">selected</c:if> >博美犬</option>
						</select> 
						<select class="pet" id="pet2" name="">
								<option <c:if test="${bespokeByid.b_pet=='布偶猫'}">selected</c:if> >布偶猫</option>
								<option <c:if test="${bespokeByid.b_pet=='异国短毛猫'}">selected</c:if> >异国短毛猫</option>
								<option <c:if test="${bespokeByid.b_pet=='挪威森林猫'}">selected</c:if> >挪威森林猫</option>
								<option <c:if test="${bespokeByid.b_pet=='波斯猫'}">selected</c:if> >波斯猫</option>
								<option <c:if test="${bespokeByid.b_pet=='暹罗猫'}">selected</c:if> >暹罗猫</option>
						</select> 
						<select class="pet" id="pet3" name="">
								<option <c:if test="${bespokeByid.b_pet=='磨光兔'}">selected</c:if> >磨光兔</option>
								<option <c:if test="${bespokeByid.b_pet=='仓鼠'}">selected</c:if> >仓鼠</option>
								<option <c:if test="${bespokeByid.b_pet=='豚鼠'}">selected</c:if> >豚鼠</option>
								<option <c:if test="${bespokeByid.b_pet=='大耳白兔'}">selected</c:if> >大耳白兔</option>
								<option <c:if test="${bespokeByid.b_pet=='龙猫'}">selected</c:if> >龙猫</option>
						</select>
					</td>
				</tr>
				<tr>
					<td>寄存套餐</td>
					<td>
					   <select class="input1" name="combo" id="combo" onchange="taocan()" >
							<option>选择套餐--</option>
							<option>套餐一</option>
							<option>套餐二</option>
							<option>套餐三</option>
					   </select>
					</td>
					<td>
					<input type="hidden" name="price1" id="price1"/>
					<label id="labelprice1" class="input1" style="color: red" ></label><span>元/天</span>
					</td>
				</tr>
				<tr>
					<td>其他服务</td>
					<td>
					   <select class="input1" name="other" id="other" onchange="qita()">
							<option>选择服务--</option>
							<option>洗澡</option>
							<option>剪毛</option>
							<option>洗澡+剪毛</option>
							<option>无</option>
					   </select>
					</td>
					<td>
					<input type="hidden" name="price2" id="price2"/>
					<label id="labelprice2" class="input1" style="color: red" ></label><span>元/次</span>
					</td>
				</tr>
				<tr>
					<td>备注</td>
					<td><input type="text" class="input1" name="notes"/></td>
				</tr>
				<tr>
					<td>寄存时间</td>
					<td><input type="text" class="input1" value="<%=sdf.format(new Date())%>" name="time" readonly="readonly"/></td>
				</tr>
			</table>
			<div class="img-div">
				<img alt="照片" src="" id="" class="img2">
				<input type="file"  name="uploadFile" class="file-input" onchange="uplode(this)"/>
				<div class="upload">
					<a href="javascript:;" class="a-img">选择照片</a>
					<input type="text"  id="filename1" class="text-input"/>
				</div>
			</div>
			<input type="submit" class="input2" value="提交修改"/>
		</form>
	</div>
  </body>
</html>
