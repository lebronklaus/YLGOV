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

<title>My JSP 'rysy.jsp' starting page</title>

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
<script type="text/javascript" src="../js/pages/rysy.js"></script>
<style type="text/css">
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
</head>

<body>
	<table id="dg" title="人员审核" class="easyui-datagrid"
		style="width:auto;height:100%" toolbar="#toolbar" rownumbers="true"
		fitColumns="true" singleSelect="false" selectOnCheck="true"
		checkOnSelect="true" pagination="true">
		<thead>
			<tr>
				<th data-options="field:'ck',checkbox:true"></th>
				<th width="80" data-options="field:'name',formatter:formatname">姓名</th>
				<th field="level" width="80">等级</th>
				<th width="50" data-options="field:'_operate',formatter:formatOper">操作</th>
			</tr>
		</thead>
	</table>
	<div id="toolbar">
		<input class="easyui-textbox" id="name"
			data-options="prompt:'请输入人员姓名'" style="width:20%"> <span>证书级别：</span><select
			class="easyui-combobox" id="level" name="level" style="width:10%"
			editable="false" panelHeight="auto">
			<option value="无" selected>无</option>
			<option value="农技员">农技员</option>
			<option value="农技师">农技师</option>
			<option value="高级农技师">高级农技师</option>
		</select><a href="javascript:void(0)" class="easyui-linkbutton"
			style="width:5%" onclick="Search()">查询</a> <a
			href="javascript:void(0)" class="easyui-linkbutton"
			iconCls="icon-edit" plain="true" onclick="plsy()">批量审验</a>
	</div>

	<div id="dlg" class="easyui-dialog"
		style="width:700px;height:500px;padding:10px 20px" closed="true"
		buttons="#dlg-buttons">
		<div class="fitem" style="float:right">
			<img id="grimg" height="160" width="120"
				style="border:1px solid;">
		</div>
		<div class="fitem">
			<label>姓名：</label> <span id="grname"></span>
		</div>
		<div class="fitem">
			<label>等级：</label> <span id="grlevel"></span>
		</div>
		<div class="fitem">
			<label>性别：</label> <span id="grgender"></span>
		</div>
		<div class="fitem">
			<label>出生年月：</label> <span id="gryear"></span><span id="grmonth"></span><span
				id="grday"></span>
		</div>
		<div class="fitem">
			<label>身份证号：</label> <span id="gridnumber"></span>
		</div>
		<div class="fitem">
			<label>联系电话：</label> <span id="grphone"></span>
		</div>
		<div class="fitem">
			<label>家庭住址：</label><span id="grprovice"></span><span id="grcity"></span>
			<span id="grcounty"></span><span id="grtown"></span>
		</div>
		<div class="fitem">
			<label>学历：</label> <span id="greducation"></span>
		</div>
		<div class="fitem">
			<label>从事专业：</label> <span id="grprof1"></span><span id="grprof2"></span>
		</div>
	</div>
	<div id="dlg-buttons">
		<a href="javascript:void(0)" class="easyui-linkbutton c6"
			iconCls="icon-ok" onclick="grsy()" style="width:90px">审验</a> <a
			href="javascript:void(0)" class="easyui-linkbutton"
			iconCls="icon-cancel" onclick="javascript:$('#dlg').dialog('close')"
			style="width:90px">取消</a>
	</div>
</body>
</html>
