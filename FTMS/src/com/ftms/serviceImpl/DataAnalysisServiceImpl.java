package com.ftms.serviceImpl;

import java.util.Iterator;
import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.ftms.dao.ResultsDAO;
import com.ftms.service.DataAnalysisService;

public class DataAnalysisServiceImpl implements DataAnalysisService {
	private ResultsDAO resultsDAO;

	public ResultsDAO getResultsDAO() {
		return resultsDAO;
	}

	public void setResultsDAO(ResultsDAO resultsDAO) {
		this.resultsDAO = resultsDAO;
	}

	public JSONArray getJson(List list) {
		JSONArray json = new JSONArray();
		JSONObject jo = null;
		Iterator iter = list.iterator();
		while (iter.hasNext()) {
			Object[] data = (Object[]) iter.next();
			jo = new JSONObject();
			jo.put("value", (long) data[1]);
			jo.put("name", data[0]);
			json.add(jo);
		}
		return json;
	}

	public JSONArray getYearJson(List list) {
		JSONArray json = new JSONArray();
		JSONObject jo = null;
		Iterator iter = list.iterator();
		while (iter.hasNext()) {
			Object[] data = (Object[]) iter.next();
			jo = new JSONObject();
			jo.put("value", data[1]);
			jo.put("name", data[0]);
			json.add(jo);
		}
		return json;
	}

	public JSONArray getAgeJson(List list) {
		JSONArray json = new JSONArray();
		JSONObject jo = null;
		Iterator iter = list.iterator();
		int[] ages = new int[6];
		while (iter.hasNext()) {
			int age = Integer.parseInt(iter.next().toString());
			if (age < 20) {
				ages[0]++;
			} else if (age >= 20 && age < 30) {
				ages[1]++;
			} else if (age >= 30 && age < 40) {
				ages[2]++;
			} else if (age >= 40 && age < 50) {
				ages[3]++;
			} else if (age >= 50 && age < 60) {
				ages[4]++;
			} else if (age >= 60) {
				ages[5]++;
			}
		}

		if (ages[0] != 0) {
			System.out.println(ages[0]+"sdfasdfsdafsdafsadfasdfdsf");
			jo = new JSONObject();
			jo.put("value", ages[0]);
			jo.put("name", "20以下");
			json.add(jo);
		}
		if (ages[1] != 0) {
			System.out.println(ages[1]);
			jo = new JSONObject();
			jo.put("value", ages[1]);
			jo.put("name", "20-30");
			json.add(jo);
		}
		if (ages[2] != 0) {
			System.out.println(ages[2]);
			jo = new JSONObject();
			jo.put("value", ages[2]);
			jo.put("name", "30-40");
			json.add(jo);
		}

		if (ages[3] != 0) {
			System.out.println(ages[3]);
			jo = new JSONObject();
			jo.put("value", ages[3]);
			jo.put("name", "40-50");
			json.add(jo);
		}

		if (ages[4] != 0) {
			System.out.println(ages[4]);
			jo = new JSONObject();
			jo.put("value", ages[4]);
			jo.put("name", "50-60");
			json.add(jo);
		}

		if (ages[5] != 0) {
			System.out.println(ages[5]);
			jo = new JSONObject();
			jo.put("value", ages[5]);
			jo.put("name", "60以上");
			json.add(jo);
		}

		return json;
	}

	public JSONArray getLegendJson(List list) {
		JSONArray json = new JSONArray();
		Iterator iter = list.iterator();
		while (iter.hasNext()) {
			Object[] data = (Object[]) iter.next();
			json.add(data[0]);
		}
		return json;
	}

	@Override
	public int getTotal() {
		// TODO Auto-generated method stub
		return resultsDAO.findAllUser();
	}

	@Override
	public int getProvince() {
		// TODO Auto-generated method stub
		return resultsDAO.getProvince();
	}

	@Override
	public int getCity() {
		// TODO Auto-generated method stub
		return resultsDAO.getCity();
	}

	@Override
	public int getCounty() {
		// TODO Auto-generated method stub
		return resultsDAO.getCounty();
	}

	@Override
	public JSONArray countByProvince() {
		// TODO Auto-generated method stub
		return getJson(resultsDAO.countByProvince());
	}

	@Override
	public JSONArray countByGender() {
		// TODO Auto-generated method stub
		return getJson(resultsDAO.countByGender());
	}

	@Override
	public JSONArray countByProf() {
		// TODO Auto-generated method stub
		return getJson(resultsDAO.countByProf());
	}

	@Override
	public JSONArray countByAge() {
		// TODO Auto-generated method stub
		System.out.println("slkdfj;sldakjflda;ksjfpiowaejlkfjsdl;kfj lks");
		return getAgeJson(resultsDAO.countByAge());
	}

	@Override
	public JSONArray countByLevel() {
		// TODO Auto-generated method stub
		return getJson(resultsDAO.countByLevel());
	}

