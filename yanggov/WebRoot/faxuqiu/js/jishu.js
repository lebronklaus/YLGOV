function uploadUser() {
		var name = $('#mingcheng').textbox('getValue');
		editor.sync();
		if (name.length < 1) {
			$.messager.alert('提示', '名字不能为空！');
		} else {
				$.post("jishuxuqiuadd.action", {
					mingcheng : $('#mingcheng').textbox('getValue'),
					lingyu : $('#lingyu').combobox('getValue'),
					company : $('#company').textbox('getValue'),
					address : $('#address').textbox('getValue'),
					companytype : $('#companytype').textbox('getValue'),
					hangye : $('#hangye').textbox('getValue'),
					lianxiren : $('#lianxiren').textbox('getValue'),
					tel : $('#tel').textbox('getValue'),
					lianxiadd : $('#lianxiadd').textbox('getValue'),
					youbian : $('#youbian').textbox('getValue'),
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
function updateUser() {
	var name = $('#mingcheng').textbox('getValue');
	editor.sync();
	if (name.length < 1) {
		$.messager.alert('提示', '名字不能为空！');
	} else {
			$.post("jishuedit.action", {
				id:$('#js_id').text(),
				mingcheng : $('#mingcheng').textbox('getValue'),
				lingyu : $('#lingyu').combobox('getValue'),
				company : $('#company').textbox('getValue'),
				address : $('#address').textbox('getValue'),
				companytype : $('#companytype').textbox('getValue'),
				hangye : $('#hangye').textbox('getValue'),
				lianxiren : $('#lianxiren').textbox('getValue'),
				tel : $('#tel').textbox('getValue'),
				lianxiadd : $('#lianxiadd').textbox('getValue'),
				youbian : $('#youbian').textbox('getValue'),
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