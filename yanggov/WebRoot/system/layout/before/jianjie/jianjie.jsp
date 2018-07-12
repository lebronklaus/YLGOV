<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>杨凌农科</title>

		<link rel="stylesheet" type="text/css"
			href="<%=path%>/shizi/shizicss/reset.css" />
		<link rel="stylesheet" type="text/css"
			href="<%=path%>/shizi/shizicss/style.css" />
		<link rel="stylesheet" type="text/css"
			href="<%=path%>/shizi/shizicss/kjzy_sp.css" />

		<script type="text/javascript"
			src="<%=path%>/shizi/shizijs/jquery1.42.min.js"></script>
		<script type="text/javascript"
			src="<%=path%>/shizi/shizijs/jquery.SuperSlide.2.1.1.source.js"></script>
		<script language="javascript" src="<%=path%>/shizi/shizijs/main.js"></script>
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
				 <a href="/FTMS/pages/Register.jsp" ">农民注册</a>&nbsp;&nbsp;|&nbsp;&nbsp;
<!-- 				 <a href="/FTMS/pages/login/userlogin.jsp">用户登录</a>&nbsp;&nbsp;|&nbsp;&nbsp;
 -->					<a href="/yanggov/connectus.jsp">联系我们</a>
			</div>
		</div>
	</div>	
	<div class="logo">
		<a href=""><img src="<%=path %>/images/logo.png" /></a>
	</div>
</div>

<div class="hang">
	<div class="dao_hang">
		<div class="dao_left">
				<ul>
						<li>
							<a href="<%=path %>/getAllList.action">首页</a>
						</li>
						<li  class="bian">
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
	<div class="xq_left">
		<div class="xq_left_div">
			<div class="xq_div_div1">
				<h1>简介介绍</h1>			
			</div>
			
			<div class="xq_div_div2">
				<ul>
					<li class="qie" style="background:#f0f0f0;">
						<a href="<%=path %>/system/layout/before/jianjie/jianjie.jsp">中心简介</a>					
					</li>
					<li class="li">
						<a href="<%=path %>/system/layout/before/jianjie/zhineng.jsp">中心职能</a>					
					</li>
					 
				</ul>
			</div>
			
					 <div class="xq_left_div3" style=" float: left;">
						<ul>
				<li>
					<a href="../../../../../FTMS/pages/login/userlogin.jsp"><img src="<%=path%>/images/glxt.jpg" /></a>
				</li>
				<li>
					<a href="../../../../../FTMS/pages/login/userlogin.jsp"><img src="<%=path%>/images/ksxt.jpg" /></a>
				</li>			
			</ul>			
					<div style="clear: both;"></div>
				</div>
			<div style="clear:both;"></div>
		</div>
		
		
		<div class="xq_left_div2">
	 		
	
			<div style="clear:both;"></div>
		</div>
		<div class="xq_left_div3">
	 			
			<div style="clear:both;"></div>
		</div>
	</div>
	
	<div class="xq_right">

		<div class="xq_right_div2">
			<div class="xq_div2_div1">
				<div class="xq_div2_top">
					<div class="xq_top_img">
						<img src="<%=path%>/images/xq_wu.png" />
					</div>
					<div class="xq_top_wen">
						<span>您当前位置： 中心简介 > </span>					
					</div>				
				</div>
			</div>
			
			<div class="xq_div2_div2">
				 <div style="width:100%;">
				<div style=""><p style="text-align:center;font-size:25px;height:50px;font-weight:bold;width:500px;margin:auto;">杨凌职业农民培训管理中心简介</p></div>
				<div style="">
				<p style="font-size:15px;margin:auto;text-indent:30px;line-height: 24px;">
				为了解决科技推广最后一公里的问题，培养一批沉在基层、巩固科技推广成果的科技二传手，建立一支“永久牌”的农民土专家队伍，2013年8月示范区管委会在示范区农业科技培训工作的基础上成立了杨凌职业农民培训管理中心，负责示范区现代农业科技培训、对外农业科技培训协调管理、宣传及统计，农民技术职称考试、评定等工作。
				</p>
				<p style="font-size:15px;margin:auto;text-indent:30px;line-height: 24px;">
				自中心成立以来，在对示范区及周边地区农民技术需求和农业产业布局进行全面调研基础上，先后编制印发了《杨凌示范区关于面向旱区开展职业农民培训的实施意见》、《杨凌示范区面向旱区职业农民培训规划（2013-2017）》、《职业农民培训工作流程》以及《职业农民培训工作规范标准》等一系列规范性文件，并修订完善了《杨凌示范区农民技术员职称认定与管理办法》，确立了“杨凌农科”培训工作方针、总体目标、工作任务。
				</p>
				<p style="font-size:15px;margin:auto;text-indent:30px;line-height: 24px;">
				在示范区职业农民培训工作领导小组的领导下，按照“整合培训资源，围绕主导产业，培训职业农民，发展现代农业”的总体思路，坚持“系列系统、分类培训”的原则，采用“走出去和请进来”相结合的培训方式，重点依托杨凌示范区管委会、西北农林科技大学、杨凌职业技术学院在旱区建立的杨凌示范区农业科技示范推广基地、永久性试验示范站等载体，面向旱区大力开展现代农业科技培训，为我省乃至西部干旱半干旱地区现代农业发展、新农村建设、城乡统筹等提供智力支撑和人才保障，初步形成了“杨凌农科”培训品牌。
				</p>
				<p style="font-size:15px;margin:auto;text-indent:30px;line-height: 24px;">
				据统计，近年来以杨凌为基地对全省乡村干部进行轮训，同时面向西部培训农村基层干部、农技人员、大学生村官、合作社负责人和职业农民，累计超过38万人次。全国20个省（市）自治区，105个地市，223个县（区）的12472名农民获得示范区的农民技术职称，成为活跃在田间地头的土专家。1200名杨凌本土农民技术员常年在省内外开展农业科技服务。杨凌示范区农民技术职称证书被广大农民朋友誉为“农业科技的身份证”，受到了广大农民朋友的认可。（数据更新于2017年6月30日）
				</p>
				
 				</div>
			</div>
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
