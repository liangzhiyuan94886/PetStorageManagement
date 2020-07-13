//判断寄存套餐赋值价格
function taocan() {
	var combo = document.getElementById('combo').value;
	if (combo == "套餐一") {
		document.getElementById("price1").value = 50;
		document.getElementById("labelprice1").innerHTML=50;
	} else if (combo == "套餐二") {
		document.getElementById("price1").value = 100;
		document.getElementById("labelprice1").innerHTML=100;
	} else if (combo == "套餐三") {
		document.getElementById("price1").value = 150;
		document.getElementById("labelprice1").innerHTML=150;
	}
}
//判断服务赋值价格
function qita() {
	var other = document.getElementById('other').value;
	if (other == "洗澡") {
		document.getElementById("price2").value = 30;
		document.getElementById("labelprice2").innerHTML=30;
	} else if (other == "剪毛") {
		document.getElementById("price2").value = 40;
		document.getElementById("labelprice2").innerHTML=40;
	} else if (other == "洗澡+剪毛") {
		document.getElementById("price2").value = 60;
		document.getElementById("labelprice2").innerHTML=60;
	} else if (other == "无") {
		document.getElementById("price2").value = 0;
		document.getElementById("labelprice2").innerHTML=0;
	}
}
//判断赋值name
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
