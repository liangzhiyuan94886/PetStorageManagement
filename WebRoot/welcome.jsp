<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>欢迎页----</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="stylesheet" type="text/css" href="css/welcome.css">
	<script type="text/javascript" src="js/welcome.js"></script>
	<link rel="stylesheet" href="css/public.css" />
	<link rel="stylesheet" type="text/css" href="css/welcome1.css" />
	<script src="js/jquery.js"></script>
	<script type="text/javascript" src="js/zturn.js"></script>

  </head>
  
  <body onload="load()">
	<div class="bg">
		 <img alt="背景图" src="images/bg_top.jpg" style="width: 100%">
	</div>
	<div class="user" id="user">
		Hi，<%=session.getAttribute("un")%>你好！
	</div>
	<input type="hidden" name="un" value="<%=session.getAttribute("un")%>" />
	<div class="login" id="login">
		<a href="userlogin.jsp" class="a-login">登陆</a>
		<a href="userregist.jsp" class="a-regist">立即注册</a>
	</div>
	<div class="personal">
		<a class="a-homepage">首页&nbsp;</a>
		<a href="QueryShowMessageServlet" class="a-login">&nbsp;留言中心&nbsp;</a> 
		<a class="a1" onclick="btclick()">&nbsp;个人中心</a>
	</div>
	<div class="family">
		<h1>别去笼子，让毛孩子住我家</h1>
		<h2>温馨舒适的环境，开放宽敞的活动空间，温暖充足的阳光；清新流动的空气，干净清洁的饮用水，新鲜可口的食物；<br>有爱抚，有固定的散步时间，还有一起玩耍的小伙伴</h2>
	</div>

	<div class="lb_gl">
		<div class="container">
			<h1 class="turn_3d">别去笼子，让毛孩子住我家</h1>
			   <div class="pictureSlider poster-main">
				  <div class="poster-btn poster-prev-btn"></div>
					<ul id="zturn" class="poster-list">
					  <li class="poster-item  zturn-item">
						<div class="for_btn">
							<img src="images/pet1.jpg" width="100%">
						</div>
						<div class="students_star">
							<p class="cell_list1">
								<img alt="11" src="images/head-icon1.jpg" class="head-icon">
								<img alt="" src="images/family-icon.png" style="padding-left: 20px">
								<span class="darks">有貓客棧</span>
								<span class="rt">
								<span class="jg">¥</span>65<span class="darks">起/天</span>
								</span>
							</p>
							<p class="cell_list2">
								<img alt="" src="images/dingwei-icon.png"> <span
									class="darks">桂林</span>
							</p>
							<div class="zwjs">
								汤圆是来我们家寄养的第一只狗狗，第一次见面汤圆还略显羞涩，到了家里东嗅嗅西嗅嗅，和泰迪lolo不一会儿就玩了起来。
							</div>
						</div>
					 </li>

					<li class="poster-item  zturn-item">
						<div class="for_btn">
							<img src="images/pet2.jpg" width="100%">
						</div>
						<div class="students_star">
							<p class="cell_list1">
								<img alt="11" src="images/head-icon2.jpg" class="head-icon">
								<img alt="" src="images/family-icon.png" style="padding-left: 20px">
								<span class="darks">有狗客栈</span>
								<span class="rt">
								<span class="jg">¥</span>80<span class="darks">起/天</span>
								</span>
							</p>
							<p class="cell_list2">
								<img alt="" src="images/dingwei-icon.png">
								<span class="darks">北京</span>
							</p>
							<div class="zwjs">
								萌萌，麻团两姐妹真的的超级听话，带出去的时候我停下它们也停住了，一直望着我，然后我一说走吧，它们就屁颠屁颠的跟着走了。
							</div>
						</div>
					</li>

					<li class="poster-item  zturn-item">
						<div class="for_btn">
							<img src="images/pet3.jpg" width="100%">
						</div>
						<div class="students_star">
							<p class="cell_list1">
								<img alt="11" src="images/head-icon3.jpg" class="head-icon">
								<img alt="" src="images/family-icon.png" style="padding-left: 20px">
								<span class="darks">拆拆的家</span>
								<span class="rt">
								<span class="jg">¥</span>65<span class="darks">起/天</span>
								</span>
							</p>
							<p class="cell_list2">
								<img alt="" src="images/dingwei-icon.png">
								<span class="darks">南宁</span>
							</p>
							<div class="zwjs">
								我人生第一次做寄养家庭，或许做的不够好，但是我已经是把这些毛孩子当成自己的孩子，我希望他们在我这里能够感受到安心，舒适，惬意~这只黑头柯基叫珍珠，是个小公举，她很亲人。
							</div>
						</div>
					</li>

					<li class="poster-item  zturn-item">
						<div class="for_btn">
							<img src="images/pet4.jpg" width="100%">
						</div>
						<div class="students_star">
							<p class="cell_list1">
								<img alt="11" src="images/head-icon4.jpg" class="head-icon">
								<img alt="" src="images/family-icon.png" style="padding-left: 20px">
								<span class="darks">猫猫咪呀</span>
								<span class="rt">
								<span class="jg">¥</span>65<span class="darks">起/天</span>
								</span>
							</p>
							<p class="cell_list2">
								<img alt="" src="images/dingwei-icon.png"> 
								<span class="darks">广州</span>
							</p>
							<div class="zwjs">
							    珍珠有点挑食，不吃自己的狗粮和零食，但是Sunday的狗粮他倒是爱吃，每次都能把一碗狗粮吃的干干净净~珍珠超级可爱的小婊贝，明明是小公举，还偏要抬腿尿尿，是不是卖萌！！
							</div>
						</div>
					</li>

					<li class="poster-item  zturn-item">
						<div class="for_btn">
							<img src="images/pet5.jpg" width="100%">
						</div>
						<div class="students_star">
							<p class="cell_list1">
								<img alt="11" src="images/head-icon5.jpg" class="head-icon">
								<img alt="" src="images/family-icon.png" style="padding-left: 20px">
								<span class="darks">寒冰有大</span> 
								<span class="rt"> 
								<span class="jg">¥</span>68<span class="darks">起/天</span>
								</span>
							</p>
							<p class="cell_list2">
								<img alt="" src="images/dingwei-icon.png"> 
								<span class="darks">成都</span>
							</p>
							<div class="zwjs">
								胖丁，是一只1岁的男柴柴，非常非常认生、特别特别胆小，遇到生人或其他同类都会极度焦虑。
							</div>
						</div>
					</li>

					<li class="poster-item  zturn-item">
						<div class="for_btn">
							<img src="images/pet6.jpg" width="100%">
						</div>
						<div class="students_star">
							<p class="cell_list1">
								<img alt="11" src="images/head-icon6.jpg" class="head-icon">
								<img alt="" src="images/family-icon.png" style="padding-left: 20px">
								<span class="darks">mocci提莫</span> 
								<span class="rt"> 
								<span class="jg">¥</span>45<span class="darks">起/天</span>
								</span>
							</p>
							<p class="cell_list2">
								<img alt="" src="images/dingwei-icon.png"> 
								<span class="darks">厦门</span>
							</p>
							<div class="zwjs">
								船长和妞妞是一家的～粑粑麻麻一起送过来的，船长是个八个月的边牧，小男生，活泼开朗，充满活力，妞妞很乖巧，很粘人，会用手轻轻的刨你的腿求摸摸。
							</div>
						</div>
					</li>

					<li class="poster-item  zturn-item">
						<div class="for_btn">
							<img src="images/pet7.jpg" width="100%">
						</div>
						<div class="students_star">
							<p class="cell_list1">
								<img alt="11" src="images/head-icon7.jpg" class="head-icon">
								<img alt="" src="images/family-icon.png" style="padding-left: 20px">
								<span class="darks">皮皮虾</span> 
								<span class="rt"> 
								<span class="jg">¥</span>66<span class="darks">起/天</span>
								</span>
							</p>
							<p class="cell_list2">
								<img alt="" src="images/dingwei-icon.png"> 
								<span class="darks">苏州</span>
							</p>
							<div class="zwjs">
								自从本皇登基以来，横行霸道，作威作福，让铲屎官真切地感受到了啥叫伴君如伴虎，喵喵喵（哈哈哈）…?
							</div>
						</div>
					</li>

					<li class="poster-item  zturn-item">
						<div class="for_btn">
							<img src="images/pet8.jpg" width="100%">
						</div>
						<div class="students_star">
							<p class="cell_list1">
								<img alt="11" src="images/head-icon8.jpg" class="head-icon">
								<img alt="" src="images/family-icon.png" style="padding-left: 20px">
								<span class="darks">喵星人</span> 
								<span class="rt"> 
								<span class="jg">¥</span>48<span class="darks">起/天</span>
								</span>
							</p>
							<p class="cell_list2">
								<img alt="" src="images/dingwei-icon.png"> 
								<span class="darks">拉萨</span>
							</p>
							<div class="zwjs">
								每天躺在被窝里睡到大中午，起来第一件事就是对铲屎的行咬刑，手指头，小腿肚，脚丫子，哪里白嫩咬哪里，谁叫这奴才这么木有眼力价，还不给本王上御膳（给你个眼神自己体会）！??
							</div>
						</div>
					</li>

					<li class="poster-item  zturn-item">
						<div class="for_btn">
							<img src="images/pet9.jpg" width="100%">
						</div>
						<div class="students_star">
							<p class="cell_list1">
								<img alt="11" src="images/head-icon9.jpg" class="head-icon">
								<img alt="" src="images/family-icon.png" style="padding-left: 20px">
								<span class="darks">快乐精灵</span> 
								<span class="rt"> 
								<span class="jg">¥</span>88<span class="darks">起/天</span>
								</span>
							</p>
							<p class="cell_list2">
								<img alt="" src="images/dingwei-icon.png"> 
								<span class="darks">杭州</span>
							</p>
							<div class="zwjs">
								烫烫是我的作为寄养家庭的第一个毛孩子。由于工作原因，我自己独居在上海这座城市。撸猫养狗和烹饪是我仅有的爱好。
							</div>
						</div>
					</li>

					<li class="poster-item  zturn-item">
						<div class="for_btn">
							<img src="images/pet10.jpg" width="100%">
						</div>
						<div class="students_star">
							<p class="cell_list1">
								<img alt="11" src="images/head-icon10.jpg" class="head-icon">
								<img alt="" src="images/family-icon.png" style="padding-left: 20px">
								<span class="darks">猫狗托儿所</span> 
								<span class="rt">
								<span class="jg">¥</span>78<span class="darks">起/天</span>
								</span>
							</p>
							<p class="cell_list2">
								<img alt="" src="images/dingwei-icon.png">
								<span class="darks">深圳</span>
							</p>
							<div class="zwjs">
								Cash君妈妈找到我第一句话就是，它有点胆小怕生，也会咬人，大概是从10月份开始做的寄养，听到会咬人还是毫不惧怕相信自己有超能力肯定能克服这一丢丢小困难，也算是一个尝试。
							</div>
						</div>
					</li>

					<li class="poster-item  zturn-item">
						<div class="for_btn">
							<img src="images/pet11.jpg" width="100%">
						</div>
						<div class="students_star">
							<p class="cell_list1">
								<img alt="11" src="images/head-icon11.jpg" class="head-icon">
								<img alt="" src="images/family-icon.png" style="padding-left: 20px">
								<span class="darks">宝莲灯之家</span> 
								<span class="rt"> 
								<span class="jg">¥</span>68<span class="darks">起/天</span>
								</span>
							</p>
							<p class="cell_list2">
								<img alt="" src="images/dingwei-icon.png"> 
								<span class="darks">天津</span>
							</p>
							<div class="zwjs">
								小板凳是过年来入住最早的小可爱，我们板凳是个嗲的不要不要的嗲妹妹勒?嗲到洋洋把晒空调的VIp 躺位都愿意让她?哈哈哈...小可爱，让我们一起开开心心过旺旺年???
							</div>
						</div>
					</li>
				</ul>
			</div>
		</div>
	</div>
	
	<div class="bottom">
	    <img alt="底部" src="images/bg_bottom.jpg" class="img-bottom"></img>
	    <h3>用心确保每一次寄养的安全</h3>
	    <div class="ensure1">
	        <img alt="保障" src="images/baozhang-icon.png" class="icon-bottom"></img>
	        <br><br><br>
	        <h4>10万保障基金</h4>
	        <br>
	        <h5>解决寄养时宠物的安全、健康等问题<br> 线上订单，全程享受保障服务</h5>
	    </div>
	    <div class="ensure2">
	        <img alt="笼养" src="images/longyang-icon.png" class="icon-bottom"></img>
	        <br><br><br>
	        <h4>拒绝笼养</h4>
	        <br>
	        <h5>拥有在家一样自由的空间、干净的水<br> 食物和无限的陪伴</h5>
	    </div>
	    <div class="ensure3">
	        <img alt="资金" src="images/zijin-icon.png" class="icon-bottom"></img>
	        <br><br><br>
	        <h4>担保资金安全</h4>
	        <br>
	        <h5>在线支付寄养费宠物主人寄养满意后<br> 寄养家庭才会收到付款</h5>
	    </div>
	    <div class="ensure4">
	        <img alt="认证" src="images/renzheng-icon.png" class="icon-bottom"></img>
	        <br><br><br>
	        <h4>实名视频认证</h4>
	        <br>
	        <h5>对家庭身份和环境严格认证<br> 平台监管、追踪每一笔线上订单</h5>
	    </div>
	</div>
	<div class="footer">
		<div class="footer-left">
			<ul>
				<li class="li1">联系我们</li>
				<li class="li2">15717736921</li>
				<li class="li1">商务合作</li>
				<li class="li2">lzy2018@163.com</li>
			</ul>
		</div>
		<div class="footer-middle">
			<ul>
				<li class="li3">关注微信</li>
				<li><img alt="微信" src="images/wechat.png"></li>
			</ul>
		</div>
		<div class="footer-right">
			<ul>
				<li class="li3">关注微博</li>
				<li><a target="blank" href="https://weibo.com/p/1005051778863673"><img alt="微博" src="images/weibo.png"></a></li>
			</ul>
		</div>
		<div class="footer-bottom">
			<ul class="ul-bottom">
				<li class="li-bottom">关于我们 &nbsp; |</li>
				<li class="li-bottom">保障服务 &nbsp; |</li>
				<li class="li-bottom">宠物指南 &nbsp; |</li>
				<li class="li-bottom">寄养家庭 &nbsp; |</li>
				<li class="li-bottom">加入我们</li>
			</ul>
			<br>
			<h6>Copyright © 1994-2018</h6>
		</div>
	</div>
</body>
<script type="text/javascript">
	var aa = new zturn({
		id : "zturn",
		opacity : 0.9,
		width : 382,
		Awidth : 1024,
		scale : 0.9,
		auto : true,//是否轮播 默认5000
		turning : 1000
	//轮播时长
	});
	var ab = new zturn({
		id : "zturn2",
		opacity : 0.8,
		width : 382,
		Awidth : 1024,
		scale : 0.6,
		auto : true
	});
</script>
</html>
