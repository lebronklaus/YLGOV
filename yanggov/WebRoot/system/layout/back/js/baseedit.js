function uploadUser() {
		var name = $('#basename').textbox('getValue');
		editor.sync();
		if (name.length < 1) {
			$.messager.alert('提示', '名字不能为空！');
		} else {
				$.post("./base/editbase.action", {
					basename : $('#basename').textbox('getValue'),
					contact : $('#contact').textbox('getValue'),
					inputNote : $('#inputNote').val(),
					base_path1 : $('#base_path1').text(),
					base_path2 : $('#base_path2').text(),
					baseid : $('#base_id').text()
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
			/*$('#rightFrame',window.parent.document).attr("src","./system/layout/back/baselist.jsp");*/ //original
			$('#show',window.parent.document).attr("src","../../yanggov/system/layout/back/baselist.jsp"); //add to szl
		},3000);

	}
function deletepic1(oldpath) {
	$('#base_path1').text("");
}
function save1(path) {
	$('#base_path1').text(path);
}
function deleteimg1(imgepath) {
	$('#base_path1').text("");
}

function deletepic2(oldpath) {
	$('#base_path2').text("");
}
function save2(path) {
	$('#base_path2').text(path);
}
function deleteimg2(imgepath) {
	$('#base_path2').text("");
}

