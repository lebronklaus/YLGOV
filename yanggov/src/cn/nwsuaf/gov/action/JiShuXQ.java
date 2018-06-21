package cn.nwsuaf.gov.action;

import cn.nwsuaf.gov.DAO.JiShudao;
import cn.nwsuaf.gov.bean.JiShuPeiXun;

import com.opensymphony.xwork2.ActionSupport;

public class JiShuXQ extends ActionSupport {
	private JiShuPeiXun js;

	public JiShuPeiXun getJs() {
		return js;
	}

	public void setJs(JiShuPeiXun js) {
		this.js = js;
	}

	@Override
	public String execute() {

		JiShudao jsdao = new JiShudao();
		try {
			jsdao.add(getJs());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return SUCCESS;

	}

}
