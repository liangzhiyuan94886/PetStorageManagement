<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>欢迎登陆</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="stylesheet" type="text/css" href="css/userlogin.css">
	<script type="text/javascript" src="js/userlogin.js"></script>
	<script type="text/javascript" src="js/jquery.js"></script>
	<script type="text/javascript">
	$(function() {
		var i = 0;
		var clone = $('.banner .img li').first().clone();
		$('.banner .img').append(clone);
		var size = $('.banner .img li').size();
		for ( var j = 0; j < size - 1; j++) {
			$('.banner .num').append('<li></li>');
		}
		$('.num li').first().addClass('active');
		$('.btn-left').click(function() {
			i++;
			move();
		});
		$('.btn-right').click(function() {
			i--;
			move();
		});

		function move() {
			if (i == size) {
				$('.banner .img').css('left', 0);
				i = 1;
			}
			if (i == -1) {
				$('.banner .img').css({
					left : -(size - 1) * 520
				});
				i = size - 2;
			}

			$('.img').stop().animate({
				left : -i * 520
			}, 500);
			if (i == size - 1) {
				$('.num li').eq(0).addClass('active').siblings().removeClass(
						'active');
			} else {
				$('.num li').eq(i).addClass('active').siblings().removeClass(
						'active');
			}
		}
		;

		$('.banner .num li').hover(function() {
			var index = $(this).index();
			i = index;
			$('.img').stop().animate({
				left : -i * 520
			}, 500);
			$(this).addClass('active').siblings().removeClass('active');
		});

		var timer = setInterval(function() {
			i++;
			move();
		}, 2000);

		$('.banner').hover(function() {
			clearInterval(timer);
		}, function() {
			timer = setInterval(function() {
				i++;
				move();
			}, 2000);
		});
	});
	</script>
	<style type="text/css">
* {
	margin: 0;
	padding: 0;
}

ul {
	list-style: none;
}

.banner {
	width: 520px;
	height: 280px;
	position: relative;
	top: 90px;
	left: 130px;
	overflow: hidden;
}

.banner .img {
	width: 3000px;
	position: absolute;
	left: 0;
	top: 0;
}

.banner .img li {
	float: left;
}

.num {
	position: absolute;
	left: 0;
	bottom: 20px;
	font-size: 0;
	text-align: center;
	width: 100%;
}

.num li {
	width: 10px;
	height: 10px;
	border-radius: 10px;
	background: #888;
	display: inline-block;
	margin: 0 3px;
}

.num li.active {
	background: #f60;
}

.btn {
	width: 30px;
	height: 50px;
	background: rgba(0, 0, 0, .3);
	color: #fff;
	font-family: "宋体";
	font-size: 40px;
	position: absolute;
	top: 50%;
	cursor: pointer;
	display: none;
}

.banner:hover .btn {
	display: block;
}

.btn-left {
	left: 0;
}

.btn-right {
	right: 0;
}
.h1{
	font-size: 35px;
	color: white;;
	margin-left: 100px;
	margin-top: 50px;
}
</style>

  </head>
  
  <body>
  	<h1 class="h1">欢迎登陆</h1>
  	<div class="banner">
			<ul class="img">
				<li><a href=""><img src="images/login1.jpg" /></a></li>
				<li><a href=""><img src="images/login2.jpg" /></a></li>
				<li><a href=""><img src="images/login3.jpg" /></a></li>
				<li><a href=""><img src="images/login4.jpg" /></a></li>
				<li><a href=""><img src="images/login5.jpg" /></a></li>
			</ul>
			<ul class="num">
			</ul>
			<div class="btn btn-left">&lt;</div>
			<div class="btn btn-right">&gt;</div>
		</div>
  	
  	
  	
     <div id="form_div">
     <form action="UserLoginServlet" method="post">
		<input type="text" placeholder="用户名" id="input-text" name="un" required></input>
		<input type="password" placeholder="密码" id="input-password" name="up" required></input> 
		<input type="submit" value="登 &nbsp;&nbsp;陆" id="input-button" onmouseover="btMouseOver(this)" onmouseout="btMouseOut(this)"></input>
	 </form>
	    <a href="userregist.jsp" id="zc">立即注册></a>
	    <a href="http://lllzy.w3.luyouxia.net/pets/adminlogin.jsp" class="admin-login">我是管理员></a>
     </div>
     
  </body>
</html>
