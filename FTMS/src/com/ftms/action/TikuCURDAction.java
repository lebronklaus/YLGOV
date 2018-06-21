package com.ftms.action;

import net.sf.json.JSONArray;

import com.ftms.entity.Tiku;
import com.ftms.service.TikuService;
import com.opensymphony.xwork2.ActionSupport;

public class TikuCURDAction extends ActionSupport {
	private TikuService tikuService;
	private JSONArray searchResultJson;
	private Tiku tiku;
	private String profession;
	private String questionType;
	private String difficulty;
	private String question;
	private int id;
	public TikuService getTikuService() {
		return tikuService;
	}
	public void setTikuService(TikuService tikuService) {
		this.tikuService = tikuService;
	}
	public String getProfession() {
		return profession;
	}
	public void setProfession(String profession) {
		this.profession = profession;
	}
	public String getQuestionType() {
		return questionType;
	}
	public void setQuestionType(String questionType) {
		this.questionType = questionType;
	}
	public String getDifficulty() {
		return difficulty;
	}
	public void setDifficulty(String difficulty) {
		this.difficulty = difficulty;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	
	public Tiku getTiku() {
		return tiku;
	}
	public void setTiku(Tiku tiku) {
		this.tiku = tiku;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public JSONArray getSearchResultJson() {
		return searchResultJson;
	}
	public void setSearchResultJson(JSONArray searchResultJson) {
		this.searchResultJson = searchResultJson;
	}
	public String searchQuestion(){
		System.out.println(profession+questionType+difficulty+question);
		this.searchResultJson=tikuService.findQuestion(profession, questionType, difficulty, question);
		return "search";
	}
	public String deleteQuestion(){
		tikuService.deleteQuestion(id);
		return "delete";
	}
	public String addQuestion(){
		tikuService.addQuestion(tiku);
		return "add";
	}
	public String editQuestion(){
		this.tiku.setId(id);
		tikuService.editQuestion(tiku);
		return "edit";
	}
}
