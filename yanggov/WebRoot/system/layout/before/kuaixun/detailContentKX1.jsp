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
	<link href="<%=path %>/shizi/shizicss/bootstrap.min.css" rel="stylesheet"/>
    <link href="<%=path %>/shizi/shizicss/new.css" rel="stylesheet"/>
    <link href="<%=path %>/shizi/shizicss/font-awesome.min.css" rel="stylesheet"/>
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
font-size:14px;
text-align:center
}
.tables td{
	height:30px
}
.tables td img
{
width:598px; height:427px; text-align:center;
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
    
    border-radius: 4px;

	white-space:pre-wrap;
	white-space:-moz-pre-wrap;
	white-space:-pre-wrap;
	white-space:-o-pre-wrap;
	word-wrap:break-word;

}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>杨凌农科</title>

<link rel="stylesheet" type="text/css" href="<%=path %>/shizi/shizicss/reset.css" />
<link rel="stylesheet" type="text/css" href="<%=path %>/shizi/shizicss/style.css" />
<link rel="stylesheet" type="text/css" href="<%=path %>/shizi/shizicss/kjzy_sp.css" />

<script type="text/javascript" src="<%=path %>/shizi/shizijs/jquery1.42.min.js"></script>
<script type="text/javascript" src="<%=path %>/shizi/shizijs/jquery.SuperSlide.2.1.1.source.js"></script>
<script language="javascript" src="<%=path %>/shizi/shizijs/main.js"></script>
			<script type="text/javascript">
function gotosearch(){
		var val = $('#val').val();
		$('#search').attr("method","post");
		var host = "http://"+window.location.host+"/yanggov/teacher/gotosearch.action?name="+val;
		console.log(host);
		$('#search').attr("action",host);
	}
</script>
</head>
<body>

<div class="top">
	<div class="ding">
		<div class="ding_top">
			<div class="ding_aa">
					<a href="../FTMS/pages/Register.jsp"">农民注册</a>&nbsp;&nbsp;|&nbsp;&nbsp;
					<!-- <a href="../FTMS/pages/YuanQiRegister.jsp">园企注册</a>&nbsp;&nbsp;|&nbsp;&nbsp; -->
					<a href="./connectus.jsp">联系我们</a>
			</div>
		</div>
	</div>	
	<div class="logo">
		<a href=""><img src="<%=path %>/images/logo.png" /></a>
	</div>
</div>

<div class="hangsj">
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
						<img src="<%=path %>/images/xq_wu.png" />
					</div>
					<div class="xq_top_wen_3">
						<span>您当前位置：资源内容> <a id ="peixun">三农快讯</a></span>					
					</div>				
				</div>
		</div>
	  <div style="width:100%;">
	 
 
	    <s:iterator value="post7">
 <table class="tables" style="width: 100%; text-align: center;">
   
       <thead>
       <tr>
       <td>
	<s:property 	value="title"></s:property>
	</td>
	</tr>
	
	</thead>
	</table>
	
	<div class="author" style="  width: 100%;;height: 35px;    line-height: 35px;    border-bottom: 2px solid #007cc1;  margin-top: 15px;   font-size: 12px;  color: #6d6d6d;
    text-align: center;" >
  <span>作者：</span><s:property  value="author"/>&nbsp;|&nbsp;
   <span   >发布日期：</span><s:property value="date"/>  

</div>
  
	
	<table class="tables">
	<tbody>

 
	<tr>
	<td>
	<div style="margin:10px;border-radius: 4px;text-align: left;text-indent: 20px;border: solid 0px #ccc;font-size: 14px;font-family: 微软雅黑;line-height:28px;margin:10px;">
<!-- 	<pre style="line-height:28px;text-indent: 20px;text-align: left;border: solid 0px #ccc;"> -->
	<s:property 	value="text" escape="false"></s:property>
<!-- </pre> -->
</div>
	</td>
	</tr>
	</tbody>
</table>
</s:iterator>
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
