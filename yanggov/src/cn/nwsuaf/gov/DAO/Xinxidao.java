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
import cn.nwsuaf.gov.bean.Xinxi;
import cn.nwsuaf.gov.service.HibernateSessionFactory;

public class Xinxidao {

	// 增加园企信息
	public void add(Xinxi rc) throws Exception {

		Session session = HibernateSessionFactory.createFactory().openSession();
		Transaction tx = session.beginTransaction();
		rc.setTime(getTime());
		session.save(rc);
		tx.commit();
		session.close();
	}

	// 时间函数
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

	// 删除函数
	public void delete(int no) throws Exception {
		Session session = HibernateSessionFactory.createFactory().openSession();
		Transaction tx = session.beginTransaction();
		Xinxi tt = (Xinxi) session.get(Xinxi.class, no);
		if (tt != null) {
			session.delete(tt);
		}
		tx.commit();
		session.close();
	}

	// 获取列表
	public List<Xinxi> getList() throws Exception {
		Session session = HibernateSessionFactory.createFactory().openSession();
		Transaction tx = session.beginTransaction();
		String hql = "from Xinxi tt order by tt.id desc";
		Query query = session.createQuery(hql);
		List<Xinxi> ttlist = query.list();
		tx.commit();
		session.close();
		return ttlist;
	}

	// 按id查找
	public Xinxi getXinxi(int no) throws Exception {
		Session session = HibernateSessionFactory.createFactory().openSession();
		Transaction tx = session.beginTransaction();
		Xinxi tt = (Xinxi)session.get(Xinxi.class, no);
		tx.commit();
		session.close();
		return tt;
	}

	// /查找一页
	public List<Xinxi> findByPage(int pageSize, int pageNow) throws Exception {
		List ttlist = new ArrayList();
		Xinxi tt = new Xinxi();
		try {
			Session session = HibernateSessionFactory.createFactory()
					.openSession();
			Transaction tx = session.beginTransaction();
			Query q = session.createQuery("from Xinxi tt order by tt.id desc");
			ttlist = q.list();
			q.setFirstResult(pageSize * (pageNow - 1));
			q.setMaxResults(pageSize);
			ttlist = q.list();
			session.getTransaction().commit();
			session.close();
		} catch (HibernateException e) {
			e.printStackTrace();
			System.out.println("查询失败");
		}
		return ttlist;
	}

	// 获取总页数
	public int getTotalRows(int pageSize) throws HibernateException, Exception {
		int dataCount = 0;
		int pageCount;

		List ttlist = new ArrayList();
		Session session = HibernateSessionFactory.createFactory().openSession();
		Transaction tx = session.beginTransaction();
		Query q = session.createQuery("from Xinxi tt");
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

	// 获取前台企业页数
	public List<Xinxi> findByPageQy(int pageSize, int pageNow) throws Exception {
		List ttlist = new ArrayList();
		Xinxi tt = new Xinxi();
		try {
			Session session = HibernateSessionFactory.createFactory()
					.openSession();
			Transaction tx = session.beginTransaction();
			Query q = session
					.createQuery("from Xinxi tt where tt.shenhe=? and tt.mark=? order by tt.id desc");
			q.setInteger(0, 1);
			q.setInteger(1, 1);
			ttlist = q.list();
			q.setFirstResult(pageSize * (pageNow - 1));
			q.setMaxResults(pageSize);
			ttlist = q.list();
			session.getTransaction().commit();
			session.close();
		} catch (HibernateException e) {
			e.printStackTrace();
			System.out.println("查询失败");
		}
		return ttlist;
	}

	// 获取前台企业总页数
	public int getTotalRowsQy(int pageSize) throws HibernateException,
			Exception {
		int dataCount = 0;
		int pageCount;

		List ttlist = new ArrayList();
		Session session = HibernateSessionFactory.createFactory().openSession();
		Transaction tx = session.beginTransaction();
		Query q = session
				.createQuery("from Xinxi tt where tt.shenhe=? and tt.mark=?");
		q.setInteger(0, 1);
		q.setInteger(1, 1);
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

	// 获取前台园区页数
	public List<Xinxi> findByPageYq(int pageSize, int pageNow) throws Exception {
		List ttlist = new ArrayList();
		Xinxi tt = new Xinxi();
		Session session = null;
		try {
			 session = HibernateSessionFactory.createFactory()
					.openSession();
			Transaction tx = session.beginTransaction();
			Query q = session
					.createQuery("from Xinxi tt where tt.shenhe=? and tt.mark=? order by tt.id desc");
			q.setInteger(0, 1);
			q.setInteger(1, 2);
			ttlist = q.list();
			q.setFirstResult(pageSize * (pageNow - 1));
			q.setMaxResults(pageSize);
			ttlist = q.list();
			session.getTransaction().commit();
			session.close();
		} catch (HibernateException e) {
			e.printStackTrace();
			session.close();
			System.out.println("查询失败");
		}
		return ttlist;
	}

	// 获取前台园区总页数
	public int getTotalRowsYq(int pageSize) throws HibernateException,
			Exception {
		int dataCount = 0;
		int pageCount;

		List ttlist = new ArrayList();
		Session session = HibernateSessionFactory.createFactory().openSession();
		Transaction tx = session.beginTransaction();
		Query q = session
				.createQuery("from Xinxi tt where tt.shenhe=? and tt.mark=?");
		q.setInteger(0, 1);
		q.setInteger(1, 2);
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

	// 更新信息
	public void update(int id) {
		SessionFactory sf = new AnnotationConfiguration().configure()
				.buildSessionFactory();
		Session session = sf.getCurrentSession();
		session.beginTransaction();
		Query q = session
				.createQuery("update Xinxi t set t.shenhe = 1 where id = ?");
		q.setInteger(0, id);
		q.executeUpdate();
		session.getTransaction().commit();
	}

	// 用于主页列表显示
	public List<Xinxi> findByPageBe(int pageSize, int pageNow) throws Exception {
		List ttlist = new ArrayList();
		Xinxi tt = new Xinxi();
		try {
			Session session = HibernateSessionFactory.createFactory()
					.openSession();
			Transaction tx = session.beginTransaction();
			Query q = session
					.createQuery("from Xinxi tt where shenhe = ? order by tt.id desc");
			q.setInteger(0, 1);
			ttlist = q.list();
			q.setFirstResult(pageSize * (pageNow - 1));
			q.setMaxResults(pageSize);
			ttlist = q.list();
			session.getTransaction().commit();
			session.close();
		} catch (HibernateException e) {
			e.printStackTrace();
			System.out.println("查询失败");
		}
		return ttlist;
	}

	// 获取主页园企总页数
	public int getTotalRowsBe(int pageSize) throws HibernateException,
			Exception {
		int dataCount = 0;
		int pageCount;

		List ttlist = new ArrayList();
		Session session = HibernateSessionFactory.createFactory().openSession();
		Transaction tx = session.beginTransaction();
		Query q = session.createQuery("from Xinxi tt where tt.shenhe=? ");
		q.setInteger(0, 1);
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

}