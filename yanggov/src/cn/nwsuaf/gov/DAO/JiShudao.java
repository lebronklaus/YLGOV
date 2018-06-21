package cn.nwsuaf.gov.DAO;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.junit.Test;

import cn.nwsuaf.gov.bean.JiShuPeiXun;
import cn.nwsuaf.gov.service.HibernateSessionFactory;

public class JiShudao {
	public void add(JiShuPeiXun js) throws Exception {

		Session session = HibernateSessionFactory.createFactory().openSession();
		Transaction tx = session.beginTransaction();
		js.setTime(getTime());
		session.save(js);
		tx.commit();
		session.close();
	}

	public String getTime() {
		Calendar ca = Calendar.getInstance();
		int year = ca.get(Calendar.YEAR);
		int month = ca.get(Calendar.MONTH) + 1;
		String monthstr=null;
		if(month<10){
			monthstr = "0"+Integer.toString(month);
		}else{
			monthstr = Integer.toString(month);
		}
		int day = ca.get(Calendar.DATE);
		String daystr = null;
		if(day<10){
			daystr="0"+Integer.toString(day);
		}else{
			daystr=Integer.toString(day);
		}
		String str3 = Integer.toString(year) + "-" + monthstr
				+ "-" + daystr;
		return str3;
	}
	@Test
	public void printdate(){
		System.out.println(getTime());
	}

	/*// 测试代码
	@Test
	public void addtest() throws Exception {
		JiShuPeiXun js = new JiShuPeiXun();
		js.setAddress("beijing");
		js.setCompany("tengxun");
		js.setCompanytype("minying");
		js.setEmail("150@qq.com");
		js.setHangye("internet");
		js.setLianxiadd("zhuyao ");
		js.setLianxiren("zhoujielun");
		js.setLingyu("nognye");
		js.setMingcheng("yangzhu");
		js.setShenhe("no");
		js.setShuoming("henhao");
		js.setTel("223456");
		js.setTime(getTime());
		add(js);
	}
*/
	public List<JiShuPeiXun> findByPage(int pageSize, int pageNow) {
		List<JiShuPeiXun> sftlist = new ArrayList<JiShuPeiXun>();

		try {

			SessionFactory sf = new AnnotationConfiguration().configure()
					.buildSessionFactory();

			Session session = sf.getCurrentSession();
			session.beginTransaction();

			Query q = session.createQuery("from JiShuPeiXun news  ");
			q.setFirstResult(pageSize * (pageNow - 1));
			q.setMaxResults(pageSize);
			sftlist = q.list();
			session.getTransaction().commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			System.out.println("查询失败");
		}
		return sftlist;
	}

	/**
	 * @author Zhitao.Chen
	 * @param pageSize
	 * @param pageNow
	 * @return
	 */
	public List<JiShuPeiXun> findByPageQt(int pageSize, int pageNow) {
		List<JiShuPeiXun> sftlist = new ArrayList<JiShuPeiXun>();
		Session session = null;
		try {
			session = HibernateSessionFactory.createFactory()
					.openSession();
			Transaction tx = session.beginTransaction();
			Query q = session
					.createQuery("from JiShuPeiXun js  where js.shenhe=?  order by js.id desc");
			q.setInteger(0, 1);
			q.setFirstResult(pageSize * (pageNow - 1));
			q.setMaxResults(pageSize);
			sftlist = q.list();
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("查询失败");
		}finally{
			if(session.isOpen()){
				session.close();
			}
		}
		return sftlist;
	}

	/**
	 * @author Zhitao.Chen
	 * @param pageSize
	 * @return
	 */
	// 获取总得页数
	public int getRows(int pageSize) {
		int dataCount = 0;
		int pageCount;
		List sftlist = new ArrayList();
		Session session = null;
		
		try {
			session = HibernateSessionFactory.createFactory()
					.openSession();
			Transaction tx = session.beginTransaction();
			
			Query q = session.createQuery("from JiShuPeiXun js where js.shenhe=? order by js.id desc");
			q.setInteger(0, 1);
			sftlist = q.list();
			dataCount = sftlist.size();
			tx.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			if(session.isOpen()){
				session.close();
			}
		}
		if (dataCount % pageSize == 0) {
			pageCount = dataCount / pageSize;
		} else {
			pageCount = dataCount / pageSize + 1;
		}
		return pageCount;
	}

	// 更新插入
	public void update(int id) {
		SessionFactory sf = new AnnotationConfiguration().configure()
				.buildSessionFactory();
		Session session = sf.getCurrentSession();
		session.beginTransaction();
		Query q = session
				.createQuery("update JiShuPeiXun t set t.shenhe = 1 where id = ?");
		q.setInteger(0, id);
		q.executeUpdate();
		session.getTransaction().commit();
	}

	
	/**
	 * @author Zhitao.Chen
	 * @param id
	 * @return
	 */
	// 按id查找
	public List<JiShuPeiXun> findById(int id) {
		List<JiShuPeiXun> sftlist = new ArrayList<JiShuPeiXun>();
		Session session = null;
		try {
			session = HibernateSessionFactory.createFactory()
					.openSession();
			Transaction tx = session.beginTransaction();
			Query q = session.createQuery("from JiShuPeiXun js where js.id=?");
			q.setInteger(0, id);
			sftlist = q.list();
			tx.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			if(session.isOpen()){
				session.close();
			}
		}
		
		return sftlist;
	}

}
