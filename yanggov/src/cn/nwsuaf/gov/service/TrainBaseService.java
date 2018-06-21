package cn.nwsuaf.gov.service;

import java.io.File;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.apache.struts2.ServletActionContext;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import cn.nwsuaf.gov.model.Train_Base;
import cn.nwsuaf.gov.model.Train_Teachers;

public class TrainBaseService {
	
	//删除照片，只要与原来的不一样就删除掉。
	public void deleImage1(int num, String path) throws HibernateException, Exception {
		Session session = HibernateSessionFactory.createFactory().openSession();
		Transaction tx = session.beginTransaction();
		String path1 = null;
		String hql = "from Train_Base tt where tt.base_id=?";
		Query query = session.createQuery(hql);
		query.setInteger(0, num);
		List<Train_Base> ttlist = query.list();
		Train_Base tr = ttlist.get(0);
		String picture1 = tr.getBase_path1();
		tx.commit();

		if(!path.equals(picture1)){
			path1 = ServletActionContext.getServletContext().getRealPath(
					"/upload/media/baseimage")
					+ "\\" + picture1;
		
			File pc1 = new File(path1);
			if (pc1.exists()) {
				pc1.delete();
			}
			Transaction tst = session.beginTransaction();
			Query q = session.createQuery("" +
					"update Train_Base tb set tb.base_path1=? where tb.base_id =?");
			q.setString(0, path);
			q.setInteger(1, num);
			q.executeUpdate();
			tst.commit();
		}
		session.close();
	}
	public void deleImage2(int num, String path) throws HibernateException, Exception {
		Session session = HibernateSessionFactory.createFactory().openSession();
		Transaction tx = session.beginTransaction();
		String path1 = null;
		String hql = "from Train_Base tt where tt.base_id=?";
		Query query = session.createQuery(hql);
		query.setInteger(0, num);
		List<Train_Base> ttlist = query.list();
		Train_Base tr = ttlist.get(0);
		String picture2 = tr.getBase_path2();
		tx.commit();

		if(!path.equals(picture2)){
			path1 = ServletActionContext.getServletContext().getRealPath(
					"/upload/media/baseimage")
					+ "\\" + picture2;
		
			File pc1 = new File(path1);
			if (pc1.exists()) {
				pc1.delete();
			}
			Transaction tst = session.beginTransaction();
			Query q = session.createQuery("" +
					"update Train_Base tb set tb.base_path2=? where tb.base_id =?");
			q.setString(0, path);
			q.setInteger(1, num);
			q.executeUpdate();
			tst.commit();
		}
		session.close();
	}
	
	
	//获取当前时间
	/*public String getTime() {
		Calendar ca = Calendar.getInstance();
		int year = ca.get(Calendar.YEAR);
		int month = ca.get(Calendar.MONTH) + 1;
		int day = ca.get(Calendar.DATE);
		String str3 = Integer.toString(year) + "-" + Integer.toString(month)
				+ "-" + Integer.toString(day);
		return str3;
	}*/
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
	
	
	//更新一条数据
	public void update(Train_Base tb) throws HibernateException, Exception{
		Session session = null;
		session = HibernateSessionFactory.createFactory().openSession();
		Transaction tx = session.beginTransaction();
		Query q = session.createQuery("" +
				"update Train_Base tb set tb.base_name=?, tb.base_profile=?, tb.base_contact=?,tb.base_time=?,"+
				"tb.base_path1=?,  tb.base_path2=?where tb.base_id =?");
		q.setString(0, tb.getBase_name());
		q.setString(1, tb.getBase_profile());
		q.setString(2, tb.getBase_contact());
		q.setString(3, getTime());
		q.setString(4, tb.getBase_path1());
		q.setString(5, tb.getBase_path2());
		q.setInteger(6, tb.getBase_id());
		
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
			Train_Base tb = (Train_Base) session.get(Train_Base.class,no);
			if (tb != null) {
				session.delete(tb);
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
	public void deleBse(int num) throws HibernateException, Exception {
		Session session = HibernateSessionFactory.createFactory().openSession();
		Transaction tx = session.beginTransaction();
		String path1 = null;
		String path2 = null;
		String hql = "from Train_Base tt where tt.base_id=?";
		Query query = session.createQuery(hql);
		query.setInteger(0, num);
		List<Train_Base> ttlist = query.list();
		Train_Base tr = ttlist.get(0);
		String picture1 = tr.getBase_path1();
		String picture2 = tr.getBase_path2();
		tx.commit();
		session.close();
		path1 = ServletActionContext.getServletContext().getRealPath(
				"/upload/media/baseimage")
				+ "\\" + picture1;
		path2 = ServletActionContext.getServletContext().getRealPath(
				"/upload/media/baseimage")
				+ "\\" + picture2;
		File pc1 = new File(path1);
		if (pc1.exists()) {
			pc1.delete();
		}
		File pc2 = new File(path2);
		if (pc2.exists()) {
			pc2.delete();
		}
	}

	// 获取总得页数
	public int getTotalRows() throws HibernateException, Exception {
		int dataCount = 0;
		int pageCount;
		List tblist = new ArrayList();
		Session session = HibernateSessionFactory.createFactory().openSession();
		Transaction tx = session.beginTransaction();
		Query q = session.createQuery("from Train_Base tb");
		tblist = q.list();
		dataCount = tblist.size();
		session.close();
		return dataCount;
	}

	// 获得一页列表
	public List<Train_Base> findByPage(String page,String rows)throws Exception {
		List ttlist = new ArrayList();
		Session session = null;
		Train_Base tb = new Train_Base();
		int currentpage = Integer.parseInt((page == null || page == "0") ? "1": page);
	    int pagesize = Integer.parseInt((rows == null || rows == "0") ? "10": rows);
		try {
			 session = HibernateSessionFactory.createFactory()
					.openSession();
			Transaction tx = session.beginTransaction();
			Query q = session.createQuery("from Train_Base tb order by tb.base_id desc");
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
		public List<Train_Base> search(String name)throws Exception {
			List<Train_Base> ttlist = new ArrayList();
			Session session = null;
			Train_Base tb = new Train_Base();
			try {
				 session = HibernateSessionFactory.createFactory()
						.openSession();
				Transaction tx = session.beginTransaction();
				Query q = session.createQuery("from Train_Base tb where tb.base_name like:?");
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
