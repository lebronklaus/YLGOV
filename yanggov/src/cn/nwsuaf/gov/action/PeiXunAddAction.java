package cn.nwsuaf.gov.action;

import cn.nwsuaf.gov.DAO.PeiXundao;
import cn.nwsuaf.gov.bean.PeiXunXuQiu;

public class PeiXunAddAction {
	private String companyname;
	private String lianxiren;
	private String tel;
	private String chuanzhen;
	private String peixunadd;
	private String guimo;
	private String peiheshixiang;
	private String email;
	private String mark;
	private String time;
	private String inputNote;
	
	private int id;
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String addPeiXun() throws Exception{
		PeiXunXuQiu px = new PeiXunXuQiu();
		px.setCompanyname(companyname);
		px.setLianxiren(lianxiren);
		px.setTel(tel);
		px.setChuanzhen(chuanzhen);
		px.setPeixunadd(peixunadd);
		px.setGuimo(guimo);
		px.setPeiheshixiang(peiheshixiang);
		px.setEmail(email);
		px.setMark(Integer.parseInt(mark));
		px.setContent(inputNote);
		px.setShenhe("1");
		px.setTime(time);
		PeiXundao pxd = new PeiXundao();
		pxd.add(px);
		return "success";
	}
	
	public String editPeiXun() throws Exception{
		PeiXunXuQiu px = new PeiXunXuQiu();
		px.setCompanyname(companyname);
		px.setLianxiren(lianxiren);
		px.setTel(tel);
		px.setChuanzhen(chuanzhen);
		px.setPeixunadd(peixunadd);
		px.setGuimo(guimo);
		px.setPeiheshixiang(peiheshixiang);
		px.setEmail(email);
		px.setMark(Integer.parseInt(mark));
		px.setContent(inputNote);
		px.setId(id);
		px.setTime(time);
		PeiXundao pxd = new PeiXundao();
		pxd.update(px);
		return "success";
	}
	
	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getCompanyname() {
		return companyname;
	}
	public void setCompanyname(String companyname) {
		this.companyname = companyname;
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
	public String getChuanzhen() {
		return chuanzhen;
	}
	public void setChuanzhen(String chuanzhen) {
		this.chuanzhen = chuanzhen;
	}
	public String getPeixunadd() {
		return peixunadd;
	}
	public void setPeixunadd(String peixunadd) {
		this.peixunadd = peixunadd;
	}
	public String getGuimo() {
		return guimo;
	}
	public void setGuimo(String guimo) {
		this.guimo = guimo;
	}
	public String getPeiheshixiang() {
		return peiheshixiang;
	}
	public void setPeiheshixiang(String peiheshixiang) {
		this.peiheshixiang = peiheshixiang;
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
