<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">
<link rel="stylesheet" type="text/css" href="system/layout/back/css/xxwh.css">
<link rel="stylesheet" type="text/css" href="system/layout/back/css/easyui.css">
<link rel="stylesheet" type="text/css" href="system/layout/back/css/color.css">
<link rel="stylesheet" type="text/css" href="system/layout/back/css/demo.css">
<link rel="stylesheet" type="text/css" href="system/layout/back/css/icon.css">
<script type="text/javascript" src="system/layout/back/js/jquery.min.js"></script>
<script type="text/javascript" src="system/layout/back/js/jquery.easyui.min.js"></script>
<title>My JSP 'upload.jsp' starting page</title>
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
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">

	
</head>

<body>
	<div id="main" align="center" style="padding:10px;" class="easyui-panel"  title="广告管理—广告投放">
	<fieldset style="width:757px;">
	<legend style="font-size:20px;font-family: 微软雅黑;">广告投放</legend>
	<div style="height:20px"></div>
	<form id="form" action="./teacher/ggupload.action" method="post" enctype="multipart/form-data" >
	<div>
		
		<div style="float:left;">
			<table>
						<tr >
							<td style="padding-top: 50px;">
								<div style="float:left;"><img id="myimage" src="images/zhicheng.jpg" width="800px" height="120px" /></div>
							</td>
						</tr>
			    		<tr style="line-height: 100px;">
							<td style="padding-top: 50px;">
								 <input style="font-size: 12px;font-family: 微软雅黑;" type="file" name="upload" id="a" class="input-text lh25"/>
								 <input style="float:right;font-size: 12px;font-family: 微软雅黑;" type="submit"  value="上传">
							</td>
							
						</tr>
						<tr style="line-height: 30px;">
							<td colspan="2">
								<span style="font-size: 12px;font-family: 微软雅黑;">（图片像素为1128*120px,否则不能上传）</span>
							</td>
						</tr>
			</table>
		</div>
	</div>
	</form>
    </fieldset>
	</div>
</body>
</html>
