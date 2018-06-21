package com.ftms.entity;

import java.sql.Timestamp;

/**
 * Results entity. @author MyEclipse Persistence Tools
 */

public class Results implements java.io.Serializable {

	// Fields

	private Integer id;
	private User user;
	private String achievement;
	private Integer total;
	private Integer canjia;
	private Integer approval;
	private Integer opposition;
	private Timestamp checktime;
	private String level;
	private String number;
	private Timestamp fazhengtime;
	private Float writescore;
	private Float interviewscore;
	private Float totalscore;

	// Constructors

	/** default constructor */
	public Results() {
	}

	/** minimal constructor */
	public Results(Timestamp checktime, Timestamp fazhengtime) {
		this.checktime = checktime;
		this.fazhengtime = fazhengtime;
	}

	/** full constructor */
	public Results(User user, String achievement, Integer total,
			Integer canjia, Integer approval, Integer opposition,
			Timestamp checktime, String level, String number,
			Timestamp fazhengtime, Float writescore, Float interviewscore,
			Float totalscore) {
		this.user = user;
		this.achievement = achievement;
		this.total = total;
		this.canjia = canjia;
		this.approval = approval;
		this.opposition = opposition;
		this.checktime = checktime;
		this.level = level;
		this.number = number;
		this.fazhengtime = fazhengtime;
		this.writescore = writescore;
		this.interviewscore = interviewscore;
		this.totalscore = totalscore;
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

	public String getAchievement() {
		return this.achievement;
	}

	public void setAchievement(String achievement) {
		this.achievement = achievement;
	}

	public Integer getTotal() {
		return this.total;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}

	public Integer getCanjia() {
		return this.canjia;
	}

	public void setCanjia(Integer canjia) {
		this.canjia = canjia;
	}

	public Integer getApproval() {
		return this.approval;
	}

	public void setApproval(Integer approval) {
		this.approval = approval;
	}

	public Integer getOpposition() {
		return this.opposition;
	}

	public void setOpposition(Integer opposition) {
		this.opposition = opposition;
	}

	public Timestamp getChecktime() {
		return this.checktime;
	}

	public void setChecktime(Timestamp checktime) {
		this.checktime = checktime;
	}

	public String getLevel() {
		return this.level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public String getNumber() {
		return this.number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public Timestamp getFazhengtime() {
		return this.fazhengtime;
	}

	public void setFazhengtime(Timestamp fazhengtime) {
		this.fazhengtime = fazhengtime;
	}

	public Float getWritescore() {
		return this.writescore;
	}

	public void setWritescore(Float writescore) {
		this.writescore = writescore;
	}

	public Float getInterviewscore() {
		return this.interviewscore;
	}

	public void setInterviewscore(Float interviewscore) {
		this.interviewscore = interviewscore;
	}

	public Float getTotalscore() {
		return this.totalscore;
	}

	public void setTotalscore(Float totalscore) {
		this.totalscore = totalscore;
	}

}