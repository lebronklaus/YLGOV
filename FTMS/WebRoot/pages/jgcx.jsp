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

<title>My JSP 'jgcx.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<link rel="stylesheet" type="text/css" href="../css/easyui.css">
<link rel="stylesheet" type="text/css" href="../css/icon.css">
<link rel="stylesheet" type="text/css" href="../css/color.css">
<link rel="stylesheet" type="text/css" href="../css/demo.css">
<link rel="stylesheet" type="text/css" href="../css/cjcx.css">

<script type="text/javascript" src="../js/jquery.min.js"></script>
<script type="text/javascript" src="../js/jquery.easyui.min.js"></script>
<script type="text/javascript" src="../js/pages/jgcx.js"></script>
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

#imageyear {
	position: relative;
	left: 150px;
	top: 20px;
	font-size: 24px;
	font-weight: bold;
}

#imagemonth {
	position: relative;
	left: 195px;
	top: 20px;
	font-size: 24px;
	font-weight: bold;
}
</style>
</head>

<body>
	<span id="username" style="display:none"><s:property
			value='username' /></span>
	<div id="main" style="width:100%;height:100%">
		<div>
			<span>请选择要查询的等级：</span> <select class="easyui-combobox" id="slevel"
				name="slevel" style="width:150px;height:30px;" editable="false"
				panelHeight="auto">
				<option value="农技员">农技员</option>
				<option value="农技师">农技师</option>
				<option value="高级农技师">高级农技师</option>
			</select> <a href="javascript:void(0)" id="baobiao" class="easyui-linkbutton"
				iconCls="icon-print" style="width:10%;height:30px;"
				onclick="report()"><span style="font-size:16px">报表</span></a>
		</div>
		<div id="judge" class="easyui-panel" title="评审意见"
			style="width:100%;height:auto;padding:10px;">
			<table style="width:500px;">
				<tr>
					<td width="101"><span>业绩：</span></td>
					<td colspan="3"><span id="jgachievement"></span></td>
				</tr>
				<tr>
					<td><span>笔试成绩：</span></td>
					<td colspan="3"><span id="jgwritescore"></span></td>
				</tr>
				<tr>
					<td><span>面试成绩：</span></td>
					<td colspan="3"><span id="jginterviewscore"></span></td>
				</tr>
				<tr>
					<td><span>总人数：</span></td>
					<td width="89"><span id="jgtotal"></span></td>
					<td width="93"><span>参加人数：</span></td>
					<td width="197"><span id="jgcanjia"></span></td>
				</tr>
				<tr>
					<td><span>赞成票：</span></td>
					<td><span id="jgapproval"></span></td>
					<td><span>反对票：</span></td>
					<td><span id="jgopposition"></span></td>
				</tr>
			</table>
		</div>
		<!-- judge -->
		<div id="guanweihui" class="easyui-panel" title="管委会意见"
			style="width:100%;height:auto;padding:10px;">
			<table style="width:750px;">
				<tr>
					<td width="103" height="30"><span>同意授予：</span></td>
					<td width="100"></td>
					<td width="155"></td>
					<td width="375" rowspan="4"
						style="background-repeat: no-repeat;background-position: center;background-image: url(../images/onlinetest/zhang.png);">
						<span id="imageyear"></span><span id="imagemonth"></span>
					</td>
				</tr>
				<tr>
					<td height="30"></td>
					<td><span>职称名称：</span></td>
					<td><span id="jglevel2"></span></td>
				</tr>
				<tr>
					<td height="30"></td>
					<td><span>专业名称：</span></td>
					<td><span id="jgprof2"></span></td>
				</tr>
				<tr>
					<td></td>
					<td><span>证书编号：</span></td>
					<td><span id="jgnumber"></span></td>
				</tr>
			</table>
		</div>
		<!-- guanweihui -->
		<table id="sy_dg" title="审验" class="easyui-datagrid"
			style="width:100%;height:auto" rownumbers="true" fitColumns="true"
			singleSelect="true" selectOnCheck="true" checkOnSelect="true">
			<thead>
				<tr>
					<th data-options="checkbox:true" field="id"></th>
					<th field="level" width="50">等级</th>
					<th field="year" width="50">审验年份</th>
					<th field="status" width="50">审验状态</th>
				</tr>
			</thead>
		</table>
		<!-- shenyan -->
	</div>
</body>
</html>
