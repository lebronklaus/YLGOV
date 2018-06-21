package com.lee.service;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

import cn.nwsuaf.gov.service.HibernateSessionFactory;

import com.lee.mode.ZhengCe;

public class ZhengCeDAO {
	public ZhengCeDAO() {
	}

	public List<ZhengCe> findAll() throws HibernateException, Exception {
		 
		Session session =HibernateSessionFactory.createFactory().openSession();
		session.beginTransaction();

		List<ZhengCe> list = session.createQuery(
				"from ZhengCe news1 order by news1.zcid desc ").list();
		session.getTransaction().commit();
		session.close();
		return list;
	}

	public List<ZhengCe> findById(int id) throws Exception {
		List sftlist = new ArrayList();

		try {
		 
			Session session =HibernateSessionFactory.createFactory().openSession();
			session.beginTransaction();
			Query q = session
					.createQuery("from ZhengCe news2 where news2.zcid=?");
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

	public void save(ZhengCe zczhi) throws HibernateException, Exception {

		 
		Session session =HibernateSessionFactory.createFactory().openSession();
		session.beginTransaction();
		session.save(zczhi);
		session.getTransaction().commit();
		session.close();
	}

	public List<ZhengCe> findByPage(int pageSize, int pageNow) throws Exception {
		List<ZhengCe> sftlist = new ArrayList();
		try {

			 

			Session session =HibernateSessionFactory.createFactory().openSession();
			session.beginTransaction();

			Query q = session.createQuery("from ZhengCe news order by news.zcid desc ");

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
		 
		Session session = HibernateSessionFactory.createFactory().openSession();
		session.beginTransaction();
		Query q = session.createQuery("from ZhengCe pnews");
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

		 
		Session session =HibernateSessionFactory.createFactory().openSession();
		session.beginTransaction();
		Query q = session.createQuery("from ZhengCe pnews where pnews.zcid=?");
		q.setInteger(0, dtid);
		ZhengCe zhengce = (ZhengCe) q.uniqueResult();
		System.out.println("�й�");
		session.delete(zhengce);
		session.getTransaction().commit();
		session.close();
	}

	public List<ZhengCe> findByMark(int mark, int pageSize, int pageNow) throws HibernateException, Exception {
		 
		Session session = HibernateSessionFactory.createFactory().openSession();
		session.beginTransaction();
		Query q = session.createQuery("from ZhengCe pnews where pnews.mark=? order by pnews.zcid desc");
		q.setInteger(0, mark);
		q.setFirstResult(pageSize * (pageNow - 1));
		q.setMaxResults(pageSize);
		List<ZhengCe> zc = q.list();
		session.getTransaction().commit();
		session.close();
		return zc;
	}

	public int getRowsd(int pageSize, int mar) throws HibernateException, Exception {
		int dataCount = 0;
		int pageCount;
		List sftlist = new ArrayList();
//		SessionFactory sf = new AnnotationConfiguration().configure()
//				.buildSessionFactory();
		Session session = HibernateSessionFactory.createFactory().openSession();
		session.beginTransaction();
		Query q = session.createQuery("from ZhengCe pnews where pnews.mark=?");
		q.setInteger(0, mar);
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

}
