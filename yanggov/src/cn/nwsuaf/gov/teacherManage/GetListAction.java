package cn.nwsuaf.gov.teacherManage;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import cn.nwsuaf.gov.model.Train_Teachers;
import cn.nwsuaf.gov.service.BusinessFactory;
import cn.nwsuaf.gov.service.TeaDele;
import cn.nwsuaf.gov.service.TrainTeachersBusiness;
import org.hibernate.HibernateException;
import org.junit.Test;

import com.opensymphony.xwork2.ActionSupport;

public class GetListAction extends ActionSupport {
	private List<Train_Teachers> tealist;

	public List<Train_Teachers> getTealist() {
		return tealist;
	}

	public void setTealist(List<Train_Teachers> tealist) {
		this.tealist = tealist;
	}

	private String msg;
	private Train_Teachers tzhi;
	private Map session;
	private int pageNow = 1;
	private int pageSize = 5;
	private int pageCount;
	private String imagpath;

	public String getImagpath() {
		return imagpath;
	}

	public void setImagpath(String imagpath) {
		this.imagpath = imagpath;
	}

	private int teacher_id;

	public int getTeacher_id() {
		return teacher_id;
	}

	public void setTeacher_id(int teacher_id) {
		this.teacher_id = teacher_id;
	}

	private HttpServletRequest request;
	TrainTeachersBusiness ttbusi = BusinessFactory
			.createTrainTeacherBussiness();

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Train_Teachers getTzhi() {
		return tzhi;
	}

	public void setTzhi(Train_Teachers tzhi) {
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
		List<Train_Teachers> cv = null;
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
		List<Train_Teachers> list_temp = cv;
		for (int i = 0; i < list_temp.size(); i++) {
			Train_Teachers teacher = list_temp.get(i);
			String profile = teacher.getTeacher_profile().trim();
			System.out.println(teacher.getTeacher_path());
			if (profile.length() > 135) {
				profile = profile.substring(0, 135) + "....";
				teacher.setTeacher_profile(profile);
			}
		}
		this.setTealist(list_temp);

		return SUCCESS;
	}

	public String findBack() {
		setPageSize(10);
		List<Train_Teachers> cv = null;
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
		List<Train_Teachers> list_temp = cv;
		for (int i = 0; i < list_temp.size(); i++) {
			Train_Teachers teacher = list_temp.get(i);
			String profile = teacher.getTeacher_profile().trim();
			System.out.println(teacher.getTeacher_path());
			if (profile.length() > 135) {
				profile = profile.substring(0, 135) + "....";
				teacher.setTeacher_profile(profile);
			}
		}
		this.setTealist(list_temp);
		return SUCCESS;
	}

	public String delete() throws Exception {
		List<Train_Teachers> cv;
		TeaDele td = new TeaDele();
		td.delTea(teacher_id);
		setPageCount(ttbusi.getTotalRows(pageSize));
		cv = ttbusi.findByPage(pageSize, pageNow);
		this.setTealist(cv);
		return SUCCESS;
	}

	@Override
	@Test
	public String execute() throws Exception {
		System.out.println("asdfd");
		TrainTeachersBusiness ttbusi = BusinessFactory
				.createTrainTeacherBussiness();
		List<Train_Teachers> list_temp = ttbusi.getList();
		for (int i = 0; i < list_temp.size(); i++) {
			Train_Teachers teacher = list_temp.get(i);
			String profile = teacher.getTeacher_profile().trim();
			if (profile.length() > 135) {
				profile = profile.substring(0, 135) + "..";
				teacher.setTeacher_profile(profile);
			}
		}
		setTealist(list_temp);
		return SUCCESS;
	}

	public String findById() throws Exception {
	
		TrainTeachersBusiness ttbusi = BusinessFactory
				.createTrainTeacherBussiness();
		setTzhi(ttbusi.getTrainTeacher(teacher_id));

		return SUCCESS;
	}

	public String findByIdEdit() throws Exception {
		
		TrainTeachersBusiness ttbusi = BusinessFactory
				.createTrainTeacherBussiness();
		setTzhi(ttbusi.getTrainTeacher(teacher_id));

		return SUCCESS;
	}

}
