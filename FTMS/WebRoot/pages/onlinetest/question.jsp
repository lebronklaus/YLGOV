<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
 <%@ page contentType="text/html; charset=UTF-8"%>
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

<title>职业农民在线自测与考试系统-试题</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<link rel="stylesheet" type="text/css" href="<%=basePath%>css/easyui.css">
<link rel="stylesheet" type="text/css" href="<%=basePath%>css/icon.css">
<link rel="stylesheet" type="text/css" href="<%=basePath%>css/onlinetest.css">
<script type="text/javascript" src="<%=basePath%>js/jquery.min.js"></script>
<script type="text/javascript" src="<%=basePath%>js/jquery.easyui.min.js"></script>
<script type="text/javascript" src="<%=basePath%>js/onlinetest.js"></script>
</head>

<body onbeforeunload="checkLeave()" onunload="unloadquestion()">
	<div id="main">
		<div class="easyui-panel" title="欢迎!"
			data-options="region:'center'" style="width:100%;padding:10px;">
			<div class="easyui-panel" title="试卷详情" data-options="region:'center'"
				style="width:100%;padding:10px;margin-bottom:10px">
				<table class="altrowstable" id="alternatecolor" align="center"
					style="font-size:14px;">
					<tr>
						<th scope="col" class="nobg" colspan="2">从事专业</th>
						<th>职称级别</th>
						<th colspan="2">试题组成类型、分值、数量</th>
						<th>考试时间</th>
						<th>总分</th>
					</tr>
					<tr>
						<td><span id="class1"><s:property value="class1" /></span></td>
						<td><span id="profession"><s:property value="profession" /></span></td>
						<td><span id="difficulty"><s:if test='difficulty=="初级"'>农技员</s:if> <s:elseif
								test='difficulty=="中级"'>农技师</s:elseif> <s:else>高级农技师</s:else></span></td>
						<td>选择题<s:property value="xuanzecount" />题,<s:property value="score_xuanze" />分/题</td>
						<td>判断题<s:property value="panduancount" />题,<s:property value="score_panduan" />分/题</td>
						<td><span id="time"><s:property value="time" /></span>分钟</td>
						<td><s:property value="total" /></td>
					</tr>
				</table>
			</div>
			<div class="easyui-panel" title="剩余时间" data-options="region:'center'"
				style="width:100%;padding:10px;margin-bottom:10px">
				<h2 align="center"><span id="min"></span>分<span id="sec"></span>秒</h2>
			</div>
			<div class="easyui-panel" title="Ⅰ卷  选择题"
				data-options="region:'center'"
				style="width:100%;padding:10px;margin-bottom:10px">
				<s:iterator value="xuanze"  status="st">
				<ul>
					<li><h3><s:property value="#st.count" />.<s:property value="question" /></h3></li>
					<li><input type="radio" onclick="panti()" name="q<s:property value='id' />" value="A" /><span>A.<s:property value="selectionA" /></span></li>
					<li><input type="radio" onclick="panti()" name="q<s:property value='id' />" value="B" /><span>B.<s:property value="selectionB" /></span></li>
					<li><input type="radio" onclick="panti()" name="q<s:property value='id' />" value="C" /><span>C.<s:property value="selectionC" /></span></li>
					<li><input type="radio" onclick="panti()" name="q<s:property value='id' />" value="D" /><span>D.<s:property value="selectionD" /></span></li>
				</ul>
				</s:iterator>
			</div>
			<div class="easyui-panel" title="Ⅱ卷  判断题"
				data-options="region:'center'"
				style="width:100%;padding:10px;margin-bottom:10px">
				<s:iterator  value="panduan" status="st">
				<ul>
					<li><h3><s:property value="#st.count+xuanzecount"/>.<s:property value="question" /></h3></li>
					<li><input type="radio" onclick="panti()" name="q<s:property value='id' />" value="T" /><span>正确</span></li>
					<li><input type="radio" onclick="panti()" name="q<s:property value='id' />" value="F" /><span>错误</span></li>
				</ul>
				</s:iterator>
			</div>
			<span id="sjbh" style="display:none"><s:property value='sjbh' /></span>
			<a href="javascript:void(0)" id ="jiaojuan1" target="_blank"
   style="width:200; height:40; margin-left:340px"
   class="easyui-linkbutton" onclick="jiaojuan()" ><h3>交&nbsp;卷</h3></a>
</div>

	</div>
	<div id="win" class="easyui-window" title="交卷提示" data-options="modal:true,closed:true,resizable:false,maximizable:false,minimizable:false,closable:false,collapsible:false" style="width:320px;height:240px;padding:10px;">
	<h1 style="margin-top: 40px" align="center">答题时间到，请交卷！</h1>
	<a href="javascript:void(0)" id ="jiaojuan2" target="_blank"
   style="width:200; height:40;margin-left: 50px"
   class="easyui-linkbutton" onclick="mustjiaojuan()" ><h3>交&nbsp;卷</h3></a>
	</div>
</body>
</html>
