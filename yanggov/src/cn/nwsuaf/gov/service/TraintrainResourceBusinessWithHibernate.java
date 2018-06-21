package cn.nwsuaf.gov.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import cn.nwsuaf.gov.model.Train_Base;
import cn.nwsuaf.gov.model.Train_Resource;

public class TraintrainResourceBusinessWithHibernate implements
		TrainResourceBusiness {

	@Override
	public void add(String resources_title, String resources_colum,
			String resources_from, String resources_author,
			String resources_profile, String resources_path)  {

		Session session = null;
		try {
			session = HibernateSessionFactory.createFactory().openSession();
			Transaction tx = session.beginTransaction();
			Train_Resource tt = new Train_Resource();

			tt.setResources_author(resources_author);
			tt.setResources_colum(resources_colum);
			tt.setResources_from(resources_from);
			tt.setResources_profile(resources_profile);
			tt.setResources_time(getTime());
			tt.setResources_title(resources_title); 
			tt.setResources_path(resources_path);
			session.save(tt);
			tx.commit();
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			session.getTransaction().rollback();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			session.close();
		}
		
		

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

	@Override
	public void delete(int no) throws Exception {
		Session session = HibernateSessionFactory.createFactory().openSession();
		Transaction tx = session.beginTransaction();
		Train_Resource tt = (Train_Resource) session.get(Train_Resource.class,
				no);
		if (tt != null) {
			session.delete(tt);
		}
		tx.commit();
		session.close();
	}

	@Override
	public List<Train_Resource> getList() throws Exception {
		Session session = HibernateSessionFactory.createFactory().openSession();
		Transaction tx = session.beginTransaction();

		String hql = "from Train_Resource tt order by tt.resources_id desc";
		Query query = session.createQuery(hql);
		List<Train_Resource> ttlist = query.list();
		tx.commit();
		session.close();
		return ttlist;
	}

	@Override
	public Train_Resource getTrainResource(int no) throws Exception {
		Session session = HibernateSessionFactory.createFactory().openSession();
		Transaction tx = session.beginTransaction();
		Train_Resource tt = (Train_Resource) session.get(Train_Resource.class,
				no);
		session.close();
		return tt;
	}

	@Override
	public List<Train_Resource> findByPage(int pageSize, int pageNow)
			throws Exception {
		List ttlist = new ArrayList();
		Session session = null;
		Train_Base tt = new Train_Base();
		try {
			session = HibernateSessionFactory.createFactory()
					.openSession();
			Transaction tx = session.beginTransaction();
			Query q = session
					.createQuery("from Train_Resource tt order by tt.resources_id desc");

			q.setFirstResult(pageSize * (pageNow - 1));
			q.setMaxResults(pageSize);
			ttlist = q.list();

			session.getTransaction().commit();
			session.close();
		} catch (HibernateException e) {
			e.printStackTrace();
			session.close();
			System.out.println("异常");
			
		}
		return ttlist;
	}

	@Override
	public List<Train_Resource> findByPageGb(int pageSize, int pageNow)
			throws Exception {
		List ttlist = new ArrayList();
		Train_Base tt = new Train_Base();
		Session session = null;
		try {
			session = HibernateSessionFactory.createFactory()
					.openSession();
			Transaction tx = session.beginTransaction();
			Query q = session
					.createQuery("from Train_Resource tt where tt.resources_colum='gb' order by tt.resources_id desc");

			q.setFirstResult(pageSize * (pageNow - 1));
			q.setMaxResults(pageSize);
			ttlist = q.list();

			session.getTransaction().commit();
			session.close();
		} catch (HibernateException e) {
			e.printStackTrace();
			System.out.println("数据库异常");
			session.close();
		}
		return ttlist;
	}

	@Override
	public List<Train_Resource> findByPageSp(int pageSize, int pageNow)
			throws Exception {
		List ttlist = new ArrayList();
		Train_Base tt = new Train_Base();
		Session session = null;
		try {
			session = HibernateSessionFactory.createFactory()
					.openSession();
			Transaction tx = session.beginTransaction();
			Query q = session
					.createQuery("from Train_Resource tt where tt.resources_colum='sp' order by tt.resources_id desc");
			q.setFirstResult(pageSize * (pageNow - 1));
			q.setMaxResults(pageSize);
			ttlist = q.list();

			session.getTransaction().commit();
			session.close();
		} catch (HibernateException e) {
			e.printStackTrace();
			System.out.println("数据库异常");
			session.close();
		}
		return ttlist;
	}

	@Override
	public List<Train_Resource> findByPageWg(int pageSize, int pageNow)
			throws Exception {
		List ttlist = new ArrayList();
		Session session = null;
		Train_Base tt = new Train_Base();
		try {
			session = HibernateSessionFactory.createFactory()
					.openSession();
			Transaction tx = session.beginTransaction();
			Query q = session
					.createQuery("from Train_Resource tt where tt.resources_colum='wg' order by tt.resources_id desc");
			q.setFirstResult(pageSize * (pageNow - 1));
			q.setMaxResults(pageSize);
			ttlist = q.list();

			session.getTransaction().commit();
			session.close();
		} catch (HibernateException e) {
			e.printStackTrace();
			System.out.println("数据库异常");
			session.close();
		}
		return ttlist;
	}

	@Override
	public int getTotalRows(int pageSize) throws HibernateException, Exception {
		int dataCount = 0;
		int pageCount;

		List ttlist = new ArrayList();
		Session session = HibernateSessionFactory.createFactory().openSession();
		Transaction tx = session.beginTransaction();
		Query q = session
				.createQuery("from Train_Resource tt order by tt.resources_id desc");
		ttlist = q.list();
		dataCount = ttlist.size();

		if (dataCount % pageSize == 0) {
			pageCount = dataCount / pageSize;
		} else {
			pageCount = dataCount / pageSize + 1;
		}
		session.close();
		return pageCount;
	}

	// ��ȡ��Ƶҳ��
	@Override
	public int getTotalRowsSp(int pageSize) throws HibernateException,
			Exception {
		int dataCount = 0;
		int pageCount;

		List ttlist = new ArrayList();
		Session session = HibernateSessionFactory.createFactory().openSession();
		Transaction tx = session.beginTransaction();
		Query q = session
				.createQuery("from Train_Resource tt where tt.resources_colum='sp' order by tt.resources_id desc");
		ttlist = q.list();
		dataCount = ttlist.size();

		if (dataCount % pageSize == 0) {
			pageCount = dataCount / pageSize;
		} else {
			pageCount = dataCount / pageSize + 1;
		}
		session.close();
		return pageCount;
	}

	@Override
	public int getTotalRowsGb(int pageSize) throws HibernateException,
			Exception {
		int dataCount = 0;
		int pageCount;

		List ttlist = new ArrayList();
		Session session = HibernateSessionFactory.createFactory().openSession();
		Transaction tx = session.beginTransaction();
		Query q = session
				.createQuery("from Train_Resource tt where tt.resources_colum='gb' order by tt.resources_id desc");
		ttlist = q.list();
		dataCount = ttlist.size();

		if (dataCount % pageSize == 0) {
			pageCount = dataCount / pageSize;
		} else {
			pageCount = dataCount / pageSize + 1;
		}
		session.close();
		return pageCount;
	}

	@Override
	public int getTotalRowsWg(int pageSize) throws HibernateException,
			Exception {
		int dataCount = 0;
		int pageCount;

		List ttlist = new ArrayList();
		Session session = HibernateSessionFactory.createFactory().openSession();
		Transaction tx = session.beginTransaction();
		Query q = session
				.createQuery("from Train_Resource tt where tt.resources_colum='wg' order by tt.resources_id desc");
		ttlist = q.list();
		dataCount = ttlist.size();

		if (dataCount % pageSize == 0) {
			pageCount = dataCount / pageSize;
		} else {
			pageCount = dataCount / pageSize + 1;
		}
		tx.commit();
		session.close();
		return pageCount;
	}

}
