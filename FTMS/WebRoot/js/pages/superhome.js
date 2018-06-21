function ksps() {
	$('#show').attr("src", "ksps.jsp");
}
function rysy() {
	$('#show').attr("src", "rysy.jsp");
}
function stgy() {
	$('#show').attr("src", "stgy.jsp");
}
function qgsj() {
	$('#show').attr("src", "qgsj.action");
}
function kssh() {
	$('#show').attr("src", "kssh.action");
}
function face() {
	$('#show').attr("src", "adminface.action");
}
function gscx() {
	$('#show').attr("src", "sfsj.jsp");
}
function sxcx() {
	$('#show').attr("src", "cssj.jsp");
}
function ylcx() {
	$('#show').attr("src", "xjsj.jsp");
}
function shengfen(province) {
	$('#show').attr("src", "sfsj.action?province=" + province);
}
function stgy() {
	$('#show').attr("src", "onlinetest/tiku.action");
}
function userManagement() {
	$('#show').attr("src", "userManagement.jsp");
}
function adminManagement() {
	$('#show').attr("src", "adminManagement.jsp");
}
function xgmm() {
	var name = $('#name').text();
	$('#show').attr("src", "resetpassword.action?adminname=&supername=" + name);
}