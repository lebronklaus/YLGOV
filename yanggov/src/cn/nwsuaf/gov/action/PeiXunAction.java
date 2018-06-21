package cn.nwsuaf.gov.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.apache.struts2.ServletActionContext;
import org.hibernate.HibernateException;

import cn.nwsuaf.gov.DAO.PeixunService;
import cn.nwsuaf.gov.bean.PeiXunXuQiu;

public class PeiXunAction {

	private JSONObject jsonObj;
	private String rows;
	private String page;
	private PeixunService ps ;
	private int id ;
	private String searchname;
	
	public String shenHe(){
		ps =  new PeixunService();
		ps.update(id);
		return "success";
	}
	//按照名字查找
	public String getsearchPeiXun() throws Exception{
		ps = new PeixunService();
		List<PeiXunXuQiu> list = ps.search(searchname);
		toBeJson(list, list.size());
		return null;
	}
	//实现删除操作
	public String deletPei() throws HibernateException, Exception{
		ps =  new PeixunService();
		ps.delPei(id);
		return "success";
	}
	//以下两个函数用来实现分页
	public String getAllPei() throws Exception{
		ps = new PeixunService();
		List list = ps.findByPage(page, rows);
		this.toBeJson(list, ps.getTotalRows());
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
