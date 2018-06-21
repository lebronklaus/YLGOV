package com.ftms.action;

import net.sf.json.JSONArray;

import com.ftms.entity.YuanQiUser;
import com.ftms.service.UserService;
import com.ftms.serviceImpl.YuanQiUserServiceImpl;

public class YuanQiRegisterAction {
	private YuanQiUser yuanqi;
	private YuanQiUserServiceImpl yuanqiservice;
	private UserService userService;
	private String username;
	private String password;
	private String email;
	private String remark;
	private JSONArray yuanqijson;
	public YuanQiUser getYuanqi() {
		return yuanqi;
	}
	public void setYuanqi(YuanQiUser yuanqi) {
		this.yuanqi = yuanqi;
	}
	public YuanQiUserServiceImpl getYuanqiservice() {
		return yuanqiservice;
	}
	public void setYuanqiservice(YuanQiUserServiceImpl yuanqiservice) {
		this.yuanqiservice = yuanqiservice;
	}
	public UserService getUserService() {
		return userService;
	}
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	public JSONArray getYuanqijson() {
		return yuanqijson;
	}
	public void setYuanqijson(JSONArray yuanqijson) {
		this.yuanqijson = yuanqijson;
	}
	public String uploadYuanQi(){
		yuanqi = new YuanQiUser();
		yuanqi.setUsername(username);
		yuanqi.setPassword(password);
		yuanqi.setEmail(email);
		yuanqi.setRemark(remark);
		yuanqiservice.register(yuanqi);
		return "success";
	}
	
	public String judgeYuanQiUser(){
		yuanqijson = new JSONArray();
		if(userService.userExist(username)|| yuanqiservice.yuanqiuserExist(username)){
			yuanqijson.add("error");
		}else{
			yuanqijson.add("ok");
		}
		return "success";
	}
}
