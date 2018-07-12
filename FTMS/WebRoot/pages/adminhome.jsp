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
    
    <title>管理员管理</title>
    
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
<style>
body{ padding:0;margin:0; height:100%;width:auto}
html{ height:100%;width:auto} 
#main{width:auto;height:100%  ; margin:0;}
/* by czt  */
.top{background:url(<%=path%>/images/ManagementSystem/ding.jpg) no-repeat;width:100%;height:100px;border-bottom:3px solid #B7D2FF}
 .logo{width:1180px; margin-top:10px;}
 .ding{background-color: rgba(255, 255, 255, 0.26); height:5px; width:100%;}
.ding_top{width:1180px; margin:0 auto; line-height:36px;}
.ding_aa{ height:36px; line-height:36px; float:right; color:#666666;}
.ding_top a{ font-size:14px; color:#666666;}
 /* above by czt */
</style>

<script language="javascript" type="text/javascript"> 
	function resizetea(){ 
	$("#show").load(function(){ 
	$(this).height(0); //用于每次刷新时控制IFRAME高度初始化 
	var height = $(this).contents().height() ; 
	$(this).height( height < 950 ? 950 : height ); 
	});
	}
	function resizetealist(){ 
	$("#show").load(function(){ 
	$(this).height(0); //用于每次刷新时控制IFRAME高度初始化 
	var height =  ($(window).height())*0.80;
	$(this).height( height ); 
	});
	}
	
	function resizebase(){ 
	$("#show").load(function(){ 
	$(this).height(0); //用于每次刷新时控制IFRAME高度初始化 
	var height = $(this).contents().height() ; 
	$(this).height( height < 1048 ? 1048 : height ); 
	});
	}
	function resizeres(){ 
	$("#show").load(function(){ 
	$(this).height(0); //用于每次刷新时控制IFRAME高度初始化 
	var height = $(this).contents().height() ; 
	$(this).height( height < 900 ? 900 : height ); 
	});
	}
</script>

<script type="text/javascript">
function ksps(){
$('#show').attr("src","ksps.jsp");
}
function stgy(){
$('#show').attr("src","stgy.jsp");
}
function kssh(){
$('#show').attr("src","kssh.action");
}
function stgy(){
$('#show').attr("src","onlinetest/tiku.action");
resizeres();
}
function userManagement(){
$('#show').attr("src","userManagement.jsp");
}
function adminManagement(){
$('#show').attr("src","adminManagement.jsp");
}
function xgmm(){
var name=$('#name').text();
$('#show').attr("src","resetpassword.action?supername=&adminname="+name);
}
//by xiuhao.yan
function cxmm(){
$('#show').attr("src","queryPassword.jsp");
}
/**
**by wangke
**/

function gglb(){
$('#show').attr("src","../../yanggov/system/layout/tzdelete1.jsp");
}
function fbgg(){
$('#show').attr("src","../../yanggov/system/layout/tongzhi1.jsp");
resizeres();
}
function dtlb(){
$('#show').attr("src","../../yanggov/system/layout/back/bpeixun/pxdelete1.jsp");
}
function fbdt(){
$('#show').attr("src","../../yanggov/system/layout/back/bpeixun/bpeixun1.jsp");
resizeres();
}
function zclb(){
$('#show').attr("src","../../yanggov/system/layout/back/bzhengce/zcdelete1.jsp");
}
function fbzc(){
$('#show').attr("src","../../yanggov/system/layout/back/bzhengce/bzhengce1.jsp");
resizeres();
}
function kxlb(){
$('#show').attr("src","../../yanggov/system/layout/back/bkuaixun/kxdelete1.jsp");
}
function fbkx(){
$('#show').attr("src","../../yanggov/system/layout/back/bkuaixun/bkuaixun1.jsp");
resizeres();
}


/**
**by czt for train_teacher_manage_back
**/
function teaList(){
	$('#show').attr("src","../../yanggov/system/layout/back/tealist.jsp");
	resizetealist();
}
function addTea(){
	$('#show').attr("src","../../yanggov/system/layout/back/teaadd.jsp");
	resizetea();
}
/**
**by czt for train_base_manage_back
**/
function baseList(){
	$('#show').attr("src","../../yanggov/system/layout/back/baselist.jsp");
}
function addBase(){
	$('#show').attr("src","../../yanggov/system/layout/back/baseadd.jsp");
	resizebase();
}
/**
**by czt for train_res_manage_back
**/
function resList(){
	$('#show').attr("src","../../yanggov/system/layout/back/reslist.jsp");
}
function addRes(){
	$('#show').attr("src","../../yanggov/system/layout/back/resadd.jsp");
	resizeres();
}
/**
**by xiuhao.yan on 06/06/2018
**/
function corpList(){
    $('#show').attr("src","../../yanggov/faxuqiu/shenhe/yuanqishenhe.jsp");
	resizeres();
}
function addCorp(){
	$('#show').attr("src","../../yanggov/faxuqiu/yuanqi/yuanqiadd.jsp");
	resizeres();
}
function demandList(){
    /* $('#show').attr("src","../../yanggov/faxuqiu/shenhe/demandlist.jsp"); */
    $('#show').attr("src","../../yanggov/faxuqiu/shenhe/peixunshenhe.jsp");
	resizeres();
}
function addTrainDemand(){
    $('#show').attr("src","../../yanggov/faxuqiu/peixunxuqiu.jsp");
    resizeres();
}
function addMasterDemand(){
    $('#show').attr("src","../../yanggov/faxuqiu/rencaixuqiu.jsp");
    resizeres();
}
function addTechDemand(){
    $('#show').attr("src","../../yanggov/faxuqiu/jishuxuqiu.jsp");
    resizeres();
}
/**
**by czt for shenhe——manage_back(annotated on 06/06/2018 by xiuhao.yan)
**/
/*
function peixun(){
	$('#show').attr("src","../../yanggov/faxuqiu/shenhe/peixunshenhe.jsp");
}
function rencai(){
	$('#show').attr("src","../../yanggov/faxuqiu/shenhe/rencaishenhe.jsp");
}
function jishu(){
	$('#show').attr("src","../../yanggov/faxuqiu/shenhe/jishushenhe.jsp");
}
function yuanqi(){
	$('#show').attr("src","../../yanggov/faxuqiu/shenhe/yuanqishenhe.jsp");
}
function reload(){
	window.location.reload();
}
*/

/**
**by czt for advice_add
**/

function guanggao(){
	$('#show').attr("src","../../yanggov/system/layout/back/ggupload.jsp");
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
        <span>管理员：</span><span id="name" style="font-size:16px; "><s:property value='adname' /></span><span>,欢迎你！</span>
        <a href="logout.action?ref=admin" class="easyui-linkbutton"  style="float:right; font-size:16px;width:9%;height:33px">退出</a>
        
        </div>
        <div style = "clear:both;"></div>
        <div class="easyui-layout" style="height:80%; ">
        	<div id="p" data-options="region:'west'" title="导航栏" style="width:15%;padding:0px">
          		 <div class="easyui-accordion" data-options="border:false" style="width:100%">
                    <div title="人员管理" style="padding:10px;">
                        <a href="javascript:void(0);" class="easyui-linkbutton" style="width:100%;height:32px" onClick="kssh()">考试审核</a>
                        <div style="margin:10px 0;"></div>
                    	<a href="javascript:void(0);" class="easyui-linkbutton" style="width:100%;height:32px" onClick="ksps()">成绩录入</a>
                    </div>
                    <div title="考试管理" style="padding:10px">
                        <a href="javascript:void(0);" class="easyui-linkbutton" style="width:100%;height:32px" onClick="stgy()">试题管理</a>
                    </div>
                    <div title="账号管理" style="padding:10px">
                        <a href="javascript:void(0);" class="easyui-linkbutton" style="width:100%;height:32px" onClick="userManagement()">用户管理</a>
                       	<div style="margin:10px 0;"></div>
                       	<a href="javascript:void(0);" class="easyui-linkbutton" style="width:100%;height:32px" onClick="xgmm()">修改密码</a>
                       	<!-- by xiuhao.yan -->
                       	<div style="margin:10px 0;"></div>
                       	<a href="javascript:void(0);" class="easyui-linkbutton" style="width:100%;height:32px" onClick="cxmm()">查询密码</a>
                    </div>
                    <!-- czt -->
                    <div title="通知公告" style="padding:10px;">
                        <a href="javascript:void(0);" class="easyui-linkbutton" style="width:100%;height:32px" onClick="gglb()">公告列表</a>
                        <div style="margin:10px 0;"></div>
                    	<a href="javascript:void(0);" class="easyui-linkbutton" style="width:100%;height:32px" onClick="fbgg()">发布公告</a>
                    </div>
                    <div title="工作动态" style="padding:10px;">
                        <a href="javascript:void(0);" class="easyui-linkbutton" style="width:100%;height:32px" onClick="dtlb()">动态列表</a>
                        <div style="margin:10px 0;"></div>
                    	<a href="javascript:void(0);" class="easyui-linkbutton" style="width:100%;height:32px" onClick="fbdt()">发布动态</a>
                    </div>
                    <div title="政策信息" style="padding:10px;">
                        <a href="javascript:void(0);" class="easyui-linkbutton" style="width:100%;height:32px" onClick="zclb()">政策列表</a>
                        <div style="margin:10px 0;"></div>
                    	<a href="javascript:void(0);" class="easyui-linkbutton" style="width:100%;height:32px" onClick="fbzc()">发布政策</a>
                    </div>
                    <div title="三农快讯" style="padding:10px;">
                        <a href="javascript:void(0);" class="easyui-linkbutton" style="width:100%;height:32px" onClick="kxlb()">快讯列表</a>
                        <div style="margin:10px 0;"></div>
                    	<a href="javascript:void(0);" class="easyui-linkbutton" style="width:100%;height:32px" onClick="fbkx()">发布快讯</a>
                    </div>
                    <div title="师资管理" style="padding:10px;">
                        <a href="javascript:void(0);" class="easyui-linkbutton" style="width:100%;height:32px" onClick="teaList()">师资列表</a>
                        <div style="margin:10px 0;"></div>
                    	<a href="javascript:void(0);" class="easyui-linkbutton" style="width:100%;height:32px" onClick="addTea()">发布师资信息</a>
                    </div>
                    <div title="基地管理" style="padding:10px;">
                        <a href="javascript:void(0);" class="easyui-linkbutton" style="width:100%;height:32px" onClick="baseList()">培训分中心列表</a>
                        <div style="margin:10px 0;"></div>
                    	<a href="javascript:void(0);" class="easyui-linkbutton" style="width:100%;height:32px" onClick="addBase()">发布培训分中心信息</a>
                    </div>
                    <div title="资源管理" style="padding:10px;">
                        <a href="javascript:void(0);" class="easyui-linkbutton" style="width:100%;height:32px" onClick="resList()">资源列表</a>
                        <div style="margin:10px 0;"></div>
                    	<a href="javascript:void(0);" class="easyui-linkbutton" style="width:100%;height:32px" onClick="addRes()">发布培训资源</a>
					</div>
					<!-- by xiuhao.yan on 06/06/2018-->
					<div title="园企管理" style="padding:10px;">
						<a href="javascript:void(0);" class="easyui-linkbutton" style="width:100%;height:32px" onClick="corpList()">园企列表</a>
						<div style="margin:10px 0;"></div>
                        <a href="javascript:void(0);" class="easyui-linkbutton" style="width:100%;height:32px" onClick="addCorp()">发布园企信息</a>
					</div>
					<div title="需求管理" style="padding:10px;">
                        <a href="javascript:void(0);" class="easyui-linkbutton" style="width:100%;height:32px" onClick="demandList()">需求列表</a>
                        <div style="margin:10px 0;"></div>
                    	<a href="javascript:void(0);" class="easyui-linkbutton" style="width:100%;height:32px" onClick="addTrainDemand()">发布培训需求</a>
                        <div style="margin:10px 0;"></div>
                        <a href="javascript:void(0);" class="easyui-linkbutton" style="width:100%;height:32px" onClick="addMasterDemand()">发布人才需求</a>
                        <div style="margin:10px 0;"></div>
                        <a href="javascript:void(0);" class="easyui-linkbutton" style="width:100%;height:32px" onClick="addTechDemand()">发布技术需求</a>
					</div>
					<!-- 根据修改意见注释掉审核信息 annotated on 06/06/2018 by xiuhao.yan-->
					<!--
                    <div title="审核信息" style="padding:10px;">
                        <a href="javascript:void(0);" class="easyui-linkbutton" style="width:100%;height:32px" onClick="peixun()">培训审核</a>
                        <div style="margin:10px 0;"></div>
                    	<a href="javascript:void(0);" class="easyui-linkbutton" style="width:100%;height:32px" onClick="rencai()">人才审核</a>
                    	<div style="margin:10px 0;"></div>
                    	<a href="javascript:void(0);" class="easyui-linkbutton" style="width:100%;height:32px" onClick="jishu()">技术审核</a>
                    	<div style="margin:10px 0;"></div>
                    	<a href="javascript:void(0);" class="easyui-linkbutton" style="width:100%;height:32px" onClick="yuanqi()">园企审核</a>
					</div>
					-->
                      <div title="广告管理" style="padding:10px;">
                        <a href="javascript:void(0);" class="easyui-linkbutton" style="width:100%;height:32px" onClick="guanggao()">广告投放</a>
                    </div>
					<!-- czt -->
					
					
                </div>
    		</div>
        	<div  data-options="region:'center'">
            	<iframe name="show" id="show" width="100%" height="99.6%" src="kssh.action" scrolling="no" frameborder="0" style="background:#fff;"></iframe>
            </div>
        </div>
        <div align="center" style="height:5%; background: #fff;"><p>Copyright ◎ 2016 杨凌农科培训综合信息服务平台All Rights Reserved</p>
			<p>联系电话：029-87036420    87036412  邮政编码：712100  联系地址：杨凌示范区新桥北路政务大厦</p></div>
    </div>
</body>
</html>
