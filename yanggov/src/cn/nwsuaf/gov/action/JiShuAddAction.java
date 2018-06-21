package cn.nwsuaf.gov.action;

import cn.nwsuaf.gov.DAO.JiShudao;
import cn.nwsuaf.gov.bean.JiShuPeiXun;

public class JiShuAddAction {
	private String mingcheng; 
	private String lingyu; 
	private String inputNote;
	private String company; 
	private String address;
	private String companytype; 
	private String hangye; 
	private String lianxiren; 
	private String tel; 
	private String lianxiadd;
	private String youbian;
	private String email; 
	private String mark;
	
	
	public String addJiShu() throws Exception{

		JiShuPeiXun jspx = new JiShuPeiXun();
		jspx.setMingcheng(mingcheng);
		jspx.setLingyu(lingyu);
		jspx.setShuoming(inputNote);
		jspx.setCompany(company);
		jspx.setAddress(address);
		jspx.setCompanytype(companytype);
		jspx.setHangye(hangye);
		jspx.setLianxiren(lianxiren);
		jspx.setTel(tel);
		jspx.setLianxiadd(lianxiadd);
		jspx.setYoubian(youbian);
		jspx.setEmail(email);
		jspx.setShenhe("0");
		jspx.setMark(Integer.parseInt(mark));
		JiShudao jsd = new JiShudao();
		jsd.add(jspx);
		return "success";
	}
	public String getMingcheng() {
		return mingcheng;
	}
	public void setMingcheng(String mingcheng) {
		this.mingcheng = mingcheng;
	}
	public String getLingyu() {
		return lingyu;
	}
	public void setLingyu(String lingyu) {
		this.lingyu = lingyu;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCompanytype() {
		return companytype;
	}
	public void setCompanytype(String companytype) {
		this.companytype = companytype;
	}
	public String getHangye() {
		return hangye;
	}
	public void setHangye(String hangye) {
		this.hangye = hangye;
	}
	public String getLianxiren() {
		return lianxiren;
	}
	public void setLianxiren(String lianxiren) {
		this.lianxiren = lianxiren;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getLianxiadd() {
		return lianxiadd;
	}
	public void setLianxiadd(String lianxiadd) {
		this.lianxiadd = lianxiadd;
	}
	public String getYoubian() {
		return youbian;
	}
	public void setYoubian(String youbian) {
		this.youbian = youbian;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMark() {
		return mark;
	}
	public void setMark(String mark) {
		this.mark = mark;
	}
	public String getInputNote() {
		return inputNote;
	}
	public void setInputNote(String inputNote) {
		this.inputNote = inputNote;
	}
	

}
