package com.ftms.service;

import java.util.List;

import net.sf.json.JSONArray;

import com.ftms.entity.Shiti;

public interface PanJuanService {
	public void panti(Shiti shijuan);
	public List<Shiti> getXuanze(String sjbh);
	public List<Shiti> getPanduan(String sjbh);
	public void deleteShijuan(String sjbh);
	public JSONArray getMiss(String sjbh);
}
