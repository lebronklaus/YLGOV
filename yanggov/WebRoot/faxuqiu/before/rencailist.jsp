<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<base href="<%=basePath%>"/>

<script  type="text/javascript" src="faxuqiu/js/pdfobject.min.js"></script>
<script type="text/javascript">
	window.onload=function(){
		PDFObject.embed("upload/media/xuqiuzhengji/rcpdf.pdf", "#xuqiuPDF");
	}
	
</script>

<style>
.pdfobject-container { height: 780px;}
.pdfobject { border: 1px solid #666; }

</style>
</head>
<body>

    <!-- PDF -->
    <div id="xuqiuPDF"></div>
  
    <!--by xiuhao.yan-->

<div style="clear:both;"></div>


<div class="di">
	<table height="20px"></table>
	<a href="upload/media/xuqiuzhengji/rcxqb.docx">附件下载：农业科技人才需求表.docx</a>
	<p>联系电话：029-87036420 &nbsp; &nbsp; &nbsp; &nbsp;联系地址：杨凌示范区新桥北路政务大厦</p>
</div>



</body>
</html>
