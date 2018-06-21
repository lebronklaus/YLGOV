package com.ftms.action;

import net.sf.json.JSONArray;
import com.ftms.entity.Address;
import com.ftms.service.ExamService;
import com.ftms.service.LocationService;
import com.ftms.service.ResultsService;
import com.ftms.service.ShenyanService;
import com.opensymphony.xwork2.ActionSupport;

public class JgcxAction extends ActionSupport {
private ResultsService resultsService;
private ExamService examService;
private ShenyanService shenyanService;
private LocationService locationService;
private String level;
private int level0;
private String username;
private String name;
private Address address;
private JSONArray jgcxJSON;

public int getLevel0() {
	return level0;
}
public void setLevel0(int level0) {
	this.level0 = level0;
}
public LocationService getLocationService() {
	return locationService;
}
public void setLocationService(LocationService locationService) {
	this.locationService = locationService;
}
public Address getAddress() {
	return address;
}
public void setAddress(Address address) {
	this.address = address;
}
public ShenyanService getShenyanService() {
	return shenyanService;
}
public void setShenyanService(ShenyanService shenyanService) {
	this.shenyanService = shenyanService;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public JSONArray getJgcxJSON() {
	return jgcxJSON;
}
public void setJgcxJSON(JSONArray jgcxJSON) {
	this.jgcxJSON = jgcxJSON;
}
public ExamService getExamService() {
	return examService;
}
public void setExamService(ExamService examService) {
	this.examService = examService;
}
public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
public ResultsService getResultsService() {
	return resultsService;
}
public void setResultsService(ResultsService resultsService) {
	this.resultsService = resultsService;
}
public String getLevel() {
	return level;
}
public void setLevel(String level) {
	this.level = level;
}
public String jgcx(){
	return "jgcx";
}
public String jgcxload_one(){
	jgcxJSON=new JSONArray();
	
	jgcxJSON=resultsService.getUserResult(username, level);
	
	return "jgcxload";
}
public String jgcxload_two(){
	jgcxJSON=new JSONArray();
	jgcxJSON=examService.searchExam(name, 0, level, "无", "无");
	return "jgcxload";
}
public String shenyan(){
//	jgcxJSON=new JSONArray();
//	JsonConfig jsonConfig= new JsonConfig();
//	jsonConfig.setExcludes(new String[]{"resultses","users","exams","certificates","achievements","shenyans","prof2sForClass1name","prof2sForC1id"});
//	this.jgcxJSON=JSONArray.fromObject(shenyanService.findUser(name, level),jsonConfig);
//	return "shenyan";
	this.jgcxJSON=shenyanService.findUser(name, level);
	return "shenyan";
}
public String addressload(){
	jgcxJSON=new JSONArray();
	address=locationService.getUserAddress(username);
	jgcxJSON=new JSONArray();
	jgcxJSON.add(address.getAddress());
	return "addressload";
}
public String report(){
//	if(level0==1){
//		level="农技员";
//	}else if(level0==2){
//		level="农技师";
//	}else{
//		level="高级农技师";
//	}
	return "report";
}
}