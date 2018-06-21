var commoncurpage=1;
var commonrow=25;
var commonpages;
function createSplitBar(rows){
	console.log("总记录数="+rows);
	calcPageSize(rows);
	clearBar();
	first();
	preBar();
	var seed =2;
	for(var x=commoncurpage;x<=commoncurpage+seed;x++){
		addBar(x);
	}
	nextBar();
	end();
	
}
function first(){
	var liobj = $("<li class=\"paginItem\"></li>");
	var spanobj = $("<span class=\"pagepre\">首页</span>");
	var aobj = $("<a style='cursor:pointer'></a>").append(spanobj);
	aobj.click(function(){
			commoncurpage = 1;
			loadData();
	});
	liobj.append(aobj);
	$("#page").append(liobj);
}
function end(){
	var liobj = $("<li class=\"paginItem\"></li>");
	var spanobj = $("<span class=\"pagepre\">尾页</span>");
	var aobj = $("<a style='cursor:pointer'></a>").append(spanobj);
	aobj.click(function(){;
			commoncurpage = commonpages;
			loadData();
	});
	liobj.append(aobj);
	$("#page").append(liobj);
}
function preBar(){
	var liobj = $("<li class=\"paginItem\"></li>");
	var spanobj = $("<span class=\"pagepre\">上一页</span>");
	var aobj = $("<a style='cursor:pointer'></a>").append(spanobj);
	if(commoncurpage == 1){
		liobj.addClass("disabled");
	}else{
		aobj.click(function(){
			if(commoncurpage >1){
				commoncurpage --;
				loadData();
			}
		});
	}
	liobj.append(aobj);
	$("#page").append(liobj);
}

function nextBar(){
	var liobj = $("<li class=\"paginItem\"></li>");
	var spanobj = $("<span class=\"pagepre\">下一页</span>");
	var aobj = $("<a style='cursor:pointer'></a>").append(spanobj);
	if(commoncurpage == commonpages){
		liobj.addClass("disabled");
	}else{
		aobj.click(function(){
			if(commoncurpage < commonpages){
				commoncurpage ++;
				loadData();
			}
			
		});
	}
	liobj.append(aobj);
	$("#page").append(liobj);
}

function addBar(index){
	var liobj = $("<li class=\"paginItem\"></li>");
	var spanobj = $("<span class=\"pagepre\">"+index+"</span>");
	var aobj = $("<a style='cursor:pointer'></a>").append(spanobj);
	if(commoncurpage == index){
		liobj.addClass("");
	}else{
		aobj.click(function(){
			commoncurpage = index;
			loadData();
		});
	}
	liobj.append(aobj);
	$("#page").append(liobj);
}

function calcPageSize(rows){
	if(rows ==0 ){
		commonpages = 1;
	}else{
		commonpages = parseInt((rows + commonrow -1)/commonrow);
	}
}

function clearBar(){
	$("#split").empty();
	var divall = $("<div class=\"message\">共  &nbsp;"+commonpages+" &nbsp;页记录，当前显示第&nbsp;"+commoncurpage+"&nbsp;页</div>");
	$("#split").append(divall);
	$("#split").append("<ul id=\"page\" class=\"paginList\"></ul>");
	
}