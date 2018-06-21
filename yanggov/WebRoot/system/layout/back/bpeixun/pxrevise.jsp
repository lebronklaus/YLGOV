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

<link rel="stylesheet" type="text/css"
	href="system/layout/back/css/xxwh.css">
<link rel="stylesheet" type="text/css"
	href="system/layout/back/css/easyui.css">
<link rel="stylesheet" type="text/css"
	href="system/layout/back/css/color.css">
<link rel="stylesheet" type="text/css"
	href="system/layout/back/css/demo.css">
<link rel="stylesheet" type="text/css"
	href="system/layout/back/css/icon.css">
<script type="text/javascript" src="system/layout/back/js/jquery.min.js"></script>
<script type="text/javascript"
	src="system/layout/back/js/jquery.easyui.min.js"></script>
<script type="text/javascript" src="system/layout/back/js/pxeidt.js"></script>
<script charset="utf-8" src="kindeditor/kindeditor.js"></script>
<script charset="utf-8" src="kindeditor/lang/zh_CN.js"></script>
<script src="system/layout/back/laydate/laydate.js"></script>
<script>
	KindEditor.ready(function(K) {
		window.editor = K.create('#inputNote');
	});
	
 	function myformatter(date) {
		var y = date.getFullYear();
		var m = date.getMonth() + 1;
		var d = date.getDate();
		return y + '-' + (m < 10 ? ('0' + m) : m) + '-'
				+ (d < 10 ? ('0' + d) : d);
	}
	function myparser(s) {
		if (!s)
			return new Date();
		var ss = (s.split('-'));
		var y = parseInt(ss[0], 10);
		var m = parseInt(ss[1], 10);
		var d = parseInt(ss[2], 10);
		if (!isNaN(y) && !isNaN(m) && !isNaN(d)) {
			return new Date(y, m - 1, d);
		} else {
			return new Date();
		}
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
	<s:iterator value="post3">
		<div id="main" align="center" style="padding:10px; height:auto;">
	<fieldset style="width: 757px">
	<legend style="font-size:20px;font-family: 微软雅黑;font-weight:bold;">工作动态编辑</legend>
			<table style="margin-top: 20px;">
		 
				<tr>
					<td width="84" height="38"><span>
							标&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;题：</span>
					</td>
					<td width="624px" colspan="3"><input name="tt.title" id="title"
						class="easyui-textbox" style="width:98%;height:30px;"
						value="<s:property value="title"></s:property>">
					</td>
				</tr>

				<tr>
				
					<td height="38"><span>
							作&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;者：</span>
					</td>
					<td width="270"><input name="tt.author" id="author" class="easyui-textbox"
						style="width:250px;height:30px;"
						value="<s:property value="author"/>"><span><font
							style="color:#F00">&nbsp;&nbsp;*</font>
					</span>
					</td>
					
							<td height="38"><span>
							时&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;间：</span>
					</td>
					<td><input name="tt.date" id="date" class="easyui-datebox" data-options="formatter:myformatter,parser:myparser"
						style="width:250px;height:30px;" 
						value="<s:property value="date"/>"><span><font
							style="color:#F00">&nbsp;&nbsp;*</font>
					</span>
					</td>
				</tr>

				<tr>
					<td height="38"  valign="top"><span>
							正&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;文：</span>
					</td>
					<td colspan="3" width="624px"><textarea style="width: 98%;height:330px;"
							class="form-control" id="inputNote" rows="5"
							name="tt.teacher_profile">
							<s:property value="text" escape="false" />
						</textarea>
				</tr>
					
								<tr>
<!-- 				<td height="200"><span>上传文件：</span></td> -->
				<td align="center"  height="50px" colspan="3"><iframe name="framer"
						src="system/layout/back/bpeixun/uploaddt1.jsp" width=100% height="100%" frameborder="0"></iframe></td>
	 </tr>

			</table>
			<div style="text-align:center;padding:10px">
				<a href="javascript:void(0)" class="easyui-linkbutton"
					iconCls="icon-ok" style="width:20%;height:40px;"
					onclick="uploadUser()"><span style="font-size:16px">保存</span>
				</a>
			</div>
	</fieldset>
			
		</div>
		<!-- 	<span id="user_picpath" ><s:property value="id"/></span> -->
		<span id="tzid" style="display:none;"><s:property value="dtid" />
		</span>
	</s:iterator>
	<!--main -->
	 
</body>
</html>
