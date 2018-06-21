package com.ftms.action;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import net.sf.json.JSONArray;
import com.ftms.service.DataAnalysisService;
import com.ftms.service.ExportService;
import com.ftms.service.ResultsService;
import com.opensymphony.xwork2.ActionSupport;

public class QgsjAction extends ActionSupport {
	private DataAnalysisService dataAnalysisService;
	private ResultsService resultsService;
	private ExportService exportService;
	private JSONArray QgsjJson;
	private String province;
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
	private int provincesum;
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

	public int getProvincesum() {
		return provincesum;
	}

	public void setProvincesum(int provincesum) {
		this.provincesum = provincesum;
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

	public DataAnalysisService getDataAnalysisService() {
		return dataAnalysisService;
	}

	public void setDataAnalysisService(DataAnalysisService dataAnalysisService) {
		this.dataAnalysisService = dataAnalysisService;
	}

	public JSONArray getQgsjJson() {
		return QgsjJson;
	}

	public void setQgsjJson(JSONArray qgsjJson) {
		QgsjJson = qgsjJson;
	}

	// 这是进行条件查询的方法
	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
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

	public ResultsService getResultsService() {
		return resultsService;
	}

	public void setResultsService(ResultsService resultsService) {
		this.resultsService = resultsService;
	}

	public int getShow() {
		return show;
	}

	public void setShow(int show) {
		this.show = show;
	}

	public String qgsj() {
		Calendar now = Calendar.getInstance();
		year = now.get(Calendar.YEAR);
		month = now.get(Calendar.MONTH) + 1;
		day = now.get(Calendar.DAY_OF_MONTH);
		total = dataAnalysisService.getTotal();
		provincesum = dataAnalysisService.getProvince();
		citysum = dataAnalysisService.getCity();
		countysum = dataAnalysisService.getCounty();
		return "qgsj";
	}

	public String searchAll() {
		this.QgsjJson = resultsService.searchByAll(province, prof1, prof2,
				gender, age, education, level, fazheng);
		return "search";
	}

	public String provinceqgsjJson() {
		JSONArray json = new JSONArray();
		json.add(dataAnalysisService.countByProvince());
		json.add(dataAnalysisService.legendByProvince());

		this.QgsjJson = json;
		return "QgsjJson";
	}

	public String profqgsjJson() {
		JSONArray json = new JSONArray();
		json.add(dataAnalysisService.countByProf());
		json.add(dataAnalysisService.legendByProf());

		this.QgsjJson = json;
		return "QgsjJson";
	}

	public String ageqgsjJson() {
		JSONArray json = new JSONArray();
		json.add(dataAnalysisService.countByAge());

		this.QgsjJson = json;
		return "QgsjJson";
	}

	public String educationqgsjJson() {
		JSONArray json = new JSONArray();
		json.add(dataAnalysisService.countByEducation());
		json.add(dataAnalysisService.legendByEducation());

		this.QgsjJson = json;
		return "QgsjJson";
	}

	public String genderqgsjJson() {
		JSONArray json = new JSONArray();
		json.add(dataAnalysisService.countByGender());
		json.add(dataAnalysisService.legendByGender());

		this.QgsjJson = json;
		return "QgsjJson";
	}

	public String levelqgsjJson() {
		JSONArray json = new JSONArray();
		json.add(dataAnalysisService.countByLevel());
		json.add(dataAnalysisService.legendByLevel());

		this.QgsjJson = json;
		return "QgsjJson";
	}

	public String fazhengqgsjJson() {
		JSONArray json = new JSONArray();
		json.add(dataAnalysisService.countByFazhengTime());
		json.add(dataAnalysisService.legendByFazhengtime());
		this.QgsjJson = json;
		return "QgsjJson";
	}

	public String getInfo() {
		Calendar now = Calendar.getInstance();
		year = now.get(Calendar.YEAR);
		month = now.get(Calendar.MONTH) + 1;
		day = now.get(Calendar.DAY_OF_MONTH);
		total = dataAnalysisService.getTotal();
		provincesum = dataAnalysisService.getProvince();
		citysum = dataAnalysisService.getCity();
		countysum = dataAnalysisService.getCounty();
		return "Info";
	}

	public String Info() {
		return "Info";
	}

	public String exportExcel() throws Exception {
		List export = new ArrayList();
		export = resultsService.export(1,province, prof1, prof2, gender,
				age, education, level, fazheng);
		String ss = exportService.export(export);
		return null;
	}
}
