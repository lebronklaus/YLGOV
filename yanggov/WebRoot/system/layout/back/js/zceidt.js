function uploadUser() {
		 
		editor.sync();
		if (name.length < 1) {
			$.messager.alert('提示', '名字不能为空！');
		} else {
				$.post("zcedit.action", {
					id : $('#tzid').text(),
					title : $('#title').textbox('getValue'),
					date : $('#date').textbox('getValue'),
					text: $('#inputNote').val(),
					fabujigou: $('#fabujigou').textbox('getValue'),
					wenhao: $('#wenhao').textbox('getValue'),
					suoyinhao: $('#suoyinhao').textbox('getValue'),
					  zhutici:$('#zhutici').textbox('getValue'),
					 //mark:$('#mark').val(),
					  mark:$('#mark').combobox('getValue'),
					gongkaimulu: $('#gongkaimulu').textbox('getValue'),
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
			$('#rightFrame',window.parent.document).attr("src","./system/layout/back/bzhengce/zcdelete1.jsp");
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
