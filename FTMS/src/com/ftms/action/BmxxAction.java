package com.ftms.action;

import net.sf.json.JSONArray;

import com.ftms.entity.Exam;
import com.ftms.entity.User;
import com.ftms.service.ExamService;
import com.ftms.service.UserService;
import com.opensymphony.xwork2.ActionSupport;

public class BmxxAction extends ActionSupport {
	private UserService userService;
	private ExamService examService;
	private User user;
	private String username;
	private String level;
	private int time;
	private String address;
	private JSONArray bmxxJSON;
	private String birth;

	public String getBirth() {
		return birth;
	}
	public void setBirth(String birth) {
		this.birth = birth;
	}
	public JSONArray getBmxxJSON() {
		return bmxxJSON;
	}
	public void setBmxxJSON(JSONArray bmxxJSON) {
		this.bmxxJSON = bmxxJSON;
	}
	public ExamService getExamService() {
		return examService;
	}
	public void setExamService(ExamService examService) {
		this.examService = examService;
	}
	public String getLevel() {
		return level;
	}
	public void setLevel(String level) {
		this.level = level;
	}
	public int getTime() {
		return time;
	}
	public void setTime(int time) {
		this.time = time;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public UserService getUserService() {
		return userService;
	}
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	
	public String bmxx(){
		this.user=userService.getUserInfo(username);
		String[] time=user.getBirthday().toString().split(" ")[0].split("-");
		this.birth=time[1]+"/"+time[2]+"/"+time[0];
		if(user.getIdnumber().length()<18){
			user.setIdnumber("");
		}
		if(user.getPicpath().equals("sss"))
			user.setPicpath("../images/ManagementSystem/nopic.png");
		return "bmxx";
	}
	public String saveExam(){
		Exam exam=new Exam();
		exam.setAddress(address);
		exam.setLevel(level);
		exam.setTime(time);

		if(examService.examExist(username, level)){
			System.out.println("存在");
			examService.updateExam(username, exam);
		}
		else{
			System.out.println("不存在");
			examService.uploadExam(username, exam);
		}
		return "saveExam";
	}
	public String bmxxjudge(){
		bmxxJSON=new JSONArray();
		String str="否";
		if(examService.examJudge(username, level))
		{
			str="是";
		}
		bmxxJSON.add(str);
		return "bmxxjudge";
	}
}
