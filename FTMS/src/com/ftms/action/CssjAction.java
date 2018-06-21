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

public class CssjAction extends ActionSupport {
	private String city;
	private DataAnalysisService dataAnalysisService;
	private ResultsService resultsService;
	private ExportService exportService;
	private JSONArray CssjJson;
	private String county;
	private String prof1;
	private String prof2;
	private String gender;
	private String age;
	private String level;
	private String education;
	private String fazheng;
	private int show;
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
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
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
	public JSONArray getCssjJson() {
		return CssjJson;
	}
	public void setCssjJson(JSONArray cssjJson) {
		CssjJson = cssjJson;
	}
	public String getCounty() {
		return county;
	}
	public void setCounty(String county) {
		this.county = county;
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
	
	public String cssj(){
		return "cssj";
	}
	
	public String searchAll() {
		this.CssjJson = resultsService.searchByCity(county, prof1,prof2, gender, age, education, level,fazheng);
		return "searchAll";
	}
	
	public String countycssjJson() {
		JSONArray json = new JSONArray();
		json.add(dataAnalysisService.cityCountByCounty(city));
		json.add(dataAnalysisService.cityLegendByCounty(city));

		this.CssjJson = json;
		return "cssjJson";
	}

	public String profcssjJson() {
		JSONArray json = new JSONArray();
		json.add(dataAnalysisService.cityCountByProf(city));
		json.add(dataAnalysisService.cityLegendByProf(city));

		this.CssjJson = json;
		return "cssjJson";
	}

	public String agecssjJson() {
		JSONArray json = new JSONArray();
		json.add(dataAnalysisService.cityCountByAge(city));

		this.CssjJson = json;
		return "cssjJson";
	}

	public String educationcssjJson() {
		JSONArray json = new JSONArray();
		json.add(dataAnalysisService.cityCountByEducation(city));
		json.add(dataAnalysisService.cityLegendByEducation(city));

		this.CssjJson = json;
		return "cssjJson";
	}

	public String gendercssjJson() {
		JSONArray json = new JSONArray();
		json.add(dataAnalysisService.cityCountByGender(city));
		json.add(dataAnalysisService.cityLegendByGender(city));

		this.CssjJson = json;
		return "cssjJson";
	}

	public String levelcssjJson() {
		JSONArray json = new JSONArray();
		json.add(dataAnalysisService.cityCountByLevel(city));
		json.add(dataAnalysisService.cityLegendByLevel(city));

		this.CssjJson = json;
		return "cssjJson";
	}
	public String fazhengcssjJson() {
		JSONArray json = new JSONArray();
		json.add(dataAnalysisService.cityCountByFazhengtime(city));
		json.add(dataAnalysisService.cityLegendByFazhengtime(city));

		this.CssjJson = json;
		return "cssjJson";
	}
	public String getInfo(){
		Calendar now = Calendar.getInstance();  
		int year = now.get(Calendar.YEAR);
		int month = now.get(Calendar.MONTH) + 1;
		int day = now.get(Calendar.DAY_OF_MONTH);
		int total = dataAnalysisService.cityGetTotal(city);
		int countysum = dataAnalysisService.cityGetCounty(city);
		
		CssjJson=new JSONArray();
		JSONObject json=new JSONObject();
		json.clear();
		json.put("year", year);
		json.put("month", month);
		json.put("day", day);
		json.put("total", total);
		json.put("countysum", countysum);
		CssjJson.add(json);
		return "Info";
	}
	public String exportExcel() throws Exception {
		List export = new ArrayList();
		export = resultsService.export(3,county, prof1, prof2, gender,
				age, education, level, fazheng);
		String ss = exportService.export(export);
		return null;
	}
}
