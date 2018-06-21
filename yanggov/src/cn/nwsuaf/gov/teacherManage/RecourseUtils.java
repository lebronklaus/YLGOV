package cn.nwsuaf.gov.teacherManage;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import cn.nwsuaf.gov.model.Train_Resource;
import cn.nwsuaf.gov.service.BusinessFactory;
import cn.nwsuaf.gov.service.ResDele;
import cn.nwsuaf.gov.service.TrainResourceBusiness;

import org.apache.struts2.ServletActionContext;
import org.hibernate.HibernateException;
import com.opensymphony.xwork2.ActionSupport;

public class RecourseUtils extends ActionSupport {
	private List<Train_Resource> tealist;
	private List<Train_Resource> veadiolist;
	private List<Train_Resource> brolist;
	private List<Train_Resource> worlist;
	private String professpath;

	private String servip;

	public String getServip() {
		return servip;
	}

	public void setServip(String servip) {
		this.servip = servip;
	}

	public String getProfesspath() {
		return professpath;
	}

	public void setProfesspath(String professpath) {
		this.professpath = professpath;
	}

	private String path;

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	private int flag;// 专家视频为0，广播演讲1，专家文稿2

	public int getFlag() {
		return flag;
	}

	public void setFlag(int flag) {
		this.flag = flag;
	}

	public List<Train_Resource> getTealist() {
		return tealist;
	}

	public void setTealist(List<Train_Resource> tealist) {
		this.tealist = tealist;
	}

	private String msg;
	private Train_Resource tzhi;
	private Map session;

	public List<Train_Resource> getVeadiolist() {
		return veadiolist;
	}

	public void setVeadiolist(List<Train_Resource> veadiolist) {
		this.veadiolist = veadiolist;
	}

	public List<Train_Resource> getBrolist() {
		return brolist;
	}

	public void setBrolist(List<Train_Resource> brolist) {
		this.brolist = brolist;
	}

	public List<Train_Resource> getWorlist() {
		return worlist;
	}

	public void setWorlist(List<Train_Resource> worlist) {
		this.worlist = worlist;
	}

	private int pageNow = 1;
	private int pageSize = 15;
	private int pageCount;

	private int resources_id;

	public int getResources_id() {
		return resources_id;
	}

	public void setResources_id(int resources_id) {
		this.resources_id = resources_id;
	}

	private HttpServletRequest request;
	TrainResourceBusiness ttbusi = BusinessFactory
			.createTrainResourceBussiness();

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Train_Resource getTzhi() {
		return tzhi;
	}

	public void setTzhi(Train_Resource tzhi) {
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
		
		int l = 0;
		int m = 0;
		int n = 0;

		setProfesspath(professpath);
		List<Train_Resource> cv = null;
		try {
			setPageCount(ttbusi.getTotalRows(pageSize));
		} catch (HibernateException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			cv = ttbusi.findByPage(pageSize * 100, pageNow);
		} catch (Exception e) {
			e.printStackTrace();
		}
		// this.setTealist(cv);
		List<Train_Resource> veadiolisttemp = new ArrayList<Train_Resource>();
		List<Train_Resource> brolisttmp = new ArrayList<Train_Resource>();
		List<Train_Resource> worlisttmp = new ArrayList<Train_Resource>();
		for (int i = 0; i < cv.size(); ++i) {
			if (cv.get(i).getResources_colum().equals("sp")) {
				l++;
				if (l <= 14) {
					veadiolisttemp.add(cv.get(i));
				} else {
					continue;
				}
			/*} else if (cv.get(i).getResources_colum().equals("gb")) {
				m++;
				if (m <= 9) {
					brolisttmp.add(cv.get(i));
				} else {
					continue;
				}*/
			} else if (cv.get(i).getResources_colum().equals("wg")) {
				n++;
				if (n <= 14) {
					worlisttmp.add(cv.get(i));
				} else {
					continue;
				}
			}
		}
		setBrolist(brolisttmp);
		setVeadiolist(veadiolisttemp);
		setWorlist(worlisttmp);

		return SUCCESS;
	}

	// 前台详细列表
	public String findWg() {
		setPageSize(29);

		setProfesspath(professpath);
		List<Train_Resource> cv = null;
		try {
			setPageCount(ttbusi.getTotalRowsWg(pageSize));
		} catch (HibernateException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			cv = ttbusi.findByPageWg(pageSize, pageNow);
		} catch (Exception e) {
			e.printStackTrace();
		}
		this.setWorlist(cv);
		return SUCCESS;
	}

	public String findSp() {
		setPageSize(29);
		setProfesspath(professpath);
		List<Train_Resource> cv = null;
		try {
			setPageCount(ttbusi.getTotalRowsSp(pageSize));
		} catch (HibernateException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			cv = ttbusi.findByPageSp(pageSize, pageNow);
		} catch (Exception e) {
			e.printStackTrace();
		}
		this.setVeadiolist(cv);
		return SUCCESS;
	}

	public String findGb() {
		setPageSize(29);

		setProfesspath(professpath);
		List<Train_Resource> cv = null;
		try {
			setPageCount(ttbusi.getTotalRowsGb(pageSize));
		} catch (HibernateException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			cv = ttbusi.findByPageGb(pageSize, pageNow);
		} catch (Exception e) {
			e.printStackTrace();
		}
		this.setBrolist(cv);
		return SUCCESS;
	}

	// 后台资源列表
	public String findBack() {
		setPageSize(10);

		setProfesspath(professpath);
		List<Train_Resource> cv = null;
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
		ResDele rd = new ResDele();
		List<Train_Resource> cv;
		rd.deleRes(resources_id);
		// ttbusi.delete(resources_id);
		setPageCount(ttbusi.getTotalRows(pageSize));
		cv = ttbusi.findByPage(pageSize, pageNow);
		this.setTealist(cv);
		return SUCCESS;
	}

	public String findById() throws Exception {
		TrainResourceBusiness ttbusi = BusinessFactory
				.createTrainResourceBussiness();
		request = ServletActionContext.getRequest();
		setServip(request.getServerName() + ":" + request.getServerPort());
		setTzhi(ttbusi.getTrainResource(resources_id));
		if (tzhi.getResources_colum().equals("sp")) {
			tzhi.setResources_colum("专家视频库");
			if (flag == 0) {
				setPath("http://" + servip + "/yanggov/upload/media/sp/"
						+ (tzhi.getResources_path()));
			}
		} else if (tzhi.getResources_colum().equals("gb")) {
			if (flag == 1) {
				setPath("http://" + servip + "/yanggov/upload/media/gb/"
						+ (tzhi.getResources_path()));
			}
			tzhi.setResources_colum("广播演讲稿");
		} else if (tzhi.getResources_colum().equals("wg")) {
			if (flag == 2) {
				setPath("http://" + servip + "/yanggov/upload/media/wg/"
						+ (tzhi.getResources_path()));
			}
			tzhi.setResources_colum("专家文稿库");
		}

		return SUCCESS;
	}

	/* 修改资源信息 */
	public String findByIdEdi() throws Exception {
		TrainResourceBusiness ttbusi = BusinessFactory
				.createTrainResourceBussiness();

		setTzhi(ttbusi.getTrainResource(resources_id));
		if (tzhi.getResources_colum().equals("sp")) {
			tzhi.setResources_colum("专家视频库");
			System.out.println(path);
		} else if (tzhi.getResources_colum().equals("gb")) {
			tzhi.setResources_colum("广播演讲稿");
		} else if (tzhi.getResources_colum().equals("wg")) {
			tzhi.setResources_colum("专家文稿库");
		}
		return SUCCESS;
	}

}
