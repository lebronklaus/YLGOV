function queryPsd(){
	var userName=$('#username').textbox('getValue');
	if(userName==""){
		$.messager.alert('错误！','请输入用户名!','error');
	}else{
		$.post("queryPsd.action", {
			username : userName,
		}, function(result) {
			if(result != "false"){
				var b = new Base64();
                var password_base64;
                password_base64 = b.decode(result.toString());
				$.messager.alert('查询结果', '用户密码为： '+password_base64,'info');
				
			}else{
				$.messager.alert('查询结果', '找不到该用户，请检查用户名是否正确！','warning');
				
//				$.messager.show({
//					title : '错误',
//					msg : '没有此用户！',
//					timeout : 3000,
//					showType : 'show',
//				});
			}
			
		});
	}
	
	
}
function resetPsd(){
	var userName=$('#username').textbox('getValue');
	if(userName==""){
		$.messager.alert('错误！','请输入用户名!','error');
	}else{
		$.messager.confirm('重置确认', '你确定要重置该用户的密码为身份证后六位吗?', function(r){
			if (r){
				
				$.post("resetPsd.action", {
					username : userName,
				}, function(result) {
					if(result=="true"){
                        $.messager.alert('提示', '密码重置成功！','info');
					}else{
                        $.messager.alert('提示', '密码重置失败，请检查用户名是否正确！','warning');
					}
					
				});
				
				
			}
		});
	}
	
}
function resetAllPsd(){
	$.messager.confirm('重置确认', '你确定要重置所有用户的密码为身份证后六位吗?', function(r){
		if (r){
            $.messager.confirm('警告！', '你确定要重置所有用户的密码吗?', function(r){
                if (r){
                    onloading();
                    $.post("resetAllPsd.action", {
                    }, function(result) {
                    	removeload();
                        if(result=="true"){
                            $.messager.alert('提示', '密码重置成功！','info');
                        }else{
                            $.messager.alert('提示', '密码重置失败，请检查用户！','info');
                        }

                    });

                }
            });
		}
	});
	
}

function onloading(){
    $("<div class=\"datagrid-mask\"></div>").css({display:"block",width:"100%",height:$(window).height()}).appendTo("body");
    $("<div class=\"datagrid-mask-msg\"></div>").html("重置密码中，请稍候。。。").appendTo("body").css({display:"block",left:($(document.body).outerWidth(true) - 190) / 2,top:($(window).height() - 45) / 2});
}
function removeload(){
    $(".datagrid-mask").remove();
    $(".datagrid-mask-msg").remove();
}