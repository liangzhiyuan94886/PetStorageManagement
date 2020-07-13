function load(){
			var un = document.all("un").value;
			if(un!=="null"){
				document.all("user").style.display="block";
				document.all("login").style.display="none";
		}
}
function btclick(){
	var un = document.all("un").value;
	if(un=="null"){
		alert("请登陆！");
		window.location.href="userlogin.jsp";
		return;
	}else{
		window.location.href="QueryUserInfoServlet";
}
}
