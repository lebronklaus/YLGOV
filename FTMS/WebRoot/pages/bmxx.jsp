<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>pages/">

<title>My JSP 'bmxx.jsp' starting page</title>

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
<script type="text/javascript" src="../js/pages/bmxx.js"></script>
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

tr {
	height: 32px;
}

#yj_fm {
	margin: 0;
	padding: 10px 30px;
}

#zs_fm {
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
	<span id="username" style="display:none"><s:property
			value='username' /></span>
	<span id="info"style="display:none"><s:property
			value='info' /></span>
	<div id="main" style="width:100%;height:100%">
		<div id="Basic" class="easyui-panel" title="基本信息"
			style="width:100%;height:auto;padding:10px;">
			<table style="width:900px;">
				<tr>
					<td width="137" rowspan="5"><img
						src='<s:property value="user.picpath"/>' height="160" width="120"
						style="border:1px solid;"></td>
					<td width="119"><span> 姓名：</span></td>
					<td width="106"><span><s:property value='user.name' /></span></td>
					<td width="111"><span>性别：</span></td>
					<td width="131"><span><s:property value='user.gender' /></span></td>
					<td width="106"><span> 出生年月：</span></td>
					<td width="158"><span><s:property value='birth' /></span></td>
				</tr>
				<tr>
					<td><span>联系电话：</span></td>
					<td colspan="2"><span><s:property value='user.phone' /></span></td>
					<td><span>身份证号：</span></td>
					<td colspan="3"><span><s:property value='user.idnumber' /></span></td>
				</tr>
				<tr>
					<td><span>家庭住址：</span></td>
					<td colspan="5"><span> <s:property
								value='user.JPositionProvice.proviceName' /> <s:property
								value='user.JPositionCity.cityName' /> <s:property
								value='user.JPositionCounty.countyName' /> <s:property
								value='user.JPositionTown.townName' /> <s:property 
								value="address.address"/></span></td>
				</tr>
				<tr>
					<td><span>学历：</span></td>
					<td><span><s:property value='user.education' /></span></td>
					<td><span>从事专业：</span></td>
					<td colspan="3"><span><s:property
								value='user.prof2.prof1.name' />-<s:property
								value='user.prof2.name' /></span></td>
				</tr>
				<tr>
					<td><span>申报级别：</span></td>
					<td><select class="easyui-combobox" id="uplevel" name="exam.level"
						style="width:100px;height:30px;" editable="false"
						panelHeight="auto">
							<option value="农技员" selected>农技员</option>
							<option value="农技师">农技师</option>
							<option value="高级农技师">高级农技师</option>
					</select></td>
					<td><span>考试时间：</span></td>
					<td><select class="easyui-combobox" id="uptime" name="exam.time"
						style="width:100px;height:30px;" editable="false"
						panelHeight="auto">
							<option value="1" selected>1月</option>
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
					</select></td>
					<td><span>考试地点：</span></td>
					<td><select class="easyui-combobox" id="upaddress" name="exam.address"
						style="width:100px;height:30px;" editable="false"
						panelHeight="auto">
							<option value="杨凌" selected>杨凌</option>
							<option value="本地">本地</option>
							<option value="其他">其他</option>
					</select></td>
				</tr>
			</table>
		</div>
		<!-- Basic -->
		<table id="yj_dg"
			title="从事专业技术工作业绩情况（指从事该专业时间，效果效益、示范带动效应，已获得技能等级，各种奖励、文章等）"
			class="easyui-datagrid" style="width:100%;height:auto"
			toolbar="#yj_toolbar" rownumbers="true" fitColumns="true"
			singleSelect="true" selectOnCheck="true" checkOnSelect="true">
			<thead>
				<tr>
					<th data-options="checkbox:true" field="id"></th>
					<th field="start" width="50">开始时间</th>
					<th field="end" width="50">结束时间</th>
					<th field="completion" width="50">完成情况</th>
					<th field="winess" width="50">鉴定人</th>
				</tr>
			</thead>
		</table>
		<div id="yj_toolbar">
			<a href="javascript:void(0)" class="easyui-linkbutton"
				iconCls="icon-add" plain="true" onclick="yj_newUser()">新建</a> <a
				href="javascript:void(0)" class="easyui-linkbutton"
				iconCls="icon-edit" plain="true" onclick="yj_editUser()">编辑</a> <a
				href="javascript:void(0)" class="easyui-linkbutton"
				iconCls="icon-remove" plain="true" onclick="yj_destroyUser()">删除</a>
		</div>

		<div id="yj_dlg" class="easyui-dialog"
			style="width:400px;height:280px;padding:10px 20px" closed="true"
			buttons="#yj_dlg-buttons">
			<div class="ftitle">业绩信息</div>
			<form id="yj_fm" method="post" novalidate>
				<div class="fitem">
					<label>开始时间:</label> <input id="yj_start" name="start"
						class="easyui-textbox"
						data-options="required:true,missingMessage:'该项必填'">
				</div>
				<div class="fitem">
					<label>结束时间:</label> <input id="yj_end" name="end"
						class="easyui-textbox"
						data-options="required:true,missingMessage:'该项必填'">
				</div>
				<div class="fitem">
					<label>完成情况:</label> <input id="yj_completion" name="completion"
						class="easyui-textbox"
						data-options="required:true,missingMessage:'该项必填'">
				</div>
				<div class="fitem">
					<label>证明人:</label> <input id="yj_winess" name="winess"
						class="easyui-textbox"
						data-options="required:true,missingMessage:'该项必填'">
				</div>
			</form>
		</div>
		<div id="yj_dlg-buttons">
			<a href="javascript:void(0)" class="easyui-linkbutton c6"
				iconCls="icon-ok" onclick="yj_saveUser()" style="width:90px">保存</a>
			<a href="javascript:void(0)" class="easyui-linkbutton"
				iconCls="icon-cancel"
				onclick="javascript:$('#yj_dlg').dialog('close')" style="width:90px">取消</a>
		</div>
		<table id="zs_dg" title="曾获得的证书" class="easyui-datagrid"
			style="width:100%;height:auto" toolbar="#zs_toolbar"
			rownumbers="true" fitColumns="true" singleSelect="true"
			selectOnCheck="true" checkOnSelect="true">
			<thead>
				<tr>
					<th data-options="checkbox:true" field="id"></th>
					<th field="time" width="50">时间</th>
					<th field="major" width="50">专业</th>
					<th field="certificatename" width="50">证书名称</th>
				</tr>
			</thead>
		</table>
		<div id="zs_toolbar">
			<a href="javascript:void(0)" class="easyui-linkbutton"
				iconCls="icon-add" plain="true" onclick="zs_newUser()">新建</a> <a
				href="javascript:void(0)" class="easyui-linkbutton"
				iconCls="icon-edit" plain="true" onclick="zs_editUser()">编辑</a> <a
				href="javascript:void(0)" class="easyui-linkbutton"
				iconCls="icon-remove" plain="true" onclick="zs_destroyUser()">移除</a>
		</div>

		<div id="zs_dlg" class="easyui-dialog"
			style="width:400px;height:280px;padding:10px 20px" closed="true"
			buttons="#zs_dlg-buttons">
			<div class="ftitle">获得的证书</div>
			<form id="zs_fm" method="post" novalidate>
				<div class="fitem">
					<label>时间：</label> <input id="zs_time" name="time"
						class="easyui-textbox"
						data-options="required:true,missingMessage:'该项必填'">
				</div>
				<div class="fitem">
					<label>专业：</label> <input id="zs_major" name="major"
						class="easyui-textbox"
						data-options="required:true,missingMessage:'该项必填'">
				</div>
				<div class="fitem">
					<label>证书名称：</label> <input id="zs_certificatename"
						name="certificatename" class="easyui-textbox"
						data-options="required:true,missingMessage:'该项必填'">
				</div>
			</form>
		</div>
		<div id="zs_dlg-buttons">
			<a href="javascript:void(0)" class="easyui-linkbutton c6"
				iconCls="icon-ok" onclick="zs_saveUser()" style="width:90px">保存</a>
			<a href="javascript:void(0)" class="easyui-linkbutton"
				iconCls="icon-cancel"
				onclick="javascript:$('#zs_dlg').dialog('close')" style="width:90px">取消</a>
		</div>
		<div style="text-align:center;padding:20px">
			<a href="javascript:void(0)" class="easyui-linkbutton"
				iconCls="icon-ok" style="width:20%;height:40px;" onclick="bmxxupload()"><span
				style="font-size:16px">报考</span></a>
		</div>
	</div>
	<!-- main -->
</body>
</html>
