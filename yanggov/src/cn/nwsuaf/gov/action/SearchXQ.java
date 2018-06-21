package cn.nwsuaf.gov.action;

import java.util.List;
import cn.nwsuaf.gov.DAO.JiShudao;
import cn.nwsuaf.gov.DAO.PeiXundao;
import cn.nwsuaf.gov.DAO.RenCaidao;
import cn.nwsuaf.gov.bean.JiShuPeiXun;
import cn.nwsuaf.gov.bean.PeiXunXuQiu;
import cn.nwsuaf.gov.bean.RenCaiXuQiu;

import com.opensymphony.xwork2.ActionSupport;

public class SearchXQ extends ActionSupport {
	private int id;
	private int pageNow = 1;
	private int pageSize = 27;
	private int pageCount;
	private List<PeiXunXuQiu> list;
	private List<RenCaiXuQiu> list1;
	private List<JiShuPeiXun> list2;
	private List<PeiXunXuQiu> list3;
	private List<RenCaiXuQiu> list4;
	private List<JiShuPeiXun> list5;
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<PeiXunXuQiu> getList3() {
		return list3;
	}

	public void setList3(List<PeiXunXuQiu> list3) {
		this.list3 = list3;
	}

	public List<JiShuPeiXun> getList2() {
		return list2;
	}

	public void setList2(List<JiShuPeiXun> list2) {
		this.list2 = list2;
	}

	public List<RenCaiXuQiu> getList1() {
		return list1;
	}

	public void setList1(List<RenCaiXuQiu> list1) {
		this.list1 = list1;
	}

	public List<PeiXunXuQiu> getList() {
		return list;
	}

	public void setList(List<PeiXunXuQiu> list) {
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
	/**
	 * @author Zhitao.Chen
	 * @find peixunxuqiu
	 */
	public String find() {
		List<PeiXunXuQiu> post;
		PeiXundao pei = new PeiXundao();
		setPageCount(pei.getRows(pageSize));
		post = pei.findByPageQt(pageSize, pageNow);
		setList(post);
		return SUCCESS;

	}

	public String find1() {
		List<RenCaiXuQiu> post;
		RenCaidao pei = new RenCaidao();
		setPageCount(pei.getRows(pageSize));
		post = pei.findByPageQt(pageSize, pageNow);
		setList1(post);
		return SUCCESS;

	}

	public String find2() {
		List<JiShuPeiXun> post;
		JiShudao pei = new JiShudao();
		setPageCount(pei.getRows(pageSize));
		post = pei.findByPageQt(pageSize, pageNow);
		setList2(post);
		return SUCCESS;
	}

	public String findById() {
		List<PeiXunXuQiu> post;
		PeiXundao pei = new PeiXundao();
		post = pei.findById(id);
		setList3(post);
		return SUCCESS;
	}

	public List<RenCaiXuQiu> getList4() {
		return list4;
	}

	public void setList4(List<RenCaiXuQiu> list4) {
		this.list4 = list4;
	}

	public List<JiShuPeiXun> getList5() {
		return list5;
	}

	public void setList5(List<JiShuPeiXun> list5) {
		this.list5 = list5;
	}

	public void shenyes() {
		PeiXundao pei = new PeiXundao();
		pei.update(id);

	}

	// 人才审核按id查找
	public String findByIdRc() {
		List<RenCaiXuQiu> post;
		RenCaidao rcdao = new RenCaidao();
		post = rcdao.findById(id);
		setList4(post);
		return SUCCESS;
	}

	// 人才审核更新
	public void shenrcyes() {
		RenCaidao rcdao = new RenCaidao();
		rcdao.update(id);
	}

	// 技术审核按id查找
	public String findByIdJs() {
		List<JiShuPeiXun> post;
		JiShudao jsdao = new JiShudao();
		post = jsdao.findById(id);
		setList5(post);
		return SUCCESS;
	}

	// 技术审核更新
	public void shenjsyes() {
		JiShudao jsdao = new JiShudao();
		jsdao.update(id);
	}

}
