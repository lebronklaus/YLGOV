package com.ftms.action;


import java.sql.Timestamp;

import net.sf.json.JSONArray;

import com.ftms.entity.Achievement;
import com.ftms.entity.Certificate;
import com.ftms.entity.Exam;
import com.ftms.entity.Results;
import com.ftms.entity.Shenyan;
import com.ftms.entity.User;
import com.ftms.service.AllInsertService;
import com.ftms.service.LocationService;
import com.ftms.service.ProfService;
import com.opensymphony.xwork2.ActionSupport;

public class AllInsertAction extends ActionSupport {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private AllInsertService allInsertService;
	
	private LocationService locationService;
	private ProfService profService;
	public AllInsertService getAllInsertService() {
		return allInsertService;
	}

	public void setAllInsertService(AllInsertService allInsertService) {
		this.allInsertService = allInsertService;
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

	private User user;
	private String username;
	private String birthday;
	private String education;
	private String gender;
	private String phone;
	private String password;
	private String name;
	private int provinceid;
	private long cityid;
	private long countyid;
	private long townid;
	private int profid;
	private String addr;
	private JSONArray userJSON;
	
	private String username_ks;
	private String level;
	private int month;
	private String address_sh;
	private String shenhe;
	
	private String username_jg;
	private String achievement_jg;
	private int total;
	private int canjia;
	private int approval;
	private int opposition;
	private String checktime;
	private String level_jg;
	private String number;
	private String  fazhengtime;
	private Float writescore;
	private Float interviewscore;
	private Float totalscore;
	
	private String username_zs;
	private String time_zs;
	private String major;
	private String certificatename;
	
	private String username_yj;
	private String start;
	private String end;
	private String completion;
	private String winess;

	private String username_sy;
	private int year_sy;
	private String level_sy;
	private String status_sy;
	
	public String getUsername_sy() {
		return username_sy;
	}

	public void setUsername_sy(String username_sy) {
		this.username_sy = username_sy;
	}

	public int getYear_sy() {
		return year_sy;
	}

	public void setYear_sy(int year_sy) {
		this.year_sy = year_sy;
	}

	public String getLevel_sy() {
		return level_sy;
	}

	public void setLevel_sy(String level_sy) {
		this.level_sy = level_sy;
	}

	public String getStatus_sy() {
		return status_sy;
	}

	public void setStatus_sy(String status_sy) {
		this.status_sy = status_sy;
	}

	public JSONArray getUserJSON() {
		return userJSON;
	}

	public void setUserJSON(JSONArray userJSON) {
		this.userJSON = userJSON;
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

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
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

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public String getUsername_ks() {
		return username_ks;
	}

	public void setUsername_ks(String username_ks) {
		this.username_ks = username_ks;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public String getAddress_sh() {
		return address_sh;
	}

	public void setAddress_sh(String address_sh) {
		this.address_sh = address_sh;
	}

	public String getShenhe() {
		return shenhe;
	}

	public void setShenhe(String shenhe) {
		this.shenhe = shenhe;
	}

	public String getUsername_jg() {
		return username_jg;
	}

	public void setUsername_jg(String username_jg) {
		this.username_jg = username_jg;
	}

	public String getAchievement_jg() {
		return achievement_jg;
	}

	public void setAchievement_jg(String achievement_jg) {
		this.achievement_jg = achievement_jg;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public int getCanjia() {
		return canjia;
	}

	public void setCanjia(int canjia) {
		this.canjia = canjia;
	}

	public int getApproval() {
		return approval;
	}

	public void setApproval(int approval) {
		this.approval = approval;
	}

	public int getOpposition() {
		return opposition;
	}

	public void setOpposition(int opposition) {
		this.opposition = opposition;
	}

	public String getChecktime() {
		return checktime;
	}

	public void setChecktime(String checktime) {
		this.checktime = checktime;
	}

	public String getLevel_jg() {
		return level_jg;
	}

	public void setLevel_jg(String level_jg) {
		this.level_jg = level_jg;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getFazhengtime() {
		return fazhengtime;
	}

	public void setFazhengtime(String fazhengtime) {
		this.fazhengtime = fazhengtime;
	}

	public Float getWritescore() {
		return writescore;
	}

	public void setWritescore(Float writescore) {
		this.writescore = writescore;
	}

	public Float getInterviewscore() {
		return interviewscore;
	}

	public void setInterviewscore(Float interviewscore) {
		this.interviewscore = interviewscore;
	}

	public Float getTotalscore() {
		return totalscore;
	}

	public void setTotalscore(Float totalscore) {
		this.totalscore = totalscore;
	}

	public String getUsername_zs() {
		return username_zs;
	}

	public void setUsername_zs(String username_zs) {
		this.username_zs = username_zs;
	}

	public String getTime_zs() {
		return time_zs;
	}

	public void setTime_zs(String time_zs) {
		this.time_zs = time_zs;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public String getCertificatename() {
		return certificatename;
	}

	public void setCertificatename(String certificatename) {
		this.certificatename = certificatename;
	}


	public String getStart() {
		return start;
	}

	public void setStart(String start) {
		this.start = start;
	}

	public String getUsername_yj() {
		return username_yj;
	}

	public void setUsername_yj(String username_yj) {
		this.username_yj = username_yj;
	}

	public String getEnd() {
		return end;
	}

	public void setEnd(String end) {
		this.end = end;
	}

	public String getCompletion() {
		return completion;
	}

	public void setCompletion(String completion) {
		this.completion = completion;
	}

	public String getWiness() {
		return winess;
	}

	public void setWiness(String winess) {
		this.winess = winess;
	}

	public String uploadUser(){
		user=new User();
		String[]  ttttt =birthday.split("/");
		String tsStr =ttttt[2]+"-"+ttttt[0]+"-"+ttttt[1]+" 00:00:00";
		user.setUsername(username);

		user.setBirthday(Timestamp.valueOf(tsStr));

		user.setPassword(password);
		user.setName(name);
		user.setGender(gender);
		user.setPhone(phone);
		user.setEducation(education);
		user.setIdnumber(username);
		user.setJPositionProvice(locationService.getUserProvince(provinceid));
		user.setJPositionCity(locationService.getUserCity(cityid));
		user.setJPositionCounty(locationService.getUserCounty(countyid));
		user.setJPositionTown(locationService.getUserTown(townid));
		user.setProf2(profService.getUserProf2(profid));
		user.setPicpath("sss");
		allInsertService.register(user);
		
		return "uploadUser";
	}
	public String judgeUser(){
		userJSON=new JSONArray();
		if(allInsertService.userExist(username)){
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
	
	
	public String saveExam(){
		Exam exam=new Exam();
		exam.setAddress(address_sh);
		exam.setLevel(level);
		exam.setTime(month);
		exam.setStatus(shenhe);
		allInsertService.updateExam(username_ks, exam);
		return "saveExam";
	}
	
	public String allinsert_result(){
		String[]  time =checktime.split("/");
		String tsStr =time[2]+"-"+time[0]+"-"+time[1]+" 00:00:00";
		String[]  time3 =fazhengtime.split("/");
		String tsStr1 =time3[2]+"-"+time3[0]+"-"+time3[1]+" 00:00:00";
		Results r=new Results();
		r.setAchievement(achievement_jg);
		r.setApproval(approval);
		r.setChecktime(Timestamp.valueOf(tsStr));
		r.setFazhengtime(Timestamp.valueOf(tsStr1));
		r.setInterviewscore(interviewscore);
		r.setLevel(level_jg);
		r.setNumber(number);
		r.setOpposition(opposition);
		r.setCanjia(canjia);
		r.setTotal(total);
		r.setTotalscore(totalscore);
		r.setWritescore(writescore);
		allInsertService.SaveResult(username_jg, r);
		return "allinsert_result";
	}
	
	public String uploadUser_cer(){
		Certificate c=new Certificate();
		
		c.setMajor(major);
		c.setTime(time_zs);
		c.setCertificatename(certificatename);
		allInsertService.addCertificate(username_zs, c);
		return "uploadUser_cer";
	}
	
	public String allinsert_ach(){
		Achievement ach=new Achievement();
		
		ach.setCompletion(completion);
		ach.setEnd(end);
		ach.setStart(start);
		ach.setWiness(winess);
		allInsertService.addAchievement(username_yj, ach);
		return "allinsert_ach";
	}
	
	public String allinsert_sy(){
		Shenyan s=new Shenyan();
		s.setLevel(level_sy);
		s.setStatus(status_sy);
		s.setYear(year_sy);
		allInsertService.check(username_sy, s);
		return "allinsert_sy";
	}
}
