<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>peixunshenhe</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<link rel="stylesheet" type="text/css" href="system/layout/back/css/easyui.css">
<link rel="stylesheet" type="text/css" href="system/layout/back/css/color.css">
<link rel="stylesheet" type="text/css" href="system/layout/back/css/demo.css">
<link rel="stylesheet" type="text/css" href="system/layout/back/css/icon.css">
<script type="text/javascript" src="system/layout/back/js/jquery.min.js"></script>
<script type="text/javascript" src="system/layout/back/js/jquery.easyui.min.js"></script>
<script type="text/javascript" src="faxuqiu/shenhe/js/peixun.js"></script>
<style>
body {
	padding: 0;
	margin: 0;
	height: 100%;
	width: auto
}

html {
	height: 100%;
	width: auto
}

#main {
	width: auto;
	margin: auto;
}

span {
	font-size: 14px;
	font-family: "微软雅黑";
}

#fm {
	margin: 0;
	padding: 10px 30px;
}

.ftitle {
	font-size: 14px;
	font-weight: bold;
	padding: 5px 0;
	margin-bottom: 10px;
	border-bottom: 1px solid #ccc;
}

.fitem {
	margin-bottom: 5px;
}

.fitem label {
	font-size: 14px;
	font-weight: bold;
	display: inline-block;
	width: 80px;
    font-family: "微软雅黑";
}

.fitem input {
	width: 160px;
}
p {
	font-size: 14px;
}
pre {
	font-family: "微软雅黑";
	text-indent:2em;
    display: block;
    padding: 9.5px;
    margin: 0 0 10px;
    font-size: 14px;
    line-height: 1.42857143;
    color: #333;
    word-break: break-all;
    background-color: #fff;
    border: 1px solid #ccc;
    border-radius: 4px;
}
</style>
<script type="text/javascript">  
    $(function() {  
        $('#dg').datagrid({  
            title : '培训需求—需求列表',  
            iconCls : 'icon-ok',  
            pageSize : 25,//默认选择的分页是每页5行数据  
            pageList : [  15, 20,25 ],//可以选择的分页集合  
            nowrap : true,//设置为true，当数据长度超出列宽时将会自动截取  
            striped : true,//设置为true将交替显示行背景。  
            collapsible : true,//显示可折叠按钮  
            toolbar:"#tb",//在添加 增添、删除、修改操作的按钮要用到这个  
            url:'peixun.action',//url调用Action方法  
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
          
    });  
    function formatshenhe(value, row, index) {
		if(row.shenhe==0){
			return "未发布";
		}else{
				return "已发布"
			}
	} 
</script>   
<script>	
	// add by xiuao.yan on 06/12/2018
	function tech(){
		$("#show", parent.document).attr("src","../../yanggov/faxuqiu/shenhe/jishushenhe.jsp");

	}
	function master(){
		$("#show", parent.document).attr("src","../../yanggov/faxuqiu/shenhe/rencaishenhe.jsp");

	}
	function train(){

	}	

		 $(document).ready(function(){
		 	train();
		 	$("#type").combobox({
        	onChange: function (n,o) {
            var a=$('#type').combobox('getValue');
           	if(a==0 ){
					train();
				}else if(a==1){
					master();
				}else{
					tech();
				}
        	}
    	})
	})
		 
</script>   
</head>

<body>
	<table id="dg" title="培训列表" class="easyui-datagrid"
		style="width:auto;height:100%" toolbar="#toolbar" rownumbers="true"
		fitColumns="true" singleSelect="false" selectOnCheck="true"
		checkOnSelect="true" pagination="true">
		<thead>
			<tr>
				<th field="companyname" width="50">单位名称</th>
				<th width="50" data-options="field:'shenhe',formatter:formatshenhe">发布状态</th>
				<th width="50" data-options="field:'_operate',formatter:formatOper">操作</th>
			</tr>
		</thead>
	</table>
	<div id="toolbar">
	选择需求分类：<select id="type" class="easyui-combobox" required data-options="missingMessage:'必填'"
							style="width:150px;height:30px;" editable="false"
							panelHeight="auto">
								<option value="0" selected="selected">培训需求列表</option>
								<option value="1">人才需求列表</option>
								<option value="2">技术需求列表</option>
						</select>
		<input class="easyui-textbox" id="name" name="name"
			data-options="prompt:'请输入单位名称'" style="width:15%"> 
		 <a href="javascript:void(0)" class="easyui-linkbutton"
			style="width:5%" onclick="Search()">查询</a> <a
			href="javascript:void(0)" class="easyui-linkbutton"
			iconCls="icon-remove" plain="true" onclick=" dele()">批量删除</a>
	</div>

	<div id="dlg" class="easyui-dialog"
		style="width:700px;height:500px;padding:10px 20px" closed="true"
		buttons="#dlg-buttons">
		<div class="ftitle">培训需求信息</div>
		
		<div class="fitem">
			<label>单位名称：</label> <span id="companyname"></span>
		</div>
		<div class="fitem">
			<label>联系人员：</label> <span id="lianxiren"></span>
		</div>
		<div class="fitem">
			<label>联系电话：</label> <span id="tel"></span>
		</div>
		<div class="fitem">
			<label>传&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;真：</label> <span id="chuanzhen"></span>
		</div>
		<div class="fitem">
			<label>电子邮件：</label><span id="email"></span>
		</div>
		<div class="fitem">
			<label>培训时间：</label> <span id="time"></span>
		</div>
		<div class="fitem">
			<label>培训地点：</label> <span id="peixunadd"></span><span id="grprof2"></span>
		</div>
		<div class="fitem">
			<label>计划规模：</label> <span id="guimo"></span>
		</div>
		<div class="fitem">
			<label>配合事项：</label> <span id="peiheshixiang"></span>
		</div>
		<div class="fitem">
			<label>培训内容：</label> <div style="margin:10px;border: 1px solid #ccc;border-radius: 4px;font-size: 14px;font-family: 微软雅黑;" id="content"></div>
			
		</div>

	</div>
	<div id="dlg-buttons">
		 <a
			href="javascript:void(0)" class="easyui-linkbutton"
			iconCls="icon-ok" onclick="javascript:$('#dlg').dialog('close')"
			style="width:90px">ok</a>
	</div>
</body>
</html>
