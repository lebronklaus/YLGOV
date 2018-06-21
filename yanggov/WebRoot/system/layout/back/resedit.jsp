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

<title>train_res_edit</title>

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
<script type="text/javascript" src="system/layout/back/js/resedit.js"></script>
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
	
	<div id="main" align="center" style="padding:10px;" class="easyui-panel"  title="资源管理—修改培训资源">
	<fieldset style="width:757px;">
			<legend style="font-size:20px;font-family: 微软雅黑;">修改培训资源</legend>
			<div style="height:20px"></div>
		<table>
			<%-- <tr >
				<td style="height: 50px;font-weight: bold;" align="center" colspan="4"><span > 修改资源</span></td>
			</tr> --%>
			<tr>
				<td width="84" height="38"><span> 资源名称：</span></td>
				<td width="287"><input name="res.resources_title" id="restitle" class="easyui-textbox"
					style="width:285px;height:30px;" required 
					data-options="missingMessage:'必填'" value="<s:property value="tr.resources_title"/>"></td>
						
				<td height="38"><span> 栏&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;目：</span></td>
				<td><select id="colum" class="easyui-combobox" name="res.resources_colum"
					required data-options="missingMessage:'必填'"
					style="width:285px;height:30px;" editable="false"
					panelHeight="auto">
					<option <s:if test='tr.resources_colum =="专家视频库"'> selected ="selected" </s:if> value="sp" >专家视频库</option>
                    <option <s:if test='tr.resources_colum =="广播演讲稿"'> selected ="selected" </s:if> value="gb" >广播演讲稿</option> 
                    <option <s:if test='tr.resources_colum =="专家文稿库"'> selected ="selected" </s:if> value="wg" >专家文稿库</option> 
				</select></td>
			</tr>
			
			<tr>
				<td height="38"><span> 资源作者：</span></td>
				<td><input name="tt.teacher_professional"  id="author" class="easyui-textbox"
					style="width:285px;height:30px;" value="<s:property value="tr.resources_author"/>" ></td>
						
				<td height="38"><span> 资源来源：</span></td>
				<td><input  name="tt.teacher_phonenum" id="from" class="easyui-textbox"
					style="width:285px;height:30px;" value="<s:property value="tr.resources_from"/>"></td>
			</tr>
			<tr> <td><div style="height:3px;"></div></td></tr>
			<tr>
				<td height="38" valign="top"><span> 资源简介：</span></td>
				<td colspan="3"><textarea style="width: 100%;height:410px;" class="form-control" id="inputNote" rows="5" name="res.resources_profile"><s:property value="tr.resources_profile" escape="false" /></textarea>
			</tr>
			
			<tr>
				<td height="100px" style="padding-bottom: 50px;"><span> 资源上传：</span></td>
				<td align="center" colspan="3"><iframe name="framer"
						src="system/layout/back/resupload.jsp" width=100% height="100%" frameborder="0"></iframe></td>
			</tr>
		</table>
			<div style="text-align:center;padding:10px">
				<a href="javascript:void(0)" class="easyui-linkbutton"
					iconCls="icon-ok" style="width:20%;height:40px;"
					onclick="uploadUser()"><span style="font-size:16px">保存</span></a>
			</div>
			</fieldset>
	</div>
	<span id="res_path" style="display:none;" ><s:property value="tr.resources_path"  /></span>
	<span id = "res_id" style="display:none;"><s:property value="tr.resources_id"  /></span>
	<!--main -->

</body>
</html>
