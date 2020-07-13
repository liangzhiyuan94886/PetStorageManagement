function searchclick(){
			var adminn = document.all("an").value;
			var date1 = document.all("date1").value;
			var date2 = document.all("date2").value;
			if(adminn=="null"){
				alert("请登陆！");
				window.location.href="adminlogin.jsp";
				return;
			}else if(adminn!="null" && date1>date2){
				alert("请输入正确的时间段！例如2018-01-01至2018-01-02");
			}
			else{
				document.all("form").submit();
		}
}
function trMouseOver(node){
		node.style.backgroundColor="skyblue";
		node.style.color="white";
	
}
function trMouseOut(node){
		node.style.backgroundColor="white";
		node.style.color="black";
	
}
/*判断是否是超管*/
function onload(){
	var admin = document.all("an").value;
	if(admin == "超级管理员"){
		document.all("super").style.display="block";
	}else if(admin != "超级管理员" && admin!="" && admin!="null"){
		document.all("super").style.display="none";
	}else{
		alert("请登录使用宠物寄存管理系统！");
		window.location.href="adminlogin.jsp";
	}
}
