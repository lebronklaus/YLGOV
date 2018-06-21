package cn.nwsuaf.gov.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import cn.nwsuaf.gov.model.Train_Base;

public class TrainBaseBusinessWithHibernate implements TrainBaseBusiness {

	@Override
	public void add(String base_name, String base_profile, String base_contact,
			String base_path1, String base_path2) throws Exception {
		Session session = HibernateSessionFactory.createFactory().openSession();
		Transaction tx = session.beginTransaction();
		Train_Base tt = new Train_Base();

		tt.setBase_name(base_name);
		tt.setBase_profile(base_profile);
		tt.setBase_contact(base_contact);
		tt.setBase_time(getTime());
		tt.setBase_path1(base_path1);
		tt.setBase_path2(base_path2);
		session.save(tt);
		tx.commit();
		session.close();
	}

	@Test
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
		Train_Base tt = (Train_Base) session.get(Train_Base.class, no);
		if (tt != null) {
			session.delete(tt);
		}
		tx.commit();
		session.close();

	}

	@Override
	public List<Train_Base> getList() throws Exception {
		Session session = HibernateSessionFactory.createFactory().openSession();
		Transaction tx = session.beginTransaction();
		String hql = "from Train_Base tt order by tt.base_id desc";
		Query query = session.createQuery(hql);
		List<Train_Base> ttlist = query.list();
		tx.commit();
		session.close();
		return ttlist;
	}

	@Override
	public Train_Base getTrainBase(int no) throws Exception {
		Session session = HibernateSessionFactory.createFactory().openSession();
		Transaction tx = session.beginTransaction();
		Train_Base tt = (Train_Base) session.get(Train_Base.class, no);
		session.close();
		return tt;
	}

	@Override
	public List<Train_Base> findByPage(int pageSize, int pageNow)
			throws Exception {
		List ttlist = new ArrayList();
		Train_Base tt = new Train_Base();
		Session session = HibernateSessionFactory.createFactory()
				.openSession();
		try {
			
			Transaction tx = session.beginTransaction();
			Query q = session
					.createQuery("from Train_Base tt order by tt.base_id desc");

			q.setFirstResult(pageSize * (pageNow - 1));
			q.setMaxResults(pageSize);
			ttlist = q.list();

			session.getTransaction().commit();
			
		} catch (HibernateException e) {
			e.printStackTrace();
			System.out.println("seach false");
		}finally{
			session.close();
		}
		return ttlist;

	}

	@Override
	public int getTotalRows(int pageSize) {
		int dataCount = 0;
		int pageCount = 0;
		Session session = null;
		List ttlist = new ArrayList();
		try{
		 session = HibernateSessionFactory.createFactory().openSession();
		Transaction tx = session.beginTransaction();
		Query q = session.createQuery("from Train_Base tt");
		ttlist = q.list();
		dataCount = ttlist.size();

		if (dataCount % pageSize == 0) {
			pageCount = dataCount / pageSize;
		} else {
			pageCount = dataCount / pageSize + 1;
		}
		}
		catch(Exception e){
			e.printStackTrace();
			session.getTransaction().rollback();
		}finally{
			session.close();
		}
		return pageCount;
	}

}
