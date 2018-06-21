<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<script type="text/javascript" src="system/layout/back/js/jquery.min.js"></script>
	<script type="text/javascript" src="system/layout/back/js/jquery.easyui.min.js"></script>
	<script type="text/javascript">
	function fun(){
	var aa=$('#myimage').text();
	return aa;
	}
	function save(){
		window.parent.deleteimg($('#myimage').text());
		var filepath = $("input[name='upload']").val();
		var extStart = filepath.lastIndexOf(".");
		var ext4=filepath.substring(extStart,filepath.length).toUpperCase();
		$('#form').attr("action","./res/upload.action?fileclass="+ext4);
	}
	function fileChange(){
		var filepath = $("input[name='upload']").val();
		var extStart = filepath.lastIndexOf(".");
		var ext=filepath.substring(extStart,filepath.length).toUpperCase();
		if(ext!=".MP4"&&ext!=".PDF"&&ext!=".FLV"){
        	 alert("上传仅限pdf,mp4,flv格式文件,请重新选择文件!");
        	 $('#upload').attr("value","");
         	 return false;
        }
   	}
	$(document).ready(function() {
		window.parent.save($('#myimage').text());
	 	if($('#res_id',window.parent.document).text().trim()){
	 		var filepath = $('#res_path',window.parent.document).text();
			var extStart = filepath.lastIndexOf(".");
			var ext=filepath.substring(extStart,filepath.length).toUpperCase();
		 	$.post("./res/deleres",
	 			{
	 			res_path:$('#myimage').text(),
	 			res_id:$('#res_id',window.parent.document).text(),
	 			fileclass : ext
	 			},function() {
			});
		}
	});
	</script>
  </head>
  
  <body>
   <%--  <table>
    <span id="myimage" style="display:none"><s:property value="showpath" /></span>
	<tr>
	<td><s:form  id="form" method="POST"
		enctype="multipart/form-data">
		<s:file name="upload" onChange="fileChange()"/>
		<s:submit value="上   传" onclick="save()"/>
	</s:form>
	（仅支持上传mp4，pdf，mp3格式的文件）
	</td>
	</tr>
	</table> --%>
  </body>
  <span id="myimage" style="display:none"><s:property value="showpath" /></span>
  <form id="form" method="post" enctype="multipart/form-data" >
	<table>
	    <tr style="line-height: 80px;">
			<td>
				 <input style="font-size: 12px;font-family: 微软雅黑;" type="file" name="upload" id="a" class="input-text lh25"onChange="fileChange()"/>
				 <input style="font-size: 12px;font-family: 微软雅黑;" type="submit" onclick="save()" value="上传">
			</td>
			<td>
			<span style="font-size: 12px;font-family: 微软雅黑;">已上传成功</span>
			</td>
									 
		</tr>
		<tr style="line-height: 20px;">
			<td>
				<span>（仅支持上传mp4,flv,pdf格式的文件）</span>
			</td>
		</tr>
	</table>
    </form> 
</html>
