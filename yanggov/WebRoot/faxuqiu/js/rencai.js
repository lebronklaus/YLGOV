function uploadUser() {
		var name = $('#gangwei').textbox('getValue');
		editor1.sync();
		editor2.sync();
		editor3.sync();
		if (name.length < 1) {
			$.messager.alert('提示', '名字不能为空！');
		} else {
				$.post("rencaixuqiuadd.action", {
					gangwei : $('#gangwei').textbox('getValue'),
					renshu : $('#renshu').textbox('getValue'),
					daogangtime : $('#daogangtime').textbox('getValue'),
					salary : $('#salary').textbox('getValue'),
					discrip : $('#inputNote1').val(),
					sex : $('#sex').combobox('getValue'),
					agerank : $('#agerank').textbox('getValue'),
					xueli : $('#xueli').textbox('getValue'),
					major : $('#major').textbox('getValue'),
					experience : $('#inputNote2').val(),
					shuoming : $('#inputNote3').val(),
					mark :$('#mark').val()
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
