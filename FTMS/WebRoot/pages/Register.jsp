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
<script type="text/javascript" src="../js/pages/Register.js"></script>
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
	/* height: 81.5%; */
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
	<%-- <div style="height:11%; background:#16538f;" align="center">
		<img style="height:100%"
			src="<%=path%>/images/ManagementSystem/head.png">
	</div> --%>
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
			<td style="height: 50px;font-weight: bold;" align="center" colspan="4"><span>农民注册</span></td>
			</tr>
			<tr><td colspan="4"><span>*填写确定后不能修改</span></td></tr>
			<tr>
				<td width="84" height="38"><span> 账号：</span></td>
				<td width="287"><input id="username" class="easyui-textbox"
					style="width:250px;height:30px;" required
					data-options="missingMessage:'必填'"><span><font
						style="color:#F00">&nbsp;&nbsp;*</font></span></td>
				<td><span id="userinfo" style="font-size:12px;"></span></td>
			</tr>
			<tr>
				<td height="38"><span> 密码：</span></td>
				<td><input id="password" type="password" class="easyui-textbox"
					style="width:250px;height:30px;"
					data-options="prompt:'密码',missingMessage:'必填'" required></td>
				<td><span id="passwordinfo" style="font-size:12px;"></span></td>
			</tr>
			<tr>
				<td height="38"><span> 真实姓名：</span></td>
				<td><input id="name" class="easyui-textbox"
					style="width:250px;height:30px;" required
					data-options="missingMessage:'必填'"><span><font
						style="color:#F00">&nbsp;&nbsp;*</font></span></td>
			</tr>
			<tr>
				<td height="38"><span> 出生年月：</span></td>
				<td><input id="birthday" class="easyui-datebox" required
					data-options="missingMessage:'必填'" style="width:250px;height:30px;"
					editable="false"></td>
			</tr>
			<tr>
				<td height="38"><span> 性别：</span></td>
				<td><select id="gender" class="easyui-combobox" name="state"
					required data-options="missingMessage:'必填'"
					style="width:250px;height:30px;" editable="false"
					panelHeight="auto">
						<option value="男">男</option>
						<option value="女">女</option>
				</select></td>
			</tr>
			<tr>
				<td height="38"><span> 身份证号：</span></td>
				<td><input id="idnumber" class="easyui-textbox"
					style="width:250px;height:30px;" required
					data-options="missingMessage:'必填'"><span><font
						style="color:#F00">&nbsp;&nbsp;*</font></span></td>
			</tr>
			<tr>
				<td height="38"><span> 地址：</span></td>
				<td><select id="province" class="easyui-combobox" name="state"
					required data-options="missingMessage:'必填'"
					style="width:250px;height:30px;" editable="false" panelHeight="300"></select><span>
						省</span></td>
				<td width="342"><select id="city" class="easyui-combobox"
					required data-options="missingMessage:'必填'" name="state"
					style="width:250px;height:30px;" editable="false"
					panelHeight="auto"></select><span> 市</span></td>
			</tr>
			<tr>
				<td height="38"></td>
				<td><select id="county" class="easyui-combobox" name="state"
					style="width:250px;height:30px;" editable="false" required
					data-options="missingMessage:'必填'" panelHeight="auto"></select><span>
						县</span></td>
				<td><select id="town" class="easyui-combobox" name="state"
					required data-options="missingMessage:'必填'"
					style="width:250px;height:30px;" editable="false" panelHeight="200"></select><span>
						村</span></td>
			</tr>
			<tr>
				<td height="38"></td>
				<td colspan="3"><input id="address" class="easyui-textbox"
					style="width:540px;height:30px; "
					><span> 地址</span></td>
				<td>
			</tr>
			<tr>
				<td height="38"><span> 学历：</span></td>
				<td><select id="education" class="easyui-combobox" name="state"
					style="width:250px;height:30px;" editable="false" required
					data-options="missingMessage:'必填'" panelHeight="auto">
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
					style="width:250px;height:30px;" required
					data-options="missingMessage:'必填'"></td>
			</tr>
			<tr>
				<td height="38"><span> 专业：</span></td>
				<td><select id="prof1" class="easyui-combobox" name="state"
					style="width:250px;height:30px;" editable="false" required
					data-options="missingMessage:'必填'" panelHeight="auto"></select></td>
				<td><select id="prof2" class="easyui-combobox" name="state"
					style="width:250px;height:30px;" editable="false" required
					data-options="missingMessage:'必填'" panelHeight="auto"></select></td>
			</tr>
			<tr>
				<td height="200"><span> 照片：</span></td>
				<td align="center" colspan="2"><iframe name="framer"
						src="upload.jsp" width=100% height="100%" frameborder="0"></iframe></td>
			</tr>
		</table>
		<div style="text-align:center;padding:10px">
			<a href="javascript:void(0)" class="easyui-linkbutton"
				iconCls="icon-ok" style="width:20%;height:40px;"
				onclick="uploadUser()"><span style="font-size:16px">保存</span></a>
		</div>
	</div>
	<span id="user_picpath" ></span>
	<!--main -->
	<div align="center" style="height:5%; background: #EEE;"><p>Copyright ◎ 2016 杨凌农科培训综合信息服务平台All Rights Reserved</p>
	<p>联系电话：029-87036420    87063412  邮政编码：712100  联系地址：杨凌示范区新桥北路政务大厦</p></div>
</body>
</html>
