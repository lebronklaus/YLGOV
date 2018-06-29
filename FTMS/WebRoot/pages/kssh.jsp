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

<title>My JSP 'kssh.jsp' starting page</title>

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
<script type="text/javascript" src="../js/pages/kssh.js"></script>
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
	<table id="dg" title="人员审核" class="easyui-datagrid"
		style="width:auto;height:100%" toolbar="#toolbar" rownumbers="true"
		fitColumns="true" singleSelect="false" selectOnCheck="true"
		checkOnSelect="true" pagination="true">
		<thead>
			<tr>
				<th data-options="field:'ck',checkbox:true" field="id"></th>
				<th field="name" width="50">姓名</th>
				<th field="time" width="50">考试时间/月</th>
				<th field="level" width="50">申报级别</th>
				<th field="address" width="50">考试地点</th>
				<th field="status" width="50">审核状态</th>
				<th width="50" data-options="field:'_operate',formatter:formatOper">操作</th>
			</tr>
		</thead>
	</table>
	<div id="toolbar">
		<input class="easyui-textbox" id="name" name="name"
			data-options="prompt:'请输入人员姓名'" style="width:15%"> <span>报考级别：</span>
		<select class="easyui-combobox" id="level" name="level"
			style="width:10%" editable="false" panelHeight="auto">
			<option value="无" selected>无</option>
			<option value="农技员">农技员</option>
			<option value="农技师">农技师</option>
			<option value="高级农技师">高级农技师</option>
		</select> <span>报考时间：</span> <select class="easyui-combobox" id="time"
			name="time" style="width:10%" editable="false" panelHeight="auto">
			<option value="0" selected>无</option>
			<option value="1">1月</option>
			<option value="2">2月</option>
			<option value="3">3月</option>
			<option value="4">4月</option>
			<option value="5">5月</option>
			<option value="6">6月</option>
			<option value="7">7月</option>
			<option value="8">8月</option>
			<option value="9">9月</option>
			<option value="10">10月</option>
			<option value="11">11月</option>
			<option value="12">12月</option>
		</select> <span>拟选考试地点：</span> <select class="easyui-combobox" id="address"
			name="address" style="width:10%" editable="false" panelHeight="auto">
			<option value="无" selected>无</option>
			<option value="杨凌">杨凌</option>
			<option value="本地">本地</option>
			<option value="其他">其他</option>
		</select> <span>审核状态：</span> <select class="easyui-combobox" id="status"
			name="status" style="width:10%" editable="false" panelHeight="auto">
			<option value="无" selected>无</option>
			<option value="是">已审核</option>
			<option value="否">未审核</option>
		</select> <a href="javascript:void(0)" class="easyui-linkbutton"
			style="width:5%" onclick="Search()">查询</a> <a
			href="javascript:void(0)" class="easyui-linkbutton"
			iconCls="icon-edit" plain="true" onclick="plsh()">批量审核</a>
	</div>

	<div id="dlg" class="easyui-dialog"
		style="width:700px;height:500px;padding:10px 20px" closed="true"
		buttons="#dlg-buttons">
		<div class="ftitle">用户信息</div>
		<div class="fitem" style="float:right">
			<img id="grimg" height="160" width="120" style="border:1px solid;">
		</div>
		<div class="fitem">
			<label>姓名：</label> <span id="grname"></span>
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
		<div class="fitem">
			<label>申报级别：</label> <span id="grlevel"></span>
		</div>
		<div class="fitem">
			<label>考试时间：</label> <span id="grtime"></span>
		</div>
		<div class="fitem">
			<label>考试地点：</label> <span id="graddress"></span>
		</div>

	</div>
	<div id="dlg-buttons">
		<a href="javascript:void(0)" class="easyui-linkbutton c6"
			iconCls="icon-ok" onclick="grsh()" style="width:90px">审核</a> <a
			href="javascript:void(0)" class="easyui-linkbutton"
			iconCls="icon-cancel" onclick="javascript:$('#dlg').dialog('close')"
			style="width:90px">取消</a>
	</div>
</body>
</html>
