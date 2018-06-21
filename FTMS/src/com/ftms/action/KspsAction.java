package com.ftms.action;

import java.sql.Timestamp;

import net.sf.json.JSONArray;

import com.ftms.entity.Results;
import com.ftms.service.ResultsService;
import com.opensymphony.xwork2.ActionSupport;

public class KspsAction extends ActionSupport {
	private ResultsService resultsService;
	private JSONArray kspsJson;
	private String username;
	private String achievement;
	private int total;
	private int real;
	private int approval;
	private int opposition;
	private String time1;
	private String level;
	private String number;
	private String  time2;
	private Float writescore;
	private Float interviewscore;
	private Float totalscore;
	public String getAchievement() {
		return achievement;
	}
	public void setAchievement(String achievement) {
		this.achievement = achievement;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public int getReal() {
		return real;
	}
	public void setReal(int real) {
		this.real = real;
	}
	public int getApproval() {
		return approval;
	}
	public void setApproval(int approval) {
		this.approval = approval;
	}
	public int getOpposition() {
		return opposition;
	}
	public void setOpposition(int opposition) {
		this.opposition = opposition;
	}
	public String getLevel() {
		return level;
	}
	public void setLevel(String level) {
		this.level = level;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public Float getWritescore() {
		return writescore;
	}
	public void setWritescore(Float writescore) {
		this.writescore = writescore;
	}
	public Float getInterviewscore() {
		return interviewscore;
	}
	public void setInterviewscore(Float interviewscore) {
		this.interviewscore = interviewscore;
	}
	public Float getTotalscore() {
		return totalscore;
	}
	public void setTotalscore(Float totalscore) {
		this.totalscore = totalscore;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public ResultsService getResultsService() {
		return resultsService;
	}
	public void setResultsService(ResultsService resultsService) {
		this.resultsService = resultsService;
	}
	public JSONArray getKspsJson() {
		return kspsJson;
	}
	public void setKspsJson(JSONArray kspsJson) {
		this.kspsJson = kspsJson;
	}
	
	public String kspsload(){
		this.kspsJson=resultsService.getAll();
		return "kspsload";
	}
	public String getTime1() {
		return time1;
	}
	public void setTime1(String time1) {
		this.time1 = time1;
	}
	public String getTime2() {
		return time2;
	}
	public void setTime2(String time2) {
		this.time2 = time2;
	}
	public String kspsAdd(){
		String[]  time =time1.split("/");
		String tsStr =time[2]+"-"+time[0]+"-"+time[1]+" 00:00:00";
		String[]  time3 =time2.split("/");
		String tsStr1 =time3[2]+"-"+time3[0]+"-"+time3[1]+" 00:00:00";
		Results r=new Results();
		r.setAchievement(achievement);
		r.setApproval(approval);
		r.setChecktime(Timestamp.valueOf(tsStr));
		r.setFazhengtime(Timestamp.valueOf(tsStr1));
		r.setInterviewscore(interviewscore);
		r.setLevel(level);
		r.setNumber(number);
		r.setOpposition(opposition);
		r.setCanjia(real);
		r.setTotal(total);
		r.setTotalscore(totalscore);
		r.setWritescore(writescore);
		resultsService.SaveResult(username, r);
		return "kspsAdd";
	}
}
