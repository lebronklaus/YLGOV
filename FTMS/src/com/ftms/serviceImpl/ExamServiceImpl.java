package com.ftms.serviceImpl;

import java.util.ArrayList;
import java.util.Iterator;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import com.ftms.dao.ExamDAO;
import com.ftms.dao.UserDAO;
import com.ftms.entity.Exam;
import com.ftms.entity.User;
import com.ftms.service.ExamService;

public class ExamServiceImpl implements ExamService {
	private ExamDAO examDAO;
	private UserDAO userDAO;
	public ExamDAO getExamDAO() {
		return examDAO;
	}

	public void setExamDAO(ExamDAO examDAO) {
		this.examDAO = examDAO;
	}

	public UserDAO getUserDAO() {
		return userDAO;
	}

	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}


	@Override
	public void uploadExam(String username, Exam exam) {
		// TODO Auto-generated method stub
		User u = (User) userDAO.findByUsername(username).get(0);
		System.out.println(u.getName());
		exam.setName(u.getName());
		exam.setGender(u.getGender());
		exam.setBirthday(u.getBirthday());
		exam.setPhone(u.getPhone());
		exam.setIdnumber(u.getIdnumber());
		exam.setJPositionProvice(u.getJPositionProvice());
		exam.setJPositionCity(u.getJPositionCity());
		exam.setJPositionCounty(u.getJPositionCounty());
		exam.setJPositionTown(u.getJPositionTown());
		exam.setEducation(u.getEducation());
		exam.setProf2(u.getProf2());
		exam.setPicpath(u.getPicpath());
		exam.setStatus("否");
		examDAO.save(exam);

	}

	@Override
	public void examCheck(int id, String status) {
		// TODO Auto-generated method stub
		System.out.println(id);
		Exam e=examDAO.findById(id);
		e.setStatus(status);
		examDAO.merge(e);
	}

	@Override
	public JSONArray searchExam(String name, int time, String level,
			String address, String status) {
		// TODO Auto-generated method stub
//		JsonConfig jsonConfig= new JsonConfig();
//		jsonConfig.setExcludes(new String[]{"users","exams","prof2sForClass1name","prof2sForC1id"});
//		return JSONArray.fromObject(examDAO.searchExam(name, time, level, address, status),jsonConfig);
		ArrayList<Exam> re = (ArrayList<Exam>) examDAO.searchExam(name, time, level, address, status);
		JSONArray json = new JSONArray();
		JSONObject jo = null;
		Iterator iter = re.iterator();
		while (iter.hasNext()) {
			Object[] data = (Object[]) iter.next();
			jo = new JSONObject();
			jo.put("name", data[0]);
			jo.put("level", data[1]);
			jo.put("time", data[2]);
			jo.put("address", data[3]);
			jo.put("status", data[4]);
			jo.put("picpath", data[5]);
			jo.put("gender", data[6]);
			jo.put("birthday", data[7]);
			jo.put("idnumber", data[8]);
			jo.put("phone", data[9]);
			jo.put("proviceName", data[10]);
			jo.put("cityName", data[11]);
			jo.put("countyName", data[12]);
			jo.put("townName", data[13]);
			jo.put("education", data[14]);
			jo.put("prof1name", data[15]);
			jo.put("prof2name", data[16]);
			jo.put("id", data[17]);
			json.add(jo);
		}
		return json;
	}

	@Override
	public boolean examExist(String username, String level) {
		// TODO Auto-generated method stub
		User u=(User) userDAO.findByUsername(username).get(0);
		String name=u.getName();
		if(examDAO.examExist(name, level)>0){
			return true;
		}
		return false;
	}

	@Override
	public void updateExam(String username, Exam exam) {
		// TODO Auto-generated method stub
		User u = (User) userDAO.findByUsername(username).get(0);
		String name=u.getName();
		String level=exam.getLevel();
		Exam e=examDAO.updateExam(name, 0, level, "无", "无").get(0);
		e.setAddress(exam.getAddress());
		e.setTime(exam.getTime());
		e.setName(u.getName());
		e.setGender(u.getGender());
		e.setBirthday(u.getBirthday());
		e.setPhone(u.getPhone());
		e.setIdnumber(u.getIdnumber());
		e.setJPositionProvice(u.getJPositionProvice());
		e.setJPositionCity(u.getJPositionCity());
		e.setJPositionCounty(u.getJPositionCounty());
		e.setJPositionTown(u.getJPositionTown());
		e.setEducation(u.getEducation());
		e.setPicpath(u.getPicpath());
		e.setProf2(u.getProf2());
		examDAO.merge(e);
	}

	@Override
	public boolean examJudge(String username, String level) {
		// TODO Auto-generated method stub
		User u=(User) userDAO.findByUsername(username).get(0);
		String name=u.getName();
		if(examDAO.examExist(name, level)==0){
			return false;
		}
		Exam exam=examDAO.examJudge(name, level).get(0);
		if("是".equals(exam.getStatus())){
			return true;
		}
		return false;
	}
}
