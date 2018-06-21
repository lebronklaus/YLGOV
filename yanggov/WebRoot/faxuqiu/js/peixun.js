function uploadUser() {
		var name = $('#companyname').textbox('getValue');
		editor.sync();
		if (name.length < 1) {
			$.messager.alert('提示', '名字不能为空！');
		} else {
				$.post("peixunxuqiuadd.action", {
					companyname : $('#companyname').textbox('getValue'),
					lianxiren : $('#lianxiren').textbox('getValue'),
					tel : $('#tel').textbox('getValue'),
					chuanzhen : $('#chuanzhen').textbox('getValue'),
					time:$('#time').textbox('getValue'),
					peixunadd : $('#peixunadd').textbox('getValue'),
					guimo : $('#guimo').textbox('getValue'),
					peiheshixiang : $('#peiheshixiang').textbox('getValue'),
					email : $('#email').textbox('getValue'),
					mark :$('#mark').val(),
					inputNote : $('#inputNote').val()
				}, function() {
					$.messager.show({
						title : '提示',
						msg : '信息保存成功！',
						timeout : 1000,
						showType : 'show',
					});
				});
		}
		setTimeout(function(){
			location.reload();
		},3000);

	}
function deletepic(oldpath) {
	$('#user_picpath').text("");
}
function save(path) {
	$('#user_picpath').text(path);
}
function deleteimg(imgepath) {
	$('#user_picpath').text("");
}
