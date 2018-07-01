function uploadUser() {
	var name;
	var password = $('#password').textbox('getValue');
	var b = new Base64();
	var password_base64;
	password_base64 = b.encode(password);

	if($('#password').textbox('getValue')!=$('#password2').textbox('getValue')){
		alert("两次密码不一致！");
	}else{
		if ($('#adminname').text() == "") {
			name = $('#supername').text();
			$.post("superReset.action", {
				supername : name,
				superpassword : password_base64,
			}, function() {
				$.messager.show({
					title : '提示',
					msg : '修改成功！',
					timeout : 3000,
					showType : 'show',
				});
			});
		} else {
			name = $('#adminname').text();
			$.post("adminReset.action", {
				adminname : name,
				adminpassword : password_base64,
			}, function() {
				$.messager.show({
					title : '提示',
					msg : '修改成功！',
					timeout : 3000,
					showType : 'show',
				});
			});
		}
	}
}