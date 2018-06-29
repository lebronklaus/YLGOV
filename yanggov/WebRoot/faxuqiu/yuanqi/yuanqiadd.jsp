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
<script type="text/javascript" src="faxuqiu/js/yuanqi.js"></script>
<script charset="utf-8" src="kindeditor/kindeditor.js"></script>
	<script charset="utf-8" src="kindeditor/lang/zh_CN.js"></script>
	<script>
    	  KindEditor.ready(function(K) {
     	        window.editor = K.create('#inputNote');
     	 });
    // add by xiuhao.yan on 06/11/2018
    $(document).ready(function() {
    	$('#yuanqu').attr('style',"display:none;");
	   	$('#yuanqumingcheng').attr('style',"display:none;");
	   	$('#yuanqufuzeren').attr('style',"display:none");
	   	$('#yuanqujianjie').attr('style',"display:none");
    	$("#type").combobox({
        	onChange: function (n,o) {
            var a=$('#type').combobox('getValue');
            document.getElementById("mark").value=a;
            if(a==1){
            	$('#yuanqu').attr('style',"display:none;");
	   			$('#yuanqumingcheng').attr('style',"display:none;");
	   			$('#yuanqufuzeren').attr('style',"display:none");
	   			$('#yuanqujianjie').attr('style',"display:none");
	   			$('#qiye').attr('style',"display:inline");
	   			$('#qiyemingcheng').attr('style','display:inline');
	   			$('#qiyefuzeren').attr('style','display:inline');
	   			$('#qiyejianjie').attr('style',"display:inline");
            }else{
            	$('#qiye').attr('style',"display:none");
	   			$('#qiyemingcheng').attr('style','display:none');
	   			$('#qiyefuzeren').attr('style','display:none');
	   			$('#qiyejianjie').attr('style',"display:none");
	   			$('#yuanqu').attr('style',"display:inline;");
	   			$('#yuanqumingcheng').attr('style',"display:inline;");
	   			$('#yuanqufuzeren').attr('style',"display:inline");
	   			$('#yuanqujianjie').attr('style',"display:inline");
            }
        	}
    	})
    	/* 
    	//annotated by xiuhao.yan on 06/11/2018
	    var mark = $("#mark",window.parent.document).attr("value");
	    $('#mark').attr("value",mark);
	   	if(mark==1){
	   		$('#yuanqu').attr('style',"display:none;");
	   		$('#yuanqumingcheng').attr('style',"display:none;");
	   		$('#yuanqufuzeren').attr('style',"display:none");
	   		$('#yuanqujianjie').attr('style',"display:none")
	   	}else if(mark==2){
	   		$('#qiye').attr('style',"display:none");
	   		$('#qiyemingcheng').attr('style','display:none');
	   		$('#qiyefuzeren').attr('style','display:none');
	   		$('#qiyejianjie').attr('style',"display:none");
	   	}
	   	*/
});
	</script>
	<script type="text/javascript">
		$(document).ready(function(){
				var a = $("#mark",window.parent.document).val();
				$("#mark").attr("value",a);
		});
	</script>
<style>
body {
	padding: 0;
	margin: 0;
	height: auto;//原来是100%
	width: auto
}

html {
	height: auto;
	width: auto
}

#main {
	width: auto;
	height: auto;
	margin: 0;
}
</style>
</head>
<body>
	
	<div id="main" align="center" style="padding:10px;" class="easyui-panel"  title="园企信息—编辑信息">
	<fieldset style="width:757px;">
			<legend  id="qiye" style="font-size:20px;font-family: 微软雅黑;">发布企业信息</legend>
			<legend  id="yuanqu" style="font-size:20px;font-family: 微软雅黑;">发布园区信息</legend>
			<div style="height:20px"></div>
		<table>
			<tr >
				<%-- <td style="height: 50px;font-weight: bold;" align="center" colspan="4"><span id="qiye"> 发布企业信息</span>
				<span id="yuanqu"> 发布园区信息</span></td> --%>
			</tr>
			<tr>
				<td width="84px" height="38"><span> 园企类别：</span></td>
				<td><select id="type" class="easyui-combobox" required data-options="missingMessage:'必填'"
					style="width:285px;height:30px;" editable="false"
					panelHeight="auto">
    					<option value="1" selected="selected">企业</option>
    					<option value="2">园区</option>
					</select>
			</tr>
			<tr>
				<td width="84" height="38"><span id="qiyemingcheng"> 企业名称：</span>
				<span id = "yuanqumingcheng"> 园区名称：</span></td>
				<td width="287"><input name="tb.base_name" id="name" class="easyui-textbox"
					style="width:285px;height:30px;" required
					data-options="missingMessage:'必填'"></td>
						
				<td height="38"><span id="qiyefuzeren"> 负责人&nbsp;&nbsp;&nbsp;：</span>
				<span id="yuanqufuzeren"> 负责人&nbsp;&nbsp;&nbsp;：</span></td>
				<td><input name="tb.base_contact"  id="fuzeren"  class="easyui-textbox"
					style="width:285px;height:30px;"
					data-options="missingMessage:'必填'" required></td>
			</tr>
			<tr>
				<td width="84" height="38"><span> 联系电话：</span></td>
				<td width="287"><input name="tb.base_name" id="tel" class="easyui-textbox"
					style="width:285px;height:30px;" required
					data-options="missingMessage:'必填'"></td>
						
				<td height="38"><span> 联系地址：</span></td>
				<td><input name="tb.base_contact"  id="address"  class="easyui-textbox"
					style="width:285px;height:30px;"
					data-options="missingMessage:'必填'" required></td>
			</tr>
			<tr> <td><div style="height:3px;"></div></td></tr>
			<tr>
				<td valign="top" height="38"><span id="qiyejianjie">企业简介：</span>
				<span id="yuanqujianjie"> 园区简介：</span></td>
				<td colspan="3"><textarea style="width: 100%;height:330px;" class="form-control" id="inputNote" rows="5" name="tb.base_profile"></textarea>
			</tr>
			
			
			<tr>
				<td height="200"><span> 远景照片：</span></td>
				<td align="center" colspan="3"><iframe name="framer"
						src="faxuqiu/yuanqi/yqupload1.jsp" width=100% height="100%" frameborder="0"></iframe></td>
			</tr>
			<tr>
				<td height="200"><span> 近景照片：</span></td>
				<td align="center" colspan="3"><iframe name="framer"
						src="faxuqiu/yuanqi/yqupload2.jsp" width=100% height="100%" frameborder="0"></iframe></td>
			</tr>
		</table>
			<div style="text-align:center;padding:10px">
				<a href="javascript:void(0)" class="easyui-linkbutton"
					iconCls="icon-ok" style="width:20%;height:40px;"
					onclick="uploadUser()"><span style="font-size:16px">保存</span></a>
			</div>
			</fieldset>
	</div>
	<span id="yq_path1" style=" display:none;" ></span>
	<span id="yq_path2" style=" display:none;"></span>
	<input  id="mark" style="display:none;" value="1" >
	<!--main -->
</body>
</html>
