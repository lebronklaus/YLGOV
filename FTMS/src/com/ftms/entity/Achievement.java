package com.ftms.entity;

/**
 * Achievement entity. @author MyEclipse Persistence Tools
 */

public class Achievement implements java.io.Serializable {

	// Fields

	private Integer id;
	private User user;
	private String start;
	private String end;
	private String completion;
	private String winess;

	// Constructors

	/** default constructor */
	public Achievement() {
	}

	/** full constructor */
	public Achievement(User user, String start, String end, String completion,
			String winess) {
		this.user = user;
		this.start = start;
		this.end = end;
		this.completion = completion;
		this.winess = winess;
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

	public String getStart() {
		return this.start;
	}

	public void setStart(String start) {
		this.start = start;
	}

	public String getEnd() {
		return this.end;
	}

	public void setEnd(String end) {
		this.end = end;
	}

	public String getCompletion() {
		return this.completion;
	}

	public void setCompletion(String completion) {
		this.completion = completion;
	}

	public String getWiness() {
		return this.winess;
	}

	public void setWiness(String winess) {
		this.winess = winess;
	}

}