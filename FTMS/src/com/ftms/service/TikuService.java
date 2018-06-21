package com.ftms.service;
import net.sf.json.JSONArray;

import com.ftms.entity.Tiku;
public interface TikuService {
	JSONArray findQuestion(String profession,String questionType,String difficulty,String question);
	void deleteQuestion(int questionid);
	void editQuestion(Tiku tiku);
	void addQuestion(Tiku tiku);
}