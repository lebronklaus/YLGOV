<%@  taglib uri="/struts-tags" prefix="s"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!doctype html>
<html lang="zh-CN">
	<head>
		<meta charset="UTF-8">
		<link rel="stylesheet" href="../../style/tzhi.css" type="text/css" />
		<link rel="stylesheet" href="../../style/style.css" type="text/css" />
		<link rel="stylesheet" href="../../style/select.css" type="text/css" />
		
	<script type="text/javascript" src="../../js/jquery.js"></script>
	<script type="text/javascript" src="../../js/jquery.idTabs.min.js"></script>
	<script type="text/javascript" src="../../js/select-ui.min.js"></script>
	<script type="text/javascript" src="../../editor/kindeditor.js"></script>
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
 
	var now=new Date();
	var years=now.getFullYear();
	var month=now.getMonth()+1;
	var day=now.getDate();
	var sub=document.getElementById("datea");
	sub.value=years+"-"+month+"-"+day;
	  alert(sub.value);
 
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
							<b class="pl15">通知信息发布:</b>
						</div>
						<div class="box_center pt10 pb10">
						
<!--						<form action="upload.action" method="post" enctype="multipart/form-data">-->
<!--						上传图片：<input type="file" name="upload"/>-->
<!--						<input type="submit" value="上传"/>-->
<!--						</form>-->

							<form action="Tnewsgb" method="post" enctype="multipart/form-data" validate="true">
								<table class="form_table"
									style="boder: 0; cellpadding: 0; cellsapcing: 0; width: 100%; height: 100%;">

									<tr>
										<td style="width: 10px;text-align: center;">
											标题
										</td>
										
										<td>
											<input type="text" name="tzhi.title" class="input-text lh25"
												size="20">
										</td>
									</tr>
									<tr>
										<td style="width: 10px;text-align: center;">
											作者
										</td>
										
										<td>
											<input type="text" name="tzhi.author" class="input-text lh25"
												size="20">
										</td>
									</tr>
									<tr>
										<td style="width: 1px;text-align: center;">
											备注
										</td>
										<td>
											<input type="text" name="tzhi.remark" class="input-text lh25"
												size="20">
										</td>

									</tr>
									
<!--									<ul class="forminfo">-->
<!--    <li>-->
<!--    <textarea id="content7" name="content" style="width:700px;height:250px;visibility:hidden;"></textarea>-->
<!-- -->
<!--    </li>-->
<!--    </ul>-->
    
									<tr class="input-text lh25" style="background-color: #fff;">
										<td style="text-align: center;" >
											正文
										</td>
										<td >
		                    <textarea name="tzhi.text" id="content7" name="content" style="width:838px;height:330px; "></textarea>
<!--											<textarea name="tzhi.text" cols="20" rows="5"-->
<!--												class="textarea"></textarea>-->
										</td>
									</tr>
									
									<tr style="line-height: 100px;">
									<td style="width: 10px;text-align: center;">上传附件：
									</td>
									<td>
										 <input type="file" name="upload" id="a" class="input-text lh25"/>
									</td>
									</tr>
									
									<tr>
									<td>
									<input style="display:none"type="text" name="tzhi.date" value="" id="datea" />
									</td>
									</tr>
									<tr> 
								  
										<td style="width:30px;">
											<input type="submit" class="btn btn82 btn_search" method="upload" onClick="datesub(this.form)"
												 value="马上发布" />
										</td>
									</tr>
								</table>
							</form>
							<script type="text/javascript"> 
      $("#usual1 ul").idTabs(); 
    </script>
    
    <script type="text/javascript">
	$('.tablelist tbody tr:odd').addClass('odd');
	</script>
						</div>
					</div>
				</div>
			</div>
		</div>
	</body>
</html>
