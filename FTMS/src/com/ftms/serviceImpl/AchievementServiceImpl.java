package com.ftms.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import com.ftms.dao.AchievementDAO;
import com.ftms.dao.UserDAO;
import com.ftms.entity.Achievement;
import com.ftms.entity.User;
import com.ftms.service.AchievementService;

public class AchievementServiceImpl implements AchievementService {
	private AchievementDAO achievementDAO;
	private UserDAO userDAO;
	
	
	public AchievementDAO getAchievementDAO() {
		return achievementDAO;
	}

	public void setAchievementDAO(AchievementDAO achievementDAO) {
		this.achievementDAO = achievementDAO;
	}

	public UserDAO getUserDAO() {
		return userDAO;
	}

	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

	@Override
	public List<Achievement> getCertificate(String username) {
		// TODO Auto-generated method stub
		return new ArrayList<Achievement>(((User) userDAO.findByUsername(
				username).get(0)).getAchievements());
	}

	@Override
	public void addAchievement(String username, Achievement a) {
		// TODO Auto-generated method stub
		a.setUser((User) userDAO.findByUsername(username).get(0));
		achievementDAO.save(a);
//		User u=(User) userDAO.findByUsername(username).get(0);
//		Set<Achievement> set=u.getAchievements();
//		set.add(a);
//		u.setAchievements(set);
//		a.setUser(u);
//		userDAO.merge(u);
	}

	@Override
	public void modifyAchievement(String username, Achievement a) {
		// TODO Auto-generated method stub
		a.setUser((User) userDAO.findByUsername(username).get(0));
		achievementDAO.merge(a);
	}

	@Override
	public void deleteAchievement(int id) {
		// TODO Auto-generated method stub
		achievementDAO.delete(achievementDAO.findById(id));
	}

}
