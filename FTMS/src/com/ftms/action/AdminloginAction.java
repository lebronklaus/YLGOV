package com.ftms.action;

import net.sf.json.JSONArray;

import com.ftms.service.AdminService;
import com.ftms.service.SuperadminService;
import com.opensymphony.xwork2.ActionSupport;

public class AdminloginAction extends ActionSupport {
	private AdminService adminService;
	private SuperadminService superadminService;
	private String adminname;
	private String password;
	private JSONArray adminJSON;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public JSONArray getAdminJSON() {
		return adminJSON;
	}

	public void setAdminJSON(JSONArray adminJSON) {
		this.adminJSON = adminJSON;
	}

	public String getAdminname() {
		return adminname;
	}

	public void setAdminname(String adminname) {
		this.adminname = adminname;
	}
	public String login(){
		if(adminname.isEmpty()||password.isEmpty())
			return "error";
		if(superadminService.superLogin(adminname, password))
			return "superlogin";
		if(adminService.adminLogin(adminname, password))
			return "adminlogin";
		return "error";
	}
	public String loginAdmin(){
		adminJSON=new JSONArray();
		System.out.println(password);
		if(adminname.isEmpty()||password.isEmpty())
			adminJSON.add("empty");
		else if(superadminService.superLogin(adminname, password))
			adminJSON.add("ok");
		else if(adminService.adminLogin(adminname, password))
			adminJSON.add("ok");
		else
			adminJSON.add("error");
		return "loginAdmin";
	}
	public String adminhome(){
		return "login";
	}
}
