package com.lee.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.hibernate.HibernateException;

import com.lee.mode.PeiXun;
import com.lee.service.PeiXunDAO;
import com.opensymphony.xwork2.ActionSupport;

public class PXnews extends ActionSupport implements ServletRequestAware {
	private String msg; // �洢�ɹ����ر�־
	private int pageNow = 1;// Ĭ�ϴӵ�һҳ��ʼ
	private int pageSize = 5;// ÿҳ��ʾ10����Ϣ
	private int pageCount;// ��ҳ��
	private int id;
	// private int tdid;
	private PeiXun peixun;
	private List<PeiXun> list;
	private HttpServletRequest request;
	private File upload; // �ϴ��ļ����ļ��������
	private String uploadContentType;// �ϴ��ļ����͵�����
	private String uploadFileName;// �ϴ��ļ����ļ���
	private String savePath;// �ϴ��ļ���·��
	PeiXunDAO news = new PeiXunDAO();

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

	@Override
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}

	//
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	// public int getTdid() {
	// return tdid;
	// }
	//
	//
	//
	// public void setTdid(int tdid) {
	// this.tdid = tdid;
	// }

	public List<PeiXun> getList() {
		return list;
	}

	public void setList(List<PeiXun> list) {
		this.list = list;
	}

	public PeiXun getPeixun() {
		return peixun;
	}

	public void setPeixun(PeiXun peixun) {
		this.peixun = peixun;
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

	// ��ҳ����
	public String findByPage() throws Exception {

		 

		List<PeiXun> cv;
		setPageCount(news.getRows(pageSize));
		cv = news.findByPage(pageSize, pageNow);
		setList(cv);
		return SUCCESS;
	}

	// ����
	public String save() throws HibernateException, Exception {
		 
		// //////
		String path = ServletActionContext.getServletContext().getRealPath("/");
		// String
		// pathfile=ServletActionContext.getServletContext().getRealPath("/")
		// �ѷ��������ļ������ַ���ļ�����н����ϴ��ļ�������
		if (getUploadFileName() != null) {
			try {
				FileOutputStream fos = new FileOutputStream(path
						+ "\\uploadfile\\" + getUploadFileName());
				FileInputStream fis = new FileInputStream(getUpload());
				String image1 = request.getScheme() + "://"
						+ request.getServerName() + ":"
						+ request.getServerPort() + request.getContextPath()
						+ "/uploadfile/" + getUploadFileName();
				System.out.println(path);
				byte[] buffer = new byte[1024];
				int len = 0;
				while ((len = fis.read(buffer)) > 0) {
					fos.write(buffer, 0, len);

				}
				fis.close();
				peixun.setImage(image1);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		news.save(peixun);
		setMsg("����ɹ�");
		return SUCCESS;
	}

	// ɾ��
	public String delete() throws HibernateException, Exception {
		 
		List<PeiXun> cv;
		// String ida=request.getParameter("id");
		// int a = Integer.parseInt(ida);
		// System.out.println("wangkecccccccccccccccccccccd::"+a);
		news.deleteById(id);
		setPageCount(news.getRows(pageSize));
		cv = news.findByPage(pageSize, pageNow);
		setList(cv);

		return SUCCESS;
	}

	// ����
	public String findById() {
		return SUCCESS;
	}
}
