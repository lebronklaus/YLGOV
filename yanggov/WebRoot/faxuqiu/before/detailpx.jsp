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
	<link href="shizi/shizicss/bootstrap.min.css" rel="stylesheet"/>
    <link href="shizi/shizicss/new.css" rel="stylesheet"/>
    <link href="shizi/shizicss/font-awesome.min.css" rel="stylesheet"/>
    
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
						<img src="images/xq_wu.png" />
					</div>
					<div class="xq_top_wen_3">
						<span>您当前位置： 需求征集> <a id ="peixun">培训需求</a></span>					
					</div>				
				</div>
		</div>
		<s:iterator value="list3">
		<div style="height:30px"></div>
	<div style="height: auto;margin-top: 30px;background: #949494;padding: 10px;border-radius: 10px;width: 780px;margin: 0 auto;">
	  <div style="width:100%; background:#fff;position:relative;">
	   
  			<div style="width:100%;" >
  			<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
                <div class="widget no-margin">
                  <div class="widget-body">
                  
                    <div class="stylish-lists">
                      <dl class="dl-horizontal no-margin">
                        <dt  class="text-info">
                          单位名称
                        </dt>
                        <dd>
                        <s:property value="companyname"/>
                        </dd>
                        <dt  class="text-info">
                         联系电话
                        </dt>
                        <dd>
                        <s:property value="tel"/>
                        </dd>
                        <dt  class="text-info">
                          电子邮件
                        </dt>
                        <dd>
                        <s:property value="email"/>
                        </dd>
                        <dt  class="text-info">
                          培训时间
                        </dt>
                        <dd>
                       <s:property value="time"/>
                        </dd>
                         <dt  class="text-info">
                          计划规模
                        </dt>
                        <dd>
                        <s:property value="tzhi.teacher_university"/>
                        </dd>
                      </dl>
                    </div>
                  </div>
                </div>
              </div>
              	<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
                <div class="widget no-margin">
                  <div class="widget-body">
                  
                    <div class="stylish-lists">
                      <dl class="dl-horizontal no-margin">
                        <dt  class="text-info">
                          联系人员
                        </dt>
                        <dd>
                     <s:property value="lianxiren"/>
                        </dd>
                        <dt  class="text-info">
                         传真
                        </dt>
                        <dd>
                     <s:property value="chuanzhen"/>
                        </dd>
                        <dt  class="text-info">
                          培训地点
                        </dt>
                        <dd>
                         <s:property value="peixunadd"/>
                        </dd>
                        <dt  class="text-info">
                        配合事项
                        </dt>
                        <dd>
                          <s:property value="peiheshixiang"/>
                        </dd>
                      </dl>
                    </div>
                  </div>
                </div>
              </div>
            </div>
  				<div style = "clear:both;"></div>
  		
  		</div>
  		</div>
	    <!--简介-->
	    <div id="info">
	    	<div class="title">培训内容</div>
	        <%-- <pre style="line-height: 20px;padding-left: 10px; border: dashed 1px #cacaca; white-space: pre-wrap; white-space: -moz-pre-wrap; white-space: -pre-wrap; white-space: -o-pre-wrap; word-spacing: break-word;">
		     <s:property value="content" escape="false"/>
	        </pre> --%>
	        <div style="display: block;line-height: 20px;    padding: 9.5px;padding-left: 10px; border: dashed 1px #cacaca;border-radius: 4px;font-size: 14px;font-family: 微软雅黑;" id="teacher_profile">
		     <s:property value="content" escape="false" />
	       </div>
	    </div>
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
