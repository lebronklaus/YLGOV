package com.ftms.action;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import net.sf.json.JSONArray;

import com.ftms.service.UserService;
import com.ftms.serviceImpl.YuanQiUserServiceImpl;
import com.opensymphony.xwork2.ActionSupport;

public class UserloginAction extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private UserService userService;
	private YuanQiUserServiceImpl yuanqiuserService;
	private String username;
	private String password;
	private JSONArray loginJSON;
	public JSONArray getLoginJSON() {
		return loginJSON;
	}

	public void setLoginJSON(JSONArray loginJSON) {
		this.loginJSON = loginJSON;
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	

	public YuanQiUserServiceImpl getYuanqiuserService() {
		return yuanqiuserService;
	}

	public void setYuanqiuserService(YuanQiUserServiceImpl yuanqiuserService) {
		this.yuanqiuserService = yuanqiuserService;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
	public String login(){
		if(username.isEmpty()||password.isEmpty())
			return "error";
		if(userService.userLogin(username, password)){
			HttpSession session = ServletActionContext.getRequest().getSession();
			session.setAttribute("mark", 0);
			System.out.println(password);
			return "login";
		}else if(yuanqiuserService.YuanQiUserlogin(username, password)){
					if(yuanqiuserService.getYuanQiUserInfo(username).getRemark().equals("1")){
						HttpSession session = ServletActionContext.getRequest().getSession();
						session.setAttribute("mark", 1);
						return "login";
					}else if(yuanqiuserService.getYuanQiUserInfo(username).getRemark().equals("2")){
						HttpSession session = ServletActionContext.getRequest().getSession();
						session.setAttribute("mark", 2);
						return "login";
					}
				}
		return "error";
	}
	public String loginUser(){
		loginJSON=new JSONArray();
		if(username.isEmpty()||password.isEmpty())
			loginJSON.add("empty");
		else if(userService.userLogin(username, password))
			loginJSON.add("ok");
		else if(yuanqiuserService.YuanQiUserlogin(username, password)){
			loginJSON.add("ok");
		}else
			loginJSON.add("error");
		return "loginUser";
	}
	public String userhome(){
		return "login";
	}
	public String passwordReset(){
		System.out.println(username);
		userService.passwordReset(username);
		/*yuanqiuserService.passwordReset(username);*/
		return "success";
	}
}
