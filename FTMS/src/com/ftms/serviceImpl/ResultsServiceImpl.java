package com.ftms.serviceImpl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import com.ftms.dao.ResultsDAO;
import com.ftms.dao.ShenyanDAO;
import com.ftms.dao.UserDAO;
import com.ftms.entity.Results;
import com.ftms.entity.Shenyan;
import com.ftms.entity.User;
import com.ftms.service.ResultsService;

public class ResultsServiceImpl implements ResultsService {
	private ResultsDAO resultsDAO;
	private UserDAO userDAO;
	private ShenyanDAO checkDAO;

	public ResultsDAO getResultsDAO() {
		return resultsDAO;
	}

	public void setResultsDAO(ResultsDAO resultsDAO) {
		this.resultsDAO = resultsDAO;
	}

	public UserDAO getUserDAO() {
		return userDAO;
	}

	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

	public ShenyanDAO getCheckDAO() {
		return checkDAO;
	}

	public void setCheckDAO(ShenyanDAO checkDAO) {
		this.checkDAO = checkDAO;
	}

	@Override
	public void SaveResult(String username, Results r) {
		// TODO Auto-generated method stub

		r.setUser((User) userDAO.findByUsername(username).get(0));
		resultsDAO.save(r);
		Calendar now = Calendar.getInstance();
		int year = now.get(Calendar.YEAR);
		Shenyan c = new Shenyan();
		c.setUser((User) userDAO.findByUsername(username).get(0));
		c.setLevel(r.getLevel());
		c.setStatus("否");
		c.setYear(year);
		checkDAO.save(c);
	}

	@Override
	public JSONArray searchByAll(String province, String prof1, String prof2,
			String gender, String age, String education, String level,
			String fazheng) {
		// TODO Auto-generated method stub
		List re = resultsDAO.searchByAll(province, prof1, prof2, gender, age,
				education, level, fazheng);

		JSONArray json = new JSONArray();
		JSONObject jo = null;
		Iterator iter = re.iterator();
		while (iter.hasNext()) {
			Object[] data = (Object[]) iter.next();
			jo = new JSONObject();
			jo.put("username", data[0]);
			jo.put("name", data[1]);
			jo.put("gender", data[2]);
			jo.put("birthday", data[3]);
			jo.put("password", data[4]);
			jo.put("phone", data[5]);
			jo.put("education", data[6]);
			jo.put("idnumber", data[7]);
			jo.put("prof1name", data[8]);
			jo.put("prof2name", data[9]);
			jo.put("proviceName", data[10]);
			jo.put("cityName", data[11]);
			jo.put("countyName", data[12]);
			jo.put("townName", data[13]);
			jo.put("fazhengtime", data[14]);
			jo.put("level", data[15]);
			jo.put("writescore", data[16]);
			jo.put("interviewscore", data[17]);
			jo.put("totalscore", data[18]);
			jo.put("number", data[19]);
			json.add(jo);
		}
		return json;
	}

	@Override
	public JSONArray searchByProvince(String city, String prof1, String prof2,
			String gender, String age, String education, String level,
			String fazheng) {
		// TODO Auto-generated method stub
//		return resultsDAO.searchByProvince(city, prof1, prof2, gender, age,
//				education, level, fazheng);
		List re = resultsDAO.searchByProvince(city, prof1, prof2, gender, age,
				education, level, fazheng);

		JSONArray json = new JSONArray();
		JSONObject jo = null;
		Iterator iter = re.iterator();
		while (iter.hasNext()) {
			Object[] data = (Object[]) iter.next();
			jo = new JSONObject();
			jo.put("username", data[0]);
			jo.put("name", data[1]);
			jo.put("gender", data[2]);
			jo.put("birthday", data[3]);
			jo.put("password", data[4]);
			jo.put("phone", data[5]);
			jo.put("education", data[6]);
			jo.put("idnumber", data[7]);
			jo.put("prof1name", data[8]);
			jo.put("prof2name", data[9]);
			jo.put("proviceName", data[10]);
			jo.put("cityName", data[11]);
			jo.put("countyName", data[12]);
			jo.put("townName", data[13]);
			jo.put("fazhengtime", data[14]);
			jo.put("level", data[15]);
			jo.put("writescore", data[16]);
			jo.put("interviewscore", data[17]);
			jo.put("totalscore", data[18]);
			jo.put("number", data[19]);
			json.add(jo);
		}
		return json;
	}

	@Override
	public JSONArray getAll() {
		// TODO Auto-generated method stub,
		// "exams","checks","certificates","resultses","achievements","prof2sForClass1name"
		// JsonConfig jsonConfig= new JsonConfig();
		// jsonConfig.setExcludes(new
		// String[]{"users","exams","shenyans","certificates","resultses","achievements","prof2sForClass1name","prof2sForC1id"});
		// ArrayList<User> u=(ArrayList<User>) userDAO.findAll();
		// Set re= new HashSet<Results>();
		// for(int i=0;i<u.size();i++){
		// re=u.get(i).getResultses();
		// if(re.isEmpty()){
		// u.remove(i);
		// }
		// }
		// return JSONArray.fromObject(re,jsonConfig);

		List re = resultsDAO.findAllresults();

		JSONArray json = new JSONArray();
		JSONObject jo = null;
		Iterator iter = re.iterator();
		while (iter.hasNext()) {
			Object[] data = (Object[]) iter.next();
			jo = new JSONObject();
			jo.put("name", data[0]);
			jo.put("level", data[1]);
			jo.put("totalscore", data[2]);
			jo.put("number", data[3]);
			json.add(jo);
		}
		return json;
	}

