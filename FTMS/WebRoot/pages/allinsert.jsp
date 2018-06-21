<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>pages/">

<title>My JSP 'allinsert.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

<link rel="stylesheet" type="text/css" href="../css/easyui.css">
<link rel="stylesheet" type="text/css" href="../css/color.css">
<link rel="stylesheet" type="text/css" href="../css/demo.css">
<link rel="stylesheet" type="text/css" href="../css/icon.css">
<script type="text/javascript" src="../js/jquery.min.js"></script>
<script type="text/javascript" src="../js/jquery.easyui.min.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
$.extend($.fn.datebox.defaults, {
		currentText : "今天",
		closeText : "关闭",
	});
	$.extend($.fn.calendar.defaults, {
		weeks : [ "日", "一", "二", "三", "四", "五", "六"],
		months : [ "一月", "二月", "三月", "四月", "五月", "六月", "七月", "八月", "九月", "十月",
				"十一月", "十二月" ]
	});
		$.post("re_prof1.action", {}, function(data) {
			$('#prof1').combobox({
				data : data
			});
		});
		$.post("registerprovince.action", {
			username : $('#username').text()
		}, function(data) {
			$('#province').combobox({
				data : data
			});
		});
		$('#prof1').combobox({
			onChange : function(newValue, oldValue) {
				var str = newValue;
				$.post("re_prof2.action", {
					prof1id : str
				}, function(data) {
					$('#prof2').combobox({
						data : data
					});
				});
			}
		})
		$('#province').combobox({
			onChange : function(newValue, oldValue) {
				var str = newValue;
				$.post("registercity.action", {
					provinceid : str
				}, function(data) {
					$('#city').combobox({
						data : data
					});
				});
			}
		});
		$('#city').combobox({
			onChange : function(newValue, oldValue) {
				var str = newValue;
				$.post("registercounty.action", {
					cityid : str
				}, function(data) {
					$('#county').combobox({
						data : data
					});
				});
			}
		});
		$('#county').combobox({
			onChange : function(newValue, oldValue) {
				var str = newValue;
				$.post("registertown.action", {
					countyid : str
				}, function(data) {
					$('#town').combobox({
						data : data
					});
				});
			}

		});

	});

	function uploadUser() {
		var username = $('#username').textbox('getValue');
		var password = $('#password').textbox('getValue');
		var name = $('#name').textbox('getValue');
		var birthday = $('#birthday').datebox('getValue');
		var phone = $('#phone').textbox('getValue');
		var gender = $('#gender').combobox('getValue');
		var education = $('#education').combobox('getValue');
		var provinceid = $('#province').combobox('getValue');
		var cityid = $('#city').combobox('getValue');
		var countyid = $('#county').combobox('getValue');
		var townid = $('#town').combobox('getValue');
		var profid = $('#prof2').combobox('getValue');
		var addr = $('#address').textbox('getValue');
		if (username.length < 1 || password.length < 1 || name.length < 1
				|| birthday.length < 1 || phone.length < 1 || gender.length < 1
				|| education.length < 1 || provinceid.length < 1
				|| cityid.length < 1 || countyid.length < 1|| townid.length < 1|| profid.length < 1|| addr.length < 1) {
			$.messager.alert('提示', '请填写完整！');
		} else {
					$.post("allinsert_user.action", {
						username : $('#username').textbox('getValue'),
						password : $('#password').textbox('getValue'),
						name : $('#name').textbox('getValue'),
						birthday : $('#birthday').datebox('getValue'),
						phone : $('#phone').textbox('getValue'),
						gender : $('#gender').combobox('getValue'),
						education : $('#education').combobox('getValue'),
						provinceid : $('#province').combobox('getValue'),
						cityid : $('#city').combobox('getValue'),
						countyid : $('#county').combobox('getValue'),
						townid : $('#town').combobox('getValue'),
						profid : $('#prof2').combobox('getValue'),
					}, function() {
						$.post("allinsert_addr.action", {
							username : $('#username').textbox('getValue'),
							addr : $('#address').textbox('getValue')
						}, function() {
							$.messager.show({
								title : '提示',
								msg : '信息保存成功！',
								timeout : 3000,
								showType : 'show',
							});
						})
					})
		}

	}
	function uploadUser_exam() {
		var username_ks = $('#username_ks').textbox('getValue');
		var level = $('#level').textbox('getValue');
		var month = $('#month').textbox('getValue');
		var address_sh = $('#address_sh').textbox('getValue');
		var shenhe =  $('#shenhe').textbox('getValue');
		if (username_ks.length < 1 || level.length < 1 || month.length < 1
				|| address_sh.length < 1 || shenhe.length < 1 ) {
			$.messager.alert('提示', '请填写完整！');
		} else {
			$.post("allinsert_userexist.action", {
				username : $('#username_ks').textbox('getValue')
			}, function(data) {
				if (data == "error") {
					$.post("allinsert_exam.action", {
						username_ks : $('#username_ks').textbox('getValue'),
						level : $('#level').textbox('getValue'),
						month : $('#month').textbox('getValue'),
						address_sh : $('#address_sh').textbox('getValue'),
						shenhe : $('#shenhe').textbox('getValue'),
					}, function() {
						$.messager.show({
							title : '提示',
							msg : '信息保存成功！',
							timeout : 3000,
							showType : 'show',
						});
					})
				} else {
					$.messager.alert('提示', '该账号不存在！');
				}
			})
		}

	}
	function uploadUser_jg() {
		var username_jg = $('#username_jg').textbox('getValue');
		var achievement_jg = $('#achievement_jg').textbox('getValue');
		var total = $('#total').textbox('getValue');
		var canjia = $('#canjia').textbox('getValue');
		var approval = $('#approval').textbox('getValue');
		var opposition =$('#opposition').textbox('getValue');
		var checktime = $('#checktime').datebox('getValue');
		var level_jg = $('#level_jg').combobox('getValue');
		var number = $('#number').textbox('getValue');
		var fazhengtime = $('#fazhengtime').datebox('getValue');
		var writescore = $('#writescore').textbox('getValue');
		var interviewscore = $('#interviewscore').textbox('getValue');
		var totalscore = $('#totalscore').textbox('getValue');
		if (username_jg.length < 1 || achievement_jg.length < 1 || total.length < 1
				|| canjia.length < 1 || approval.length < 1 || opposition.length < 1
				|| checktime.length < 1 || level_jg.length < 1 || number.length < 1
				|| fazhengtime.length < 1 || writescore.length < 1|| interviewscore.length < 1|| totalscore.length < 1) {
			$.messager.alert('提示', '请填写完整！');
		} else {
			$.post("allinsert_userexist.action", {
				username : $('#username_jg').textbox('getValue')
			}, function(data) {
				if (data == "error") {
					$.post("allinsert_result.action", {
						username_jg : $('#username_jg').textbox('getValue'),
						achievement_jg : $('#achievement_jg').textbox(
								'getValue'),
						total : $('#total').numberbox('getValue'),
						canjia : $('#canjia').numberbox('getValue'),
						approval : $('#approval').numberbox('getValue'),
						opposition : $('#opposition').numberbox('getValue'),
						checktime : $('#checktime').datebox('getValue'),
						level_jg : $('#level_jg').combobox('getValue'),
						number : $('#number').textbox('getValue'),
						fazhengtime : $('#fazhengtime').datebox('getValue'),
						writescore : $('#writescore').numberbox('getValue'),
						interviewscore : $('#interviewscore').numberbox(
								'getValue'),
						totalscore : $('#totalscore').numberbox('getValue'),
					}, function() {
						$.messager.show({
							title : '提示',
							msg : '信息保存成功！',
							timeout : 3000,
							showType : 'show',
						});
					})
				} else {
					$.messager.alert('提示', '该账号不存在！');
				}
			})
		}

	}
	function uploadUser_certificate() {
		var username_zs = $('#username_zs').textbox('getValue');
		var time_zs = $('#time_zs').textbox('getValue');
		var major = $('#major').textbox('getValue');
		var certificatename = $('#certificatename').textbox('getValue');
		if (username_zs.length < 1 || time_zs.length < 1 || major.length < 1
				|| certificatename.length < 1 ) {
			$.messager.alert('提示', '请填写完整！');
		} else {
			$.post("allinsert_userexist.action", {
				username : $('#username_zs').textbox('getValue')
			}, function(data) {
				if (data == "error") {
					$.post("uploadUser_cer.action", {
						username_zs : $('#username_zs').textbox('getValue'),
						time_zs : $('#time_zs').textbox('getValue'),
						major : $('#major').textbox('getValue'),
						certificatename : $('#certificatename').textbox(
								'getValue'),
					}, function() {
						$.messager.show({
							title : '提示',
							msg : '信息保存成功！',
							timeout : 3000,
							showType : 'show',
						});
					})
				} else {
					$.messager.alert('提示', '该账号不存在！');
				}
			})
		}

	}
	function uploadUser_ach() {
		var username_yj = $('#username_yj').textbox('getValue');
		var start = $('#start').textbox('getValue');
		var end = $('#end').textbox('getValue');
		var completion = $('#completion').textbox('getValue');
		var winess = $('#winess').textbox('getValue');
		if (username_yj.length < 1 || start.length < 1 || end.length < 1
				|| completion.length < 1|| winess.length < 1 ) {
			$.messager.alert('提示', '请填写完整！');
		} else {
			$.post("allinsert_userexist.action", {
				username : $('#username_yj').textbox('getValue')
			}, function(data) {
				if (data == "error") {
					$.post("allinsert_ach.action", {
						username_yj : $('#username_yj').textbox('getValue'),
						start : $('#start').textbox('getValue'),
						end : $('#end').textbox('getValue'),
						completion : $('#completion').textbox('getValue'),
						winess : $('#winess').textbox('getValue'),
					}, function() {
						$.messager.show({
							title : '提示',
							msg : '信息保存成功！',
							timeout : 3000,
							showType : 'show',
						});
					})
				} else {
					$.messager.alert('提示', '该账号不存在！');
				}
			})
		}

	}
	function uploadUser_shenyan() {
		var username_sy = $('#username_sy').textbox('getValue');
		var year_sy = $('#year_sy').numberbox('getValue');
		var level_sy = $('#level_sy').combobox('getValue');
		var status_sy = $('#status_sy').combobox('getValue');
		if (username_sy.length < 1 || year_sy.length < 1 || level_sy.length < 1
				|| status_sy.length < 1) {
			$.messager.alert('提示', '请填写完整！');
		} else {
			$.post("allinsert_userexist.action", {
				username : $('#username_sy').textbox('getValue')
			}, function(data) {
				if (data == "error") {
					$.post("allinsert_sy.action", {
						username_sy : $('#username_sy').textbox('getValue'),
						year_sy : $('#year_sy').numberbox('getValue'),
						level_sy : $('#level_sy').combobox('getValue'),
						status_sy : $('#status_sy').combobox('getValue'),
					}, function() {
						$.messager.show({
							title : '提示',
							msg : '信息保存成功！',
							timeout : 3000,
							showType : 'show',
						});
					})
				} else {
					$.messager.alert('提示', '该账号不存在！');
				}
			})
		}

	}
