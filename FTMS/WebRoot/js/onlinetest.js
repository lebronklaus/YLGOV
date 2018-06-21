$.extend($.messager.defaults,{
	ok:"确定",
	cancel:"取消"
});
//组卷
function zujuan() {
	var class1 = $('#level1').combobox('getValue');
	var profession = $('#profession1').combobox('getValue');
	var difficulty = $('#difficulty').combobox('getValue');
	var url = "zujuan.action?class1=" + class1 + "&profession=" + profession
			+ "&difficulty=" + difficulty;
	$('#zujuan').attr('href', url);
}
// 判题
function panti() {
	var name = (event || window.event).srcElement.name;
	var shitiid = name.toString().substr(1);
	var useranswer = $("input[name=" + name + "]:checked").attr("value");
	var useranswercontent = $("input[name=" + name + "]:checked").next("span")
			.text();
	var sjbh = $('#sjbh').text();
	$.post("panti.action", {
		sjbh : sjbh,
		shitiid : shitiid,
		useranswer : useranswer,
		useranswercontent : useranswercontent
	});
}
// 正常交卷，提示未作答题目及交卷确认
function jiaojuan() {
	$.post("miss.action", {
		sjbh : $('#sjbh').text()
	}, function(data, status) {
		if (data.toString() != "") {
			$.messager.confirm('交卷确认', '您还有第' + data + '题未作答，确定要交卷吗？',
					function(r) {
						if (r) {
							clearInterval(interveal);
							var sjbh = $('#sjbh').text();
							var class1 = $('#class1').text();
							var profession = $('#profession').text();
							var difficulty = $('#difficulty').text();
							var url = "panjuan.action?class1=" + class1
									+ "&profession=" + profession
									+ "&difficulty=" + difficulty + "&sjbh="
									+ sjbh;
							window.open(url, '_blank')
							$('#jiaojuan1').linkbutton('disable');
							$('#jiaojuan2').linkbutton('disable');
						}
					});
		} else {
			$.messager.confirm('交卷确认', '您确定要交卷吗？', function(r) {
				if (r) {
					clearInterval(interveal);
					var sjbh = $('#sjbh').text();
					var class1 = $('#class1').text();
					var profession = $('#profession').text();
					var difficulty = $('#difficulty').text();
					var url = "panjuan.action?class1=" + class1 + "&profession="
							+ profession + "&difficulty=" + difficulty
							+ "&sjbh=" + sjbh;
					window.open(url, '_blank')
					$('#jiaojuan1').linkbutton('disable');
					$('#jiaojuan2').linkbutton('disable');
				}
			});
		}
	});
}
// 时间结束交卷
function mustjiaojuan() {
	var sjbh = $('#sjbh').text();
	var class1 = $('#class1').text();
	var profession = $('#profession').text();
	var difficulty = $('#difficulty').text();
	var url = "panjuan.action?class1=" + class1 + "&profession=" + profession
			+ "&difficulty=" + difficulty + "&sjbh=" + sjbh;
	window.open(url, '_blank')
	$('#jiaojuan1').linkbutton('disable');
	$('#jiaojuan2').linkbutton('disable');
}
// 阻止刷新
function checkLeave() {
	event.returnValue = "页面重新加载或离开后将重新生成试卷！";
}
function checkAnswer() {
	event.returnValue = "页面重新加载或离开后无法查看答案！";
}
function unloadquestion() {
	var sjbh = $('#sjbh').text();
	$.post("unload.action", {
		sjbh : sjbh,
	});
}
// 倒计时
var min;
var sec;
$(document).ready(function() {
	min = $('#time').text();
	sec = 0;
	$('#min').text(min);
	$('#sec').text(sec);
});

var show = 0;
function time() {
	if (show == 0 && min == 10 && sec == 0) {
		$.messager.show({
			title : '提示',
			msg : '距离答题结束还有10分钟时间，请把握好时间，及时交卷。',
			timeout : 4000,
			showType : 'show',
		});
		show = 1;
	}
	if (min == 9 && sec == 0) {
		clearInterval(interveal);
		$('#min').text('0');
		$('#sec').text('0');
		$('#win').window(
				{
					top : (document.body.offsetHeight - 240) / 2
							+ document.body.scrollTop
							- document.body.offsetHeight / 4,
					left : (document.body.offsetWidth - 320) / 2
							+ document.body.scrollLeft
				});
		$('#win').window('open');
	} else {
		if (sec == 0) {
			min--;
			sec = 60;
		}
		sec--;
		$('#min').text(min);
		$('#sec').text(sec);
	}
}
var interveal = setInterval("time()", 1000);
// 题库查询
function submitSearch() {
	var profession = $('#profession').combobox('getValue');
	var questionType = $('#questionType').combobox('getValue');
	var difficulty = $('#difficulty').combobox('getValue');
	var question = $('#question').textbox("getValue");
	var url = "search.action?profession=" + profession + "&questionType="
			+ questionType + "&difficulty=" + difficulty + "&question="
			+ question;
	$("#dg").datagrid({
		url : url
	});
}
// 页面加载时加载题库
$(document).ready(function() {
	$('#dg').datagrid({
		url : "search.action?profession=请选择&questionType=请选择&difficulty=请选择&question="
	});
});
// 保存试卷配置
function saveproperties() {
	$('#config').form('submit', {
		url : 'saveprops.action',
		success : function() {
			$('#w').window('close');
			$.messager.show({
				title : '提示',
				msg : '试卷配置保存成功!',
				timeout : 3000,
				showType : 'show',
			});
		}
	});
}

