<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<!-- saved from url=(0045)http://nmpx.yangling.gov.cn/sort.php?sortid=5 -->
<html xmlns="http://www.w3.org/1999/xhtml"><head><meta http-equiv="Content-Type" content="text/html; charset=GBK">
<title>杨凌农业科技培训服务平台 - 政策信息 </title>
<meta name="keywords" content="">
<meta content="" name="description">
<link rel="stylesheet" href="../../zhengce/base.css" type="text/css" media="all">
	<link rel="stylesheet" href="../../zhengce/page.css" type="text/css" media="all">
	<link rel="stylesheet" href="../../zhengce/dongtai.css" type="text/css" media="all">
 
<meta name="copyright" content="Copyright 2010 "> 
<meta name="Author" content=""> 
<meta name="Keywords" content=""> 
<meta name="Description" content="">
 <script language="JavaScript"> 
<!--
function MM_jumpMenu(targ,selObj,restore){ //v3.0
  eval(targ+".location='"+selObj.options[selObj.selectedIndex].value+"'");
  if (restore) selObj.selectedIndex=0;
}
 
function h(obj,url){obj.style.behavior='url(#default#homepage)';obj.setHomePage(url);}
// -->
</script>

<style type="text/css">

.tables  thead 
{
  font-family: "Microsoft YaHei", "微软雅黑", "sans-serif";
  font-weight: bold;
  font-size: 20px;
   text-align:center;
}
.tables tbody
{
font-family: "Microsoft YaHei", "微软雅黑", "sans-serif";
//line-height:30px;
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

<!--[if IE 6]>
<style type="text/css"> 
	li{list-style:none;}
</style>
<![endif]-->


<style type="text/css"></style></head>
<body><div class="container">
<div class="header">
	<div class="banner">
		<div class="banner_l l">
			<img src="../../zhengce/index_01.gif" alt="杨凌农业科技培训服务平台">
		</div>
		<div class="banner_r r">
			<p><a href="http://nmpx.yangling.gov.cn/sort.php?sortid=5#" onclick="h(this,'http://nmpx')" target="_blank">设为首页</a><a onclick="window.external.AddFavorite('http://nmpx','杨凌农业科技培训服务平台')" href="javascript:;">加入收藏</a><a href="http://nmpx.yangling.gov.cn/show.php?articleid=80">联系我们</a></p>
			<ul>
				<li>关键词</li>
				<li><form action="http://nmpx.yangling.gov.cn/search.php" method="get">
					<input type="text" name="keyword" class="text">
<input type="hidden" name="action" value="result">
					<input type="submit" name="submit" class="submit" value="搜索">
					<!--<button type="submit"></button>-->
				</form></li>
			</ul>
		</div>
	</div>
	<div class="nav">
	<ul>
			<li style="margin-left:60px;display:inline"><a href="<%=path %>/getAllList.action">首页</a></li>
			<li><a href="JavaScript:void(0);">中心简介</a></li>
			<li><a href="<%=path %>/system/layout/morenewsdt.action">工作动态</a></li>
			<li><a href="<%=path %>/system/layout/morenews.action">通知公告</a></li>
			<li><a href="<%=path %>/peixun.jsp">培训资源</a></li>
			<li><a href="<%=path %>/system/layout/morenewszc.action">政策信息</a></li>
			<li><a href="<%=path %>/system/layout/morenewskx.action">三农快讯</a></li>
			<li><a href="<%=path %>/xuqiuzhengji.action?qt=1">需求征集</a></li>
			<li><a href="<%=path %>/faxuqiu/yuanqi/yuanqi.jsp">园企信息</a></li>
			
			</ul>						</div>
</div>

<div class="main">
		<div class="right">
			<p class="title">您现在的位置：<a href="http://nmpx.yangling.gov.cn/index.php">首页</a> &gt; <a href="../../zhengce/杨凌农业科技培训服务平台 - 政策信息.html">政策信息</a></p>
<div class="content" style="height: auto;margin:auto; overflow:scroll;">	
   <s:iterator value="list4">
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


<div class="pagenav">

         
</div>
<br class="clearfloat">
</div>
		</div>
		<div class="left">
			<h2>政策信息</h2>
			<img src="../../zhengce/left_05.gif" alt="">
			<div class="left_cont">
				<ul>
					<li><a href="<%=path %>/system/layout/fzszcnews.action?mark=0" target="right">中省政策</a></li>
					<li><a href="<%=path %>/system/layout/fylzcnews.action?mark=1" target="right">杨凌政策</a></li>
					
		</ul>
			</div>
			<p><a href="../../../../../FTMS/pages/login/userlogin.jsp"><img src="../../zhengce/index_45.gif" alt="农民远程教育培训"></a><br><a href="../../../../../FTMS/pages/login/userlogin.jsp"><img src="../../zhengce/index_54.gif" alt="农技师自主能力测试题库"></a></p>
		</div>
	</div>
<div class="footer l mt10">
	<h2></h2>
	<p>主办：杨凌职业农民培训中心&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;电话：029-87036420</p>
			<p>地址：陕西省杨凌示范去新桥北路政务大厦一楼&nbsp;&nbsp;</p>
</div>
</div><!-- TPL: 栏目页_政策信息 --></body></html>