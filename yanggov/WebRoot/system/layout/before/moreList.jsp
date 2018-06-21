<%@ page language="java"
	import="java.util.*,com.lee.action.Search,com.lee.mode.Tnews"
	pageEncoding="utf-8"%>
<%@  taglib uri="/struts-tags" prefix="s"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">
		<link href="style/style.css" rel="stylesheet" type="text/css" />
		<title>moreList</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
		<link href="style/style1.css" rel="stylesheet" type="text/css" />
		<link rel="stylesheet" type="text/css" href="style/moreNews.css">
		<script type="text/javascript" src="js/jquery.js"></script>
  
   

	</head>

	<body style="min-width:660px;">
		
		
		<s:iterator value="%{#application.newsList}">
  		<div style="width:660px;border-bottom:1px solid grey;height: 36px;line-height: 36px;border-bottom: dashed 1px #cacaca;">
  			
  			
  		<div id="name" style="width:530px;height:100%;border:0px solid grey;float: left;">
  		<a href="system/layout/addMoreNewss.action?id=<s:property value='id'></s:property>"><s:property	value="title"></s:property> </a></div>
  		<div id="time" style="width:125px;height:100%;border:0px solid grey;float: left;"><s:property value="date"/></div>
  		</div>
  		
  	</s:iterator>
       <div class="pagin">
				<div class="message">
					共
					<s:property value='#application.pagecount' />
					页记录，当前显示第
					<i class="blue"><s:property value="#application.pagenow"/></i>页
				</div>

				<ul class="paginList">
					<li class="paginItem">
						<a href="<%=path %>/system/layout/morenewswk.action?PageNow=1" target="right"><span class="pagepre">首页</span>
						</a>
					</li>
					<li class="paginItem">
					<s:if test="#application.pagenow!=1">
						<a href="<%=path %>/system/layout/morenewswk.action?PageNow=<s:property value='#application.pagenow-1'/>" target="right"><span
							class="pagepre">back</span>
						</a></s:if>
					</li>

					<li class="paginItem">
						<a href="javascript:;"><s:property value='#application.pagenow'/></a>
					</li>
					
					<li class="paginItem current">
							<s:if test="#application.pagenow+1 <= #application.pagecount"><a style="cursor:pointer" href="<%=path %>/system/layout/morenewswk.action?PageNow=<s:property value='#application.pagenow+1'/>"><s:property value='#application.pagenow+1'/></a>
							</s:if>
					</li>
					<li class="paginItem current">
						<s:if test="#application.pagenow+2 <= #application.pagecount "><a style="cursor:pointer" href="<%=path %>/system/layout/morenewswk.action?PageNow=<s:property value='#application.pagenow+2'/>"><s:property value='#application.pagenow+2'/></a>
							</s:if>
					</li>
<!--                   下一页-->
					<li class="paginItem">
					<s:if test="#application.pagenow!=#application.pagecount">
						<a  href="<%=path %>/system/layout/morenewswk.action?PageNow=<s:property value='#application.pagenow+1'/>" target="right"><span
							class="pagepre">next</span>
						</a></s:if>
					</li>
					<li class="paginItem">
						<a href="<%=path %>/system/layout/morenewswk.action?PageNow=<s:property value='#application.pagecount'/>" target="right"><span
							class="pagepre">末页</span>
						</a>
					</li>
				</ul>
			</div>
		<div class="resText"></div>
		<!--       <ul>-->
		<!--       <li class="resText">-->
		<!--       </li>-->
		<!--       </ul>-->
		<!--  <s:property value="%{#application.newsList[1].title}"></s:property>-->
	</body>
</html>
