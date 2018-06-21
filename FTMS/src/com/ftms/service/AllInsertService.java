package com.ftms.service;

import com.ftms.entity.Achievement;
import com.ftms.entity.Certificate;
import com.ftms.entity.Exam;
import com.ftms.entity.Results;
import com.ftms.entity.Shenyan;
import com.ftms.entity.User;

public interface AllInsertService {
	public boolean userExist(String username);
	public void register(User u);
	public void updateExam(String username,Exam exam);
	public void SaveResult(String username, Results r);
	public void addCertificate(String username,Certificate c);
	public void addAchievement(String username,Achievement a);
	public void check(String username,Shenyan c);
}
