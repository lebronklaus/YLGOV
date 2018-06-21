<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>pages/">
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript" src="../js/jquery.min.js"></script>
	<script src="../js/jquery.easyui.min.js"></script>
	<script type="text/javascript">
	function fun(){
	var aa=$('#myimage').text();
	return aa;
	}
	function save(form){
		if(document.getElementById("ufile").value.length>4){
		window.parent.deleteimg($('#myimage').text());
		window.parent.save($('#myimage').text());
		}
		else{
			alert("请先选择图片，在进行上传。");
			return false;
		}
		 return true;
	}
	$(document).ready(function() {
	 window.parent.save($('#myimage').text());
	});
	</script>
	<style>
	.img{background: url(../images/ManagementSystem/nopic.png)}
	</style>
  </head>
  
  <body>
    <table>
    <span id="myimage" style="display:none"><s:property value="uploadImageName" /></span>
	<tr>
	<td><img id="gg" src='<s:property value="uploadImageName" />' width="120px" height="160px" /></td>
	<td><s:form action="doUpload" method="POST"
		enctype="multipart/form-data">
		<s:file name="upload" id="ufile" />
		<s:submit value="上   传" onclick="return save(this.form)"/>
	</s:form>
	（图片像素为144*190，最大不超过100K，否则不能上传）
	</td>
	</tr>
	</table>
  </body>
</html>
