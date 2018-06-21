function uploadUser() {
		 
		 
		editor.sync();
		if (name.length < 1) {
			$.messager.alert('提示', '标题不能为空！');
		} else {
				$.post("pxedit.action", {
					id : $('#tzid').text(),
					title : $('#title').textbox('getValue'),
					date : $('#date').textbox('getValue'),
					author : $('#author').textbox('getValue'), 
					text: $('#inputNote').val(),
				}, function() {
					$.messager.show({
						title : '提示',
						msg : '信息修改成功！',
						timeout : 1000,
						showType : 'show',
					});
				});
		}
		setTimeout(function(){
			$('#rightFrame',window.parent.document).attr("src","./system/layout/back/bpeixun/pxdelete1.jsp");
		},3000);

	}
function deletepic() {
	return $('#tzid').text();
}
function save(path) {
	$('#user_picpath').text(path);
}
function deleteimg(imgepath) {
	$('#user_picpath').text("");
}
