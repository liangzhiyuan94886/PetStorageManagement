function div1OnClick(node){
	node.style.color="#2E79CC";
    node.style.backgroundColor="white";
	document.all("title2").style.backgroundColor = "#2E79CC";
    document.all("title2").style.color = "white";
    document.all("title3").style.backgroundColor = "#2E79CC";
    document.all("title3").style.color = "white";
    document.all("personal").style.display="block";
    document.all("order").style.display="none";
    document.all("modifypassword").style.display="none";
}
function div2OnClick(node){
	node.style.color="#2E79CC";
    node.style.backgroundColor="white";
	document.all("title1").style.backgroundColor = "#2E79CC";
    document.all("title1").style.color = "white";
    document.all("title3").style.backgroundColor = "#2E79CC";
    document.all("title3").style.color = "white";
    document.all("personal").style.display="none";
    document.all("order").style.display="block";
    document.all("modifypassword").style.display="none";
}
function div3OnClick(node){
	node.style.color="#2E79CC";
    node.style.backgroundColor="white";
	document.all("title1").style.backgroundColor = "#2E79CC";
    document.all("title1").style.color = "white";
    document.all("title2").style.backgroundColor = "#2E79CC";
    document.all("title2").style.color = "white";
    document.all("personal").style.display="none";
    document.all("order").style.display="none";
    document.all("modifypassword").style.display="block";
}
function btclick(){
	var up = document.all("nup").value;
	var ucp = document.all("ucp").value;
	if(up!=ucp){
		alert("两次密码不一致");
		return;
	}
}
