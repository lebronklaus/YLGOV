package cn.nwsuaf.gov.service;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import cn.nwsuaf.gov.model.Train_Teachers;

public class TrainTeachersBusinessWithHibernate implements
		TrainTeachersBusiness {

	@Override
	public void add(String teacher_name, String teacher_sex,
			String teacher_workplace, String teacher_inwork,
			String teacher_university, String teacher_major,
			String teacher_professional, String teacher_address,
			String teacher_email, String teacher_profile,
			String teacher_phonenum, String teacher_path)
			 {
		Session session = null;
		try {
			session = HibernateSessionFactory.createFactory().openSession();
			Transaction tx = session.beginTransaction();
			Train_Teachers tt = new Train_Teachers();

			tt.setTeacher_name(teacher_name);
			if (teacher_sex.equals("male")) {
				tt.setTeacher_sex("男");
			} else {
				tt.setTeacher_sex("女");
			}

			tt.setTeacher_workplace(teacher_workplace);
			if (teacher_inwork.equals("yes")) {
				tt.setTeacher_inwork("是");
			} else {
				tt.setTeacher_inwork("否");
			}

			tt.setTeacher_university(teacher_university);
			tt.setTeacher_major(teacher_major);
			tt.setTeacher_professional(teacher_professional);
			tt.setTeacher_address(teacher_address);
			tt.setTeacher_email(teacher_email);
			tt.setTeacher_profile(teacher_profile);
			tt.setTeacher_phonenum(teacher_phonenum);
			tt.setTeacher_path(teacher_path);
			session.save(tt);
			tx.commit();
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			session.close();
		}
	
		

	}

	@Override
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
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			session.close();
		}
		
		

	}

	@Override
	public List<Train_Teachers> getList(){
		Session session = null;
		List<Train_Teachers> ttlist = null;
		try {
			session = HibernateSessionFactory.createFactory().openSession();
			Transaction tx = session.beginTransaction();
			String hql = "from Train_Teachers tt order by tt.teacher_id desc";
			Query query = session.createQuery(hql);
			ttlist = query.list();
			tx.commit();
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			session.close();
		}
		
		return ttlist;
	}

	@Override
	public Train_Teachers getTrainTeacher(int no) throws Exception {
		Session session = HibernateSessionFactory.createFactory().openSession();
		Transaction tx = session.beginTransaction();
		Train_Teachers tt = (Train_Teachers) session.get(Train_Teachers.class,
				no);
		session.close();
		return tt;
	}

	// 获取总得页数
	@Override
	@Test
	public int getTotalRows(int pageSize) throws HibernateException, Exception {
		int dataCount = 0;
		int pageCount;

		List ttlist = new ArrayList();
		Session session = HibernateSessionFactory.createFactory().openSession();
		Transaction tx = session.beginTransaction();
		Query q = session.createQuery("from Train_Teachers tt");
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

	// 获得一页列表
	@Override
	public List<Train_Teachers> findByPage(int pageSize, int pageNow)
			throws Exception {
		List ttlist = new ArrayList();
		Session session = null;
		Train_Teachers tt = new Train_Teachers();
		try {
			 session = HibernateSessionFactory.createFactory()
					.openSession();
			Transaction tx = session.beginTransaction();
			Query q = session
					.createQuery("from Train_Teachers tt order by tt.teacher_id desc");
			q.setFirstResult(pageSize * (pageNow - 1));
			q.setMaxResults(pageSize);
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
