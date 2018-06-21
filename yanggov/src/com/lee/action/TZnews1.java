package com.lee.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.util.ServletContextAware;
import org.hibernate.HibernateException;

import com.lee.mode.Tnews;
import com.lee.service.TnewsDAO;
import com.lee.service.TnewsDAO1;
import com.opensymphony.xwork2.ActionSupport;




public class TZnews1 extends ActionSupport implements  
ServletContextAware{
	private JSONObject jsonObj;
	private String rows;
	private String page;
	private TnewsDAO1  tts;
	private int id ;
	private String s;
	private String title;
	private String author;
	private String remark;
	private String text;
	private String date;
	private List<Tnews> post;
	private File upload; // �ϴ��ļ����ļ��������
	private String uploadContentType;// �ϴ��ļ����͵�����
	private String uploadFileName;// �ϴ��ļ����ļ���
	private String savePath;// �ϴ��ļ���·��
	private ServletContext application;
	private JSONArray achievementJson;
	private String msg;
	HttpServletRequest request=ServletActionContext.getRequest();
	HttpSession session=request.getSession();
	
	
	public JSONArray getAchievementJson() {
		return achievementJson;
	}
	public void setAchievementJson(JSONArray achievementJson) {
		this.achievementJson = achievementJson;
	}
	public String getS() {
		return s;
	}
	public void setS(String s) {
		this.s = s;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	 
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

	public List<Tnews> getPost() {
		return post;
	}

	public void setPost(List<Tnews> post) {
		this.post = post;
	}

	public TnewsDAO1 getTts() {
		return tts;
	}

	public void setTts(TnewsDAO1 tts) {
		this.tts = tts;
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
	//����������������ʵ�ַ�ҳ
	public String getAllTrainTeacher () throws Exception{
		tts = new TnewsDAO1();
		List list = tts.findByPage(page, rows);
		this.toBeJson(list, tts.getTotalRows());
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
		tts = new TnewsDAO1();
		try {
			 s=java.net.URLDecoder.decode(getS(), "UTF-8");
			 System.out.println("wngeksa10021998\n"+java.net.URLDecoder.decode(getS(), "UTF-8"));
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		List list = tts.findsearch(s);
		achievementJson = JSONArray.fromObject(list);
		return "result";
	}

	//	
	public String tzrevise() throws Exception{
		TnewsDAO news = new TnewsDAO();
		List<Tnews> cv;
		int i;
		cv = news.findById(id);// ͨ��ID���в�ѯ
		setPost(cv);
		 
		return SUCCESS;
	}

	public String editTZ()
	{
		Tnews tt = new Tnews();
		tt.setId(id);
		tt.setAuthor(author);
		tt.setDate(date);
		tt.setText(text);
		tt.setTitle(title);
		
		 
		TnewsDAO1 tts=new TnewsDAO1();
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


	public String deletezc() throws HibernateException, Exception
	{
		tts =  new TnewsDAO1();
		tts.deltz(id);
		return SUCCESS;
	}

	public String upload() throws Exception
	{	
		Tnews tt = new Tnews();
		TnewsDAO1 tts=new TnewsDAO1();
		
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
				tt.setFilename(name);

				tts.updatefile(tt.getFilename(),id);
				setMsg("����ɹ�");
			}
	 
		return SUCCESS;
	}
		public String uploadzt() throws Exception
		{		
			 
			Tnews tt = new Tnews();
			 
			String path = ServletActionContext.getServletContext().getRealPath("/");
			// String
			// pathfile=ServletActionContext.getServletContext().getRealPath("/")
			// �ѷ��������ļ������ַ���ļ�����н����ϴ��ļ�������
			Date date=new Date();
			DateFormat format=new SimpleDateFormat("yyyyMMddHHmmss");
			String time=format.format(date);
			
			String  absolutePath=path + "\\uploadzc\\"+ getUploadFileName();
			int index = uploadFileName.lastIndexOf(".");
//			String name = getUploadFileName();
 			String name = time+uploadFileName.substring(index);
			if (getUploadFileName() != null) {
				
				File file = new File(absolutePath);
				if(file.exists())
				{
					System.out.println("���ļ�����");
					file.delete();

				}
			 	
//					FileOutputStream fos = new FileOutputStream(path + "\\uploadzc\\"
//							+ getUploadFileName());
					FileOutputStream fos = new FileOutputStream(path + "\\uploadzc\\"
							+ name);
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
					tt.setFilename(name);
					session.setAttribute("cishu", 1);
					session.setAttribute("filename", tt.getFilename());
					//tts.savefile(tt);
					setMsg("����ɹ�");
				}
		 
			return SUCCESS;
			
		}
		
		public String save() throws HibernateException, Exception
		{
			Tnews tt = new Tnews();
			TnewsDAO1 tts=new TnewsDAO1();
			tt.setAuthor(author);
			tt.setDate(date);
			tt.setRemark(remark);
			tt.setText(text);
			tt.setTitle(title);
			if((String)session.getAttribute("filename")!=null)
			{
			tt.setFilename((String)session.getAttribute("filename"));
			session.setAttribute("filename",null);
			}
		 
			 
			tts.savefile(tt);
			return SUCCESS;
			
		}
}
