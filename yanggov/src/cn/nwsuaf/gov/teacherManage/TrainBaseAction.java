package cn.nwsuaf.gov.teacherManage;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.apache.struts2.ServletActionContext;
import org.hibernate.HibernateException;

import com.opensymphony.xwork2.ActionSupport;

import cn.nwsuaf.gov.model.Train_Base;
import cn.nwsuaf.gov.service.TrainBaseService;
import cn.nwsuaf.gov.service.TrainTeacherService;

public class TrainBaseAction extends ActionSupport{
	private JSONObject jsonObj;
	private String rows;
	private String page;
	private TrainBaseService tbs ;
	private int id ;
	private String base_path1;
	private String base_path2;
	private int base_id;
	
	private String searchname;
	//按照基地名字进行查找
	public String getsearchTrainBase() throws Exception{
		tbs = new TrainBaseService();
		List<Train_Base> list = tbs.search(searchname);
		toBeJson(list, list.size());
		return null;
	}
	
	//实现删除重复照片操作，也就是每次如果更换照片，都会把之前的删除
	public String delePostImage1() throws HibernateException, Exception{
		tbs = new TrainBaseService();
		tbs.deleImage1(base_id, base_path1);
		return "success";
	}
	
	public String delePostImage2() throws HibernateException, Exception{
		tbs = new TrainBaseService();
		tbs.deleImage1(base_id, base_path2);
		return "success";
	}
	
	//实现删除操作
	public String deletTrainBase() throws HibernateException, Exception{
		tbs =  new TrainBaseService();
		tbs.deleBse(id);
		tbs.delete(id);
		return "success";
	}
	
	//以下两个函数用来实现分页
	public String getAllTrainBase() throws Exception{
		tbs = new TrainBaseService();
		List list = tbs.findByPage(page, rows);
		this.toBeJson(list, tbs.getTotalRows());
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
	
	public String getBase_path2() {
		return base_path2;
	}
	public void setBase_path2(String base_path2) {
		this.base_path2 = base_path2;
	}
	public String getBase_path1() {
		return base_path1;
	}
	public void setBase_path1(String base_path1) {
		this.base_path1 = base_path1;
	}
	public int getBase_id() {
		return base_id;
	}
	public void setBase_id(int base_id) {
		this.base_id = base_id;
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
