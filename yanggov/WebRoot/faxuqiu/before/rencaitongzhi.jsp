<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
	<base href="<%=basePath%>"/>
	<link rel="stylesheet" type="text/css" href="shizi/shizicss/reset.css" />
	<link rel="stylesheet" type="text/css" href="shizi/shizicss/style.css" />
	

	<script type="text/javascript" src="shizi/shizijs/jquery1.42.min.js"></script>
	<script type="text/javascript" src="shizi/shizijs/jquery.SuperSlide.2.1.1.source.js"></script>
	
	
	
<%-- 	<script type="text/javascript" src="js/jquery.js"></script>
 --%>    

    
  </head>
  <!-- by xiuhao.yan -->
  <body >
  <div class="xq_left_div2">
  <div class="xq_div_div1">
		<h1>人才需求</h1>
	</div>
  	<div class="xq_div1_div2" id="rencailist">
				<ul class="infoList">
					<s:iterator value="%{#application.rencailist}">
							<li style="overflow:hidden;" >
								<div class="img">
									<img src="images/dian.jpg" />
								</div>
								<div class="wen">
									<a target="_parent"
											href="showrencai.action?id=<s:property value='id'></s:property>"><s:property
												value="gangwei" ></s:property>---<s:property value="inputdate" ></s:property>
										</a>
								</div>
							</li>
					</s:iterator>
				</ul>
			</div>
  	
    </div>
    <script type="text/javascript">
		jQuery(".xq_left_div2").slide({mainCell:".xq_div1_div2 ul",autoPlay:true,effect:"topMarquee",vis:6,interTime:50});
	</script>
  </body>
</html>
