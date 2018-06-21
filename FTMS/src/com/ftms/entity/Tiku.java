package com.ftms.entity;

/**
 * Tiku entity. @author MyEclipse Persistence Tools
 */

public class Tiku implements java.io.Serializable {

	// Fields

	private Integer id;
	private String profession;
	private String questionType;
	private String difficulty;
	private String question;
	private String selectionA;
	private String selectionB;
	private String selectionC;
	private String selectionD;
	private String answer;

	// Constructors

	/** default constructor */
	public Tiku() {
	}

	/** full constructor */
	public Tiku(String profession, String questionType, String difficulty,
			String question, String selectionA, String selectionB,
			String selectionC, String selectionD, String answer) {
		this.profession = profession;
		this.questionType = questionType;
		this.difficulty = difficulty;
		this.question = question;
		this.selectionA = selectionA;
		this.selectionB = selectionB;
		this.selectionC = selectionC;
		this.selectionD = selectionD;
		this.answer = answer;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getProfession() {
		return this.profession;
	}

	public void setProfession(String profession) {
		this.profession = profession;
	}

	public String getQuestionType() {
		return this.questionType;
	}

	public void setQuestionType(String questionType) {
		this.questionType = questionType;
	}

	public String getDifficulty() {
		return this.difficulty;
	}

	public void setDifficulty(String difficulty) {
		this.difficulty = difficulty;
	}

	public String getQuestion() {
		return this.question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getSelectionA() {
		return this.selectionA;
	}

	public void setSelectionA(String selectionA) {
		this.selectionA = selectionA;
	}

	public String getSelectionB() {
		return this.selectionB;
	}

	public void setSelectionB(String selectionB) {
		this.selectionB = selectionB;
	}

	public String getSelectionC() {
		return this.selectionC;
	}

	public void setSelectionC(String selectionC) {
		this.selectionC = selectionC;
	}

	public String getSelectionD() {
		return this.selectionD;
	}

	public void setSelectionD(String selectionD) {
		this.selectionD = selectionD;
	}

	public String getAnswer() {
		return this.answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

}