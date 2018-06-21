package com.ftms.action;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import com.ftms.service.DataAnalysisService;
import com.ftms.service.ExportService;
import com.ftms.service.ResultsService;
import com.opensymphony.xwork2.ActionSupport;

public class SfsjAction extends ActionSupport {
	private String province;
	private DataAnalysisService dataAnalysisService;
	private ResultsService resultsService;
	private ExportService exportService;
	private JSONArray SfsjJson;
	private String city;
	private String prof1;
	private String prof2;
	private String gender;
	private String age;
	private String level;
	private String education;
	private String fazheng;
	private int show;

	private int year;
	private int month;
	private int day;
	private int total;
	private int citysum;
	private int countysum;
	public ExportService getExportService() {
		return exportService;
	}

	public void setExportService(ExportService exportService) {
		this.exportService = exportService;
	}
	public String getFazheng() {
		return fazheng;
	}

	public void setFazheng(String fazheng) {
		this.fazheng = fazheng;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public int getCitysum() {
		return citysum;
	}

	public void setCitysum(int citysum) {
		this.citysum = citysum;
	}

	public int getCountysum() {
		return countysum;
	}

	public void setCountysum(int countysum) {
		this.countysum = countysum;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public DataAnalysisService getDataAnalysisService() {
		return dataAnalysisService;
	}

	public void setDataAnalysisService(DataAnalysisService dataAnalysisService) {
		this.dataAnalysisService = dataAnalysisService;
	}

	public ResultsService getResultsService() {
		return resultsService;
	}

	public void setResultsService(ResultsService resultsService) {
		this.resultsService = resultsService;
	}

	public JSONArray getSfsjJson() {
		return SfsjJson;
	}

	public void setSfsjJson(JSONArray sfsjJson) {
		SfsjJson = sfsjJson;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getProf1() {
		return prof1;
	}

	public void setProf1(String prof1) {
		this.prof1 = prof1;
	}

	public String getProf2() {
		return prof2;
	}

	public void setProf2(String prof2) {
		this.prof2 = prof2;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public String getEducation() {
		return education;
	}

	public void setEducation(String education) {
		this.education = education;
	}

	public int getShow() {
		return show;
	}

	public void setShow(int show) {
		this.show = show;
	}

	public String sfsj() {
		return "sfsj";
	}

	public String searchAll() {
		this.SfsjJson =resultsService.searchByProvince(city, prof1,prof2, gender, age,education, level,fazheng);
		return "searchAll";
	}

	public String citysfsjJson() {
		JSONArray json = new JSONArray();
		json.add(dataAnalysisService.provinceCountByCity(province));
		json.add(dataAnalysisService.provinceLegendByCity(province));

		this.SfsjJson = json;
		return "sfsjJson";
	}

	public String profsfsjJson() {
		JSONArray json = new JSONArray();
		json.add(dataAnalysisService.provinceCountByProf(province));
		json.add(dataAnalysisService.provinceLegendByProf(province));

		this.SfsjJson = json;
		return "sfsjJson";
	}

	public String agesfsjJson() {
		JSONArray json = new JSONArray();
		json.add(dataAnalysisService.provinceCountByAge(province));

		this.SfsjJson = json;
		return "sfsjJson";
	}

	public String educationsfsjJson() {
		JSONArray json = new JSONArray();
		json.add(dataAnalysisService.provinceCountByEducation(province));
		json.add(dataAnalysisService.provinceLegendByEducation(province));

		this.SfsjJson = json;
		return "sfsjJson";
	}

	public String gendersfsjJson() {
		JSONArray json = new JSONArray();
		json.add(dataAnalysisService.provinceCountByGender(province));
		json.add(dataAnalysisService.provinceLegendByGender(province));

		this.SfsjJson = json;
		return "sfsjJson";
	}

	public String levelsfsjJson() {
		JSONArray json = new JSONArray();
		json.add(dataAnalysisService.provinceCountByLevel(province));
		json.add(dataAnalysisService.provinceLegendByLevel(province));

		this.SfsjJson = json;
		return "sfsjJson";
	}
	public String fazhengsfsjJson() {
		JSONArray json = new JSONArray();
		json.add(dataAnalysisService.provinceCountByFazhengtime(province));
		json.add(dataAnalysisService.provinceLegendByFazhengtime(province));

		this.SfsjJson = json;
		return "sfsjJson";
	}
	public String getInfo(){
		Calendar now = Calendar.getInstance();  
		year=now.get(Calendar.YEAR);
		month=now.get(Calendar.MONTH) + 1;
		day=now.get(Calendar.DAY_OF_MONTH);
		total=dataAnalysisService.provinceGetTotal(province);
		citysum=dataAnalysisService.provinceGetCity(province);
		countysum=dataAnalysisService.provinceGetCounty(province);
		
		SfsjJson=new JSONArray();
		JSONObject json=new JSONObject();
		json.clear();
		json.put("year", year);
		json.put("month", month);
		json.put("day", day);
		json.put("total", total);
		json.put("citysum", citysum);
		json.put("countysum", countysum);
		SfsjJson.add(json);
		return "Info";
	}
	public String exportExcel() throws Exception {
		List export = new ArrayList();
		export = resultsService.export(2,city, prof1, prof2, gender,
				age, education, level, fazheng);
		String ss = exportService.export(export);
		return null;
	}
}
