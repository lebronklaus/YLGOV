$.extend($.messager.defaults, {
	ok : "确定",
	cancel : "取消"
});
$.extend($.fn.datebox.defaults, {
	currentText : "今天",
	closeText : "关闭",
});

$.extend($.fn.calendar.defaults, {
	weeks : [ "日", "一", "二", "三", "四", "五", "六" ],
	months : [ "一月", "二月", "三月", "四月", "五月", "六月", "七月", "八月", "九月", "十月",
			"十一月", "十二月" ]
});

var url;
function newUser() {
	$('#dlg').dialog('open').dialog('setTitle', '新建信息');
	$('#fm').form('clear');
}

function saveUser() {
	$.messager.confirm('添加', '是否添加该人员成绩?', function(r) {
		if (r) {
			$.ajax({
				type : 'POST',
				url : 'kspsAdd.action',
				async : false,
				data : {
					"username" : $('#username').textbox('getText'),
					"achievement" : $('#achievement').textbox('getText'),
					"total" : $('#total').textbox('getText'),
					"real" : $('#real').textbox('getText'),
					"approval" : $('#approval').textbox('getText'),
					"opposition" : $('#opposition').textbox('getText'),
					"time1" : $('#checktime').textbox('getText'),
					"level" : $('#level').textbox('getText'),
					"number" : $('#number').textbox('getText'),
					"time2" : $('#fazhengtime').textbox('getText'),
					"writescore" : $('#writescore').textbox('getText'),
					"interviewscore" : $('#interviewscore').textbox('getText'),
					"totalscore" : $('#totalscore').textbox('getText')
				},
				dataType : 'json'
			});
			$('#dlg').dialog('close');
			$.messager.show({
				title : '提示',
				msg : '成员：' + $('#username').textbox('getText') + '添加成功!',
				timeout : 3000,
				showType : 'show',
			});
		}
	});
}
$(document).ready(function() {
	$("#dg").datagrid({
		rownumbers : true,
		fit : true,
		striped : true,
		pagination : true,
		pageSize : 25,// 每页显示的记录条数，默认为10
		pageList : [ 15, 25, 35 ],// 可以设置每页记录条数的列表
	});
	var p = $('#dg').datagrid('getPager');
	$(p).pagination({
		beforePageText : '第',// 页数文本框前显示的汉字
		afterPageText : '页    共 {pages} 页',
		displayMsg : '当前显示 {from} - {to} 条记录   共 {total} 条记录'
	});
	$.post("kspsload.action", function(data) {
		$('#dg').datagrid({
			loadFilter : pagerFilter
		}).datagrid('loadData', data);
	});
});
function pagerFilter(data) {
	if (typeof data.length == 'number' && typeof data.splice == 'function') { // is
		// array
		data = {
			total : data.length,
			rows : data
		}
	}
	var dg = $(this);
	var opts = dg.datagrid('options');
	var pager = dg.datagrid('getPager');
	pager.pagination({
		onSelectPage : function(pageNum, pageSize) {
			opts.pageNumber = pageNum;
			opts.pageSize = pageSize;
			pager.pagination('refresh', {
				pageNumber : pageNum,
				pageSize : pageSize
			});
			dg.datagrid('loadData', data);
		}
	});
	if (!data.originalRows) {
		data.originalRows = (data.rows);
	}
	var start = (opts.pageNumber - 1) * parseInt(opts.pageSize);
	var end = start + parseInt(opts.pageSize);
	data.rows = (data.originalRows.slice(start, end));
	var p = $('#dg').datagrid('getPager');
	$(p).pagination({
		beforePageText : '第',// 页数文本框前显示的汉字
		afterPageText : '页    共 {pages} 页',
		displayMsg : '当前显示 {from} - {to} 条记录   共 {total} 条记录'
	});
	return data;
}
function formatname(value, row, index) {
	return row.user.name;
}// JavaScript Document
