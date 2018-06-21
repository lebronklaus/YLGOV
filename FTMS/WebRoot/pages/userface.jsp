<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>pages/">

<title>My JSP 'userface.jsp' starting page</title>

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
<link rel="stylesheet" type="text/css" href="../css/color.css">
<link rel="stylesheet" type="text/css" href="../css/demo.css">

<script type="text/javascript" src="../js/jquery.min.js"></script>
<script type="text/javascript" src="../js/jquery.easyui.min.js"></script>

<style>
body {
	padding: 0;
	margin: 0;
	height: 100%;
	width: auto
}

html {
	height: 100%;
	width: auto
}

#main {
	width: auto;
	margin: auto;
}

span {
	font-size: 16px;
	font-family: "微软雅黑";
}
</style>

</head>

<body>
<span id="username" style="display:none"><s:property
			value='username' /></span>
    <div id="Basic" align="center" style="width:auto;height:400px;padding:10px;">
    	<span style="font-size:20px;">人员基本信息</span>
    	<div style="margin:20px 0;"></div>
        <table style="width:700px;" border="1" cellspacing="0">
            <tr>
                <td width="145" height="40" style="vertical-align:middle; text-align:right;"><span> 姓名：</span></td>
              <td width="416"><span>&nbsp;&nbsp;&nbsp;&nbsp;</span><span ><s:property value="user.name"/></span></td>
                <td width="125" rowspan="5"><img src='<s:property value="user.picpath"/>' height="160" width="120" style="border:1px solid;"></td>
            </tr>
            <tr>
            	<td height="40" style="vertical-align:middle; text-align:right;"><span>性别：</span></td>
              <td><span>&nbsp;&nbsp;&nbsp;&nbsp;</span><span><s:property value="user.gender"/></span></td>
            </tr>
            <tr>
            	<td height="40" style="vertical-align:middle; text-align:right;"><span> 出生年月：</span></td>
              <td><span>&nbsp;&nbsp;&nbsp;&nbsp;</span><span><s:property value="birth"/></span></td>
            </tr>
            <tr>
            	<td height="40" style="vertical-align:middle; text-align:right;"><span>联系电话：</span></td>
              <td><span>&nbsp;&nbsp;&nbsp;&nbsp;</span><span><s:property value="user.phone"/></span></td>
            </tr>
            <tr>
                
                <td height="40" style="vertical-align:middle; text-align:right;"><span>身份证号：</span></td>
              <td><span>&nbsp;&nbsp;&nbsp;&nbsp;</span><span><s:property value="user.idnumber"/></span></td>
            </tr>
            <tr>
                <td height="40" style="vertical-align:middle; text-align:right;"><span>家庭住址：</span></td>
              <td colspan="3"><span>&nbsp;&nbsp;&nbsp;&nbsp;</span><span><s:property
								value='user.JPositionProvice.proviceName' /> <s:property
								value='user.JPositionCity.cityName' /> <s:property
								value='user.JPositionCounty.countyName' /> <s:property
								value='user.JPositionTown.townName' /> <s:property 
								value="address.address"/></span></td>
            </tr>
            <tr>
                <td height="40" style="vertical-align:middle; text-align:right;"><span>学历：</span></td>
              <td colspan="3"><span>&nbsp;&nbsp;&nbsp;&nbsp;</span><span><s:property value="user.education"/></span></td>
            </tr>
            <tr>
            	<td height="40" style="vertical-align:middle; text-align:right;"><span>从事专业：</span></td>
              <td colspan="3"><span>&nbsp;&nbsp;&nbsp;&nbsp;</span><span><s:property
								value='user.prof2.prof1.name' />-<s:property
								value='user.prof2.name' /></span></td>
            </tr>
        </table>
    </div><!-- Basic -->

    <div id="result" align="center" style="width:auto;height:200px;padding:10px;">
        <span style="font-size:20px;">证书获得情况</span>
    	<div style="margin:20px 0;"></div>
        <table style="width:700px; text-align:center" border="1" cellspacing="0">
        	 <tr>
                <th width="300" height="35"><span>级别</span></th>
                <th width="300"><span>证书编号</span></th>
                <!-- <th width="200"><span>审验状态</span></th> -->
            </tr>
            <tr>
                <td height="35"><span>农技员</span></td>
                <td><span id="result_njy"></span></td>
                <!--  <td><span id="shenyan_njy"></span></td>-->
            </tr>
             <tr>
                <td height="35"><span>农技师</span></td>
                <td><span id="result_njs"></span></td>
               <!--  <td><span id="shenyan_njs"></span></td> -->
            </tr>
             <tr>
                <td height="30"><span>高级农技师</span></td>
                <td><span id="result_gjnjs"></span></td>
                <!--<td><span id="shenyan_gjnjs"></span></td>  -->
            </tr>
        </table>
    </div><!-- result -->
</body>
<script type="text/javascript">
	$(document).ready(function() {
		$.post("faceload.action", {
			username : $('#username').text()
		}, function(data) {
			$('#result_njy').text(data[0].result_njy),
			//$('#shenyan_njy').text(data[1].shenyan),
			$('#result_njs').text(data[0].result_njs),
			//$('#shenyan_njs').text(data[2].shenyan),
			$('#result_gjnjs').text(data[0].result_gjnjs)
			//$('#shenyan_gjnjs').text(data[3].shenyan)
		}, "json");

	});
</script>
</html>