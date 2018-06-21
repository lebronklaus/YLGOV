package cn.nwsuaf.gov.teacherManage;

import com.opensymphony.xwork2.ActionSupport;

import cn.nwsuaf.gov.service.BusinessFactory;
import cn.nwsuaf.gov.service.TrainBaseBusiness;

public class BaseAddAction extends ActionSupport {
	private String basename;
	private String contact;
	private String inputNote;
	private String base_path1;
	private String base_path2;
	
	public String addBase() throws Exception{
		TrainBaseBusiness ttbusi = BusinessFactory
				.createTrainBaseBussiness();
		ttbusi.add(basename, inputNote,contact,base_path1,base_path2);
		return "success";
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
