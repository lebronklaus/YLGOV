package cn.nwsuaf.gov.service;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.apache.struts2.ServletActionContext;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import cn.nwsuaf.gov.model.Train_Teachers;

public class TrainTeacherService  {

	//删除原来重复的照片，在修改教师信息的时候才用此函数，在第一次发布的时候没有破
	public void delImage(int num ,String teapath) throws HibernateException, Exception {
		Session session = HibernateSessionFactory.createFactory().openSession();
		Transaction tx = session.beginTransaction();
		String path = null;
		String hql = "from Train_Teachers tt where tt.teacher_id=?";
		Query query = session.createQuery(hql);
		query.setInteger(0, num);
		List<Train_Teachers> ttlist = query.list();
		Train_Teachers tr = ttlist.get(0);
		tx.commit();
		String picture = tr.getTeacher_path();
		if(!teapath.equals(picture)){
			path = ServletActionContext.getServletContext().getRealPath(
					"/upload/media/image")
					+ "\\" + picture;
			File wg = new File(path);
			if (wg.exists()) {
				wg.delete();
			}
			Transaction tst = session.beginTransaction();
			Query q =  session.createQuery("" +
					"update Train_Teachers tt set tt.teacher_path=? where tt.teacher_id =?");
			q.setString(0, teapath);
			q.setInteger(1, num);
			tst.commit();
		}
		session.close();
	}
	//更新一条信息
	public void update(Train_Teachers tt) throws HibernateException, Exception{
		Session session = null;
		session = HibernateSessionFactory.createFactory().openSession();
		Transaction tx = session.beginTransaction();
		Query q = session.createQuery("" +
				"update Train_Teachers tt set tt.teacher_name=?, tt.teacher_sex=?, tt.teacher_workplace=?,tt.teacher_inwork=?,"+
				"tt.teacher_university=?,  tt.teacher_major=?,"+
					"tt.teacher_professional=?,  tt.teacher_address=?,"+
					 "tt.teacher_email=?,  tt.teacher_profile=?,"+
					 "tt.teacher_phonenum=?, tt.teacher_path=? where tt.teacher_id =?");
		q.setString(0, tt.getTeacher_name());
		q.setString(1, tt.getTeacher_sex());
		q.setString(2, tt.getTeacher_workplace());
		q.setString(3, tt.getTeacher_inwork());
		q.setString(4,tt.getTeacher_university());
		q.setString(5, tt.getTeacher_major());
		q.setString(6, tt.getTeacher_professional());
		q.setString(7, tt.getTeacher_address());
		q.setString(8,tt.getTeacher_email());
		q.setString(9,tt.getTeacher_profile());
		q.setString(10,tt.getTeacher_phonenum());
		q.setString(11, tt.getTeacher_path());
		q.setInteger(12, tt.getTeacher_id());
		q.executeUpdate();
		tx.commit();
		session.close();	
	}
	
	//删除一条数据
	public void delete(int no) {
		Session session = null;
		try {
			session = HibernateSessionFactory.createFactory().openSession();
			Transaction tx = session.beginTransaction();
			Train_Teachers tt = (Train_Teachers) session.get(Train_Teachers.class,
					no);
			if (tt != null) {
				session.delete(tt);
			}
			tx.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			session.close();
		}
	}
	
	//删除一条数据，将照片也删除
	public void delTea(int num) throws HibernateException, Exception {
		Session session = HibernateSessionFactory.createFactory().openSession();
		Transaction tx = session.beginTransaction();
		String path = null;
		String hql = "from Train_Teachers tt where tt.teacher_id=?";
		Query query = session.createQuery(hql);
		query.setInteger(0, num);
		List<Train_Teachers> ttlist = query.list();
		Train_Teachers tr = ttlist.get(0);
		tx.commit();
		session.close();
		String picture = tr.getTeacher_path();
		path = ServletActionContext.getServletContext().getRealPath(
				"/upload/media/image")
				+ "\\" + picture;
		File wg = new File(path);
		if (wg.exists()) {
			wg.delete();
		}
		delete(num);
	}

	// 获取总得页数
	public int getTotalRows() throws HibernateException, Exception {
		int dataCount = 0;
		int pageCount;
		List ttlist = new ArrayList();
		Session session = HibernateSessionFactory.createFactory().openSession();
		Transaction tx = session.beginTransaction();
		Query q = session.createQuery("from Train_Teachers tt");
		ttlist = q.list();
		dataCount = ttlist.size();
		session.close();
		return dataCount;
	}

	// 获得一页列表
	public List<Train_Teachers> findByPage(String page,String rows)
			throws Exception {
		List ttlist = new ArrayList();
		Session session = null;
		Train_Teachers tt = new Train_Teachers();
		int currentpage = Integer.parseInt((page == null || page == "0") ? "1": page);  
	    int pagesize = Integer.parseInt((rows == null || rows == "0") ? "10": rows);
		try {
			 session = HibernateSessionFactory.createFactory()
					.openSession();
			Transaction tx = session.beginTransaction();
			Query q = session
					.createQuery("from Train_Teachers tt order by tt.teacher_id desc");
			q.setFirstResult(pagesize * (currentpage  - 1));
			q.setMaxResults(pagesize);
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

	// 获得一页列表
	public List<Train_Teachers> search(String name)
			throws Exception {
		List ttlist = new ArrayList();
		Session session = null;
		Train_Teachers tt = new Train_Teachers();
		try {
			 session = HibernateSessionFactory.createFactory()
					.openSession();
			Transaction tx = session.beginTransaction();
			Query q = session
					.createQuery("from Train_Teachers tt where tt.teacher_name like :?");
			q.setString(0, "%"+name+"%");
			
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
}


