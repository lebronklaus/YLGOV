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
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>杨凌农科</title>

<link rel="stylesheet" type="text/css"
	href="<%=path%>/shizi/shizicss/reset.css" />
<link rel="stylesheet" type="text/css"
	href="<%=path%>/shizi/shizicss/style.css" />

<script type="text/javascript"
	src="<%=path%>/shizi/shizijs/jquery1.42.min.js"></script>
<script type="text/javascript"
	src="<%=path%>/shizi/shizijs/jquery.SuperSlide.2.1.1.source.js"></script>

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
			<a href=""><img src="<%=path%>/images/logo.png" /> </a>
		</div>
	</div>

	<div class="hang">
		<div class="dao_hang">
			<div class="dao_left">
				<ul>
				<li >
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
						<li class="bian">
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

	<div class="xq_zhong">
		<div class="xq_left">
			<div class="xq_left_div">
				<div class="xq_div_div1">
					<h1>信息分类</h1>
				</div>

				<div class="xq_div_div2">
					<ul>
						<li class="qie"><a
							href="<%=path%>/system/layout/zszcnews.action?mark=0">中省政策</a></li>
						<li class="li"><a
							href="<%=path%>/system/layout/ylzcnews.action?mark=1">杨凌政策</a></li>
					</ul>
				</div>
				<div style="clear: both;"></div>
			</div>


			<div class="xq_left_div2">
				<div class="xq_div_div1">
					<h1>通知公告</h1>
				</div>
				<div class="xq_div1_div2">
					<!--		 滚动-->
					<ul class="infoList">
						<s:iterator value="%{#application.newsList}">
							<li style="overflow:hidden;">
								<div class="img">
									<img src="<%=path%>/images/dian.jpg" />
								</div>
								<div class="wen">
									<a
										href="system/layout/addMoreNewss.action?id=<s:property value='id'></s:property>"><s:property
											value="title"></s:property>
									</a>
								</div></li>
						</s:iterator>
					</ul>
				</div>
				<div style="clear: both;"></div>
			</div>
			<div class="xq_left_div3">
				<ul>
				<li>
					<a href="../../../../FTMS/pages/login/userlogin.jsp"><img src="<%=path%>/images/glxt.jpg" /></a>
				</li>
				<li>
					<a href="../../../../FTMS/pages/login/userlogin.jsp"><img src="<%=path%>/images/ksxt.jpg" /></a>
				</li>			
			</ul>			
				<div style="clear: both;"></div>
			</div>
		</div>

		<div class="xq_right">

			<div class="xq_right_div2"  style="height: 820px;">
				<div class="xq_div2_div1">
					<div class="xq_div2_top">
						<div class="xq_top_img">
							<img src="<%=path%>/images/xq_wu.png" />
						</div>
						<div class="xq_top_wen">
							<span>您当前位置：信息列表 > <a>政策信息</a> </span>
						</div>
					</div>
				</div>

				<div class="xq_div2_div2" style="height: 640px;" >
					<div class="xq_div2_div3">
						<s:iterator value="%{#application.newsListzc}">
							<ul class="ula">
								<li style="overflow: hidden;">
									<div class="img">
										<img src="<%=path%>/images/dian.jpg" />
									</div>
									<div class="wen">
										<span><s:property value="date" />
										</span> <a
											href="system/layout/addMoreNewsszc.action?id=<s:property value='zcid'></s:property>"><s:property
												value="title"></s:property> </a>
									</div></li>
							</ul>
						</s:iterator>
					</div>
				</div>

				<div class="xq_div6">
					<div class="pagin">
						<div class="message">
							共
							<s:property value='#application.pagecountzc' />
							页记录，当前显示第&nbsp; <i class="blue"><s:property
									value="#application.pagenowzc" />&nbsp;</i>页
						</div>

						<ul class="paginList">
							<li class="paginItem"><a
								href="<%=path %>/system/layout/morenewszcwk.action?PageNow=1"
								target="right"><span class="pagepre">首页</span> </a></li>
							<li class="paginItem"><s:if test="#application.pagenowzc!=1">
									<a
										href="<%=path %>/system/layout/morenewszcwk.action?PageNow=<s:property value='#application.pagenowzc-1'/>"
										target="right"><span class="pagepre">上一页</span> </a>
								</s:if></li>
							<li class="paginItem"><a href="javascript:;"><s:property
										value='#application.pagenowzc' />
							</a></li>
							<li class="paginItem current"><s:if
									test="#application.pagenowzc+1 <= #application.pagecountzc">
									<a style="cursor:pointer"
										href="<%=path %>/system/layout/morenewszcwk.action?PageNow=<s:property value='#application.pagenowzc+1'/>"><s:property
											value='#application.pagenowzc+1' />
									</a>
								</s:if></li>
							<li class="paginItem current"><s:if
									test="#application.pagenowzc+2 <= #application.pagecountzc ">
									<a style="cursor:pointer"
										href="<%=path %>/system/layout/morenewszcwk.action?PageNow=<s:property value='#application.pagenowzc+2'/>"><s:property
											value='#application.pagenowzc+2' />
									</a>
								</s:if></li>
							<!--                   下一页-->
							<li class="paginItem"><s:if
									test="#application.pagenowzc!=#application.pagecountzc">
									<a
										href="<%=path %>/system/layout/morenewszcwk.action?PageNow=<s:property value='#application.pagenowzc+1'/>"
										target="right"><span class="pagepre">下一页</span> </a>
								</s:if></li>
							<li class="paginItem"><a
								href="<%=path %>/system/layout/morenewszcwk.action?PageNow=<s:property value='#application.pagecountzc'/>"
								target="right"><span class="pagepre">末页</span> </a></li>
						</ul>
					</div>
				</div>
				<div style="clear: both;"></div>
			</div>
		</div>
		<div style="clear: both;"></div>
	</div>

	<div class="di">
		<p>Copyright ◎ 2016 杨凌农科培训综合信息服务平台All Rights Reserved</p>
		<p>联系电话：029-87036420 87036412 邮政编码：712100 联系地址：杨凌示范区新桥北路政务大厦</p>
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

