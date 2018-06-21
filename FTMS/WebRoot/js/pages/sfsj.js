$.extend($.messager.defaults, {
	ok : "确定",
	cancel : "取消"
});
$(document).ready(
		function() {
			var province = $('#province').text();
			$.post("provinceshow.action?province=" + province, function(data) {
				$('#provinceselect').combobox({
					data : data
				})
			});

			$('#provinceselect').combobox(
					{
						onChange : function(newValue, oldValue) {
							var str = $('#provinceselect').combobox('getText');
							$.ajax({
								type : "post",
								async : false, // 同步执行
								url : "citysfsjJson.action?province=" + str,
								dataType : "json", // 返回数据形式为json
								success : function(result) {
									// 将返回的category和series对象赋值给options对象内的category和series
									// 因为xAxis是一个数组 这里需要是xAxis[i]的形式
									draw(result[0], result[1], "不同城市报考人员数量",
											"报考城市");
								}
							});
							$.post(
									"citysjsearch.action?provinceid="
											+ $('#provinceselect').combobox(
													'getValue'),
									function(data) {
										$('#city').combobox({
											data : data
										})
									});
							$('#city').combobox("select", "不限");
							$.post("sfInfo.action", {
								province : str
							}, function(data) {
								$('#tj_year').text(data[0].year),
										$('#tj_month').text(data[0].month), $(
												'#tj_day').text(data[0].day),
										$('#tj_province').text(str), $(
												'#tj_number').text(
												data[0].total), $('#tj_city')
												.text(data[0].citysum), $(
												'#tj_county').text(
												data[0].countysum)
							});
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
function chengshi() {
	var str = $('#provinceselect').combobox('getText');
	$.ajax({
		type : "post",
		async : false, // 同步执行
		url : "citysfsjJson.action?province=" + str,
		dataType : "json", // 返回数据形式为json
		success : function(result) {
			// 将返回的category和series对象赋值给options对象内的category和series
			// 因为xAxis是一个数组 这里需要是xAxis[i]的形式
			draw(result[0], result[1], "不同城市报考人员数量", "报考城市");
		}
	});
}
function zhuanye() {
	var str = $('#provinceselect').combobox('getText');
	$.ajax({
		type : "post",
		async : false, // 同步执行
		url : "profsfsjJson.action?province=" + str,
		dataType : "json", // 返回数据形式为json
		success : function(result) {
			// 将返回的category和series对象赋值给options对象内的category和series
			// 因为xAxis是一个数组 这里需要是xAxis[i]的形式
			draw(result[0], result[1], "不同专业参加报考人员数量", "报考专业");
		}
	});
}
function xingbie() {
	var str = $('#provinceselect').combobox('getText');
	$.ajax({
		type : "post",
		async : false, // 同步执行
		url : "gendersfsjJson.action?province=" + str,
		dataType : "json", // 返回数据形式为json
		success : function(result) {
			// 将返回的category和series对象赋值给options对象内的category和series
			// 因为xAxis是一个数组 这里需要是xAxis[i]的形式
			draw(result[0], result[1], "不同性別参加报考人员数量", "报考性別");
		}
	});
}
function nianling() {
	var str = $('#provinceselect').combobox('getText');
	$.ajax({
		type : "post",
		async : false, // 同步执行
		url : "agesfsjJson.action?province=" + str,
		dataType : "json", // 返回数据形式为json
		success : function(result) {
			// 将返回的category和series对象赋值给options对象内的category和series
			// 因为xAxis是一个数组 这里需要是xAxis[i]的形式
			draw(result[0], [ '20以下', '20-30', '30-40', '40-50', '50-60',
					'60以上' ], "不同年龄参加报考人员数量", "报考年龄");
		}
	});
}
function jibie() {
	var str = $('#provinceselect').combobox('getText');
	$.ajax({
		type : "post",
		async : false, // 同步执行
		url : "levelsfsjJson.action?province=" + str,
		dataType : "json", // 返回数据形式为json
		success : function(result) {
			// 将返回的category和series对象赋值给options对象内的category和series
			// 因为xAxis是一个数组 这里需要是xAxis[i]的形式
			draw(result[0], result[1], "不同级别参加报考人员数量", "报考级别");
		}
	});
}
function xueli() {
	var str = $('#provinceselect').combobox('getText');
	$.ajax({
		type : "post",
		async : false, // 同步执行
		url : "educationsfsjJson.action?province=" + str,
		dataType : "json", // 返回数据形式为json
		success : function(result) {
			// 将返回的category和series对象赋值给options对象内的category和series
			// 因为xAxis是一个数组 这里需要是xAxis[i]的形式
			draw(result[0], result[1], "不同学历参加报考人员数量", "报考级别");
		}
	});
}
function fazheng() {
	var str = $('#provinceselect').combobox('getText');
	$.ajax({
		type : "post",
		async : false, // 同步执行
		url : "fazhengsfsjJson.action?province=" + str,
		dataType : "json", // 返回数据形式为json
		success : function(result) {
			// 将返回的category和series对象赋值给options对象内的category和series
			// 因为xAxis是一个数组 这里需要是xAxis[i]的形式
			draw(result[0], result[1], "不同年份录取人员数量", "录取年份");
		}
	});
}
function Search() {
	$.post("sfsearchAll.action", {
		"city" : $('#city').combobox('getText'),
		"prof1" : $('#prof1').combobox('getText'),
		"prof2" : $('#prof2').combobox('getText'),
		"gender" : $('#gender').combobox('getText'),
		"age" : $('#age').combobox('getText'),
		"level" : $('#level').combobox('getText'),
		"education" : $('#education').combobox('getText'),
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
}// JavaScript Document
