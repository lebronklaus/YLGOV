package cn.nwsuaf.gov.teacherManage;

import com.opensymphony.xwork2.ActionSupport;

import cn.nwsuaf.gov.service.BusinessFactory;
import cn.nwsuaf.gov.service.TrainTeachersBusiness;

public class TeaAddAction extends ActionSupport{
	private String teaname; 
	private String gender ;
	private String workplace;
	private String inwork;
	private String profession; 
	private String phonenum ;
	private String university; 
	private String major ;
	private String address;
	private String email ;
	private String inputNote; 
	private String user_picpath;
	
	/*
	 * add train_teacher action
	 * */
	public String addTeacher() throws Exception{
		TrainTeachersBusiness ttbusi = BusinessFactory
				.createTrainTeacherBussiness();
		ttbusi.add(teaname, gender,
				workplace, inwork,
				university, major,
				profession, address,
				email, inputNote,
				phonenum, user_picpath);
		return "success";
	}
	
	public String getTeaname() {
		return teaname;
	}
	public void setTeaname(String teaname) {
		this.teaname = teaname;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getWorkplace() {
		return workplace;
	}
	public void setWorkplace(String workplace) {
		this.workplace = workplace;
	}
	public String getInwork() {
		return inwork;
	}
	public void setInwork(String inwork) {
		this.inwork = inwork;
	}
	public String getProfession() {
		return profession;
	}
	public void setProfession(String profession) {
		this.profession = profession;
	}
	public String getPhonenum() {
		return phonenum;
	}
	public void setPhonenum(String phonenum) {
		this.phonenum = phonenum;
	}
	public String getUniversity() {
		return university;
	}
	public void setUniversity(String university) {
		this.university = university;
	}
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getInputNote() {
		return inputNote;
	}
	public void setInputNote(String inputNote) {
		this.inputNote = inputNote;
	}
	public String getUser_picpath() {
		return user_picpath;
	}
	public void setUser_picpath(String user_picpath) {
		this.user_picpath = user_picpath;
	}
	
	

}
