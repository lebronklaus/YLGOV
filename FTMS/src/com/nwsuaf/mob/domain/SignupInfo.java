package com.nwsuaf.mob.domain;
/*
 * Ϊ�˼��ٴ���������дexam��
 */
public class SignupInfo {
	private String name;
	private String gender;
	private String birthday;
	private String address;
	private String idnumber;
	private String phone;
	private String education;
	private String prof;
	private String level;
	private String time;
	private String examaddress;
	private String status;
	public SignupInfo() {
		super();
	}
	public SignupInfo(String name, String gender, String birthday,
			String address, String idnumber, String phone, String education,
			String prof, String level, String time, String examaddress,
			String status) {
		super();
		this.name = name;
		this.gender = gender;
		this.birthday = birthday;
		this.address = address;
		this.idnumber = idnumber;
		this.phone = phone;
		this.education = education;
		this.prof = prof;
		this.level = level;
		this.time = time;
		this.examaddress = examaddress;
		this.status = status;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getIdnumber() {
		return idnumber;
	}
	public void setIdnumber(String idnumber) {
		this.idnumber = idnumber;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEducation() {
		return education;
	}
	public void setEducation(String education) {
		this.education = education;
	}
	public String getProf() {
		return prof;
	}
	public void setProf(String prof) {
		this.prof = prof;
	}
	public String getLevel() {
		return level;
	}
	public void setLevel(String level) {
		this.level = level;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getExamaddress() {
		return examaddress;
	}
	public void setExamaddress(String examaddress) {
		this.examaddress = examaddress;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "SignupInfo [name=" + name + ", gender=" + gender
				+ ", birthday=" + birthday + ", address=" + address
				+ ", idnumber=" + idnumber + ", phone=" + phone
				+ ", education=" + education + ", prof=" + prof + ", level="
				+ level + ", time=" + time + ", examaddress=" + examaddress
				+ ", status=" + status + "]";
	}
}
