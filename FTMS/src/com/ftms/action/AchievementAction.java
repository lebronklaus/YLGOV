package com.ftms.action;

import net.sf.json.JSONArray;
import net.sf.json.JsonConfig;

import com.ftms.entity.Achievement;
import com.ftms.service.AchievementService;
import com.opensymphony.xwork2.ActionSupport;

public class AchievementAction extends ActionSupport {
	private AchievementService achievementService;
	private Achievement achievement;
	private int id;
	private String username;
	private JSONArray achievementJson;
	public JSONArray getAchievementJson() {
		return achievementJson;
	}
	public void setAchievementJson(JSONArray achievementJson) {
		this.achievementJson = achievementJson;
	}
	public AchievementService getAchievementService() {
		return achievementService;
	}
	public void setAchievementService(AchievementService achievementService) {
		this.achievementService = achievementService;
	}
	public Achievement getAchievement() {
		return achievement;
	}
	public void setAchievement(Achievement achievement) {
		this.achievement = achievement;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String saveAchievement(){
		
		achievementService.addAchievement(username, achievement);
		return "Achievement";
	}
	public String modifyAchievement(){
		achievementService.modifyAchievement(username, achievement);
		return "Achievement";
	}
	public String deleteAchievement(){
		achievementService.deleteAchievement(id);
		return "Achievement";
	}
	public String achievement(){
		JsonConfig jsonConfig = new JsonConfig();
		jsonConfig.setExcludes( new String[]{ "user"} );
		this.achievementJson = JSONArray.fromObject( achievementService.getCertificate(username),jsonConfig);
		return "achievement";
	}
}
