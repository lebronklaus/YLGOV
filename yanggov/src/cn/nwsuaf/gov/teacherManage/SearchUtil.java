package cn.nwsuaf.gov.teacherManage;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.util.ServletContextAware;

import com.lee.mode.KuaiXun;
import com.lee.mode.Message;
import com.lee.mode.PeiXun;
import com.lee.mode.Tnews;
import com.lee.mode.ZhengCe;
import com.lee.service.PeiXunDAO;
import com.lee.service.SearchAllDao;
import com.lee.service.TnewsDAO;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;

public class SearchUtil extends ActionSupport implements ServletRequestAware,
ServletContextAware{
	private List<Message> list;
	private int pageNow = 1;
	private int pageSize = 27;
	private int pageCount;
	private String name;
	private KuaiXun kx;
	private PeiXun px;
	private ZhengCe zc;
	private Tnews tn;
	private ServletContext application;
	private HttpServletRequest request;
	private List<Tnews> post1;//用来支持每个页面的通知公告上下滚动。
	/**
	 * 查找一页数据
	 * @author Zhitao.Chen
	 * @param name
	 * @return
	 * @throws Exception
	 */
	public String gotoSearch() throws Exception{
		 TnewsDAO news = new TnewsDAO();
		 List<Tnews> cv;
		 setPageCount(news.getRows(pageSize));
		 cv = news.findByPage(pageSize, pageNow);
		 setPost1(cv);
		 application.setAttribute("peixun", post1);
		 return SUCCESS;
	}
	public String find() throws Exception{
		SearchAllDao sad = new SearchAllDao();
		setPageCount(sad.getRows(pageSize, name));
		List<Message> list = new ArrayList<Message>();
		this.setList(sad.findByPage(pageSize, pageNow, name));
		 application.setAttribute("searchname", name);
		return SUCCESS;
	}
	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Message> getList() {
		return list;
	}

	public void setList(List<Message> list) {
		this.list = list;
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


	public KuaiXun getKx() {
		return kx;
	}


	public void setKx(KuaiXun kx) {
		this.kx = kx;
	}


	public PeiXun getPx() {
		return px;
	}


	public void setPx(PeiXun px) {
		this.px = px;
	}


	public ZhengCe getZc() {
		return zc;
	}


	public void setZc(ZhengCe zc) {
		this.zc = zc;
	}


	public Tnews getTn() {
		return tn;
	}


	public void setTn(Tnews tn) {
		this.tn = tn;
	}
	public ServletContext getApplication() {
		return application;
	}
	@Override
	public void setServletContext(ServletContext application) {
		this.application = application;
	}

	@Override
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}
	public List<Tnews> getPost1() {
		return post1;
	}
	public void setPost1(List<Tnews> post1) {
		this.post1 = post1;
	}
	
}
