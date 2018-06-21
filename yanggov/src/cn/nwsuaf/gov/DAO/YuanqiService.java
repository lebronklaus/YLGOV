package cn.nwsuaf.gov.DAO;

import java.io.File;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.apache.struts2.ServletActionContext;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import cn.nwsuaf.gov.bean.Xinxi;
import cn.nwsuaf.gov.model.Train_Base;
import cn.nwsuaf.gov.model.Train_Teachers;
import cn.nwsuaf.gov.service.HibernateSessionFactory;

public class YuanqiService {
	
	//更新一条数据
	public void update(int id ) throws HibernateException, Exception{
		Session session = null;
		session = HibernateSessionFactory.createFactory().openSession();
		Transaction tx = session.beginTransaction();
		Query q = session
				.createQuery("update Xinxi t set t.shenhe = 1 where id = ?");
		q.setInteger(0, id);
		
		q.executeUpdate();
		tx.commit();
		session.close();	
	}
	
	//删除一条数据
	public void deleYuanqi(int no) {
		Session session = null;
		try {
			session = HibernateSessionFactory.createFactory().openSession();
			Transaction tx = session.beginTransaction();
			Xinxi xx = (Xinxi) session.get(Xinxi.class,no);
			if (xx != null) {
				session.delete(xx);
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
	public void deleYuanQi(int num) throws HibernateException, Exception {
		Session session = HibernateSessionFactory.createFactory().openSession();
		Transaction tx = session.beginTransaction();
		String path1 = null;
		String path2 = null;
		String hql = "from Xinxi xx where xx.id=?";
		Query query = session.createQuery(hql);
		query.setInteger(0, num);
		List<Xinxi> ttlist = query.list();
		Xinxi xx = ttlist.get(0);
		String picture1 = xx.getPath1();
		String picture2 = xx.getPath2();
		tx.commit();
		session.close();
		path1 = ServletActionContext.getServletContext().getRealPath(
				"/upload/media/yuanqiimage")
				+ "\\" + picture1;
		path2 = ServletActionContext.getServletContext().getRealPath(
				"/upload/media/yuanqiimage")
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
		Query q = session.createQuery("from Xinxi xx");
		tblist = q.list();
		dataCount = tblist.size();
		session.close();
		return dataCount;
	}

	// 获得一页列表
	public List<Xinxi> findByPage(String page, String rows) throws Exception {
		List ttlist = new ArrayList();
		Session session = null;
		Xinxi tb = new Xinxi();
		int currentpage = Integer.parseInt((page == null || page == "0") ? "1"
				: page);// 第几页
		int pagesize = Integer.parseInt((rows == null || rows == "0") ? "10"
				: rows);// 每页多少行
		try {
			session = HibernateSessionFactory.createFactory().openSession();
			Transaction tx = session.beginTransaction();
			Query q = session.createQuery("from Xinxi xx order by xx.id desc");
			q.setFirstResult(pagesize * (currentpage - 1));
			q.setMaxResults(pagesize);
			ttlist = q.list();
			session.getTransaction().commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			System.out.println("查询失败");
		} finally {
			session.close();
		}
		return ttlist;
	}
	
	// 按照名字查找
		public List<Xinxi> search(String name) throws Exception {
			List<Xinxi> ttlist = new ArrayList();
			Session session = null;
			Xinxi tb = new Xinxi();
			try {
				session = HibernateSessionFactory.createFactory().openSession();
				Transaction tx = session.beginTransaction();
				Query q = session.createQuery("from Xinxi xx where xx.name like:?");
				q.setString(0, "%"+name+"%");
				ttlist = q.list();
				session.getTransaction().commit();
			} catch (HibernateException e) {
				e.printStackTrace();
				System.out.println("查询失败");
			} finally {
				session.close();
			}
			return ttlist;
		}
}
