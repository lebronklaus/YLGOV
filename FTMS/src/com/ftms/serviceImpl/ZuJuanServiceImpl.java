package com.ftms.serviceImpl;

import java.util.List;

import com.ftms.dao.TikuDAO;
import com.ftms.entity.Tiku;
import com.ftms.service.ZuJuanService;

public class ZuJuanServiceImpl implements ZuJuanService {
	private TikuDAO tikuDAO;
	
	public TikuDAO getTikuDAO() {
		return tikuDAO;
	}

	public void setTikuDAO(TikuDAO tikuDAO) {
		this.tikuDAO = tikuDAO;
	}
	
	@Override
	public List<Tiku> getXuanze(String profession, String difficulty, int count) {
		// TODO Auto-generated method stub
		return tikuDAO.findXuanze(profession, difficulty, count);
	}

	@Override
	public List<Tiku> getPanduan(String profession, String difficulty, int count) {
		// TODO Auto-generated method stub
		return tikuDAO.findPanduan(profession, difficulty, count);
	}
}
