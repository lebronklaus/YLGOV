// JavaScript Document
$.extend($.fn.datebox.defaults, {
	currentText : "今天",
	closeText : "关闭",
});
$.extend($.fn.calendar.defaults, {
	weeks : [ "日", "一", "二", "三", "四", "五", "六" ],
	months : [ "一月", "二月", "三月", "四月", "五月", "六月", "七月", "八月", "九月", "十月",
			"十一月", "十二月" ]
});
$(document).ready(function() {
	$.post("addressload.action", {
		username : $('#username').text()
	}, function(data) {
		$('#address').textbox('setValue', data);
	});
	$.post("userprovince.action", {
		username : $('#username').text()
	}, function(data) {
		$('#province').combobox({
			data : data
		});
	});
	$.post("usercity.action", {
		username : $('#username').text()
	}, function(data) {
		$('#city').combobox({
			data : data
		});
	});
	$.post("usercounty.action", {
		username : $('#username').text()
	}, function(data) {
		$('#county').combobox({
			data : data
		});
	});
	$.post("usertown.action", {
		username : $('#username').text()
	}, function(data) {
		$('#town').combobox({
			data : data
		});
	});
	$.post("userprof1.action", {
		username : $('#username').text()
	}, function(data) {
		$('#prof1').combobox({
			data : data
		});
	});
	$.post("userprof2.action", {
		username : $('#username').text()
	}, function(data) {
		$('#prof2').combobox({
			data : data
		});
	});
	$('#province').combobox({
		onChange : function(newValue, oldValue) {
			var str = newValue;
			$.post("xxwhcity.action", {
				provinceid : str,
				username : $('#username').text()
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
			$.post("xxwhcounty.action", {
				cityid : str,
				username : $('#username').text()
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
			$.post("xxwhtown.action", {
				countyid : str,
				username : $('#username').text()
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
			$.post("xxwhprof2.action", {
				prof1id : str,
				username : $('#username').text()
			}, function(data) {
				$('#prof2').combobox({
					data : data
				});
			});
		}
	});

	$('#gender').combobox("select", $('#user_sex').text());
	$('#education').combobox("select", $('#user_education').text());
	$('#birthday').datebox('setValue', $('#user_year').text());
});
function uploadUser() {
	
	var username = $('#username').text();
		var password = $('#password').textbox('getValue');
		var name = $('#name').textbox('getValue');
		var birthday = $('#birthday').datebox('getValue');
		var phone = $('#phone').textbox('getValue');
		var gender = $('#gender').combobox('getValue');
		var education = $('#education').combobox('getValue');
		var provinceid = $('#province').combobox('getValue');
		var cityid = $('#city').combobox('getValue');
		var countyid = $('#county').combobox('getValue');
		var townid = $('#town').combobox('getValue');
		var profid = $('#prof2').combobox('getValue');
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
			var b = new Base64();
			var password_base64;
			password_base64 = b.encode(password);
			
			var password_md5;
			     password_md5=hex_md5(hex_md5(username)+hex_md5(password));
			$.post("uploadUser.action", {
				username : $('#username').text(),
				password : password_base64,
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
				phone : $('#phone').textbox('getValue')
			}, function() {
				$.post("uploadAddress.action", {
					username : $('#username').text(),
					addr : $('#address').textbox('getValue')
				}, function() {
					$.messager.show({
						title : '提示',
						msg : '信息保存成功，已重新对密码进行加密！',
						timeout : 3000,
						showType : 'show'
					});
					location.reload();
				})

			})
		}
}
function deletepic(oldpath) {
	$.post("deleteimg.action", {
		"imgpath" : oldpath
	});
}
function save(path) {
	$.post("imgUser.action", {
		"username" : $('#username').text(),
		"picpath" : path
	}, function(data) {
		$.messager.show({
			title : '提示',
			msg : data,
			timeout : 3000,
			showType : 'show'
		});
	});
	
}
function deleteimg(imgepath) {
	$.post("imgUser.action", {
		"username" : $('#username').text(),
		"picpath" : imgepath
	});
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
	

}