package cn.nwsuaf.gov.DAO;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import cn.nwsuaf.gov.bean.JiShuPeiXun;
import cn.nwsuaf.gov.bean.PeiXunXuQiu;
import cn.nwsuaf.gov.bean.RenCaiXuQiu;
import cn.nwsuaf.gov.service.HibernateSessionFactory;

public class JishuService {
	//更新shenhe栏位
		public String update(int id ){
			Session session = null;
			try {
				session = HibernateSessionFactory.createFactory().openSession();
				Transaction tx = session.beginTransaction();
				Query q = session
						.createQuery("update JiShuPeiXun t set t.shenhe = 1 where id = ?");
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
		public String delJi(int id){
			Session session = null;
			try {
				session = HibernateSessionFactory.createFactory().openSession();
				Transaction tx = session.beginTransaction();
				JiShuPeiXun js = (JiShuPeiXun) session.get(JiShuPeiXun.class,id);
				if (js != null) {
					session.delete(js);
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
			Query q = session.createQuery("from JiShuPeiXun rc");
			ttlist = q.list();
			dataCount = ttlist.size();
			session.close();
			return dataCount;
		}

		// 获得一页列表
		public List<JiShuPeiXun> findByPage(String page,String rows)
				throws Exception {
			List<JiShuPeiXun> ttlist = new ArrayList();
			Session session = null;
			JiShuPeiXun tt = new JiShuPeiXun();
			int currentpage = Integer.parseInt((page == null || page == "0") ? "1": page);
		    int pagesize = Integer.parseInt((rows == null || rows == "0") ? "10": rows);
			try {
				 session = HibernateSessionFactory.createFactory()
						.openSession();
				Transaction tx = session.beginTransaction();
				Query q = session
						.createQuery("from JiShuPeiXun js order by js.id desc");
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
		// 按名称查找
	public List<JiShuPeiXun> search(String name) throws Exception {
		List<JiShuPeiXun> ttlist = new ArrayList();
		Session session = null;
		JiShuPeiXun tt = new JiShuPeiXun();
		try {
			session = HibernateSessionFactory.createFactory().openSession();
			Transaction tx = session.beginTransaction();
			Query q = session
					.createQuery("from JiShuPeiXun js where js.mingcheng like:?");
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
