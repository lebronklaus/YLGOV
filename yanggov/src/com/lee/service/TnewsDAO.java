package com.lee.service;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

import cn.nwsuaf.gov.service.HibernateSessionFactory;

import com.lee.action.TZnews;
import com.lee.mode.Tnews;

public class TnewsDAO {

	public TnewsDAO() {
	}

	public void save(Tnews tzhi) throws HibernateException, Exception {
//		SessionFactory sf = new AnnotationConfiguration().configure()
//				.buildSessionFactory();
		Session session = HibernateSessionFactory.createFactory().openSession();
		session.beginTransaction();
		session.save(tzhi);
		session.getTransaction().commit();
		session.close();
	}

	public List<Tnews> findAll() throws HibernateException, Exception {
		System.out.println("ddddddddddddd");
//		SessionFactory sf = new AnnotationConfiguration().configure()
//				.buildSessionFactory();
		Session session = HibernateSessionFactory.createFactory().openSession();
		session.beginTransaction();
		List<Tnews> list = session.createQuery(
				"from Tnews news order by news.id desc ").list();
		session.getTransaction().commit();
		session.close();
		return list;
	}

	public List<Tnews> findByPage(int pageSize, int pageNow) throws Exception {
		System.out.println("dasdhdafsfdfsdfsdf");
		List sftlist = new ArrayList();
		TZnews tnews = new TZnews();
		try {

//			SessionFactory sf = new AnnotationConfiguration().configure()
//					.buildSessionFactory();

			Session session = HibernateSessionFactory.createFactory().openSession();
			session.beginTransaction();

			Query q = session.createQuery("from Tnews news order by news.id desc");

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

	// ��ȡ�ܵ�ҳ��
	public int getRows(int pageSize) throws HibernateException, Exception {
		int dataCount = 0;
		int pageCount;
		List sftlist = new ArrayList();
//		SessionFactory sf = new AnnotationConfiguration().configure()
//				.buildSessionFactory();
		Session session = HibernateSessionFactory.createFactory().openSession();
		session.beginTransaction();
		Query q = session.createQuery("from Tnews tnews");
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

	// ɾ����
	public void deleteById(int id) throws HibernateException, Exception {
		SessionFactory sf = new AnnotationConfiguration().configure()
				.buildSessionFactory();
		Session session = HibernateSessionFactory.createFactory().openSession();
		session.beginTransaction();
		Query q = session.createQuery("from Tnews news where news.id=?");
		q.setInteger(0, id);
		Tnews tnews = (Tnews) q.uniqueResult();
		session.delete(tnews);
		session.getTransaction().commit();
		session.close();
	}

	// ���id���в�ѯ
	public List<Tnews> findById(int id) throws Exception {
		List sftlist = new ArrayList();

		try {
//			SessionFactory sf = new AnnotationConfiguration().configure()
//					.buildSessionFactory();
			Session session = HibernateSessionFactory.createFactory().openSession();
			session.beginTransaction();
			Query q = session.createQuery("from Tnews news where news.id=?");
			q.setInteger(0, id);
			sftlist = q.list();
			session.getTransaction().commit();
			session.close();
		} catch (HibernateException e) {
			e.printStackTrace();
			System.out.println("��ѯʧ��");
		}
		return sftlist;
	}

}
