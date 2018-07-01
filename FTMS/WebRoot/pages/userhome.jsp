<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>pages/">
    
    <title>用户管理</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<link rel="stylesheet" type="text/css" href="../css/easyui.css">
<link rel="stylesheet" type="text/css" href="../css/icon.css">
<link rel="stylesheet" type="text/css" href="../css/demo.css">
<link rel="stylesheet" type="text/css" href="../css/color.css">

<script src="../js/jquery.min.js"></script>
<script src="../js/jquery.easyui.min.js"></script>
<script type="text/javascript" src="../js/jquery.base64.js"></script>
<style>
body{ padding:0;margin:0; height:100%;width:auto}
html{ height:100%;width:auto} 
#main{width:auto;height:100%  ; margin:0;}

.top{background:url(<%=path%>/images/ManagementSystem/ding.jpg) no-repeat;width:100%;height:100px;border-bottom:3px solid #B7D2FF}
 .logo{width:1180px; margin-top:10px;}
 .ding{background-color: rgba(255, 255, 255, 0.26); height:5px; width:100%;}
.ding_top{width:1180px; margin:0 auto; line-height:36px;}
.ding_aa{ height:36px; line-height:36px; float:right; color:#666666;}
.ding_top a{ font-size:14px; color:#666666;}
 
</style>
<script language="javascript" type="text/javascript"> 
	function resizepx(){ 
		$("#show").load(function(){ 
		$(this).height(0); //用于每次刷新时控制IFRAME高度初始化 
		var height = $(this).contents().height() ; 
		$(this).height( height < 950 ? 950 : height ); 
		});
	}
	
</script>
<script type="text/javascript">
$(document).ready(function() {
	var mark = <%=session.getAttribute("mark")%>;
	if(mark==0){
		$('#show').attr("src","face.action?username="+$('#username').text());
	}else if(mark==1){
		$('#show').attr("src","../../yanggov/faxuqiu/yuanqi/yuanqiadd.jsp");
	}else if(mark==2){
		$('#show').attr("src","../../yanggov/faxuqiu/yuanqi/yuanqiadd.jsp");
	}
});
function face(){
$('#show').attr("src","face.action?username="+$('#username').text());
}
function xxwh(){
$('#show').attr("src","loaduser.action?username="+$('#username').text());
}
function bmxx(){
$('#show').attr("src","bmxx.action?username="+$('#username').text());
}
function jgcx(){
$('#show').attr("src","jgcx.action?username="+$('#username').text());
}
function mnks(){
$('#show').attr("src","onlinetest/index.action");
}
function jieguo(url){
$('#show').attr("src","onlinetest/"+url+".action");
}
/*  by czt*/
/***
 * annotated by xiuhao.yan on 08/06/2018
 */
/*
function peixun(){
$('#show').attr("src","../../yanggov/faxuqiu/peixunxuqiu.jsp");
resizepx();
}
function jishu(){
$('#show').attr("src","../../yanggov/faxuqiu/jishuxuqiu.jsp");
resizepx();
}
function rencai(){
$('#show').attr("src","../../yanggov/faxuqiu/rencaixuqiu.jsp");
resizepx();
}
*/
function yuanqi(){

}
function reload(){
	window.location.reload();
}
//by xiuhao.yan
function logout(){
	
}

</script>
</head>

<body style="background:#fff;">
    <div id="main">
    	<%-- <div style="height:11%; background:#16538f;" align="center"><img style="height:100%" src="<%=path%>/images/ManagementSystem/head.png"></div> --%>
    	<div class="top">
		<div class="ding">
				<div class="ding_top">
					<div class="ding_aa">
					</div>
				</div>
			</div>	
			<div class="logo">
				<a href="javascript:void(0);" onClick="reload()"><img src="<%=path%>/images/ManagementSystem//logo.png"></a>
			</div>
		</div>
        <div style="height:3%; background:#fff;">
        <!-- <div style="margin:0.5%;"></div> -->
        <span style="font-size:16px;" id="username"><s:property value="uname" /></span><span>,欢迎你！</span><s:property value="username"/>
        <a href="logout.action?ref=user" class="easyui-linkbutton"  style="float:right; font-size:16px;width:9%;height:33px">退出</a>
                
        </div>
        <div style = "clear:both;"></div>
        <div class="easyui-layout" style="height:80%;">
        	<div id="p" data-options="region:'west'" title="导航栏" style="width:15%;padding:0px">
        		<s:if test='#session.mark==0'>
          		 <div class="easyui-accordion" data-options="border:false" style="width:100%">
                   	<div title="职称信息" style="padding:10px; ">
                        <a href="javascript:void(0);" class="easyui-linkbutton" style="width:100%;height:32px" onClick="face()">基本信息</a>
                        <div style="margin:4%;"></div>
                        <a href="javascript:void(0);" class="easyui-linkbutton" style="width:100%;height:32px" onClick="xxwh()">信息维护</a>
                        <div style="margin:4%;"></div>
                        <a href="javascript:void(0);" class="easyui-linkbutton" style="width:100%;height:32px" onClick="jgcx()">证书查询</a>
                    </div>
                    <div title="考试信息" style="padding:10px;">
                       	<a href="javascript:void(0);" class="easyui-linkbutton" style="width:100%;height:32px" onClick="bmxx()">考试报名</a>
                       	<div style="margin:4%;"></div>
                        <a href="javascript:void(0);" class="easyui-linkbutton" style="width:100%;height:32px" onClick="mnks()">模拟考试</a>
					</div>
					<!--
                    <div title="发布需求" style="padding:10px;">
                       	<a href="javascript:void(0);" class="easyui-linkbutton" style="width:100%;height:32px" onClick="peixun()">培训需求</a>
                       	<div style="margin:4%;"></div>
                        <a href="javascript:void(0);" class="easyui-linkbutton" style="width:100%;height:32px" onClick="jishu()">技术需求</a>
					</div>
					-->
                </div>
              </s:if>
               
               <s:if test='#session.mark==1'>
          		 <div class="easyui-accordion" data-options="border:false,multiple:true" style="width:100%">
                   	<div title="企业信息" style="padding:10px; ">
                        <a href="javascript:void(0);" class="easyui-linkbutton" style="width:100%;height:32px" onClick="yuanqi()">编辑信息</a>
					</div>
					<!--
                    <div title="发布需求" style="padding:10px;">
                       	<a href="javascript:void(0);" class="easyui-linkbutton" style="width:100%;height:32px" onClick="rencai()">人才需求</a>
                       	<div style="margin:4%;"></div>
                        <a href="javascript:void(0);" class="easyui-linkbutton" style="width:100%;height:32px" onClick="jishu()">技术需求</a>
					</div>
					-->
                 
                </div>
               </s:if>
               
               <s:if test='#session.mark==2'>
          		 <div class="easyui-accordion" data-options="border:false,multiple:true" style="width:100%">
                   	<div title="园区信息" style="padding:10px; ">
                        <a href="javascript:void(0);" class="easyui-linkbutton" style="width:100%;height:32px" onClick="yuanqi()">编辑信息</a>
                        <div style="margin:4%;"></div>
                    </div>
                   <!--
                    <div title="发布需求" style="padding:10px;">
                       	<a href="javascript:void(0);" class="easyui-linkbutton" style="width:100%;height:32px" onClick="peixun()">培训需求</a>
                       	<div style="margin:4%;"></div>
                        <a href="javascript:void(0);" class="easyui-linkbutton" style="width:100%;height:32px" onClick="jishu()">技术需求</a>
                       	<div style="margin:4%;"></div>
                        <a href="javascript:void(0);" class="easyui-linkbutton" style="width:100%;height:32px" onClick="rencai()">人才需求</a>
					</div>
					-->
                </div>
               </s:if>
    		</div>
        	<div data-options="region:'center'" >
            	<iframe name="show" id="show" width="100%" height="99.6%" frameborder="0" style="background:#fff;"></iframe>
            </div>
        </div>
        <div align="center" style="height:5%; background: #fff;"><p>Copyright ◎ 2016 杨凌农科培训综合信息服务平台All Rights Reserved</p>
	<p>联系电话：029-87036420    87036412  邮政编码：712100  联系地址：杨凌示范区新桥北路政务大厦</p>
        <input  id="mark" style="display:none;"  value="<s:property value='#session.mark'/>">
        </div>
    </div>
</body>
</html>

