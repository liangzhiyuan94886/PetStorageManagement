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
/*function tijiao(){
	var name = document.getElementById('name').value;
	var type = document.getElementById('type').value;
	var color = document.getElementById('color').value;
	var weight = document.getElementById('weight').value;
	var age = document.getElementById('age').value;
	var owner = document.getElementById('owner').value;
	if(name !=="null" && type !=="null" && color !=="null" && weight !=="null" && age !=="null" && owner !=="null"){
		document.getElementById("form").submit;
	}else {
		alert("信息未填写完整，是否继续提交？");
	}
}*/