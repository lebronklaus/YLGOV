package cn.nwsuaf.gov.action;

import cn.nwsuaf.gov.DAO.RenCaidao;
import cn.nwsuaf.gov.bean.RenCaiXuQiu;

public class RenCaiAddAction {
	private String gangwei;
	private String renshu; 
	private String daogangtime ;
	private String salary ;
	private String discrip ;
	private String sex ;
	private String agerank ;
	private String xueli ;
	private String major;
	private String experience ;
	private String shuoming ;
	private String mark ;
	
	public String addRenCai() throws Exception{
		RenCaiXuQiu rc = new RenCaiXuQiu();
		rc.setGangwei(gangwei);
		rc.setRenshu(renshu);
		rc.setDaogangtime(daogangtime);
		rc.setSalary(salary);
		rc.setDiscrip(discrip);
		rc.setSex(sex);
		rc.setAgerank(agerank);
		rc.setXueli(xueli);
		rc.setMajor(major);
		rc.setExperience(experience);
		rc.setShuoming(shuoming);
		rc.setShenhe("0");
		rc.setMark(Integer.parseInt(mark));
		RenCaidao rcd = new RenCaidao();
		rcd.add(rc);
		return "success";
	}
	public String getGangwei() {
		return gangwei;
	}
	public void setGangwei(String gangwei) {
		this.gangwei = gangwei;
	}
	public String getRenshu() {
		return renshu;
	}
	public void setRenshu(String renshu) {
		this.renshu = renshu;
	}
	public String getDaogangtime() {
		return daogangtime;
	}
	public void setDaogangtime(String daogangtime) {
		this.daogangtime = daogangtime;
	}
	public String getSalary() {
		return salary;
	}
	public void setSalary(String salary) {
		this.salary = salary;
	}
	public String getDiscrip() {
		return discrip;
	}
	public void setDiscrip(String discrip) {
		this.discrip = discrip;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getAgerank() {
		return agerank;
	}
	public void setAgerank(String agerank) {
		this.agerank = agerank;
	}
	public String getXueli() {
		return xueli;
	}
	public void setXueli(String xueli) {
		this.xueli = xueli;
	}
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}
	public String getExperience() {
		return experience;
	}
	public void setExperience(String experience) {
		this.experience = experience;
	}
	public String getShuoming() {
		return shuoming;
	}
	public void setShuoming(String shuoming) {
		this.shuoming = shuoming;
	}
	public String getMark() {
		return mark;
	}
	public void setMark(String mark) {
		this.mark = mark;
	}

}
