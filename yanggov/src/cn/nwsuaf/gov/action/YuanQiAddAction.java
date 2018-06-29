package cn.nwsuaf.gov.action;

import cn.nwsuaf.gov.DAO.Xinxidao;
import cn.nwsuaf.gov.bean.Xinxi;


public class YuanQiAddAction {
	private String name; 
	private String fuzeren;
	private String tel;
	private String address; 
	private String inputNote; 
	private String yq_path1;
	private String yq_path2;
	private String mark;
	
	public String addYuanQi() throws Exception{
		Xinxi xx = new Xinxi();
		xx.setName(name);
		xx.setFuzeren(fuzeren);
		xx.setTel(tel);
		xx.setAddress(address);
		xx.setIntro(inputNote);
		xx.setPath1(yq_path1);
		xx.setPath2(yq_path2);
		xx.setMark(Integer.parseInt(mark));
		xx.setShenhe("1");
		Xinxidao xxd = new Xinxidao();
		xxd.add(xx);
		return "success";
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getFuzeren() {
		return fuzeren;
	}
	public void setFuzeren(String fuzeren) {
		this.fuzeren = fuzeren;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getInputNote() {
		return inputNote;
	}
	public void setInputNote(String inputNote) {
		this.inputNote = inputNote;
	}
	public String getYq_path1() {
		return yq_path1;
	}
	public void setYq_path1(String yq_path1) {
		this.yq_path1 = yq_path1;
	}
	public String getYq_path2() {
		return yq_path2;
	}
	public void setYq_path2(String yq_path2) {
		this.yq_path2 = yq_path2;
	}
	public String getMark() {
		return mark;
	}
	public void setMark(String mark) {
		this.mark = mark;
	}
	
}
