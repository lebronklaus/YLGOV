package cn.nwsuaf.gov.action;

import cn.nwsuaf.gov.DAO.Xinxidao;
import cn.nwsuaf.gov.bean.Xinxi;

import com.opensymphony.xwork2.ActionSupport;

public class XinxiBianji extends ActionSupport {

	public Xinxi xin;

	public Xinxi getXin() {
		return xin;
	}

	public void setXin(Xinxi xin) {
		this.xin = xin;
	}

	@Override
	public String execute() {
		Xinxidao xdao = new Xinxidao();
		try {
			xdao.add(getXin());
		} catch (Exception e) {
			e.printStackTrace();
		}

		return SUCCESS;
	}
}
