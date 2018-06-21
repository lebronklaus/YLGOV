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
<script type="text/javascript" src="system/layout/back/js/adddt.js"></script>
<script charset="utf-8" src="kindeditor/kindeditor.js"></script>
	<script charset="utf-8" src="kindeditor/lang/zh_CN.js"></script>
	<script>
    		 KindEditor.ready(function(K) {
     	        window.editor = K.create('#inputNote',{

					uploadJson : 'ImgUpload.action', //图片上传Action
					allowImageRemote : false //取消网络图片上传
				});
     	 });
     	 
   function datesub()
	{
	alert("ds");
	var now=new Date();
	var years=now.getFullYear();
	var month=now.getMonth()+1;
	var day=now.getDate();
	var sub=document.getElementById("datea");
	sub.value=years+"-"+month+"-"+day;
	  alert(sub.value);
 
	}
	
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
	
	<div id="main" align="center" style="padding:10px;">
	<fieldset style="width: 757px">
	<legend style="font-size:20px;font-family: 微软雅黑;font-weight:bold;">工作动态</legend>
		<table style="margin-top: 20px;">

			<tr>
				<td width="84" height="38"><span>标题：</span></td>
				<td  width="90%"><input name="tb.base_name" id="title" class="easyui-textbox"
					style="width:90%;height:30px;" required
					data-options="missingMessage:'必填'"><span><font
						style="color:#F00">&nbsp;&nbsp;*</font></span></td>
			</tr>
	
		<tr>
		  <td height="38"><span> 作者：</span></td>
				<td ><input name="tb.base_contact"  id="author"  class="easyui-textbox"
					style="width:90%;height:30px;"
					data-options="missingMessage:'必填'" required><span><font
						style="color:#F00">&nbsp;&nbsp;*</font ></span> </td>
		</tr>
		<tr>
		<td height="38"><span>备注：</span></td>
		<td>
		<textarea     id="remark"  class="easyui-textbox"
					style="width:90%;height:30px;" rows="10" cols="30"></textarea> 
		</td>
		</tr>
		
		
			<tr>
				<td height="38"><span>内  容：</span></td>
				<td  ><textarea style="width: 90%;height:330px;" class="form-control" id="inputNote" rows="5" name="tb.base_profile"></textarea>
			</tr>
			
			
			 <tr>
									<td>
									<input style="display:none"type="text" name="tzhi.date" value="" id="datea" />
									</td>
									</tr>
			
			<tr>
			
			
			
				<td align="center"   height="50" colspan="4" ><iframe name="framer"
						src="system/layout/back/bpeixun/uploaddt.jsp" width=100% height="100%" frameborder="0"></iframe></td>
			</tr>
	 
		</table>
		<div style="text-align:center;padding:10px">
				<a href="javascript:void(0)" class="easyui-linkbutton"
					iconCls="icon-ok" style="width:20%;height:40px;"
					onclick="uploadUser()"><span style="font-size:16px">保存</span></a>
			</div>
		</fieldset>
			
	</div>
	<span id="base_path1" ></span>
	<span id="base_path2" ></span>
 
</body>
</html>
