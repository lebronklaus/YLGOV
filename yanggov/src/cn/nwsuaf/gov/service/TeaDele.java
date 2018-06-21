package cn.nwsuaf.gov.service;

import java.io.File;
import java.util.List;

import org.apache.struts2.ServletActionContext;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import cn.nwsuaf.gov.model.Train_Teachers;

public class TeaDele extends TrainTeachersBusinessWithHibernate {
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
				"../upload/media/image")
				+ "\\" + picture;
		File wg = new File(path);
		if (wg.exists()) {
			wg.delete();
		}

		delete(num);
	}

}
