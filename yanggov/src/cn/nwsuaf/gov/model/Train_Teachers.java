package cn.nwsuaf.gov.model;

import java.io.Serializable;

public class Train_Teachers implements Serializable {
	private String teacher_name;
	private String teacher_sex;
	private String teacher_workplace;
	private String teacher_inwork;
	private String teacher_university;
	private String teacher_major;
	private String teacher_professional;
	private String teacher_address;
	private String teacher_email;
	private String teacher_profile;

	public String getTeacher_phonenum() {
		return teacher_phonenum;
	}

	public void setTeacher_phonenum(String teacher_phonenum) {
		this.teacher_phonenum = teacher_phonenum;
	}

	private String teacher_phonenum;
	private String teacher_path;

	public String getTeacher_path() {
		return teacher_path;
	}

	public void setTeacher_path(String teacher_path) {
		this.teacher_path = teacher_path;
	}

	private int teacher_id;

	public Train_Teachers() {
	}

	public String getTeacher_name() {
		return teacher_name;
	}

	public void setTeacher_name(String teacher_name) {
		this.teacher_name = teacher_name;
	}

	public String getTeacher_sex() {
		return teacher_sex;
	}

	public void setTeacher_sex(String teacher_sex) {
		this.teacher_sex = teacher_sex;
	}

	public String getTeacher_workplace() {
		return teacher_workplace;
	}

	public void setTeacher_workplace(String teacher_workplace) {
		this.teacher_workplace = teacher_workplace;
	}

	public String getTeacher_inwork() {
		return teacher_inwork;
	}

	public void setTeacher_inwork(String teacher_inwork) {
		this.teacher_inwork = teacher_inwork;
	}

	public String getTeacher_university() {
		return teacher_university;
	}

	public void setTeacher_university(String teacher_university) {
		this.teacher_university = teacher_university;
	}

	public String getTeacher_major() {
		return teacher_major;
	}

	public void setTeacher_major(String teacher_major) {
		this.teacher_major = teacher_major;
	}

	public String getTeacher_professional() {
		return teacher_professional;
	}

	public void setTeacher_professional(String teacher_professional) {
		this.teacher_professional = teacher_professional;
	}

	public String getTeacher_address() {
		return teacher_address;
	}

	public void setTeacher_address(String teacher_address) {
		this.teacher_address = teacher_address;
	}

	public String getTeacher_email() {
		return teacher_email;
	}

	public void setTeacher_email(String teacher_email) {
		this.teacher_email = teacher_email;
	}

	public String getTeacher_profile() {
		return teacher_profile;
	}

	public void setTeacher_profile(String teacher_profile) {
		this.teacher_profile = teacher_profile;
	}

	public int getTeacher_id() {
		return teacher_id;
	}

	public void setTeacher_id(int teacher_id) {
		this.teacher_id = teacher_id;
	}

}
