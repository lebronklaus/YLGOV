package com.ftms.service;

import net.sf.json.JSONArray;

import com.ftms.entity.Exam;
public interface ExamService {
	public void uploadExam(String username,Exam exam);
	public JSONArray searchExam(String name,int time,String level,String address,String status);
	public void examCheck(int id,String status);
	public boolean examExist(String username,String level);
	public void updateExam(String username,Exam exam);
	public boolean examJudge(String username,String level);
}
