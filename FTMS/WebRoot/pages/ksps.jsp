<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>pages/">
    
    <title>My JSP 'ksps.jsp' starting page</title>
    
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
        <script type="text/javascript" src="../js/pages/ksps.js"></script>
<style>
body{ padding:0;margin:0; height:100%;width:auto}
html{ height:100%;width:auto} 
#main {
	width: auto;
	margin: auto;
}
span{
	font-size:16px;
	font-family:"微软雅黑";
}
#fm{
    margin:0;
    padding:10px 30px;
}
.ftitle{
	font-size:14px;
    font-weight:bold;
    padding:5px 0;
    margin-bottom:10px;
    border-bottom:1px solid #ccc;
}
.fitem{
    margin-bottom:5px;
}
.fitem label{
    display:inline-block;
    width:80px;
}
.fitem input{
    width:160px;
}
</style>
</head>

<body>
	 <table id="dg" title="录入成绩" class="easyui-datagrid" style="width:auto;height:100%"
            toolbar="#toolbar"
            rownumbers="true" fitColumns="true" singleSelect="false" selectOnCheck="true" checkOnSelect="true"  pagination="true">
        <thead>
            <tr>
                <th field="name" width="50" >姓名</th>
                <th width="50" field="level">申报级别</th>
                <th width="50" field="totalscore">总成绩</th>
                <th width="50" field="number">证书编号</th>
            </tr>
        </thead>
    </table>
    <div id="toolbar">
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="newUser()">添加考生成绩</a>
    </div>
    
    <div id="dlg" class="easyui-dialog" style="width:400px;height:600px;padding:10px 20px"
            closed="true" buttons="#dlg-buttons">
        <div class="ftitle">考生成绩</div>
        <form id="fm" method="post" novalidate>
            <div class="fitem">
                <label>账号:</label>
                <input id="username" class="easyui-textbox" required data-options="missingMessage:'必填'">
            </div>
            <div class="fitem">
                <label>业绩:</label>
                <input id="achievement" class="easyui-textbox" required data-options="missingMessage:'必填'">
            </div>
            <div class="fitem">
                <label>总人数:</label>
                <input id="total" class="easyui-textbox" required data-options="missingMessage:'必填'">
            </div>
            <div class="fitem">
                <label>参加人数:</label>
                <input id="real" class="easyui-textbox" required data-options="missingMessage:'必填'">
            </div>
            <div class="fitem">
                <label>同意票:</label>
                <input id="approval" class="easyui-textbox" required data-options="missingMessage:'必填'">
            </div>
             <div class="fitem">
                <label>反对票:</label>
                <input id="opposition" class="easyui-textbox" required data-options="missingMessage:'必填'">
            </div>
            <div class="fitem">
                <label>评审时间:</label>
                <input id="checktime" class="easyui-datebox" required data-options="missingMessage:'必填'">
            </div>
            <div class="fitem">
                <label>职称名称:</label>
                <input id="level" class="easyui-textbox" required data-options="missingMessage:'必填'">
            </div>
            <div class="fitem">
                <label>证书编号:</label>
                <input id="number" class="easyui-textbox" required data-options="missingMessage:'必填'">
            </div>
            <div class="fitem">
                <label>发证日期:</label>
                <input id="fazhengtime" class="easyui-datebox" required data-options="missingMessage:'必填'">
            </div>
            <div class="fitem">
                <label>笔试成绩:</label>
                <input id="writescore" class="easyui-textbox" required data-options="missingMessage:'必填'">
            </div>
            <div class="fitem">
                <label>面试成绩:</label>
                <input id="interviewscore" class="easyui-textbox" required data-options="missingMessage:'必填'">
            </div>
            <div class="fitem">
                <label>总成绩:</label>
                <input id="totalscore" class="easyui-textbox" required data-options="missingMessage:'必填'">
            </div>
            </form>
    </div>
    <div id="dlg-buttons">
        <a href="javascript:void(0)" class="easyui-linkbutton c6" iconCls="icon-ok" onclick="saveUser()" style="width:90px">保存</a>
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-cancel" onclick="javascript:$('#dlg').dialog('close')" style="width:90px">取消</a>
    </div>
</body>
</html>

