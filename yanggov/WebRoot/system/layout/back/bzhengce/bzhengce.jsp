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
	
	function datesub1()
	{
 	//alert("sss");
	var now=new Date();
	var years=now.getFullYear();
	var month=now.getMonth()+1;
	var day=now.getDate();
	var sub=document.getElementById("dateaq");
	sub.value=years+"-"+month+"-"+day;
	  alert(sub.value);
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
		<div class="container">
			<div id="search_bar" class="mt10">
				<div class="box">
					<div class="box_border">
						<div class="box_top">
							<b class="pl15" style="font-size: 20px;">政策信息发布:</b>
						</div>
						<div class="box_center pt10 pb10">

							<form action="<%=path %>/system/back/zhengcefb.action" method="post" enctype="multipart/form-data" validate="true">
								<table class="form_table"
									style="boder: 0; cellpadding: 0; cellsapcing: 0; width: 900px; height: 100%;">

									<tr style="width:900px;">
										<td style="width:15%;border: 0px solid;">
											标题
										</td>
										<td style="border: 0px solid;width: 35%;">
											<input type="text" name="zhengce.title"  class="input-text lh25"
												size="20">
										</td>
										<td style="width: 10%;border: 0px solid;">索引号</td>
										<td style="width:40%;border: 0px solid;">
										<input type="text" name="zhengce.suoyinhao" class="input-text lh25">
										</td>
									</tr>
									<tr>
										<td style="width: 15%;border: 0px solid;">
											备注
										</td>
										<td style="width: 35%;border: 0px solid;">
											<input type="text" name="zhengce.remark" class="input-text lh25"
												size="20">
										</td>
										<td style="width: 15%;">公开目录</td>
										<td style="width:35%;">
										<input type="text" name="zhengce.gongkaimulu" class="input-text lh25">
										</td>
									</tr>
									<tr>
										<td style="width: 15%;">发布机构</td>
										<td style="width:35%;">
										<input type="text" name="zhengce.fabujigou" class="input-text lh25">
										</td>
										<td style="width: 10%;">文号</td>
										<td style="width:40%;">
										<input type="text" name="zhengce.wenhao" class="input-text lh25">
										</td>
									</tr>
									<tr>
										<td style="width: 15%;">主题词</td>
										<td style="width: 35%;">
										<input type="text" name="zhengce.zhutici" class="input-text lh25">
										</td>
<!--										<td style="width: 10%;">索引号</td>-->
<!--										<td style="width: 40%;">-->
<!--										<input type="text" name="zhengce.suoyinhao" class="input-text lh25">-->
<!--										</td>-->
									</tr>
									
									<tr>
										<td style="width: 15%;">
											正文
										</td>
										<td colspan="3">
										<textarea name="zhengce.text" id="content7" name="content" style="width:700px;height:330px; "></textarea>
									
										</td>
									</tr>
									
									<tr style="line-height: 100px;">
									<td style="width: 10%; ">上传附件：
									</td>
									<td colspan="3" style="border: 0px solid;">
									<input type="file" name="upload" id="a" class="input-text lh25"/>
									</td>
									</tr>
									
									<tr>
									<td colspan="4">
									<input style="display:none"type="text" name="zhengce.date" value="" id="dateaq" />
									</td>
									</tr>
									<tr >
									<td style="  padding-top: 30px;">
									<input type="radio" name="zhengce.mark" value="0" id="0" checked><label for="0">中省政策</label></td>
									<td style="  padding-top: 30px;" colspan="3">
									<input type="radio" name="zhengce.mark" value="1" id="1"><label for="1">杨凌政策</label>
									</td>
									<td></td>
									<td></td>
									</tr>
									<tr>
										<td colspan="4">
											<input type="submit" class="btn btn82 btn_search"
												 value="马上发布" onClick="datesub1()" />
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
