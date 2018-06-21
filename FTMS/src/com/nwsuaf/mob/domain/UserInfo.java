package com.nwsuaf.mob.domain;

/*
 * �������ֻ�˴���user��������������дuser��
 */
public class UserInfo {
	private String name;
	private String gender;
	private String birthday;
	private String address;
	private String idnumber;
	private String phone;
	private String education;
	private String prof;
	public UserInfo(String name, String gender, String birthday,
			String address, String idnumber, String phone, String education,
			String prof) {
		super();
		this.name = name;
		this.gender = gender;
		this.birthday = birthday;
		this.address = address;
		this.idnumber = idnumber;
		this.phone = phone;
		this.education = education;
		this.prof = prof;
	}
	public UserInfo() {
		super();
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
	@Override
	public String toString() {
		return "UserInfo [name=" + name + ", gender=" + gender + ", birthday="
				+ birthday + ", address=" + address + ", idnumber=" + idnumber
				+ ", phone=" + phone + ", education=" + education + ", prof="
				+ prof + "]";
	}
	
}
