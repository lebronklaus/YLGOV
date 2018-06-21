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

import cn.nwsuaf.gov.bean.PeiXunXuQiu;
import cn.nwsuaf.gov.service.HibernateSessionFactory;

public class PeiXundao {
	public void add(PeiXunXuQiu js) throws Exception {

		Session session = HibernateSessionFactory.createFactory().openSession();
		Transaction tx = session.beginTransaction();
		js.setInputdate(getTime());
		session.save(js);
		tx.commit();
		session.close();
	}

	public List<PeiXunXuQiu> findByPage(int pageSize, int pageNow) {
		List<PeiXunXuQiu> sftlist = new ArrayList<PeiXunXuQiu>();

		try {

			SessionFactory sf = new AnnotationConfiguration().configure()
					.buildSessionFactory();

			Session session = sf.getCurrentSession();
			session.beginTransaction();

			Query q = session.createQuery("from PeiXunXuQiu news  ");
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
	public List<PeiXunXuQiu> findByPageQt(int pageSize, int pageNow) {
		List<PeiXunXuQiu> sftlist = new ArrayList<PeiXunXuQiu>();
		Session session = null;
		try {
			session = HibernateSessionFactory.createFactory()
						.openSession();
			Transaction tx = session.beginTransaction();
			Query q = session
					.createQuery("from PeiXunXuQiu px where px.shenhe=? order by px.id desc");
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
			daystr= Integer.toString(day);
		}
		String str3 = Integer.toString(year) + "-" + monthstr
				+ "-" + daystr;
		return str3;
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
		List<PeiXunXuQiu> sftlist = new ArrayList<PeiXunXuQiu>();
		Session session = null;
		try {
			session = HibernateSessionFactory.createFactory()
						.openSession();
			Transaction tx = session.beginTransaction();
			Query q = session
					.createQuery("from PeiXunXuQiu px where px.shenhe=? order by px.id desc");
			q.setInteger(0, 1);
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
		dataCount = sftlist.size();

		if (dataCount % pageSize == 0) {
			pageCount = dataCount / pageSize;
		} else {
			pageCount = dataCount / pageSize + 1;
		}
		return pageCount;
	}

	/**
	 * @author Zhitao.Chen
	 * @param id
	 * @return
	 */
	public List<PeiXunXuQiu> findById(int id) {
		List<PeiXunXuQiu> sftlist = new ArrayList<PeiXunXuQiu>();
		Session session = null;
		try {
			session = HibernateSessionFactory.createFactory()
					.openSession();
			Transaction tx = session.beginTransaction();
			
			Query q = session.createQuery("from PeiXunXuQiu news where news.id=?");
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

	public void update(int id) {
		SessionFactory sf = new AnnotationConfiguration().configure()
				.buildSessionFactory();
		Session session = sf.getCurrentSession();
		session.beginTransaction();
		Query q = session
				.createQuery("update PeiXunXuQiu t set t.shenhe = 1 where id = ?");
		q.setInteger(0, id);
		q.executeUpdate();
		session.getTransaction().commit();
	}

}
