package com.ftms.action;

import net.sf.json.JSONArray;
import com.ftms.service.ShenyanService;
import com.opensymphony.xwork2.ActionSupport;

public class RysyAction extends ActionSupport {
private ShenyanService shenyanService;
private JSONArray rysyJson;
private String name;
private String level;
private String username;
private int id;
public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}

public ShenyanService getShenyanService() {
	return shenyanService;
}
public void setShenyanService(ShenyanService shenyanService) {
	this.shenyanService = shenyanService;
}
public JSONArray getRysyJson() {
	return rysyJson;
}
public void setRysyJson(JSONArray rysyJson) {
	this.rysyJson = rysyJson;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getLevel() {
	return level;
}
public void setLevel(String level) {
	this.level = level;
}
public String rysy(){
	return "rysy";
}
public String rysyload(){
	this.rysyJson=shenyanService.searchCheck(name, level);

	return "rysyload";
}
public String rysycheck(){
	shenyanService.check(id, username);
	return "rysycheck";
}
}
