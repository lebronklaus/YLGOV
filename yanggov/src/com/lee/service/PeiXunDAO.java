package com.lee.service;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

import cn.nwsuaf.gov.service.HibernateSessionFactory;

import com.lee.mode.PeiXun;

public class PeiXunDAO {

	public PeiXunDAO() {
	}

	public List<PeiXun> findAll() throws HibernateException, Exception {
//		SessionFactory sf = new AnnotationConfiguration().configure()
//				.buildSessionFactory();
		// SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = HibernateSessionFactory.createFactory().openSession();
		session.beginTransaction();

		List<PeiXun> list = session.createQuery(
				"from PeiXun news order by news.dtid desc").list();
		session.getTransaction().commit();
		session.close();
		return list;
	}

	public List<PeiXun> findById(int id) throws Exception {
		List sftlist = new ArrayList();

		try {
//			SessionFactory sf = new AnnotationConfiguration().configure()
//					.buildSessionFactory();
			Session session = HibernateSessionFactory.createFactory().openSession();
			session.beginTransaction();
			Query q = session.createQuery("from PeiXun news where news.dtid=?");
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

	public void save(PeiXun tzhi) throws HibernateException, Exception {
//		SessionFactory sf = new AnnotationConfiguration().configure()
//				.buildSessionFactory();

		Session session = HibernateSessionFactory.createFactory().openSession();
		session.beginTransaction();
		session.save(tzhi);

		// session.flush();
		session.getTransaction().commit();
		session.close();
	}

	public List<PeiXun> findByPage(int pageSize, int pageNow) throws Exception {
		List<PeiXun> sftlist = new ArrayList();
		// TZnews tnews = new TZnews();
		try {

			Session session = HibernateSessionFactory.createFactory().openSession();
			session.beginTransaction();

			Query q = session.createQuery("from PeiXun news order by news.dtid desc");

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
		Session session =HibernateSessionFactory.createFactory().openSession();
		session.beginTransaction();
		Query q = session.createQuery("from PeiXun pnews");
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

	public void deleteById(int dtid) throws HibernateException, Exception {

//		SessionFactory sf = new AnnotationConfiguration().configure()
//				.buildSessionFactory();
		Session session = HibernateSessionFactory.createFactory().openSession();
		session.beginTransaction();
		Query q = session.createQuery("from PeiXun pnews where pnews.dtid=?");
		q.setInteger(0, dtid);
		PeiXun peixun = (PeiXun) q.uniqueResult();
		session.delete(peixun);
		session.getTransaction().commit();
		session.close();
	}

}
