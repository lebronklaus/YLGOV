package com.ftms.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * JPositionCity entity. @author MyEclipse Persistence Tools
 */

public class JPositionCity implements java.io.Serializable {

	// Fields

	private Integer id;
	private Integer provinceId;
	private Long cityId;
	private String cityName;
	private Set exams = new HashSet(0);
	private Set users = new HashSet(0);

	// Constructors

	/** default constructor */
	public JPositionCity() {
	}

	/** minimal constructor */
	public JPositionCity(Integer provinceId, Long cityId, String cityName) {
		this.provinceId = provinceId;
		this.cityId = cityId;
		this.cityName = cityName;
	}

	/** full constructor */
	public JPositionCity(Integer provinceId, Long cityId, String cityName,
			Set exams, Set users) {
		this.provinceId = provinceId;
		this.cityId = cityId;
		this.cityName = cityName;
		this.exams = exams;
		this.users = users;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getProvinceId() {
		return this.provinceId;
	}

	public void setProvinceId(Integer provinceId) {
		this.provinceId = provinceId;
	}

	public Long getCityId() {
		return this.cityId;
	}

	public void setCityId(Long cityId) {
		this.cityId = cityId;
	}

	public String getCityName() {
		return this.cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public Set getExams() {
		return this.exams;
	}

	public void setExams(Set exams) {
		this.exams = exams;
	}

	public Set getUsers() {
		return this.users;
	}

	public void setUsers(Set users) {
		this.users = users;
	}

}