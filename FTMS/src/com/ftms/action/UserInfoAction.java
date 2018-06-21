package com.ftms.action;


import java.sql.Timestamp;





import net.sf.json.JSONArray;

import com.ftms.entity.User;
import com.ftms.service.LocationService;
import com.ftms.service.ProfService;
import com.ftms.service.UserService;
import com.opensymphony.xwork2.ActionSupport;

public class UserInfoAction extends ActionSupport {
	private User user;
	private String username;
	private UserService userService;
	private LocationService locationService;
	private ProfService profService;
	private String year;
	private String education;
	private String gender;
	private String phone;
	private String password;
	private String name;
	private int provinceid;
	private String idnumber;
	private long cityid;
	private long countyid;
	private long townid;
	private int profid;
	private String picpath;
	private JSONArray imgJSON;
	public JSONArray getImgJSON() {
		return imgJSON;
	}
	public void setImgJSON(JSONArray imgJSON) {
		this.imgJSON = imgJSON;
	}
	public String getPicpath() {
		return picpath;
	}
	public void setPicpath(String picpath) {
		this.picpath = picpath;
	}
	public String getIdnumber() {
		return idnumber;
	}
	public void setIdnumber(String idnumber) {
		this.idnumber = idnumber;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEducation() {
		return education;
	}
	public void setEducation(String education) {
		this.education = education;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public ProfService getProfService() {
		return profService;
	}
	public void setProfService(ProfService profService) {
		this.profService = profService;
	}
	public LocationService getLocationService() {
		return locationService;
	}
	public void setLocationService(LocationService locationService) {
		this.locationService = locationService;
	}
	public int getProvinceid() {
		return provinceid;
	}
	public void setProvinceid(int provinceid) {
		this.provinceid = provinceid;
	}
	public long getCityid() {
		return cityid;
	}
	public void setCityid(long cityid) {
		this.cityid = cityid;
	}
	public long getCountyid() {
		return countyid;
	}
	public void setCountyid(long countyid) {
		this.countyid = countyid;
	}
	public long getTownid() {
		return townid;
	}
	public void setTownid(long townid) {
		this.townid = townid;
	}
	public int getProfid() {
		return profid;
	}
	public void setProfid(int profid) {
		this.profid = profid;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
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
	
	public String xxwh(){
		this.user=userService.getUserInfo(username);
		String[] time=user.getBirthday().toString().split(" ")[0].split("-");
		this.year=time[1]+"/"+time[2]+"/"+time[0];
		if(user.getPicpath().equals("sss"))
			user.setPicpath("../images/ManagementSystem/nopic.png");
		return "xxwh";
	}
	public String uploadUser(){
		System.out.println("1");
		String[]  time =year.split("/");
		System.out.println("2");
		String tsStr =time[2]+"-"+time[0]+"-"+time[1]+" 00:00:00";
		System.out.println("3");
		user.setBirthday(Timestamp.valueOf(tsStr));
		System.out.println("4");
		user.setPassword(password);
		System.out.println("5");
		user.setName(name);
		System.out.println("6");
		user.setGender(gender);
		System.out.println("7");
		user.setPhone(phone);
		System.out.println("8");
		user.setEducation(education);
		System.out.println("9");
		user.setIdnumber(idnumber);
		System.out.println("10");
		try{
			System.out.println("11");
			user.setJPositionProvice(locationService.getUserProvince(provinceid));
			System.out.println("12");
			user.setJPositionCity(locationService.getUserCity(cityid));
			System.out.println("13");
			user.setJPositionCounty(locationService.getUserCounty(countyid));
			System.out.println("14");
			user.setJPositionTown(locationService.getUserTown(townid));
			System.out.println("15");
			user.setProf2(profService.getUserProf2(profid));
			System.out.println("16");
			
		} catch (Exception e) {
			return "uploadUser";
		}
		userService.modifyUserInfo(user);

		return "uploadUser";
	}
	public String uploadUserManage(){
		String[]  time =year.split("/");
		String tsStr =time[2]+"-"+time[0]+"-"+time[1]+" 00:00:00";
		user=new User();
		user.setUsername(username);
		user.setBirthday(Timestamp.valueOf(tsStr));
		user.setPassword(password);
		user.setName(name);
		user.setGender(gender);
		user.setPhone(phone);
		user.setEducation(education);
		user.setIdnumber(idnumber);
		user.setJPositionProvice(locationService.getUserProvince(provinceid));
		user.setJPositionCity(locationService.getUserCity(cityid));
		user.setJPositionCounty(locationService.getUserCounty(countyid));
		user.setJPositionTown(locationService.getUserTown(townid));
		user.setProf2(profService.getUserProf2(profid));
		userService.modifyUserInfoManage(user);
		return "uploadUser";
	}
	public String imgUser(){
		imgJSON=new JSONArray();
		user=userService.getUserInfo(username);
		user.setPicpath(picpath);
		userService.modifyUserInfo(user);
		imgJSON.add("上传成功！");
		return "imgUser";
	}
}
