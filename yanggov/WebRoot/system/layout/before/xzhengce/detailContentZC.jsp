<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib uri="/struts-tags" prefix='s'%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'detailContent.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

<style type="text/css">
.tables thead
{
  font-family: "Microsoft YaHei", "微软雅黑", "sans-serif";
  font-weight: bold;
  font-size: 20px;
   text-align:center
}
.tables tbody
{
font-family: "Microsoft YaHei", "微软雅黑", "sans-serif";
font-size:14px
}
table.scrollable td { overflow: scroll; }

pre
{
white-space:pre-wrap;
white-space:-moz-pre-wrap;
white-space:-pre-wrap;
white-space:-o-pre-wrap;
word-wrap:break-word;
}
</style>
  </head>

  <body>
   <s:iterator value="post4">
   <table class="tables" style="width: 630px; overflow: scroll; ">
   <thead>
<tr   >
 <td  colspan="2" >  <s:property value="title"/></td>
</tr>
</thead>
   
   </table>
 
<div class="author" style="  width: 90%;;height: 35px;    line-height: 35px; border-bottom: #e3e3e3 solid 1px ;  margin-top: 15px;   font-size: 12px;  color: #6d6d6d;
    text-align: center;" >
   <span  >发布机构：</span>  <s:property value="fabujigou"/>&nbsp;|&nbsp;
   <span   >发布日期：</span><s:property value="date"/> &nbsp;|&nbsp;
   <span  >文号：</span><s:property value="wenhao"/>
   
</div>

  
<table class="tables" style="width: 630px; overflow: scroll; ">
   <tbody>
 
   <tr >
   <td colspan="4">
   <pre style="line-height: 28px;">
 <s:property 	value="text" escape="false"></s:property>
	  </pre>
	</td>
	</tr>
	<tr>
	<td>
	<p style="line-height:3em; font-size:14px; float:left;">
      <img src="<%=path %>/images/icon_doc.gif"/>
         附件下载：<a href="<%=path %>/down.action?inputPath=<s:property value="filename"/>"> <s:property value="filename"></s:property> </a> 
         </p>
         </td>

</tr>
	</tbody>
</table>
</s:iterator>
</body>
</html>
