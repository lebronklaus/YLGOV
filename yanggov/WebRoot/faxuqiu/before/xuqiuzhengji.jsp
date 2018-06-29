<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
/* String basePath = request.getScheme()+"://"+request.getServerName()+path+"/"; */
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<base href="<%=basePath%>"/>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>杨凌农科</title>

<link rel="stylesheet" type="text/css" href="shizi/shizicss/reset.css" />
<link rel="stylesheet" type="text/css" href="shizi/shizicss/style.css" />

<script type="text/javascript" src="shizi/shizijs/jquery1.42.min.js"></script>
<script type="text/javascript" src="shizi/shizijs/jquery.SuperSlide.2.1.1.source.js"></script>
<script language="javascript" type="text/javascript"> 
	$(document).ready(function(){ 
	
	$("#rightFrm").load(function(){ 
	$(this).height(0); //用于每次刷新时控制IFRAME高度初始化 
	var height = $(this).contents().height() ; 
	$(this).height( height < 921 ? 921 : height );
	}); 
	changebg(peixun); 
/* 	$("#peixunlist").show();
	$("#rencailist").hide();
	$("#jishulist").hide(); */
}); 
function changebg(var1){
	if(var1==peixun){
		$("#peixun").css("background","#f0f0f0");
		$("#rencai").css("background","#fff");
		$("#jishu").css("background","#fff");

	}else if(var1 == rencai  ){
		$("#peixun").css("background","#fff");
		$("#rencai").css("background","#f0f0f0");
		$("#jishu").css("background","#fff");
		
	}else if(var1== jishu){
		$("#peixun").css("background","#fff");
		$("#rencai").css("background","#fff");
		$("#jishu").css("background","#f0f0f0");

		}
}
function train(){
	changebg(peixun);
	$('#rightFrm').attr("src","peixunsearch.action");
	$('#xuqiu').html("培训需求");
	$('#listframe').attr("src","goPeiXun.action");

	
}
function master(){
	changebg(rencai);
	$('#rightFrm').attr("src","rencaisearch.action");
	$('#xuqiu').html("人才需求");
	$('#listframe').attr("src","goRenCai.action");

	
}
function tech(){
	changebg(jishu);
	$('#rightFrm').attr("src","jishusearch.action");
	$('#xuqiu').html("技术需求");
	$('#listframe').attr("src","goJiShu.action");

}
</script>
<script type="text/javascript">
	function gotosearch(){
		var val = $('#val').val();
		$('#search').attr("method","post");
		$('#search').attr("action","/teacher/gotosearch.action?name="+val);
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
		<a href="javascript:void(0)"><img src="images/logo.png" /></a>
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


<div class="xq_zhong">
	<div class="xq_left" style="height: 1000px;">
		<div class="xq_left_div">
			<div class="xq_div_div1">
				<h1>需求分类</h1>
			</div>
			
			<div class="xq_div_div2">
				<ul>
					<li id="peixun"class="qie">
						<a id="res" href="javascript:void(0)" onclick="train()">培训需求</a>					
					</li>
					<li id="rencai"class="li">
						<a id="base" href="javascript:void(0)" onclick="master()">人才需求</a>					
					</li>
					<li id="jishu">
						<a id="tea" href="javascript:void(0)" onclick="tech()">技术需求</a>					
					</li>
				</ul>
			</div>
			<div style="clear:both;"></div>
		</div>
		
		 
		 <iframe id ="listframe" src="goPeiXun.action" name="listFrame"  frameborder="0" scrolling="no" width="100%" height="352px"></iframe>
		 		 
		
		<div class="xq_left_div3">
			<ul>
				<li>
					<a href="../FTMS/pages/login/userlogin.jsp"><img src="images/glxt.jpg" /></a>
				</li>
				<li>
					<a href="../FTMS/pages/login/userlogin.jsp"><img src="images/ksxt.jpg" /></a>
				</li>			
			</ul>			
			<div style="clear:both;"></div>
		</div>
	</div>
	
	<div class="xq_right">
		<%-- <div id="slideBoxx" class="slideBoxx">			
			<div class="bd">
				<ul>
					<li>
						<a href=" " target="_blank"><img src="images/xq_lun.jpg"/></a>
						<div class="xq_tou">
							<span>郭社荣主持召开2016年第7次党工委管委会班子会议 </span>
						</div>
					</li>
					
					<li>
						<a href=" " target="_blank"><img src="images/xq_lun.jpg"/></a>
						<div class="xq_tou">
							<span>2郭社荣主持召开2016年第7次党工委管委会班子会议 </span>
						</div>
					</li>
					
					<li>
						<a href=" " target="_blank"><img src="images/xq_lun.jpg"/></a>
						<div class="xq_tou">
							<span>3郭社荣主持召开2016年第7次党工委管委会班子会议 </span>
						</div>
					</li>
					
				</ul>
			</div>

			<!-- 下面是前/后按钮代码，如果不需要删除即可 -->
			<a class="prev" href="javascript:void(0)"></a>
			<a class="next" href="javascript:void(0)"></a>

		</div> --%>
		
		
		
		
		
		<div class="xq_right_div2">
			<div class="xq_div2_div1">
				<div class="xq_div2_top">
					<div class="xq_top_img">
						<img src="images/xq_wu.png" />
					</div>
					<div class="xq_top_wen">
						<span>您当前位置：需求征集 > <a id ="xuqiu">培训需求</a></span>					
					</div>				
				</div>
			</div>
			
			<div class="xq_div2_div2">
				<iframe id ="rightFrm" src="peixunsearch.action" name="rightFrm"  frameborder="0" scrolling="no" width="100%" height="100%"></iframe>
			</div>
			<div style="clear:both;"></div>
		</div>
	</div>	
	<div style="clear:both;"></div>
</div>



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
