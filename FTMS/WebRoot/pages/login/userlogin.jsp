<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
  String path = request.getContextPath();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Frameset//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-frameset.dtd">
<html xmlns="http://www.w3.org/1999/xhtml"></html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html;charset=utf-8"></meta>
	<title>职业农民技术职称管理系统</title>
	<link rel="stylesheet" href="<%=path%>/css/style.css"></link>
	<link rel="stylesheet" type="text/css" href="<%=path%>/css/easyui.css">
	<script type="text/javascript" src="<%=path%>/libs/js/jquery.js"></script>
	<script type="text/javascript" src="<%=path%>/libs/js/login.js"></script>
	<script type="text/javascript" src="<%=path%>/js/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="md5.js"></script>
	<!--  <script type="text/javascript" src="<%=path%>/libs/js/method/center-plugin.js"></script>
		<meta name="viewport" content="width=device-width, initial-scale=1" />
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<meta name="keywords" content="Lambent Login Form Responsive, Login Form Web Template, Flat Pricing Tables, Flat Drop-Downs, Sign-Up Web Templates, Flat Web Templates, Login Sign-up Responsive Web Template, Smartphone Compatible Web Template, Free Web Designs for Nokia, Samsung, LG, Sony Ericsson, Motorola Web Design" />
		<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
		 -->
	<style>
		#code{
		font-family:Arial;
		font-style:italic;
		font-weight:bold;
		border:0;
		letter-spacing:10px;
		color:blue;
       }
      
	</style>
</head>
<body>
	<h1>杨凌农科培训综合信息服务平台</h1>
	<div style="float:right;margin-right:300px;margin-top:50px;">
	<a href="<%=path%>/pages/login/adminlogin.jsp" style="padding:5px 0px;width:10px;font-size:16px;color:white;">管理员登陆</a>
	</div>
	<div class="main-agileinfo">
		<div style="font-size:16px;color:white;margin-bottom:22px;">用户登录</div>
		<%-- <a href="<%=path%>/pages/Register.jsp" style="padding:5px 0px;width:10px;font-size:16px;">农民注册</a>
		<a href="<%=path%>/pages/YuanQiRegister.jsp" style="padding:5px 0px;width:10px;font-size:16px;">园企注册</a>
		<a href="javascript:void(0);" style="padding:5px 0px;width:10px;font-size:16px;" onclick="reset()">重置密码</a> --%>
		
		<!-- <form id="loginForm"  method="post"> -->
			<input type="text" name="name"  placeholder="用户名" required="" id="username"></input>
			<input type="password"  class="password" placeholder="密码" required="" id="password"></input>
			<div>
			<input type = "text"  style="width:230px;height:16px;" value="" placeholder="验证码"  id = "input"></input>
			<input type = "button" style="width:100px;height:46px;" id="code" onclick="createCode()"/>
			</div>
			<!-- <div class="clear"> -->
			<div>
			<a href="<%=path%>/pages/Register.jsp" style="padding:5px 0px;font-size:16px;margin-right:50px;color:black;">农民注册</a> 
			<!-- <a href="javascript:void(0);" style="padding:5px 0px;font-size:16px;margin-right:60px;color:white;" onclick="reset();">重置密码</a> -->
			<%--<a href="<%=path%>/pages/YuanQiRegister.jsp" style="padding:5px 0px;font-size:16px;margin-right:50px;color:black;">园企注册</a> --%>
			<%-- <a href="javascript:void(0);" style="padding:5px 0px;font-size:16px;margin-right:60px;color:black;" onclick="reset()">重置密码</a> --%>
			<%-- <a href="<%=path%>/pages/Register.jsp" style="padding:5px 0px;font-size:16px;margin-right:50px;color:white;">农民注册</a> --%>
			</div>
			<input type="submit" style="background:#e3e5e6;" value="登录"  onclick="validate()"></input>
		<!-- </form> -->
		<div class="login_info" style="display:none;color:black;"></div>
	 </div>
	<div class="footer-w3l" style="overflow:hidden;">
		<p class="agile"> &copy; Copyright ◎ 2016 杨凌农科培训综合信息服务平台All Rights Reserved</p>
		<p>联系电话：029-87036420    87036412  邮政编码：712100  联系地址：杨凌示范区新桥北路政务大厦</p>
	</div>

