function uploadUser() {
		var name = $('#name').textbox('getValue');
		editor.sync();
		if (name.length < 1) {
			$.messager.alert('提示', '名字不能为空！');
		} else {
				$.post("yuanqixuqiuadd.action", {
					name : $('#name').textbox('getValue'),
					fuzeren : $('#fuzeren').textbox('getValue'),
					tel : $('#tel').textbox('getValue'),
					address : $('#address').textbox('getValue'),
					inputNote : $('#inputNote').val(),
					yq_path1 : $('#yq_path1').text(),
					yq_path2 : $('#yq_path2').text(),
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
function deletepic1(oldpath) {
	$('#yq_path1').text("");
}
function save1(path) {
	$('#yq_path1').text(path);
}
function deleteimg1(imgepath) {
	$('#yq_path1').text("");
}

function deletepic2(oldpath) {
	$('#yq_path2').text("");
}
function save2(path) {
	$('#yq_path2').text(path);
}
function deleteimg2(imgepath) {
	$('#yq_path2').text("");
}

