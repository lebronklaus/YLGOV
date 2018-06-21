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
<style type="text/css">
.tables thead
{
  font-family: "Microsoft YaHei", "微软雅黑", "sans-serif";
  font-weight: bold;
  font-size: 20px;
  text-align:center;

}
.tables tbody
{
font-family: "Microsoft YaHei", "微软雅黑", "sans-serif";
font-size:14px
}
pre {
    display: block;
    padding: 9.5px;
    margin: 0 0 10px;
    font-size: 13px;
    line-height: 1.42857143;
    color: #333;
    word-break: break-all;
    word-wrap: break-word;
    background-color: #fff;
    border: 1px solid #ccc;
    border-radius: 4px;
}
p {
	font-size: 14px;
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>杨凌农科</title>

<link rel="stylesheet" type="text/css" href="shizi/shizicss/reset.css" />
<link rel="stylesheet" type="text/css" href="shizi/shizicss/style.css" />
<link rel="stylesheet" type="text/css" href="shizi/shizicss/kjzy_sp.css" />
<link rel="stylesheet" type="text/css" href="shizi/shizicss/kjzy_ypk_3.css" />

<script type="text/javascript" src="shizi/shizijs/jquery1.42.min.js"></script>
<script type="text/javascript" src="shizi/shizijs/jquery.SuperSlide.2.1.1.source.js"></script>
<script language="javascript" src="shizi/shizijs/main.js"></script>
<script type="text/javascript">
	function gotosearch(){
		var val = $('#val').val();
		$('#search').attr("method","post");
		$('#search').attr("action","./teacher/gotosearch.action?name="+val);
	}
</script>
</head>
<body>

<div class="top">
	<div class="ding">
		<div class="ding_top">
			<div class="ding_aa">
						 <a href="../FTMS/pages/Register.jsp" ">农民注册</a>&nbsp;&nbsp;|&nbsp;&nbsp;
						 <!-- <a href="../FTMS/pages/YuanQiRegister.jsp">园企注册</a>&nbsp;&nbsp;|&nbsp;&nbsp; -->
						 <a href="./connectus.jsp">联系我们</a>
			</div>
		</div>
	</div>	
	<div class="logo">
		<a href=""><img src="images/logo.png" /></a>
	</div>
</div>

<div class="hang">
	<div class="dao_hang">
		<div class="dao_left">
			<ul>
						<li class="bian">
							<a href="<%=path %>/getAllList.action">首页</a>
						</li>
						<li>
							<a href="<%=path %>/system/layout/before/jianjie/jianjie.jsp">中心简介</a>
						</li>
						<li>
							<a href="<%=path %>/system/layout/morenewsdt.action">工作动态</a>
						</li>
						<li>
							<a href="<%=path %>/system/layout/morenews.action">通知公告</a>
						</li>
						<li>
							<a href="<%=path %>/system/layout/morenewszc.action">政策信息</a>
						</li>
						<li>
							<a href="<%=path %>/teacher/peixun.action">培训资源</a>
						</li>
						<li>
							<a href="<%=path %>/system/layout/morenewskx.action">三农快讯</a>
						</li>
						<li>
							<a href="<%=path %>/teacher/xuqiu.action">需求征集</a>
						</li>
						<li>
							<a href="<%=path %>/teacher/yuanqi.action">园企信息</a>
						</li>
					</ul>	
		</div>		
		<div class="dao_right">
					<form id="search" action="">
						<input id="val" class="sub" />
						<input class="sou" type="submit" value="搜索" onclick="gotosearch()" />
					</form>
		</div>
	</div>
	<div style="clear:both;"></div>
</div>

<!-- 网页内容                     ----------------------------------------  -->
<div class="xq_zhong_3">
		<div class="xq_div2_div1_3">
				<div class="xq_div2_top">
					<div class="xq_top_img">
						<img src="images/xq_wu.png" />
					</div>
					<div class="xq_top_wen_3">
						<span>您当前位置： 培训资源 ><a id ="peixun">广播演讲稿</a></span>					
					</div>				
				</div>
		</div>
	  <div style="width:100%;height:20%;">
			<table class="tables" style="width: 100%;  margin-top:10px">
				<thead>
					<tr>
						<td><s:property value="tzhi.resources_title"></s:property></td>
					</tr>
				</thead>
			</table>

			<div 
				style="  width:100%;height: 20px; line-height: 20px;  margin-top: 10px;   font-size: 12px;  color: #6d6d6d; text-align: center;">
				<span>作者：</span>
				<s:property value="tzhi.resources_author" />&nbsp;|
				<span>发布日期：</span>
				<s:property value="tzhi.resources_time" />&nbsp;|
				<span>广播来源：</span>
				<s:property value="tzhi.resources_from" />
			</div>
			<!--分割线-->
    <div class="left_article_line_right" style="width:1178px;"></div>
    <div style="height:30px"></div>
     <script>
       var addr=window.location.protocol+'//'+window.location.host+'/transfer/';
    </script>
    <!--音频--><!-- param和embed的值都要改 -->
    <object class="audio" classid="clsid:D27CDB6E-AE6D-11cf-96B8-444553540000" codebase="http://download.macromedia.com/pub/shockwave/cabs/flash/swflash.cab#version=7,0,19,0" width="800px" height="50px">
      <param name="movie" value="shizi/3.swf?soundFile=<s:property value="videopath"/>&bg=0xCDDFF3&leftbg=0x357DCE&lefticon=0xF2F2F2&rightbg=0x357DCE&rightbghover=0x4499EE&righticon=0xF2F2F2&righticonhover=0xFFFFFF&text=0x357DCE&slider=0x357DCE&track=0xFFFFFF&border=0xFFFFFF&loader=0x8EC2F4&autostart=no&loop=no" />
      <param name="quality" value="high" />
      <param value="transparent" name="wmode" />
      <embed src="shizi/3.swf?soundFile=<s:property value="path"/>&bg=0xCDDFF3&leftbg=0x357DCE&lefticon=0xF2F2F2&rightbg=0x357DCE&rightbghover=0x4499EE&righticon=0xF2F2F2&righticonhover=0xFFFFFF&text=0x357DCE&slider=0x357DCE&track=0xFFFFFF&border=0xFFFFFF&loader=0x8EC2F4&autostart=no&loop=no" width="1024px" height="50px" quality="high" pluginspage="http://www.macromedia.com/go/getflashplayer" type="application/x-shockwave-flash"></embed>
  	</object>
   
  
  
    <!--简介-->
    <div id="info">
    	<div class="title">内容简介</div>
        <!-- <pre style="display: block;border-radius: 4px;line-height: 20px;padding-left: 10px; border: dashed 1px #cacaca; white-space: pre-wrap; white-space: -moz-pre-wrap; white-space: -pre-wrap; white-space: -o-pre-wrap; word-spacing: break-word;"> -->
        <div style="display: block;line-height: 20px;    padding: 9.5px;padding-left: 10px; border: dashed 1px #cacaca;border-radius: 4px;font-size: 14px;font-family: 微软雅黑;" >
	        <s:property value="tzhi.resources_profile" escape="false"/>
        </div>
    </div>
  </div>
  
</div>
<div style="clear:both;"></div>


<div class="di">
	<p>Copyright ◎ 2016 杨凌农科培训综合信息服务平台All Rights Reserved</p>
	<p>联系电话：029-87036420    87036412  邮政编码：712100  联系地址：杨凌示范区新桥北路政务大厦</p>
</div>

<!--lunbo------->
<script type="text/javascript">
		jQuery(".slideBoxx").slide({mainCell:".bd ul",autoPlay:true});
</script>
<!--lunbo------->


<!--------文字上下滚动-------------->


<script type="text/javascript">
	jQuery(".xq_left_div2").slide({mainCell:".xq_div1_div2 ul",autoPlay:true,effect:"topMarquee",vis:6,interTime:50});
</script>

</body>
</html>
