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

var rowid;
function formatOper(val, row, index) {
	return '<a href="javascript:void(0)" onclick="editUser(' + index
			+ ')">修改</a>';
}
function editUser(index) {
	$('#dg').datagrid('selectRow', index);
	var row = $('#dg').datagrid('getSelected');
	rowid = row;
	$('#address').textbox('setValue', "");
	if (row) {
		$('#dlg').dialog('open').dialog('setTitle', '修改');
		if(row.picpath="sss"){
			$('#grimg').attr("src", "../images/ManagementSystem/nopic.png");
		}else{
			$('#grimg').attr("src", row.picpath);
		}
		$('#grname').textbox('setValue', row.name);
		$('#grgender').combobox("select", row.gender);
		var by = row.birthday.year + 1900;
		var bm = row.birthday.month + 1 + "/";
		var bd = row.birthday.date + "/";
		$('#grbirthday').datebox('setValue', bm + bd + by);
		$('#gridnumber').textbox('setValue', row.idnumber);
		$('#grphone').textbox('setValue', row.phone);
		$('#greducation').combobox("select", row.education);
		$.post("addressManageload.action", {
			username : row.username
		});
		$.post("userprof1.action", {
			username : row.username
		}, function(data) {
			$('#grprof1').combobox({
				data : data
			});
		});
		$.post("userprof2.action", {
			username : row.username
		}, function(data) {
			$('#grprof2').combobox({
				data : data
			});
		});
		$.post("userprovince.action", {
			username : row.username
		}, function(data) {
			$('#grprovince').combobox({
				data : data
			});
		});
		$.post("usercity.action", {
			username : row.username
		}, function(data) {
			$('#grcity').combobox({
				data : data
			});
		});
		$.post("usercounty.action", {
			username : row.username
		}, function(data) {
			$('#grcounty').combobox({
				data : data
			});
		});
		$.post("usertown.action", {
			username : row.username
		}, function(data) {
			$('#grtown').combobox({
				data : data
			});
		});
		$.post("addressload.action", {
			username : $('#username').text()
		}, function(data) {
			$('#address').textbox('setValue', data);
		});
	}
}

$(document).ready(function() {
	$('#grprovince').combobox({
		onChange : function(newValue, oldValue) {
			var str = newValue;
			$.post("xxwhcity.action", {
				provinceid : str,
				username : rowid.username
			}, function(data) {
				$('#grcity').combobox({
					data : data
				});
			});
		}
	});

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
	$('#grcity').combobox({
		onChange : function(newValue, oldValue) {
			var str = newValue;
			$.post("xxwhcounty.action", {
				cityid : str,
				username : rowid.username
			}, function(data) {
				$('#grcounty').combobox({
					data : data
				});
			});
		}
	});
	$('#grcounty').combobox({
		onChange : function(newValue, oldValue) {
			var str = newValue;
			$.post("xxwhtown.action", {
				countyid : str,
				username : rowid.username
			}, function(data) {
				$('#grtown').combobox({
					data : data
				});
			});
		}
	});
	$('#grprof1').combobox({
		onChange : function(newValue, oldValue) {
			var str = newValue;
			$.post("xxwhprof2.action", {
				prof1id : str,
				username : rowid.username
			}, function(data) {
				$('#grprof2').combobox({
					data : data
				});
			});
		}
	});

});
function Search() {
	if ($('#name').textbox('getText') == "") {
		$('#name').textbox('setText', "");
	}
	$.post("userManageload.action", {
		"name" : $('#name').textbox('getText'),
	}, function(data) {
		$('#dg').datagrid({
			loadFilter : pagerFilter
		}).datagrid('loadData', data);
	});

}
function pagerFilter(data) {
	if (typeof data.length == 'number' && typeof data.splice == 'function') { // is array
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

function deleteUser(index) {

	$('#dg').datagrid('selectRow', index);
	var row = $('#dg').datagrid('getSelected');
	$.messager.confirm('删除', '是否删除选中的用户?', function(r) {
		if (r) {
			$.ajax({
				type : 'POST',
				url : 'deleteUser.action',
				async : false,
				data : {
					id : row.id
				},
				dataType : 'json'
			});
			Search();
			$('#dlg').dialog('close');
			$.messager.show({
				title : '提示',
				msg : '成员：' + row.name + '删除成功!',
				timeout : 3000,
				showType : 'show',
			});
		}
	});
}
function updateUser() {
	var username = rowid.username;
	var password = rowid.password;
	var name = $('#grname').textbox('getValue');
	var birthday = $('#grbirthday').datebox('getValue');
	var phone = $('#grphone').textbox('getValue');
	var gender =$('#grgender').combobox('getValue');
	var education = $('#greducation').combobox('getValue');
	var provinceid = $('#grprovince').combobox('getValue');
	var cityid = $('#grcity').combobox('getValue');
	var countyid = $('#grcounty').combobox('getValue');
	var townid = $('#grtown').combobox('getValue');
	var profid = $('#grprof2').combobox('getValue');
	var addr = $('#address').textbox('getValue');
	
	if(provinceid.length!=3||cityid.length!=12||countyid.length!=12||townid.length!=12||profid.length>2){
		$.messager.alert('提示', '填写信息有误！');
		return;
	}
	
	if (username.length < 1 || password.length < 1 || name.length < 1
			|| birthday.length < 1 || phone.length < 1 || gender.length < 1
			|| education.length < 1 || provinceid.length < 1
			|| cityid.length < 1 || countyid.length < 1|| townid.length < 1|| profid.length < 1|| addr.length < 1) {
		$.messager.alert('提示', '请填写完整！');
	} else {
		$.post("uploadUserManage.action", {
			username : rowid.username,
			password : rowid.password,
			name : $('#grname').textbox('getValue'),
			year : $('#grbirthday').datebox('getValue'),
			gender : $('#grgender').combobox('getValue'),
			idnumber : $('#gridnumber').textbox('getValue'),
			education : $('#greducation').combobox('getValue'),
			provinceid : $('#grprovince').combobox('getValue'),
			cityid : $('#grcity').combobox('getValue'),
			countyid : $('#grcounty').combobox('getValue'),
			townid : $('#grtown').combobox('getValue'),
			profid : $('#grprof2').combobox('getValue'),
			phone : $('#grphone').textbox('getValue'),
		}, function() {
			$.post("uploadManageAddress.action", {
				username : rowid.username,
				addr : $('#address').textbox('getValue')
			}, function() {
				$.messager.show({
					title : '提示',
					msg : '信息保存成功！',
					timeout : 3000,
					showType : 'show',
				});
				$('#dlg').dialog('close');
			})
		});
	}
	

}// JavaScript Document