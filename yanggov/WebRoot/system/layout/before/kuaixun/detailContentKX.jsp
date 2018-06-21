<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib uri="/struts-tags" prefix='s' %>
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
     <s:iterator value="post7">
 <table class="tables" style="width: 90%;">
   
       <thead>
       <tr>
       <td>
	<s:property 	value="title"></s:property>
	</td>
	</tr>
	
	</thead>
	</table>
	
	<div class="author" style="  width: 90%;;height: 35px;    line-height: 35px; border-bottom: #e3e3e3 solid 1px ;  margin-top: 15px;   font-size: 12px;  color: #6d6d6d;
    text-align: center;" >
  <span>作者：</span><s:property  value="author"/>
   <span   >发布日期：</span><s:property value="date"/>  
 
   
</div>
  
	
	<table class="tables">
	<tbody>

 
	<tr>
	<td>
	<pre style="line-height:28px;">
	<s:property 	value="text" escape="false"></s:property>
</pre>
	</td>
	</tr>
	</tbody>
</table>
</s:iterator>
</body>
</html>
