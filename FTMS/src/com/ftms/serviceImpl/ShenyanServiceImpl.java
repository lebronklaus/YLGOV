package com.ftms.serviceImpl;

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
import com.ftms.service.ShenyanService;

public class ShenyanServiceImpl implements ShenyanService {
	private ShenyanDAO shenyanDAO;
	private UserDAO userDAO;
	private ResultsDAO resultsdao;
	public ResultsDAO getResultsdao() {
		return resultsdao;
	}

	public void setResultsdao(ResultsDAO resultsdao) {
		this.resultsdao = resultsdao;
	}

	public UserDAO getUserDAO() {
		return userDAO;
	}

	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

	public ShenyanDAO getShenyanDAO() {
		return shenyanDAO;
	}

	public void setShenyanDAO(ShenyanDAO shenyanDAO) {
		this.shenyanDAO = shenyanDAO;
	}

	@Override
	public void check(int id, String username) {
		// TODO Auto-generated method stub
		Results r= resultsdao.findById(id);
		int index=0;
		Calendar now = Calendar.getInstance();  
		int year=now.get(Calendar.YEAR);
		Shenyan c=new Shenyan();
		if(shenyanDAO.searchshenyanid(username).isEmpty()){
			c.setUser((User)userDAO.findByUsername(username).get(0));
			c.setLevel(r.getLevel());
			c.setStatus("是");
			c.setYear(year);
			shenyanDAO.merge(c);
		}else{
			int k=shenyanDAO.searchshenyanid(username).size();
			for(int i=0;i<k;i++){
				c=shenyanDAO.findById((int)shenyanDAO.searchshenyanid(username).get(i));
				if(c.getYear().equals(year)){
					index=1;
					c.setStatus("是");
					shenyanDAO.merge(c);
				}
			}
			if(index!=1){
				Shenyan d=new Shenyan();
				d.setUser((User)userDAO.findByUsername(username).get(0));
				d.setLevel(r.getLevel());
				d.setStatus("是");
				d.setYear(year);
				shenyanDAO.merge(d);
			}
		}
		
	}

	@Override
	public JSONArray searchCheck(String name, String level) {
		// TODO Auto-generated method stub
		//return resultsdao.searchCheck(name,level);
		List re = resultsdao.shenyanSearch(name, level);

		JSONArray json = new JSONArray();
		JSONObject jo = null;
		Iterator iter = re.iterator();
		while (iter.hasNext()) {
			Object[] data = (Object[]) iter.next();
			jo = new JSONObject();
			jo.put("name", data[0]);
			jo.put("level", data[1]);
			jo.put("picpath", data[2]);
			jo.put("gender", data[3]);
			jo.put("birthday", data[4]);
			jo.put("idnumber", data[5]);
			jo.put("phone", data[6]);
			jo.put("proviceName", data[7]);
			jo.put("cityName", data[8]);
			jo.put("countyName", data[9]);
			jo.put("townName", data[10]);
			jo.put("education", data[11]);
			jo.put("prof1name", data[12]);
			jo.put("prof2name", data[13]);
			jo.put("id", data[14]);
			jo.put("username", data[15]);
			json.add(jo);
		}
		return json;
	}

	@Override
	public void addCheck(Shenyan c) {
		// TODO Auto-generated method stub
		shenyanDAO.save(c);
	}

	@Override
	public JSONArray findAll() {
		// TODO Auto-generated method stub
		return JSONArray.fromObject(shenyanDAO.findAll()) ;
	}

	@Override
	public String judge(String username, String level) {
		// TODO Auto-generated method stub
		User u=(User) userDAO.findByUsername(username).get(0);
		List<Shenyan> sy=shenyanDAO.searchCheck(u.getName(), level);
		if(sy.isEmpty()){
			return "无该级别证书";
		}
		
		return sy.get(0).getStatus();
	}

	@Override
	public JSONArray findUser(String name, String level) {
		// TODO Auto-generated method stub
		//return shenyanDAO.searchCheck(name, level);
		List re = shenyanDAO.searchCheck(name, level);

		JSONArray json = new JSONArray();
		JSONObject jo = null;
		Iterator iter = re.iterator();
		while (iter.hasNext()) {
			Object[] data = (Object[]) iter.next();
			jo = new JSONObject();
			jo.put("id", data[0]);
			jo.put("year", data[1]);
			jo.put("level", data[2]);
			jo.put("status", data[3]);
			json.add(jo);
		}
		return json;
	}

}
