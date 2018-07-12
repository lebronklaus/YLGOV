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
<base href="<%=basePath%>">

<title>train_base_add</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">

<link rel="stylesheet" type="text/css" href="system/layout/back/css/xxwh.css">
<link rel="stylesheet" type="text/css" href="system/layout/back/css/easyui.css">
<link rel="stylesheet" type="text/css" href="system/layout/back/css/color.css">
<link rel="stylesheet" type="text/css" href="system/layout/back/css/demo.css">
<link rel="stylesheet" type="text/css" href="system/layout/back/css/icon.css">
<script type="text/javascript" src="system/layout/back/js/jquery.min.js"></script>
<script type="text/javascript" src="system/layout/back/js/jquery.easyui.min.js"></script>
<script type="text/javascript" src="system/layout/back/js/baseedit.js"></script>
<script charset="utf-8" src="kindeditor/kindeditor.js"></script>
	<script charset="utf-8" src="kindeditor/lang/zh_CN.js"></script>
	<script>
    	  KindEditor.ready(function(K) {
     	        window.editor = K.create('#inputNote');
     	 });
	</script>
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
	height: 100%;
	margin: 0;
}
</style>
</head>
<body>
	
	<div id="main" align="center" style="padding:10px;" class="easyui-panel"  title="基地管理—修改分中心信息">
	<fieldset style="width:757px;">
			<legend style="font-size:20px;font-family: 微软雅黑;font-weight:bold;">修改分中心信息</legend>
			<div style="height:20px"></div>
		<table>
			<tr>
				<td width="84" height="38"><span> 分中心名称：</span></td>
				<td width="287"><input name="tb.base_name" id="basename" class="easyui-textbox"
					style="width:271px;height:30px;" value="<s:property value="tb.base_name"/>"></td>
						
				<td height="38"><span> 分中心联系人：</span></td>
				<td><input name="tb.base_contact"  id="contact"  class="easyui-textbox"
					style="width:271px;height:30px;"
					value="<s:property value="tb.base_contact"/>"></td>
			</tr>
			<tr> <td><div style="height:3px;"></div></td></tr>
			<tr>
				<td height="38" valign="top"><span> 分中心简介：</span></td>
				<td colspan="3"><textarea style="width: 100%;height:410px;" class="form-control" id="inputNote" rows="5" name="tb.base_profile"><s:property value="tb.base_profile" escape="false" /></textarea>
			</tr>
			
			
			<tr>
				<td height="200"><span> 远景照片：</span></td>
				<td align="center" colspan="3"><iframe name="framer"
						src="system/layout/back/baseupload1.jsp" width=100% height="100%" frameborder="0"></iframe></td>
			</tr>
			<tr>
				<td height="200"><span> 近景照片：</span></td>
				<td align="center" colspan="3"><iframe name="framer"
						src="system/layout/back/baseupload2.jsp" width=100% height="100%" frameborder="0"></iframe></td>
			</tr>
		</table>
			<div style="text-align:center;padding:10px">
				<a href="javascript:void(0)" class="easyui-linkbutton"
					iconCls="icon-ok" style="width:20%;height:40px;"
					onclick="uploadUser()"><span style="font-size:16px">保存</span></a>
			</div>
			</fieldset>
	</div>
	<span id="base_path1" style="display:none;" ><s:property value="tb.base_path1" escape="false" /></span>
	<span id="base_path2" style="display:none;"><s:property value="tb.base_path2" escape="false" /></span>
	<span id="base_id" style="display:none;"><s:property value="tb.base_id" escape="false" /></span>
	<!--main -->
	
</body>
</html>
