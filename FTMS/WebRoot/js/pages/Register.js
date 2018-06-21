//document.write('<script type="text/javascript" src="md5.js"></script>');
function uploadUser() {
		var username = $('#username').textbox('getValue');
		var password = $('#password').textbox('getValue');
		var name = $('#name').textbox('getValue');
		var birthday = $('#birthday').datebox('getValue');
		var gender = $('#gender').combobox('getValue');
		var idnumber=$('#idnumber').textbox('getValue');
		var education = $('#education').combobox('getValue');
		var provinceid = $('#province').combobox('getValue');
		var cityid = $('#city').combobox('getValue');
		var countyid = $('#county').combobox('getValue');
		var townid = $('#town').combobox('getValue');
		var profid = $('#prof2').combobox('getValue');
		var phone = $('#phone').textbox('getValue');
		var addr = $('#address').textbox('getValue');
		var picpath=$('#user_picpath').text();
		if(picpath.length<1){
			picpath="sss";
		}
		if (username.length < 1 || password.length < 1 || name.length < 1|| idnumber.length<1
				|| birthday.length < 1 || phone.length < 1 || gender.length < 1
				|| education.length < 1 || provinceid.length < 1
				|| cityid.length < 1 || countyid.length < 1|| townid.length < 1|| profid.length < 1|| addr.length < 1) {
			$.messager.alert('提示', '信息填写不完整！');
		} else {
			$.post("registerjudge.action", {
				username : $('#username').textbox('getValue')
			}, function(data) {
				if (data == "ok"){
				//农民注册时，对密码进行加密
				var password_md5;
			     password_md5=hex_md5(hex_md5(username)+hex_md5(password));
  				  $.post("registerUser.action", {
						username : $('#username').textbox('getValue'),
						password : password_md5,
						name : $('#name').textbox('getValue'),
						year : $('#birthday').datebox('getValue'),
						gender : $('#gender').combobox('getValue'),
						idnumber : $('#idnumber').textbox('getValue'),
						education : $('#education').combobox('getValue'),
						provinceid : $('#province').combobox('getValue'),
						cityid : $('#city').combobox('getValue'),
						countyid : $('#county').combobox('getValue'),
						townid : $('#town').combobox('getValue'),
						profid : $('#prof2').combobox('getValue'),
						phone : $('#phone').textbox('getValue'),
						picpath : picpath
					}, function() {
						$.post("uploadAddress.action", {
							username : $('#username').textbox('getValue'),
							addr : $('#address').textbox('getValue')
						}, function() {
							window.location.href = 'userlogin.action?username='
									+ $('#username').textbox('getValue')
									+ '&password='
									+ password_md5;
							$.messager.show({
								title : '提示',
								msg : '信息保存成功！',
								timeout : 3000,
								showType : 'show'
							});
						})

					})
					}
				else {
					$.messager.alert('提示', '该账号已存在！');
				}
			})
		}

	}
	$.extend($.fn.datebox.defaults, {
		currentText : "今天",
		closeText : "关闭"
	});
	$.extend($.fn.calendar.defaults, {
		weeks : [ "日", "一", "二", "三", "四", "五", "六" ],
		months : [ "一月", "二月", "三月", "四月", "五月", "六月", "七月", "八月", "九月", "十月",
				"十一月", "十二月" ]
	});
	$(document).ready(function() {

		$.post("re_prof1.action", {}, function(data) {
			$('#prof1').combobox({
				data : data
			});
		});
		$.post("registerprovince.action", {
			username : $('#username').text()
		}, function(data) {
			$('#province').combobox({
				data : data
			});
		});

		$('#province').combobox({
			onChange : function(newValue, oldValue) {
				var str = newValue;
				$.post("registercity.action", {
					provinceid : str
				}, function(data) {
					$('#city').combobox({
						data : data
					});
				});
			}
		});
		$('#city').combobox({
			onChange : function(newValue, oldValue) {
				var str = newValue;
				$.post("registercounty.action", {
					cityid : str
				}, function(data) {
					$('#county').combobox({
						data : data
					});
				});
			}
		});
		$('#county').combobox({
			onChange : function(newValue, oldValue) {
				var str = newValue;
				$.post("registertown.action", {
					countyid : str
				}, function(data) {
					$('#town').combobox({
						data : data
					});
				});
			}

		});

		$('#prof1').combobox({
			onChange : function(newValue, oldValue) {
				var str = newValue;
				$.post("re_prof2.action", {
					prof1id : str
				}, function(data) {
					$('#prof2').combobox({
						data : data
					});
				});
			}
		});
		$('#username').textbox({
			onChange : function(newValue, oldValue) {
				if (newValue.length < 1) {
					$('#userinfo').text("账号不能为空！");
				} else {
					$.post("registerjudge.action", {
						username : newValue
					}, function(data) {
						if (data == "ok") {
							$('#userinfo').text("账号可以使用！");
						} else {
							$('#userinfo').text("该账号已存在！");
						}

					})
				}
			}
		})
		$('#password').textbox({
			onChange : function(newValue, oldValue) {
				if (newValue.length < 3) {
					$('#passwordinfo').text("长度不够");
				} else {
					$('#passwordinfo').text("符合");
				}
			}
		})
	});
	function deletepic(oldpath) {
		$('#user_picpath').text("");
		$.post("deleteimg.action", {
			"imgpath" : imgepath
		});
	}
	function save(path) {
		$('#user_picpath').text(path);
	}
	function deleteimg(imgepath) {
		$('#user_picpath').text("");
		$.post("deleteimg.action", {
			"imgpath" : imgepath
		}, function(data) {
			$.messager.show({
				title : '提示',
				msg : data,
				timeout : 3000,
				showType : 'show'
			});
		});
	}// JavaScript Document