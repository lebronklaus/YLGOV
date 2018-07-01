package com.ftms.action;

import net.sf.json.JSONArray;

import java.util.logging.Logger;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.ftms.service.AdminService;
import com.ftms.service.SuperadminService;
import com.opensymphony.xwork2.ActionSupport;

public class AdminloginAction extends ActionSupport {
	private AdminService adminService;
	private SuperadminService superadminService;
	private String adminname;
	private String password;
	
	private String adname;
	private String adpass;
	
	
	
	public String getAdname() {
		return adname;
	}

	public void setAdname(String adname) {
		this.adname = adname;
	}

	public String getAdpass() {
		return adpass;
	}

	public void setAdpass(String adpass) {
		this.adpass = adpass;
	}
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
		this.adname = adminname;
		this.adpass = password;
		if(adminname==null||password==null)
			return "error";

		if(superadminService.superLogin(adminname, password)){
			HttpSession session = ServletActionContext.getRequest().getSession();

			session.setAttribute("mark", -1);
			adminname=null;
			password=null;
			return "superlogin";
		}
			
		if(adminService.adminLogin(adminname, password)){
			HttpSession session = ServletActionContext.getRequest().getSession();

			session.setAttribute("mark", -1);
			adminname=null;
			password=null;
			return "adminlogin";
		}
			
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
