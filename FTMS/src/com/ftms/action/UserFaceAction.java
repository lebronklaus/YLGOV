package com.ftms.action;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.ftms.entity.Address;
import com.ftms.entity.User;
import com.ftms.service.ExamService;
import com.ftms.service.LocationService;
import com.ftms.service.ResultsService;
import com.ftms.service.ShenyanService;
import com.ftms.service.UserService;
import com.opensymphony.xwork2.ActionSupport;

public class UserFaceAction extends ActionSupport {
	private User user;
	private UserService userService;
	private ResultsService resultsService;
	private ExamService examService;
	private ShenyanService shenyanService;
	private LocationService locationService;
	private String username;
	private Address address;
	private JSONArray faceJSON;
	private String birth;
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
	public String getBirth() {
		return birth;
	}
	public void setBirth(String birth) {
		this.birth = birth;
	}
	public ResultsService getResultsService() {
		return resultsService;
	}
	public void setResultsService(ResultsService resultsService) {
		this.resultsService = resultsService;
	}
	public ExamService getExamService() {
		return examService;
	}
	public void setExamService(ExamService examService) {
		this.examService = examService;
	}
	public ShenyanService getShenyanService() {
		return shenyanService;
	}
	public void setShenyanService(ShenyanService shenyanService) {
		this.shenyanService = shenyanService;
	}
	public JSONArray getFaceJSON() {
		return faceJSON;
	}
	public void setFaceJSON(JSONArray faceJSON) {
		this.faceJSON = faceJSON;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
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
	
	public String userFace(){
		this.user=userService.getUserInfo(username);
		String[] time=user.getBirthday().toString().split(" ")[0].split("-");
		this.birth=time[1]+"/"+time[2]+"/"+time[0];
		if(user.getIdnumber().length()<18){
			user.setIdnumber("");
		}
		if(user.getPicpath().equals("sss"))
			user.setPicpath("../images/ManagementSystem/nopic.png");
		address=locationService.getUserAddress(username);
		return "userFace";
	}
	public String faceload(){
//		faceJSON=new JSONArray();
//		JSONObject json=new JSONObject();
//		if(examService.examExist(username, "农技员")){
//			json.clear();
//			json.put("exam_exsit", "已报名");
//			if(examService.examJudge(username, "农技员")){
//				json.put("exam_status", "已审核");
//			}else{
//				json.put("exam_status", "未审核");
//			}
//			json.put("result", resultsService.getzhenshu(username, "农技员"));
//			json.put("shenyan", shenyanService.judge(username,  "农技员"));
//			faceJSON.add(json);
//		}else{
//			json.clear();
//			json.put("exam_exsit", "未报名");
//			json.put("exam_status", "未审核");
//			json.put("result", resultsService.getzhenshu(username, "农技员"));
//			json.put("shenyan", shenyanService.judge(username,  "农技员"));
//			faceJSON.add(json);
//		}
//		if(examService.examExist(username, "农技师")){
//			json.clear();
//			json.put("exam_exsit", "已报名");
//			if(examService.examJudge(username, "农技师")){
//				json.put("exam_status", "已审核");
//			}else{
//				json.put("exam_status", "未审核");
//			}
//			json.put("result", resultsService.getzhenshu(username, "农技师"));
//			json.put("shenyan", shenyanService.judge(username,  "农技师"));
//			faceJSON.add(json);
//		}else{
//			json.clear();
//			json.put("exam_exsit", "未报名");
//			json.put("exam_status", "未审核");
//			json.put("result", resultsService.getzhenshu(username, "农技师"));
//			json.put("shenyan", shenyanService.judge(username,  "农技师"));
//			faceJSON.add(json);
//		}
//		if(examService.examExist(username, "高级农技师")){
//			json.clear();
//			json.put("exam_exsit", "已报名");
//			if(examService.examJudge(username, "高级农技师")){
//				json.put("exam_status", "已审核");
//			}else{
//				json.put("exam_status", "未审核");
//			}
//			json.put("result", resultsService.getzhenshu(username, "高级农技师"));
//			json.put("shenyan", shenyanService.judge(username,  "高级农技师"));
//			faceJSON.add(json);
//		}else{
//			json.clear();
//			json.put("exam_exsit", "未报名");
//			json.put("exam_status", "未审核");
//			json.put("result", resultsService.getzhenshu(username, "高级农技师"));
//			json.put("shenyan", shenyanService.judge(username,  "高级农技师"));
//			faceJSON.add(json);
//		}
//		return "faceload";
		faceJSON=new JSONArray();
		JSONObject json=new JSONObject();
		json.put("result_njy", resultsService.getzhenshu(username, "农技员"));
		json.put("result_njs", resultsService.getzhenshu(username, "农技师"));
		json.put("result_gjnjs", resultsService.getzhenshu(username, "高级农技师"));
		faceJSON.add(json);
		return "faceload";
	}
	public String addressload(){
		address=locationService.getUserAddress(username);
		return "addressload";
	}
	public String useraddressload(){
		this.faceJSON=new JSONArray();
		address=locationService.getUserAddress(username);
		this.faceJSON.add(address.getAddress());
		return "useraddressload";
	}
}
