
<%@ page language="java" import="java.util.*,com.lee.mode.*"
	pageEncoding="utf-8"%>
<%@  taglib uri="/struts-tags" prefix="s"%>

<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">

		<title>删除页面</title>
		<link href="style/style.css" rel="stylesheet" type="text/css" />
		<script type="text/javascript" src="js/jquery.js"></script>

		<script type="text/javascript">
		function setDateTime(){
			var date=new Date();
			var day=date.getDay();
			var week;
			switch(day){
			case 0:week="星期日";break;
			case 1:week="星期一";break;
			case 2:week="星期二";break;
			case 3:week="星期三";break;
			case 4:week="星期四";break;
			case 5:week="星期五";break;
			case 6:week="星期六";break;
			}
			var today=date.getFullYear()+"年"+(date.getMonth()+1)+"月"+date.getDate()+"日  "+week+" "+date.getHours()+":"+date.getMinutes()+":"+date.getSeconds();
			document.getElementById("today").innerHTML=today;
		}
		
		window.setInterval("setDateTime()", 1000);
		

        function del(){
			if(confirm("确定要删除吗？"))
			{
			return true;
			}
			else
			{
			return false;
			}
            }
            
            
            function decide(se,sr)
            {
          //  alert(se);
//            var str= se;
            // document.write(se);
//            var sun=sr;
             if(se<=sr)
             {
            window.location.href= "Tnews1.action?PageNow="+se;
            }
            else
            {
            alert("已经到最后一页");}
            }
            
            
            $(function()
            {
            
            }
            )
            $(document).ready(function()
            {
            $(".click").click(function()
            {
            $(".top").fadeIn(200);
            }
            );
            
            $(".tiptop a").click(function()
            {
            $(".tip").fadeOut(200);
            });
            
            $(".sure").click(function()
            {
            $(".tip").fadeOut(100);
            });
            
            $(".cancel").click(function()
            {
            $(".tip").fadeOut(100);
            }
            );
            }
            );           
	</script>
	</head>

	<body>
		<%
			Tnews tnews = new Tnews();
		%>
		<div class="place">
			<span>位置：</span>
			<ul class="placeul">
				<li>
					<a href="#">首页</a>
				</li>
				<li>
					<a href="#">数据信息</a>
				</li>
				<li>
					<a href="#">基本内容</a>
				</li>
			</ul>
		</div>
		<div class="rightinfo">

			<div class="tools">
				<ul class="toolbar">
					<li class="click">
						<span><img src="images/bimages/t01.png"></img>
						</span>添加
					</li>
					<li class="click">
						<span><img src="images/bimages/t02.png"></img>
						</span>修改
					</li>
				</ul>

				<ul class="toolbar1">
					<li>
						<font id="today"></font>
					</li>
					<li class="click">
						<span><img src="images/bimages/t05.png">
						</span>设置
					</li>
					</ul>
			</div>

			<table class="tablelist">
				<thead>
					<tr>
						<th>
							<input name="input1" type="checkbox" value="" checked="checked" />
						</th>
						<th>
							公告标题
						</th>
						<th>
							操作
						</th>
					</tr>
				</thead>

				<tbody>
					<s:iterator id="strain" value="list">
						<tr>
							<td>
								<input name="" type="checkbox" value="" />
							</td>
							<td id="info">
								<s:property value="title" />
							</td>
							<td>
								<a href="Tnews2.action?id=<s:property value="#strain.id"/>"
									class="tablelink" onclick="return del()">刪除</a>
								<a href="<%=path %>/system/layout/addMoreNewss.action?id=<s:property value="#strain.id"/>" class="tablelink">查看</a>
							</td>
						</tr>
					</s:iterator>
				</tbody>
			</table>

			<div class="pagin">
				<div class="message">
					共
					<s:property value='pageCount' />
					条记录，当前显示第&nbsp;
					<i class="blue"><s:property  value="pageNow"/>&nbsp;</i>页
				</div>

				<ul class="paginList">
					<li class="paginItem">
						<a href="Tnews1.action?PageNow=1"><span class="pagepre">首页</span>
						</a>
					</li>
					<li class="paginItem">
						<a href="Tnews1.action?PageNow=<s:property value='pageNow-1'/>"><span
							class="pagepre">back</span>
						</a>
					</li>

					<li class="paginItem">
						<a href="javascript:;">1</a>
					</li>
					<li class="paginItem current">
						<a href="javascript:;">2</a>
					</li>
<!--                   下一页-->
					<li class="paginItem">
						<a  href="JavaScript:decide(<s:property value='pageNow+1'/>,<s:property value='pageCount'/>)" ><span
							class="pagepre">next</span>
						</a>
					</li>
					<li class="paginItem">
						<a href="Tnews1.action?PageNow=<s:property value='pageCount'/>"><span
							class="pagepre">末页</span>
						</a>
					</li>
				</ul>
			</div>
		</div>
		<script type="text/javascript">
	$('.tablelist tbody tr:odd').addClass('odd');
	</script>
	</body>
</html>