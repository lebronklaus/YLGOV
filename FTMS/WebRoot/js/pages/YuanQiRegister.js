function uploadUser() {
	
		var name = $('#username').textbox('getValue');
		var reg = /^\w+((-\w+)|(\.\w+))*\@[A-Za-z0-9]+((\.|-)[A-Za-z0-9]+)*\.[A-Za-z0-9]+$/;
		var newValue = $('#email').textbox('getValue');
        if (!reg.test(newValue)) {
            $.messager.alert("提示",'请输入正确的邮箱!');
        }else{
			if (name.length < 1) {
				$.messager.alert('提示', '账号不能为空！');
			} else {
				$.post("registerYuanQijudge.action", {
					username : $('#username').textbox('getValue')
				}, function(data) {
					if (data == "ok"){
						var name1 = $('#username').textbox('getValue');
					var password = $('#password').textbox('getValue');
					  var password_md5=hex_md5(hex_md5(name1)+hex_md5(password));
						$.post("registerYuanQiUser.action", {
							username : $('#username').textbox('getValue'),
							password : password_md5,
							email : $('#email').textbox('getValue'),
							remark : $('#remark').combobox('getValue')
						
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
				}
					else {
						$.messager.alert('提示', '该账号已存在！');
					}
				})
			}
        }
	}

	$(document).ready(function() {

		$('#username').textbox({
			onChange : function(newValue, oldValue) {
				if (newValue.length < 1) {
					$('#userinfo').text("账号不能为空！");
				} else {
					$.post("registerYuanQijudge.action", {
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
		
		$('#email').textbox({
			onChange : function(newValue, oldValue) {
		        var reg = /^\w+((-\w+)|(\.\w+))*\@[A-Za-z0-9]+((\.|-)[A-Za-z0-9]+)*\.[A-Za-z0-9]+$/;
	            if (!reg.test(newValue)) {
	                $.messager.alert("提示",'请输入正确的邮箱!');
	               /* $.messager.alert('提示', '账号不能为空！');*/
	            }
			}
		})
	});
	