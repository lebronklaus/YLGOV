package com.lee.action;

import java.util.List;

import org.hibernate.HibernateException;

import com.lee.mode.KuaiXun;
import com.lee.service.KuaiXunDAO;
import com.opensymphony.xwork2.ActionSupport;

public class KXnews extends ActionSupport {

	private String msg; // �洢�ɹ����ر�־
	private int pageNow = 1;// Ĭ�ϴӵ�һҳ��ʼ
	private int pageSize = 5;// ÿҳ��ʾ10����Ϣ
	private int pageCount;// ��ҳ��
	private int id;
	private KuaiXun kuaixun;
	private List<KuaiXun> list;

	KuaiXunDAO news = new KuaiXunDAO();

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public KuaiXun getKuaixun() {
		return kuaixun;
	}

	public void setKuaixun(KuaiXun kuaixun) {
		this.kuaixun = kuaixun;
	}

	public List<KuaiXun> getList() {
		return list;
	}

	public void setList(List<KuaiXun> list) {
		this.list = list;
	}

	public String save() throws HibernateException, Exception {
		 
		news.save(kuaixun);
		setMsg("����ɹ�");
		return SUCCESS;
	}

	public String findByPage() throws HibernateException, Exception {

		 

		List<KuaiXun> cv;
		setPageCount(news.getRows(pageSize));
		cv = news.findByPage(pageSize, pageNow);
		setList(cv);
		return SUCCESS;
	}

	public String delete() throws HibernateException, Exception {
		 
		List<KuaiXun> cv;
		// String ida=request.getParameter("id");
		// int a = Integer.parseInt(ida);
		// System.out.println("wangkecccccccccccccccccccccd::"+a);
		news.deleteById(id);
		setPageCount(news.getRows(pageSize));
		cv = news.findByPage(pageSize, pageNow);
		setList(cv);

		return SUCCESS;
	}

}
