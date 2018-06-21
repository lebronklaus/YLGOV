package com.ftms.serviceImpl;

import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.ftms.dao.Prof1DAO;
import com.ftms.dao.Prof2DAO;
import com.ftms.entity.Prof1;
import com.ftms.entity.Prof2;
import com.ftms.service.ProfService;

public class ProfServicImpl implements ProfService {
	private Prof1DAO prof1DAO;
	private Prof2DAO prof2DAO;
	
	
	public Prof1DAO getProf1DAO() {
		return prof1DAO;
	}

	public void setProf1DAO(Prof1DAO prof1dao) {
		prof1DAO = prof1dao;
	}

	public Prof2DAO getProf2DAO() {
		return prof2DAO;
	}

	public void setProf2DAO(Prof2DAO prof2dao) {
		prof2DAO = prof2dao;
	}

	@Override
	public JSONArray getProf1() {
		// TODO Auto-generated method stub
		List<Prof1> prof1 = prof1DAO.findAll();
		JSONArray json = new JSONArray();
		JSONObject jo = null;
		for (Prof1 p : prof1) {
			jo = new JSONObject();
			jo.put("value", p.getId());
			jo.put("text", p.getName());
			json.add(jo);
		}
		return json;
	}

	@Override
	public JSONArray getProf2(int c1id) {
		// TODO Auto-generated method stub
		List<Prof2> prof2 = prof2DAO.getProf2(c1id);
		JSONArray json = new JSONArray();
		JSONObject jo = null;
		for (Prof2 p : prof2) {
			jo = new JSONObject();
			jo.put("value", p.getId());
			jo.put("text", p.getName());
			json.add(jo);
		}
		return json;
	}

	@Override
	public Prof2 getUserProf2(int profid) {
		// TODO Auto-generated method stub
		return prof2DAO.findById(profid);
	}

}
