package com.lee.action;

import java.io.File;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.util.ServletContextAware;
import org.hibernate.HibernateException;

import cn.nwsuaf.gov.DAO.Xinxidao;
import cn.nwsuaf.gov.bean.Xinxi;

import com.lee.mode.KuaiXun;
import com.lee.mode.PeiXun;
import com.lee.mode.Tnews;
import com.lee.mode.ZhengCe;
import com.lee.service.KuaiXunDAO;
import com.lee.service.PeiXunDAO;
import com.lee.service.TnewsDAO;
import com.lee.service.ZhengCeDAO;
import com.opensymphony.xwork2.ActionSupport;

public class Search extends ActionSupport implements ServletRequestAware,
		ServletContextAware {

	private int pageNow = 1;// Ĭ�ϴӵ�һҳ��ʼ
	private int pageSize = 20;// ÿҳ��ʾ10����Ϣ
	private int pageCount;// ��ҳ��
	private List<Tnews> post;
	private HttpServletRequest request;
	private ServletContext application;
	private int id;
	private int mark;
	private List<PeiXun> post1;
	private List<PeiXun> post3;
	private List<ZhengCe> post4;
	private List<ZhengCe> post5;
	private List<KuaiXun> post6;
	private List<KuaiXun> post7;
	// private String filename;//
	private String inputPath;// ������ļ���
	private InputStream inputStream;

	// /园企信息前台显示===================================
		private List<Xinxi> tealist;

		public List<Xinxi> getTealist() {
			return tealist;
		}

		public void setTealist(List<Xinxi> tealist) {
			this.tealist = tealist;
		}

		/**
		 * @author Zhitao.Chen
		 * 主页列表显示 园企信息
		 * @return
		 */
		public String findbe() {
			Xinxidao ttbusi = new Xinxidao();
			setPageSize(6);
			// System.out.println("getTongzhi()===========22222===============");
			List<Xinxi> cv = null;
			try {
				setPageCount(ttbusi.getTotalRowsBe(pageSize));
			} catch (HibernateException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
			try {
				cv = ttbusi.findByPageBe(pageSize, pageNow);
			} catch (Exception e) {
				e.printStackTrace();
			}
			this.setTealist(cv);
			return SUCCESS;
		}

	// ////////////////////////////////--------------------------------

	// public InputStream getInputStream() {
	// return
	// ServletActionContext.getServletContext().getResourceAsStream("/uploadzc/"+inputPath);
	// }
	public String getDownloadFileName() {
		String downFileName = getInputPath();
		try {
			downFileName = URLEncoder.encode(downFileName, "UTF-8");

		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return downFileName;

	}

	public InputStream getInputStream() throws UnsupportedEncodingException {

		String path = "/uploadzc/" + File.separatorChar
				+ new String(inputPath.getBytes());
		
		return ServletActionContext.getServletContext().getResourceAsStream(
				path); // ʵ���ļ���������
		// return new ByteArrayInputStream(("/uploadzc/"+inputPath).getBytes());
		// //���֮���Է����������Ϊ������ڽ��б����ʱ�򣬽��ļ��Ķ���ƽ��ж�����ת�룬���ļ������ݳ��ִ���
	}

	public String getInputPath() {

		return inputPath;
	}

	public void setInputPath(String inputPath) {
		this.inputPath = inputPath;
	}

	// public void setFilename(String inputPath) {
	// this.filename = inputPath;
	// }

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

	public int getMark() {
		return mark;
	}

	public void setMark(int mark) {
		this.mark = mark;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}

	@Override
	public void setServletContext(ServletContext application) {
		this.application = application;
	}

	public List<Tnews> getPost() {
		return post;
	}

	public void setPost(List<Tnews> post) {
		this.post = post;
	}

	public List<PeiXun> getPost1() {
		return post1;
	}

	public void setPost1(List<PeiXun> post1) {
		this.post1 = post1;
	}

	public List<PeiXun> getPost3() {
		return post3;
	}

	public void setPost3(List<PeiXun> post3) {
		this.post3 = post3;
	}

	public List<ZhengCe> getPost4() {
		return post4;
	}

	public void setPost4(List<ZhengCe> post4) {
		this.post4 = post4;
	}

	public List<ZhengCe> getPost5() {
		return post5;
	}

	public void setPost5(List<ZhengCe> post5) {
		this.post5 = post5;
	}

	public List<KuaiXun> getPost6() {
		return post6;
	}

	public void setPost6(List<KuaiXun> post6) {
		this.post6 = post6;
	}

	public List<KuaiXun> getPost7() {
		return post7;
	}

	public void setPost7(List<KuaiXun> post7) {
		this.post7 = post7;
	}

	List<Tnews> listNews = new ArrayList();
	List<Tnews> list = new ArrayList();
	List<PeiXun> listim = new ArrayList();

	List<PeiXun> list1 = new ArrayList();
	List<PeiXun> list2 = new ArrayList();
	List<ZhengCe> list3 = new ArrayList();
	List<ZhengCe> list4 = new ArrayList();
	List<KuaiXun> list5 = new ArrayList();
	List<KuaiXun> list6 = new ArrayList();

	public List<PeiXun> getListim() {
		return listim;
	}

	public void setListim(List<PeiXun> listim) {
		this.listim = listim;
	}

	public List<KuaiXun> getList6() {
		return list6;
	}

	public void setList6(List<KuaiXun> list6) {
		this.list6 = list6;
	}

	public List<KuaiXun> getList5() {
		return list5;
	}

	public void setList5(List<KuaiXun> list5) {
		this.list5 = list5;
	}

	public List<ZhengCe> getList4() {
		return list4;
	}

	public void setList4(List<ZhengCe> list4) {
		this.list4 = list4;
	}

	public List<ZhengCe> getList3() {
		return list3;
	}

	public void setList3(List<ZhengCe> list3) {
		this.list3 = list3;
	}

	public List<PeiXun> getList2() {
		return list2;
	}

	public void setList2(List<PeiXun> list2) {
		this.list2 = list2;
	}

	public List<PeiXun> getList1() {
		return list1;
	}

	public void setList1(List<PeiXun> list1) {
		this.list1 = list1;
	}

	public List<Tnews> getListNews() {
		return listNews;
	}

	public void setListNews(List<Tnews> listNews) {
		this.listNews = listNews;
	}

	public List<Tnews> getList() {
		return list;
	}

	public void setList(List<Tnews> list) {
		this.list = list;
	}

	@Override
	public String execute() {
System.out.println("sd");
		TnewsDAO news = new TnewsDAO();
		PeiXunDAO news1 = new PeiXunDAO();
		ZhengCeDAO news2 = new ZhengCeDAO();
		KuaiXunDAO news3 = new KuaiXunDAO();
		System.out.println("**************************");
		List<PeiXun> peixun;
		List<Tnews> cv;
		List<ZhengCe> zhengce;
		List<KuaiXun> kuaixun;
		try {
			cv = news.findAll();
			for (int i = 0; i < 6; i++)// bug����Ū������
			{				 
				getList().add(cv.get(i));
			}
			
		} catch (HibernateException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			peixun = news1.findAll();
			for (int i = 0; i < 13; i++)// bug����Ū������
			{

				 
				getList1().add(peixun.get(i));
			}
			for(int i=0;i<peixun.size();i++)
			{
				if(peixun.get(i).getImage()!=null)
				{
					getListim().add(peixun.get(i));
				}
			}
		} catch (HibernateException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			zhengce = news2.findAll();
			for (int i = 0; i < 13; i++) {
				 
				getList3().add(zhengce.get(i));

			}
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		kuaixun = news3.findAll();
		for (int i = 0; i <13; i++) {
			 
			getList5().add(kuaixun.get(i));
		}
		findbe();
		return SUCCESS;
	}

	// ����
	public String find() throws Exception {
		TnewsDAO news = new TnewsDAO();
		 
		List<Tnews> cv;

		// cv = news.findAll();
		setPageCount(news.getRows(pageSize));
		cv = news.findByPage(pageSize, pageNow);
		setPost(cv);
		System.out.println(getPost());
		System.out.println("cumt");
		// request.setAttribute("newsList", post);
		application.setAttribute("newsList", post);
		application.setAttribute("pagenow", pageNow);
		application.setAttribute("pagecount", pageCount);
		return SUCCESS;
	}

	public String finddt() throws Exception {
		PeiXunDAO news = new PeiXunDAO();
		 
		List<PeiXun> cv;
		setPageCount(news.getRows(pageSize));
		// cv = news.findAll();
		cv = news.findByPage(pageSize, pageNow);
		setPost1(cv);
		application.setAttribute("newsListdt", post1);
		application.setAttribute("pagenowdt", pageNow);
		application.setAttribute("pagecountdt", pageCount);
		return SUCCESS;
	}

	public String findzc() throws Exception {
		ZhengCeDAO news = new ZhengCeDAO();
		 
		List<ZhengCe> cv;
		setPageCount(news.getRows(pageSize));
		cv = news.findByPage(pageSize, pageNow);
		setPost4(cv);
		application.setAttribute("newsListzc", post4);
		application.setAttribute("pagenowzc", pageNow);
		application.setAttribute("pagecountzc", pageCount);
		return SUCCESS;
	}

	public String findzcByMark() throws HibernateException, Exception {
		ZhengCeDAO news = new ZhengCeDAO();

		List<ZhengCe> cv;
		if (mark == 0) {
			setPageCount(news.getRowsd(pageSize, mark));
			cv = news.findByMark(mark, pageSize, pageNow);
			application.setAttribute("newsListzszc", cv);
		} else {
			setPageCount(news.getRowsd(pageSize, mark));
			cv = news.findByMark(mark, pageSize, pageNow);
			application.setAttribute("newsListylzc", cv);
		}
		return SUCCESS;

	}

	public String findkx() throws Exception {
		KuaiXunDAO news = new KuaiXunDAO();
		 
		List<KuaiXun> cv;
		setPageCount(news.getRows(pageSize));
		cv = news.findByPage(pageSize, pageNow);
		setPost6(cv);
		// request.setAttribute("newsList", post);
		application.setAttribute("pagenowkx", pageNow);
		application.setAttribute("pagecountkx", pageCount);
		application.setAttribute("newsListkx", post6);
		return SUCCESS;
	}

	public String moreFind() throws Exception {
		TnewsDAO news = new TnewsDAO();
		List<Tnews> cv;
		cv = news.findById(id);// ͨ��ID���в�ѯ
		setPost(cv);
		System.out.println(post);
		// JSONObject json = JSONObject.fromObject(post);//��map����ת����json�������
		// result = json.toString();//��result��ֵ�����ݸ�ҳ��
		return "result";

	}

	public String moreFind1() throws Exception {
		TnewsDAO news = new TnewsDAO();
		List<Tnews> cv;
		int i;
		cv = news.findById(id);// ͨ��ID���в�ѯ

		setPost(cv);
		 
		// JSONObject json = JSONObject.fromObject(post);//��map����ת����json�������
		// result = json.toString();//��result��ֵ�����ݸ�ҳ��
		return SUCCESS;

	}

	public String moreFind2() throws Exception {
		PeiXunDAO news = new PeiXunDAO();
		List<PeiXun> cv;
		int i;
		cv = news.findById(id);// ͨ��ID���в�ѯ
		if (cv.get(0).getImage() != null) {
			i = 0;
			application.setAttribute("image3", i);
		} else {
			i = 1;
			application.setAttribute("image3", i);
		}

		setPost3(cv);
		System.out.println("wangkeiani1993");
		// JSONObject json = JSONObject.fromObject(post);//��map����ת����json�������
		// result = json.toString();//��result��ֵ�����ݸ�ҳ��
		return SUCCESS;

	}

	public String moreFind3() throws Exception {
		ZhengCeDAO news = new ZhengCeDAO();
		List<ZhengCe> cv;
		cv = news.findById(id);
		setPost4(cv);
	 
		return SUCCESS;

	}

	public String moreFind4() throws Exception {
		KuaiXunDAO news = new KuaiXunDAO();
		List<KuaiXun> cv;
		cv = news.findById(id);
		setPost7(cv);
		 
		return SUCCESS;

	}

	public String findList() throws Exception {
		 
		TnewsDAO news = new TnewsDAO();
		List<Tnews> cv;
		cv = news.findById(id);
		setListNews(cv);
		return SUCCESS;

	}

	public String findListpeixun() throws Exception {
		 
		PeiXunDAO news = new PeiXunDAO();
		List<PeiXun> cv;
		cv = news.findById(id);
		setList2(cv);
		return SUCCESS;

	}

	public String findListzhengce() throws Exception {
		 
		ZhengCeDAO news = new ZhengCeDAO();
		List<ZhengCe> cv;
		cv = news.findById(id);
		setList4(cv);
		return SUCCESS;
	}

	public String findListkuaixun() throws Exception {
		KuaiXunDAO news = new KuaiXunDAO();
		List<KuaiXun> cv;
		cv = news.findById(id);
		setList6(cv);
		return SUCCESS;
	}

	public String downfile() {
		// HttpServletResponse response=ServletActionContext.getResponse();
		// try{
		// response.setHeader( "contentDisposition ", "attachment; filename= " +
		// URLEncoder.encode(getFilename(), "UTF-8 "));
		// }catch( UnsupportedEncodingException e)
		// {
		// e.printStackTrace();
		// }
		return SUCCESS;
	}

}
