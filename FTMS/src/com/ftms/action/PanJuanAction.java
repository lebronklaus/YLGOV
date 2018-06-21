package com.ftms.action;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLDecoder;
import java.util.List;
import java.util.Properties;

import net.sf.json.JSONArray;

import com.ftms.entity.Shiti;
import com.ftms.service.PanJuanService;
import com.opensymphony.xwork2.ActionSupport;

public class PanJuanAction extends ActionSupport {
	private PanJuanService panJuanService;
	private List<Shiti> xuanze;
	private List<Shiti> panduan;
	private JSONArray miss;
	private String sjbh;
	private int shitiid;
	private String useranswer;
	private String useranswercontent;
	private int xuanzecount;
	private int panduancount;
	private int score_xuanze;
	private int score_panduan;
	private int total;
	private int score;
	private String class1;
	private String profession;
	private String difficulty;
	private int time;
	
	public PanJuanService getPanJuanService() {
		return panJuanService;
	}
	public void setPanJuanService(PanJuanService panJuanService) {
		this.panJuanService = panJuanService;
	}
	public String getSjbh() {
		return sjbh;
	}
	public void setSjbh(String sjbh) {
		this.sjbh = sjbh;
	}
	public int getShitiid() {
		return shitiid;
	}
	public void setShitiid(int shitiid) {
		this.shitiid = shitiid;
	}
	public String getUseranswer() {
		return useranswer;
	}
	public void setUseranswer(String useranswer) {
		this.useranswer = useranswer;
	}

	public String getUseranswercontent() {
		return useranswercontent;
	}
	public void setUseranswercontent(String useranswercontent) {
		this.useranswercontent = useranswercontent;
	}

	public List<Shiti> getXuanze() {
		return xuanze;
	}
	public void setXuanze(List<Shiti> xuanze) {
		this.xuanze = xuanze;
	}
	public List<Shiti> getPanduan() {
		return panduan;
	}
	public void setPanduan(List<Shiti> panduan) {
		this.panduan = panduan;
	}
	
	public int getXuanzecount() {
		return xuanzecount;
	}
	public void setXuanzecount(int xuanzecount) {
		this.xuanzecount = xuanzecount;
	}
	public int getPanduancount() {
		return panduancount;
	}
	public void setPanduancount(int panduancount) {
		this.panduancount = panduancount;
	}
	public int getScore_xuanze() {
		return score_xuanze;
	}
	public void setScore_xuanze(int score_xuanze) {
		this.score_xuanze = score_xuanze;
	}
	public int getScore_panduan() {
		return score_panduan;
	}
	public void setScore_panduan(int score_panduan) {
		this.score_panduan = score_panduan;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public int getTime() {
		return time;
	}
	public void setTime(int time) {
		this.time = time;
	}
	
	public String getClass1() {
		return class1;
	}
	public void setClass1(String class1) {
		this.class1 = class1;
	}
	public String getProfession() {
		return profession;
	}
	public void setProfession(String profession) {
		this.profession = profession;
	}
	public String getDifficulty() {
		return difficulty;
	}
	public void setDifficulty(String difficulty) {
		this.difficulty = difficulty;
	}
	
	public JSONArray getMiss() {
		return miss;
	}
	public void setMiss(JSONArray miss) {
		this.miss = miss;
	}
	public String panti(){
		Shiti shijuan=new Shiti();
		shijuan.setSjbh(this.sjbh);
		shijuan.setShitiid(this.shitiid);
		shijuan.setUseranswer(this.useranswer);
		shijuan.setUseranswercontent(this.useranswercontent);
		panJuanService.panti(shijuan);
		return "panti";
	}
	public String panjuan(){
		try { 
			InputStream in = new FileInputStream( (URLDecoder.decode(this.getClass().getResource("/").getPath(), "UTF-8")+"config.properties"));
			Properties prop = new Properties();
			prop.load(in);
			this.xuanzecount=Integer.parseInt(prop.getProperty("xuanzecount")) ;
			this.panduancount=Integer.parseInt(prop.getProperty("panduancount"));
			this.score_xuanze=Integer.parseInt(prop.getProperty("score_xuanze"));
			this.score_panduan=Integer.parseInt(prop.getProperty("score_panduan"));
			this.time=Integer.parseInt(prop.getProperty("time"));
			this.total=xuanzecount*score_xuanze+panduancount*score_panduan;
			in.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.xuanze=panJuanService.getXuanze(this.sjbh);
		this.panduan=panJuanService.getPanduan(this.sjbh);
		panJuanService.deleteShijuan(this.sjbh);
		int xuanzescore=0;
		int panduanscore=0;
		for(Shiti s:xuanze){
			if(s.getAnswer().equals(s.getUseranswer())){
				xuanzescore+=this.score_xuanze;
			}
		}
		for(Shiti s:panduan){
			if(s.getAnswer().equals(s.getUseranswer())){
				panduanscore+=this.score_panduan;
			}
		}
		this.score=xuanzescore+panduanscore;
		return "panjuan";
	}
	public String unload(){
		panJuanService.deleteShijuan(this.sjbh);
		return "unload";
	}
	public String miss(){
		this.miss=panJuanService.getMiss(sjbh);
		return "miss";
	}
}
