package com.ftms.entity;

/**
 * Superadmin entity. @author MyEclipse Persistence Tools
 */

public class Superadmin implements java.io.Serializable {

	// Fields

	private Integer id;
	private String supername;
	private String superpassword;

	// Constructors

	/** default constructor */
	public Superadmin() {
	}

	/** full constructor */
	public Superadmin(String supername, String superpassword) {
		this.supername = supername;
		this.superpassword = superpassword;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getSupername() {
		return this.supername;
	}

	public void setSupername(String supername) {
		this.supername = supername;
	}

	public String getSuperpassword() {
		return this.superpassword;
	}

	public void setSuperpassword(String superpassword) {
		this.superpassword = superpassword;
	}

}