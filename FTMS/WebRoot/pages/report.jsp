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

<title>报表</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<script type="text/javascript" src="../js/jquery.min.js"></script>
<script type="text/javascript" src="../js/jquery.easyui.min.js"></script>
<script type="text/javascript" src="../js/pages/report.js"></script>
<link rel="stylesheet" type="text/css" href="../css/color.css">
<link rel="stylesheet" type="text/css" href="../css/demo.css">
<link rel="stylesheet" type="text/css" href="../css/easyui.css">
<link rel="stylesheet" type="text/css" href="../css/icon.css">
<style>
span {
	font-size: 16px;
	font-family: "微软雅黑";
}

#imageyear {
	position: relative;
	left: 150px;
	top: 18px;
	font-size:24px;
	font-weight:bold;
}

#imagemonth {
	position: relative;
	left: 195px;
	top: 18px;
	font-size:24px;
	font-weight:bold;
}
</style>
</head>

<body>
	<div align="center">
		<div id="Basic" class="easyui-panel" title="基本信息"
			style="width:920px;height:auto;padding:10px;">
			<table style="width:900px;">
				<tr>
					<td width="137" rowspan="5"><img id="jgimg" height="160"
						width="120" style="border:1px solid;"></td>
					<td width="119"><span> 姓名：</span></td>
					<td width="106"><span id="jgname"></span></td>
					<td width="111"><span>性别：</span></td>
					<td width="131"><span id="jggender"></span></td>
					<td width="106"><span> 出生年月：</span></td>
					<td width="158"><span id="jgyear"></span><span id="jgmonth"></span></td>
				</tr>
				<tr>
					<td><span>联系电话：</span></td>
					<td colspan="2"><span id="jgphone"></span></td>
					<td><span>身份证号：</span></td>
					<td colspan="3"><span id="jgidnumber"></span></td>
				</tr>
				<tr>
					<td><span>家庭住址：</span></td>
					<td colspan="5"><span id="jglocal"></span></td>
				</tr>
				<tr>
					<td><span>学历：</span></td>
					<td><span id="jgeducation"></span></td>
					<td><span>从事专业：</span></td>
					<td colspan="3"><span id="jgprof"></span></td>
				</tr>
				<tr>
					<td><span>申报级别：</span></td>
					<td><span id="jglevel"></span></td>
					<td><span>考试时间：</span></td>
					<td><span id="jgtime"></span></td>
					<td><span>考试地点：</span></td>
					<td><span id="jgaddress"></span></td>
				</tr>
			</table>
		</div>
		<!-- Basic -->
		<!-- Basic -->
		<div id="judge" class="easyui-panel" title="评审意见"
			style="width:920px;height:auto;padding:10px;">
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
			style="width:920px;height:auto;padding:10px;">
			<table style="width:800px;">
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
		<table id="yj_dg"
			title="从事专业技术工作业绩情况（指从事该专业时间，效果效益、示范带动效应，已获得技能等级，各种奖励、文章等）"
			class="easyui-datagrid" style="width:920px;height:auto"
			rownumbers="true" fitColumns="true" singleSelect="true"
			selectOnCheck="true" checkOnSelect="true">
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
		<table id="zs_dg" title="曾获得的证书" class="easyui-datagrid"
			style="width:920px;height:auto" toolbar="#zs_toolbar" rownumbers="true"
			fitColumns="true" singleSelect="true" selectOnCheck="true"
			checkOnSelect="true">
			<thead>
				<tr>
					<th data-options="checkbox:true" field="id"></th>
					<th field="time" width="50">时间</th>
					<th field="major" width="50">专业</th>
					<th field="certificatename" width="50">证书名称</th>
				</tr>
			</thead>
		</table>
		<!-- <div style="text-align:center;padding:20px">
			<a href="javascript:void(0)" class="easyui-linkbutton"
				iconCls="icon-print" style="width:20%;height:40px;"><span
				style="font-size:16px">打印报表</span></a>
		</div> -->
	</div>
	<span id="username" style="display:none"><s:property
			value='username' /></span>
	<span id="userlevel" style="display:none"><s:property
			value='level' /></span>
</body>
</html>
