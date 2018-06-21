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
	<script language = "JavaScript" src="js/jquery.js"></script>
    <style>
	td {
		height: 30px;
	}
	body{
		overflow-x : hidden;
	}
	p {
	font-size: 12px;
}
</style>
  </head>
  
  <body >
  	<s:iterator value="tealist"  var="tea">
  		<div style="width:726px;height:170px;border-bottom: dashed 1px #cacaca;padding-top:7px; ">
  			<div id="image" style="width:144px;height:164px;border:0px solid grey;float: left;">
  				<a href="./teacher/teaspe.action?teacher_id=<s:property value="teacher_id"/>" target="_parent">
  				<s:if test='teacher_path == null || teacher_path=="" '>
  					<img id="teaimage" src="upload/media/zwtp.jpg" style="width:125px;height:164px;">
  				</s:if>
  				<s:else>
  					<img id="teaimage" src="upload/media/image/<s:property value="teacher_path"/>" style="width:125px;height:164px;">
  				</s:else>
  				</a>
  			</div>
  			<div id="infor" style="  width:580px;height:100%;border:0px solid grey;float: left;">
  				<table style="border:none;border-width: 0px;">
  					<tr>
  						<td style="width:70px;border:0px;"><a href="./teacher/teaspe.action?teacher_id=<s:property value="teacher_id"/>" target="_parent" style="font-size: 15px;"><s:property value="teacher_name"/></a></td>
  						<td></td>
  					</tr>
  					<tr>
  						<td style="width:70px;color:#007cc1;">科研领域</td>
  						<td><s:property value="teacher_major"/></td>
  					</tr>
  					<tr>
  						<td style="width:70px;vertical-align: top;color:#007cc1;">个人简介</td>
  						<td style="width:660px; height:100px; vertical-align: top; border: 0px solid;">
  							<%-- <pre style="white-space: pre-wrap; white-space: -moz-pre-wrap; white-space: -pre-wrap; white-space: -o-pre-wrap;line-height:15px; word-spacing: break-word;"><s:property value="teacher_profile" escape="false"/></pre> --%>
  							<div style="display: block;line-height: 20px;    padding: 9.5px;padding-left: 10px; font-size: 14px;font-family: 微软雅黑;" ><s:property value="teacher_profile" escape="false"/></div>
  						</td>
  					</tr>
  				</table>
  			</div>
  			
  		</div>
  	</s:iterator>
  	
  	<div class="pagin" style="width:708px;">
				<div class="message">
					共
					<s:property value='pageCount' />
					页记录，当前显示第&nbsp;
					<i class="blue"><s:property  value="pageNow"/>&nbsp;</i>页
				</div>

				<ul class="paginList">
					<li class="paginItem">
						<a href="./teacher/tealist.action?PageNow=1"><span class="pagepre">首页</span>
						</a>
					</li>
					<li class="paginItem">
						<s:if test="pageNow!=1"><a href="./teacher/tealist.action?PageNow=<s:property value='pageNow-1'/>"><span
							class="pagepre">上一页</span>
						</a></s:if>
					</li>

					<li class="paginItem">
						<a href="javascript:;"><s:property value='pageNow'/></a>
					</li>
					
								
					<li class="paginItem current">
					<s:if test="pageNow+1 <= pageCount"><a  style="cursor:pointer"  href="./teacher/tealist.action?PageNow=<s:property value='pageNow+1'/>"><span
							class="pagepre"><s:property value='pageNow+1'/></span>
						</a></s:if>
							
					</li>
					<li class="paginItem current">
						<s:if test="pageNow+2 <=pageCount"><a style="cursor:pointer"  href="./teacher/tealist.action?PageNow=<s:property value='pageNow+2'/>"><span
							class="pagepre"><s:property value='pageNow+2'/></span>
						</a>
						</s:if>
						
					</li>
					
					<li class="paginItem">
						<s:if test="pageNow!=pageCount"><a style="cursor:pointer" href="./teacher/tealist.action?PageNow=<s:property value='pageNow+1'/>"><span
							class="pagepre">下一页</span>
						</a></s:if>
					</li>
					<li class="paginItem">
						<a href="./teacher/tealist.action?PageNow=<s:property value='pageCount'/>"><span
							class="pagepre">末页</span>
						</a>
					</li>
				</ul>
			</div>
    
  </body>
</html>
