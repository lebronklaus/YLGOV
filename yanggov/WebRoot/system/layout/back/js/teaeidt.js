function uploadUser() {
		var name = $('#teaname').textbox('getValue');
		editor.sync();
		if (name.length < 1) {
			$.messager.alert('提示', '名字不能为空！');
		} else {
				$.post("./teacher/edittea.action", {
					teacher_id : $('#teacher_id').text(),
					teaname : $('#teaname').textbox('getValue'),
					gender : $('#gender').combobox('getValue'),
					workplace : $('#workplace').textbox('getValue'),
					inwork : $('#inwork').combobox('getValue'),
					profession : $('#profession').textbox('getValue'),
					phonenum : $('#phonenum').textbox('getValue'),
					university : $('#university').textbox('getValue'),
					major : $('#major').textbox('getValue'),
					address : $('#address').textbox('getValue'),
					email : $('#email').textbox('getValue'),
					inputNote : $('#inputNote').val(),
					user_picpath : $('#user_picpath').text()
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
			$('#rightFrame',window.parent.document).attr("src","./system/layout/back/tealist.jsp");
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
