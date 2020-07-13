<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>营业额查看</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="stylesheet" type="text/css" href="css/totalrevenue.css">
	<script type="text/javascript" src="js/echarts.js"></script>
	<script type="text/javascript" src="js/jquery.js"></script>
	<script type="text/javascript">
		function Mouseover(node){
	    node.style.fontWeight="bold";
	    node.style.fontSize="32px";
	}
		function Mouseout(node){
	    node.style.fontWeight="normal";
	    node.style.fontSize="25px";
}
	</script>

  </head>
  <body>
	<div class="back-div" onmouseout="Mouseout(this)" onmouseover="Mouseover(this)">
	   <a href="mainadmin.jsp" class="a-back">返回</a>
	</div>
	<div class="signout">
		当前管理员：<span><%=session.getAttribute("an")%></span>
		<a href="index.jsp">退出>></a>
	</div>
	<div class="searchdiv">
			<input type="date" class="input1" id="date1"/>至 
			<input type="date" class="input1" id="date2"/>
			<input type="button" class="input2" value="搜索" onclick="onclickBydate()"/>
	</div>
	<div id="bar" class="bar"></div>
     <div class="righttext">
     	宠物狗收入<label id="lable1"></label>元<br>
     	宠物猫收入<label id="lable2"></label>元<br>
     	其他宠物收入<label id="lable3"></label>元<br>
     	总收入<label id="lable0"></label>元<br>
     	预计盈利<label id="lable4">元</label><br>
     	<label class="remind">（受季节、天气、食品等因素影响，盈利收入仅作参考数据）</label>
     </div>
     
    
  </body>
  <script type="text/javascript">
   
        // 基于准备好的dom，初始化echarts实例
        var myChart = echarts.init(document.getElementById('bar'));
        // 指定图表的配置项和数据
          option = {
			color: ['#10C55B'],
			tooltip : {
			trigger: 'axis',
			axisPointer : {            // 坐标轴指示器，坐标轴触发有效
			    type : 'shadow'        // 默认为直线，可选为：'line' | 'shadow'
			}
          },

          grid: {
            left: '3%',
            right: '4%',
            bottom: '3%',
            containLabel: true
        },
            
          legend: {
            data:['收入']
        },

	      xAxis : [
	       {
            type : 'category',
            data : ['宠物狗收入','宠物猫收入','其他收入','总收入'],
            axisTick: {
                alignWithLabel: true
            }
        }
            ],

            yAxis : [
                  {
                    type : 'value'
                }
            ],

            series : [
                {
                    name:'收入',
                    type:'bar',
                    barWidth: '60%',
                    data:(
                    function(){
                       var arr=[];
                        $.ajax({
                        type : "post",
                        async : false, //同步执行
                        url : "QueryTotalRevenueServlet",
                        data : {},
                        dataType : "json", //返回数据形式为json
                        success : function(data) {
                        var jsonObj=eval(data);
				        	 
								for(var i=0;i<jsonObj.length;i++){
								arr.push(jsonObj[i].n1);
								arr.push(jsonObj[i].n2);
								arr.push(jsonObj[i].n3);
								arr.push(jsonObj[i].n0);
								document.getElementById("lable1").innerHTML = jsonObj[i].n1;
								document.getElementById("lable2").innerHTML = jsonObj[i].n2;
								document.getElementById("lable3").innerHTML = jsonObj[i].n3;
								document.getElementById("lable0").innerHTML = jsonObj[i].n0;
								document.getElementById("lable4").innerHTML = jsonObj[i].n0*0.6;
								}
								
							                    
                    },
                    error : function(errorMsg) {
                    alert("系统繁忙！图表请求数据失败啦!");
                        /* alert("不好意思，大爷，图表请求数据失败啦!");
                        myChart.hideLoading(); */
                    }
                   });
                   return arr;
                    }
                    )()
                   
                } 
            ]
        };

        // 使用刚指定的配置项和数据显示图表。
        myChart.setOption(option);
    </script>
    
    <!-- 下面是根据时间查询收入----------- -->
    <script type="text/javascript">
    	function onclickBydate(){
    	//	var arr=[];
			var date1 = $("#date1").val();
			var date2 = $("#date2").val();
			if(date1>date2){
			alert("请输入正确的时间段！例如2018-01-01至2018-01-02");
			}else {
			
		// 基于准备好的dom，初始化echarts实例
        var myChart = echarts.init(document.getElementById('bar'));
        // 指定图表的配置项和数据
          option = {
			color: ['#10C55B'],
			tooltip : {
			trigger: 'axis',
			axisPointer : {            // 坐标轴指示器，坐标轴触发有效
			    type : 'shadow'        // 默认为直线，可选为：'line' | 'shadow'
			}
          },

          grid: {
            left: '3%',
            right: '4%',
            bottom: '3%',
            containLabel: true
        },
            
          legend: {
            data:['收入']
        },

	      xAxis : [
	       {
            type : 'category',
            data : ['宠物狗收入','宠物猫收入','其他收入','总收入'],
            axisTick: {
                alignWithLabel: true
            }
        }
            ],

            yAxis : [
                  {
                    type : 'value'
                }
            ],

            series : [
                {
                    name:'收入',
                    type:'bar',
                    barWidth: '60%',
                    data:(
                    function(){
                       var arr=[];
                        $.ajax({
                        type : "post",
                        async : false, //同步执行
                        url : "QueryTotalRevenueByDateServlet",
                        data : {"date1":date1,"date2":date2},
                        dataType : "json", //返回数据形式为json
                        success : function(data) {
                        var jsonObj=eval(data);
								for(var i=0;i<jsonObj.length;i++){
								arr.push(jsonObj[i].n1);
								arr.push(jsonObj[i].n2);
								arr.push(jsonObj[i].n3);
								arr.push(jsonObj[i].n0);
								document.getElementById("lable1").innerHTML = jsonObj[i].n1;
								document.getElementById("lable2").innerHTML = jsonObj[i].n2;
								document.getElementById("lable3").innerHTML = jsonObj[i].n3;
								document.getElementById("lable0").innerHTML = jsonObj[i].n0;
								document.getElementById("lable4").innerHTML = jsonObj[i].n0*0.6;
								}
								
							                    
                    },
                    error : function(errorMsg) {
                    alert("系统繁忙！图表请求数据失败啦!");
                        /* alert("不好意思，大爷，图表请求数据失败啦!");
                        myChart.hideLoading(); */
                    }
                   });
                   return arr;
                    }
                    )()
                   
                } 
            ]
        };

        // 使用刚指定的配置项和数据显示图表。
        myChart.setOption(option);
    	}
    }
    </script>
</html>
