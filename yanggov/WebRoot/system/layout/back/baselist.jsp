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

<title>Train_base_list</title>

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
<script type="text/javascript" src="system/layout/back/js/baselist.js"></script>
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
</style>
<script type="text/javascript">  
    $(function() {  
        $('#dg').datagrid({  
            title : '基地管理—基地列表',  
            iconCls : 'icon-ok',  
            pageSize : 25,//默认选择的分页是每页5行数据  
            pageList : [  15, 20,25 ],//可以选择的分页集合  
            nowrap : true,//设置为true，当数据长度超出列宽时将会自动截取  
            striped : true,//设置为true将交替显示行背景。  
            collapsible : true,//显示可折叠按钮  
            toolbar:"#tb",//在添加 增添、删除、修改操作的按钮要用到这个  
            url:'./base/baseb.action',//url调用Action方法  
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
      
</script>   
</head>

<body>
	<table id="dg" title="基地列表" class="easyui-datagrid"
		style="width:auto;height:100%" toolbar="#toolbar" rownumbers="true"
		fitColumns="true" singleSelect="false" selectOnCheck="true"
		checkOnSelect="true" pagination="true">
		<thead>
			<tr>
				<th field="base_name" width="50">基地名称</th>
				<th width="50" data-options="field:'_operate',formatter:formatOper">操作</th>
			</tr>
		</thead>
	</table>
	<div id="toolbar">
		<input class="easyui-textbox" id="name" name="name"
			data-options="prompt:'请输入基地名称'" style="width:15%"> 
		 <a href="javascript:void(0)" class="easyui-linkbutton"
			style="width:5%" onclick="Search()">查询</a> <a
			href="javascript:void(0)" class="easyui-linkbutton"
			iconCls="icon-remove" plain="true" onclick=" dele()">批量删除</a>
	</div>

	<div id="dlg" class="easyui-dialog"
		style="width:700px;height:500px;padding:10px 20px" closed="true"
		buttons="#dlg-buttons">
		<div class="ftitle">基地信息</div>
		<div class="fitem" style="float:left">
			<img id="baseimg1" height="160" width="300" style="border:1px solid;">
		</div>
		<div class="fitem" style="float:right">
			<img id="baseimg2" height="160" width="300" style="border:1px solid;">
		</div>
		<div style = "clear:both;"></div>
		<div class="fitem">
			<label>基地名称：</label> <span id="base_name"></span>
		</div>
		<div class="fitem">
			<label>联系人&nbsp;&nbsp;&nbsp;：</label> <span id="base_contact"></span>
		</div>
		<div class="fitem">
			<label>基地简介：</label> <div style="margin:10px;border: 1px solid #ccc;border-radius: 4px;font-size: 14px;font-family: 微软雅黑;" id="base_profile"></div>
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
