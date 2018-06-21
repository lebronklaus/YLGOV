package com.ftms.service;


import java.util.List;

import net.sf.json.JSONArray;

import com.ftms.entity.Results;

public interface ResultsService {
	public void SaveResult(String username, Results r);

	public JSONArray searchByAll(String province, String prof1,String prof2,
			String gender, String age, String education, String level,String fazheng);

	public JSONArray searchByProvince(String city, String prof1,String prof2,
			String gender, String age, String education, String level,String fazheng);
	
	public JSONArray searchByCity(String county, String prof1,String prof2,
			String gender, String age, String education, String level,String fazheng);
	public JSONArray searchByCounty(String town, String prof1,String prof2,
			String gender, String age, String education, String level,String fazheng);
	public JSONArray getAll();
	public JSONArray getUserResult(String username,String level);
	public String getzhenshu(String username,String level);
	public List export(int info,String local, String prof1,String prof2,
			String gender, String age, String education, String level,String fazheng);
}