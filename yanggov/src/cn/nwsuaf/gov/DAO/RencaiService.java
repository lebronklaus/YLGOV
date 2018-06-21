package cn.nwsuaf.gov.DAO;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import cn.nwsuaf.gov.bean.PeiXunXuQiu;
import cn.nwsuaf.gov.bean.RenCaiXuQiu;
import cn.nwsuaf.gov.service.HibernateSessionFactory;

public class RencaiService {
	//更新shenhe栏位
		public String update(int id ){
			Session session = null;
			try {
				session = HibernateSessionFactory.createFactory().openSession();
				Transaction tx = session.beginTransaction();
				Query q = session
						.createQuery("update RenCaiXuQiu t set t.shenhe = 1 where id = ?");
				q.setInteger(0, id);
				q.executeUpdate();
				tx.commit();
			} catch (HibernateException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}finally{
				session.close();
			}
			return "success";
		}
		public String delRen(int id){
			Session session = null;
			try {
				session = HibernateSessionFactory.createFactory().openSession();
				Transaction tx = session.beginTransaction();
				RenCaiXuQiu rc = (RenCaiXuQiu) session.get(RenCaiXuQiu.class,id);
				if (rc != null) {
					session.delete(rc);
				}
				tx.commit();
			} catch (HibernateException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}finally{
				session.close();
			}
			return "success";
		}
		// 获取总得页数
		public int getTotalRows() throws HibernateException, Exception {
			int dataCount = 0;
			int pageCount;

			List ttlist = new ArrayList();
			Session session = HibernateSessionFactory.createFactory().openSession();
			Transaction tx = session.beginTransaction();
			Query q = session.createQuery("from RenCaiXuQiu rc");
			ttlist = q.list();
			dataCount = ttlist.size();
			session.close();
			return dataCount;
		}

		// 获得一页列表
	public List<RenCaiXuQiu> findByPage(String page, String rows)
			throws Exception {
		List ttlist = new ArrayList();
		Session session = null;
		RenCaiXuQiu tt = new RenCaiXuQiu();
		int currentpage = Integer.parseInt((page == null || page == "0") ? "1"
				: page);
		int pagesize = Integer.parseInt((rows == null || rows == "0") ? "10"
				: rows);
		try {
			session = HibernateSessionFactory.createFactory().openSession();
			Transaction tx = session.beginTransaction();
			Query q = session
					.createQuery("from RenCaiXuQiu rc order by rc.id desc");
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
	public List<RenCaiXuQiu> search(String name)
			throws Exception {
		List<RenCaiXuQiu> ttlist = new ArrayList();
		Session session = null;
		RenCaiXuQiu tt = new RenCaiXuQiu();
		try {
			session = HibernateSessionFactory.createFactory().openSession();
			Transaction tx = session.beginTransaction();
			Query q = session
					.createQuery("from RenCaiXuQiu rc where rc.gangwei like:?");
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
