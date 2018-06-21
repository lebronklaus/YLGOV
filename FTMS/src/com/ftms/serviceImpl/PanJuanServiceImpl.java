package com.ftms.serviceImpl;

import java.util.List;

import net.sf.json.JSONArray;

import com.ftms.dao.ShitiDAO;
import com.ftms.entity.Shiti;
import com.ftms.service.PanJuanService;

public class PanJuanServiceImpl implements PanJuanService {
	private ShitiDAO shitiDAO;

	public ShitiDAO getShitiDAO() {
		return shitiDAO;
	}

	public void setShitiDAO(ShitiDAO shitiDAO) {
		this.shitiDAO = shitiDAO;
	}

	@Override
	public void panti(Shiti shijuan) {
		// TODO Auto-generated method stub
		shitiDAO.panti(shijuan);
	}

	@Override
	public List<Shiti> getXuanze(String sjbh) {
		// TODO Auto-generated method stub
		return shitiDAO.getXuanze(sjbh);
	}

	@Override
	public List<Shiti> getPanduan(String sjbh) {
		// TODO Auto-generated method stub
		return shitiDAO.getPanduan(sjbh);
	}

	@Override
	public void deleteShijuan(String sjbh) {
		// TODO Auto-generated method stub
		shitiDAO.deleteShijuan(sjbh);
	}

	@Override
	public JSONArray getMiss(String sjbh) {
		// TODO Auto-generated method stub
		return JSONArray.fromObject(shitiDAO.getMiss(sjbh));
	}
	
}
