$(function(){
	loadData();
})

function loadData(){
	$.post("./teacher/teab.action",{"page":commoncurpage,"rows":commonrow},function(data){
		createSplitBar(data.total);
		clearTable();
		for(var x=0;x <data.rows.length;x++){
			var teaname = data.rows[x].teacher_name;
			var work = data.rows[x].teacher_workplace;
			addTableRow(teaname,work);
		}
	},"json");
}

function addTableRow(teaname,work){
	var img = $("<img src='/yanggov/images/dian.jpg'></img>");
	var divimg = $("<div class='img'></div>").append(img);
	var aobj = $("<a>"+teaname+"</a>");
	var spanobj = $("<span>"+work+"</span>");
	var diva =$("<div class=\"wen\"></div>").append(aobj);
	diva.append(spanobj);
	var liobj = $("<li></li>");
	liobj.append(divimg);
	liobj.append(diva);
	$("#ul").append(liobj);
}
function clearTable(){
	$("#fenye").empty();
	$("#fenye").append("<ul id=\"ul\" class=\"ula\"></ul>");
}