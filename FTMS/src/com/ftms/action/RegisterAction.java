package com.ftms.action;

import java.sql.Timestamp;

import net.sf.json.JSONArray;
import com.ftms.entity.User;
import com.ftms.service.LocationService;
import com.ftms.service.ProfService;
import com.ftms.service.UserService;
import com.opensymphony.xwork2.ActionSupport;

public class RegisterAction extends ActionSupport {
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
	private String addr;
	private String picpath;
	private JSONArray userJSON;
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
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
	public UserService getUserService() {
		return userService;
	}
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	public LocationService getLocationService() {
		return locationService;
	}
	public void setLocationService(LocationService locationService) {
		this.locationService = locationService;
	}
	public ProfService getProfService() {
		return profService;
	}
	public void setProfService(ProfService profService) {
		this.profService = profService;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getProvinceid() {
		return provinceid;
	}
	public void setProvinceid(int provinceid) {
		this.provinceid = provinceid;
	}
	public String getIdnumber() {
		return idnumber;
	}
	public void setIdnumber(String idnumber) {
		this.idnumber = idnumber;
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
	public String getPicpath() {
		return picpath;
	}
	public void setPicpath(String picpath) {
		this.picpath = picpath;
	}
	public JSONArray getUserJSON() {
		return userJSON;
	}
	public void setUserJSON(JSONArray userJSON) {
		this.userJSON = userJSON;
	}
	public String uploadUser(){
		user=new User();
		String[]  time =year.split("/");
		String tsStr =time[2]+"-"+time[0]+"-"+time[1]+" 00:00:00";
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
		user.setPicpath(picpath);
		userService.register(user);
		return "uploadUser";
	}
	public String judgeUser(){
		userJSON=new JSONArray();
		if(userService.userExist(username)){
			userJSON.add("error");
		}else{
			userJSON.add("ok");
		}
		return "judgeUser";
	}
	public String uploadAddress(){
		locationService.setUserAddress(username, addr);
		return "uploadAddress";
	}
}
