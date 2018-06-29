<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>pages/">

<title>My JSP 'adminManagement.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<link rel="stylesheet" type="text/css" href="../css/easyui.css">
<link rel="stylesheet" type="text/css" href="../css/color.css">
<link rel="stylesheet" type="text/css" href="../css/demo.css">
<link rel="stylesheet" type="text/css" href="../css/icon.css">
<script type="text/javascript" src="../js/jquery.min.js"></script>
<script type="text/javascript" src="../js/jquery.easyui.min.js"></script>
<script type="text/javascript" src="../js/pages/adminManagement.js"></script>
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
	font-size: 16px;
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
	display: inline-block;
	width: 80px;
}

.fitem input {
	width: 160px;
}
</style>
<script type="text/javascript">
$(document).ready(function() {
			$("#dg").datagrid({
				rownumbers : true,
				fit : true,
				striped : true,
				pagination : true,
				pageSize : 10,// 每页显示的记录条数，默认为10
				pageList : [ 10, 20, 30 ],// 可以设置每页记录条数的列表
			});
			var p = $('#dg').datagrid('getPager');
			$(p).pagination({
				beforePageText : '第',// 页数文本框前显示的汉字
				afterPageText : '页    共 {pages} 页',
				displayMsg : '当前显示 {from} - {to} 条记录   共 {total} 条记录'
			});

			$.post( "adminload",function(data){
				$('#dg').datagrid({
					loadFilter : pagerFilter
				}).datagrid('loadData', data);
			})
		});
</script>
</head>

<body>
	<table id="dg" title="管理员信息" class="easyui-datagrid"
		style="width:auto;height:auto" toolbar="#toolbar" rownumbers="true"
		fitColumns="true" singleSelect="false" selectOnCheck="true"
		checkOnSelect="true" pagination="true">
		<thead>
			<tr>
				<th field="adminname" width="50" formatter="formatname">账号</th>
				<th width="50" field="adminpassword">密码</th>
				<th width="50" data-options="field:'_operate',formatter:formatOper">修改</th>
			</tr>
		</thead>
	</table>
	<div id="toolbar">
		<a href="javascript:void(0)" class="easyui-linkbutton"
			iconCls="icon-add" plain="true" onclick="newUser()">添加管理员</a>
	</div>

	<div id="dlg" class="easyui-dialog"
		style="width:400px;height:220px;padding:10px 20px" closed="true"
		buttons="#dlg-buttons" pagination="true">
		<div class="ftitle">管理员信息</div>
		<form id="fm" method="post" novalidate>
			<div class="fitem">
				<label>账号:</label> <input id="adminname" class="easyui-textbox"
					required data-options="missingMessage:'必填'">
			</div>
			<div class="fitem">
				<label>密码:</label> <input id="adminpassword" class="easyui-textbox"
					required data-options="missingMessage:'必填'">
			</div>
		</form>
	</div>
	<div id="dlg-buttons">
		<a href="javascript:void(0)" class="easyui-linkbutton c6"
			iconCls="icon-ok" onclick="saveUser()" style="width:90px">保存</a> <a
			href="javascript:void(0)" class="easyui-linkbutton"
			iconCls="icon-cancel" onclick="javascript:$('#dlg').dialog('close')"
			style="width:90px">取消</a>
	</div>
</body>
</html>

