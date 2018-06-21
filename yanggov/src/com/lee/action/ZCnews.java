package com.lee.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.text.DateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.hibernate.HibernateException;

import com.lee.mode.ZhengCe;
import com.lee.service.ZhengCeDAO;
import com.opensymphony.xwork2.ActionSupport;

public class ZCnews extends ActionSupport implements ServletRequestAware {

	private String msg; // �洢�ɹ����ر�־
	private int pageNow = 1;// Ĭ�ϴӵ�һҳ��ʼ
	private int pageSize = 5;// ÿҳ��ʾ10����Ϣ
	private int pageCount;// ��ҳ��
	private int id;
	// private int tdid;
	private File upload; // �ϴ��ļ����ļ��������
	private String uploadContentType;// �ϴ��ļ����͵�����
	private String uploadFileName;// �ϴ��ļ����ļ���
	private String savePath;// �ϴ��ļ���·��
	private ZhengCe zhengce;
	private List<ZhengCe> list;
	private HttpServletRequest request;

	ZhengCeDAO news = new ZhengCeDAO();

	@Override
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
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

	public ZhengCe getZhengce() {
		return zhengce;
	}

	public void setZhengce(ZhengCe zhengce) {
		this.zhengce = zhengce;
	}

	public List<ZhengCe> getList() {
		return list;
	}

	public void setList(List<ZhengCe> list) {
		this.list = list;
	}

	// ����
	public String save() throws HibernateException, Exception {

		Date date = new Date();
		DateFormat df1 = DateFormat.getDateTimeInstance();
		 
		int a = getZhengce().getMark();
		String path = ServletActionContext.getServletContext().getRealPath("/");
		String path1 = path + "\\uploadzc\\" + getUploadFileName();

		String name = getUploadFileName();// ����ļ���

		if (getUploadFileName() != null) {
			try {
				FileOutputStream fos = new FileOutputStream(path
						+ "\\uploadzc\\" + getUploadFileName());
				FileInputStream fis = new FileInputStream(getUpload());

				// String path1 = request.getScheme() + "://"
				// + request.getServerName() + ":" + request.getServerPort()
				// + request.getContextPath() + "/uploadzc/"
				// + getUploadFileName();
				// String path1=getUploadFileName();
				byte[] buffer = new byte[1024];
				int len = 0;
				while ((len = fis.read(buffer)) > 0) {
					fos.write(buffer, 0, len);

				}
				fis.close();
				zhengce.setPath(path1);
				zhengce.setFilename(name);

			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		news.save(zhengce);
		setMsg("����ɹ�");
		return SUCCESS;
	}

	// ��ҳ��ѯ
	public String findByPage() throws Exception {
		List<ZhengCe> cv;
		setPageCount(news.getRows(pageSize));
		cv = news.findByPage(pageSize, pageNow);
		setList(cv);
		return SUCCESS;

	}

	public String delete() throws HibernateException, Exception {
		 
		List<ZhengCe> cv;
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
