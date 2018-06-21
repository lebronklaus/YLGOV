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
	}
	$(document).ready(function() {
	 window.parent.save($('#myimage').text());
	 if($('#teacher_id',window.parent.document).text().trim()){
		 $.post("./teacher/deleimage",
	 			{
	 			tea_path:$('#myimage').text(),
	 			tea_id:$('#teacher_id',window.parent.document).text()
	 			},function() {
			});
	}
	});
	</script>
  </head>
  
  <body>
    <%-- <table>
    <span id="myimage" style="display:none"><s:property value="showpath" /></span>
	<tr>
	<td><img id="gg" src='upload/media/image/<s:property value="showpath"/>' width="120px" height="160px" /></td>
	<td><s:form action="./teacher/upload.action" method="POST"
		enctype="multipart/form-data">
		<s:file name="upload" />
		<s:submit value="上   传" onclick="save()"/>
	</s:form>
	（图片像素为144*190，最大不超过100K，否则不能上传）
	</td>
	</tr>
	</table> --%>
	<span id="myimage" style="display:none"><s:property value="showpath" /></span>
	<form id="form" action="./teacher/upload.action" method="post" enctype="multipart/form-data" >
	<div>
		<div style="float:left;"><img id="gg" src='upload/media/image/<s:property value="showpath"/>' width="120px" height="160px" /></div>
		<div style="float:left;">
			<table>
			    		<tr style="line-height: 100px;">
							<td style="padding-top: 50px;">
								 <input style="font-size: 12px;font-family: 微软雅黑;" type="file" name="upload" id="a" class="input-text lh25"/>
							</td>
							<td style="padding-top: 50px;"> <input style="font-size: 12px;font-family: 微软雅黑;" type="submit" onclick="save()" value="上传"></td>
						</tr>
						<tr style="line-height: 30px;">
							<td colspan="2">
								<span style="font-size: 12px;font-family: 微软雅黑;">（图片像素为144*190，最大不超过100K，否则不能上传）</span>
							</td>
						</tr>
			</table>
		</div>
	</div>
    </form> 
  </body>
</html>
