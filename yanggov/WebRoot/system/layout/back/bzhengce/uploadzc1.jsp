<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'uploadtz.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript" src="system/layout/back/js/jquery.min.js"></script>
<!-- 	<script type="text/javascript" src="system/layout/back/js/pxeidt.js"></script> -->
	<script type="text/javascript">
	function save()
	{
		
	}
	$(document).ready(function() 
	{
	var s=window.parent.deletepic();
	 
	$("#id").attr("value",s);
	});
	</script>

  </head>
  
  <body>
    <form action="zhnegcefile.action" method="post" enctype="multipart/form-data" validate="true" style="font-size: 16px; font-family:微软雅黑;">
    <tr style="line-height: 100px;">
									<td style="width: 10px;text-align: center;">上传附件：
									</td>
									<td>
										 <input type="file" name="upload" id="a" class="input-text lh25"/>
										 <input type="submit" value="上传">
									</td>
									<td>
									<input id="id" name="id" type="text" class="input-text lh25" style="display: none;">
									</td>
								 
									</tr>
    </form>
  </body>
</html>
