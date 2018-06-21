package com.lee.service;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

import cn.nwsuaf.gov.service.HibernateSessionFactory;

import com.lee.mode.KuaiXun;

public class KuaiXunDAO {

	public KuaiXunDAO() {
	}

	public List<KuaiXun> findAll() {
		 
		// SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session;
		try {
			session = HibernateSessionFactory.createFactory().openSession();
			session.beginTransaction();

			List<KuaiXun> list = session.createQuery(
					"from KuaiXun news3 order by news3.kxid desc").list();
			session.getTransaction().commit();
			session.close();
			return list;
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public List<KuaiXun> findById(int id) throws Exception {
		List sftlist = new ArrayList();

		try {
			 
			Session session =HibernateSessionFactory.createFactory().openSession();
			session.beginTransaction();
			Query q = session
					.createQuery("from KuaiXun news where news.kxid=?");
			q.setInteger(0, id);
			sftlist = q.list();
			session.getTransaction().commit();
			session.close();
			System.out.println("cumtzhongguo1111");
		} catch (HibernateException e) {
			e.printStackTrace();
			System.out.println("��ѯʧ��");
		}
		return sftlist;
	}

	public void save(KuaiXun tzhi) throws HibernateException, Exception  {
//		SessionFactory sf = new AnnotationConfiguration().configure()
//				.buildSessionFactory();

		Session session =HibernateSessionFactory.createFactory().openSession();
		session.beginTransaction();
		session.save(tzhi);

		// session.flush();
		session.getTransaction().commit();
		session.close();
	}

	public List<KuaiXun> findByPage(int pageSize, int pageNow) throws Exception {
		List<KuaiXun> sftlist = new ArrayList();
		// TZnews tnews = new TZnews();
		try {

			 

			Session session =HibernateSessionFactory.createFactory().openSession();
			session.beginTransaction();

			Query q = session.createQuery("from KuaiXun news order by news.kxid desc");

			q.setFirstResult(pageSize * (pageNow - 1));
			q.setMaxResults(pageSize);
			sftlist = q.list();

			session.getTransaction().commit();
			session.close();
		} catch (HibernateException e) {
			e.printStackTrace();
			System.out.println("��ѯʧ��");
		}
		return sftlist;

	}

	public int getRows(int pageSize) throws HibernateException, Exception {
		int dataCount = 0;
		int pageCount;
		List sftlist = new ArrayList();
//		SessionFactory sf = new AnnotationConfiguration().configure()
//				.buildSessionFactory();
		Session session = HibernateSessionFactory.createFactory().openSession();
		session.beginTransaction();
		Query q = session.createQuery("from KuaiXun pnews");
		sftlist = q.list();
		dataCount = sftlist.size();

		if (dataCount % pageSize == 0) {
			pageCount = dataCount / pageSize;
		} else {
			pageCount = dataCount / pageSize + 1;
		}
		session.getTransaction().commit();
		session.close();
		return pageCount;
	}

	public void deleteById(int kxid) throws HibernateException, Exception {

//		SessionFactory sf = new AnnotationConfiguration().configure()
//				.buildSessionFactory();
		Session session = HibernateSessionFactory.createFactory().openSession();
		session.beginTransaction();
		Query q = session.createQuery("from KuaiXun pnews where pnews.kxid=?");
		q.setInteger(0, kxid);
		KuaiXun kuaixun = (KuaiXun) q.uniqueResult();
		session.delete(kuaixun);
		session.getTransaction().commit();
		session.close();
	}

}
