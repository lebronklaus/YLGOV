<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>pages/">

<title>My JSP 'jgcx.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<link rel="stylesheet" type="text/css" href="../css/easyui.css">
<link rel="stylesheet" type="text/css" href="../css/icon.css">
<link rel="stylesheet" type="text/css" href="../css/color.css">
<link rel="stylesheet" type="text/css" href="../css/demo.css">
<link rel="stylesheet" type="text/css" href="../css/cjcx.css">

<script type="text/javascript" src="../js/jquery.min.js"></script>
<script type="text/javascript" src="../js/jquery.easyui.min.js"></script>

<style>
body {
	padding: 0;
	margin: 0;
	height: 100%;
	width: auto
}

html {
	height: 100%;
	width: auto
}

#main {
	width: auto;
	margin: auto;
}

span {
	font-size: 16px;
	font-family: "微软雅黑";
}

tr {
	height: 32px;
}

#imageyear {
	position: relative;
	left: 150px;
	top: 20px;
	font-size: 24px;
	font-weight: bold;
}

#imagemonth {
	position: relative;
	left: 195px;
	top: 20px;
	font-size: 24px;
	font-weight: bold;
}
</style>
<script type="text/javascript">
$.extend($.messager.defaults, {
		ok : "确定",
		cancel : "取消"
	});
	$(document)
			.ready(
					function() {
						$
								.post(
										"jgcxload_one",
										{
											"level" : "农技员",
											"username" : $('#username').text()
										},
										function(data) {
											if (data[0]) {
												var idnumber;
												var achievement;
												if (data[0].user.idnumber.length < 18) {
													idnumber = "";
												} else {
													idnumber = data[0].user.idnumber
												}
												if (data[0].achievement == "无") {
													achievement = "";
												} else {
													achievement = data[0].achievement;
												}

														$('#jgimg')
																.attr(
																		"src",
																		data[0].user.picpath),
														$('#jgname')
																.text(
																		data[0].user.name),
														$('#jggender')
																.text(
																		data[0].user.gender),
														$('#jgyear')
																.text(
																		data[0].user.birthday.year
																				+ 1900
																				+ "-"),
														$('#jgmonth')
																.text(
																		data[0].user.birthday.month + 1),
														$('#jgphone')
																.text(
																		data[0].user.phone),
														$('#jgidnumber').text(
																idnumber),
														$('#jgeducation')
																.text(
																		data[0].user.education),
														$('#jgprof')
																.text(
																		data[0].user.prof2.prof1.name
																				+ "-"
																				+ data[0].user.prof2.name),
														$('#jgprof2')
																.text(
																		data[0].user.prof2.prof1.name
																				+ "-"
																				+ data[0].user.prof2.name),
														$('#jgachievement')
																.text(
																		achievement),
														$('#jgwritescore')
																.text(
																		data[0].canjia),
														$('#jginterviewscore')
																.text(
																		data[0].interviewscore),
														$('#jgtotal').text(
																data[0].total),
														$('#jgcanjia').text(
																data[0].canjia),
														$('#jgapproval')
																.text(
																		data[0].approval),
														$('#jgopposition')
																.text(
																		data[0].opposition),
														$('#jgnumber').text(
																data[0].number),
														$
																.post(
																		"jgcxload_two",
																		{
																			"level" : "农技员",
																			"name" : data[0].user.name
																		},
																		function(
																				row) {
																					$(
																							'#jglevel')
																							.text(
																									row[0].level),
																					$(
																							'#jgtime')
																							.text(
																									row[0].time),
																					$(
																							'#jgaddress')
																							.text(
																									row[0].address),
																					$(
																							'#jglevel2')
																							.text(
																									row[0].level)
																		},
																		"json");
												$
														.post(
																"jgcx_sy",
																{
																	"level" : "农技员",
																	"name" : data[0].user.name
																},
																function(dd) {
																	$('#sy_dg')
																			.datagrid(
																					{
																						data : dd
																					});
																	$('#sy_dg')
																			.datagrid(
																					'reload');
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
																	$(
																			'#imageyear')
																			.text(
																					k);
																	$(
																			'#imagemonth')
																			.text(
																					"1");
																}, "json");

												$
														.post(
																"jgAddress",
																{
																	username : $(
																			'#username')
																			.text()
																},
																function(kk) {
																	$(
																			'#jglocal')
																			.text(
																					data[0].user.JPositionProvice.proviceName
																							+ data[0].user.JPositionCity.cityName
																							+ data[0].user.JPositionCounty.countyName
																							+ data[0].user.JPositionTown.townName
																							+ kk)

																});
												$('#baobiao').linkbutton(
														'enable');
											} else {
												$.messager.alert('提示',
														'该等级无结果...');
												$('#baobiao').linkbutton(
														'disable');
												$('#jgimg').attr("src", ""), $(
														'#jgname').text(), $(
														'#jggender').text(""),
														$('#jgyear').text(""),
														$('#jgmonth').text(""),
														$('#jgphone').text(""),
														$('#jgidnumber').text(
																""), $(
																'#jglocal')
																.text(""), $(
																'#jgeducation')
																.text(""), $(
																'#jgprof')
																.text(""), $(
																'#jgprof2')
																.text(""),
														$('#jgachievement')
																.text(""),
														$('#jgwritescore')
																.text(""),
														$('#jginterviewscore')
																.text(""), $(
																'#jgtotal')
																.text(""), $(
																'#jgcanjia')
																.text(""), $(
																'#jgapproval')
																.text(""),
														$('#jgopposition')
																.text(""), $(
																'#jgnumber')
																.text(""), $(
																'#jglevel')
																.text(""), $(
																'#jgtime')
																.text(""), $(
																'#jgaddress')
																.text(""), $(
																'#jglevel2')
																.text(""), $(
																'#imageyear')
																.text(""), $(
																'#imagemonth')
																.text(""), $(
																'#sy_dg')
																.datagrid({
																	data : null
																});
												$('#sy_dg').datagrid('reload')
											}
										}, "json");
						$('#slevel')
								.combobox(
										{
											onChange : function(newValue,
													oldValue) {
												$
														.post(
																"jgcxload_one",
																{
																	"level" : newValue,
																	"username" : $(
																			'#username')
																			.text()
																},
																function(data) {
																	if (data[0]) {
																		var idnumber;
																		var achievement;
																		if (data[0].user.idnumber.length < 18) {
																			idnumber = ""
																		} else {
																			idnumber = data[0].user.idnumber
																		}
																		if (data[0].achievement == "无") {
																			achievement = "";
																		} else {
																			achievement = data[0].achievement;
																		}
																				$(
																						'#jgimg')
																						.attr(
																								"src",
																								data[0].user.picpath),
																				$(
																						'#jgname')
																						.text(
																								data[0].user.name),
																				$(
																						'#jggender')
																						.text(
																								data[0].user.gender),
																				$(
																						'#jgyear')
																						.text(
																								data[0].user.birthday.year
																										+ 1900
																										+ "-"),
																				$(
																						'#jgmonth')
																						.text(
																								data[0].user.birthday.month + 1),
																				$(
																						'#jgphone')
																						.text(
																								data[0].user.phone),
																				$(
																						'#jgidnumber')
																						.text(
																								idnumber),
																				$(
																						'#jgeducation')
																						.text(
																								data[0].user.education),
																				$(
																						'#jgprof')
																						.text(
																								data[0].user.prof2.prof1.name
																										+ "-"
																										+ data[0].user.prof2.name),
																				$(
																						'#jgprof2')
																						.text(
																								data[0].user.prof2.prof1.name
																										+ "-"
																										+ data[0].user.prof2.name),
																				$(
																						'#jgachievement')
																						.text(
																								achievement),
																				$(
																						'#jgwritescore')
																						.text(
																								data[0].canjia),
																				$(
																						'#jginterviewscore')
																						.text(
																								data[0].interviewscore),
																				$(
																						'#jgtotal')
																						.text(
																								data[0].total),
																				$(
																						'#jgcanjia')
																						.text(
																								data[0].canjia),
																				$(
																						'#jgapproval')
																						.text(
																								data[0].approval),
																				$(
																						'#jgopposition')
																						.text(
																								data[0].opposition),
																				$(
																						'#jgnumber')
																						.text(
																								data[0].number),
																				$
																						.post(
																								"jgcxload_two",
																								{
																									"level" : newValue,
																									"name" : data[0].user.name
																								},
																								function(
																										data) {
																											$(
																													'#jglevel')
																													.text(
																															data[0].level),
																											$(
																													'#jgtime')
																													.text(
																															data[0].time),
																											$(
																													'#jgaddress')
																													.text(
																															data[0].address),
																											$(
																													'#jglevel2')
																													.text(
																															data[0].level)
																								},
																								"json");
																		$
																				.post(
																						"jgcx_sy",
																						{
																							"level" : newValue,
																							"name" : data[0].user.name
																						},
																						function(
																								dd) {
																							$(
																									'#sy_dg')
																									.datagrid(
																											{
																												data : dd
																											});
																							$(
																									'#sy_dg')
																									.datagrid(
																											'reload');
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
																							$(
																									'#imageyear')
																									.text(
																											k);
																							$(
																									'#imagemonth')
																									.text(
																											"1");
																						},
																						"json");
																		$
																				.post(
																						"jgAddress",
																						{
																							username : $(
																									'#username')
																									.text()
																						},
																						function(
																								kk) {
																							$(
																									'#jglocal')
																									.text(
																											data[0].user.JPositionProvice.proviceName
																													+ data[0].user.JPositionCity.cityName
																													+ data[0].user.JPositionCounty.countyName
																													+ data[0].user.JPositionTown.townName
																													+ kk)

																						});
																		$(
																				'#baobiao')
																				.linkbutton(
																						'enable');
																	} else {
																		$.messager
																				.alert(
																						'提示',
																						'该等级无结果...');
																		$(
																				'#baobiao')
																				.linkbutton(
																						'disable');
																				$(
																						'#jgimg')
																						.attr(
																								"src",
																								""),
																				$(
																						'#imageyear')
																						.text(
																								""),
																				$(
																						'#imagemonth')
																						.text(
																								"");
																				$(
																						'#jgname')
																						.text(
																								""),
																				$(
																						'#jggender')
																						.text(
																								""),
																				$(
																						'#jgyear')
																						.text(
																								""),
																				$(
																						'#jgmonth')
																						.text(
																								""),
																				$(
																						'#jgphone')
																						.text(
																								""),
																				$(
																						'#jgidnumber')
																						.text(
																								""),
																				$(
																						'#jglocal')
																						.text(
																								""),
																				$(
																						'#jgeducation')
																						.text(
																								""),
																				$(
																						'#jgprof')
																						.text(
																								""),
																				$(
																						'#jgprof2')
																						.text(
																								""),
																				$(
																						'#jgachievement')
																						.text(
																								""),
																				$(
																						'#jgwritescore')
																						.text(
																								""),
																				$(
																						'#jginterviewscore')
																						.text(
																								""),
																				$(
																						'#jgtotal')
																						.text(
																								""),
																				$(
																						'#jgcanjia')
																						.text(
																								""),
																				$(
																						'#jgapproval')
																						.text(
																								""),
																				$(
																						'#jgopposition')
																						.text(
																								""),
																				$(
																						'#jgnumber')
																						.text(
																								""),
																				$(
																						'#jglevel')
																						.text(
																								""),
																				$(
																						'#jgtime')
																						.text(
																								""),
																				$(
																						'#jgaddress')
																						.text(
																								""),
																				$(
																						'#jglevel2')
																						.text(
																								""),
																				$(
																						'#sy_dg')
																						.datagrid(
																								{
																									data : null
																								});
																		$(
																				'#sy_dg')
																				.datagrid(
																						'reload');
																	}
																}, "json");

											}
										});
						$('#baobiao').linkbutton('disable');
					});

	function report() {
		var url = "report?username=" + $('#username').text() + "&level="
				+ $('#slevel').combobox('getValue');
		window.open(url, '_blank');
	}// JavaScript Document
