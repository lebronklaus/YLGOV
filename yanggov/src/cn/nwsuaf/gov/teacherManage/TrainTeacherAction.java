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

import cn.nwsuaf.gov.bean.JiShuPeiXun;
import cn.nwsuaf.gov.bean.PeiXunXuQiu;
import cn.nwsuaf.gov.bean.RenCaiXuQiu;
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
	private String rows;//涓�椤电殑鏁伴噺
	private String page;
	private TrainTeacherService tts ;
	private int id ;
	private int tea_id;
	private String tea_path;
	
	private String searchname;
	private List<Tnews> post1;//鐢ㄦ潵鏀寔姣忎釜椤甸潰鐨勯�氱煡鍏憡涓婁笅婊氬姩銆�
	
	private List<RenCaiXuQiu> rcPost;//follow 3 by xiuhao.yan
	private List<JiShuPeiXun> jsPost;
	private List<PeiXunXuQiu> pxPost;
	
	private int pageNow = 1;// 榛樿浠庣涓�椤靛紑濮� 婊氬姩淇℃伅閮芥槸浠庣涓�椤垫帹骞�
	private int pageSize = 15;// 姣忛〉鏄剧ず15鏉℃秷鎭�
	private int pageCount;// 鎬婚〉鏁�
	private ServletContext application;
	private HttpServletRequest request;
	/**
	 * @author Zhitao.Chen
	 * 浠ヤ笅涓変釜鍑芥暟鐢ㄦ潵瀹炵幇涓婚〉鍒板煿璁祫婧愶紝鍥紒淇℃伅锛岄渶姹傚緛闆嗛〉闈㈣烦杞�
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
	 
	 //follow 4 by xiuhao.yan
	 public String getGongGao() throws Exception{
		 TnewsDAO news = new TnewsDAO();
		 setPageCount(news.getRows(pageSize));
		 
		 List<RenCaiXuQiu> rc;
		 //setPageCount(news.getRows(pageSize));
		 rc = news.findByPageRC(pageSize, pageNow);
		 setRcPost(rc);
		 application.setAttribute("rencailist", rcPost);
		 
		 List<JiShuPeiXun> js;
		 //setPageCount(news.getRows(pageSize));
		 js = news.findByPageJS(pageSize, pageNow);
		 setJsPost(js);
		 application.setAttribute("jishulist", jsPost);
		 
		 List<PeiXunXuQiu> px;
		 //setPageCount(news.getRows(pageSize));
		 px = news.findByPagePX(pageSize, pageNow);
		 setPxPost(px);
		 application.setAttribute("peixunlist", pxPost);
		 
		 return SUCCESS;
		 
	 }
	 public String getRenCaiGongGao() throws Exception{
		 TnewsDAO news = new TnewsDAO();
		 List<RenCaiXuQiu> rc;
		 setPageCount(news.getRows(pageSize));
		 rc = news.findByPageRC(pageSize, pageNow);
		 setRcPost(rc);
		 application.setAttribute("rencailist", rcPost);
		 return SUCCESS;
	 }
	 
	 public String getJiShuGongGao() throws Exception{
		 TnewsDAO news = new TnewsDAO();
		 List<JiShuPeiXun> cv;
		 setPageCount(news.getRows(pageSize));
		 cv = news.findByPageJS(pageSize, pageNow);
		 setJsPost(cv);
		 application.setAttribute("jishulist", jsPost);
		 return SUCCESS;
		 
	 }
	 public String getPeiXunGongGao() throws Exception{
		 TnewsDAO news = new TnewsDAO();
		 List<PeiXunXuQiu> cv;
		 setPageCount(news.getRows(pageSize));
		 cv = news.findByPagePX(pageSize, pageNow);
		 setPxPost(cv);
		 application.setAttribute("peixunlist", pxPost);
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
	//瀹炵幇鍒犻櫎閲嶅鐓х墖鎿嶄綔锛屼篃灏辨槸姣忔濡傛灉鏇存崲鐓х墖锛岄兘浼氭妸涔嬪墠鐨勫垹闄�
	public String delePostImage() throws HibernateException, Exception{
		tts =  new TrainTeacherService();
		tts.delImage(tea_id, tea_path);
		return "success";
	}
		
	//瀹炵幇鍒犻櫎鎿嶄綔
	public String deletTrainTeacher() throws HibernateException, Exception{
		tts =  new TrainTeacherService();
		tts.delTea(id);
		return "success";
	}
	
	//浠ヤ笅涓や釜鍑芥暟鐢ㄦ潵瀹炵幇鍒嗛〉
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

	public List<RenCaiXuQiu> getRcPost() {
		return rcPost;
	}

	public void setRcPost(List<RenCaiXuQiu> rcPost) {
		this.rcPost = rcPost;
	}

	public List<JiShuPeiXun> getJsPost() {
		return jsPost;
	}

	public void setJsPost(List<JiShuPeiXun> jsPost) {
		this.jsPost = jsPost;
	}

	public List<PeiXunXuQiu> getPxPost() {
		return pxPost;
	}

	public void setPxPost(List<PeiXunXuQiu> pxPost) {
		this.pxPost = pxPost;
	}
	
	
}
