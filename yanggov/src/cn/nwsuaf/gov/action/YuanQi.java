package cn.nwsuaf.gov.action;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import cn.nwsuaf.gov.DAO.Xinxidao;
import cn.nwsuaf.gov.bean.Xinxi;
import org.hibernate.HibernateException;
import com.opensymphony.xwork2.ActionSupport;

public class YuanQi extends ActionSupport {
	private List<Xinxi> tealist;

	public List<Xinxi> getTealist() {
		return tealist;
	}

	public void setTealist(List<Xinxi> tealist) {
		this.tealist = tealist;
	}

	private String msg;
	private Xinxi tzhi;
	private Map session;
	private int pageNow = 1;
	private int pageSize = 27;
	private int pageCount;

	private int base_id;
	private String professpath;

	public String getProfesspath() {
		return professpath;
	}

	public void setProfesspath(String professpath) {
		this.professpath = professpath;
	}

	public HttpServletRequest getRequest() {
		return request;
	}

	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}

	public Xinxidao getTtbusi() {
		return ttbusi;
	}

	public void setTtbusi(Xinxidao ttbusi) {
		this.ttbusi = ttbusi;
	}

	public int getBase_id() {
		return base_id;
	}

	public void setBase_id(int base_id) {
		this.base_id = base_id;
	}

	private HttpServletRequest request;
	Xinxidao ttbusi = new Xinxidao();

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Xinxi getTzhi() {
		return tzhi;
	}

	public void setTzhi(Xinxi tzhi) {
		this.tzhi = tzhi;
	}

	public Map getSession() {
		return session;
	}

	public void setSession(Map session) {
		this.session = session;
	}

	// request的setter函数
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

	// 查找前台企业信息
	public String findQy() {
		// System.out.println("getTongzhi()===========22222===============");
		List<Xinxi> cv = null;
		try {
			setPageCount(ttbusi.getTotalRowsQy(pageSize));
		} catch (HibernateException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			cv = ttbusi.findByPageQy(pageSize, pageNow);
		} catch (Exception e) {
			e.printStackTrace();
		}
		this.setTealist(cv);

		return SUCCESS;
	}

	// 查找前台园区信息
	public String findYq() {
		List<Xinxi> cv = null;
		try {
			setPageCount(ttbusi.getTotalRowsYq(pageSize));
		} catch (HibernateException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			cv = ttbusi.findByPageYq(pageSize, pageNow);
		} catch (Exception e) {
			e.printStackTrace();
		}
		this.setTealist(cv);

		return SUCCESS;
	}

	// 后台列表显示
	public String findBack() {
		List<Xinxi> cv = null;
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

	// 主页列表显示
	public String findbe() {
		setPageSize(5);
		List<Xinxi> cv = null;
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
		List<Xinxi> cv;

		ttbusi.delete(base_id);
		setPageCount(ttbusi.getTotalRows(pageSize));
		cv = ttbusi.findByPage(pageSize, pageNow);
		this.setTealist(cv);
		return SUCCESS;
	}

	public String findById() throws Exception {

		setTzhi(ttbusi.getXinxi(base_id));
		return SUCCESS;
	}

	// 审核函数
//	public void ShenHe() {
//		Xinxidao xx = new Xinxidao();
//		xx.update(base_id);
//	}

}
