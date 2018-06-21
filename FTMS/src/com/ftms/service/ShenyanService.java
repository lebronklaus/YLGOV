package com.ftms.service;

import net.sf.json.JSONArray;

import com.ftms.entity.Shenyan;

public interface ShenyanService {
	public void check(int id, String username);
	public JSONArray searchCheck(String name, String level);
	public JSONArray findUser(String name, String level);
	public void addCheck(Shenyan c);
	public JSONArray findAll();
	public String judge(String username, String level);
}
