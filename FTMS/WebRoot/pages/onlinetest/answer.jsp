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

<title>职业农民在线自测与考试系统-答案</title>

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

<body onbeforeunload="checkAnswer()">
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
						<th>得分</th>
					</tr>
					<tr>
						<td><s:property value="class1" /></td>
						<td><s:property value="profession" /></td>
						<td><s:property value="difficulty" /></td>
						<td>选择题<s:property value="xuanzecount" />题,<s:property value="score_xuanze" />分/题</td>
						<td>判断题<s:property value="panduancount" />题,<s:property value="score_panduan" />分/题</td>
						<td><s:property value="time" />分钟</td>
						<td><s:property value="total" /></td>
						<td><strong style="font-size:18px;"><s:property value="score" /></strong></td>
					</tr>
				</table>
			</div>
			<div class="easyui-panel" title="Ⅰ卷  选择题"
				data-options="region:'center'"
				style="width:100%;padding:10px;margin-bottom:10px">
				<s:iterator value="xuanze"  status="st">
				<s:if test="answer==useranswer">
				<ul>
					<li><h3><s:property value="#st.count" />.<s:property value="question" /></h3></li>
					<li><span style="font-weight: bold;">您的答案：</span><span><s:property value='useranswercontent'/></span></li>
				</ul>
				</s:if>
				<s:else>
				<ul class="error">
					<li><h3><s:property value="#st.count" />.<s:property value="question" /></h3></li>
					<li><span style="font-weight: bold;">您的答案：</span><span><s:property value='useranswercontent'/></span></li>
					<li><span style="font-weight: bold;">正确答案：</span><span><s:property value='answer'/>.<s:property value='answercontent'/></span></li>
				</ul>
				</s:else>
				</s:iterator>
			</div>
			<div class="easyui-panel" title="Ⅱ卷  判断题"
				data-options="region:'center'"
				style="width:100%;padding:10px;margin-bottom:10px">
				<s:iterator value="panduan"  status="st">
				<s:if test="answer==useranswer">
				<ul>
					<li><h3><s:property value="#st.count+xuanzecount" />.<s:property value="question" /></h3></li>
					<li><span style="font-weight: bold;">您的答案：</span><span><s:property value='useranswercontent'/></span></li>
				</ul>
				</s:if>
				<s:else>
				<ul class = "error">
					<li><h3><s:property value="#st.count+xuanzecount" />.<s:property value="question" /></h3></li>
					<li><span style="font-weight: bold;">您的答案：</span><span><s:property value='useranswercontent'/></span></li>
					<li><span style="font-weight: bold;">正确答案：</span><span><s:property value='answercontent'/></span></li>
				</ul>
				</s:else>
				</s:iterator>
			</div>
		</div>
	</div>
</body>
</html>
