$.extend($.messager.defaults, {
	ok : "确定",
	cancel : "取消"
});
$(document).ready(function() {
	Search();
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
});
function Search() {
	if ($('#name').textbox('getText') == "") {
		$('#name').textbox('setText', "");
	}
	$.post("ksshload.action", {
		"name" : $('#name').textbox('getText'),
		"level" : $('#level').combobox('getValue'),
		"time" : $('#time').combobox('getValue'),
		"address" : $('#address').combobox('getValue'),
		"status" : $('#status').combobox('getValue')
	}, function(data) {
		$('#dg').datagrid({
			loadFilter : pagerFilter
		}).datagrid('loadData', data);
	});
}
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
var rowid;
function formatOper(val, row, index) {
	return '<a href="javascript:void(0)" onclick="editUser(' + index
			+ ')">审核</a>';
}
function editUser(index) {
	$('#dg').datagrid('selectRow', index);
	var row = $('#dg').datagrid('getSelected');
	rowid = row;
	if (row) {
		if(row.picpath="sss"){
			$('#grimg').attr("src", "../images/ManagementSystem/nopic.png");
		}else{
			$('#grimg').attr("src", row.picpath);
		}
		$('#dlg').dialog('open').dialog('setTitle', '审核');
		$('#grname').text(row.name);
		$('#grgender').text(row.gender);
		$('#gryear').text(row.birthday.year + 1900 + "-");
		$('#grmonth').text(row.birthday.month + 1 + "-");
		$('#grday').text(row.birthday.date);
		$('#gridnumber').text(row.idnumber);
		$('#grphone').text(row.phone);
		$('#grprovice').text(row.proviceName);
		$('#grcity').text(row.cityName);
		$('#grcounty').text(row.countyName);
		$('#grtown').text(row.townName);
		$('#greducation').text(row.education);
		$('#grprof1').text(row.prof1name + "-");
		$('#grprof2').text(row.prof2name);
		$('#grlevel').text(row.level);
		$('#grtime').text(row.time);
		$('#graddress').text(row.address);
	}
}

function plsh() {
	var rows = $('#dg').datagrid('getSelections');
	if (rows.length > 0) {
		$.messager.confirm('批量审核', '选中的人员是否全部审核?', function(r) {
			if (r) {
				for (var i = 0; i < rows.length; i++) {
					var row = rows[i];
					$.ajax({
						type : 'POST',
						url : 'plsh.action',
						async : false,
						data : {
							id : row.id
						},
						dataType : 'json',
					});
				}
				Search();
				$.messager.show({
					title : '提示',
					msg : '成功审核' + rows.length + '个人员!',
					timeout : 3000,
					showType : 'show',
				});
			}
		});
	}
}

function grsh() {
	$.messager.confirm('审核', '是否审核选中的人员?', function(r) {
		if (r) {
			$.ajax({
				type : 'POST',
				url : 'grsh.action',
				async : false,
				data : {
					id : rowid.id
				},
				dataType : 'json'
			});
			Search();
			$('#dlg').dialog('close');
			$.messager.show({
				title : '提示',
				msg : '成员：' + rowid.name + '审核成功!',
				timeout : 3000,
				showType : 'show',
			});
		}
	});
}// JavaScript Document