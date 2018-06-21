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
import org.junit.Test;

import cn.nwsuaf.gov.model.Train_Resource;
import cn.nwsuaf.gov.model.Train_Teachers;

public class TrainResService {
	//删除原来重复的照片，在修改教师信息的时候才用此函数，在第一次发布的时候没有破
		
		public void deleteRes(int num,String respath,String fileclass) throws HibernateException, Exception {
			Session session = HibernateSessionFactory.createFactory().openSession();
			Transaction tx = session.beginTransaction();
			String path = null;
			String hql = "from Train_Resource tt where tt.resources_id=?";
			Query query = session.createQuery(hql);
			query.setInteger(0, num);
			List<Train_Resource> ttlist = query.list();
			Train_Resource tr = ttlist.get(0);
			tx.commit();
			String repath = tr.getResources_path();
			if(!repath.equals(respath)){
				if (fileclass.equals(".MP4")) {
					path = ServletActionContext.getServletContext().getRealPath(
							"/upload/media/sp")
							+ "\\" + repath;
					File sp = new File(path);
					if (sp.exists()) {
						sp.delete();
					}
				} else if (fileclass.equals(".MP3	")) {
					path = ServletActionContext.getServletContext().getRealPath(
							"/upload/media/gb")
							+ "\\" + repath;
					File gb = new File(path);
					if (gb.exists()) {
						gb.delete();
					}
				} else if (fileclass.equals(".PDF")) {
					path = ServletActionContext.getServletContext().getRealPath(
							"/upload/media/wg")
							+ "\\" + repath;
					File wg = new File(path);
					if (wg.exists()) {
						wg.delete();
					}
				}
			}
			session.close();
		}
		//更新一条信息
		public void update(Train_Resource tr) throws HibernateException, Exception{
			Session session = null;
			session = HibernateSessionFactory.createFactory().openSession();
			Transaction tx = session.beginTransaction();
			Query q = session.createQuery("" +
					"update Train_Resource tr set tr.resources_title=?, tr.resources_colum=?," +
					" tr.resources_author=?,tr.resources_from=?,"+
					"tr.resources_profile=?,tr.resources_time=?,tr.resources_path=? where tr.resources_id =?");
			q.setString(0, tr.getResources_title());
			q.setString(1, tr.getResources_colum());
			q.setString(2, tr.getResources_author());
			q.setString(3, tr.getResources_from());
			q.setString(4, tr.getResources_profile());
			q.setString(5, getTime());
			q.setString(6, tr.getResources_path());
			q.setInteger(7, tr.getResources_id());
			q.executeUpdate();
			tx.commit();
			session.close();	
		}
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
		@Test
		public void testtime(){
			System.out.println(getTime());
		}
		
		//删除一条数据
		public void delete(int no) {
			Session session = null;
			try {
				session = HibernateSessionFactory.createFactory().openSession();
				Transaction tx = session.beginTransaction();
				Train_Resource tt = (Train_Resource) session.get(Train_Resource.class,
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
		//删除一条数据，将资源也删除
		public void deleRes(int num) throws HibernateException, Exception {
			Session session = HibernateSessionFactory.createFactory().openSession();
			Transaction tx = session.beginTransaction();
			String path = null;
			String hql = "from Train_Resource tt where tt.resources_id=?";
			Query query = session.createQuery(hql);
			query.setInteger(0, num);
			List<Train_Resource> ttlist = query.list();
			Train_Resource tr = ttlist.get(0);
			tx.commit();
			session.close();
			String colum = tr.getResources_colum();
			if (colum.equals("sp")) {
				path = ServletActionContext.getServletContext().getRealPath(
						"/upload/media/sp")
						+ "\\" + tr.getResources_path();
				File sp = new File(path);
				if (sp.exists()) {
					sp.delete();
				}
			} else if (colum.equals("gb")) {
				path = ServletActionContext.getServletContext().getRealPath(
						"/upload/media/gb")
						+ "\\" + tr.getResources_path();
				File gb = new File(path);
				if (gb.exists()) {
					gb.delete();
				}
			} else if (colum.equals("wg")) {
				path = ServletActionContext.getServletContext().getRealPath(
						"/upload/media/wg")
						+ "\\" + tr.getResources_path();
				File wg = new File(path);
				if (wg.exists()) {
					wg.delete();
				}
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
			Query q = session.createQuery("from Train_Resource tt");
			ttlist = q.list();
			dataCount = ttlist.size();
			session.close();
			return dataCount;
		}

		// 获得一页列表
		public List<Train_Resource> findByPage(String page,String rows)
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
						.createQuery("from Train_Resource tr order by tr.resources_id desc");
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
		
		// 按名字查找
		public List<Train_Resource> search(String name)
				throws Exception {
			List<Train_Resource> ttlist = new ArrayList();
			Session session = null;
			Train_Teachers tt = new Train_Teachers();
			try {
				 session = HibernateSessionFactory.createFactory()
						.openSession();
				Transaction tx = session.beginTransaction();
				Query q = session
						.createQuery("from Train_Resource tr where tr.resources_title like:?");
				q.setString(0,"%"+name+"%");
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
