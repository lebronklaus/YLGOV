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
					<a href="../FTMS/pages/Register.jsp"">农民注册</a>&nbsp;&nbsp;|&nbsp;&nbsp;
					<!-- <a href="../FTMS/pages/YuanQiRegister.jsp">园企注册</a>&nbsp;&nbsp;|&nbsp;&nbsp; -->
					<a href="/yanggov/connectus.jsp">联系我们</a>
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
										<li >
							<a href="<%=path %>/getAllList.action">首页</a>
						</li>
						<li class="bian">
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
					<li class="qie">
						<a href="<%=path %>/system/layout/before/jianjie/jianjie.jsp">中心简介</a>					
					</li>
					<li class="li" style="background:#f0f0f0;">
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
						<span>您当前位置： 中心职能 > </span>					
					</div>				
				</div>
			</div>
			
			<div class="xq_div2_div2">
				 <div style="width:100%;">
				<div style=""><p style="text-align:center;font-size:25px;height:50px;font-weight:bold;width:500px;margin:auto;">杨凌职业农民培训管理中心职能</p></div>
				<div style="">
				<p style="font-size:15px;margin:auto;text-indent:30px;line-height: 24px;">
				一、负责统筹区内各类培训资源，建立健全职业农民培训各项工作制度，鼓励支持有关企、事业单位，积极开展立足杨凌，面向旱区的职业农民培训工作；
				</p>
				<p style="font-size:15px;margin:auto;text-indent:30px;line-height: 24px;">
				二、负责制定示范区及面向旱区的职业农民培训规划，研究提出有关加强职业农民培训的政策建议；
				</p>
				<p style="font-size:15px;margin:auto;text-indent:30px;line-height: 24px;">
				三、在示范区职业农民培训工作领导小组的领导下，负责示范区农民培训年度目标任务的分解、下达，有关农民培训项目的管理、检查和考核等；
				</p>
				<p style="font-size:15px;margin:auto;text-indent:30px;line-height: 24px;">
				四、负责杨凌示范区农民技术职称的考评、发证、管理、人才推介等工作；
				</p>
				<p style="font-size:15px;margin:auto;text-indent:30px;line-height: 24px;">
				五、负责示范区职业农民培训的信息统计、宣传、考核、表彰等工作；
				</p>
				<p style="font-size:15px;margin:auto;text-indent:30px;line-height: 24px;">
				六、负责面向区外有关农民培训的联络、组织、交流等工作。
				</p>
				<p style="font-size:15px;margin:auto;text-indent:30px;line-height: 24px;">
				联系地址：陕西杨凌示范区新桥北路政务大厦一楼      联系电话：029-87036420（传真）
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
