<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
    <base href="<%=basePath%>">
    <link rel="stylesheet" type="text/css" href="shizi/shizicss/reset.css" />
	<link rel="stylesheet" type="text/css" href="shizi/shizicss/style.css" />
	<script type="text/javascript" src="js/jquery.js"></script>
    
    <style>

body{
    	width:762px;
    	height:530px;
    	overflow-x : hidden;
    }
</style>
   
  </head>
  
  <body >
  <!--专家视频库  -->
  
  	<div class="xq_div2_div4">
		<div class="ind_lie_tong1">
			<div class="lie_tong_left">
				<ul>
					<li class="bei"><a href="javascript:void(0)">专家</a></li>
					<li><a href="javascript:void(0)">视频库</a></li>					
				</ul>
			</div>
			<div class="lie_tong_right1">
				<span>--------------------------------------------------------------------------------------------------------------<a href="./res/ressp2.action?flag=0" target="rightFrm">更多>></a></span>
			</div>					
		</div>		
				<div class="xq_div2_div3">
					<ul class="ula">
					<s:iterator value="veadiolist">
						<li>
							<div class="img"><img src="images/dian.jpg" /></div>
							<div class="wen"><a href="./res/resved.action?resources_id=<s:property value="resources_id"/>&flag=0" target="_parent"><s:property value="resources_title"/></a><span><s:property value="resources_time"/></span></div>						
						</li>
					</s:iterator>						
					</ul>				
				</div>
	</div>
			<%-- <div class="xq_div2_div4">
  				<div class="ind_lie_tong1">
					<div class="lie_tong_left">
						<ul>
							<li class="bei"><a href="javascript:void(0)">广播</a></li>
							<li><a href="javascript:void(0)">演讲稿</a></li>					
						</ul>
					</div>
					<div class="lie_tong_right1">
						<span>--------------------------------------------------------------------------------------------------------------<a href="./res/resgb2.action?flag=1" target="rightFrm">更多>></a></span>
					</div>					
				</div>		
				<div class="xq_div2_div3">
					<ul class="ula">
					<s:iterator value="brolist">
						<li>
							<div class="img"><img src="images/dian.jpg" /></div>
							<div class="wen"><a href="./res/resbro.action?resources_id=<s:property value="resources_id"/>&flag=1" target="_parent"><s:property value="resources_title"/></a><span><s:property value="resources_time"/></span></div>						
						</li>
					</s:iterator>
					</ul>				
				</div>
			</div> --%>
			<div class="xq_div2_div4">
  				<div class="ind_lie_tong1">
					<div class="lie_tong_left">
						<ul>
							<li class="bei"><a href="javascript:void(0)">专家</a></li>
							<li><a href="javascript:void(0)">文稿库</a></li>					
						</ul>
					</div>
					<div class="lie_tong_right1">
						<span>--------------------------------------------------------------------------------------------------------------<a href="./res/reswg2.action?flag=2" target="rightFrm">更多>></a></span>
					</div>					
				</div>		
				<div class="xq_div2_div3">
					<ul class="ula">
					<s:iterator value="worlist">
						<li>
							<div class="img"><img src="images/dian.jpg" /></div>
							<div class="wen"><a href="./res/reswg.action?resources_id=<s:property value="resources_id"/>&flag=2" target="_parent"><s:property value="resources_title"/></a><span><s:property value="resources_time"/></span></div>						
						</li>
					</s:iterator>
					</ul>				
				</div>
			</div>
  
  </body>
</html>
