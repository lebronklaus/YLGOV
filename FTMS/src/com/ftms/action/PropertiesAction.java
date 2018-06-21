package com.ftms.action;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLDecoder;
import java.util.Properties;

import com.opensymphony.xwork2.ActionSupport;

public class PropertiesAction extends ActionSupport{
	private int xuanzecount;
	private int panduancount;
	private int score_xuanze;
	private int score_panduan;
	private int total;
	private int time;
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
	public String index(){
		getProperties();
		return "index";	
	}
	public String tiku(){
		getProperties();
		return "tiku";	
	}
	public String saveprops(){
		setProperties();
		return "saveprops";	
	}
	public void getProperties(){
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
	}
	public void setProperties(){
		try { 
			OutputStream out = new FileOutputStream(URLDecoder.decode(this.getClass().getResource("/").getPath(), "UTF-8")+"config.properties");
			Properties prop = new Properties();
			prop.setProperty("xuanzecount",xuanzecount+"");
			prop.setProperty("panduancount",panduancount+"");
			prop.setProperty("score_xuanze",score_xuanze+"");
			prop.setProperty("score_panduan",score_panduan+"");
			prop.setProperty("time",time+"");
			prop.store(out, "saved");
			out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
