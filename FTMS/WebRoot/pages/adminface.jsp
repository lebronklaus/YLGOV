<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>pages/">
    
    <title>My JSP 'adminface.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link rel="stylesheet" type="text/css" href="../css/SyntaxHighlighter.css">
    
	<script type="text/javascript" src="../js/jquery.min.js"></script>
	<script type="text/javascript" src="../js/lib/raphael-min.js"></script>
	<script type="text/javascript" src="../js/res/chinaMapConfig.js"></script>
	<script type="text/javascript" src="../js/res/worldMapConfig.js"></script>
	<script type="text/javascript" src="../js/map.js"></script>
    
    <style>
body{ padding:0;margin:0; height:100%;width:auto}
html{ height:100%;width:auto} 
#main {
	width: auto;
	margin: auto;
}
span{
	font-size:24px;
	font-family:"微软雅黑";
}
.stateTip, #StateTip{display:none; position:absolute; padding:8px; background:#fff; border:2px solid #2385B1; -moz-border-radius: 4px; -webkit-border-radius: 4px; border-radius: 4px; font-size:12px; font-family:Tahoma; color:#333;}

.mapInfo i{ display:inline-block; width:15px; height:15px; margin-top:5px; line-height:15px; font-style:normal; background:#aeaeae; color:#fff; font-size:11px; font-family: Tahoma; -webkit-border-radius:15px; border-radius:15px; text-align:center}
.mapInfo i.active{background:#E27F21;}
.mapInfo span{ padding:0 5px 0 3px;}
.mapInfo b{ font-weight:normal; color:#2770B5}
	</style>
    <script type="text/javascript">
    $(function(){$('#ChinaMap').SVGMap({
    mapName: 'china',
    mapWidth: 600,
    mapHeight: 500,
    clickCallback: function(stateData, obj){
    	   $(function(){parent.shengfen(obj.name);})
       }
    
});})
    </script>
</head>

<body>
	<div id="main">
    	 <div class="items" id="Item0" align="center">
              <a href="javascript:;" class="fold"></a>
              <div class="itemCon">
                  <div id="ClickCallback" style="font-size:14px; color:red"></div>
                  <div id="ChinaMap"></div>
              </div>
          </div>
         <div align="center"><span >（可视化显示全国各省分获得证书情况）</span></div>
    </div>
</body>
</html>

