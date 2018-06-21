package com.ftms.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * Prof2 entity. @author MyEclipse Persistence Tools
 */

public class Prof2 implements java.io.Serializable {

	// Fields

	private Integer id;
	private Prof1 prof1;
	private String name;
	private Set users = new HashSet(0);
	private Set exams = new HashSet(0);

	// Constructors

	/** default constructor */
	public Prof2() {
	}

	/** full constructor */
	public Prof2(Prof1 prof1, String name, Set users, Set exams) {
		this.prof1 = prof1;
		this.name = name;
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

	public Prof1 getProf1() {
		return this.prof1;
	}

	public void setProf1(Prof1 prof1) {
		this.prof1 = prof1;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
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