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
		
		//查看教师信息
		function showUser(index) {
			$('#dg').datagrid('selectRow', index);
			var row = $('#dg').datagrid('getSelected');
			rowid=row;
			if (row) {
				$('#dlg').dialog('open').dialog('setTitle', '查看');
				if(row.teacher_path==""){
					$('#grimg').attr("src","upload/media/zwtp.jpg");
				}else{
					$('#grimg').attr("src","upload/media/image/"+row.teacher_path);
				}
				
				$('#teacher_name').text(row.teacher_name);
				$('#teacher_sex').text(row.teacher_sex);
				$('#teacher_workplace').text(row.teacher_workplace);
				$('#teacher_inwork').text(row.teacher_inwork);
				$('#teacher_professional').text(row.teacher_professional);
				$('#teacher_phonenum').text(row.teacher_phonenum);
				$('#teacher_address').text(row.teacher_address);
				$('#teacher_email').text(row.teacher_email);
				$('#teacher_university').text(row.teacher_university);
				$('#teacher_major').text(row.teacher_major);
				$('#teacher_profile').html(row.teacher_profile);
			}
		}
		
		//修改教师信息
		function editTeacher(index){
			
			$('#dg').datagrid('selectRow',index);
			var row = $('#dg').datagrid('getSelected');
			rowid = row;
			if(row){
				/*$('#rightFrame',window.parent.document).attr("src","./teacher/xxwh.action?tea_id="+row.teacher_id);//原来后台*/
				$('#show',window.parent.document).attr("src","../../yanggov/teacher/xxwh.action?tea_id="+row.teacher_id);//zelu后台
			}
			resizetea();
		}
		function resizetea(){ 
			$("#show",window.parent.document).load(function(){ 
			$(this).height(0); //用于每次刷新时控制IFRAME高度初始化 
			var height = $(this).contents().height() ; 
			$(this).height( height < 950 ? 950 : height ); 
			});
			}
       //删除教师信息
		function dele() {
			var rows = $('#dg').datagrid('getSelections');
			if (rows.length > 0) {
				$.messager.confirm('批量删除', '选中的人员是否全部删除?', function(r) {
					if (r) {
						for (var i = 0; i < rows.length; i++) {
							var row = rows[i];
							$.ajax({
								type : 'POST',
								url : './teacher/teadel.action',
								async : false,
								data : {
									id : row.teacher_id
								},dataType : 'json',
							});
						}
						location.reload();
					}
				});
			}
		}

		
		function Search() {
			var name = $('#name').textbox('getValue');
			if(name.length<1){
				$.messager.alert('提示','请输入姓名');
			}else{
				ggrid(name);
			}
		}
			
		function ggrid(name) { 
	        $('#dg').datagrid({  
	            title : '师资列表',  
	            iconCls : 'icon-ok',  
	            pageSize : 25,//默认选择的分页是每页5行数据  
	            pageList : [  15, 20,25 ],//可以选择的分页集合  
	            queryParams:{searchname:name},
	            nowrap : true,//设置为true，当数据长度超出列宽时将会自动截取  
	            striped : true,//设置为true将交替显示行背景。  
	            collapsible : true,//显示可折叠按钮  
	            toolbar:"#tb",//在添加 增添、删除、修改操作的按钮要用到这个  
	            url:'./teacher/teasearch.action',//url调用Action方法  
	            loadMsg : '数据装载中......',  
	            singleSelect:false,//为true时只能选择单行  
	            fitColumns:true,//允许表格自动缩放，以适应父容器  
	            remoteSort : false,  
	             frozenColumns : [ [ {  
	                field : 'ck',  
	                checkbox : true  
	            } ] ],   
	            pagination : true,//分页  
	            rownumbers : true//行数  
	            
	        });  
	   
	        var p = $('#dg').datagrid('getPager');
			$(p).pagination({
				beforePageText : '第',// 页数文本框前显示的汉字
				afterPageText : '页    共 {pages} 页',
				displayMsg : '当前显示 {from} - {to} 条记录   共 {total} 条记录'
			});
	          
	    }