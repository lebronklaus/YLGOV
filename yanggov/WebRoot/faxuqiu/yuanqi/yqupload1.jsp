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

<title>My JSP 'upload.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<script type="text/javascript" src="system/layout/back/js/jquery.min.js"></script>
	<script type="text/javascript">
	function save1(){
		 window.parent.deletepic1($('#yq_path1').attr("src"));
		
	}
	$(document).ready(function() {
	$('#yq_path1').attr("src", <%=path%>+"upload/media/yuanqiimage/"+$('#yq_path1',window.parent.document).text());
	});
	
	</script>
</head>

<body>
	<%-- <table>
	<tr>
	<td><img id="yq_path1" width="120px" height="160px" /></td>
	<td><s:form action="upload1.action" method="POST"
		enctype="multipart/form-data">
		<s:file name="upload" />
		<s:submit value="上   传" onclick="save1()"/>
	</s:form>
	（图片像素为144*190，最大不超过100K，否则不能上传）
	</td>
	</tr>
	</table> --%>
	<form id="form" action="upload1.action" method="post" enctype="multipart/form-data" >
	<div>
		<div style="float:left;"><img id="yq_path1" width="120px" height="160px" /></div>
		<div style="float:left;">
			<table>
			    		<tr style="line-height: 100px;">
							<td style="padding-top: 50px;">
								 <input style="font-size: 12px;font-family: 微软雅黑;" type="file" name="upload" id="a" class="input-text lh25"/>
							</td>
							<td style="padding-top: 50px;"> <input style="font-size: 12px;font-family: 微软雅黑;" type="submit" onclick="save1()" value="上传"></td>
						</tr>
						<tr style="line-height: 30px;">
							<td colspan="2">
								<span style="font-size: 12px;font-family: 微软雅黑;">（图片像素为760*500）</span>
							</td>
						</tr>
			</table>
		</div>
	</div>
    </form> 
</body>
</html>
