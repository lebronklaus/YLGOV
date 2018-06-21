package com.ftms.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * Prof1 entity. @author MyEclipse Persistence Tools
 */

public class Prof1 implements java.io.Serializable {

	// Fields

	private Integer id;
	private String name;
	private Set prof2sForClass1name = new HashSet(0);
	private Set prof2sForC1id = new HashSet(0);

	// Constructors

	/** default constructor */
	public Prof1() {
	}

	/** minimal constructor */
	public Prof1(Integer id) {
		this.id = id;
	}

	/** full constructor */
	public Prof1(Integer id, String name, Set prof2sForClass1name,
			Set prof2sForC1id) {
		this.id = id;
		this.name = name;
		this.prof2sForClass1name = prof2sForClass1name;
		this.prof2sForC1id = prof2sForC1id;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set getProf2sForClass1name() {
		return this.prof2sForClass1name;
	}

	public void setProf2sForClass1name(Set prof2sForClass1name) {
		this.prof2sForClass1name = prof2sForClass1name;
	}

	public Set getProf2sForC1id() {
		return this.prof2sForC1id;
	}

	public void setProf2sForC1id(Set prof2sForC1id) {
		this.prof2sForC1id = prof2sForC1id;
	}

}