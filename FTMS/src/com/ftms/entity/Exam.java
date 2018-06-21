package com.ftms.entity;

import java.sql.Timestamp;

/**
 * Exam entity. @author MyEclipse Persistence Tools
 */

public class Exam implements java.io.Serializable {

	// Fields

	private Integer id;
	private Prof2 prof2;
	private JPositionCounty JPositionCounty;
	private JPositionCity JPositionCity;
	private JPositionProvice JPositionProvice;
	private JPositionTown JPositionTown;
	private String level;
	private Integer time;
	private String address;
	private String name;
	private String gender;
	private Timestamp birthday;
	private String phone;
	private String idnumber;
	private String education;
	private String status;
	private String picpath;

	// Constructors

	/** default constructor */
	public Exam() {
	}

	/** full constructor */
	public Exam(Prof2 prof2, JPositionCounty JPositionCounty,
			JPositionCity JPositionCity, JPositionProvice JPositionProvice,
			JPositionTown JPositionTown, String level, Integer time,
			String address, String name, String gender, Timestamp birthday,
			String phone, String idnumber, String education, String status,
			String picpath) {
		this.prof2 = prof2;
		this.JPositionCounty = JPositionCounty;
		this.JPositionCity = JPositionCity;
		this.JPositionProvice = JPositionProvice;
		this.JPositionTown = JPositionTown;
		this.level = level;
		this.time = time;
		this.address = address;
		this.name = name;
		this.gender = gender;
		this.birthday = birthday;
		this.phone = phone;
		this.idnumber = idnumber;
		this.education = education;
		this.status = status;
		this.picpath = picpath;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Prof2 getProf2() {
		return this.prof2;
	}

	public void setProf2(Prof2 prof2) {
		this.prof2 = prof2;
	}

	public JPositionCounty getJPositionCounty() {
		return this.JPositionCounty;
	}

	public void setJPositionCounty(JPositionCounty JPositionCounty) {
		this.JPositionCounty = JPositionCounty;
	}

	public JPositionCity getJPositionCity() {
		return this.JPositionCity;
	}

	public void setJPositionCity(JPositionCity JPositionCity) {
		this.JPositionCity = JPositionCity;
	}

	public JPositionProvice getJPositionProvice() {
		return this.JPositionProvice;
	}

	public void setJPositionProvice(JPositionProvice JPositionProvice) {
		this.JPositionProvice = JPositionProvice;
	}

	public JPositionTown getJPositionTown() {
		return this.JPositionTown;
	}

	public void setJPositionTown(JPositionTown JPositionTown) {
		this.JPositionTown = JPositionTown;
	}

	public String getLevel() {
		return this.level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public Integer getTime() {
		return this.time;
	}

	public void setTime(Integer time) {
		this.time = time;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return this.gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Timestamp getBirthday() {
		return this.birthday;
	}

	public void setBirthday(Timestamp birthday) {
		this.birthday = birthday;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getIdnumber() {
		return this.idnumber;
	}

	public void setIdnumber(String idnumber) {
		this.idnumber = idnumber;
	}

	public String getEducation() {
		return this.education;
	}

	public void setEducation(String education) {
		this.education = education;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getPicpath() {
		return this.picpath;
	}

	public void setPicpath(String picpath) {
		this.picpath = picpath;
	}

}