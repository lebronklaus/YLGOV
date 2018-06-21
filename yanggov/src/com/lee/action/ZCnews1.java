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

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.struts2.ServletActionContext;
import org.hibernate.HibernateException;

import com.lee.mode.PeiXun;
import com.lee.mode.Tnews;
import com.lee.mode.ZhengCe;
import com.lee.service.PeiXunDAO1;
import com.lee.service.ZhengCeDAO;
import com.lee.service.ZhengCeDAO1;
import com.opensymphony.xwork2.ActionSupport;

public class ZCnews1 extends ActionSupport {
	private JSONObject jsonObj;
	private String rows;
	private String page;
	private ZhengCeDAO1 zhengce;
	private int id;
	private List<ZhengCe> post4;
	private String title;
	private String author;
	private String text;
	private String date;
	private String wenhao;
	private String fabujigou; 
	private int mark;
	private String msg;
	private String filename;
	private String suoyinhao;
	private String gongkaimulu;
	private String zhutici;
	private File upload; // �ϴ��ļ����ļ��������
	private String uploadContentType;// �ϴ��ļ����͵�����
	private String uploadFileName;// �ϴ��ļ����ļ���
	private String savePath;// �ϴ��ļ���·��
	HttpServletRequest request=ServletActionContext.getRequest();
	HttpSession session=request.getSession();
	private String s;
	private JSONArray achievementJson;
	
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
	public int getMark() {
		return mark;
	}
	public void setMark(int mark) {
		this.mark = mark;
	}
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	public String getSuoyinhao() {
		return suoyinhao;
	}
	public void setSuoyinhao(String suoyinhao) {
		this.suoyinhao = suoyinhao;
	}
	public String getGongkaimulu() {
		return gongkaimulu;
	}
	public void setGongkaimulu(String gongkaimulu) {
		this.gongkaimulu = gongkaimulu;
	}
	public String getZhutici() {
		return zhutici;
	}
	public void setZhutici(String zhutici) {
		this.zhutici = zhutici;
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
	public String getWenhao() {
		return wenhao;
	}
	public void setWenhao(String wenhao) {
		this.wenhao = wenhao;
	}
	public String getFabujigou() {
		return fabujigou;
	}
	public void setFabujigou(String fabujigou) {
		this.fabujigou = fabujigou;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public List<ZhengCe> getPost4() {
		return post4;
	}
	public void setPost4(List<ZhengCe> post4) {
		this.post4 = post4;
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
	public ZhengCeDAO1 getZhengce() {
		return zhengce;
	}
	public void setZhengce(ZhengCeDAO1 zhengce) {
		this.zhengce = zhengce;
	}
	//����������������ʵ�ַ�ҳ
	public String getAllTrainTeacher () throws Exception{
		zhengce = new ZhengCeDAO1();
		List list = zhengce.findByPage(page, rows);
		this.toBeJson(list, zhengce.getTotalRows());
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
		 zhengce= new ZhengCeDAO1();
		try {
			 s=java.net.URLDecoder.decode(getS(), "UTF-8");
			 System.out.println("wngeksa10021998\n"+java.net.URLDecoder.decode(getS(), "UTF-8"));
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		List list = zhengce.findsearch(s);
		achievementJson = JSONArray.fromObject(list);
		return "result";
	}
	public String zcrevise() throws Exception{
		ZhengCeDAO news = new ZhengCeDAO();
		List<ZhengCe> cv;
		cv = news.findById(id);
		setPost4(cv);
		System.out.println("wangkeiani1994");
		return SUCCESS;
	}

	public String editZC()
	{
		ZhengCe tt = new ZhengCe();
		tt.setZcid(id);
		//tt.setAuthor(author);
		tt.setDate(date);
		tt.setText(text);
		tt.setTitle(title);
		tt.setFabujigou(fabujigou);
		tt.setWenhao(wenhao);
		tt.setGongkaimulu(gongkaimulu);
		tt.setMark(mark);
		
		 
		ZhengCeDAO1 tts=new ZhengCeDAO1();
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

	public String deletezc()
	{
		zhengce=new ZhengCeDAO1();
		zhengce.deleteById(id);
		return SUCCESS;
	}
	public String uploadzc() throws Exception
	{		
		 
		ZhengCe tt = new ZhengCe();
		 
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
				//session.setAttribute("cishu", 1);
				tt.setFilename(name);
				session.setAttribute("filename", tt.getFilename());
				//tts.savefile(tt);
				setMsg("����ɹ�");
			}
	 
		return SUCCESS;
		
	}
	public String save() throws HibernateException, Exception
	{
		ZhengCe tt = new ZhengCe();
		zhengce=new ZhengCeDAO1();
		 
		tt.setDate(date);
		 
		tt.setText(text);
		tt.setTitle(title);
		
		tt.setFabujigou(fabujigou);
		tt.setMark(mark);
		tt.setGongkaimulu(gongkaimulu);
		tt.setWenhao(wenhao);
		tt.setZhutici(zhutici);
		tt.setSuoyinhao(suoyinhao);
		if((String)session.getAttribute("filename")!=null)
		{
		tt.setFilename((String)session.getAttribute("filename"));
		session.setAttribute("filename",null);
		}
	 
		//tt.setFilename((String)session.getAttribute("filename"));
		//System.out.println("����ļ����֣�"+tt.getFilename());
		System.out.println("�������"+tt.getText());
		zhengce.save(tt);
		return SUCCESS;
		
	}
	
	public String uploadfile() throws Exception
	{
		
		ZhengCe tt = new ZhengCe();
		zhengce=new ZhengCeDAO1();
		
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
				 
				zhengce.updatefile(tt.getFilename(),id);
				setMsg("����ɹ�");
			}
	 
		return SUCCESS;
	}
}
