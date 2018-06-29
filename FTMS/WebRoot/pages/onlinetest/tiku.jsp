<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>pages/onlinetest/">

<title>职业农民在线自测与考试系统-题库配置</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<link rel="stylesheet" type="text/css"
	href="<%=basePath%>css/easyui.css">
<link rel="stylesheet" type="text/css" href="<%=basePath%>css/icon.css">
<link rel="stylesheet" type="text/css"
	href="<%=basePath%>css/onlinetest.css">
<script type="text/javascript" src="<%=basePath%>js/jquery.min.js"></script>
<script type="text/javascript"
	src="<%=basePath%>js/jquery.easyui.min.js"></script>
<script type="text/javascript" src="<%=basePath%>js/tiku.js"></script>
<script type="text/javascript" src="<%=basePath%>js/combobox.js"></script>
<script type="text/javascript" src="<%=basePath%>js/onlinetest.js"></script>
<script type="text/javascript" src="<%=basePath%>js/datagrid.js"></script>
<script type="text/javascript"
	src="<%=basePath%>js/datagrid-detailview.js"></script>

</head>
<body>
	<div id="main">
		<div class="easyui-panel" title="欢迎!" data-options="region:'center'"
			style="width:100%;padding:10px;">
			<div class="easyui-panel" title="试卷配置" data-options="region:'center'"
				style="width:100%;padding:10px; margin-bottom:10px; font-size:14px">
				<form id="config" method="post">

					<table class="altrowstable" id="alternatecolor" align="center"
						style="font-size:14px;">
						<tr>
							<th scope="col" class="nobg">选择题</th>
							<th>判断题</th>
							<th>考试时间</th>
						</tr>
						<tr>
							<td><input class="easyui-numberbox"
								data-options="min:1,max:100" style="width:50px;"
								value='<s:property value="xuanzecount"/>' name="xuanzecount" />&nbsp;题，
								<input class="easyui-numberbox" data-options="min:1,max:100"
								style="width:50px;" value='<s:property value="score_xuanze" />'
								name="score_xuanze" />&nbsp;分/题</td>
							<td><input class="easyui-numberbox"
								data-options="min:1,max:100" style="width:50px;"
								value='<s:property value="panduancount" />' name="panduancount" />&nbsp;题，
								<input class="easyui-numberbox" data-options="min:1,max:100"
								style="width:50px;" value='<s:property value="score_panduan" />'
								name="score_panduan" />&nbsp;分/题</td>
							<td><input class="easyui-numberbox"
								data-options="min:1,max:600" style="width:50px;"
								value='<s:property value="time" />' name="time" />&nbsp;分钟</td>
						</tr>
					</table>
					<br /> <a href="javascript:void(0)" id="saveprops"
						style="width:100px; height:30px; margin-left:380px"
						class="easyui-linkbutton" onclick="saveproperties()"
						iconCls="icon-save">保存配置</a>
				</form>
			</div>
			<table class="easyui-datagrid" title="题库配置"
				style="width:100%;height:auto;" id="dg"
				data-options="rownumbers:true,singleSelect:false,pagination:true,autoRowHeight:false,selectOnCheck:true,checkOnSelect:true,
			pageSize:20,method:'post', toolbar:'#tb'">
				<thead>
					<tr>
						<th
							data-options="field:'id',width:40,align:'center',checkbox:true">序号</th>
						<th data-options="field:'profession',width:90,align:'left'">职业工种</th>
						<th data-options="field:'questionType',width:60,align:'center'">题目类型</th>
						<th data-options="field:'difficulty',width:60,align:'center'">难易程度</th>
						<th data-options="field:'question',width:160,align:'left'">题目要求</th>
						<th data-options="field:'selectionA',width:90,align:'left'">选项A</th>
						<th data-options="field:'selectionB',width:90,align:'left'">选项B</th>
						<th data-options="field:'selectionC',width:90,align:'left'">选项C</th>
						<th data-options="field:'selectionD',width:90,align:'left'">选项D</th>
						<th data-options="field:'answer',width:40,align:'center'">答案</th>
					</tr>
				</thead>
			</table>

			<div id="tb" style="padding:2px 5px;">
				<a href="javascript:void(0)" class="easyui-linkbutton"
					iconCls="icon-add" title="添加" onclick="addquestion()">添加</a> <a
					href="javascript:void(0)" class="easyui-linkbutton"
					iconCls="icon-remove" title="删除" onclick="deletequestion()">删除</a>
				<a href="javascript:void(0)" class="easyui-linkbutton"
					iconCls="icon-edit" title="修改" onclick="editquestion()"
					style="margin-right: 20px">修改</a> <select class="easyui-combobox"
					id="class1" style="width:90px;" editable="false" panelHeight="auto"
					valueField="value" textField="text">
					<option value="请选择">请选择</option>
					<option value="果树管理">果树管理</option>
					<option value="设施蔬菜">设施蔬菜</option>
					<option value="畜牧养殖">畜牧养殖</option>
					<option value="植物保护">植物保护</option>
					<option value="其它">其它</option>
				</select> <select class="easyui-combobox" id="profession"
					style="width:150px;" editable="false" panelHeight="auto"
					valueField="value" textField="text">
					<option value="请选择">请选择</option>
				</select> <select class="easyui-combobox" id="questionType"
					style="width:80px;" editable="false" panelHeight="auto"
					valueField="value" textField="text">
					<option value="请选择">请选择</option>
					<option value="选择题">选择题</option>
					<option value="判断题">判断题</option>
				</select> <select class="easyui-combobox" id="difficulty" style="width:80px;"
					editable="false" panelHeight="auto" valueField="value"
					textField="text">
					<option value="请选择">请选择</option>
					<option value="初级">初级</option>
					<option value="中级">中级</option>
					<option value="高级">高级</option>
				</select> <input class="easyui-textbox" id="question" style="width:120px;" />
				<a href="javascript:void(0)" id="search" class="easyui-linkbutton"
					iconCls="icon-search" title="查询" onclick="submitSearch()">查询</a>
			</div>
		</div>
	</div>
	<div id="w" class="easyui-window" title=" 添加题目"
		data-options="modal:true,closed:true,iconCls:'icon-add',resizable:false,maximizable:false,minimizable:false,collapsible:false,right:'',bottom:''"
		style="width:500px;height:370px;padding:10px;">
		<form id="curd" method="post">
			<strong>从事专业：</strong> <select class="easyui-combobox" id="level1"
				style="width:90px;" editable="false" panelHeight="auto"
				valueField="value" textField="text">
				<option value="果树管理">果树管理</option>
				<option value="设施蔬菜">设施蔬菜</option>
				<option value="畜牧养殖">畜牧养殖</option>
				<option value="植物保护">植物保护</option>
				<option value="其它">其它</option>
			</select> <select class="easyui-combobox" id="profession1"
				name="tiku.profession" style="width:150px;" editable="false"
				panelHeight="auto" valueField="value" textField="text">
				<option value="果树嫁接">果树嫁接</option>
				<option value="苹果栽培管理">苹果栽培管理</option>
				<option value="猕猴桃栽培管理">猕猴桃栽培管理</option>
				<option value="枣栽培管理（冬枣）">枣栽培管理（冬枣）</option>
				<option value="核桃栽培管理">核桃栽培管理</option>
				<option value="杂果栽培管理（桃、杏、樱桃）">杂果栽培管理（桃、杏、樱桃）</option>
			</select> <br />
			<br /> <strong>难易程度：</strong> <select class="easyui-combobox"
				name="tiku.difficulty" id="difficulty1" style="width:80px;"
				editable="false" panelHeight="auto" valueField="value"
				textField="text">
				<option value="易">易</option>
				<option value="中">中</option>
				<option value="难">难</option>
			</select> <strong>题目类型：</strong> <select class="easyui-combobox"
				name="tiku.questionType" id="questionType1" style="width:80px;"
				editable="false" panelHeight="auto" valueField="value"
				textField="text">
				<option value="选择题">选择题</option>
				<option value="判断题">判断题</option>
			</select>
			<table cellpadding="5" style="font-size:12px">
				<tr>
					<td><strong>题目：</strong></td>
					<td><input class="easyui-textbox" type="text" id="Q"
						name="tiku.question" value="" data-options="required:true"
						style="width:380px"></input></td>
				</tr>
				<tr>
					<td><strong>选项A：</strong></td>
					<td><input id="A" class="easyui-textbox" type="text"
						name="tiku.selectionA" value="" data-options="required:true"
						style="width:380px"></input></td>
				</tr>
				<tr>
					<td><strong>选项B：</strong></td>
					<td><input id="B" class="easyui-textbox" type="text"
						name="tiku.selectionB" value="" data-options="required:true"
						style="width:380px"></input></td>
				</tr>
				<tr>
					<td><strong>选项C：</strong></td>
					<td><input id="C" class="easyui-textbox" type="text"
						name="tiku.selectionC" value="" data-options="required:true"
						style="width:380px"></input></td>
				</tr>
				<tr>
					<td><strong>选项D：</strong></td>
					<td><input id="D" class="easyui-textbox" type="text"
						name="tiku.selectionD" value="" data-options="required:true"
						style="width:380px"></input></td>
				</tr>
				<tr>
					<td><strong>答案：</strong></td>
					<td><select class="easyui-combobox" name="tiku.answer"
						id="answers" style="width:60px" panelHeight="auto"
						valueField="value" textField="text">
							<option value="A">A</option>
							<option value="B">B</option>
							<option value="C">C</option>
							<option value="D">D</option>
					</select></td>
				</tr>
			</table>
		</form>
		<div style="text-align:center;">
			<a href="javascript:void(0)" style="width:80px;height:30"
				iconCls='icon-add' class="easyui-linkbutton"
				onclick="savequestion()" id="bt_ae">添加</a> <a
				href="javascript:void(0)" style="width:80px;height:30"
				iconCls='icon-cancel' class="easyui-linkbutton"
				onclick="$('#w').window('close')">取消</a>
		</div>
	</div>
</body>
</html>
