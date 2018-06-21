package com.ftms.entity;

/**
 * Certificate entity. @author MyEclipse Persistence Tools
 */

public class Certificate implements java.io.Serializable {

	// Fields

	private Integer id;
	private User user;
	private String time;
	private String major;
	private String certificatename;

	// Constructors

	/** default constructor */
	public Certificate() {
	}

	/** full constructor */
	public Certificate(User user, String time, String major,
			String certificatename) {
		this.user = user;
		this.time = time;
		this.major = major;
		this.certificatename = certificatename;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getTime() {
		return this.time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getMajor() {
		return this.major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public String getCertificatename() {
		return this.certificatename;
	}

	public void setCertificatename(String certificatename) {
		this.certificatename = certificatename;
	}

}