package com.lee.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.hibernate.HibernateException;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.lee.mode.KuaiXun;
import com.lee.mode.PeiXun;
import com.lee.mode.Tnews;
import com.lee.mode.ZhengCe;
import com.lee.service.KuaiXunDAO;
import com.lee.service.KuaiXunDAO1;
import com.lee.service.PeiXunDAO1;
import com.lee.service.TnewsDAO1;
import com.lee.service.ZhengCeDAO1;
import com.opensymphony.xwork2.ActionSupport;

public class KXnews1 extends ActionSupport{
	private JSONObject jsonObj;
	private String rows;
	private String page;
	private KuaiXunDAO1 kuaixun;
	private int id;
	private List<KuaiXun> post7;
	private String title;
	private String author;
	private String text;
	private String date;
	private String remark;
	private String msg;
	private File upload; // �ϴ��ļ����ļ��������
	private String uploadContentType;// �ϴ��ļ����͵�����
	private String uploadFileName;// �ϴ��ļ����ļ���
	private String savePath;// �ϴ��ļ���·��
	private String s;
	private JSONArray achievementJson;
	HttpServletRequest request=ServletActionContext.getRequest();
	HttpSession session=request.getSession();
	
	
	public String getS() {
		return s;
	}
	public void setS(String s) {
		this.s = s;
	}
	public JSONArray getAchievementJson() {
		return achievementJson;
	}
	public void setAchievementJson(JSONArray achievementJson) {
		this.achievementJson = achievementJson;
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
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
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
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public List<KuaiXun> getPost7() {
		return post7;
	}
	public void setPost7(List<KuaiXun> post7) {
		this.post7 = post7;
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
	public KuaiXunDAO1 getKuaixun() {
		return kuaixun;
	}
	public void setKuaixun(KuaiXunDAO1 kuaixun) {
		this.kuaixun = kuaixun;
	}
	//����������������ʵ�ַ�ҳ
	public String getAllTrainTeacher () throws Exception{
		kuaixun = new KuaiXunDAO1();
		List list = kuaixun.findByPage(page, rows);
		this.toBeJson(list, kuaixun.getTotalRows());
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
	public String getfind() throws Exception
	{
		 kuaixun= new KuaiXunDAO1();
		try {
			 s=java.net.URLDecoder.decode(getS(), "UTF-8");
			 System.out.println("wngeksa10021998\n"+java.net.URLDecoder.decode(getS(), "UTF-8"));
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		List list = kuaixun.findsearch(s);
		achievementJson = JSONArray.fromObject(list);
		return "result";
	}
	public String kxrevise() throws Exception {
		KuaiXunDAO news = new KuaiXunDAO();
		List<KuaiXun> cv;
		cv = news.findById(id);
		setPost7(cv);
		System.out.println("wangkeiani1995");
		return SUCCESS;

	}
	
	public String editKX()
	{
		KuaiXun tt = new KuaiXun();
		tt.setKxid(id);
		tt.setAuthor(author);
		tt.setDate(date);
		tt.setText(text);
		tt.setTitle(title);
		
		 
		KuaiXunDAO1 tts=new KuaiXunDAO1();
		try {
			tts.update(tt);
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return SUCCESS;
	}
	
	public String deletekx()
	{
		kuaixun=new KuaiXunDAO1();
		kuaixun.deleteById(id);
		return SUCCESS;
	}
	public String uploadkx() throws Exception
	{		
		 
		KuaiXun tt = new KuaiXun();
		 
		String path = ServletActionContext.getServletContext().getRealPath("/");
		// String
		// pathfile=ServletActionContext.getServletContext().getRealPath("/")
		// �ѷ��������ļ������ַ���ļ�����н����ϴ��ļ�������
		String  absolutePath=path + "\\uploadzc\\"+ getUploadFileName();
		String name = getUploadFileName();
		if (getUploadFileName() != null) {
			
			File file = new File(absolutePath);
			if(file.exists())
			{
				 
				file.delete();

			}
		 	
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
				try {
					while ((len = fis.read(buffer)) > 0) {
						fos.write(buffer, 0, len);

					}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				try {
					fis.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				tt.setPath(name);
				session.setAttribute("filename", tt.getPath());
				session.setAttribute("cishu", 1);
				//tts.savefile(tt);
				setMsg("����ɹ�");
			}
	 
		return SUCCESS;
		
	}
	public String save()
	{
		KuaiXun tt = new KuaiXun();
		kuaixun=new KuaiXunDAO1();
		tt.setAuthor(author);
		tt.setDate(date);
		tt.setRemark(remark);
		tt.setText(text);
		tt.setTitle(title);
		if((String)session.getAttribute("filename")!=null)
		{
		tt.setPath((String)session.getAttribute("filename"));
		session.setAttribute("filename",null);
		}
	 
		//tt.setFilename((String)session.getAttribute("filename"));
		//System.out.println("����ļ����֣�"+tt.getFilename());
		System.out.println("�������"+tt.getText());
		kuaixun.save(tt);
		return SUCCESS;
		
	}
	
	public String uploadfile() throws Exception
	{
		
		KuaiXun tt = new KuaiXun();
		kuaixun=new KuaiXunDAO1();
		
		String path = ServletActionContext.getServletContext().getRealPath("/");
		// String
		// pathfile=ServletActionContext.getServletContext().getRealPath("/")
		// �ѷ��������ļ������ַ���ļ�����н����ϴ��ļ�������
		String  absolutePath=path + "\\uploadzc\\"+ getUploadFileName();
		String name = getUploadFileName();
		if (getUploadFileName() != null) {
			
			File file = new File(absolutePath);
			if(file.exists())
			{
				System.out.println("���ļ�����");
				file.delete();

			}
		 	
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
				try {
					while ((len = fis.read(buffer)) > 0) {
						fos.write(buffer, 0, len);

					}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				try {
					fis.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				tt.setPath(name);
				System.out.println("ͼƬ������"+tt.getPath()+id);
				kuaixun.updatefile(tt.getPath(),id);
				setMsg("����ɹ�");
			}
	 
		return SUCCESS;
	}
}
