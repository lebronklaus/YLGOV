package cn.nwsuaf.gov.service;

import java.io.File;
import java.util.List;

import org.apache.struts2.ServletActionContext;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import cn.nwsuaf.gov.model.Train_Base;

public class BasDele extends TrainBaseBusinessWithHibernate {
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
				"../upload/media/baseimage")
				+ "\\" + picture1;
		path2 = ServletActionContext.getServletContext().getRealPath(
				"../upload/media/baseimage")
				+ "\\" + picture2;
		File pc1 = new File(path1);
		if (pc1.exists()) {
			pc1.delete();
		}
		File pc2 = new File(path2);
		if (pc2.exists()) {
			pc2.delete();
		}
		delete(num);
	}
}
