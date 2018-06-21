package com.ftms.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * JPositionProvice entity. @author MyEclipse Persistence Tools
 */

public class JPositionProvice implements java.io.Serializable {

	// Fields

	private Integer id;
	private Integer proviceId;
	private String proviceName;
	private Set users = new HashSet(0);
	private Set exams = new HashSet(0);

	// Constructors

	/** default constructor */
	public JPositionProvice() {
	}

	/** minimal constructor */
	public JPositionProvice(Integer proviceId, String proviceName) {
		this.proviceId = proviceId;
		this.proviceName = proviceName;
	}

	/** full constructor */
	public JPositionProvice(Integer proviceId, String proviceName, Set users,
			Set exams) {
		this.proviceId = proviceId;
		this.proviceName = proviceName;
		this.users = users;
		this.exams = exams;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getProviceId() {
		return this.proviceId;
	}

	public void setProviceId(Integer proviceId) {
		this.proviceId = proviceId;
	}

	public String getProviceName() {
		return this.proviceName;
	}

	public void setProviceName(String proviceName) {
		this.proviceName = proviceName;
	}

	public Set getUsers() {
		return this.users;
	}

	public void setUsers(Set users) {
		this.users = users;
	}

	public Set getExams() {
		return this.exams;
	}

	public void setExams(Set exams) {
		this.exams = exams;
	}

}