	@Override
	public JSONArray countByEducation() {
		// TODO Auto-generated method stub
		return getJson(resultsDAO.countByEducation());
	}

	@Override
	public int provinceGetTotal(String province) {
		// TODO Auto-generated method stub
		return resultsDAO.provinceGetTotal(province);
	}

	@Override
	public int provinceGetCity(String province) {
		// TODO Auto-generated method stub
		return resultsDAO.provinceGetCity(province);
	}

	@Override
	public int provinceGetCounty(String province) {
		// TODO Auto-generated method stub
		return resultsDAO.provinceGetCounty(province);
	}

	@Override
	public JSONArray provinceCountByCity(String province) {
		// TODO Auto-generated method stub
		return getJson(resultsDAO.provinceCountByCity(province));
	}

	@Override
	public JSONArray provinceCountByCounty(String province) {
		// TODO Auto-generated method stub
		return getJson(resultsDAO.provinceCountByCounty(province));
	}

	@Override
	public JSONArray provinceCountByGender(String province) {
		// TODO Auto-generated method stub
		return getJson(resultsDAO.provinceCountByGender(province));
	}

	@Override
	public JSONArray provinceCountByProf(String province) {
		// TODO Auto-generated method stub
		return getJson(resultsDAO.provinceCountByProf(province));
	}

	@Override
	public JSONArray provinceCountByAge(String province) {
		// TODO Auto-generated method stub
		return getAgeJson(resultsDAO.provinceCountByAge(province));
	}

	@Override
	public JSONArray provinceCountByLevel(String province) {
		// TODO Auto-generated method stub
		return getJson(resultsDAO.provinceCountByLevel(province));
	}

	@Override
	public JSONArray provinceCountByEducation(String province) {
		// TODO Auto-generated method stub
		return getJson(resultsDAO.provinceCountByEducation(province));
	}

	@Override
	public JSONArray legendByProvince() {
		// TODO Auto-generated method stub
		return getLegendJson(resultsDAO.countByProvince());
	}

	@Override
	public JSONArray legendByGender() {
		// TODO Auto-generated method stub
		return getLegendJson(resultsDAO.countByGender());
	}

	@Override
	public JSONArray legendByProf() {
		// TODO Auto-generated method stub
		return getLegendJson(resultsDAO.countByProf());
	}

	@Override
	public JSONArray legendByLevel() {
		// TODO Auto-generated method stub
		return getLegendJson(resultsDAO.countByLevel());
	}

	@Override
	public JSONArray legendByEducation() {
		// TODO Auto-generated method stub
		return getLegendJson(resultsDAO.countByEducation());
	}

	@Override
	public JSONArray provinceLegendByCity(String province) {
		// TODO Auto-generated method stub
		return getLegendJson(resultsDAO.provinceCountByCity(province));
	}

	@Override
	public JSONArray provinceLegendByCounty(String province) {
		// TODO Auto-generated method stub
		return getLegendJson(resultsDAO.provinceCountByCounty(province));
	}

	@Override
	public JSONArray provinceLegendByGender(String province) {
		// TODO Auto-generated method stub
		return getLegendJson(resultsDAO.provinceCountByGender(province));
	}

	@Override
	public JSONArray provinceLegendByProf(String province) {
		// TODO Auto-generated method stub
		return getLegendJson(resultsDAO.provinceCountByProf(province));
	}

	@Override
	public JSONArray provinceLegendByLevel(String province) {
		// TODO Auto-generated method stub
		return getLegendJson(resultsDAO.provinceCountByLevel(province));
	}

	@Override
	public JSONArray provinceLegendByEducation(String province) {
		// TODO Auto-generated method stub
		return getLegendJson(resultsDAO.provinceCountByEducation(province));
	}

	@Override
	public JSONArray cityCountByCounty(String City) {
		// TODO Auto-generated method stub
		return getJson(resultsDAO.cityCountByCounty(City));
	}

	@Override
	public JSONArray cityCountByGender(String City) {
		// TODO Auto-generated method stub
		return getJson(resultsDAO.cityCountByGender(City));
	}

	@Override
	public JSONArray cityCountByProf(String City) {
		// TODO Auto-generated method stub
		return getJson(resultsDAO.cityCountByProf(City));
	}

	@Override
	public JSONArray cityCountByLevel(String City) {
		// TODO Auto-generated method stub
		return getJson(resultsDAO.cityCountByLevel(City));
	}

	@Override
	public JSONArray cityCountByEducation(String City) {
		// TODO Auto-generated method stub
		return getJson(resultsDAO.cityCountByEducation(City));
	}

	@Override
	public JSONArray cityCountByAge(String City) {
		// TODO Auto-generated method stub
		return getAgeJson(resultsDAO.cityCountByAge(City));
	}

