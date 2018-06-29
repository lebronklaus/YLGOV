package com.ftms.serviceImpl;

import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.ftms.dao.AddressDAO;
import com.ftms.dao.JPositionCityDAO;
import com.ftms.dao.JPositionCountyDAO;
import com.ftms.dao.JPositionProviceDAO;
import com.ftms.dao.JPositionTownDAO;
import com.ftms.entity.Address;
import com.ftms.entity.JPositionCity;
import com.ftms.entity.JPositionCounty;
import com.ftms.entity.JPositionProvice;
import com.ftms.entity.JPositionTown;
import com.ftms.service.LocationService;

public class LocationServiceImpl implements LocationService {
	private JPositionProviceDAO jPositionProviceDAO;
	private JPositionCityDAO jPositionCityDAO;
	private JPositionCountyDAO jPositionCountyDAO;
	private JPositionTownDAO jPositionTownDAO;
	private AddressDAO addressDAO;
	public AddressDAO getAddressDAO() {
		return addressDAO;
	}

	public void setAddressDAO(AddressDAO addressDAO) {
		this.addressDAO = addressDAO;
	}

	/*
	public JPositionProviceDAO getjPositionProviceDAO() {
		return jPositionProviceDAO;
	}

	public void setjPositionProviceDAO(JPositionProviceDAO jPositionProviceDAO) {
		this.jPositionProviceDAO = jPositionProviceDAO;
	}

	public JPositionCityDAO getjPositionCityDAO() {
		return jPositionCityDAO;
	}

	public void setjPositionCityDAO(JPositionCityDAO jPositionCityDAO) {
		this.jPositionCityDAO = jPositionCityDAO;
	}

	public JPositionCountyDAO getjPositionCountyDAO() {
		return jPositionCountyDAO;
	}

	public void setjPositionCountyDAO(JPositionCountyDAO jPositionCountyDAO) {
		this.jPositionCountyDAO = jPositionCountyDAO;
	}

	public JPositionTownDAO getjPositionTownDAO() {
		return jPositionTownDAO;
	}

	public void setjPositionTownDAO(JPositionTownDAO jPositionTownDAO) {
		this.jPositionTownDAO = jPositionTownDAO;
	}
	*/
	

	@Override
	public JSONArray getProvince() {
		// TODO Auto-generated method stub
		List<JPositionProvice> province = jPositionProviceDAO.findAll();
		JSONArray json = new JSONArray();
		JSONObject jo = null;
		for (JPositionProvice p : province) {
			jo = new JSONObject();
			jo.put("value", p.getProviceId());
			jo.put("text", p.getProviceName());
			json.add(jo);
		}
		return json;
	}

	public JPositionProviceDAO getJPositionProviceDAO() {
		return jPositionProviceDAO;
	}

	public void setJPositionProviceDAO(JPositionProviceDAO jPositionProviceDAO) {
		this.jPositionProviceDAO = jPositionProviceDAO;
	}

	public JPositionCityDAO getJPositionCityDAO() {
		return jPositionCityDAO;
	}

	public void setJPositionCityDAO(JPositionCityDAO jPositionCityDAO) {
		this.jPositionCityDAO = jPositionCityDAO;
	}

	public JPositionCountyDAO getJPositionCountyDAO() {
		return jPositionCountyDAO;
	}

	public void setJPositionCountyDAO(JPositionCountyDAO jPositionCountyDAO) {
		this.jPositionCountyDAO = jPositionCountyDAO;
	}

	public JPositionTownDAO getJPositionTownDAO() {
		return jPositionTownDAO;
	}

	public void setJPositionTownDAO(JPositionTownDAO jPositionTownDAO) {
		this.jPositionTownDAO = jPositionTownDAO;
	}

	@Override
	public JSONArray getCity(int provinceid) {
		// TODO Auto-generated method stub
		List<JPositionCity> city = jPositionCityDAO.findByProvinceId(provinceid);
		JSONArray json = new JSONArray();
		JSONObject jo = null;
		for (JPositionCity c : city) {
			jo = new JSONObject();
			jo.put("value", c.getCityId());
			jo.put("text", c.getCityName());
			json.add(jo);
		}
		return json;
	}

	@Override
	public JSONArray getCounty(long cityid) {
		// TODO Auto-generated method stub
		List<JPositionCounty> county = jPositionCountyDAO.findByCityId(cityid);
		JSONArray json = new JSONArray();
		JSONObject jo = null;
		for (JPositionCounty c : county) {
			jo = new JSONObject();
			jo.put("value", c.getCountyId());
			jo.put("text", c.getCountyName());
			json.add(jo);
		}
		return json;
	}

	@Override
	public JSONArray gettown(long countyid) {
		// TODO Auto-generated method stub
		List<JPositionTown> town = jPositionTownDAO.findByCountyId(countyid);
		JSONArray json = new JSONArray();
		JSONObject jo = null;
		for (JPositionTown t : town) {
			jo = new JSONObject();
			jo.put("value", t.getTownId());
			jo.put("text", t.getTownName());
			json.add(jo);
		}
		return json;
	}

	@Override
	public JPositionProvice getUserProvince(int provinceid) {
		// TODO Auto-generated method stub
		return (JPositionProvice) jPositionProviceDAO.findByProviceId(provinceid).get(0);
	}

	@Override
	public JPositionCity getUserCity(long cityid) {
		// TODO Auto-generated method stub
		return (JPositionCity) jPositionCityDAO.findByCityId(cityid).get(0);
	}

	@Override
	public JPositionCounty getUserCounty(long countyid) {
		// TODO Auto-generated method stub
		return (JPositionCounty) jPositionCountyDAO.findByCountyId(countyid).get(0);
	}

	@Override
	public JPositionTown getUserTown(long townid) {
		// TODO Auto-generated method stub
		return (JPositionTown) jPositionTownDAO.findByTownId(townid).get(0);
	}

	@Override
	public Address getUserAddress(String username) {
		// TODO Auto-generated method stub
		if(addressDAO.findByUsername(username).isEmpty()){
		
			Address a=new Address();
			a.setAddress("无");
			return a;
		}
		return (Address) addressDAO.findByUsername(username).get(0);
	}

	@Override
	public void setUserAddress(String username, String address) {
		// TODO Auto-generated method stub
		Address a=new Address();
		if(addressDAO.findByUsername(username).isEmpty()){
			a.setUsername(username);
			a.setAddress(address);
		}else{
			a=(Address) addressDAO.findByUsername(username).get(0);
			a.setAddress(address);
			a.setUsername(username);
		}
		addressDAO.merge(a);
	}

}
