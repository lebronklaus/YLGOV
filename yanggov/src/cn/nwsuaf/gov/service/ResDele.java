package cn.nwsuaf.gov.service;

import java.io.File;
import java.util.List;

import org.apache.struts2.ServletActionContext;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import cn.nwsuaf.gov.model.Train_Resource;

public class ResDele extends TraintrainResourceBusinessWithHibernate {
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
					"../upload/media/sp")
					+ "\\" + tr.getResources_path();
			File sp = new File(path);
			if (sp.exists()) {
				sp.delete();
			}
		} else if (colum.equals("gb")) {
			path = ServletActionContext.getServletContext().getRealPath(
					"../upload/media/gb")
					+ "\\" + tr.getResources_path();
			File gb = new File(path);
			if (gb.exists()) {
				gb.delete();
			}
		} else if (colum.equals("wg")) {
			path = ServletActionContext.getServletContext().getRealPath(
					"../upload/media/wg")
					+ "\\" + tr.getResources_path();
			File wg = new File(path);
			if (wg.exists()) {
				wg.delete();
			}
		}
		delete(num);
	}
}
