function uploadUser() {
		var name = $('#restitle').textbox('getValue');
		editor.sync();
		if (name.length < 1) {
			$.messager.alert('提示', '名字不能为空！');
		} else {
				$.post("./res/resaddback.action", {
					res_title : $('#restitle').textbox('getValue'),
					res_colum : $('#colum').combobox('getValue'),
					res_author : $('#author').textbox('getValue'),
					res_from : $('#from').textbox('getValue'),
					res_profile : $('#inputNote').val(),
					res_path:$('#res_path').text()
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
	$('#res_path').text("");
}
function save(path) {
	$('#res_path').text(path);
}
function deleteimg(imgepath) {
	$('#res_path').text("");
}


