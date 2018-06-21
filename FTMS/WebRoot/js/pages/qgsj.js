$.extend($.messager.defaults, {
	ok : "确定",
	cancel : "取消"
});
$(document).ready(function() {
	$.ajax({
		type : "post",
		async : false, // 同步执行
		url : "provinceqgsjJson.action",
		dataType : "json", // 返回数据形式为json
		success : function(result) {
			// 将返回的category和series对象赋值给options对象内的category和series
			// 因为xAxis是一个数组 这里需要是xAxis[i]的形式
			draw(result[0], result[1], "不同省份报考人员数量", "报考省份");
		}
	});
	$('#prof1').combobox({
		onChange : function(newValue, oldValue) {
			$.post("prof2search.action", {
				"prof1id" : newValue
			}, function(data) {
				$('#prof2').combobox("loadData", data);
			}, "json");
			$('#prof2').combobox("select", "不限");
		}
	});

	$.post("prof1search.action", function(data) {
		$('#prof1').combobox({
			data : data,
			value : '6'
		})
	});
	$.post("provincesjsearch.action", function(data) {
		$('#province').combobox({
			data : data
		})
	});
	$("#dg").datagrid({
		rownumbers : true,
		fit : true,
		striped : true,
		pagination : true,
		pageSize : 20,// 每页显示的记录条数，默认为10
		pageList : [ 10, 20, 30 ],// 可以设置每页记录条数的列表
	});
	var p = $('#dg').datagrid('getPager');
	$(p).pagination({
		beforePageText : '第',// 页数文本框前显示的汉字
		afterPageText : '页    共 {pages} 页',
		displayMsg : '当前显示 {from} - {to} 条记录   共 {total} 条记录'
	});
});
function draw(data, legend, text1, text2) {

	require.config({
		paths : {
			echarts : '../echarts-2.2.7/build/dist'
		}
	});

	require([ 'echarts', 'echarts/chart/pie', 'echarts/chart/funnel' ],
			function(ec) {
				var myChart = ec.init(document.getElementById('China'));

				var option = {
					title : {
						text : text1,
						subtext : '',
						x : 'center'
					},
					tooltip : {
						trigger : 'item',
						formatter : "{a} <br/>{b} : {c} ({d}%)"
					},
					legend : {
						orient : 'vertical',
						x : 'left',
						data : legend
					},
					toolbox : {
						show : true,
						feature : {
							mark : {
								show : true
							},
							dataView : {
								show : true,
								readOnly : false
							},
							magicType : {
								show : true,
								type : [ 'pie', 'funnel' ],
								option : {
									funnel : {
										x : '25%',
										width : '50%',
										funnelAlign : 'left',
										max : 1548
									}
								}
							},
							restore : {
								show : true
							},
							saveAsImage : {
								show : true
							}
						}

					},
					calculable : true,
					series : [ {
						name : text2,
						type : 'pie',
						radius : '55%',
						center : [ '50%', '60%' ],
						data : data
					} ]

				};
				// 为echarts对象加载数据
				myChart.setOption(option);
			});
}
function shengfen() {
	$.ajax({
		type : "post",
		async : false, // 同步执行
		url : "provinceqgsjJson.action",
		dataType : "json", // 返回数据形式为json
		success : function(result) {
			// 将返回的category和series对象赋值给options对象内的category和series
			// 因为xAxis是一个数组 这里需要是xAxis[i]的形式
			draw(result[0], result[1], "不同省份报考人员数量", "报考省份");
		}
	});
}
function zhuanye() {
	$.ajax({
		type : "post",
		async : false, // 同步执行
		url : "profqgsjJson.action",
		dataType : "json", // 返回数据形式为json
		success : function(result) {
			// 将返回的category和series对象赋值给options对象内的category和series
			// 因为xAxis是一个数组 这里需要是xAxis[i]的形式
			draw(result[0], result[1], "不同专业报考人员数量", "报考专业");
		}
	});
}
function xingbie() {
	$.ajax({
		type : "post",
		async : false, // 同步执行
		url : "genderqgsjJson.action",
		dataType : "json", // 返回数据形式为json
		success : function(result) {
			// 将返回的category和series对象赋值给options对象内的category和series
			// 因为xAxis是一个数组 这里需要是xAxis[i]的形式
			draw(result[0], result[1], "不同性別报考人员数量", "报考性別");
		}
	});
}
function nianling() {
	$.ajax({
		type : "post",
		async : false, // 同步执行
		url : "ageqgsjJson.action",
		dataType : "json", // 返回数据形式为json
		success : function(result) {
			// 将返回的category和series对象赋值给options对象内的category和series
			// 因为xAxis是一个数组 这里需要是xAxis[i]的形式
			draw(result[0], [ '20以下', '20-30', '30-40', '40-50', '50-60',
					'60以上' ], "不同年龄报考人员数量", "报考年龄");
		}
	});
}
function jibie() {
	$.ajax({
		type : "post",
		async : false, // 同步执行
		url : "levelqgsjJson.action",
		dataType : "json", // 返回数据形式为json
		success : function(result) {
			// 将返回的category和series对象赋值给options对象内的category和series
			// 因为xAxis是一个数组 这里需要是xAxis[i]的形式
			draw(result[0], result[1], "不同级别报考人员数量", "报考级别");
		}
	});
}
function xueli() {
	$.ajax({
		type : "post",
		async : false, // 同步执行
		url : "educationqgsjJson.action",
		dataType : "json", // 返回数据形式为json
		success : function(result) {
			// 将返回的category和series对象赋值给options对象内的category和series
			// 因为xAxis是一个数组 这里需要是xAxis[i]的形式
			draw(result[0], result[1], "不同学历报考人员数量", "报考学历");
		}
	});
}
function fazheng() {
	$.ajax({
		type : "post",
		async : false, // 同步执行
		url : "fazhengqgsjJson.action",
		dataType : "json", // 返回数据形式为json
		success : function(result) {
			// 将返回的category和series对象赋值给options对象内的category和series
			// 因为xAxis是一个数组 这里需要是xAxis[i]的形式
			draw(result[0], result[1], "不同年份录取人员数量", "录取年份");
		}
	});
}
function Search() {
	$.post("qgsearchAll.action", {
		"province" : $('#province').combobox('getText'),
		"prof1" : $('#prof1').combobox('getText'),
		"prof2" : $('#prof2').combobox('getText'),
		"gender" : $('#gender').combobox('getValue'),
		"age" : $('#age').combobox('getValue'),
		"level" : $('#level').combobox('getValue'),
		"education" : $('#education').combobox('getValue'),
		"fazheng" : $('#fazheng').combobox('getValue')
	}, function(data) {
		$('#dlg').dialog('open').dialog('setTitle', '结果');
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
function formatusername(value, row, index) {
	return row.username;
}
function formatname(value, row, index) {
	return row.name;
}
function formatgender(value, row, index) {
	return row.gender;
}
function formatbirthday(value, row, index) {
	var year = row.birthday.year + 1900;
	var month = row.birthday.month + 1;
	var day = row.birthday.date;
	return year + "-" + month + "-" + day;
}
function formatpassword(value, row, index) {
	return row.password;
}
function formatphone(value, row, index) {
	return row.phone;
}
function formateducation(value, row, index) {
	return row.education;
}
function formatidnumber(value, row, index) {
	return row.idnumber;
}
function formatprof1(value, row, index) {
	return row.prof1name;
}
function formatprof2(value, row, index) {
	return row.prof2name;
}
function formatprovince(value, row, index) {
	return row.proviceName;
}
function formatcity(value, row, index) {
	return row.cityName;
}
function formatcounty(value, row, index) {
	return row.countyName;
}
function formattown(value, row, index) {
	return row.townName;
}
function formatfazheng(value, row, index) {
	return row.fazhengtime.year + 1900;
}
// JavaScript Document
