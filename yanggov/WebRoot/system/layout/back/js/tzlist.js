$.extend($.messager.defaults,{
	ok:"确定",
	cancel:"取消"
});
	var rowid;
		function formatOper(val, row, index) {
			return '<a href="javascript:void(0)" onclick="showUser(' + index
					+ ')">查看</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="javascript:void(0)" onclick="editTeacher(' + index
					+ ')">修改</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="javascript:void(0)" onclick="dele()">删除</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;';
		}
		
	 
		function showUser(index) {
			$('#dg').datagrid('selectRow', index);
			var row = $('#dg').datagrid('getSelected');
			rowid=row;
			if (row) {
				$('#dlg').dialog('open').dialog('setTitle', '查看');
//				$('#grimg').attr("src","upload/media/image/"+row.teacher_path);
				$('#teacher_name').text(row.title);
				$('#teacher_sex').text(row.date);
				$('#teacher_workplace').html(row.text);	
				
			}
		}
		// 
		function editTeacher(index){
			
			$('#dg').datagrid('selectRow',index);
			var row = $('#dg').datagrid('getSelected');
			rowid = row;
			if(row){
				$('#show',window.parent.document).attr("src","../../yanggov/tzrevise.action?id="+row.id);
			}
		}
       //É¾ï¿½ï¿½ï¿½Ê¦ï¿½ï¿½Ï¢
		function dele() {
			var rows = $('#dg').datagrid('getSelections');
			if (rows.length > 0) {
				$.messager.confirm('批量删除', '选中的信息是否全部删除?', function(r) {
					if (r) {
						for (var i = 0; i < rows.length; i++) {
							var row = rows[i];
							$.ajax({
								type : 'POST',
								url : 'tzdel.action',
								async : false,
								data : {
									id : row.id
								},dataType : 'json',
							});
						}
						 location.reload();
					}
				});
			}
		}
