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
<base href="<%=basePath%>">

<title>My JSP 'Register.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

<link rel="stylesheet" type="text/css" href="system/layout/back/css/xxwh.css">
<link rel="stylesheet" type="text/css" href="system/layout/back/css/easyui.css">
<link rel="stylesheet" type="text/css" href="system/layout/back/css/color.css">
<link rel="stylesheet" type="text/css" href="system/layout/back/css/demo.css">
<link rel="stylesheet" type="text/css" href="system/layout/back/css/icon.css">
<script type="text/javascript" src="system/layout/back/js/jquery.min.js"></script>
<script type="text/javascript" src="system/layout/back/js/jquery.easyui.min.js"></script>
<script type="text/javascript" src="faxuqiu/js/peixun.js"></script>
<script charset="utf-8" src="kindeditor/kindeditor.js"></script>
	<script charset="utf-8" src="kindeditor/lang/zh_CN.js"></script>
	<script>
    	  KindEditor.ready(function(K) {
     	        window.editor = K.create('#inputNote');
     	 });
	</script>
	<script>
		function getQueryString(name) {
		var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)", "i");
		var r = window.location.search.substr(1).match(reg);
		if (r != null) return unescape(r[2]); return null;
		}
	</script>
	<!-- annotated by xiuhao.yan on 10/0/2018 -->
	<!-- 
	<script type="text/javascript">
		$(document).ready(function(){
				var a = $("#mark",window.parent.document).val();
				$("#mark").attr("value",a);				
				if(a==0 || a==1){
					$("#tr0").hide();
					$("#tr1").hide();
					$("#tr2").hide();
					$("#tr3").hide();
					$("#tr4").hide();
					$("#tr5").hide();
					$("#tr6").hide();
				}
		});
	</script>
	 -->
	
	<script>
	// add by xiuao.yan on 06/10/2018
		 $(document).ready(function(){
		 var from = getQueryString("type");
		if(from==0){
					$("#tr1").hide();
					$("#tr2").hide();
					$("#tr3").hide();
					$("#tr4").hide();
					$("#tr5").hide();
					$("#tr6").hide();
				}else{
					$("#tr1").show();
					$("#tr2").show();
					$("#tr3").show();
					$("#tr4").show();
					$("#tr5").show();
					$("#tr6").show();
				}
		 	$("#type").combobox({
        	onChange: function (n,o) {
            var a=$('#type').combobox('getValue');
            document.getElementById("mark").value=a;
            if(a==0){
					$("#tr1").hide();
					$("#tr2").hide();
					$("#tr3").hide();
					$("#tr4").hide();
					$("#tr5").hide();
					$("#tr6").hide();
				}else{
					$("#tr1").show();
					$("#tr2").show();
					$("#tr3").show();
					$("#tr4").show();
					$("#tr5").show();
					$("#tr6").show();
				}
        }
    })
		 })
		 
	</script>
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
	height: 100%;
	margin: 0;
}
</style>
</head>
<body>
	
	<div id="main" align="center" style="padding:10px;"class="easyui-panel"  title="编辑需求—修改培训需求">
	<fieldset style="width:757px;">
			<legend style="font-size:20px;font-family: 微软雅黑;font-weight:bold;">修改培训需求</legend>
			<div style="height:20px"></div>
		<table>
			<%-- <tr >
				<td style="height: 50px;font-weight: bold;" align="center" colspan="4"><span > 发布培训需求</span></td>
			</tr> --%>
			<tr>
				<td height="38"><span> 需求对象：</span></td>
				<td><select id="type" class="easyui-combobox" required data-options="missingMessage:'必填'"
					style="width:285px;height:30px;" editable="false"
					panelHeight="auto">
    					<option <s:if test='pxxq.mark ==0'> selected ="selected" </s:if> value="0">农民</option>
    					<option <s:if test='pxxq.mark ==2'> selected ="selected" </s:if> value="2">园区</option>
					</select>
			</tr>
			
			<tr id="tr1">
				<td width="84" height="38"><span>单位名称：</span></td>
				<td width="287"><input name="tt.teacher_name" id="companyname" class="easyui-textbox"
					style="width:285px;height:30px;" value="<s:property value="pxxq.companyname"/>"></td>
				
				<td width="84" height="38"><span>联系人员：</span></td>
				<td width="287"><input name="tt.teacher_name" id="lianxiren" class="easyui-textbox"
					style="width:285px;height:30px;"  value="<s:property value="pxxq.lianxiren"/>"></td>
			</tr>
			
			<tr id="tr2">
				<td height="38"><span> 联系电话：</span></td>
				<td><input name="tt.teacher_workplace"  id="tel"  class="easyui-textbox"
					style="width:285px;height:30px;"
					 value="<s:property value="pxxq.tel"/>"></td>
				
				<td height="38"><span> 传&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;真：</span></td>
				<td><input name="tt.teacher_workplace"  id="chuanzhen"  class="easyui-textbox"
					style="width:285px;height:30px;"
					 value="<s:property value="pxxq.chuanzhen"/>"></td>
			</tr>
			
			<tr id="tr3"> 
				<td height="38"><span> 培训时间：</span></td>
				<td><input name="tt.teacher_professional"  id="time" class="easyui-datebox"
					style="width:285px;height:30px;"  value="<s:property value="pxxq.time"/>"></td>
						
				<td height="38"><span> 培训地点：</span></td>
				<td><input  name="tt.teacher_phonenum" id="peixunadd" class="easyui-textbox"
					style="width:285px;height:30px;"  value="<s:property value="pxxq.peixunadd"/>"></td>
			</tr>
			
			<tr id="tr4">
				<td height="38"><span> 计划规模：</span></td>
				<td><input name="tt.teacher_university"  id="guimo" class="easyui-textbox"
					style="width:285px;height:30px;"  value="<s:property value="pxxq.guimo"/>"></td>
						
				<td height="38"><span>配合事项：</span></td>
				<td><input name="tt.teacher_major"  id="peiheshixiang" class="easyui-textbox"
					style="width:285px;height:30px;"  value="<s:property value="pxxq.peiheshixiang"/>"></td>
			</tr>
			<tr id="tr5"> <td><div style="height:3px;"></div></td></tr>
			<tr id="tr6">
				<td height="38"><span> 电子邮件：</span></td>
				<td><input  name="tt.teacher_address" id="email" class="easyui-textbox"
					style="width:285px;height:30px;"  value="<s:property value="pxxq.email"/>"></td>
			</tr>
			
			<tr>
				<td valign="top" height="38" style="width: 81px;"><span> 培训内容：</span></td>
				<td colspan="3"><textarea style="width: 100%;height:410px;" class="form-control" id="inputNote" rows="5" name="tt.teacher_profile"><s:property 	value="pxxq.content" escape="false"/>  </textarea>
			</tr>
		</table>
			<div style="text-align:center;padding:10px">
				<a href="javascript:void(0)" class="easyui-linkbutton"
					iconCls="icon-ok" style="width:20%;height:40px;"
					onclick="updateUser()"><span style="font-size:16px">保存</span></a>
			</div>
			</fieldset>
			 <input  id="mark" style="display:none; " value='2' >
		<!--  <input  id="mark" style="display:none; " value="<s:property value='#session.mark'/>">-->
	</div>
	<!--main -->
	<span id = "px_id" style="display:none;"><s:property value="pxxq.id"  /></span>
</body>
</html>
