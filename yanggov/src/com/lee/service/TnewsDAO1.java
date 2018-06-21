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

import com.lee.mode.Tnews;

public class TnewsDAO1 {
	/**
	 * @author Zhitao.Chen
	 * @param s
	 * @return
	 * @throws Exception
	 */
	public List<Tnews> Search(String name)
			throws Exception {
		List ttlist = new ArrayList();
		Session session = null;
		Tnews tt = new Tnews();
		try {
			 session = HibernateSessionFactory.createFactory()
					.openSession();
			Transaction tx = session.beginTransaction();
			Query q = session
					.createQuery("from Tnews tt where tt.title like:name");
			 q.setString("name","%"+name+"%");
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
		Query q = session.createQuery("from Tnews tt");
		ttlist = q.list();
		dataCount = ttlist.size();
		session.close();
		return dataCount;
	}

	// ���һҳ�б�
	public List<Tnews> findByPage(String page,String rows)
			throws Exception {
		List ttlist = new ArrayList();
		Session session = null;
		Tnews tt = new Tnews();
		int currentpage = Integer.parseInt((page == null || page == "0") ? "1": page);//�ڼ�ҳ  
	    int pagesize = Integer.parseInt((rows == null || rows == "0") ? "10": rows);//ÿҳ������ 
		try {
			 session = HibernateSessionFactory.createFactory()
					.openSession();
			Transaction tx = session.beginTransaction();
			Query q = session
					.createQuery("from Tnews tt order by tt.id desc");
			q.setFirstResult(pagesize * (currentpage  - 1));
			q.setMaxResults(pagesize);
			ttlist = q.list();

			session.getTransaction().commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			System.out.println("��ѯʧ��");
		}finally{
			session.close();
		}
		return ttlist;

	}
	
	
	public List<Tnews> findsearch(String s)
			throws Exception {
		List ttlist = new ArrayList();
		Session session = null;
		Tnews tt = new Tnews();
		 System.out.println("��ļ���"+s);
		try {
			 session = HibernateSessionFactory.createFactory()
					.openSession();
			Transaction tx = session.beginTransaction();
			Query q = session
					.createQuery("from Tnews tt where tt.title like ?");
			 q.setString(0, "%"+s+"%");
			ttlist = q.list();
			session.getTransaction().commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			System.out.println("��ѯʧ��");
		}finally{
			session.close();
		}
		return ttlist;
	}
	
	
	public void update(Tnews tt) throws HibernateException, Exception{
		Session session = null;
		session = HibernateSessionFactory.createFactory().openSession();
		Transaction tx = session.beginTransaction();
		Query q = session.createQuery("" +
				"update Tnews tt set tt.title=?, tt.author=?, tt.date=?,tt.text=? where tt.id =?");
		q.setString(0, tt.getTitle());
		q.setString(1, tt.getAuthor());
		q.setString(2, tt.getDate());
		q.setString(3, tt.getText());
		q.setInteger(4, tt.getId());
		
		q.executeUpdate();
		tx.commit();
		session.close();	
	}
	public void deltz(int num) throws HibernateException, Exception
	{
//		SessionFactory sf = new AnnotationConfiguration().configure()
//				.buildSessionFactory();
		Session session = HibernateSessionFactory.createFactory().openSession();
		session.beginTransaction();
		Query q = session.createQuery("from Tnews news where news.id=?");
		q.setInteger(0, num);
		Tnews tnews = (Tnews) q.uniqueResult();
		session.delete(tnews);
		session.getTransaction().commit();
		session.close();
	}
	
	public void updatefile(String filename,int id) throws HibernateException, Exception
	{Session session = null;
	session = HibernateSessionFactory.createFactory().openSession();
	Transaction tx = session.beginTransaction();
	Query q = session.createQuery("" +
			"update Tnews tt set tt.filename=? where tt.id =?");
	q.setString(0, filename);
	 
	q.setInteger(1, id);
	
	q.executeUpdate();
	tx.commit();
	session.close();	
		
	}
	
	public void savefile(Tnews tt) throws HibernateException, Exception
	{	 
		System.out.println("ddddddddddddd");
//		SessionFactory sf = new AnnotationConfiguration().configure()
//				.buildSessionFactory();
		Session session =HibernateSessionFactory.createFactory().openSession();
		session.beginTransaction();
		
		session.save(tt);
		session.getTransaction().commit();
		session.close();
	}
	
	
 
}