// 题库增删改
var url;
function addquestion() {
	$('#Q').textbox('clear');
	$('#A').textbox('clear');
	$('#B').textbox('clear');
	$('#C').textbox('clear');
	$('#D').textbox('clear');
	$('#bt_ae').linkbutton({
		"text" : "添加",
		iconCls : 'icon-add'
	});
	$('#w').window({
		"title" : "添加题目",
		iconCls : 'icon-add'
	});
	$('#w').window(
			{
				top : (document.body.offsetHeight - 370) / 2
						+ document.body.scrollTop - document.body.offsetHeight
						/ 4,
				left : (document.body.offsetWidth - 500) / 2
						+ document.body.scrollLeft
			});
	$('#w').window('open');
	url = "addquestion.action";
}
function editquestion() {
	$('#A').textbox('clear');
	$('#B').textbox('clear');
	$('#C').textbox('clear');
	$('#D').textbox('clear');
	var row = $('#dg').datagrid('getSelected');
	if (row) {
		$('#profession1').combobox("select", row.profession);
		$('#difficulty1').combobox("select", row.difficulty);
		$('#questionType1').combobox("select", row.questionType);
		$('#Q').textbox("setValue", row.question);
		var data = [];
		if (row.questionType == "选择题") {
			$('#A').textbox({
				"disabled" : false,
				"required" : true
			});
			$('#B').textbox({
				"disabled" : false,
				"required" : true
			});
			$('#C').textbox({
				"disabled" : false,
				"required" : true
			});
			$('#D').textbox({
				"disabled" : false,
				"required" : true
			});

			$('#A').textbox({
				"value" : row.selectionA,
			});
			$('#B').textbox({
				"value" : row.selectionB,
			});
			$('#C').textbox({
				"value" : row.selectionC,
			});
			$('#D').textbox({
				"value" : row.selectionD,
			});
			data.push({
				"text" : "A",
				"value" : "A",
			});
			data.push({
				"text" : "B",
				"value" : "B"
			});
			data.push({
				"text" : "C",
				"value" : "C"
			});
			data.push({
				"text" : "D",
				"value" : "D"
			});
			$("#answers").combobox("loadData", data);
		} else {
			$('#A').textbox({
				"disabled" : true,
				"required" : false
			});
			$('#B').textbox({
				"disabled" : true,
				"required" : false
			});
			$('#C').textbox({
				"disabled" : true,
				"required" : false
			});
			$('#D').textbox({
				"disabled" : true,
				"required" : false
			});

			data.push({
				"text" : "正确",
				"value" : "T",
				"selected" : true
			});
			data.push({
				"text" : "错误",
				"value" : "F"
			});
			$("#answers").combobox("loadData", data);
		}
		$('#answers').combobox("select", row.answer);
		$('#bt_ae').linkbutton({
			"text" : "修改",
			iconCls : 'icon-edit'
		});
		$('#w').window({
			"title" : "修改题目",
			iconCls : 'icon-edit'
		});
		$('#w').window(
				{
					top : (document.body.offsetHeight - 370) / 2
							+ document.body.scrollTop
							- document.body.offsetHeight / 4,
					left : (document.body.offsetWidth - 500) / 2
							+ document.body.scrollLeft
				});
		$('#w').window('open');
		url = 'editquestion.action?id=' + row.id;
	}
}
function savequestion() {
	$('#curd').form('submit', {
		url : url,
		success : function(result) {
			$('#w').window('close');
			if (url.indexOf("add") != -1) {
				$.messager.show({
					title : '提示',
					msg : '题目添加成功!',
					timeout : 3000,
					showType : 'show',
				});
			} else {
				$('#dg').datagrid('reload');
				$.messager.show({
					title : '提示',
					msg : '题目修改成功!',
					timeout : 3000,
					showType : 'show',
				});
			}

		}
	});
}
function deletequestion() {
	var rows = $('#dg').datagrid('getSelections');
	if (rows.length > 0) {
		$.messager.confirm('删除确认', '您确定要删除这些题目吗?', function(r) {
			if (r) {
				for (var i = 0; i < rows.length; i++) {
					var row = rows[i];
					$.ajax({
						type : 'POST',
						url : 'deletequestion.action',
						async : false,
						data : {
							id : row.id
						},
						dataType : 'json'
					});
				}
				$('#dg').datagrid('reload');
				$.messager.show({
					title : '提示',
					msg : '成功删除' + rows.length + '个题目!',
					timeout : 3000,
					showType : 'show',
				});
			}
		});
	}
}