</script>
</head>

<body>
	<div class="easyui-accordion" style="width:100%;height:auto;"
		data-options="border:true,multiple:true">
		<div title="用户信息" data-options="iconCls:'icon-ok'"
			style="overflow:auto;padding:10px;">
			<table>
				<tr>
					<td width="5%"><div>身份证号:</div></td>
					<td width="30%"><input id="username" class="easyui-textbox"
						style="width:60%;height:32px"></td>
					<td width="5%"><div>姓名:</div></td>
					<td width="30%"><input id="name" class="easyui-textbox"
						style="width:60%;height:32px"></td>
					<td width="5%"><div>密码:</div></td>
					<td width="25%"><input id="password" class="easyui-textbox"
						style="width:60%;height:32px"></td>
				</tr>
				<tr>
					<td><div>年龄:</div></td>
					<td><input id="birthday" class="easyui-datebox"
						editable="false" required style="width:60%"></td>
					<td><div>性别:</div></td>
					<td><select id="gender" class="easyui-combobox"
						panelHeight="auto" editable="false" name="state"
						style="width:60%;">
							<option value="男">男</option>
							<option value="女">女</option>
					</select></td>
					<td><div>省:</div></td>
					<td><select id="province" class="easyui-combobox"
						panelHeight="auto" editable="false" name="state"
						style="width:60%;">
					</select></td>
				</tr>
				<tr>
					<td><div>市:</div></td>
					<td><select id="city" class="easyui-combobox"
						panelHeight="auto" editable="false" name="state"
						style="width:60%;">
					</select></td>
					<td><div>县:</div></td>
					<td><select id="county" class="easyui-combobox"
						panelHeight="auto" editable="false" name="state"
						style="width:60%;">
					</select></td>
					<td><div>乡:</div></td>
					<td><select id="town" class="easyui-combobox"
						panelHeight="auto" editable="false" name="state"
						style="width:60%;">
					</select></td>
				</tr>
				<tr>
					<td><div>地址:</div></td>
					<td><input id="address" class="easyui-textbox"
						style="width:60%;height:32px"></td>
					<td><div>学历:</div></td>
					<td><select id="education" class="easyui-combobox"
						editable="false" panelHeight="auto" name="state"
						style="width:60%;">
							<option value="小学">小学</option>
							<option value="初中">初中</option>
							<option value="高中">高中</option>
							<option value="中专">中专</option>
							<option value="大专">大专</option>
							<option value="本科">本科</option>
							<option value="研究生">研究生</option>
							<option value="其他">其他</option>
					</select></td>
					<td><div>电话:</div></td>
					<td><input id="phone" class="easyui-textbox"
						style="width:60%;height:32px"></td>
				</tr>
				<tr>
					<td><div>专业1:</div></td>
					<td><select id="prof1" class="easyui-combobox"
						editable="false" name="state" panelHeight="auto" style="width:60%;">
					</select></td>
					<td><div>专业2:</div></td>
					<td><select id="prof2" class="easyui-combobox"
						editable="false" name="state" panelHeight="auto" style="width:60%;">
					</select></td>
					<td></td>
					<td><a href="javascript:void(0)" class="easyui-linkbutton"
						iconCls="icon-ok" style="width:60%;height:30px;"
						onclick="uploadUser()"><span style="font-size:16px">保存</span></a></td>
				</tr>
			</table>
		</div>
		<div title="考试信息" data-options="iconCls:'icon-ok'"
			style="overflow:auto;padding:10px;">
			<table>
            	<tr>
                	<td width="5%"><div>身份证号:</div></td>
                    <td width="30%"><input  id="username_ks" class="easyui-textbox" style="width:60%;height:32px"></td>
                	<td width="5%"><div>报考级别:</div></td>
                    <td width="30%"><select class="easyui-combobox" id="level" name="exam.level"
										style="width:60%;height:30px;" editable="false"
										panelHeight="auto">
											<option value="农技员" selected>农技员</option>
											<option value="农技师">农技师</option>
											<option value="高级农技师">高级农技师</option>
									</select></td>
                    <td width="5%"><div>月份:</div></td>
                    <td width="25%"><select class="easyui-combobox" id="month" name="exam.time"
										style="width:60%;height:30px;" editable="false" 
										panelHeight="auto">
											<option value="1" selected>1月</option>
											<option value="2">2月</option>
											<option value="3">3月</option>
											<option value="4">4月</option>
											<option value="5">5月</option>
											<option value="6">6月</option>
											<option value="7">7月</option>
											<option value="8">8月</option>
											<option value="9">9月</option>
											<option value="10">10月</option>
											<option value="11">11月</option>
											<option value="12">12月</option>
									</select></td>
                </tr>
                <tr>
                	<td><div>考试地址:</div></td>
                    <td><select class="easyui-combobox" id="address_sh" name="exam.address"
										style="width:60%;height:30px;" panelHeight="auto" editable="false"
										panelHeight="auto">
											<option value="杨凌" selected>杨凌</option>
											<option value="本地">本地</option>
											<option value="其他">其他</option>
									</select></td>
                	<td><div>审核:</div></td>
                    <td><select id="shenhe" class="easyui-combobox" panelHeight="auto" editable="false" name="state" style="width:60%;">
								<option value="否">否</option>
								<option value="是">是</option>
						</select></td>
                    
                    <td></td>
                     <td><a href="javascript:void(0)" class="easyui-linkbutton"
							iconCls="icon-ok" style="width:60%;height:30px;"
							onclick="uploadUser_exam()"><span style="font-size:16px">保存</span></a></td>
                </tr>
            </table>
		</div>
		<div title="结果" data-options="iconCls:'icon-help'"
			style="padding:10px;">
			<table>
				<tr>
					<td width="5%"><div>身份证号:</div></td>
					<td width="30%"><input id="username_jg" class="easyui-textbox"
						style="width:60%;height:32px"></td>
					<td width="5%"><div>业绩:</div></td>
					<td width="30%"><input id="achievement_jg"
						class="easyui-textbox" data-options="multiline:true"
						style="width:60%;height:100px"></td>
					<td width="5%"><div>总人数:</div></td>
					<td width="25%"><input id="total" class="easyui-numberbox"
						style="width:60%;height:32px"></td>
				</tr>
				<tr>
					<td><div>参加人数:</div></td>
					<td><input id="canjia" class="easyui-numberbox"
						style="width:60%;height:32px"></td>
					<td><div>赞成票:</div></td>
					<td><input id="approval" class="easyui-numberbox"
						style="width:60%;height:32px"></td>
					<td><div>反对票:</div></td>
					<td><input id="opposition" class="easyui-numberbox"
						style="width:60%;height:32px"></td>
				</tr>
				<tr>
					<td><div>投票时间:</div></td>
					<td><input id="checktime" class="easyui-datebox"
						editable="false" required style="width:60%"></td>
					<td><div>等级:</div></td>
					<td><select id="level_jg" class="easyui-combobox"
						panelHeight="auto" editable="false" name="state"
						style="width:60%;">
							<option value="农技员">农技员</option>
							<option value="农技师">农技师</option>
							<option value="高级农技师">高级农技师</option>
					</select></td>
					<td><div>证书编号:</div></td>
					<td><input id="number" class="easyui-textbox"
						style="width:60%;height:32px"></td>
				</tr>
				<tr>
					<td><div>发证时间:</div></td>
					<td><input id="fazhengtime" class="easyui-datebox"
						editable="false" required style="width:60%"></td>
					<td><div>笔试成绩:</div></td>
					<td><input id="writescore" class="easyui-numberbox"
						style="width:60%;height:32px"></td>
					<td><div>面试成绩:</div></td>
					<td><input id="interviewscore" class="easyui-numberbox"
						style="width:60%;height:32px"></td>
				</tr>
				<tr>
					<td><div>总成绩:</div></td>
					<td><input id="totalscore" class="easyui-numberbox"
						style="width:60%;height:32px"></td>
					<td></td>
					<td></td>
					<td></td>
					<td><a href="javascript:void(0)" class="easyui-linkbutton"
						iconCls="icon-ok" style="width:60%;height:30px;"
						onclick="uploadUser_jg()"><span style="font-size:16px">保存</span></a></td>
				</tr>
			</table>

		</div>
		<div title="证书" data-options="iconCls:'icon-help'"
			style="padding:10px;">
			<table>
				<tr>
					<td width="5%"><div>身份证号:</div></td>
					<td width="30%"><input id="username_zs" class="easyui-textbox"
						style="width:60%;height:32px"></td>
					<td width="5%"><div>获得时间:</div></td>
					<td width="30%"><input id="time_zs" class="easyui-textbox"
						style="width:60%;height:32px"></td>
					<td width="5%"><div>类型:</div></td>
					<td width="25%"><input id="major" class="easyui-textbox"
						style="width:60%;height:32px"></td>
				</tr>
				<tr>
					<td><div>证书名称:</div></td>
					<td><input id="certificatename" class="easyui-textbox"
						style="width:60%;height:32px"></td>
					<td></td>
					<td></td>
					<td></td>
					<td><a href="javascript:void(0)" class="easyui-linkbutton"
						iconCls="icon-ok" style="width:60%;height:30px;"
						onclick="uploadUser_certificate()"><span
							style="font-size:16px">保存</span></a></td>
				</tr>
			</table>
		</div>
		<div title="业绩" data-options="iconCls:'icon-help'"
			style="padding:10px;">
			<table>
				<tr>
					<td width="5%"><div>身份证号:</div></td>
					<td width="30%"><input id="username_yj" class="easyui-textbox"
						style="width:60%;height:32px"></td>
					<td width="5%"><div>开始时间:</div></td>
					<td width="30%"><input id="start" class="easyui-textbox"
						style="width:60%;height:32px"></td>
					<td width="5%"><div>结束时间:</div></td>
					<td width="25%"><input id="end" class="easyui-textbox"
						style="width:60%;height:32px"></td>
				</tr>
				<tr>
					<td><div>主要内容:</div></td>
					<td><input id="completion" class="easyui-textbox"
						data-options="multiline:true" style="width:60%;height:100px"></td>
					<td><div>见证人:</div></td>
					<td><input id="winess" class="easyui-textbox"
						style="width:60%;height:32px"></td>
					<td></td>
					<td><a href="javascript:void(0)" class="easyui-linkbutton"
						iconCls="icon-ok" style="width:60%;height:30px;"
						onclick="uploadUser_ach()"><span style="font-size:16px">保存</span></a></td>
				</tr>
			</table>
		</div>
		<div title="审验" data-options="iconCls:'icon-help'"
			style="padding:10px;">
			<table>
				<tr>
					<td width="5%"><div>身份证号:</div></td>
					<td width="30%"><input id="username_sy" class="easyui-textbox"
						style="width:60%;height:32px"></td>
					<td width="5%"><div>时间（年）:</div></td>
					<td width="30%"><input id="year_sy" class="easyui-numberbox"
						style="width:60%;height:32px"></td>
					<td width="5%"><div>等级:</div></td>
					<td width="25%"><select id="level_sy" class="easyui-combobox"
						panelHeight="auto" editable="false" name="state"
						style="width:60%;">
							<option value="农技员">农技员</option>
							<option value="农技师">农技师</option>
							<option value="高级农技师">高级农技师</option>
					</select></td>
				</tr>
				<tr>
					<td><div>审验状态:</div></td>
					<td><select id="status_sy" class="easyui-combobox"
						editable="false" panelHeight="auto" name="state"
						style="width:60%;">
							<option value="否">否</option>
							<option value="是">是</option>
					</select></td>
					<td></td>
					<td></td>
					<td></td>
					<td><a href="javascript:void(0)" class="easyui-linkbutton"
						iconCls="icon-ok" style="width:60%;height:30px;"
						onclick="uploadUser_shenyan()"><span style="font-size:16px">保存</span></a></td>
				</tr>
			</table>
		</div>
	</div>
</body>
</html>
