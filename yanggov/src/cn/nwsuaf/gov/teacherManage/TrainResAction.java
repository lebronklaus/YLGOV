package cn.nwsuaf.gov.teacherManage;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.apache.struts2.ServletActionContext;
import org.hibernate.HibernateException;

import com.opensymphony.xwork2.ActionSupport;

import cn.nwsuaf.gov.model.Train_Resource;
import cn.nwsuaf.gov.service.TrainResService;

public class TrainResAction extends ActionSupport{

	private JSONObject jsonObj;
	private String rows;
	private String page;
	private TrainResService trs ;
	private int id ;
	
	//下面两个变量是用来删除前面上传到的资源
	private String res_path;
	private int res_id;
	private String fileclass;
	
	private String searchname;
	
	
	//实现按名字查找的功能
	public String getsearchTrainRes() throws Exception{
		trs = new TrainResService();
		List<Train_Resource> list = trs.search(searchname);
		toBeJson(list, list.size());
		return null;
	}
	//实现删除重复照片操作，也就是每次如果更换照片，都会把之前的删除
	public String delePostRes() throws HibernateException, Exception{
		trs = new TrainResService();
		
		trs.deleteRes(res_id, res_path,fileclass);
		return "success";
	}

	//实现删除操作
	public String deletTrainRes() throws HibernateException, Exception{
		trs = new TrainResService();
		trs.deleRes(id);
		return "success";
	}
	
	//以下两个函数用来实现分页
	public String getAllTrainRes() throws Exception{
		trs = new TrainResService();
		List list = trs.findByPage(page, rows);
		this.toBeJson(list, trs.getTotalRows());
		return null;
	}
	public void toBeJson(List list ,int total) throws IOException{
		HttpServletResponse response = ServletActionContext.getResponse();
		HttpServletRequest request = ServletActionContext.getRequest();
		
		JSONObject jobj = new JSONObject();
		jobj.accumulate("total", total);
		jobj.accumulate("rows", list);
		
		response.setCharacterEncoding("utf-8");
		response.getWriter().write(jobj.toString());
	}
	
	
	public String getFileclass() {
		return fileclass;
	}

	public void setFileclass(String fileclass) {
		this.fileclass = fileclass;
	}

	public String getRes_path() {
		return res_path;
	}
	public void setRes_path(String res_path) {
		this.res_path = res_path;
	}
	public int getRes_id() {
		return res_id;
	}
	public void setRes_id(int res_id) {
		this.res_id = res_id;
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
	



}
