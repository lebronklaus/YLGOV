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

import cn.nwsuaf.gov.bean.RenCaiXuQiu;
import cn.nwsuaf.gov.service.HibernateSessionFactory;

public class RenCaidao {
	public void add(RenCaiXuQiu rc) throws Exception {

		Session session = HibernateSessionFactory.createFactory().openSession();
		Transaction tx = session.beginTransaction();
		rc.setInputdate(getTime());
		session.save(rc);
		tx.commit();
		session.close();
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
	public List<RenCaiXuQiu> findByPage(int pageSize, int pageNow) {
		List<RenCaiXuQiu> sftlist = new ArrayList<RenCaiXuQiu>();

		try {

			SessionFactory sf = new AnnotationConfiguration().configure()
					.buildSessionFactory();

			Session session = sf.getCurrentSession();
			session.beginTransaction();

			Query q = session.createQuery("from RenCaiXuQiu news ");
			q.setFirstResult(pageSize * (pageNow - 1));
			q.setMaxResults(pageSize);
			sftlist = q.list();

			session.getTransaction().commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			System.out.println("查询失败");
		}
		return sftlist;
	}

	/**
	 * @author Zhitao.Chen
	 * @param pageSize
	 * @param pageNow
	 * @return
	 */
	public List<RenCaiXuQiu> findByPageQt(int pageSize, int pageNow) {
		List<RenCaiXuQiu> sftlist = new ArrayList<RenCaiXuQiu>();
		Session session = null;
		try {
			session = HibernateSessionFactory.createFactory()
					.openSession();
			Transaction tx = session.beginTransaction();
			Query q = session
					.createQuery("from RenCaiXuQiu rc where rc.shenhe=?  order by rc.id desc");
			q.setInteger(0, 1);
			q.setFirstResult(pageSize * (pageNow - 1));
			q.setMaxResults(pageSize);
			sftlist = q.list();

			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("查询失败");
		}finally{
			if(session.isOpen()){
				session.close();
			}
		}
		return sftlist;
	}

	/**
	 * @author Zhitao.Chen
	 * @param pageSize
	 * @return
	 */
	// 获取总得页数
	public int getRows(int pageSize) {
		int dataCount = 0;
		int pageCount;
		List sftlist = new ArrayList();
		Session session = null;
		try {
			session = HibernateSessionFactory.createFactory()
					.openSession();
			Transaction tx = session.beginTransaction();
			Query q = session.createQuery("from RenCaiXuQiu rc where rc.shenhe=? order by rc.id desc");
			q.setInteger(0, 1);
			tx.commit();
			sftlist = q.list();
			dataCount = sftlist.size();
			
		} catch (HibernateException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			if(session.isOpen()){
				session.close();
			}
		}
		
		if (dataCount % pageSize == 0) {
			pageCount = dataCount / pageSize;
		} else {
			pageCount = dataCount / pageSize + 1;
		}
		return pageCount;
	}

	// 更新插入
	public void update(RenCaiXuQiu rc) {
		SessionFactory sf = new AnnotationConfiguration().configure()
				.buildSessionFactory();
		Session session = sf.getCurrentSession();
		session.beginTransaction();
		Query q = session
				.createQuery("update RenCaiXuQiu t set t.gangwei = ?,t.renshu = ?,t.daogangtime = ?,t.discrip = ?,t.sex = ?,t.agerank = ?,t.xueli = ?,t.major = ?,"
						+ "t.experience = ?,t.shuoming = ?,t.salary = ?, t.mark = ? where id = ?");
		q.setString(0, rc.getGangwei());
		q.setString(1, rc.getRenshu());
		q.setString(2, rc.getDaogangtime());
		q.setString(3, rc.getDiscrip());
		q.setString(4, rc.getSex());
		q.setString(5, rc.getAgerank());
		q.setString(6, rc.getXueli());
		q.setString(7, rc.getMajor());
		q.setString(8, rc.getExperience());
		q.setString(9, rc.getShuoming());
		q.setString(10, rc.getSalary());
		q.setInteger(11, rc.getMark());
		q.setInteger(12, rc.getId());
		q.executeUpdate();
		session.getTransaction().commit();
	}

	/**
	 * @author Zhitao.Chen
	 * @param id
	 * @return
	 */
	// 按id查找
	public List<RenCaiXuQiu> findById(int id) {
		List<RenCaiXuQiu> sftlist = new ArrayList<RenCaiXuQiu>();
		Session session = null;
		try {
			session = HibernateSessionFactory.createFactory()
					.openSession();
			Transaction tx = session.beginTransaction();
			Query q = session.createQuery("from RenCaiXuQiu rc where rc.id=?");
			q.setInteger(0, id);
			sftlist = q.list();
			tx.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			if(session.isOpen()){
				session.close();
			}
		}
		
		return sftlist;
	}
}
