package com.ftms.action;

import net.sf.json.JSONArray;

import com.ftms.service.UserService;
import com.opensymphony.xwork2.ActionSupport;

public class UserManageAction extends ActionSupport {
private UserService userService;
private JSONArray userJson;
private String name;
private String username;
private int id;
private String rows;
private String page;

private JSONArray psdJson;

	public JSONArray getPsdJson() {
		return psdJson;
	}

	public void setPsdJson(JSONArray psdJson) {
		this.psdJson = psdJson;
	}

	public String getRows() {
	return rows;
}
public void setRows(String rows) {
	this.rows = rows;
}
public String getPage() {
	return page;
}
public void setPage(String page) {
	this.page = page;
}
public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
public UserService getUserService() {
	return userService;
}
public void setUserService(UserService userService) {
	this.userService = userService;
}
public JSONArray getUserJson() {
	return userJson;
}
public void setUserJson(JSONArray userJson) {
	this.userJson = userJson;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String userManagement(){
	return "userManagement";
}
public String userload(){
	this.userJson=userService.searchUser(name);
	return "userload";
}
public String deleteUser(){
	userService.deleteUser(id);
	return "delete";
}
//follow 3 by xiuhao.yan
public String queryPsd(){
	psdJson = new JSONArray();
	String psd = userService.queryPsd(username);
	psdJson.add(0,psd);
	return "queryPsd";
}
public String resetPsd(){
	psdJson = new JSONArray();
	psdJson.add(0,userService.resetPsd(username));
	return "resetPsd";
}
public String resetAllPsd(){
	psdJson = new JSONArray();
	psdJson.add(0,userService.resetAllPsd());
	return "resetAllPsd";
}

}
