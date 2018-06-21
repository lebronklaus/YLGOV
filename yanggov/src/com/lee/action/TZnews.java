package com.lee.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.util.ServletContextAware;
import org.hibernate.HibernateException;

import com.lee.mode.Tnews;
import com.lee.service.TnewsDAO;
import com.opensymphony.xwork2.ActionSupport;

public class TZnews extends ActionSupport implements ServletRequestAware,
		ServletContextAware {
	private String msg;
	private Tnews tzhi;
	// private Map session;
	private int pageNow = 1;// Ĭ�ϴӵ�һҳ��ʼ
	private int pageSize = 5;// ÿҳ��ʾ10����Ϣ
	private int pageCount;// ��ҳ��
	private List<Tnews> flist;// ������ʾ����ļ���
	private File upload; // �ϴ��ļ����ļ��������
	private String uploadContentType;// �ϴ��ļ����͵�����
	private String uploadFileName;// �ϴ��ļ����ļ���
	private String savePath;// �ϴ��ļ���·��
	private Map session;
	private ServletContext application;
	private HttpServletRequest request;
	private String title;
	private String author;
	private String remark;
	private String date;
	private String inputNote;
	
	List<Tnews> list = new ArrayList();

	TnewsDAO news = new TnewsDAO();
	
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getInputNote() {
		return inputNote;
	}

	public void setInputNote(String inputNote) {
		this.inputNote = inputNote;
	}

	@Override
	public void setServletContext(ServletContext application) {
		this.application = application;
	}

	public File getUpload() {
		return upload;
	}

	public void setUpload(File upload) {
		this.upload = upload;
	}

	public String getUploadContentType() {
		return uploadContentType;
	}

	public void setUploadContentType(String uploadContentType) {
		this.uploadContentType = uploadContentType;
	}

	public String getUploadFileName() {
		return uploadFileName;
	}

	public void setUploadFileName(String uploadFileName) {
		this.uploadFileName = uploadFileName;
	}

	public String getSavePath() {
		return savePath;
	}

	public void setSavePath(String savePath) {
		this.savePath = savePath;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Tnews getTzhi() {
		return tzhi;
	}

	public void setTzhi(Tnews tzhi) {
		this.tzhi = tzhi;
	}

	public List<Tnews> getList() {
		return list;
	}

	public void setList(List<Tnews> list) {
		this.list = list;
	}

	public Map getSession() {
		return session;
	}

	public void setSession(Map session) {
		this.session = session;
	}

	// request��setter����
	@Override
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

	@Override
	public String execute() throws Exception {
		
		tzhi.setAuthor(author);
		tzhi.setDate(date);
		tzhi.setRemark(remark);
		tzhi.setText(inputNote);
		tzhi.setTitle(title);
		/*
		System.out.println("getTongzhi()===========111111==============="
				+ getTzhi().getTitle());
		String path = ServletActionContext.getServletContext().getRealPath("/");
		// String
		// pathfile=ServletActionContext.getServletContext().getRealPath("/")
		// �ѷ��������ļ������ַ���ļ�����н����ϴ��ļ�������
		String name = getUploadFileName();
		if (getUploadFileName() != null) {
			FileOutputStream fos = new FileOutputStream(path + "\\uploadzc\\"
					+ getUploadFileName());
			FileInputStream fis = new FileInputStream(getUpload());
			String image1 = request.getScheme() + "://"
					+ request.getServerName() + ":" + request.getServerPort()
					+ request.getContextPath() + "/uploadfile/"
					+ getUploadFileName();
			System.out.println(path);
			byte[] buffer = new byte[1024];
			int len = 0;
			while ((len = fis.read(buffer)) > 0) {
				fos.write(buffer, 0, len);

			}
			fis.close();
			tzhi.setFilename(name);
		}
		// System.out.println("getTongzhi()===========22222==============="
		// +getTongzhi());
		
		 *
		 *
		 *
		 */
		news.save(tzhi);
		setMsg("����ɹ�");
		// System.out.println("getTongzhi()=========================="
		// +getTongzhi());
		return SUCCESS;
	}

	public String find() throws Exception {

		
		List<Tnews> cv;
		setPageCount(news.getRows(pageSize));
		cv = news.findByPage(pageSize, pageNow);
		setList(cv);

		return SUCCESS;
	}

	public String delete() throws HibernateException, Exception {
		List<Tnews> cv;
		String ida = request.getParameter("id");
		int a = Integer.parseInt(ida);
		
		news.deleteById(a);
		setPageCount(news.getRows(pageSize));
		cv = news.findByPage(pageSize, pageNow);
		setList(cv);
		return SUCCESS;
	}
	
 
}
