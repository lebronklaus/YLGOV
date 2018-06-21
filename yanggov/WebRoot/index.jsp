<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@  taglib uri="/struts-tags" prefix="s"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		
		<title>杨凌农科</title>

		<link rel="stylesheet" type="text/css"
			href="<%=path%>/shizi/shizicss/reset.css" />
		<link rel="stylesheet" type="text/css"
			href="<%=path%>/shizi/shizicss/style.css" />



		<script type="text/javascript"
			src="<%=path%>/shizi/shizijs/jquery1.42.min.js"></script>
		<script type="text/javascript"
			src="<%=path%>/shizi/shizijs/jquery.SuperSlide.2.1.1.source.js"></script>
	
<%-- <script >
	 window.onload = function (){ 
	
	var host = "http://"+window.location.host+"/yanggov/getAllList.action";
	window.location.href=host;
	
	} 
</script>  --%>
 <script type="text/javascript">
	$(document).ready(function(){
		var host = "http://"+window.location.host;
		$("#zj1").attr("href",host+"/yanggov/teacher/teaspe.action?teacher_id=104");
		$("#zj2").attr("href",host+"/yanggov/teacher/teaspe.action?teacher_id=159");
		$("#zj3").attr("href",host+"/yanggov/teacher/teaspe.action?teacher_id=225");
		$("#zj4").attr("href",host+"/yanggov/teacher/teaspe.action?teacher_id=196");
		$("#zj5").attr("href",host+"/yanggov/teacher/teaspe.action?teacher_id=72");
		
	});
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
				<a href=""><img src="images/logo.png" />
				</a>
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
			<div style="clear: both;"></div>
		</div>
		<div class="zhong">
			<div class="zhong_bu">
				<div class="ind_div1">
					<div class="ind_left">
						<div id="slideBox" class="slideBox" style="width:598px;height:427px;">
							<div class="hd">
								<ul>
									<li>
										1
									</li>
									<li>
										2
									</li>
									<li>
										3
									</li>
									<li>
										4
									</li>
									<li>
										5
									</li>
								</ul>
							</div>
							<div class="bd">
						 	
						 	<ul>
									<s:iterator value="listim">
										<li style="overflow: hidden;">
									 
										 <a	href="system/layout/addMoreNewssdt.action?id=<s:property value='dtid'/>"
												target="_blank"> <img src="<%=basePath%>uploadzc/<s:property value="image" ></s:property>"/>
											</a>
										 <div class="ind_tou">
											<span><s:property value="title" /></span>
										</div>
										</li>
									</s:iterator>
							</ul>

							</div>
						</div>
					</div>
					<div class="ind_right" style="width:500px;">
						<div class="slideTxtBox">
							<div class="hd" >
								<ul>
									<li>
										<a href="<%=path %>/system/layout/morenewsdt.action">工作动态</a>
									</li>
					 
									<li>
										<a href="<%=path %>/system/layout/morenewskx.action">三农快讯</a>
									</li>
									<li>
										<a href="<%=path %>/system/layout/morenewszc.action">政策信息</a>
									</li>
									<li>
										<a href="<%=path %>/system/layout/morenewszc.action">资料下载</a>
									</li>
								</ul>
 								
							</div>
 
							<div class="bd" style="padding-top: 10px;">
								<ul>
									<s:iterator value="list1">
										<li style="overflow: hidden;">
											<div class="img">
												<img src="images/dian.jpg" />
											</div>
											<span class="date"><s:property value="date" /></span><a
												href="system/layout/addMoreNewssdt.action?id=<s:property value='dtid'/>"
												target="_blank"> <s:property value="title" />
											</a>
										</li>
									</s:iterator>
									 
								</ul>

								<ul>
									<s:iterator value="list5">
										<li style="overflow: hidden;">
											<div class="img">
												<img src="images/dian.jpg" />
											</div>
											<span class="date"><s:property value="date" /></span><a
												href="system/layout/addMoreNewsskx.action?id=<s:property value='kxid'/>"
												target="_blank"><s:property value="title" /> </a>
										</li>
									</s:iterator>
								</ul>

								<ul>
									<s:iterator value="list3">
										<li style="overflow: hidden;">
											<div class="img">
												<img src="images/dian.jpg" />
											</div>
											<span class="date"><s:property value="date" /></span><a
												href="system/layout/addMoreNewsszc.action?id=<s:property value='zcid'/>"
												target="_blank"><s:property value="title" /> </a>
										</li>
									</s:iterator>
								</ul>
							</div>
						</div>
					</div>
				</div>



				<div class="ind_div2">
					<div class="ind_div1_lie">
						<div class="ind_lie_tong">
							<div class="lie_tong_left">
								<ul>
									<li class="bei">
										<a href="">通知</a>
									</li>
									<li>
										<a href="">公告</a>
									</li>
								</ul>
							</div>
							<div class="lie_tong_right">
								<span>———————————————————<a href="<%=path %>/system/layout/morenews.action">更多>></a>
								</span>
							</div>
						</div>
						<div class="ind_lie_div1">
							<ul>
								<s:iterator value="list">
									<li style="overflow: hidden;float:left; width:380px;">
										<div class="img">
											<img src="images/dian.jpg" />
										</div>
										<div class="wen">
