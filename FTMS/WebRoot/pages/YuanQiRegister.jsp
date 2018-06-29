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

<title>用户注册</title>

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
<script type="text/javascript" src="../js/pages/YuanQiRegister.js"></script>
<script type="text/javascript" src="../js/pages/md5.js"></script>
<link rel="stylesheet" type="text/css" href="../css/color.css">
<link rel="stylesheet" type="text/css" href="../css/demo.css">
<link rel="stylesheet" type="text/css" href="../css/easyui.css">
<link rel="stylesheet" type="text/css" href="../css/icon.css">
<link rel="stylesheet" type="text/css" href="../css/xxwh.css">

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
	height: 81.5%;
	margin: 0;
}
/* by czt  */
.top{background:url(<%=path%>/images/ManagementSystem/ding.jpg) no-repeat;width:100%;height:100px;border-bottom:3px solid #B7D2FF}
 .logo{width:1180px; margin-top:10px;}
 .ding{background-color: rgba(255, 255, 255, 0.26); height:5px; width:100%;}
.ding_top{width:1180px; margin:0 auto; line-height:36px;}
.ding_aa{ height:36px; line-height:36px; float:right; color:#666666;}
.ding_top a{ font-size:14px; color:#666666;}
 /* above by czt */
</style>
</head>
<body>
	<div class="top">
		<div class="ding">
				<div class="ding_top">
					<div class="ding_aa">
					</div>
				</div>
			</div>	
			<div class="logo">
				<img src="<%=path%>/images/ManagementSystem//logo.png">
			</div>
		</div>
	<div id="main" align="center" style="padding:10px;">
		<table>
			<tr>
			<td style="height: 50px;font-weight: bold;" align="center" colspan="3"><span>园企注册</span></td>
			</tr>
			<tr><td colspan="4"><span>*填写确定后不能修改</span></td></tr>
			<tr>
				<td width="84" height="38"><span> 账&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;号：</span></td>
				<td width="287"><input id="username" class="easyui-textbox"
					style="width:250px;height:30px;" required
					data-options="missingMessage:'必填'"><span><font
						style="color:#F00">&nbsp;&nbsp;*</font></span></td>
				<td><span id="userinfo" style="font-size:12px;"></span></td>
			</tr>
			<tr>
				<td height="38"><span> 密&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;码：</span></td>
				<td><input id="password" type="password" class="easyui-textbox"
					style="width:250px;height:30px;"
					data-options="prompt:'密码',missingMessage:'必填'" required></td>
				<td><span id="passwordinfo" style="font-size:12px;"></span></td>
			</tr>
			<tr>
				<td height="38"><span> 电子邮件：</span></td>
				<td><input id="email" class="easyui-textbox"
					style="width:250px;height:30px;" required
					data-options="missingMessage:'必填'"><span><font
						style="color:#F00">&nbsp;&nbsp;*</font></span></td>
			</tr>
			
			<tr>
				<td height="38"><span>园企选择：</span></td>
				<td><select id="remark" class="easyui-combobox" name="state"
					required data-options="missingMessage:'必填'"
					style="width:250px;height:30px;" editable="false"
					panelHeight="auto">
						<option value="1">企业</option>
						<option value="2">园区</option>
				</select></td>
			</tr>
			
		</table>
		<div style="text-align:center;padding:10px">
			<a href="javascript:void(0)" class="easyui-linkbutton"
				iconCls="icon-ok" style="width:20%;height:40px;"
				onclick="uploadUser()"><span style="font-size:16px">保存</span></a>
		</div>
	</div>
	
	<!--main -->
	<div align="center" style="height:5%; background: #EEE;"><p>Copyright ◎ 2016 杨凌农科培训综合信息服务平台All Rights Reserved</p>
	<p>联系电话：029-87036420    87036412  邮政编码：712100  联系地址：杨凌示范区新桥北路政务大厦</p>
		</div>
</body>
</html>
