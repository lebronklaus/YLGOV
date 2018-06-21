function ksps() {
	$('#show').attr("src", "ksps.jsp");
}
function stgy() {
	$('#show').attr("src", "stgy.jsp");
}
function kssh() {
	$('#show').attr("src", "kssh.action");
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
	$('#show').attr("src", "resetpassword.action?supername=&adminname=" + name);
}