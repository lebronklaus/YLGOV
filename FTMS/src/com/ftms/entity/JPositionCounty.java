package com.ftms.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * JPositionCounty entity. @author MyEclipse Persistence Tools
 */

public class JPositionCounty implements java.io.Serializable {

	// Fields

	private Integer id;
	private Long cityId;
	private Long countyId;
	private String countyName;
	private Set users = new HashSet(0);
	private Set exams = new HashSet(0);

	// Constructors

	/** default constructor */
	public JPositionCounty() {
	}

	/** minimal constructor */
	public JPositionCounty(Long cityId, Long countyId, String countyName) {
		this.cityId = cityId;
		this.countyId = countyId;
		this.countyName = countyName;
	}

	/** full constructor */
	public JPositionCounty(Long cityId, Long countyId, String countyName,
			Set users, Set exams) {
		this.cityId = cityId;
		this.countyId = countyId;
		this.countyName = countyName;
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

	public Long getCityId() {
		return this.cityId;
	}

	public void setCityId(Long cityId) {
		this.cityId = cityId;
	}

	public Long getCountyId() {
		return this.countyId;
	}

	public void setCountyId(Long countyId) {
		this.countyId = countyId;
	}

	public String getCountyName() {
		return this.countyName;
	}

	public void setCountyName(String countyName) {
		this.countyName = countyName;
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