package com.ftms.service;

import com.ftms.entity.Prof2;

import net.sf.json.JSONArray;

public interface ProfService {
	public JSONArray getProf1();

	public JSONArray getProf2(int c1id);
	public Prof2 getUserProf2(int profid);
}
