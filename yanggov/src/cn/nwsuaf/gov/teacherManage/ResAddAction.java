package cn.nwsuaf.gov.teacherManage;

import com.opensymphony.xwork2.ActionSupport;

import cn.nwsuaf.gov.service.BusinessFactory;
import cn.nwsuaf.gov.service.TrainResourceBusiness;

public class ResAddAction extends ActionSupport {
	private String res_title;
    private String res_colum;
    private String res_author;
    private String res_from; 
    private String res_profile; 
    private String res_path;
    
    
    public String addRes() throws Exception{
    	TrainResourceBusiness ttbusi = BusinessFactory
    			.createTrainResourceBussiness();
    	ttbusi.add(res_title, res_colum, res_from, res_author, res_profile, res_path);
    	return "success";
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
