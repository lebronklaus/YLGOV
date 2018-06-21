package cn.nwsuaf.gov.teacherManage;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.util.ServletContextAware;
import org.hibernate.HibernateException;

import cn.nwsuaf.gov.model.Train_Teachers;
import cn.nwsuaf.gov.service.TrainTeacherService;

import com.lee.mode.PeiXun;
import com.lee.mode.Tnews;
import com.lee.service.PeiXunDAO;
import com.lee.service.TnewsDAO;
import com.opensymphony.xwork2.ActionSupport;

public class TrainTeacherAction extends ActionSupport implements ServletRequestAware,
ServletContextAware {
	private JSONObject jsonObj;
	private String rows;//一页的数量
	private String page;
	private TrainTeacherService tts ;
	private int id ;
	private int tea_id;
	private String tea_path;
	
	private String searchname;
	private List<Tnews> post1;//用来支持每个页面的通知公告上下滚动。
	private int pageNow = 1;// 默认从第一页开始 滚动信息都是从第一页推广
	private int pageSize = 15;// 每页显示15条消息
	private int pageCount;// 总页数
	private ServletContext application;
	private HttpServletRequest request;
	/**
	 * @author Zhitao.Chen
	 * 以下三个函数用来实现主页到培训资源，园企信息，需求征集页面跳转
	 * @throws Exception 
	 */
	 public String goToPeiXun() throws Exception{
		 TnewsDAO news = new TnewsDAO();
		 List<Tnews> cv;
		 setPageCount(news.getRows(pageSize));
		 cv = news.findByPage(pageSize, pageNow);
		 setPost1(cv);
		 application.setAttribute("peixun", post1);
		 return "success";
	 }
	 
	 public String goToXuQiu() throws Exception{
		 TnewsDAO news = new TnewsDAO();
		 List<Tnews> cv;
		 setPageCount(news.getRows(pageSize));
		 cv = news.findByPage(pageSize, pageNow);
		 setPost1(cv);
		 application.setAttribute("peixun", post1);
		 return SUCCESS;
	 }
	 public String goToYuanQi() throws Exception{
		 TnewsDAO news = new TnewsDAO();
		 List<Tnews> cv;
		 setPageCount(news.getRows(pageSize));
		 cv = news.findByPage(pageSize, pageNow);
		 setPost1(cv);
		 application.setAttribute("peixun", post1);
		 return SUCCESS;
	 }
	/**
	 * @author czt
	 * @return
	 * @throws HibernateException
	 * @throws Exception
	 */
	
	public String getSearchTrainTeacher() throws Exception{
		tts = new TrainTeacherService();
		List<Train_Teachers> list = tts.search(searchname);
		this.toBeJson(list, list.size());
		return null;
	}
	//实现删除重复照片操作，也就是每次如果更换照片，都会把之前的删除
	public String delePostImage() throws HibernateException, Exception{
		tts =  new TrainTeacherService();
		tts.delImage(tea_id, tea_path);
		return "success";
	}
		
	//实现删除操作
	public String deletTrainTeacher() throws HibernateException, Exception{
		tts =  new TrainTeacherService();
		tts.delTea(id);
		return "success";
	}
	
	//以下两个函数用来实现分页
	public String getAllTrainTeacher () throws Exception{
		tts = new TrainTeacherService();
		List list = tts.findByPage(page, rows);
		this.toBeJson(list, tts.getTotalRows());
		return null;
	}
	
	public void toBeJson(List<Train_Teachers> list ,int total) throws IOException{
		HttpServletResponse response = ServletActionContext.getResponse();
		HttpServletRequest request = ServletActionContext.getRequest();
		JSONObject jobj = new JSONObject();
		jobj.accumulate("total", total);
		jobj.accumulate("rows", list);
		response.setCharacterEncoding("utf-8");
		response.getWriter().write(jobj.toString());
	}
	
	public int getTea_id() {
		return tea_id;
	}
	public void setTea_id(int tea_id) {
		this.tea_id = tea_id;
	}
	public String getTea_path() {
		return tea_path;
	}
	public void setTea_path(String tea_path) {
		this.tea_path = tea_path;
	}
	public JSONObject getJsonObj() {
		return jsonObj;
	}
	public void setJsonObj(JSONObject jsonObj) {
		this.jsonObj = jsonObj;
	}
	public String getRows() {
		return rows;
	}
	public void setRows(String rows) {
		this.rows = rows;
	}
	public String getPage() {
		return page;
	}
	public void setPage(String page) {
		this.page = page;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public String getSearchname() {
		return searchname;
	}

	public void setSearchname(String searchname) {
		this.searchname = searchname;
	}
	public List<Tnews> getPost1() {
		return post1;
	}
	public void setPost1(List<Tnews> post1) {
		this.post1 = post1;
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
	
	
}
