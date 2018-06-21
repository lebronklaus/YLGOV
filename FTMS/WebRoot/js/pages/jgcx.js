$.extend($.messager.defaults, {
	ok : "确定",
	cancel : "取消"
});
$(document).ready(
		function() {
			$.post("jgcxload_one.action", {
				"level" : "农技员",
				"username" : $('#username').text()
			}, function(data) {
				if (data[0]) {
					var achievement;
					if (data[0].achievement == "无") {
						achievement = "";
					} else {
						achievement = data[0].achievement;
					}

					$('#jgprof2').text(
							data[0].prof1name + "-" + data[0].prof2name), $(
							'#jgachievement').text(achievement), $(
							'#jgwritescore').text(data[0].writescore), $(
							'#jginterviewscore').text(data[0].interviewscore),
							$('#jgtotal').text(data[0].total), $('#jgcanjia')
									.text(data[0].canjia), $('#jgapproval')
									.text(data[0].approval), $('#jgopposition')
									.text(data[0].opposition), $('#jgnumber')
									.text(data[0].number), $('#jglevel2').text(
									"农技员"), $.post("jgcx_sy.action", {
								"level" : "农技员",
								"name" : data[0].name
							}, function(dd) {
								$('#sy_dg').datagrid({
									data : dd
								});
								$('#sy_dg').datagrid('reload');
								var i = 0;
								var k = 0;
								while (dd[i] != null) {
									if (dd[i].status == "是") {
										if (k < dd[i].year) {
											k = dd[i].year;
										}
									}
									i++;
								}
								$('#imageyear').text(k);
								$('#imagemonth').text("1");
							}, "json");

					$('#baobiao').linkbutton('enable');
				} else {
					$.messager.alert('提示', '没有该等级证书...');
					$('#baobiao').linkbutton('disable');
					$('#jgimg').attr("src", ""), $('#jgprof2').text(""), $(
							'#jgachievement').text(""), $('#jgwritescore')
							.text(""), $('#jginterviewscore').text(""), $(
							'#jgtotal').text(""), $('#jgcanjia').text(""), $(
							'#jgapproval').text(""), $('#jgopposition')
							.text(""), $('#jgnumber').text(""), $('#jglevel2')
							.text(""), $('#imageyear').text(""), $(
							'#imagemonth').text(""), $('#sy_dg').datagrid({
						data : null
					});
					$('#sy_dg').datagrid('reload')
				}
			}, "json");
			$('#slevel').combobox(
					{
						onChange : function(newValue, oldValue) {
							$.post("jgcxload_one.action", {
								"level" : newValue,
								"username" : $('#username').text()
							}, function(data) {
								if (data[0]) {
									var achievement;
									if (data[0].achievement == "无") {
										achievement = "";
									} else {
										achievement = data[0].achievement;
									}
									$('#jgprof2').text(
											data[0].prof1name + "-"
													+ data[0].prof2name),
											$('#jgachievement').text(
													achievement), $(
													'#jgwritescore').text(
													data[0].writescore), $(
													'#jginterviewscore').text(
													data[0].interviewscore), $(
													'#jgtotal').text(
													data[0].total), $(
													'#jgcanjia').text(
													data[0].canjia), $(
													'#jgapproval').text(
													data[0].approval), $(
													'#jgopposition').text(
													data[0].opposition), $(
													'#jgnumber').text(
													data[0].number),
											$('#jglevel2').text(newValue),

											$.post("jgcx_sy.action", {
												"level" : newValue,
												"name" : data[0].name
											}, function(dd) {
												$('#sy_dg').datagrid({
													data : dd
												});
												$('#sy_dg').datagrid('reload');
												var i = 0;
												var k = 0;
												while (dd[i] != null) {
													if (dd[i].status == "是") {
														if (k < dd[i].year) {
															k = dd[i].year;
														}
													}
													i++;
												}
												$('#imageyear').text(k);
												$('#imagemonth').text("1");
											}, "json");
									$('#baobiao').linkbutton('enable');
								} else {
									$.messager.alert('提示', '没有该等级证书...');
									$('#baobiao').linkbutton('disable');
									$('#jgprof2').text(""), $('#jgachievement')
											.text(""), $('#jgwritescore').text(
											""), $('#jginterviewscore')
											.text(""), $('#jgtotal').text(""),
											$('#jgcanjia').text(""), $(
													'#jgapproval').text(""), $(
													'#jgopposition').text(""),
											$('#jgnumber').text(""), $(
													'#jglevel2').text(""), $(
													'#sy_dg').datagrid({
												data : null
											});
									$('#sy_dg').datagrid('reload');
								}
							}, "json");

						}
					});
			$('#baobiao').linkbutton('disable');
		});

function report() {
	var url = "report.action?username=" + $('#username').text() + "&level="
			+ $('#slevel').combobox('getValue');
	window.open(url, '_blank');
}// JavaScript Document
