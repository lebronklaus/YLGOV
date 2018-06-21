<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@  taglib uri="/struts-tags" prefix="s"%>
<!doctype html>
<%
	String path = request.getContextPath();
%>
<html lang="zh-CN">
	<head>
		<meta charset="UTF-8">
		<link rel="stylesheet" href="../../../../style/common.css" type="text/css" />
		<link rel="stylesheet" href="../../../../style/tzhi.css" type="text/css" />
		<link rel="stylesheet" href="../../../../style/main.css" type="text/css" />
	<script type="text/javascript" src="../../../../js/jquery.js"></script>
	<script type="text/javascript" src="../../../../js/jquery.idTabs.min.js"></script>
	<script type="text/javascript" src="../../../../js/select-ui.min.js"></script>
	<script type="text/javascript" src="../../../../editor/kindeditor.js"></script>
		<script type="text/javascript">
					 KE.show({
        id : 'content7',
        cssPath : './index.css'
    });
    
    $(document).ready(function(e) {
    $(".select1").uedSelect({
		width : 345			  
	});
	$(".select2").uedSelect({
		width : 167  
	});
	$(".select3").uedSelect({
		width : 100
	});
});
		
	$(function() {
		$(".list_table").colResizable({
			liveDrag : true,
			gripInnerHtml : "<div class='grip'></div>",
			draggingClass : "dragging",
			minWidth : 30
		});
	});
	
		function datesub()
	{
//	alert("sss");
	var now=new Date();
	var years=now.getFullYear();
	var month=now.getMonth()+1;
	var day=now.getDate();
	var sub=document.getElementById("datea");
	sub.value=years+"-"+month+"-"+day;
	// alert(sub.value);
//if(confirm("are you ok?"))
//{
//return true;
//}
//else
//return false;
	}
	
	
</script>
		<title>Document</title>
	</head>
	<body>
		<div class="container" style=" background: url(../images/bimages/itabbg.png) 0px 0px repeat-x;">
			<div id="search_bar" class="mt10">
				<div class="box">
					<div class="box_border">
						<div class="box_top">
							<b class="pl15" style="font-size: 20px;">通知信息发布:</b>
						</div>
						<div class="box_center pt10 pb10">

							<form action="<%=path %>/system/back/peixunfb.action" method="post"  enctype="multipart/form-data" validate="true">
								<table class="form_table"
									style="boder: 0; cellpadding: 0; cellsapcing: 0; width: 100%; height: 100%;">

									<tr>
										<td style="width: 10px;">
											标题
										</td>
										<td>
											<input type="text" name="peixun.title" class="input-text lh25"
												size="20">
										</td>
									</tr>
									<tr>
									<tr>
										<td style="width: 10px;">
											作者
										</td>
										<td>
											<input type="text" name="peixun.author" class="input-text lh25"
												size="20">
										</td>
									</tr>
									<tr>
										<td style="width: 1px;">
											备注
										</td>
										<td>
											<input type="text" name="peixun.remark" class="input-text lh25"
												size="20">
										</td>

									</tr>
									<tr>
										<td style="width: 10px;">
											正文
										</td>
										<td>
										<textarea name="peixun.text" id="content7" name="content" style="width:838px;height:330px; "></textarea>
											
										</td>
									</tr>
											<tr style="line-height: 100px;">
									<td style="width: 10px;text-align: center;">上传图片：
									</td>
									<td>
										 <input type="file" name="upload" id="a" class="input-text lh25"/>
									</td>
									</tr>
									<tr>
									<td>
									<input style="display:none"type="text" name="peixun.date" value="" id="datea" />
									</td>
									</tr>
									<tr>
										<td>
											<input type="submit" class="btn btn82 btn_search" onclick="datesub()"
												 value="马上发布" />
										</td>
									</tr>
								</table>
							</form>
						</div>

					</div>
				</div>
			</div>
		</div>
	</body>
</html>
