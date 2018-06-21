package com.ftms.entity;

/**
 * Shenyan entity. @author MyEclipse Persistence Tools
 */

public class Shenyan implements java.io.Serializable {

	// Fields

	private Integer id;
	private User user;
	private Integer year;
	private String level;
	private String status;

	// Constructors

	/** default constructor */
	public Shenyan() {
	}

	/** minimal constructor */
	public Shenyan(Integer id) {
		this.id = id;
	}

	/** full constructor */
	public Shenyan(Integer id, User user, Integer year, String level,
			String status) {
		this.id = id;
		this.user = user;
		this.year = year;
		this.level = level;
		this.status = status;
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

	public Integer getYear() {
		return this.year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public String getLevel() {
		return this.level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}