<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>pages/">
    
    <title>My JSP 'login.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript" src="../js/jquery.min.js"></script>
	<script type="text/javascript" src="../js/jquery.easyui.min.js"></script>

	<link rel="stylesheet" type="text/css" href="../css/color.css">
	<link rel="stylesheet" type="text/css" href="../css/demo.css">
	<link rel="stylesheet" type="text/css" href="../css/easyui.css">
	<link rel="stylesheet" type="text/css" href="../css/icon.css">
	
<script type="text/javascript">
	function userlogin() {
		if ($('#username').textbox('getValue').length<1
				|| $('#userpassword').textbox('getValue').length<1) {
			$('#userinfo').text("账号或密码不能为空！");
		} else {
			$.post("loginUser", {
				username : $('#username').textbox('getValue'),
				password : $('#userpassword').textbox('getValue')
			}, function(data) {
				if (data == "ok") {
					window.location.href = 'userlogin?username='
							+ $('#username').textbox('getValue') + '&password='
							+ $('#userpassword').textbox('getValue');
				} else if (data == "empty") {
					$('#userinfo').text("账号或密码不能为空！");
				} else {
					$('#userinfo').text("账号或密码不正确！");
				}
			})
		}
	}
	function adminlogin() {
		if ($('#adminname').textbox('getValue').length<1
				|| $('#adminpassword').textbox('getValue').length<1) {
			$('#admininfo').text("账号或密码不能为空！");
		} else {
			$.post("loginAdmin", {
				adminname : $('#adminname').textbox('getValue'),
				password : $('#adminpassword').textbox('getValue')
			}, function(data) {
				if (data == "ok") {
					window.location.href = 'adminlogin?adminname='
							+ $('#adminname').textbox('getValue') + '&password='
							+ $('#adminpassword').textbox('getValue');
				} else if (data == "empty") {
					$('#admininfo').text("账号或密码不能为空！");
				} else {
					$('#admininfo').text("账号或密码不正确！");
				}
			})
		}
	}
</script>	
  </head>
  
  <body>
    <div class="easyui-panel" title="普通用户" style="width:400px;padding:30px 70px 20px 70px">
        <div style="margin-bottom:10px">
            <input id="username" class="easyui-textbox" style="width:100%;height:40px;padding:12px" data-options="prompt:'账号',iconCls:'icon-man',iconWidth:38">
        </div>
        <div style="margin-bottom:20px">
            <input id="userpassword" class="easyui-textbox" type="password" style="width:100%;height:40px;padding:12px" data-options="prompt:'密码',iconCls:'icon-lock',iconWidth:38">
        </div>
        <div style="margin-bottom:20px">
            <input type="checkbox" checked="checked">
            <span>记住我</span><font style="color:#F00">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span id="userinfo"></span></font>
        </div>
        <div>
            <a href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'icon-ok'" style="padding:5px 0px;width:100%;" onclick="userlogin()">
                <span style="font-size:14px;">登陆</span>
            </a>
        </div>
        <a class="easyui-linkbutton" href="Register.jsp" style="padding:5px 0px;width:100%;">注册</a>
    </div>
    <div class="easyui-panel" title="管理员" style="width:400px;padding:30px 70px 20px 70px">
        <div style="margin-bottom:10px">
            <input id="adminname" class="easyui-textbox" style="width:100%;height:40px;padding:12px" data-options="prompt:'账号',iconCls:'icon-man',iconWidth:38">
        </div>
        <div style="margin-bottom:20px">
            <input id="adminpassword" class="easyui-textbox" type="password" style="width:100%;height:40px;padding:12px" data-options="prompt:'密码',iconCls:'icon-lock',iconWidth:38">
        </div>
        <div style="margin-bottom:20px">
            <input type="checkbox" checked="checked">
            <span>记住我</span><font style="color:#F00">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span id="admininfo"></span></font>
        </div>
        <div>
            <a href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'icon-ok'" style="padding:5px 0px;width:100%;" onclick="adminlogin()">
                <span style="font-size:14px;">登陆</span>
            </a>
        </div>
    </div>
  </body>
</html>
