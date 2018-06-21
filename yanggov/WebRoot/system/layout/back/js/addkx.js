function uploadUser() {
	 
	var now=new Date();
	var years=now.getFullYear();
	var month=now.getMonth()+1;
	var day=now.getDate();
	var sub=document.getElementById("datea");
	sub.value=years+"-"+(month<10?('0' + month):month)+"-"+(day<10?('0'+day):day);
 
	
		 var name = $('#title').textbox('getValue');
	 	    editor.sync();
	 	   if (name.length < 1) {
				$.messager.alert('提示ʾ', '标题不能为空');
			} else {
				$.post("kuaixungb.action", {
					title : $('#title').textbox('getValue'),
					author : $('#author').textbox('getValue'),
					remark : $('#remark').val(),
					text : $('#inputNote').val(),
					date : sub.value,
					 
				}, function() {
					$.messager.show({
						title : '提示',
						msg : '信息发布成功',
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

