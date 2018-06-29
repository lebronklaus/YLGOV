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

<title>My JSP 'xjsj.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<link rel="stylesheet" type="text/css" href="../css/easyui.css">
<link rel="stylesheet" type="text/css" href="../css/color.css">
<link rel="stylesheet" type="text/css" href="../css/demo.css">
<link rel="stylesheet" type="text/css" href="../css/icon.css">
<script type="text/javascript" src="../js/jquery.min.js"></script>
<script type="text/javascript" src="../js/jquery.easyui.min.js"></script>
<script type="text/javascript" src="../echarts-2.2.7/build/dist/echarts.js"></script>
<script type="text/javascript" src="../js/pages/xjsj.js"></script>

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
	<span id="county" style="display:none">杨陵区</span>
	<div id="main" style="width:100%;height:100%">
		<div class="easyui-layout" style="width:atuo;height:90%;">
			<div class="easyui-layout" data-options="fit:true">
				<div data-options="region:'west',split:true,border:false"
					style="width:10%">
					<a href="javascript:void(0)" class="easyui-linkbutton"
						style="width:100%" onClick="cun()">按村统计</a> <a
						href="javascript:void(0)" class="easyui-linkbutton"
						style="width:100%" onClick="zhuanye()">按专业统计</a> <a
						href="javascript:void(0)" class="easyui-linkbutton"
						style="width:100%" onClick="xingbie()">按性别统计</a> <a
						href="javascript:void(0)" class="easyui-linkbutton"
						style="width:100%" onClick="nianling()">按年龄统计</a> <a
						href="javascript:void(0)" class="easyui-linkbutton"
						style="width:100%" onClick="jibie()">按级别统计</a> <a
						href="javascript:void(0)" class="easyui-linkbutton"
						style="width:100%" onClick="xueli()">按学历统计</a> <a
						href="javascript:void(0)" class="easyui-linkbutton"
						style="width:100%" onClick="fazheng()">按日期统计</a>
				</div>
				<div data-options="region:'center',border:false">
					<div id="pie" class="easyui-panel" title="查询数据"
						style="height:92%; width:auto; overflow:hidden;">
						<div id="China" class="China" style="height:100%;"></div>
					</div>
					<div id="wenzi" align="center">
						<pre style="font-size:16px">截止<span id="tj_year"></span>年<span
								id="tj_month"></span>月<span id="tj_day"></span>日，<span
								id="tj_county"></span>共有<span id="tj_number"></span>农民获得证书，涉及<span
								id="tj_town"></span>个村</pre>
					</div>
				</div>
			</div>
		</div>
		<div class="easyui-panel" title="条件查询" style="width:100%;height:auto;">
			<span>村：</span><select class="easyui-combobox" id="town" name="town"
				style="width:10%;height:30px;" editable="false" panelHeight="auto"></select>
			<span>专业：</span> <select class="easyui-combobox" id="prof1"
				name="prof1" style="width:10%; height:30px;" editable="false"
				panelHeight="auto">
			</select> <select class="easyui-combobox" id="prof2" name="prof2"
				style="width:10%;height:30px;" editable="false" panelHeight="auto">
				<option value="不限">不限</option>
			</select> <span>性别：</span><select class="easyui-combobox" id="gender"
				name="gender" style="width:4%;height:30px;" editable="false"
				panelHeight="auto">
				<option value="不限">不限</option>
				<option value="男">男</option>
				<option value="女">女</option>
			</select> <span>年龄：</span><select class="easyui-combobox" id="age" name="age"
				style="width:auto;height:30px;" editable="false" panelHeight="auto">
				<option value="不限">不限</option>
				<option value="20以下">20以下</option>
				<option value="20-30">20~39</option>
				<option value="30-40">30~40</option>
				<option value="40-50">40~50</option>
				<option value="50-60">50~60</option>
				<option value="60以上">60以上</option>
			</select> <span>级别：</span><select class="easyui-combobox" id="level"
				name="level" style="width:auto;height:30px;" editable="false"
				panelHeight="auto">
				<option value="不限">不限</option>
				<option value="农技员">农技员</option>
				<option value="农技师">农技师</option>
				<option value="高级农技师">高级农技师</option>
			</select> <span>学历：</span><select class="easyui-combobox" id="education"
				name="education" style="width:auto;height:30px;" editable="false"
				panelHeight="auto">
				<option value="不限">不限</option>
				<option value="小学">小学</option>
				<option value="初中">初中</option>
				<option value="高中">高中</option>
				<option value="大专">大专</option>
				<option value="本科">本科</option>
				<option value="研究生">研究生</option>
				<option value="其他">其他</option>
			</select> <span>年份：</span><select class="easyui-combobox" id="fazheng"
				name="fazheng" style="width:auto;height:30px;" editable="false"
				panelHeight="auto">
				<option value="不限">不限</option>
				<option value="2005">2005</option>
				<option value="2006">2006</option>
				<option value="2007">2007</option>
				<option value="2008">2008</option>
				<option value="2009">2009</option>
				<option value="2010">2010</option>
				<option value="2011">2011</option>
				<option value="2012">2012</option>
				<option value="2013">2013</option>
				<option value="2014">2014</option>
				<option value="2015">2015</option>
				<option value="2016">2016</option>
				<option value="2017">2017</option>
			</select><a href="javascript:void(0)" class="easyui-linkbutton"
				style="width:5%" onClick="Search()">查询</a>
		</div>
	</div>
	<div id="dlg" class="easyui-dialog"
		style="width:97%;height:80%;padding:10px 20px" closed="true"
		buttons="#dlg-buttons">
		<div class="ftitle">
			<span>查询结果为:</span>
		</div>
		<table id="dg" title="" class="easyui-datagrid"
			style="width:100%;height:80%" rownumbers="true" fitColumns="true"
			singleSelect="false" selectOnCheck="true" checkOnSelect="true"
			pagination="true">
			<thead>
				<tr>
					<th
						data-options="field:'username',formatter:formatusername,width:150">账号</th>
					<th
						data-options="field:'password',formatter:formatpassword,width:40">密码</th>
					<th data-options="field:'name',formatter:formatname,width:50">姓名</th>
					<th data-options="field:'gender',formatter:formatgender,width:30">性别</th>
					<th
						data-options="field:'idnumber',formatter:formatidnumber,width:150">身份证号</th>
					<th
						data-options="field:'birthday',formatter:formatbirthday,width:100">生日</th>
					<th data-options="field:'phone',formatter:formatphone,width:100">电话</th>
					<th
						data-options="field:'education',formatter:formateducation,width:50">学历</th>
					<th data-options="field:'prof1',formatter:formatprof1,width:70">专业1级分类</th>
					<th data-options="field:'prof2',formatter:formatprof2,width:100">专业2级分类</th>
					<th data-options="field:'level',width:80">等级</th>
					<th data-options="field:'fazheng',formatter:formatfazheng,width:80">发证日期</th>
					<th
						data-options="field:'province',formatter:formatprovince,width:80">省</th>
					<th data-options="field:'city',formatter:formatcity,width:80">市</th>
					<th data-options="field:'county',formatter:formatcounty,width:80">县</th>
					<th data-options="field:'town',formatter:formattown,width:80">地址</th>
					<th data-options="field:'number',width:100">证书编号</th>
					<th data-options="field:'writescore',width:50">笔试成绩</th>
					<th data-options="field:'interviewscore',width:50">面试成绩</th>
					<th data-options="field:'totalscore',width:50">总成绩</th>
				</tr>
			</thead>
		</table>
		<div id="dlg-buttons">
			<a href="xjexport.action" class="easyui-linkbutton c6" iconCls="icon-ok"
				style="width:90px">导出</a> <a href="javascript:void(0)"
				class="easyui-linkbutton" iconCls="icon-cancel"
				onclick="javascript:$('#dlg').dialog('close')" style="width:90px">取消</a>
		</div>
	</div>
</body>
</html>

