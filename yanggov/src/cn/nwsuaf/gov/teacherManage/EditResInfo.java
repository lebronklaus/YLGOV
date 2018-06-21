package cn.nwsuaf.gov.teacherManage;

import org.hibernate.HibernateException;

import com.opensymphony.xwork2.ActionSupport;

import cn.nwsuaf.gov.model.Train_Base;
import cn.nwsuaf.gov.model.Train_Resource;
import cn.nwsuaf.gov.service.BusinessFactory;
import cn.nwsuaf.gov.service.TrainBaseBusiness;
import cn.nwsuaf.gov.service.TrainBaseService;
import cn.nwsuaf.gov.service.TrainResService;
import cn.nwsuaf.gov.service.TrainResourceBusiness;

public class EditResInfo extends ActionSupport{
	private int id ;
	private Train_Resource tr;
	
	private int res_id;
	private String res_title;
    private String res_colum;
    private String res_author;
    private String res_from; 
    private String res_profile; 
    private String res_path;
    
    
    public String xxwh() throws Exception{
    	TrainResourceBusiness ttbusi = BusinessFactory
    			.createTrainResourceBussiness();
		setTr(ttbusi.getTrainResource(id));
		return "success";
	}
    
    public String editRes() throws HibernateException, Exception{
    	Train_Resource tr = new Train_Resource();
    	tr.setResources_title(res_title);
    	tr.setResources_colum(res_colum);
    	tr.setResources_author(res_author);
    	tr.setResources_from(res_from);
    	tr.setResources_profile(res_profile);
    	tr.setResources_path(res_path);
    	tr.setResources_id(res_id);
    	
		TrainResService trs = new TrainResService();
		trs.update(tr);
		return "success";
		
	}
    
    
    
    
    
    
    
    
    
    
    
    
    
    
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Train_Resource getTr() {
		return tr;
	}
	public void setTr(Train_Resource tr) {
		this.tr = tr;
	}
	public int getRes_id() {
		return res_id;
	}
	public void setRes_id(int res_id) {
		this.res_id = res_id;
	}
	public String getRes_title() {
		return res_title;
	}
	public void setRes_title(String res_title) {
		this.res_title = res_title;
	}
	public String getRes_colum() {
		return res_colum;
	}
	public void setRes_colum(String res_colum) {
		this.res_colum = res_colum;
	}
	public String getRes_author() {
		return res_author;
	}
	public void setRes_author(String res_author) {
		this.res_author = res_author;
	}
	public String getRes_from() {
		return res_from;
	}
	public void setRes_from(String res_from) {
		this.res_from = res_from;
	}
	public String getRes_profile() {
		return res_profile;
	}
	public void setRes_profile(String res_profile) {
		this.res_profile = res_profile;
	}
	public String getRes_path() {
		return res_path;
	}
	public void setRes_path(String res_path) {
		this.res_path = res_path;
	}
    
	

}
