<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
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
    
    <title>添加寄存信息</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="stylesheet" type="text/css" href="css/addpetinfo.css">
	<script type="text/javascript" src="js/addpetinfo.js"></script>
	<script type="text/javascript" src="js/jquery.js"></script>
	<script type="text/javascript">
	function uplode(obj) {
	//	var filename=document.all("haha");
	//	console.log(obj.files[0].name);
	//	将名字复制给haha控件
	//	filename.value=obj.files[0].name;
	//	获得图的url
		console.log(obj.files[0].name);
		
		var url = window.URL.createObjectURL(obj.files[0]);
		console.log(url);
		//找到控件
		var filename1 = document.all("filename1");
		//给控件的value赋值
		filename1.value = obj.files[0].name;
		var Img=document.all("img");
		Img.src=url; 
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
	<div id="title">
		<i>宠物添加</i>
	</div>
	<div id="return">
		Hi，<span><%=session.getAttribute("an")%></span> 
		<a href="adminlogin.jsp">退出>></a>
	</div>
	<div id="column">
	    <a href="mainadmin.jsp" id="back">宠物管理</a>
	    <span id="span">>>宠物添加&nbsp;</span>
	</div>
	<hr><br>
	<div>
		<form action="AddPetInfoServlet" method="post" enctype="multipart/form-data">
			<input type="hidden" value="<%=session.getAttribute("an")%>" name="operator"/>
			<table id="tb">
				<tr>
					<td>用户</td>
					<td><input type="text" name="user" class="input1" required /></td>
				</tr>
				<tr>
					<td>联系方式</td>
					<td><input type="text" name="tel" class="input1" required /></td>
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
					<td>寄存套餐</td>
					<td>
					   <select class="input1" name="combo" id="combo" onchange="taocan()">
							<option>选择套餐--</option>
							<option>套餐一</option>
							<option>套餐二</option>
							<option>套餐三</option>
					   </select>
					</td>
					<td>
					<input type="hidden" name="price1" id="price1" />
					<label  id="labelprice1" class="input1" style="color: red" >0</label><span>元/天</span>
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
					<input type="hidden" name="price2" id="price2" />
					<label  id="labelprice2" class="input1" style="color: red" >0</label><span>元/次</span>
					</td>
				</tr>
				<tr>
					<td>备注</td>
					<td><input type="text" name="notes" class="input1"  /></td>
				</tr>
				<tr>
					<td>来店时间</td>
					<td><input type="text" name="time" class="input1" value="<%=sdf.format(new Date())%>" readonly="readonly" /></td>
				</tr>
			</table>
			<div class="img-div">
				<img alt="照片" src="" id="img" class="img2">
				<input type="file"  name="uploadFile" class="file-input" onchange="uplode(this)"/>
				<div class="upload">
					<a href="javascript:;" class="a-img">选择照片</a>
					<input type="text" id="filename1" class="text-input"/>
				</div>
			</div>
			<input type="submit" value="提&nbsp;&nbsp;交" class="input2"/>
		</form>
	</div>
	‍‍
	
	
</body>
</html>
