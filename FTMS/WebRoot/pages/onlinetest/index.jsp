<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	request.setCharacterEncoding("UTF-8");
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>pages/onlinetest/">

<title>职业农民在线自测与考试系统</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<link rel="stylesheet" type="text/css" href="styles.css">
<link rel="stylesheet" type="text/css"
	href="<%=basePath%>css/easyui.css">
<link rel="stylesheet" type="text/css" href="<%=basePath%>css/icon.css">
<link rel="stylesheet" type="text/css"
	href="<%=basePath%>css/onlinetest.css">
<script type="text/javascript" src="<%=basePath%>js/jquery.min.js"></script>
<script type="text/javascript"
	src="<%=basePath%>js/jquery.easyui.min.js"></script>
<script type="text/javascript" src="<%=basePath%>js/combobox.js"></script>
<script type="text/javascript" src="<%=basePath%>js/onlinetest.js"></script>
</head>

<body>
	<div id="main">
		<div class="easyui-panel" title="欢迎!"
			data-options="region:'center'" style="width:100%;padding:10px;">
			<div class="easyui-panel" title="试卷详情" data-options="region:'center'"
				style="width:100%;padding:10px;margin-bottom:10px">
				<table class="altrowstable" id="alternatecolor" align="center"
					style="font-size:14px;">
					<tr>
						<th colspan="2">试题组成类型、分值、数量</th>
						<th>考试时间</th>
						<th>总分</th>
					</tr>
					<tr>
						<td>选择题<s:property value="xuanzecount" />题,<s:property
								value="score_xuanze" />分/题
						</td>
						<td>判断题<s:property value="panduancount" />题,<s:property
								value="score_panduan" />分/题
						</td>
						<td><s:property value="time" />分钟</td>
						<td><s:property value="total" /></td>
					</tr>
				</table>
			</div>
			<div class="easyui-panel" title="答题须知" data-options="region:'center'"
				style="width:100%;padding:10px;margin-bottom:10px; font-size:14px">
				<ol>
					<li>正式考试为笔试、闭卷形式；考试时间为90分钟。</li>
					<li>正式考试试卷由名词解释、选择题、判断题、填空题、简答题和论述题六个部分组成。</li>
					<li>网络测试样题每专业不分级别，仅提供了选择题40个和判断题40个，试题答案仅供参考，满分为120分。</li>
					<li>请在规定时间内答完题目。</li>
					<li>答题过程中请勿刷新页面。</li>
					<li>答完题目后请点击交卷按钮提交试卷，到规定时间时将自动提交。</li>
					<li>交卷后将显示答题详情，试题不做保存，请及时查阅。</li>
				</ol>
			</div>
			<div class="easyui-panel" title="请选择专业和级别："
				data-options="region:'center'"
				style="width:100%;padding:10px; margin-bottom:10px;">
				<span style="margin-right: 220px"></span> <select
					class="easyui-combobox" id="level1" style="width:90px;"
					editable="false" panelHeight="auto" valueField="value" textField="text">
					<option value="果树管理">果树管理</option>
					<option value="设施蔬菜">设施蔬菜</option>
					<option value="畜牧养殖">畜牧养殖</option>
					<option value="植物保护">植物保护</option>
					<option value="其它">其它</option>
				</select> <select class="easyui-combobox" id="profession1"
					style="width:200px;" editable="false" panelHeight="auto" valueField="value" textField="text">
					<option value="果树嫁接技术">果树嫁接技术</option>
					<option value="苹果栽培管理技术">苹果栽培管理技术</option>
					<option value="猕猴桃栽培管理技术">猕猴桃栽培管理技术</option>
					<option value="枣栽培管理技术（冬枣）">枣栽培管理技术（冬枣）</option>
					<option value="核桃栽培管理技术">核桃栽培管理技术</option>
					<option value="杂果栽培管理技术（桃、杏、樱桃）">杂果栽培管理技术（桃、杏、樱桃）</option>
				</select> <select class="easyui-combobox" id="difficulty"
					style="width:100px;" editable="false" panelHeight="auto" valueField="value" textField="text">
					<option value="初级">农技员</option>
					<option value="中级">农技师</option>
					<option value="高级">高级农技师</option>
				</select> <a href="javascript:void(0)" id="zujuan"
					style="width:200; height:40; margin-left:340px;margin-top: 10px"
					class="easyui-linkbutton" onclick="zujuan()"><h3>开始答题</h3></a>
			</div>
		</div>

	</div>
</body>
</html>
