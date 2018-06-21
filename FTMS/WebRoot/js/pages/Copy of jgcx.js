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