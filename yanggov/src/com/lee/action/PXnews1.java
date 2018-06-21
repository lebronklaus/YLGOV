package com.lee.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.struts2.ServletActionContext;
import org.hibernate.HibernateException;

import com.lee.mode.PeiXun;
import com.lee.mode.Tnews;
import com.lee.service.PeiXunDAO;
import com.lee.service.PeiXunDAO1;
import com.lee.service.TnewsDAO1;
import com.opensymphony.xwork2.ActionSupport;
 

public class PXnews1 extends ActionSupport{
	
	private JSONObject jsonObj;
	private String rows;
	private String page;
	private PeiXunDAO1 peixun;
	private List<PeiXun> post3;
	private int id;
	private String title;
	private String author;
	private String text;
	private String date;
	private String remark;
	private File upload; // �ϴ��ļ����ļ��������
	private String uploadContentType;// �ϴ��ļ����͵�����
	private String uploadFileName;// �ϴ��ļ����ļ���
	private String savePath;// �ϴ��ļ���·��
	private String msg;
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
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
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
	public List<PeiXun> getPost3() {
		return post3;
	}
	public void setPost3(List<PeiXun> post3) {
		this.post3 = post3;
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
	
	public PeiXunDAO1 getPeixun() {
		return peixun;
	}
	public void setPeixun(PeiXunDAO1 peixun) {
		this.peixun = peixun;
	}
		//����������������ʵ�ַ�ҳ
		public String getAllTrainTeacher () throws Exception{
			peixun = new PeiXunDAO1();
			List list = peixun.findByPage(page, rows);
			this.toBeJson(list, peixun.getTotalRows());
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
			 peixun= new PeiXunDAO1();
			try {
				 s=java.net.URLDecoder.decode(getS(), "UTF-8");
				 System.out.println("wngeksa10021998\n"+java.net.URLDecoder.decode(getS(), "UTF-8"));
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			List list = peixun.findsearch(s);
			achievementJson = JSONArray.fromObject(list);
			return "result";
		}
		public String pxrevise() throws Exception
		{
			PeiXunDAO news = new PeiXunDAO();
			HttpServletRequest request=ServletActionContext.getRequest();
			HttpSession session=request.getSession();
			List<PeiXun> cv;
			int i;
			cv = news.findById(id);// ͨ��ID���в�ѯ
			if (cv.get(0).getImage() != null) {
				i = 0;
				session.setAttribute("image3", i);
			} else {
				i = 1;
				session.setAttribute("image3", i);
			}

			setPost3(cv);
			 
			// JSONObject json = JSONObject.fromObject(post);//��map����ת����json�������
			// result = json.toString();//��result��ֵ�����ݸ�ҳ��
			return SUCCESS;

		}
	
		public String editPX()
		{
			PeiXun tt = new PeiXun();
			tt.setDtid(id);
			tt.setAuthor(author);
			tt.setDate(date);
			tt.setText(text);
			tt.setTitle(title);
			
			 
			PeiXunDAO1 tts=new PeiXunDAO1();
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
		
		public String deletepx()
		{	peixun=new PeiXunDAO1();
			peixun.deleteById(id);
			return SUCCESS;
		}
		
		public String uploaddt() throws Exception
		{		
			System.out.println("nima++++++");
			PeiXun tt = new PeiXun();
			 
			String path = ServletActionContext.getServletContext().getRealPath("/");
			// String
			// pathfile=ServletActionContext.getServletContext().getRealPath("/")
			// �ѷ��������ļ������ַ���ļ�����н����ϴ��ļ�������
			Date date=new Date();
			DateFormat format=new SimpleDateFormat("yyyyMMddHHmmss");
			String time=format.format(date);
			String  absolutePath=path + "\\uploadzc\\"+ getUploadFileName();
			//String name = getUploadFileName();
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
					tt.setImage(name);
					session.setAttribute("cishu", 1);
					session.setAttribute("filename", tt.getImage());
					//tts.savefile(tt);
					setMsg("����ɹ�");
				}
		 
			return SUCCESS;
			
		}
		public String save() throws HibernateException, Exception
		{
			PeiXun tt = new PeiXun();
			peixun=new PeiXunDAO1();
			tt.setAuthor(author);
			tt.setDate(date);
			tt.setRemark(remark);
			tt.setText(text);
			tt.setTitle(title);
			if((String)session.getAttribute("filename")!=null)
			{
			tt.setImage((String)session.getAttribute("filename"));
			session.setAttribute("filename",null);
			}
	 
			//tt.setFilename((String)session.getAttribute("filename"));
			//System.out.println("����ļ����֣�"+tt.getFilename());
			System.out.println("�������"+tt.getText());
			peixun.save(tt);
			return SUCCESS;
			
		}
		public String uploadfile() throws Exception
		{
			
			PeiXun tt = new PeiXun();
			peixun=new PeiXunDAO1();
			
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
					tt.setImage(name);
					 
					peixun.updatefile(tt.getImage(),id);
					setMsg("����ɹ�");
				}
		 
			return SUCCESS;
		}
}
