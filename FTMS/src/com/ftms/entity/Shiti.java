package com.ftms.entity;

/**
 * Shiti entity. @author MyEclipse Persistence Tools
 */

public class Shiti implements java.io.Serializable {

	// Fields

	private String sjid;
	private String sjbh;
	private Integer questionrank;
	private Integer shitiid;
	private String questionType;
	private String question;
	private String answer;
	private String answercontent;
	private String useranswer;
	private String useranswercontent;

	// Constructors

	/** default constructor */
	public Shiti() {
	}

	/** full constructor */
	public Shiti(String sjbh, Integer questionrank, Integer shitiid,
			String questionType, String question, String answer,
			String answercontent, String useranswer, String useranswercontent) {
		this.sjbh = sjbh;
		this.questionrank = questionrank;
		this.shitiid = shitiid;
		this.questionType = questionType;
		this.question = question;
		this.answer = answer;
		this.answercontent = answercontent;
		this.useranswer = useranswer;
		this.useranswercontent = useranswercontent;
	}

	// Property accessors

	public String getSjid() {
		return this.sjid;
	}

	public void setSjid(String sjid) {
		this.sjid = sjid;
	}

	public String getSjbh() {
		return this.sjbh;
	}

	public void setSjbh(String sjbh) {
		this.sjbh = sjbh;
	}

	public Integer getQuestionrank() {
		return this.questionrank;
	}

	public void setQuestionrank(Integer questionrank) {
		this.questionrank = questionrank;
	}

	public Integer getShitiid() {
		return this.shitiid;
	}

	public void setShitiid(Integer shitiid) {
		this.shitiid = shitiid;
	}

	public String getQuestionType() {
		return this.questionType;
	}

	public void setQuestionType(String questionType) {
		this.questionType = questionType;
	}

	public String getQuestion() {
		return this.question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getAnswer() {
		return this.answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public String getAnswercontent() {
		return this.answercontent;
	}

	public void setAnswercontent(String answercontent) {
		this.answercontent = answercontent;
	}

	public String getUseranswer() {
		return this.useranswer;
	}

	public void setUseranswer(String useranswer) {
		this.useranswer = useranswer;
	}

	public String getUseranswercontent() {
		return this.useranswercontent;
	}

	public void setUseranswercontent(String useranswercontent) {
		this.useranswercontent = useranswercontent;
	}

}