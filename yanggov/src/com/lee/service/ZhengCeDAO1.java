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

import com.lee.mode.PeiXun;
import com.lee.mode.Tnews;
import com.lee.mode.ZhengCe;

public class ZhengCeDAO1 {
	/**
	 * @author Zhitao.Chen
	 * @param name
	 * @return
	 * @throws Exception
	 */
	public List<ZhengCe> Search(String name)
			throws Exception {
		List ttlist = new ArrayList();
		Session session = null;
		Tnews tt = new Tnews();
		try {
			 session = HibernateSessionFactory.createFactory()
					.openSession();
			Transaction tx = session.beginTransaction();
			Query q = session
					.createQuery("from ZhengCe tt where tt.title like:name");
			 q.setString("name", "%"+name+"%");
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
		Query q = session.createQuery("from ZhengCe tt");
		ttlist = q.list();
		dataCount = ttlist.size();
		session.close();
		return dataCount;
	}

	// ���һҳ�б�
	public List<ZhengCe> findByPage(String page,String rows)
			throws Exception {
		List ttlist = new ArrayList();
		Session session = null;
		ZhengCe tt = new ZhengCe();
		int currentpage = Integer.parseInt((page == null || page == "0") ? "1": page);//�ڼ�ҳ  
	    int pagesize = Integer.parseInt((rows == null || rows == "0") ? "10": rows);//ÿҳ������ 
		try {
			 session = HibernateSessionFactory.createFactory()
					.openSession();
			Transaction tx = session.beginTransaction();
			Query q = session
					.createQuery("from ZhengCe tt order by tt.zcid desc");
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
	public List<ZhengCe> findsearch(String s)
			throws Exception {
		List ttlist = new ArrayList();
		Session session = null;
		Tnews tt = new Tnews();
		int a= Integer.parseInt(s);
		 System.out.println("��ļ���"+s);
		try {
			 session = HibernateSessionFactory.createFactory()
					.openSession();
			Transaction tx = session.beginTransaction();
			Query q = session
					.createQuery("from ZhengCe tt where tt.mark=?");
			 q.setInteger(0, a);
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
	public void update(ZhengCe tt) throws HibernateException, Exception{
		Session session = null;
		session = HibernateSessionFactory.createFactory().openSession();
		Transaction tx = session.beginTransaction();
		Query q = session.createQuery("" +
				"update ZhengCe tt set tt.title=?, tt.fabujigou=?, tt.wenhao=?,tt.date=?,tt.text=? ,tt.mark=? where tt.zcid =?");
		q.setString(0, tt.getTitle());
		q.setString(1, tt.getFabujigou());
		q.setString(2, tt.getWenhao());
		q.setString(3, tt.getDate());
		q.setString(4, tt.getText());
		q.setInteger(5, tt.getMark());
		q.setInteger(6, tt.getZcid());
		
		q.executeUpdate();
		tx.commit();
		session.close();	
	}

	public void deleteById(int dtid) {

		SessionFactory sf = new AnnotationConfiguration().configure()
				.buildSessionFactory();
		Session session = sf.getCurrentSession();
		session.beginTransaction();
		Query q = session.createQuery("from ZhengCe pnews where pnews.zcid=?");
		q.setInteger(0, dtid);
		ZhengCe zhengce = (ZhengCe) q.uniqueResult();
		session.delete(zhengce);
		session.getTransaction().commit();
	}
	
	public void save(ZhengCe tzhi) throws HibernateException, Exception {
		 
//		SessionFactory sf = new AnnotationConfiguration().configure()
//				.buildSessionFactory();

		Session session =HibernateSessionFactory.createFactory().openSession();
		session.beginTransaction();
		session.save(tzhi);

		// session.flush();
		session.getTransaction().commit();
		session.close();
	}
	public void updatefile(String filename,int id) throws HibernateException, Exception
	{Session session = null;
	session = HibernateSessionFactory.createFactory().openSession();
	Transaction tx = session.beginTransaction();
	Query q = session.createQuery("" +
			"update ZhengCe tt set tt.filename=? where tt.zcid =?");
	q.setString(0, filename);
	 
	q.setInteger(1, id);
	
	q.executeUpdate();
	tx.commit();
	session.close();	
		
	}
}
