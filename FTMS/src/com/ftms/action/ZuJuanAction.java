package com.ftms.action;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLDecoder;
import java.util.List;
import java.util.Properties;
import java.util.UUID;



import com.ftms.dao.ShitiDAO;
import com.ftms.entity.Tiku;
import com.ftms.entity.Shiti;
import com.ftms.service.ZuJuanService;
import com.opensymphony.xwork2.ActionSupport;

public class ZuJuanAction extends ActionSupport {
	private ZuJuanService zujuanService;
	private ShitiDAO shitiDAO;
	private List<Tiku> xuanze;
	private List<Tiku> panduan;
	private String class1;
	private String profession;
	private String difficulty;
	private int xuanzecount;
	private int panduancount;
	private int score_xuanze;
	private int score_panduan;
	private int total;
	private int time;
	private String sjbh;

	public ShitiDAO getShitiDAO() {
		return shitiDAO;
	}

	public void setShitiDAO(ShitiDAO shitiDAO) {
		this.shitiDAO = shitiDAO;
	}

	public ZuJuanService getZujuanService() {
		return zujuanService;
	}

	public void setZujuanService(ZuJuanService zujuanService) {
		this.zujuanService = zujuanService;
	}

	public List<Tiku> getXuanze() {
		return xuanze;
	}

	public void setXuanze(List<Tiku> xuanze) {
		this.xuanze = xuanze;
	}

	public List<Tiku> getPanduan() {
		return panduan;
	}

	public void setPanduan(List<Tiku> panduan) {
		this.panduan = panduan;
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

	public String getSjbh() {
		return sjbh;
	}

	public void setSjbh(String sjbh) {
		this.sjbh = sjbh;
	}

	public String zuJuan() {
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
		this.xuanze = zujuanService.getXuanze(this.profession, this.difficulty,xuanzecount);
		this.panduan = zujuanService.getPanduan(this.profession, this.difficulty,panduancount);
		
		//生成试卷，插入数据库
		Shiti shiti;
		int rank=1;
		this.sjbh=UUID.randomUUID().toString();
		for(Tiku t:xuanze){
			shiti=new Shiti();
			shiti.setSjbh(this.sjbh);
			shiti.setQuestionrank(rank);
			shiti.setShitiid(t.getId());
			shiti.setQuestionType(t.getQuestionType());
			shiti.setQuestion(t.getQuestion());
			shiti.setAnswer(t.getAnswer());
			if("A".equals(t.getAnswer())){
				shiti.setAnswercontent(t.getSelectionA());
			}else if("B".equals(t.getAnswer())){
				shiti.setAnswercontent(t.getSelectionB());
			}else if("C".equals(t.getAnswer())){
				shiti.setAnswercontent(t.getSelectionC());
			}else if("D".equals(t.getAnswer())){
				shiti.setAnswercontent(t.getSelectionD());
			}
			shitiDAO.save(shiti);
			rank++;
		}
		for(Tiku t:panduan){
			shiti=new Shiti();
			shiti.setSjbh(this.sjbh);
			shiti.setQuestionrank(rank);
			shiti.setShitiid(t.getId());
			shiti.setQuestionType(t.getQuestionType());
			shiti.setQuestion(t.getQuestion());
			shiti.setAnswer(t.getAnswer());
			if("T".equals(t.getAnswer())){
				shiti.setAnswercontent("正确");
			}else{
				shiti.setAnswercontent("错误");
			}
			shitiDAO.save(shiti);
			rank++;
		}
		return "zujuan";
	}
}
