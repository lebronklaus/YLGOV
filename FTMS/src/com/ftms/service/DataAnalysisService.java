package com.ftms.service;

import net.sf.json.JSONArray;

public interface DataAnalysisService {
	// ȫ��ͳ��
	public int getTotal();

	public int getProvince();

	public int getCity();

	public int getCounty();

	public JSONArray countByProvince();

	public JSONArray countByGender();

	public JSONArray countByProf();

	public JSONArray countByAge();

	public JSONArray countByLevel();

	public JSONArray countByEducation();
	
	public JSONArray countByFazhengTime();

	// ��ʡͳ��
	public int provinceGetTotal(String province);

	public int provinceGetCity(String province);

	public int provinceGetCounty(String province);

	public JSONArray provinceCountByCity(String province);

	public JSONArray provinceCountByCounty(String province);

	public JSONArray provinceCountByGender(String province);

	public JSONArray provinceCountByProf(String province);

	public JSONArray provinceCountByAge(String province);

	public JSONArray provinceCountByLevel(String province);

	public JSONArray provinceCountByEducation(String province);
	
	public JSONArray provinceCountByFazhengtime(String province);

	// ȫ��ͼ��legend
	public JSONArray legendByProvince();

	public JSONArray legendByGender();

	public JSONArray legendByProf();

	public JSONArray legendByLevel();

	public JSONArray legendByEducation();
	
	public JSONArray legendByFazhengtime();

	// ��ʡͼ��
	public JSONArray provinceLegendByCity(String province);

	public JSONArray provinceLegendByCounty(String province);

	public JSONArray provinceLegendByGender(String province);

	public JSONArray provinceLegendByProf(String province);

	public JSONArray provinceLegendByLevel(String province);

	public JSONArray provinceLegendByEducation(String province);
	
	public JSONArray provinceLegendByFazhengtime(String province);
	
	//����ͳ��
	
	public int cityGetTotal(String city);
	
	public int cityGetCounty(String city);
	
	public JSONArray cityCountByCounty(String City);

	public JSONArray cityCountByGender(String City);
	
	public JSONArray cityCountByProf(String City);
	
	public JSONArray cityCountByLevel(String City);
	
	public JSONArray cityCountByEducation(String City);
	
	public JSONArray cityCountByAge(String City);
	
	public JSONArray cityCountByFazhengtime(String City);
	
	//����ͼ��
	
	public JSONArray cityLegendByCounty(String City);
	
	public JSONArray cityLegendByGender(String City);
	
	public JSONArray cityLegendByProf(String City);
	
	public JSONArray cityLegendByLevel(String City);
	
	public JSONArray cityLegendByEducation(String City);
	
	public JSONArray cityLegendByFazhengtime(String City);
	
	//����ͼ��
	
		public int countyGetTotal(String County);
		
		public int countyGetTown(String County);
		
		public JSONArray countyCountByTown(String County);

		public JSONArray countyCountByGender(String County);
		
		public JSONArray countyCountByProf(String County);
		
		public JSONArray countyCountByLevel(String County);
		
		public JSONArray countyCountByEducation(String County);
		
		public JSONArray countyCountByAge(String County);
		
		public JSONArray countyCountByFazhengtime(String County);
		
		//����ͼ��
		
		public JSONArray countyLegendByTown(String County);
		
		public JSONArray countyLegendByGender(String County);
		
		public JSONArray countyLegendByProf(String County);
		
		public JSONArray countyLegendByLevel(String County);
		
		public JSONArray countyLegendByEducation(String County);
		
		public JSONArray countyLegendByFazhengtime(String County);
	
}
