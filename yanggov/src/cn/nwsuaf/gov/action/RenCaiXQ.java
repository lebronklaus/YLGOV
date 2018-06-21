package cn.nwsuaf.gov.action;

import com.opensymphony.xwork2.ActionSupport;

import cn.nwsuaf.gov.DAO.RenCaidao;
import cn.nwsuaf.gov.bean.RenCaiXuQiu;

public class RenCaiXQ extends ActionSupport {
	private RenCaiXuQiu rc;

	public RenCaiXuQiu getRc() {
		return rc;
	}

	public void setRc(RenCaiXuQiu rc) {
		this.rc = rc;
	}

	@Override
	public String execute() {

		RenCaidao rcdao = new RenCaidao();
		try {
			rcdao.add(getRc());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return SUCCESS;

	}

}
