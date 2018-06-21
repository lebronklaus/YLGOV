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

public class XjsjAction extends ActionSupport {
	private String county;
	private DataAnalysisService dataAnalysisService;
	private ResultsService resultsService;
	private ExportService exportService;
	private JSONArray XjsjJson;
	private String town;
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

	public String getCounty() {
		return county;
	}

	public void setCounty(String county) {
		this.county = county;
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

	public JSONArray getXjsjJson() {
		return XjsjJson;
	}

	public void setXjsjJson(JSONArray xjsjJson) {
		XjsjJson = xjsjJson;
	}

	public String getTown() {
		return town;
	}

	public void setTown(String town) {
		this.town = town;
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

	public String xjsj(){
		return "xjsj";
	}
	
	public String searchAll() {
		System.out.println(town+prof1+prof2+gender+age+education+level+fazheng);
		this.XjsjJson = resultsService.searchByCounty(town, prof1,prof2, gender, age, education, level,fazheng);
		return "searchAll";
	}
	
	public String townxjsjJson() {
		JSONArray json = new JSONArray();
		json.add(dataAnalysisService.countyCountByTown(county));
		json.add(dataAnalysisService.countyLegendByTown(county));
		this.XjsjJson = json;
		return "xjsjJson";
	}

	public String profxjsjJson() {
		JSONArray json = new JSONArray();
		json.add(dataAnalysisService.countyCountByProf(county));
		json.add(dataAnalysisService.countyLegendByProf(county));

		this.XjsjJson = json;
		return "xjsjJson";
	}

	public String agexjsjJson() {
		JSONArray json = new JSONArray();
		json.add(dataAnalysisService.countyCountByAge(county));

		this.XjsjJson = json;
		return "xjsjJson";
	}

	public String educationxjsjJson() {
		JSONArray json = new JSONArray();
		json.add(dataAnalysisService.countyCountByEducation(county));
		json.add(dataAnalysisService.countyLegendByEducation(county));

		this.XjsjJson = json;
		return "xjsjJson";
	}

	public String genderxjsjJson() {
		JSONArray json = new JSONArray();
		json.add(dataAnalysisService.countyCountByGender(county));
		json.add(dataAnalysisService.countyLegendByGender(county));

		this.XjsjJson = json;
		return "xjsjJson";
	}

	public String levelxjsjJson() {
		JSONArray json = new JSONArray();
		json.add(dataAnalysisService.countyCountByLevel(county));
		json.add(dataAnalysisService.countyLegendByLevel(county));

		this.XjsjJson = json;
		return "xjsjJson";
	}
	
	public String fazhengxjsjJson() {
		JSONArray json = new JSONArray();
		json.add(dataAnalysisService.countyCountByFazhengtime(county));
		json.add(dataAnalysisService.countyLegendByFazhengtime(county));

		this.XjsjJson = json;
		return "xjsjJson";
	}
	public String getInfo(){
		Calendar now = Calendar.getInstance();  
		int year = now.get(Calendar.YEAR);
		int month = now.get(Calendar.MONTH) + 1;
		int day = now.get(Calendar.DAY_OF_MONTH);
		int total = dataAnalysisService.countyGetTotal(county);
		int townsum = dataAnalysisService.countyGetTown(county);
		
		XjsjJson=new JSONArray();
		JSONObject json=new JSONObject();
		json.clear();
		json.put("year", year);
		json.put("month", month);
		json.put("day", day);
		json.put("total", total);
		json.put("townsum", townsum);
		XjsjJson.add(json);
		return "Info";
	}
	public String exportExcel() throws Exception {
		List export = new ArrayList();
		export = resultsService.export(4,town, prof1, prof2, gender,
				age, education, level, fazheng);
		String ss = exportService.export(export);
		return null;
	}
}
