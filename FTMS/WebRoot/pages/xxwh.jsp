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

<title>My JSP 'xxwh.jsp' starting page</title>

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
<script type="text/javascript" src="../js/pages/xxwh.js"></script>
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
	width: auto;
	background: #fff;
}

html {
	height: 100%;
	width: auto
}
</style>
</head>

<body>
	<span id="username" style="display:none"><s:property
			value="username" /></span>
	<div id="main" align="center" style="padding:10px;">
		<table>
			<tr>
				<td width="84" height="38"><span> 账号：</span></td>
				<td width="287"><input class="easyui-textbox"
					style="width:250px;height:30px;" editable="false"
					value="<s:property value="username"/>"></td>
			</tr>
			<tr>
				<td height="38"><span> 密码：</span></td>
				<td><input id="password" type="password" class="easyui-textbox"
					style="width:250px;height:30px;" data-options="prompt:'密码'"
					value='<s:property value="user.password"/>'></td>
			</tr>
			<tr>
				<td height="38"><span> 真实姓名：</span></td>
				<td><input id="name" class="easyui-textbox"
					style="width:250px;height:30px;" editable="false"
					value="<s:property value="user.name"/>"></td>
			</tr>
			<tr>
				<td height="38"><span> 出生年月：</span></td>
				<td><input id="birthday" class="easyui-datebox"
					style="width:250px;height:30px;" editable="false"></td>
			</tr>
			<tr>
				<td height="38"><span> 性别：</span></td>
				<td><select id="gender" class="easyui-combobox" name="state"
					style="width:250px;height:30px;" editable="false"
					panelHeight="auto">
						<option value="男">男</option>
						<option value="女">女</option>
				</select></td>
			</tr>
			<tr>
				<td height="38"><span> 身份证号：</span></td>
				<td><input id="idnumber" class="easyui-textbox"
					style="width:250px;height:30px;" editable="false"
					value="<s:property value='user.idnumber' />"></td>
			</tr>
			<tr>
				<td height="38"><span> 地址：</span></td>
				<td><select id="province" class="easyui-combobox" name="province"
					style="width:250px;height:30px;" editable="false" panelHeight="300"></select><span>
						省</span></td>
				<td width="342"><select id="city" class="easyui-combobox"
					name="city" style="width:250px;height:30px;" editable="false"
					panelHeight="auto"></select><span> 市</span></td>
			</tr>
			<tr>
				<td height="38"></td>
				<td><select id="county" class="easyui-combobox" name="county"
					style="width:250px;height:30px;" editable="false"
					panelHeight="auto"></select><span> 县</span></td>
				<td><select id="town" class="easyui-combobox" name="town"
					style="width:250px;height:30px;" editable="false" panelHeight="200"></select><span>
						村</span></td>
			</tr>
			<tr>
				<td height="38"></td>
				<td colspan="3"><input id="address" class="easyui-textbox" name="address"
					style="width:540px;height:30px; "
					><span> 地址</span></td>
				<td>
			</tr>
			<tr>
				<td height="38"><span> 学历：</span></td>
				<td><select id="education" class="easyui-combobox" name="state"
					style="width:250px;height:30px;" editable="false"
					panelHeight="auto">
						<option value="小学">小学</option>
						<option value="初中">初中</option>
						<option value="高中">高中</option>
						<option value="大专">大专</option>
						<option value="本科">本科</option>
						<option value="研究生">研究生</option>
						<option value="其他">其他</option>
				</select></td>
			</tr>
			<tr>
				<td height="38"><span> 电话：</span></td>
				<td><input id="phone" class="easyui-textbox"
					style="width:250px;height:30px;"
					value="<s:property value='user.phone' />"></td>
			</tr>
			<tr>
				<td height="38"><span> 专业：</span></td>
				<td><select id="prof1" class="easyui-combobox" name="prof1"
					style="width:250px;height:30px;" editable="false"
					panelHeight="auto"></select></td>
				<td><select id="prof2" class="easyui-combobox" name="prof2"
					style="width:250px;height:30px;" editable="false"
					panelHeight="auto"></select></td>
			</tr>
			<tr>
				<td height="193"><span> 照片：</span></td>
				<td align="center" colspan="2"><iframe name="framer"
						src="upload.jsp" width=100% height="100%" frameborder="0"></iframe></td>
			</tr>
		</table>
		<div style="text-align:center;">
			<a href="javascript:void(0)" class="easyui-linkbutton"
				iconCls="icon-ok" style="width:20%;height:40px;"
				onclick="uploadUser()"><span style="font-size:16px">保存</span></a>
		</div>
	</div>
	<!--main -->
	<span id="user_sex" style="display:none"><s:property
			value='user.gender' /></span>
	<span id="user_year" style="display:none"><s:property
			value='year' /></span>
	<span id="user_education" style="display:none"><s:property
			value='user.education' /></span>
	<span id="user_picpath" style="display:none"><s:property
			value='user.picpath' /></span>
</body>
</html>