	@Override
	public JSONArray searchByCity(String county, String prof1, String prof2,
			String gender, String age, String education, String level,
			String fazheng) {
		// TODO Auto-generated method stub
//		return resultsDAO.searchByCity(county, prof1, prof2, gender, age,
//				education, level, fazheng);
		List re = resultsDAO.searchByCity(county, prof1, prof2, gender, age,
				education, level, fazheng);

		JSONArray json = new JSONArray();
		JSONObject jo = null;
		Iterator iter = re.iterator();
		while (iter.hasNext()) {
			Object[] data = (Object[]) iter.next();
			jo = new JSONObject();
			jo.put("username", data[0]);
			jo.put("name", data[1]);
			jo.put("gender", data[2]);
			jo.put("birthday", data[3]);
			jo.put("password", data[4]);
			jo.put("phone", data[5]);
			jo.put("education", data[6]);
			jo.put("idnumber", data[7]);
			jo.put("prof1name", data[8]);
			jo.put("prof2name", data[9]);
			jo.put("proviceName", data[10]);
			jo.put("cityName", data[11]);
			jo.put("countyName", data[12]);
			jo.put("townName", data[13]);
			jo.put("fazhengtime", data[14]);
			jo.put("level", data[15]);
			jo.put("writescore", data[16]);
			jo.put("interviewscore", data[17]);
			jo.put("totalscore", data[18]);
			jo.put("number", data[19]);
			json.add(jo);
		}
		return json;
	}

	@Override
	public JSONArray getUserResult(String username, String level) {
		// TODO Auto-generated method stub
		ArrayList<Results> re = (ArrayList<Results>) resultsDAO.getUserResult(
				username, level);
//		JsonConfig jsonConfig = new JsonConfig();
//		jsonConfig.setExcludes(new String[] { "users", "exams", "shenyans",
//				"certificates", "resultses", "achievements",
//				"prof2sForClass1name", "prof2sForC1id" });
//		return JSONArray.fromObject(re, jsonConfig);
		JSONArray json = new JSONArray();
		JSONObject jo = null;
		Iterator iter = re.iterator();
		while (iter.hasNext()) {
			Object[] data = (Object[]) iter.next();
			jo = new JSONObject();
			jo.put("achievement", data[0]);
			jo.put("prof1name", data[1]);
			jo.put("prof2name", data[2]);
			jo.put("writescore", data[3]);
			jo.put("interviewscore", data[4]);
			jo.put("total", data[5]);
			jo.put("canjia", data[6]);
			jo.put("approval", data[7]);
			jo.put("opposition", data[8]);
			jo.put("number", data[9]);
			jo.put("name", data[10]);
			jo.put("gender", data[11]);
			jo.put("birthday", data[12]);
			jo.put("phone", data[13]);
			jo.put("idnumber", data[14]);
			jo.put("proviceName", data[15]);
			jo.put("cityName", data[16]);
			jo.put("countyName", data[17]);
			jo.put("townName", data[18]);
			jo.put("education", data[19]);
			jo.put("picpath", data[20]);
			json.add(jo);
		}
		return json;
	}

	@Override
	public String getzhenshu(String username, String level) {
		// TODO Auto-generated method stub
		String number="";
		ArrayList<Results> re = (ArrayList<Results>) resultsDAO.getUserResult(
				username, level);
		if (re.isEmpty()) {
			return "无该级别证书";
		}
		Iterator iter = re.iterator();
		while (iter.hasNext()) {
			Object[] data = (Object[]) iter.next();
			number=(String) data[9];
		}
		return number;
	}

	@Override
	public JSONArray searchByCounty(String town, String prof1, String prof2,
			String gender, String age, String education, String level,
			String fazheng) {
		// TODO Auto-generated method stub
//		return resultsDAO.searchByCounty(town, prof1, prof2, gender, age,
//				education, level, fazheng);
		List re = resultsDAO.searchByCounty(town, prof1, prof2, gender, age,
				education, level, fazheng);

		JSONArray json = new JSONArray();
		JSONObject jo = null;
		Iterator iter = re.iterator();
		while (iter.hasNext()) {
			Object[] data = (Object[]) iter.next();
			jo = new JSONObject();
			jo.put("username", data[0]);
			jo.put("name", data[1]);
			jo.put("gender", data[2]);
			jo.put("birthday", data[3]);
			jo.put("password", data[4]);
			jo.put("phone", data[5]);
			jo.put("education", data[6]);
			jo.put("idnumber", data[7]);
			jo.put("prof1name", data[8]);
			jo.put("prof2name", data[9]);
			jo.put("proviceName", data[10]);
			jo.put("cityName", data[11]);
			jo.put("countyName", data[12]);
			jo.put("townName", data[13]);
			jo.put("fazhengtime", data[14]);
			jo.put("level", data[15]);
			jo.put("writescore", data[16]);
			jo.put("interviewscore", data[17]);
			jo.put("totalscore", data[18]);
			jo.put("number", data[19]);
			json.add(jo);
		}
		return json;
	}

	@Override
	public List export(int info, String local, String prof1,
			String prof2, String gender, String age, String education,
			String level, String fazheng) {
		List re;
		switch(info){
			case 1:
				re= resultsDAO.searchByAll(local, prof1, prof2, gender, age,
						education, level, fazheng);
				break;
			case 2:
				re= resultsDAO.searchByProvince(local, prof1, prof2, gender, age,
						education, level, fazheng);
				break;
			case 3:
				re= resultsDAO.searchByCity(local, prof1, prof2, gender, age,
						education, level, fazheng);
				break;
			case 4:
				re= resultsDAO.searchByCounty(local, prof1, prof2, gender, age,
						education, level, fazheng);
				break;
			default:
				re=null;
				break;
		}
		return re;
	}

}
