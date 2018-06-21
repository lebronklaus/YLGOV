package cn.nwsuaf.gov.teacherManage;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import cn.nwsuaf.gov.model.Train_Base;
import cn.nwsuaf.gov.service.BasDele;
import cn.nwsuaf.gov.service.BusinessFactory;
import cn.nwsuaf.gov.service.TrainBaseBusiness;

import org.hibernate.HibernateException;
import com.opensymphony.xwork2.ActionSupport;

public class BaseUtils extends ActionSupport {
	private List<Train_Base> tealist;

	public List<Train_Base> getTealist() {
		return tealist;
	}

	public void setTealist(List<Train_Base> tealist) {
		this.tealist = tealist;
	}

	private String msg;
	private Train_Base tzhi;
	private Map session;
	private int pageNow = 1;
	private int pageSize = 27;
	private int pageCount;

	private int base_id;

	public int getBase_id() {
		return base_id;
	}

	public void setBase_id(int base_id) {
		this.base_id = base_id;
	}

	private HttpServletRequest request;
	TrainBaseBusiness ttbusi = BusinessFactory.createTrainBaseBussiness();

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Train_Base getTzhi() {
		return tzhi;
	}

	public void setTzhi(Train_Base tzhi) {
		this.tzhi = tzhi;
	}

	public Map getSession() {
		return session;
	}

	public void setSession(Map session) {
		this.session = session;
	}

	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}

	public int getPageNow() {
		return pageNow;
	}

	public void setPageNow(int pageNow) {
		this.pageNow = pageNow;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getPageCount() {
		return pageCount;
	}

	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}

	public String find() {
		List<Train_Base> cv = null;
		try {
			setPageCount(ttbusi.getTotalRows(pageSize));
		} catch (HibernateException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			cv = ttbusi.findByPage(pageSize, pageNow);
		} catch (Exception e) {
			e.printStackTrace();
		}
		this.setTealist(cv);

		return SUCCESS;
	}

	// ��̨�б���ʾ
	public String findBack() {
		List<Train_Base> cv = null;
		try {
			setPageCount(ttbusi.getTotalRows(pageSize));
		} catch (HibernateException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			cv = ttbusi.findByPage(pageSize, pageNow);
		} catch (Exception e) {
			e.printStackTrace();
		}
		this.setTealist(cv);

		return SUCCESS;
	}

	public String delete() throws Exception {
		List<Train_Base> cv;
		BasDele bd = new BasDele();
		bd.deleBse(base_id);
		setPageCount(ttbusi.getTotalRows(pageSize));
		cv = ttbusi.findByPage(pageSize, pageNow);
		this.setTealist(cv);
		return SUCCESS;
	}

	public String findById() throws Exception {
		TrainBaseBusiness ttbusi = BusinessFactory.createTrainBaseBussiness();
		setTzhi(ttbusi.getTrainBase(base_id));
		return SUCCESS;
	}

	public String findByIdEdit() throws Exception {
		TrainBaseBusiness ttbusi = BusinessFactory.createTrainBaseBussiness();
		setTzhi(ttbusi.getTrainBase(base_id));
		return SUCCESS;
	}

}
