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
    
    <title>My JSP 'updatepetinformation.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="stylesheet" type="text/css" href="css/updatepetinformation.css">
	<script type="text/javascript" src="js/updatepetinformation.js"></script>
	<script type="text/javascript" src="js/jquery.js"></script>
	<script type="text/javascript">
		var currentShowCity = 0;
		$(document).ready(function() {
			$("#type").change(function() {
				$("#type option").each(function(i, o) {
					if ($(this).attr("selected")) {
						$(".pet").hide();
						$(".pet").eq(i).show();
						currentShowCity = i;
					}
				});
			});
			$("#type").change();
		});
	</script>


</head>
  
  <body>
    <div class="title">
		<i>修改宠物详细信息</i>
	</div>
	<div class="return">
		Hi，<span><%=session.getAttribute("an")%></span> 
		<a href="adminlogin.jsp">退出>></a>
	</div>
	<div class="column">
	    <a href="mainadmin.jsp" class="back">宠物管理</a>
	    <span>>></span>
	    <a href="petinformation.jsp" class="back">资料查看</a>
	    <span class="span">>>修改信息&nbsp;</span>
	</div>
	<hr><br>
	
	<div>
      <form action="UpdatePetInformationServlet" method="post">
          <input type="hidden" value="${petid.m_id}" name="id"/>
          <table class="table">
              <tr>
                 <td>宠物名字</td>
                 <td><input type="text" class="input1" value="${petid.m_name}" name="petname" /></td>
              </tr>
              <tr>
                 <td>宠物类型</td>
                 <td>
                 <select id="type" name="pettype" class="select" onchange="change()">
							<option <c:if test="${petid.m_type=='选择宠物类型--'}">selected</c:if> >选择宠物种类--</option>
							<option <c:if test="${petid.m_type=='宠物狗'}">selected</c:if> >宠物狗</option>
							<option <c:if test="${petid.m_type=='宠物猫'}">selected</c:if> >宠物猫</option>
							<option <c:if test="${petid.m_type=='其他宠物'}">selected</c:if> >其他宠物</option>
					</select>
					<select class="pet" >
							<option>选择宠物--</option>
					</select> <select class="pet" id="pet1" name="">
							<option <c:if test="${petid.m_pets=='金毛犬'}">selected</c:if> >金毛犬</option>
							<option <c:if test="${petid.m_pets=='贵宾犬'}">selected</c:if> >贵宾犬</option>
							<option <c:if test="${petid.m_pets=='哈士奇'}">selected</c:if> >哈士奇</option>
							<option <c:if test="${petid.m_pets=='泰迪'}">selected</c:if> >泰迪</option>
							<option <c:if test="${petid.m_pets=='博美犬'}">selected</c:if> >博美犬</option>
					</select> <select class="pet" id="pet2" name="">
							<option <c:if test="${petid.m_pets=='布偶猫'}">selected</c:if> >布偶猫</option>
							<option <c:if test="${petid.m_pets=='异国短毛猫'}">selected</c:if> >异国短毛猫</option>
							<option <c:if test="${petid.m_pets=='挪威森林猫'}">selected</c:if> >挪威森林猫</option>
							<option <c:if test="${petid.m_pets=='波斯猫'}">selected</c:if> >波斯猫</option>
							<option <c:if test="${petid.m_pets=='暹罗猫'}">selected</c:if> >暹罗猫</option>
					</select> <select class="pet" id="pet3" name="">
							<option <c:if test="${petid.m_pets=='磨光兔'}">selected</c:if> >磨光兔</option>
							<option <c:if test="${petid.m_pets=='仓鼠'}">selected</c:if> >仓鼠</option>
							<option <c:if test="${petid.m_pets=='豚鼠'}">selected</c:if> >豚鼠</option>
							<option <c:if test="${petid.m_pets=='大耳白兔'}">selected</c:if> >大耳白兔</option>
							<option <c:if test="${petid.m_pets=='龙猫'}">selected</c:if> >龙猫</option>
					</select>
					</td>
              </tr>
              <tr>
                 <td>外表颜色</td>
                 <td><input type="text" value="${petid.m_color}" class="input1" name="petcolor" /></td>
              </tr>
              <tr>
                 <td>体重</td>
                 <td><input type="text" value="${petid.m_weight}" class="input1" name="petweight" /></td>
              </tr>
              <tr>
                 <td>年龄</td>
                 <td><input type="text" value="${petid.m_age}" class="input1" name="petage" /></td>
              </tr>
              <tr>
                 <td>宠物主人</td>
                 <td><input type="text" value="${petid.m_owner}" class="input1" name="petowner" /></td>
              </tr>
          </table>
         
   
   <input type="submit" class="input2" value="提交修改"/>
   </form>
      </div>
  </body>
</html>
