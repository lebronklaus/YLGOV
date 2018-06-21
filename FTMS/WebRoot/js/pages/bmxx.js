// JavaScript Document
$.extend($.messager.defaults, {
	ok : "确定",
	cancel : "取消"
});
var url;
var yjtitle;
var zstitle;
var info;
function yj_newUser() {
	$('#yj_dlg').dialog('open').dialog('setTitle', '新建');
	yjtitle = 1;
	$('#yj_fm').form('clear');
}
function yj_editUser() {
	var row = $('#yj_dg').datagrid('getSelected');
	if (row) {
		$('#yj_dlg').dialog('open').dialog('setTitle', '编辑');
		yjtitle = 2;
		$('#yj_fm').form('load', row);
	}
}

function yj_saveUser() {
	if (yjtitle == 1) {
		url = "saveAchievement.action";
		info = "添加成功！";
	} else {
		url = "modifyAchievement.action";
		info = "修改成功！";
	}

	var row = $('#yj_dg').datagrid('getSelected');
	if (row) {
		$.ajax({
			type : 'POST',
			url : 'deleteAchievement.action',
			async : false,
			data : {
				"id" : row.id
			},
			dataType : 'json',
		});
	}
	$.ajax({
		type : 'POST',
		url : url,
		async : false,
		data : {
			"username" : $('#username').text(),
			"achievement.start" : $('#yj_start').textbox('getText'),
			"achievement.end" : $('#yj_end').textbox('getText'),
			"achievement.completion" : $('#yj_completion').textbox('getText'),
			"achievement.winess" : $('#yj_winess').textbox('getText')
		},
		dataType : 'json',
	});
	$('#yj_dg').datagrid('reload');
	$('#yj_dlg').dialog('close');
	$.messager.show({
		title : '提示',
		msg : info,
		timeout : 3000,
		showType : 'show',
	});
}

function yj_destroyUser() {
	var row = $('#yj_dg').datagrid('getSelected');
	if (row) {
		$.messager.confirm('提示', '确定删除该条信息么？', function(r) {
			if (r) {
				$.ajax({
					type : 'POST',
					url : 'deleteAchievement.action',
					async : false,
					data : {
						"id" : row.id
					},
					dataType : 'json',
				});
				$('#yj_dg').datagrid('reload');
				$.messager.show({
					title : '提示',
					msg : '刪除成功!',
					timeout : 3000,
					showType : 'show',
				});
			}
		});
	}
}
function zs_newUser() {
	$('#zs_dlg').dialog('open').dialog('setTitle', '新建');
	zstitle = 1;
	$('#zs_fm').form('clear');
}
function zs_editUser() {
	var row = $('#zs_dg').datagrid('getSelected');
	if (row) {
		$('#zs_dlg').dialog('open').dialog('setTitle', '编辑');
		$('#zs_fm').form('load', row);
		zstitle = 2;
	}
}
function zs_saveUser() {
	if (zstitle == 1) {
		url = "saveCertificate.action";
		info = "添加成功！";
	} else {
		url = "modifyCertificate.action";
		info = "修改成功！";
	}
	var row = $('#zs_dg').datagrid('getSelected');
	if (row) {
		$.ajax({
			type : 'POST',
			url : 'deleteCertificate.action',
			async : false,
			data : {
				"id" : row.id
			},
			dataType : 'json',
		});
	}
	$.ajax({
		type : 'POST',
		url : url,
		async : false,
		data : {
			"username" : $('#username').text(),
			"certificate.time" : $('#zs_time').textbox('getText'),
			"certificate.major" : $('#zs_major').textbox('getText'),
			"certificate.certificatename" : $('#zs_certificatename').textbox(
					'getText'),
		},
		dataType : 'json',
	});
	$('#zs_dlg').dialog('close');
	$('#zs_dg').datagrid('reload');
	$.messager.show({
		title : '提示',
		msg : info,
		timeout : 3000,
		showType : 'show',
	});
}
function zs_destroyUser() {
	var row = $('#zs_dg').datagrid('getSelected');
	if (row) {
		$.messager.confirm('提示', '确定删除该条记录么？', function(r) {
			if (r) {
				$.ajax({
					type : 'POST',
					url : 'deleteCertificate.action',
					async : false,
					data : {
						"id" : row.id
					},
					dataType : 'json',
				});
				$('#zs_dg').datagrid('reload');
				$.messager.show({
					title : '提示',
					msg : '刪除成功!',
					timeout : 3000,
					showType : 'show',
				});
			}
		});
	}
}
$(document).ready(function() {
	$('#yj_dg').datagrid({
		url : "achievement.action?username=" + $('#username').text()
	});
	$('#zs_dg').datagrid({
		url : "certificate.action?username=" + $('#username').text()
	});
});

function bmxxupload() {
	$.ajax({
		type : 'POST',
		url : 'bmxxjudge.action',
		async : false,
		data : {
			level : $('#uplevel').combobox('getValue'),
			username : $('#username').text()
		},
		dataType : 'json',
		success : function(data) {
			if (data == "是") {
				$.messager.alert('提示', '该等级已审核，不能提交。');
			} else {
				$.ajax({
					type : 'POST',
					url : 'saveExam.action',
					async : false,
					data : {
						username : $('#username').text(),
						level : $('#uplevel').combobox('getValue'),
						time : $('#uptime').combobox('getValue'),
						address : $('#upaddress').combobox('getValue')
					},
					dataType : 'json',
				});
				$.messager.show({
					title : '提示',
					msg : '报考成功!',
					timeout : 3000,
					showType : 'show',
				});
			}
		}
	});
}
$.post("bmaddress.action", {
	username : $('#username').text()
});