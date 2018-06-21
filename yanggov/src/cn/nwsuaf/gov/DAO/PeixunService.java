package cn.nwsuaf.gov.DAO;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import cn.nwsuaf.gov.bean.JiShuPeiXun;
import cn.nwsuaf.gov.bean.PeiXunXuQiu;
import cn.nwsuaf.gov.model.Train_Resource;
import cn.nwsuaf.gov.model.Train_Teachers;
import cn.nwsuaf.gov.service.HibernateSessionFactory;

public class PeixunService {
	//更新shenhe栏位
	public String update(int id ){
		Session session = null;
		try {
			session = HibernateSessionFactory.createFactory().openSession();
			Transaction tx = session.beginTransaction();
			Query q = session
					.createQuery("update PeiXunXuQiu t set t.shenhe = 1 where id = ?");
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
	public String delPei(int id){
		Session session = null;
		try {
			session = HibernateSessionFactory.createFactory().openSession();
			Transaction tx = session.beginTransaction();
			PeiXunXuQiu px = (PeiXunXuQiu) session.get(PeiXunXuQiu.class,id);
			if (px != null) {
				session.delete(px);
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
		Query q = session.createQuery("from PeiXunXuQiu px");
		ttlist = q.list();
		dataCount = ttlist.size();
		session.close();
		return dataCount;
	}

	// 获得一页列表
	public List<PeiXunXuQiu> findByPage(String page,String rows)
			throws Exception {
		List ttlist = new ArrayList();
		Session session = null;
		PeiXunXuQiu tt = new PeiXunXuQiu();
		int currentpage = Integer.parseInt((page == null || page == "0") ? "1": page);//第几页
	    int pagesize = Integer.parseInt((rows == null || rows == "0") ? "10": rows);//每页多少行 
		try {
			 session = HibernateSessionFactory.createFactory()
					.openSession();
			Transaction tx = session.beginTransaction();
			Query q = session
					.createQuery("from PeiXunXuQiu px order by px.id desc");
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
		public List<PeiXunXuQiu> search(String name)
				throws Exception {
			List<PeiXunXuQiu> ttlist = new ArrayList();
			Session session = null;
			PeiXunXuQiu tt = new PeiXunXuQiu();
			try {
				 session = HibernateSessionFactory.createFactory()
						.openSession();
				Transaction tx = session.beginTransaction();
				Query q = session
						.createQuery("from PeiXunXuQiu px where px.companyname like:?");
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
