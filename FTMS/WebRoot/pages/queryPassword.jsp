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

<title>My JSP 'ksps.jsp' starting page</title>

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
<script type="text/javascript" src="../js/loading.js"></script>
<script type="text/javascript" src="../js/jquery.min.js"></script>
<script type="text/javascript" src="../js/jquery.easyui.min.js"></script>
<script type="text/javascript" src="../js/pages/querypassword.js"></script>
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
</style>
</head>

<body>
	<span id="adminname" style="display:none"><s:property
			value="adminname" /></span>
	<span id="supername" style="display:none"><s:property
			value="supername" /></span>
	
	<div style="margin-bottom:20px">
	

	</div>
	
	<div style="padding:10px">
		<span>请输入用户名：</span>
	<input id="username"  class="easyui-textbox"
		style="width:250px;height:30px;" data-options="prompt:'用户名'">
	</input>
	
		<a href="javascript:void(0)" class="easyui-linkbutton"
			iconCls="icon-search" style="width:80px;height:30px;"
			onclick="queryPsd()"><span style="font-size:16px">查询</span></a>
		
		<a href="javascript:void(0)" class="easyui-linkbutton"
			iconCls="icon-undo" style="width:80px;height:30px;"
			onclick="resetPsd()"><span style="font-size:16px">重置</span></a>
			
		<a href="javascript:void(0)" class="easyui-linkbutton"
			iconCls="icon-reload" style="width:100px;height:30px;"
			onclick="resetAllPsd()"><span style="font-size:16px">重置所有</span></a>
	</div>
</body>
</html>

