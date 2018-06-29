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
<base href="<%=basePath%>pages/">

<title>My JSP 'userManagement.jsp' starting page</title>

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
<script type="text/javascript" src="../js/pages/userManagement.js"></script>
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
</head>

<body>
	<table id="dg" title="用户信息" class="easyui-datagrid"
		style="width:auto;height:100%" toolbar="#toolbar" rownumbers="true"
		fitColumns="true" singleSelect="false" selectOnCheck="true"
		checkOnSelect="true" pagination="true">
		<thead>
			<tr>
				<th data-options="field:'ck',checkbox:true" field="id"></th>
				<th field="name" width="50">姓名</th>
				<th field="gender" width="50">性别</th>
				<th field="idnumber" width="50">身份证号</th>
				<th width="50" data-options="field:'_operate',formatter:formatOper">修改</th>
			</tr>
		</thead>
	</table>
	<div id="toolbar">
		<input class="easyui-textbox" id="name" name="name"
			data-options="prompt:'请输入用户姓名'" style="width:15%"> <a
			href="javascript:void(0)" id="search" class="easyui-linkbutton"
			iconCls="icon-search" title="查询" onclick="Search()">查询</a>
	</div>

	<div id="dlg" class="easyui-dialog"
		style="width:700px;height:550px;padding:10px 20px" closed="true"
		buttons="#dlg-buttons">
		<div class="ftitle">用户信息</div>
		<div class="fitem" style="float:right">
			<img id="grimg" height="160" width="120" style="border:1px solid;">
		</div>
		<div class="fitem">
			<label>姓名：</label> <input id="grname" class="easyui-textbox" name="grname"
				style="width:250px;height:30px;">
		</div>
		<div class="fitem">
			<label>性别：</label> <select id="grgender" class="easyui-combobox"
				name="grgender" style="width:250px;height:30px;" editable="false"
				panelHeight="auto">
				<option value="男">男</option>
				<option value="女">女</option>
			</select>
		</div>
		<div class="fitem">
			<label>出生年月：</label> <input id="grbirthday" class="easyui-datebox" name="grbirthday"
				style="width:250px;height:30px;" editable="false">
		</div>
		<div class="fitem">
			<label>身份证号：</label> <input id="gridnumber" class="easyui-textbox" name="gridnumber"
				style="width:250px;height:30px;">
		</div>
		<div class="fitem">
			<label>联系电话：</label> <input id="grphone" class="easyui-textbox" name="grphone"
				style="width:250px;height:30px;">
		</div>
		<div class="fitem">
			<label>家庭住址：</label> <select id="grprovince" class="easyui-combobox"
				name="grprovince" style="width:250px;height:30px;" editable="false"
				panelHeight="300"></select><span> 省</span> <select id="grcity"
				class="easyui-combobox" name="grcity"
				style="width:250px;height:30px;" editable="false" panelHeight="auto"></select><span>
				市</span>

		</div>
		<div class="fitem">
			<label> </label> <select id="grcounty" class="easyui-combobox"
				name="grcounty" style="width:250px;height:30px;" editable="false"
				panelHeight="auto"></select><span> 县</span> <select id="grtown"
				class="easyui-combobox" name="grtown"
				style="width:250px;height:30px;" editable="false" panelHeight="200"></select><span>
				村</span>
		</div>
		<div class="fitem">
			<label> </label><input id="address" class="easyui-textbox"
				style="width:500px;height:30px; " name="address"
				value="<s:property value="address.address"/>"><span>
				地址</span>
		</div>
		<div class="fitem">
			<label>学历：</label> <select id="greducation" class="easyui-combobox"
				name="greducation" style="width:250px;height:30px;" editable="false"
				panelHeight="auto">
				<option value="小学">小学</option>
				<option value="初中">初中</option>
				<option value="高中">高中</option>
				<option value="大专">大专</option>
				<option value="本科">本科</option>
				<option value="研究生">研究生</option>
				<option value="其他">其他</option>
			</select>
		</div>
		<div class="fitem">
			<label>从事专业：</label> <select id="grprof1" class="easyui-combobox"
				name="grprof1" style="width:250px;height:30px;" editable="false"
				panelHeight="auto"></select><span>&nbsp;&nbsp;&nbsp;&nbsp;</span> <select
				id="grprof2" class="easyui-combobox" name="grprof2"
				style="width:250px;height:30px;" editable="false" panelHeight="auto"></select>
		</div>

	</div>
	<div id="dlg-buttons">
		<a href="javascript:void(0)" class="easyui-linkbutton c6"
			iconCls="icon-ok" onclick="updateUser()" style="width:90px">修改</a> <a
			href="javascript:void(0)" class="easyui-linkbutton"
			iconCls="icon-cancel" onclick="javascript:$('#dlg').dialog('close')"
			style="width:90px">取消</a>
	</div>
</body>
</html>