</script>
</head>

<body>
	<span id="username" style="display:none"><s:property
			value='username' /></span>
	<div id="main" style="width:100%;height:100%">
		<div>
			<span>请选择要查询的等级：</span> <select class="easyui-combobox" id="slevel"
				name="state" style="width:150px;height:30px;" editable="false"
				panelHeight="auto">
				<option value="农技员">农技员</option>
				<option value="农技师">农技师</option>
				<option value="高级农技师">高级农技师</option>
			</select> <a href="javascript:void(0)" id="baobiao" class="easyui-linkbutton"
				iconCls="icon-print" style="width:10%;height:30px;"
				onclick="report()"><span style="font-size:16px">报表</span></a>
		</div>
		<div id="judge" class="easyui-panel" title="评审意见"
			style="width:100%;height:auto;padding:10px;">
			<table style="width:500px;">
				<tr>
					<td width="101"><span>业绩：</span></td>
					<td colspan="3"><span id="jgachievement"></span></td>
				</tr>
				<tr>
					<td><span>笔试成绩：</span></td>
					<td colspan="3"><span id="jgwritescore"></span></td>
				</tr>
				<tr>
					<td><span>面试成绩：</span></td>
					<td colspan="3"><span id="jginterviewscore"></span></td>
				</tr>
				<tr>
					<td><span>总人数：</span></td>
					<td width="89"><span id="jgtotal"></span></td>
					<td width="93"><span>参加人数：</span></td>
					<td width="197"><span id="jgcanjia"></span></td>
				</tr>
				<tr>
					<td><span>赞成票：</span></td>
					<td><span id="jgapproval"></span></td>
					<td><span>反对票：</span></td>
					<td><span id="jgopposition"></span></td>
				</tr>
			</table>
		</div>
		<!-- judge -->
		<div id="guanweihui" class="easyui-panel" title="管委会意见"
			style="width:100%;height:auto;padding:10px;">
			<table style="width:750px;">
				<tr>
					<td width="103" height="30"><span>同意授予：</span></td>
					<td width="100"></td>
					<td width="155"></td>
					<td width="375" rowspan="4"
						style="background-repeat: no-repeat;background-position: center;background-image: url(../images/onlinetest/zhang.png);">
						<span id="imageyear"></span><span id="imagemonth"></span>
					</td>
				</tr>
				<tr>
					<td height="30"></td>
					<td><span>职称名称：</span></td>
					<td><span id="jglevel2"></span></td>
				</tr>
				<tr>
					<td height="30"></td>
					<td><span>专业名称：</span></td>
					<td><span id="jgprof2"></span></td>
				</tr>
				<tr>
					<td></td>
					<td><span>证书编号：</span></td>
					<td><span id="jgnumber"></span></td>
				</tr>
			</table>
		</div>
		<!-- guanweihui -->
		<table id="sy_dg" title="审验" class="easyui-datagrid"
			style="width:100%;height:auto" rownumbers="true" fitColumns="true"
			singleSelect="true" selectOnCheck="true" checkOnSelect="true">
			<thead>
				<tr>
					<th data-options="checkbox:true" field="id"></th>
					<th field="level" width="50">等级</th>
					<th field="year" width="50">审验年份</th>
					<th field="status" width="50">审验状态</th>
				</tr>
			</thead>
		</table>
		<!-- shenyan -->
	</div>
</body>
</html>
