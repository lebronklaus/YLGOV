package cn.nwsuaf.gov.action;

import com.opensymphony.xwork2.ActionSupport;

import cn.nwsuaf.gov.DAO.PeiXundao;
import cn.nwsuaf.gov.bean.PeiXunXuQiu;

public class PeiXunXQ extends ActionSupport {
	private PeiXunXuQiu px;
	private int id;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public PeiXunXuQiu getPx() {
		return px;
	}

	public void setPx(PeiXunXuQiu px) {
		this.px = px;
	}

	@Override
	public String execute() {

		PeiXundao jsdao = new PeiXundao();
		try {
			jsdao.add(getPx());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return SUCCESS;

	}

//	public void shenyes() {
//		PeiXundao news = new PeiXundao();
//		System.out.println("fdfgdgdwkwkw" + id);
//		news.update(id);
//	}

}
