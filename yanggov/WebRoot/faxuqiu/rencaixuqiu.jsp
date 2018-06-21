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

<title>My JSP 'Register.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

<link rel="stylesheet" type="text/css" href="system/layout/back/css/xxwh.css">
<link rel="stylesheet" type="text/css" href="system/layout/back/css/easyui.css">
<link rel="stylesheet" type="text/css" href="system/layout/back/css/color.css">
<link rel="stylesheet" type="text/css" href="system/layout/back/css/demo.css">
<link rel="stylesheet" type="text/css" href="system/layout/back/css/icon.css">
<script type="text/javascript" src="system/layout/back/js/jquery.min.js"></script>
<script type="text/javascript" src="system/layout/back/js/jquery.easyui.min.js"></script>
<script type="text/javascript" src="faxuqiu/js/rencai.js"></script>
<script charset="utf-8" src="kindeditor/kindeditor.js"></script>
	<script charset="utf-8" src="kindeditor/lang/zh_CN.js"></script>
	<script>
    	  KindEditor.ready(function(K) {
     	        window.editor1 = K.create('#inputNote1');
     	        window.editor2 = K.create('#inputNote2');
     	        window.editor3 = K.create('#inputNote3');
     	        
     	        
     	 });
	</script>
	<script type="text/javascript">
		$(document).ready(function(){
				var a = $("#mark",window.parent.document).val();
				$("#mark").attr("value",a);
		});
	</script>
<style>
body {
	padding: 0;
	margin: 0;
	height: auto;
	width: auto
}

html {
	height: auto;
	width: auto
}

#main {
	width: auto;
	height: auto;
	margin: 0;
}
</style>
</head>
<body>
	
	<div id="main" align="center" style="padding:10px;"class="easyui-panel"  title="发布需求—发布人才需求">
	<fieldset style="width:757px;">
			<legend style="font-size:20px;font-family: 微软雅黑;font-weight:bold;">发布人才需求</legend>
			<div style="height:20px"></div>
		<table>
			<%-- <tr >
				<td style="height: 50px;font-weight: bold;" align="center" colspan="4"><span > 发布人才需求</span></td>
			</tr> --%>
			<tr>
				<td width="84" height="38"><span>岗位名称：</span></td>
				<td width="287"><input name="tt.teacher_name" id="gangwei" class="easyui-textbox"
					style="width:285px;height:30px;" required
					data-options="missingMessage:'必填'"></td>
				
				<td width="84" height="38"><span>需求人数：</span></td>
				<td width="287"><input name="tt.teacher_name" id="renshu" class="easyui-textbox"
					style="width:285px;height:30px;" required
					data-options="missingMessage:'必填'"></td>
			</tr>
			
			<tr>
				<td height="38"><span> 到岗时间：</span></td>
				<td><input name="tt.teacher_workplace"  id="daogangtime"  class="easyui-textbox"
					style="width:285px;height:30px;"
					data-options="missingMessage:'必填'" required></td>
				
				<td height="38"><span> 薪资待遇：</span></td>
				<td><input name="tt.teacher_workplace"  id="salary"  class="easyui-textbox"
					style="width:285px;height:30px;"
					data-options="missingMessage:'必填'" required></td>
			</tr>
			<tr> <td><div style="height:3px;"></div></td></tr>
			<tr>
				<td valign="top" height="38"><span>岗位描述：</span></td>
				<td colspan="3"><textarea style="width: 100%;height:330px;" class="form-control" id="inputNote1" rows="5" name="tt.teacher_profile"></textarea>
			</tr>
			<tr >
				<td style="height: 50px;" align="center" colspan="4"><span > 任职资格</span></td>
			</tr>
			<tr>
				<td height="38"><span> 所属领域：</span></td>
				<td><input  name="tt.teacher_phonenum" id="agerank" class="easyui-textbox"
					style="width:285px;height:30px;" required
					data-options="missingMessage:'必填'"></td>
						
				<td height="38"><span> 年龄范围：</span></td>
				<td><input  name="tt.teacher_phonenum" id="agerank" class="easyui-textbox"
					style="width:285px;height:30px;" required
					data-options="missingMessage:'必填'"></td>
			</tr>
			
			<tr>
				<td height="38"><span> 学&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;历：</span></td>
				<td><input name="tt.teacher_university"  id="xueli" class="easyui-textbox"
					style="width:285px;height:30px;" required
					data-options="missingMessage:'必填'"></td>
						
				<td height="38"><span> 专&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;业：</span></td>
				<td><input name="tt.teacher_major"  id="major" class="easyui-textbox"
					style="width:285px;height:30px;" required
					data-options="missingMessage:'必填'"></td>
			</tr>
			
			<tr> <td><div style="height:3px;"></div></td></tr>
			<tr>
				<td valign="top" height="38"><span> 岗位经验：</span></td>
				<td colspan="3"><textarea style="width: 100%;height:330px;" class="form-control" id="inputNote2" rows="5" name="tt.teacher_profile"></textarea>
			</tr>
			<tr> <td><div style="height:3px;"></div></td></tr>
			<tr>
				<td  valign="top" height="38"><span> 岗位说明：</span></td>
				<td colspan="3"><textarea style="width: 100%;height:330px;" class="form-control" id="inputNote3" rows="5" name="tt.teacher_profile"></textarea>
			</tr>
		</table>
			<div style="text-align:center;padding:10px">
				<a href="javascript:void(0)" class="easyui-linkbutton"
					iconCls="icon-ok" style="width:20%;height:40px;"
					onclick="uploadUser()"><span style="font-size:16px">保存</span></a>
			</div>
			</fieldset>
		<input  id="mark" style=" display:none;" value="<s:property value='#session.mark'/>">
	</div>
	<!--main -->
	
</body>
</html>