	@Override
	public JSONArray cityLegendByCounty(String City) {
		// TODO Auto-generated method stub
		return getLegendJson(resultsDAO.cityCountByCounty(City));
	}

	@Override
	public JSONArray cityLegendByGender(String City) {
		// TODO Auto-generated method stub
		return getLegendJson(resultsDAO.cityCountByGender(City));
	}

	@Override
	public JSONArray cityLegendByProf(String City) {
		// TODO Auto-generated method stub
		return getLegendJson(resultsDAO.cityCountByProf(City));
	}

	@Override
	public JSONArray cityLegendByLevel(String City) {
		// TODO Auto-generated method stub
		return getLegendJson(resultsDAO.cityCountByLevel(City));
	}

	@Override
	public JSONArray cityLegendByEducation(String City) {
		// TODO Auto-generated method stub
		return getLegendJson(resultsDAO.cityCountByEducation(City));
	}

	@Override
	public int cityGetTotal(String city) {
		// TODO Auto-generated method stub
		return resultsDAO.cityGetTotal(city);
	}

	@Override
	public int cityGetCounty(String city) {
		// TODO Auto-generated method stub
		return resultsDAO.cityGetCounty(city);
	}

	// 分县
	@Override
	public int countyGetTotal(String County) {
		// TODO Auto-generated method stub
		return resultsDAO.countyGetTotal(County);
	}

	@Override
	public int countyGetTown(String County) {
		// TODO Auto-generated method stub
		return resultsDAO.countyGetTown(County);
	}

	@Override
	public JSONArray countyCountByTown(String County) {
		// TODO Auto-generated method stub
		return getJson(resultsDAO.countyCountByTown(County));
	}

	@Override
	public JSONArray countyCountByGender(String County) {
		// TODO Auto-generated method stub
		return getJson(resultsDAO.countyCountByGender(County));
	}

	@Override
	public JSONArray countyCountByProf(String County) {
		// TODO Auto-generated method stub
		return getJson(resultsDAO.countyCountByProf(County));
	}

	@Override
	public JSONArray countyCountByLevel(String County) {
		// TODO Auto-generated method stub
		return getJson(resultsDAO.countyCountByLevel(County));
	}

	@Override
	public JSONArray countyCountByEducation(String County) {
		// TODO Auto-generated method stub
		return getJson(resultsDAO.countyCountByEducation(County));
	}

	@Override
	public JSONArray countyCountByAge(String County) {
		// TODO Auto-generated method stub
		return getAgeJson(resultsDAO.countyCountByAge(County));
	}

	@Override
	public JSONArray countyLegendByTown(String County) {
		// TODO Auto-generated method stub
		return getLegendJson(resultsDAO.countyCountByTown(County));
	}

	@Override
	public JSONArray countyLegendByGender(String County) {
		// TODO Auto-generated method stub
		return getLegendJson(resultsDAO.countyCountByGender(County));
	}

	@Override
	public JSONArray countyLegendByProf(String County) {
		// TODO Auto-generated method stub
		return getLegendJson(resultsDAO.countyCountByProf(County));
	}

	@Override
	public JSONArray countyLegendByLevel(String County) {
		// TODO Auto-generated method stub
		return getLegendJson(resultsDAO.countyCountByLevel(County));
	}

	@Override
	public JSONArray countyLegendByEducation(String County) {
		// TODO Auto-generated method stub
		return getLegendJson(resultsDAO.countyCountByEducation(County));
	}

	@Override
	public JSONArray countByFazhengTime() {
		// TODO Auto-generated method stub
		return getYearJson(resultsDAO.countByYear());
	}

	@Override
	public JSONArray provinceCountByFazhengtime(String province) {
		// TODO Auto-generated method stub
		return getYearJson(resultsDAO.provinceCountByYear(province));
	}

	@Override
	public JSONArray legendByFazhengtime() {
		// TODO Auto-generated method stub
		return getLegendJson(resultsDAO.countByYear());
	}

	@Override
	public JSONArray provinceLegendByFazhengtime(String province) {
		// TODO Auto-generated method stub
		return getLegendJson(resultsDAO.provinceCountByYear(province));
	}

	@Override
	public JSONArray cityCountByFazhengtime(String City) {
		// TODO Auto-generated method stub
		return getYearJson(resultsDAO.cityCountByYear(City));
	}

	@Override
	public JSONArray cityLegendByFazhengtime(String City) {
		// TODO Auto-generated method stub
		return getLegendJson(resultsDAO.cityCountByYear(City));
	}

	@Override
	public JSONArray countyCountByFazhengtime(String County) {
		// TODO Auto-generated method stub
		return getYearJson(resultsDAO.countyCountByYear(County));
	}

	@Override
	public JSONArray countyLegendByFazhengtime(String County) {
		// TODO Auto-generated method stub
		return getLegendJson(resultsDAO.countyCountByYear(County));
	}

}