<script>
window.onload = function (){
        createCode();

    }


	$(function(){
		//居中
		/*  $('.login_main').center(); */
		 document.getElementById("username").focus();
		 $("#username").keydown(function(event){
		 	if(event.keyCode==13){
				login();
				return false;
			}
		 })
		 $("#password").keydown(function(event){
		 	if(event.keyCode==13){
				login();
				return false;
			}
		 })

	})

	//登录
	function login() {
		var errorMsg = "";
		var loginName = document.getElementById("username");
		var password = document.getElementById("password");
		if(!loginName.value){
			errorMsg += "&nbsp;&nbsp;用户名不能为空!";
			createCode();
		}
		if(!password.value){
			errorMsg += "&nbsp;&nbsp;密码不能为空!";
			createCode();
		}

		if(errorMsg != ""){
			$(".login_info").html(errorMsg);
			$(".login_info").show();
		}
		else{
			$(".login_info").show();
			$(".login_info").html("&nbsp;&nbsp;正在登录中...");
			//MD5对密码加密
			var password_md5;
			password_md5=hex_md5(hex_md5(loginName.value)+hex_md5(password.value));
			//登录处理
				  $.ajax({
				  type:'post',
				  url:"<%=path%>/pages/loginUser.action",
				  data:{"username":loginName.value,"password":password_md5},
				  cache:false,
				  dataType:"json",
				  async:false,
				  success:function(result){
					  if(result == null){
						  $(".login_info").html("&nbsp;&nbsp;登陆失败！");
						  createCode();
						  return false;
					  }
					  if(result=="ok"||result == 0){
					  	  $(".login_info").html("&nbsp;&nbsp;登录成功，正在转到主页...");
						  window.location.href = '<%=path%>/pages/userlogin.action?username='
							+ loginName.value + '&password='
							+ password_md5;
					  }
					  else{
					  	 $(".login_info").html("&nbsp;&nbsp;登陆失败！账号密码错误");
					  	 createCode();
					  }

				  },
				  error:function(result) {
				  	alert("请求失败");

				  }
				  });
		}
	}
	/***
	 * annotated by xiuhao.yan on 06/06/2018
	 */
	/*
	function reset(){
	var errorMsg = "";
		var loginName = document.getElementById("username");
		if(!loginName.value){
		errorMsg += "&nbsp;&nbsp;用户名不能为空!";
		}else if(loginName.value){

			$.messager.confirm('重置密码', '确定要重置你的密码么?', function(r) {

					if (r) {
						$.ajax({
								type : 'POST',
								url : '<%=path%>/pages/passwordReset.action',
								async : false,
								data : {
									"username": loginName.value
								},
								dataType : 'json',
							});
						$.messager.show({
							title : '提示',
							msg : loginName.value+'重置密码成功!',
							timeout : 3000,
							showType : 'show',
						});
					}
				});
		}

	}
		$.extend($.messager.defaults,{
	ok:"确定",
	cancel:"取消"
});
*/

//生成验证码的JS
var code ;

function createCode(){
	 code = "";
	 var codeLength = 4;//验证码的长度
	 var checkCode = document.getElementById("code");
	 var random = new Array(0,1,2,3,4,5,6,7,8,9,'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R',
	 'S','T','U','V','W','X','Y','Z');
	 for(var i = 0; i < codeLength; i++) {
		var index = Math.floor(Math.random()*36);//取得随机数的索引（0-35）
		code += random[index];//根据索引取得随机数加到code上
	}
	checkCode.value = code;//把code值赋给验证码
}

//校验验证码
function validate(){
	var inputCode = document.getElementById("input").value.toUpperCase(); //取得输入的验证码并转化为大写
	if(inputCode.length <= 0) {
		alert("请输入验证码");
	}
	else if(inputCode != code ) {
		createCode();//刷新验证码
		alert("验证码输入有误");

		document.getElementById("input").value = "";//清空文本框
	}
	else {
        login();
	}
}

	/* scx*/
</script>
<!-- scx -->
</body>
</html>