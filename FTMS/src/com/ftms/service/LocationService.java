package com.ftms.service;

import com.ftms.entity.Address;
import com.ftms.entity.JPositionCity;
import com.ftms.entity.JPositionCounty;
import com.ftms.entity.JPositionProvice;
import com.ftms.entity.JPositionTown;

import net.sf.json.JSONArray;

public interface LocationService {
	public JSONArray getProvince();
	public JSONArray getCity(int provinceid);
	public JSONArray getCounty(long cityid);
	public JSONArray gettown(long countyid);
	public JPositionProvice getUserProvince(int provinceid);
	public JPositionCity getUserCity(long cityid);
	public JPositionCounty getUserCounty(long countyid);
	public JPositionTown getUserTown(long townid);
	public Address getUserAddress(String username);
	public void setUserAddress(String username,String address);
}
