<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
	<base href="<%=basePath%>"/>
	<link rel="stylesheet" type="text/css" href="shizi/shizicss/reset.css" />
	<link rel="stylesheet" type="text/css" href="shizi/shizicss/style.css" />
	
	<script type="text/javascript" src="js/jquery.js"></script>
    
    <style>
		td {
			height: 10px;
		}
		body{
			overflow-x : hidden;
		}
	</style>
    
  </head>
  
  <body >
  	
  	<div class="xq_div2_div4">
			<div class="ind_lie_tong1">
				<div class="lie_tong_left">
					<ul>
						<li class="bei"><a href="javascript:void(0)">培训</a></li>
						<li><a href="javascript:void(0)">需求</a></li>					
					</ul>
				</div>
				<div class="lie_tong_right1">
					<span>---------------------------------------------------------------------------------------------------------------------</span>
				</div>					
			</div>		
			<div class="xq_div2_div3_sp">
				<ul class="ula">
				<s:iterator value="list">
					<li>
						<div class="img"><img src="images/dian.jpg" /></div>
						<div class="wen"><a href="showpeixun.action?id=<s:property value="id"/>" target="_parent"><s:property value="companyname"/></a><span><s:property value="inputdate"/></span></div>						
					</li>
				</s:iterator>						
				</ul>				
			</div>
			<div style="clear:both;"></div>
			
  	<div class="pagin" style="width:708px;">
				<div class="message">
					共
					<s:property value='pageCount' />
					页记录，当前显示第&nbsp;
					<i class="blue"><s:property  value="pageNow"/>&nbsp;</i>页
				</div>

				<ul class="paginList">
					<li class="paginItem">
						<a href="peixunsearch.action?PageNow=1"><span class="pagepre">首页</span>
						</a>
					</li>
					<li class="paginItem">
						<s:if test="pageNow!=1"><a href="peixunsearch.action?PageNow=<s:property value='pageNow-1'/>"><span
							class="pagepre">上一页</span>
						</a></s:if>
					</li>

					<li class="paginItem">
						<a href="javascript:;"><s:property value='pageNow'/></a>
					</li>
					<li class="paginItem current">
							<s:if test="pageNow +1 <= pageCount"><a style="cursor:pointer" href="peixunsearch.action?PageNow=<s:property value='pageNow+1'/>"><s:property value='pageNow+1'/></a>
							</s:if>
					</li>
					<li class="paginItem current">
						<s:if test="pageNow+2 <= pageCount"><a style="cursor:pointer" href="peixunsearch.action?PageNow=<s:property value='pageNow+2'/>"><s:property value='pageNow+2'/></a>
							</s:if>
					</li>
					
					<li class="paginItem">
						<s:if test="pageNow!=pageCount"><a href="peixunsearch.action?PageNow=<s:property value='pageNow+1'/>"><span
							class="pagepre">下一页</span>
						</a></s:if>
					</li>
					<li class="paginItem">
						<a href="peixunsearch.action?PageNow=<s:property value='pageCount'/>"><span
							class="pagepre">末页</span>
						</a>
					</li>
				</ul>
			</div>
		</div>
    
  </body>
</html>
