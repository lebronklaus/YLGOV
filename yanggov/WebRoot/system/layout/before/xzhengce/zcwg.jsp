<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
     <base href="<%=basePath%>">
	    <title>政策文稿</title>
	<link rel="stylesheet" type="text/css" href="shizi/shizicss/kjzy_sp.css" />
	<link rel="stylesheet" type="text/css" href="shizi/shizicss/main.css" />
	
	<script type="text/javascript" src="shizi/shizijs/jquery-1.4.2.js"></script>
	<script language="javascript" src="shizi/shizijs/main.js"></script>
	<script type="text/javascript" src="shizi/shizijs/flexpaper.js"></script>
	<script type="text/javascript" src="shizi/shizijs/flexpaper_handlers.js"></script>
	
	   <style>
    body{
    	width:688px;
    	height:643px;
    	overflow-x : hidden;
    }
    
</style>
</head>
  
  <body>
    <div style="width:100%;height:20%;border-bottom:0px solid grey;">
    	<div class="left_top">
    	<div id="title"><s:property value="zc.title"/></div>
        <div id="writer">政策分类：<s:property value="zcfl"/><span>发布时间：<s:property value="zc.date"/></span></div>
    	</div>
    <!--分割线-->
    <!-- <div class="left_article_line_left"></div> -->
    <div class="left_article_line_right" style="width:660px"></div>
    <!--视频-->
      <input type="hidden" value="<s:property value="wgpath"/>" id="addr"/>
	<div id="documentViewer" class="temp">
		<object classid="clsid:d27cdb6e-ae6d-11cf-96b8-444553540000"
		codebase="http://download.macromedia.com/pub/shockwave/cabs/flash/swflash.cab#version=6,0,0,0" height="100%" width="100%" >
			<param name="wmode" value="opaque"/>
			<param name=movie value="${wgpath}"><param name=quality value=high>
			<embed src="${wgpath}" quality=high  height="500px" width="660px" type="application/x-shockwave-flash" pluginspage="http://www.macromedia.com/go/getflashplayer">
			</embed>
		</object>
	</div>
    </div>
  </body>
</html>
