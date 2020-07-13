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