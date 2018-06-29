package com.ftms.action;

import net.sf.json.JSONArray;

import com.ftms.service.AdminService;
import com.ftms.service.SuperadminService;
import com.opensymphony.xwork2.ActionSupport;

public class SuperadminAction extends ActionSupport {
private SuperadminService superadminService;
private AdminService adminService;
private String adminname;
private String adminpassword;
private int id;
private JSONArray adminJSON;
private String supername;
private String superpassword;

public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getSupername() {
	return supername;
}
public void setSupername(String supername) {
	this.supername = supername;
}
public String getSuperpassword() {
	return superpassword;
}
public void setSuperpassword(String superpassword) {
	this.superpassword = superpassword;
}
public JSONArray getAdminJSON() {
	return adminJSON;
}
public void setAdminJSON(JSONArray adminJSON) {
	this.adminJSON = adminJSON;
}
public SuperadminService getSuperadminService() {
	return superadminService;
}
public void setSuperadminService(SuperadminService superadminService) {
	this.superadminService = superadminService;
}
public AdminService getAdminService() {
	return adminService;
}
public void setAdminService(AdminService adminService) {
	this.adminService = adminService;
}
public String getAdminname() {
	return adminname;
}
public void setAdminname(String adminname) {
	this.adminname = adminname;
}
public String getAdminpassword() {
	return adminpassword;
}
public void setAdminpassword(String adminpassword) {
	this.adminpassword = adminpassword;
}
public String adminload(){
	adminJSON=JSONArray.fromObject(superadminService.findAll());
	return "adminload";
}
public String adminAdd(){
	superadminService.mergeAdmin(adminname,adminpassword);
	return "adminAdd";
}
public String adminDelete(){
	superadminService.deleteAdmin(id);
	return "adminDelete";
}
public String superReset(){
	superadminService.updateSuperadmin(supername, superpassword);
	return "superReset";
}
public String adminReset(){
	adminService.adminUpdate(adminname, adminpassword);
	return "adminReset";
}
public String resetpassword(){
	return "resetpassword";
}

}