<!-- 										<div> -->
									<span  style="float: right;padding-left:10px;"><s:property value="date" /></span>
											<a 
												href="system/layout/addMoreNewss.action?id=<s:property value='id'/>"><s:property
													value="title" />
											</a>
											
<!-- 											</div> -->
										</div>
									</li>
								</s:iterator>
							</ul>
						</div>
						<div style="clear: both;"></div>
					</div>

					<div class="ind_div1_lie1">
						<div class="ind_lie_tong1">
							<div class="lie_tong_left">
								<ul>
									<li class="bei">
										<a href="">园企</a>
									</li>
									<li>
										<a href="">信息</a>
									</li>
								</ul>
							</div>
							<div class="lie_tong_right">
								<span>————————————————<a href="<%=path %>/teacher/yuanqi.action">更多>></a>
								</span>
							</div>
						</div>
						<div class="ind_lie_div1">
							<ul>
								<s:iterator value="tealist">
									<li style="overflow: hidden;">
										<div class="img">
											<img src="images/dian.jpg" />
										</div>
										<div class="wen">
										<span  style="float: right;padding-left:7px;"><s:property value="time" /></span>
											<a
												href="qiyespe.action?base_id=<s:property value='id'/>"><s:property value='name'/>
											</a>
										</div>
									</li>
								</s:iterator>
							</ul>
						</div><!--  -->

					</div>
					<div class="ind_div1_tu">
						<ul>
							<li>
								<a href="../FTMS/pages/login/userlogin.jsp"><img src="images/glxt.jpg" />
								</a>
							</li>
							<li class="li2">
								<a href="../FTMS/pages/login/userlogin.jsp"><img src="images/ksxt.jpg" />
								</a>
							</li>
						</ul>
					</div>
				</div>

				<div class="ind_div3">
					<div class="ind_div3_xiao">
						<ul>
							<li>
								<a href="<%=path %>/teacher/xuqiu.action"><img style="height:99px;width: 260px;"  src="images/xqzj.jpg" />
								</a>
							</li>

							<li class="li">
								<a href="../FTMS/pages/login/userlogin.jsp">
									<div class="li_left">
										<span>培训需求</span>
									</div>
									<div class="li_right">
										<img src="images/li1.png" />
									</div> </a>
							</li>


							<li class="li">
								<a href="../FTMS/pages/login/userlogin.jsp">
									<div class="li_left">
										<span>技术需求</span>
									</div>
									<div class="li_right">
										<img src="images/li2.png" />
									</div> </a>
							</li>


							<li class="li">
								<a href="../FTMS/pages/login/userlogin.jsp">
									<div class="li_left">
										<span>人才需求</span>
									</div>
									<div class="li_right">
										<img src="images/li3.png" />
									</div> </a>
							</li>
						</ul>
						<div style="clear: both;"></div>
					</div>
					<div class="ind_div3_xue">
						<img style="width:1128px;height:120px;" src="images/zhicheng.jpg" />
					</div>
					<div style="clear: both;"></div>
				</div>

				<div class="ind_div4">
					<div class="ind_div4_jie">
						<h1>
							&nbsp;&nbsp;知名专家
							<a href="./zjpeixun.jsp">更多>></a>
						</h1>
					</div>

				<div class="ind_div4_lie">
				<ul class="ind_lie_ul">
					<li><A id="zj1" href="">
						<div class="img"><img  style="height:127px;width: 192px;" src="images/zj1.jpg"/></div>						
						<div class="wen">
							<h1>水利专家：张广军</h1>
							<p>潜心林业、水土保持与荒漠化防治等领域的工作...</p>						
						</div></A>
					</li>
					
					<li class="le"><A id="zj2" href="">
						<div class="img"><img style="height:127px;width: 192px;"  src="images/zj2.jpg"/></div>						
						<div class="wen">
							<h1>林学专家：彭长辉</h1>
							<p>在全球变化、陆地生态系等方面已取得国际公认的研究成果...</p>						
						</div></A>
					</li>
					
					<li class="le"><A id="zj3" href="">
						<div class="img"><img style="height:127px;width: 192px;"  src="images/zj3.jpg"/></div>						
						<div class="wen">
							<h1>果树专家：王西平</h1>
							<p>主要从事果树生物技术与育种研究工作...</p>						
						</div></A>
					</li>
					
					<li class="le"><A id="zj4" href="">
						<div class="img"><img style="height:127px;width: 192px;"  src="images/zj4.jpg"/></div>						
						<div class="wen">
							<h1>食品专家：刘学波</h1>
							<p>长期从事食品加工、发酵工程、微生物选育等方面的研究...</p>						
						</div></A>
					</li>
					
					<li class="le"><A id="zj5" href="">
						<div class="img"><img style="height:127px;width: 192px;"  src="images/zj5.jpg"/></div>						
						<div class="wen">
							<h1>植保专家：康振生</h1>
							<p>一直以病原真菌与寄主小麦的互作关系为主攻方向...</p>						
						</div></A>
					</li>
				</ul>
				<div style="clear:both;"></div>
			</div>	
				</div>
				<div style="clear: both;"></div>
			</div>
		</div>
 
		<div class="di" id="di"> 
			<p>
						<a href="javascript:void(0) ">友情链接：</a>&nbsp;&nbsp;|&nbsp;&nbsp;
						<a href="http://www.yangling.gov.cn/" ">杨凌示范区管委会</a>&nbsp;&nbsp;|&nbsp;&nbsp;
						<a href="http://www.ylppc.com/">杨凌示范区生产力促进中心</a>&nbsp;&nbsp;|&nbsp;&nbsp;
						<a href="http://kjj.yangling.gov.cn/" ">杨凌科学技术局</a>&nbsp;&nbsp;|&nbsp;&nbsp;
						<a href="http://xxzx.yangling.gov.cn/">杨凌示范区科技信息中心</a>&nbsp;&nbsp;|&nbsp;&nbsp;
						<a href="http://www.nwsuaf.edu.cn" ">西北农林科技大学</a>&nbsp;&nbsp;|&nbsp;&nbsp;
						<a href="http://www.ylvtc.cn/">杨凌职业技术学院</a>&nbsp;&nbsp;|&nbsp;&nbsp;
						<a href="http://fzggj.yangling.gov.cn/ ">杨凌示范区发展和改革局</a>
			</p>
			<p>
				Copyright ◎ 2016 杨凌农科培训综合信息服务平台All Rights Reserved
			</p>
			<p >
				联系电话：029-87036420 87036412 邮政编码：712100 联系地址：杨凌示范区新桥北路政务大厦&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			
			</p>
			<p>
				 <img src="images/iconfont-peiziiconfont09.png" class="wangke"/>
				<img class="change" style="height:100px;width:100px;display:none;"src="images/apkdown.jpg"/> 
			</p>
		</div>

 	 
		<!--首页图片轮播--->
		<script type="text/javascript">
	jQuery(".slideBox").slide({mainCell:".bd ul",autoPlay:true});
</script>
		<!--首页轮播结束--->
		<!--多标签切换----->
		<script type="text/javascript">jQuery(".ind_right").slide();</script>

		<!--多标签切换----->
		<script type="text/javascript">
		
		$(function()
		{
		$(".wangke").bind("mouseover",function(){
		 
		  if($(".change").is(":visible"))
		  {
		 	$(".change").hide();
		  }
		  else
		  {
		 	 $(".wangke").hide();
			 $(".change").css
		 		({
				 height:100+"px",
				 width:100+"px"
				 }).show();
		  }
		 
		}) 
		
		}
		);

		</script>
		
		
		
	</body>
</html>
