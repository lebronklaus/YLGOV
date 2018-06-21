package com.ftms.service;

import java.util.List;

import com.ftms.entity.Achievement;

public interface AchievementService {
	public List<Achievement> getCertificate(String username);
	public void addAchievement(String username,Achievement a);
	public void modifyAchievement(String username,Achievement a);
	public void deleteAchievement(int id);
}
