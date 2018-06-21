package com.lee.service;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;

import cn.nwsuaf.gov.service.HibernateSessionFactory;

import com.lee.mode.KuaiXun;
import com.lee.mode.PeiXun;
import com.lee.mode.Tnews;

public class KuaiXunDAO1 {
	/**
	 * @author Zhitao.Chen
	 * @param tt
	 * @throws HibernateException
	 * @throws Exception
	 */
	public List<KuaiXun> Search(String name)
			throws Exception {
		List ttlist = new ArrayList();
		Session session = null;
		Tnews tt = new Tnews();
		try {
			 session = HibernateSessionFactory.createFactory()
					.openSession();
			Transaction tx = session.beginTransaction();
			Query q = session
					.createQuery("from KuaiXun tt where tt.title like:?");
			 q.setString(0,name);
			ttlist = q.list();
			session.getTransaction().commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			System.out.println("查询失败");
		}finally{
			session.close();
		}
		return ttlist;
	}
	
	// ��ȡ�ܵ�ҳ��
	public int getTotalRows() throws HibernateException, Exception {
		int dataCount = 0;
		int pageCount;

		List ttlist = new ArrayList();
		Session session = HibernateSessionFactory.createFactory().openSession();
		Transaction tx = session.beginTransaction();
		Query q = session.createQuery("from KuaiXun tt");
		ttlist = q.list();
		dataCount = ttlist.size();
		session.close();
		return dataCount;
	}

	
	public List<KuaiXun> findByPage(String page,String rows)
			throws Exception {
		List ttlist = new ArrayList();
		Session session = null;
		KuaiXun tt = new KuaiXun();
		int currentpage = Integer.parseInt((page == null || page == "0") ? "1": page); 
		int pagesize = Integer.parseInt((rows == null || rows == "0") ? "10": rows);
		try {
			session = HibernateSessionFactory.createFactory()
					.openSession();
			Transaction tx = session.beginTransaction();
			Query q = session
					.createQuery("from KuaiXun tt order by tt.kxid desc");
			q.setFirstResult(pagesize * (currentpage  - 1));
			q.setMaxResults(pagesize);
			ttlist = q.list();

			session.getTransaction().commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			System.out.println("search false");
		}finally{
			session.close();
		}
		return ttlist;

	}
	public List<KuaiXun> findsearch(String s)
			throws Exception {
		List ttlist = new ArrayList();
		Session session = null;
		Tnews tt = new Tnews();
		try {
			 session = HibernateSessionFactory.createFactory()
					.openSession();
			Transaction tx = session.beginTransaction();
			Query q = session
					.createQuery("from KuaiXun tt where tt.title like ?");
			 q.setString(0,  "%"+s+"%");
			ttlist = q.list();
			session.getTransaction().commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			System.out.println("search false");
		}finally{
			session.close();
		}
		return ttlist;
	}
	public void update(KuaiXun tt) throws HibernateException, Exception{
		Session session = null;
		session = HibernateSessionFactory.createFactory().openSession();
		Transaction tx = session.beginTransaction();
		Query q = session.createQuery("" +
				"update KuaiXun tt set tt.title=?, tt.author=?, tt.date=?,tt.text=? where tt.kxid =?");
		q.setString(0, tt.getTitle());
		q.setString(1, tt.getAuthor());
		q.setString(2, tt.getDate());
		q.setString(3, tt.getText());
		q.setInteger(4, tt.getKxid());
		
		q.executeUpdate();
		tx.commit();
		session.close();	
	}
	public void deleteById(int kxid) {

//		SessionFactory sf = new AnnotationConfiguration().configure()
//				.buildSessionFactory();
		Session session;
		try {
			session = HibernateSessionFactory.createFactory().openSession();
			session.beginTransaction();
			Query q = session.createQuery("from KuaiXun pnews where pnews.kxid=?");
			q.setInteger(0, kxid);
			KuaiXun kuaixun = (KuaiXun) q.uniqueResult();
			session.delete(kuaixun);
			session.getTransaction().commit();
			session.close();
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 	
	}
	public void save(KuaiXun tt)
	{	 
	 
		Session session;
		try {
			 session = HibernateSessionFactory.createFactory().openSession();
			session.beginTransaction();
			
			session.save(tt);
			session.getTransaction().commit();
			session.close();
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 
		
	}
	
	public void updatefile(String filename,int id) throws HibernateException, Exception
	{Session session = null;
	session = HibernateSessionFactory.createFactory().openSession();
	Transaction tx = session.beginTransaction();
	Query q = session.createQuery("" +
			"update KuaiXun tt set tt.path=? where tt.kxid =?");
	q.setString(0, filename);
	 
	q.setInteger(1, id);
	
	q.executeUpdate();
	tx.commit();
	session.close();	
		
	}
}
