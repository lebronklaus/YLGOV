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

<title>train_teacher_edit</title>

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
<script type="text/javascript" src="system/layout/back/js/teaeidt.js"></script>
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
	
	<div id="main" align="center" style="padding:10px;"class="easyui-panel"  title="师资管理—修改师资信息">
	<fieldset style="width:757px;">
			<legend style="font-size:20px;font-family: 微软雅黑;">修改师资信息</legend>
			<div style="height:20px"></div>
		<table>
			<tr>
				<td width="84" height="38"><span> 姓&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;名：</span></td>
				<td width="287"><input name="tt.teacher_name" id="teaname" class="easyui-textbox"
					style="width:285px;height:30px;" value="<s:property value="tt.teacher_name"/>"></td>
				
				<td height="38"><span> 性&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;别：</span></td>
				<td><select id="gender" class="easyui-combobox" name="tt.teacher_sex"
					style="width:285px;height:30px;" editable="false"
					panelHeight="auto">
						<option   <s:if test='tt.teacher_sex=="男"'> selected="selected"</s:if> value="male">男</option>
						<option <s:if test='tt.teacher_sex=="女"'>selected="selected"</s:if> value="female">女</option>
				</select></td>
			</tr>
			
			<tr>
				<td height="38"><span> 工作单位：</span></td>
				<td><input name="tt.teacher_workplace"  id="workplace"  class="easyui-textbox"
					style="width:285px;height:30px;"
					value="<s:property value="tt.teacher_workplace"/>"></td>
				
				<td height="38"><span>是否在职：</span></td>
				<td><select id="inwork" class="easyui-combobox" name="tt.teacher_inwork"
					required data-options="missingMessage:'必填'"
					style="width:285px;height:30px;" editable="false"
					panelHeight="auto">
						<option <s:if test='tt.teacher_inwork=="是"'> selected="selected"</s:if> value="yes">是</option>
                    	<option <s:if test='tt.teacher_inwork=="否"'> selected="selected"</s:if> value="no">否</option>
				</select></td>
			</tr>
			
			<tr>
				<td height="38"><span> 技术职称：</span></td>
				<td><input name="tt.teacher_professional"  id="profession" class="easyui-textbox"
					style="width:285px;height:30px;" value="<s:property value="tt.teacher_professional"/>"></td>
						
				<td height="38"><span> 单位电话：</span></td>
				<td><input  name="tt.teacher_phonenum" id="phonenum" class="easyui-textbox"
					style="width:285px;height:30px;" value="<s:property value="tt.teacher_phonenum"/>" ></td>
			</tr>
			
			<tr>
				<td height="38"><span> 毕业院校：</span></td>
				<td><input name="tt.teacher_university"  id="university" class="easyui-textbox"
					style="width:285px;height:30px;" value="<s:property value="tt.teacher_university"/>" ></td>
						
				<td height="38"><span> 专业领域：</span></td>
				<td><input name="tt.teacher_major"  id="major" class="easyui-textbox"
					style="width:285px;height:30px;" value="<s:property value="tt.teacher_major"/>" ></td>
			</tr>
			
			<tr>
				<td height="38"><span> 联系地址：</span></td>
				<td><input  name="tt.teacher_address" id="address" class="easyui-textbox"
					style="width:285px;height:30px;" value="<s:property value="tt.teacher_address"/>" ></td>
						
				<td height="38"><span> 电子邮件：</span></td>
				<td><input  name="tt.teacher_email" id="email" class="easyui-textbox"
					style="width:285px;height:30px;" value="<s:property value="tt.teacher_email"/>" ></td>
			</tr>
			<tr> <td><div style="height:3px;"></div></td></tr>
			<tr>
				<td  valign="top" height="38"><span> 个人简介：</span></td>
				<td colspan="3"><textarea style="width: 100%;height:330px;" class="form-control" id="inputNote" rows="5" name="tt.teacher_profile"><s:property value="tt.teacher_profile" escape="false"/></textarea>
			</tr>
			
			
			<tr>
				<td height="200"><span> 照片：</span></td>
				<td align="center" colspan="3"><iframe name="framer"
						src="system/layout/back/upload.jsp" width=100% height="100%" frameborder="0"></iframe></td>
			</tr>
		</table>
			<div style="text-align:center;padding:10px">
				<a href="javascript:void(0)" class="easyui-linkbutton"
					iconCls="icon-ok" style="width:20%;height:40px;"
					onclick="uploadUser()"><span style="font-size:16px">保存</span></a>
			</div>
			</fieldset>
	</div>
	<span id="user_picpath" style="display:none;" ><s:property value="tt.teacher_path"/></span>
	<span id="teacher_id" style="display:none;" ><s:property value="tt.teacher_id"/></span>
	<!--main -->

</body>
</html>
