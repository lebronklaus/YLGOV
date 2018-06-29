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


<link rel="stylesheet" type="text/css" href="system/layout/back/css/xxwh.css">
<link rel="stylesheet" type="text/css" href="system/layout/back/css/easyui.css">
<link rel="stylesheet" type="text/css" href="system/layout/back/css/color.css">
<link rel="stylesheet" type="text/css" href="system/layout/back/css/demo.css">
<link rel="stylesheet" type="text/css" href="system/layout/back/css/icon.css">
<script type="text/javascript" src="system/layout/back/js/jquery.min.js"></script>
<script type="text/javascript" src="system/layout/back/js/jquery.easyui.min.js"></script>
<script type="text/javascript" src="faxuqiu/js/jishu.js"></script>
<script charset="utf-8" src="kindeditor/kindeditor.js"></script>
	<script charset="utf-8" src="kindeditor/lang/zh_CN.js"></script>
	<script>
    	  KindEditor.ready(function(K) {
     	        window.editor = K.create('#inputNote');
     	 });
	</script>
	<script type="text/javascript">
		$(document).ready(function(){
				var a = $("#mark",window.parent.document).val();
				$("#mark").attr("value",a);
		});
	</script>
	<!-- annotated by xiuhao.yan  -->
	<!-- 
	<script type="text/javascript">
		$(document).ready(function(){
				var a = $("#mark",window.parent.document).val();
				$("#mark").attr("value",a);
				if(a==0 ){
					$("#tr0").hide();
					$("#tr1").hide();
					$("#tr2").hide();
					$("#tr3").hide();
					$("#tr4").hide();
					$("#tr5").hide();
					$("#tr6").hide();
					$("#tr7").hide();
				}else{
					$("#tr8").hide();
					$("#tr9").hide();
				}
		});
	</script>
	 -->
	<script>
	// add by xiuao.yan on 06/10/2018
		 $(document).ready(function(){
		 	$("#type").combobox({
        	onChange: function (n,o) {
            var a=$('#type').combobox('getValue');
            document.getElementById("mark").value=a;
           if(a==0 ){
					$("#tr1").hide();
					$("#tr2").hide();
					$("#tr3").hide();
					$("#tr4").hide();
					$("#tr6").hide();
					$("#tr7").hide();
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
	
	<div id="main" align="center" style="padding:10px;" class="easyui-panel"  title="发布需求—发布技术需求">
	<fieldset style="width:757px;">
			<legend style="font-size:20px;font-family: 微软雅黑;font-weight:bold;">发布技术需求</legend>
			<div style="height:20px"></div>
		<table>
			<%-- <tr >
				<td style="height: 50px;font-weight: bold;" align="center" colspan="4"><span > 发布技术需求</span></td>
			</tr> --%>
			<tr>
				<td width="84px" height="38"><span> 需求对象：</span></td>
				<td><select id="type" class="easyui-combobox" required data-options="missingMessage:'必填'"
					style="width:285px;height:30px;" editable="false"
					panelHeight="auto">
    					<option value="0">农民</option>
    					<option value="1" selected="selected">企业</option>
    					<option value="2">园区</option>
					</select>
			</tr>
			<tr>
				<td width="84px" height="38"><span>需求名称：</span></td>
				<td width="287"><input name="tt.teacher_name" id="mingcheng" class="easyui-textbox"
					style="width:285px;height:30px;" required
					data-options="missingMessage:'必填'"></td>
				
				<td width="84px" height="38"><span> 所属领域：</span></td>
				<td><select id="lingyu" class="easyui-combobox" name="tt.teacher_sex"
					required data-options="missingMessage:'必填'"
					style="width:285px;height:30px;" editable="false"
					panelHeight="auto">
						<option value="zhongzhi">种植</option>
	                    <option value="yangzhi" >养殖</option>                      
	                    <option value="nongzi" >农资</option>                      
	                    <option value="jiagong" >加工</option>                      
	                    <option value="nongji" >农机</option>                      
	                    <option value="nengyuan" >能源</option>                      
	                    <option value="fuwu" >服务</option>                      
	                    <option value="qita" >其他</option>   
				</select></td>
			</tr>
			
			<tr id="tr1">
				<td width="84px"  height="38"><span> 需求单位：</span></td>
				<td><input name="tt.teacher_workplace"  id="company"  class="easyui-textbox"
					style="width:285px;height:30px;"
					data-options="missingMessage:'必填'" required></td>
				
				<td width="84px" height="38"><span> 单位地址：</span></td>
				<td><input name="tt.teacher_workplace"  id="address"  class="easyui-textbox"
					style="width:285px;height:30px;"
					data-options="missingMessage:'必填'" required></td>
			</tr>
			
			<tr id="tr2">
				<td width="84px" height="38"><span> 技术职称：</span></td>
				<td><input name="tt.teacher_professional"  id="profession" class="easyui-textbox"
					style="width:285px;height:30px;" required
					data-options="missingMessage:'必填'"></td>
						
				<td width="84px" height="38"><span> 单位电话：</span></td>
				<td><input  name="tt.teacher_phonenum" id="phonenum" class="easyui-textbox"
					style="width:285px;height:30px;" required
					data-options="missingMessage:'必填'"></td>
			</tr>
			
			<tr id="tr3">
				<td width="84px" height="38"><span> 单位类型：</span></td>
				<td><input name="tt.teacher_university"  id="companytype" class="easyui-textbox"
					style="width:285px;height:30px;" required
					data-options="missingMessage:'必填'"></td>
						
				<td width="84px" height="38"><span> 所属行业：</span></td>
				<td><input name="tt.teacher_major"  id="hangye" class="easyui-textbox"
					style="width:285px;height:30px;" required
					data-options="missingMessage:'必填'"></td>
			</tr>
			
			<tr id="tr4">
				<td width="84px" height="38" ><span> 联系人员：</span></td>
				<td id="tr5"><input  name="tt.teacher_address" id="lianxiren" class="easyui-textbox"
					style="width:285px;height:30px;" required
					data-options="missingMessage:'必填'"></td>
					
				<td width="84px" height="38"><span> 联系地址：</span></td>
				<td><input  name="tt.teacher_address" id="lianxiadd" class="easyui-textbox"
					style="width:285px;height:30px;" required
					data-options="missingMessage:'必填'"></td>
			</tr>
			
			<tr id="tr5">
				<td width="84px" height="38"><span> 联系电话：</span></td>
				<td ><input  name="tt.teacher_email" id="tel" class="easyui-textbox"
					style="width:285px;height:30px;" required
					data-options="missingMessage:'必填'"></td>
					
				<td width="84px" height="38"><span> 电子邮件：</span></td>
				<td><input  name="tt.teacher_address" id="email" class="easyui-textbox"
					style="width:285px;height:30px;" required
					data-options="missingMessage:'必填'"></td>
			</tr>
			
			<tr id="tr6">		
				<td width="84px" height="38"><span> 邮政编码：</span></td>
				<td><input  name="tt.teacher_email" id="youbian" class="easyui-textbox"
					style="width:285px;height:30px;" required
					data-options="missingMessage:'必填'"></td>
			</tr>
			<!-- 
			<tr id="tr7" >
				<td width="84px" height="38"><span> 电子邮件：</span></td>
				<td><input  name="tt.teacher_address" id="email" class="easyui-textbox"
					style="width:285px;height:30px;" required
					data-options="missingMessage:'必填'"></td>
				
				
			</tr>
			 -->
			<tr> <td><div style="height:3px;"></div></td></tr>
			<tr>
				<td width="84px" valign="top" height="38"><span> 需求说明：</span></td>
				<td colspan="3"><textarea style="width: 100%;height:410px;" class="form-control" id="inputNote" rows="5" name="tt.teacher_profile"></textarea>
			</tr>
		</table>
			<div style="text-align:center;padding:10px">
				<a href="javascript:void(0)" class="easyui-linkbutton"
					iconCls="icon-ok" style="width:20%;height:40px;"
					onclick="uploadUser()"><span style="font-size:16px">保存</span></a>
			</div>
			</fieldset>
		<input  id="mark" style=" display:none;" value="1">
	</div>
	<!--main -->
	
</body>
</html>
