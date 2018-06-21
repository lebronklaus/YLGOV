package com.ftms.action;

import net.sf.json.JSONArray;

import com.ftms.service.ExamService;
import com.opensymphony.xwork2.ActionSupport;

public class KsshAction extends ActionSupport {
	private ExamService examService;
	private JSONArray examJson;
	private String name;
	private String level;
	private int time;
	private String address;
	private String status;
	private int id;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public ExamService getExamService() {
		return examService;
	}
	public void setExamService(ExamService examService) {
		this.examService = examService;
	}
	public JSONArray getExamJson() {
		return examJson;
	}
	public void setExamJson(JSONArray examJson) {
		this.examJson = examJson;
	}
	
	public String kssh(){
		return "kssh";
	}
	public String ksshload(){
		this.examJson=examService.searchExam(name, time, level, address, status);
		return "ksshload";
	}
	public String examcheck(){
		examService.examCheck(id, "是");
		return "examcheck";
	}
}
