package cn.nwsuaf.gov.teacherManage;

import java.io.File;
import java.util.List;

import org.apache.struts2.ServletActionContext;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.opensymphony.xwork2.ActionSupport;

import cn.nwsuaf.gov.model.Train_Base;
import cn.nwsuaf.gov.service.BusinessFactory;
import cn.nwsuaf.gov.service.HibernateSessionFactory;
import cn.nwsuaf.gov.service.TrainBaseBusiness;
import cn.nwsuaf.gov.service.TrainBaseService;

public class EditBaseInfo extends ActionSupport {
	private int base_id;
	private Train_Base tb;
	
	private int baseid;
	private String basename;
	private String contact;
	private String inputNote;
	private String base_path1;
	private String base_path2;
	
	public String xxwh() throws Exception{
		TrainBaseBusiness ttbusi = BusinessFactory
				.createTrainBaseBussiness();
		setTb(ttbusi.getTrainBase(base_id));
		return "success";
	}
	
	public String editBase() throws HibernateException, Exception{
		Train_Base tb = new Train_Base();
		tb.setBase_contact(contact);
		tb.setBase_name(basename);
		tb.setBase_profile(inputNote);
		tb.setBase_path1(base_path1);
		tb.setBase_path2(base_path2);
		tb.setBase_id(baseid);
		TrainBaseService tbs = new TrainBaseService();
		tbs.update(tb);
		return "success";
		
	}
	
	public int getBaseid() {
		return baseid;
	}

	public void setBaseid(int baseid) {
		this.baseid = baseid;
	}

	public int getBase_id() {
		return base_id;
	}
	public void setBase_id(int base_id) {
		this.base_id = base_id;
	}
	public Train_Base getTb() {
		return tb;
	}
	public void setTb(Train_Base tb) {
		this.tb = tb;
	}
	public String getBasename() {
		return basename;
	}
	public void setBasename(String basename) {
		this.basename = basename;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public String getInputNote() {
		return inputNote;
	}
	public void setInputNote(String inputNote) {
		this.inputNote = inputNote;
	}
	public String getBase_path1() {
		return base_path1;
	}
	public void setBase_path1(String base_path1) {
		this.base_path1 = base_path1;
	}
	public String getBase_path2() {
		return base_path2;
	}
	public void setBase_path2(String base_path2) {
		this.base_path2 = base_path2;
	}

}
