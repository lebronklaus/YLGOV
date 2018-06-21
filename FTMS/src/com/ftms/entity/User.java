package com.ftms.entity;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

/**
 * User entity. @author MyEclipse Persistence Tools
 */

public class User implements java.io.Serializable {

	// Fields

	private Integer id;
	private Prof2 prof2;
	private JPositionCounty JPositionCounty;
	private JPositionCity JPositionCity;
	private JPositionProvice JPositionProvice;
	private JPositionTown JPositionTown;
	private String username;
	private String password;
	private String name;
	private Timestamp birthday;
	private String gender;
	private String idnumber;
	private String education;
	private String phone;
	private String picpath;
	private Set certificates = new HashSet(0);
	private Set achievements = new HashSet(0);
	private Set shenyans = new HashSet(0);
	private Set resultses = new HashSet(0);

	// Constructors

	/** default constructor */
	public User() {
	}

	/** minimal constructor */
	public User(Timestamp birthday) {
		this.birthday = birthday;
	}

	/** full constructor */
	public User(Prof2 prof2, JPositionCounty JPositionCounty,
			JPositionCity JPositionCity, JPositionProvice JPositionProvice,
			JPositionTown JPositionTown, String username, String password,
			String name, Timestamp birthday, String gender, String idnumber,
			String education, String phone, String picpath, Set certificates,
			Set achievements, Set shenyans, Set resultses) {
		this.prof2 = prof2;
		this.JPositionCounty = JPositionCounty;
		this.JPositionCity = JPositionCity;
		this.JPositionProvice = JPositionProvice;
		this.JPositionTown = JPositionTown;
		this.username = username;
		this.password = password;
		this.name = name;
		this.birthday = birthday;
		this.gender = gender;
		this.idnumber = idnumber;
		this.education = education;
		this.phone = phone;
		this.picpath = picpath;
		this.certificates = certificates;
		this.achievements = achievements;
		this.shenyans = shenyans;
		this.resultses = resultses;
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

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Timestamp getBirthday() {
		return this.birthday;
	}

	public void setBirthday(Timestamp birthday) {
		this.birthday = birthday;
	}

	public String getGender() {
		return this.gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
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

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPicpath() {
		return this.picpath;
	}

	public void setPicpath(String picpath) {
		this.picpath = picpath;
	}

	public Set getCertificates() {
		return this.certificates;
	}

	public void setCertificates(Set certificates) {
		this.certificates = certificates;
	}

	public Set getAchievements() {
		return this.achievements;
	}

	public void setAchievements(Set achievements) {
		this.achievements = achievements;
	}

	public Set getShenyans() {
		return this.shenyans;
	}

	public void setShenyans(Set shenyans) {
		this.shenyans = shenyans;
	}

	public Set getResultses() {
		return this.resultses;
	}

	public void setResultses(Set resultses) {
		this.resultses = resultses;
	}

}